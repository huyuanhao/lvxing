package com.qiyukf.unicorn.api;

import android.app.Activity;
import android.app.Fragment;
import com.qiyukf.unicorn.p515i.C6200b;
import com.qiyukf.unicorn.p516j.C6218e;
import org.json.JSONObject;

public class QiyuTracker {
    public static void onBehavior(final Activity activity, final String str, final JSONObject jSONObject) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29392a(activity, (CharSequence) str, jSONObject);
                }
            }
        });
    }

    public static void onBehavior(final Fragment fragment, final String str, final JSONObject jSONObject) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29394a(fragment, (CharSequence) str, jSONObject);
                }
            }
        });
    }

    public static void onBehavior(final androidx.fragment.app.Fragment fragment, final String str, final JSONObject jSONObject) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29396a(fragment, (CharSequence) str, jSONObject);
                }
            }
        });
    }

    public static void onPause(final Activity activity) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29398b(activity);
                }
            }
        });
    }

    public static void onPause(final Activity activity, final CharSequence charSequence) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29399b(activity, charSequence);
                }
            }
        });
    }

    public static void onPause(final Fragment fragment, final CharSequence charSequence) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29400b(fragment, charSequence);
                }
            }
        });
    }

    public static void onPause(final androidx.fragment.app.Fragment fragment, final CharSequence charSequence) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29401b(fragment, charSequence);
                }
            }
        });
    }

    public static void onResume(final Activity activity) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29390a(activity);
                }
            }
        });
    }

    public static void onResume(final Activity activity, final CharSequence charSequence) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29391a(activity, charSequence);
                }
            }
        });
    }

    public static void onResume(final Fragment fragment, final CharSequence charSequence) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29393a(fragment, charSequence);
                }
            }
        });
    }

    public static void onResume(final androidx.fragment.app.Fragment fragment, final CharSequence charSequence) {
        C6218e.m24651a(new Runnable() {
            public final void run() {
                if (Unicorn.isInit()) {
                    C6200b.m24602a().mo29395a(fragment, charSequence);
                }
            }
        });
    }
}
