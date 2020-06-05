package com.p368pw.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.p369a.C4897d;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.pw.view.InterstitialActivity */
public class InterstitialActivity extends Activity {
    private static final Map<String, InterstitialActivity> CACHE_ACTIVITYS = new HashMap();
    public static final String DATA = "ins_data";
    public static final String EXTRA_IACTIVITY_CLASS_NAME = "win_extra_iactivity_class_name";
    public static final String EXTRA_IACTIVITY_KEY = "win_extra_iactivity_key";
    private static final Map<String, C4897d> IACTIVITY_MAP = new ConcurrentHashMap();
    private String className;
    private C4897d iActivity;

    private static void add(String str, InterstitialActivity interstitialActivity) {
        if (!TextUtils.isEmpty(str) && interstitialActivity != null) {
            CACHE_ACTIVITYS.put(str, interstitialActivity);
        }
    }

    public static void finish(String str) {
        InterstitialActivity interstitialActivity = (InterstitialActivity) CACHE_ACTIVITYS.remove(str);
        if (interstitialActivity != null) {
            interstitialActivity.finish();
        }
    }

    public static Intent getIntent(Context context, Class<? extends C4897d> cls) {
        return getIntent(context, cls, null);
    }

    public static Intent getIntent(Context context, Class<? extends C4897d> cls, C4897d dVar) {
        if (context == null || cls == null) {
            return null;
        }
        Intent intent = new Intent(context, InterstitialActivity.class);
        intent.putExtra(EXTRA_IACTIVITY_CLASS_NAME, cls.getName());
        intent.addFlags(268435456);
        if (dVar != null) {
            String uuid = UUID.randomUUID().toString();
            IACTIVITY_MAP.put(uuid, dVar);
            intent.putExtra(EXTRA_IACTIVITY_KEY, uuid);
        }
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            super.onActivityResult(i, i2, intent);
            this.iActivity.mo25987a(i, i2, intent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            this.iActivity.mo26009e();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onBackPressed() {
        try {
            if (!this.iActivity.mo25900c()) {
                super.onBackPressed();
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        try {
            super.onChildTitleChanged(activity, charSequence);
            this.iActivity.mo25991a(activity, charSequence);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
            this.iActivity.mo25896a(configuration);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onContentChanged() {
        try {
            super.onContentChanged();
            this.iActivity.mo26011f();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        try {
            Boolean a = this.iActivity.mo25985a(menuItem);
            return a != null ? a.booleanValue() : super.onContextItemSelected(menuItem);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public void onContextMenuClosed(Menu menu) {
        try {
            super.onContextMenuClosed(menu);
            this.iActivity.mo25994a(menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        try {
            String string = getIntent().getExtras().getString(EXTRA_IACTIVITY_KEY);
            if (!TextUtils.isEmpty(string)) {
                this.iActivity = (C4897d) IACTIVITY_MAP.get(string);
                IACTIVITY_MAP.remove(string);
            }
            if (this.iActivity == null) {
                this.className = getIntent().getExtras().getString(EXTRA_IACTIVITY_CLASS_NAME);
                StringBuilder sb = new StringBuilder();
                sb.append("className:");
                sb.append(this.className);
                C5205o.m21462a(sb.toString());
                Constructor declaredConstructor = Class.forName(this.className).getDeclaredConstructor(new Class[]{Activity.class});
                declaredConstructor.setAccessible(true);
                this.iActivity = (C4897d) declaredConstructor.newInstance(new Object[]{this});
            }
            this.iActivity.mo25990a((Activity) this);
            this.iActivity.mo25897a(bundle);
            super.onCreate(bundle);
            this.iActivity.mo25899b(bundle);
            add(this.className, this);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            finish();
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        try {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            this.iActivity.mo25993a(contextMenu, view, contextMenuInfo);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public CharSequence onCreateDescription() {
        try {
            CharSequence g = this.iActivity.mo26012g();
            return g != null ? g : super.onCreateDescription();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i) {
        try {
            Dialog a = this.iActivity.mo25976a(i);
            return a != null ? a : super.onCreateDialog(i);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i, Bundle bundle) {
        try {
            Dialog a = this.iActivity.mo25977a(i, bundle);
            return a != null ? a : super.onCreateDialog(i, bundle);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            Boolean b = this.iActivity.mo26000b(menu);
            return b != null ? b.booleanValue() : super.onCreateOptionsMenu(menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return true;
        }
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        try {
            Boolean a = this.iActivity.mo25981a(i, menu);
            return a != null ? a.booleanValue() : super.onCreatePanelMenu(i, menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public View onCreatePanelView(int i) {
        try {
            View b = this.iActivity.mo25997b(i);
            return b != null ? b : super.onCreatePanelView(i);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        try {
            Boolean a = this.iActivity.mo25984a(bitmap, canvas);
            return a != null ? a.booleanValue() : super.onCreateThumbnail(bitmap, canvas);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        try {
            View a = this.iActivity.mo25978a(str, context, attributeSet);
            return a != null ? a : super.onCreateView(str, context, attributeSet);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            this.iActivity.mo25898b();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
        super.onDestroy();
    }

    public void onDetachedFromWindow() {
        try {
            this.iActivity.mo26013h();
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            Boolean a = this.iActivity.mo25980a(i, keyEvent);
            return a != null ? a.booleanValue() : super.onKeyDown(i, keyEvent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return true;
        }
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        try {
            Boolean b = this.iActivity.mo25998b(i, keyEvent);
            return b != null ? b.booleanValue() : super.onKeyLongPress(i, keyEvent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        try {
            Boolean a = this.iActivity.mo25979a(i, i2, keyEvent);
            return a != null ? a.booleanValue() : super.onKeyMultiple(i, i2, keyEvent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            Boolean c = this.iActivity.mo26003c(i, keyEvent);
            return c != null ? c.booleanValue() : super.onKeyUp(i, keyEvent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public void onLowMemory() {
        try {
            super.onLowMemory();
            this.iActivity.mo26014i();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        try {
            Boolean a = this.iActivity.mo25982a(i, menuItem);
            return a != null ? a.booleanValue() : super.onMenuItemSelected(i, menuItem);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public boolean onMenuOpened(int i, Menu menu) {
        try {
            Boolean b = this.iActivity.mo25999b(i, menu);
            return b != null ? b.booleanValue() : super.onMenuOpened(i, menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        try {
            super.onNewIntent(intent);
            this.iActivity.mo25992a(intent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            Boolean b = this.iActivity.mo26001b(menuItem);
            return b != null ? b.booleanValue() : super.onOptionsItemSelected(menuItem);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public void onOptionsMenuClosed(Menu menu) {
        try {
            super.onOptionsMenuClosed(menu);
            this.iActivity.mo26006c(menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        try {
            this.iActivity.mo26004c(i, menu);
            super.onPanelClosed(i, menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            this.iActivity.mo25895a();
            super.onPause();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        try {
            super.onPostCreate(bundle);
            this.iActivity.mo26005c(bundle);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        try {
            this.iActivity.mo26015j();
            super.onPostResume();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialog(int i, Dialog dialog) {
        try {
            super.onPrepareDialog(i, dialog);
            this.iActivity.mo25988a(i, dialog);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialog(int i, Dialog dialog, Bundle bundle) {
        try {
            super.onPrepareDialog(i, dialog, bundle);
            this.iActivity.mo25989a(i, dialog, bundle);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            Boolean d = this.iActivity.mo26007d(menu);
            return d != null ? d.booleanValue() : super.onPrepareOptionsMenu(menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return true;
        }
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        try {
            Boolean a = this.iActivity.mo25983a(i, view, menu);
            return a != null ? a.booleanValue() : super.onPreparePanel(i, view, menu);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        try {
            super.onRestart();
            this.iActivity.mo26016k();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        try {
            super.onRestoreInstanceState(bundle);
            this.iActivity.mo26008d(bundle);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        try {
            super.onResume();
            this.iActivity.mo26017l();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public Object onRetainNonConfigurationInstance() {
        try {
            Object m = this.iActivity.mo26018m();
            return m != null ? m : super.onRetainNonConfigurationInstance();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            bundle.putString(EXTRA_IACTIVITY_CLASS_NAME, this.className);
            this.iActivity.mo26010e(bundle);
            super.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onSearchRequested() {
        try {
            Boolean n = this.iActivity.mo26019n();
            return n != null ? n.booleanValue() : super.onSearchRequested();
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        try {
            super.onStart();
            this.iActivity.mo26020o();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            this.iActivity.mo26021p();
            super.onStop();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i) {
        try {
            super.onTitleChanged(charSequence, i);
            this.iActivity.mo25995a(charSequence, i);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            Boolean a = this.iActivity.mo25986a(motionEvent);
            return a != null ? a.booleanValue() : super.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        try {
            Boolean b = this.iActivity.mo26002b(motionEvent);
            return b != null ? b.booleanValue() : super.onTrackballEvent(motionEvent);
        } catch (Throwable th) {
            C5205o.m21464a(th);
            return false;
        }
    }

    public void onUserInteraction() {
        try {
            super.onUserInteraction();
            this.iActivity.mo26022q();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* access modifiers changed from: protected */
    public void onUserLeaveHint() {
        try {
            super.onUserLeaveHint();
            this.iActivity.mo26023r();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
            this.iActivity.mo25996a(z);
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }
}
