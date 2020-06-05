package p655io.openinstall;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.p235fm.openinstall.p238c.C2617a;
import com.p235fm.openinstall.p238c.C2618b;
import com.p235fm.openinstall.p239d.C2621b;
import java.util.Set;
import p655io.openinstall.p656a.C8070a;

/* renamed from: io.openinstall.a */
public class C8069a {
    /* renamed from: a */
    private C8070a f27372a;

    /* renamed from: a */
    private void m34901a(Uri uri, C2621b bVar) {
        if (C2618b.f9489a) {
            C2618b.m12720a("decodeWakeUp", new Object[0]);
        }
        this.f27372a.mo38815a(uri, bVar);
    }

    /* renamed from: a */
    public void mo38813a(C2621b bVar) {
        m34901a(null, bVar);
    }

    /* renamed from: a */
    public boolean mo38814a(Intent intent) {
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getBoolean("openinstall_intent", false)) {
                return false;
            }
            String string = extras.getString(C2617a.f9484a);
            if (C2617a.f9485b.equalsIgnoreCase(string) || C2617a.f9486c.equalsIgnoreCase(string)) {
                return true;
            }
        }
        String action = intent.getAction();
        Set categories = intent.getCategories();
        return action == null || categories == null || !action.equals("android.intent.action.MAIN") || !categories.contains("android.intent.category.LAUNCHER");
    }
}
