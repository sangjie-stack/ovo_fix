package moe.ono.hooks.item.entertainment

import android.annotation.SuppressLint
import android.content.Context
import android.widget.EditText
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.tencent.qqnt.kernel.nativeinterface.MsgElement
import com.tencent.qqnt.kernel.nativeinterface.ShareLocationElement
import de.robv.android.xposed.XC_MethodHook.MethodHookParam
import moe.ono.R
import moe.ono.config.ConfigManager
import moe.ono.constants.Constants
import moe.ono.hooks._base.BaseSwitchFunctionHookItem
import moe.ono.hooks._core.annotation.HookItem
import moe.ono.hooks._core.factory.HookItemFactory.getItem
import moe.ono.hooks.base.api.QQSendMsgListener
import moe.ono.hooks.base.util.Toasts
import moe.ono.hooks.dispatcher.OnMenuBuilder
import moe.ono.ui.CommonContextWrapper
import moe.ono.util.ContextUtils
import moe.ono.util.CustomMenu
import moe.ono.util.Logger

@SuppressLint("DiscouragedApi")
@HookItem(
    path = "entertainment/modify_location_share_message",
    description = "Modify location share message text before it is sent"
)
class ModifyLocationShareMessage : BaseSwitchFunctionHookItem(), OnMenuBuilder {

    override val targetTypes = arrayOf(
        "com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent"
    )

    override fun entry(classLoader: ClassLoader) {
        QQSendMsgListener.listeners.add(::rewriteShareLocationMessage)

        runCatching {
            hookBefore(
                classLoader.loadClass("com.tencent.qqnt.kernel.nativeinterface.ShareLocationElement"),
                { param -> rewriteConstructorArgs(param) },
                String::class.java,
                String::class.java
            )
        }.onFailure {
            Logger.e(TAG, "failed to hook ShareLocationElement ctor: ${it.message}")
        }

        runCatching {
            val method = classLoader
                .loadClass("com.tencent.qqnt.kernel.nativeinterface.ShareLocationElement")
                .getDeclaredMethod("setText", String::class.java)
            hookBefore(method) { param ->
                val replacement = getReplacementText()
                if (shouldRewriteText(param.args[0] as? String, replacement)) {
                    param.args[0] = replacement
                    Logger.d(TAG, "rewrote ShareLocationElement.setText")
                }
            }
        }.onFailure {
            Logger.e(TAG, "failed to hook ShareLocationElement.setText: ${it.message}")
        }
    }

    private fun rewriteConstructorArgs(param: MethodHookParam) {
        val replacement = getReplacementText()
        if (!shouldRewriteText(param.args[0] as? String, replacement)) {
            return
        }
        param.args[0] = replacement
        Logger.d(TAG, "rewrote ShareLocationElement constructor")
    }

    private fun rewriteShareLocationMessage(
        param: de.robv.android.xposed.XC_MethodHook.MethodHookParam,
        elements: ArrayList<MsgElement>
    ) {
        val replacement = getReplacementText()
        if (replacement.isBlank()) {
            return
        }
        for (element in elements) {
            val shareLocationElement = element.shareLocationElement ?: continue
            rewriteShareLocationElement(shareLocationElement, replacement)
            element.shareLocationElement = shareLocationElement
        }
    }

    private fun rewriteShareLocationElement(
        shareLocationElement: ShareLocationElement,
        replacement: String
    ) {
        if (!shouldRewriteText(shareLocationElement.text, replacement)) {
            return
        }
        shareLocationElement.text = replacement
        Logger.d(TAG, "rewrote share location element before send")
    }

    private fun shouldRewriteText(currentText: String?, replacement: String): Boolean {
        if (!getItem(this.javaClass).isEnabled) {
            return false
        }
        if (replacement.isBlank()) {
            return false
        }
        if (currentText.isNullOrBlank()) {
            return true
        }
        return currentText.contains(DEFAULT_LOCATION_SHARE_TEXT) || currentText == replacement
    }

    override fun onGetMenu(aioMsgItem: Any, targetType: String, param: MethodHookParam) {
        if (!getItem(this.javaClass).isEnabled) {
            return
        }
        val item = CustomMenu.createItemIconNt(
            aioMsgItem,
            "modify text",
            R.drawable.ic_baseline_border_color_24,
            R.id.item_modify_location_share_message
        ) {
            val activity = ContextUtils.getCurrentActivity() ?: return@createItemIconNt Unit
            showConfigDialog(CommonContextWrapper.createAppCompatContext(activity))
            Unit
        }
        param.result = listOf(item) + param.result as List<*>
    }

    private fun showConfigDialog(context: Context) {
        val input = EditText(context).apply {
            hint = "input new location share text"
            setText(getReplacementText())
        }
        MaterialAlertDialogBuilder(context)
            .setTitle("modify location share text")
            .setView(input)
            .setNegativeButton("cancel", null)
            .setNeutralButton("reset") { _, _ ->
                ConfigManager.dPutString(CONFIG_KEY, "")
                Toasts.success(context, "reset to default")
            }
            .setPositiveButton("save") { _, _ ->
                ConfigManager.dPutString(CONFIG_KEY, input.text?.toString().orEmpty())
                Toasts.success(context, "saved")
            }
            .show()
    }

    private fun getReplacementText(): String {
        return ConfigManager.dGetString(CONFIG_KEY, "")
    }

    companion object {
        private const val CONFIG_KEY = Constants.PrekCfgXXX + "modify_location_share_message_text"
        private const val DEFAULT_LOCATION_SHARE_TEXT =
            "\u53d1\u8d77\u4e86\u4f4d\u7f6e\u5171\u4eab"
        private const val TAG = "ModifyLocationShare"
    }
}
