package com.tencent.qqnt.kernel.msf;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public final class KernelServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a(DefaultConstructorMarker defaultConstructorMarker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
            IPatchRedirector iPatchRedirector2 = $redirector_;
            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }


    public KernelServlet() {
        throw new RuntimeException("Stub!");
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent intent, @Nullable FromServiceMsg fromServiceMsg) {
        throw new RuntimeException("Stub!");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent intent, @Nullable Packet packet) {
        throw new RuntimeException("Stub!");
    }

    @Override // mqq.app.MSFServlet
    protected void sendToMSF(@Nullable Intent intent, @Nullable ToServiceMsg toServiceMsg) {
        throw new RuntimeException("Stub!");
    }
}