package moe.ono.hooks.item.chat

import android.annotation.SuppressLint
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord
import de.robv.android.xposed.XC_MethodHook.MethodHookParam
import moe.ono.R
import moe.ono.bridge.Nt_kernel_bridge
import moe.ono.bridge.kernelcompat.ContactCompat
import moe.ono.bridge.ntapi.MsgConstants
import moe.ono.bridge.ntapi.MsgServiceHelper
import moe.ono.builder.MsgBuilder
import moe.ono.hooks._base.BaseSwitchFunctionHookItem
import moe.ono.hooks._core.annotation.HookItem
import moe.ono.hooks._core.factory.HookItemFactory.getItem
import moe.ono.hooks.base.util.Toasts
import moe.ono.hooks.dispatcher.OnMenuBuilder
import moe.ono.reflex.Reflex
import moe.ono.util.AppRuntimeHelper
import moe.ono.util.ContextUtils
import moe.ono.util.CustomMenu
import moe.ono.util.Logger
import moe.ono.util.Session
import moe.ono.util.SyncUtils

/**
 * 复读机（长按消息）
 *
 * 长按任意一条消息 -> 菜单里多出一个「复读」按钮，
 * 点击后把该消息里的文本内容重新发回当前会话。
 *
 * 元素处理策略：
 *  - 文本 / 富文本里的文本元素：原样拼接
 *  - 系统表情 / 商城表情：转成占位符 [表情]
 *  - 图片 / 语音 / 文件 / 视频：转成占位符，不重传资源
 *  - 其它元素（Ark、合并转发、回复引用等）：忽略
 */
@SuppressLint("DiscouragedApi")
@HookItem(
    path = "聊天与消息/复读机",
    description = "长按消息菜单里新增「复读」，把原消息的文本内容重新发一遍\n" +
            "* 图片/语音/文件等非文本元素用占位符代替，不会重传资源\n" +
            "* 需配合「聊天与消息/快捷菜单」或直接在消息长按菜单中使用"
)
class RepeatMessage : BaseSwitchFunctionHookItem(), OnMenuBuilder {

    override fun entry(classLoader: ClassLoader) {}

    override fun onGetMenu(aioMsgItem: Any, targetType: String, param: MethodHookParam) {
        if (!getItem(this.javaClass).isEnabled) {
            return
        }

        val item: Any = CustomMenu.createItemIconNt(
            aioMsgItem,
            "复读",
            R.drawable.ic_twotone_message_24,
            R.id.item_repeat_message
        ) {
            try {
                repeatMessage(aioMsgItem)
            } catch (e: Exception) {
                Logger.e("RepeatMessage.onGetMenu", e)
            }
            Unit
        }

        param.result = listOf(item) + param.result as List<*>
    }

    /**
     * 取到原消息记录，抽取文本，再发一次
     */
    private fun repeatMessage(aioMsgItem: Any) {
        val contact: ContactCompat = Session.getContact() ?: return
        val msgId = Reflex.invokeVirtual(aioMsgItem, "getMsgId") as Long

        val msgIds = ArrayList<Long>(1)
        msgIds.add(msgId)

        val service = AppRuntimeHelper.getAppRuntime()
            ?.let { MsgServiceHelper.getKernelMsgService(it) }
            ?: return

        service.getMsgsByMsgId(contact, msgIds) { result, errMsg, msgList ->
            if (result != 0 || msgList.isNullOrEmpty()) {
                Logger.e("RepeatMessage: getMsgsByMsgId failed, result=$result, errMsg=$errMsg")
                toast("复读失败：取不到原消息")
                return@getMsgsByMsgId
            }

            val record: MsgRecord = msgList[0]
            val body = extractText(record)

            if (body.isEmpty()) {
                toast("这条消息没有可复读的文本")
                return@getMsgsByMsgId
            }

            val payload = ArrayList<MsgElement>(1)
            payload.add(MsgBuilder.nt_build_text(body))
            Nt_kernel_bridge.send_msg(contact, payload)

            Logger.d("RepeatMessage: peer=${record.peerUid} seq=${record.msgSeq} body=$body")
        }
    }

    /**
     * 把 MsgRecord 里的元素列表压成一段可发送的纯文本
     */
    private fun extractText(record: MsgRecord): String {
        val sb = StringBuilder()
        val elements: List<MsgElement>? = record.elements

        elements?.forEach { element ->
            when (element.elementType) {
                MsgConstants.ELEM_TYPE_TEXT -> sb.append(element.textElement?.content.orEmpty())
                MsgConstants.ELEM_TYPE_FACE,
                MsgConstants.ELEM_TYPE_MARKET_FACE -> sb.append("[表情]")

                MsgConstants.ELEM_TYPE_PIC -> sb.append("[图片]")
                MsgConstants.ELEM_TYPE_PTT -> sb.append("[语音]")
                MsgConstants.ELEM_TYPE_VIDEO -> sb.append("[视频]")
                MsgConstants.ELEM_TYPE_FILE,
                MsgConstants.ELEM_TYPE_ONLINE_FILE -> sb.append("[文件]")

                MsgConstants.ELEM_TYPE_ARK_STRUCT -> sb.append("[卡片]")
                MsgConstants.ELEM_TYPE_MULTI_FORWARD -> sb.append("[合并转发]")

                else -> Unit
            }
        }

        return sb.toString().trim()
    }

    private fun toast(text: String) {
        val activity = ContextUtils.getCurrentActivity() ?: return
        SyncUtils.runOnUiThread { Toasts.info(activity, text) }
    }
}
