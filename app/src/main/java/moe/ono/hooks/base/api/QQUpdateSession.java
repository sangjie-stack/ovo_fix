package moe.ono.hooks.base.api;

import static moe.ono.constants.Constants.MethodCacheKey_AIOParam;
import static moe.ono.hooks._core.factory.HookItemFactory.getItem;
import static moe.ono.hooks.message.SessionUtils.AIOParam2Contact;

import android.os.Bundle;

import androidx.annotation.NonNull;

import moe.ono.bridge.kernelcompat.ContactCompat;
import moe.ono.config.ONOConf;
import moe.ono.dexkit.TargetManager;
import moe.ono.hooks._base.ApiHookItem;
import moe.ono.hooks._core.annotation.HookItem;
import moe.ono.hooks.item.chat.ChatScrollMemory;
import moe.ono.hooks.item.chat.QQBubbleRedirect;
import moe.ono.util.Logger;
import moe.ono.util.Session;

@HookItem(path = "API/获取Session")
public class QQUpdateSession extends ApiHookItem {

    private void update(ClassLoader classLoader) {
        hookBefore(TargetManager.requireMethod(MethodCacheKey_AIOParam), param -> {
            Logger.d("on QQUpdateSession");

            if (param.args == null || param.args.length == 0) {
                Logger.w("QQUpdateSession", "skip: args is empty");
                return;
            }

            if (!(param.args[0] instanceof Bundle)) {
                Logger.w("QQUpdateSession", "skip: arg0 is not Bundle");
                return;
            }

            Bundle bundle = (Bundle) param.args[0];
            Object cAIOParam = bundle.getParcelable("aio_param");
            if (cAIOParam == null) {
                Logger.w("QQUpdateSession", "skip: aio_param is null");
                return;
            }

            ContactCompat contact = AIOParam2Contact(cAIOParam);
            if (contact == null || contact.getPeerUid() == null || contact.getPeerUid().isEmpty()) {
                Logger.w("QQUpdateSession", "skip: contact is unavailable");
                return;
            }
            String cPeerUID = contact.getPeerUid();
            int cChatType = contact.getChatType();

            new Thread(() -> {
                int seq0 = ONOConf.getInt("ChatScrollMemory", cPeerUID, -1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int seq = ONOConf.getInt("ChatScrollMemory", cPeerUID, -1);
                Logger.d("seq: " + seq0 + "::" + seq);

                ChatScrollMemory.createGrayTip(seq0, seq, cPeerUID, cChatType);
            }).start();


            Session.setCurrentPeerID(cPeerUID);
            Session.setCurrentChatType(cChatType);
            // -------------------------------------------

            QQBubbleRedirect.invokeGetAioVasMsgData();

//            ChatScrollMemory.createGrayTip();
        });
    }

    @Override
    public void entry(@NonNull ClassLoader classLoader) throws Throwable {
        update(classLoader);
    }
}
