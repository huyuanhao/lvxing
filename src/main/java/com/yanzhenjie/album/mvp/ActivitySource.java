package com.yanzhenjie.album.mvp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.album.R;

/* renamed from: com.yanzhenjie.album.mvp.a */
class ActivitySource extends C7766d<Activity> {
    /* renamed from: a */
    private View f26332a;
    /* renamed from: b */
    private Toolbar f26333b;
    /* renamed from: c */
    private Drawable f26334c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public C7767a f26335d;

    ActivitySource(Activity activity) {
        super(activity);
        this.f26332a = activity.findViewById(16908290);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37681a() {
        mo37684a((Toolbar) ((Activity) mo37714f()).findViewById(R.id.toolbar));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37684a(Toolbar toolbar) {
        this.f26333b = toolbar;
        Activity activity = (Activity) mo37714f();
        if (this.f26333b != null) {
            mo37686a(activity.getTitle());
            this.f26333b.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (ActivitySource.this.f26335d != null) {
                        ActivitySource.this.f26335d.mo37713a(menuItem);
                    }
                    return true;
                }
            });
            this.f26333b.setNavigationOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ActivitySource.this.f26335d != null) {
                        ActivitySource.this.f26335d.mo37712a();
                    }
                }
            });
            this.f26334c = this.f26333b.getNavigationIcon();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public MenuInflater mo37687b() {
        return new SupportMenuInflater(mo37690d());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Menu mo37689c() {
        Toolbar toolbar = this.f26333b;
        if (toolbar == null) {
            return null;
        }
        return toolbar.getMenu();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37685a(C7767a aVar) {
        this.f26335d = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37682a(int i) {
        mo37683a(ContextCompat.getDrawable(mo37690d(), i));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37683a(Drawable drawable) {
        this.f26334c = drawable;
        Toolbar toolbar = this.f26333b;
        if (toolbar != null) {
            toolbar.setNavigationIcon(drawable);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: a */
    public final void mo37686a(CharSequence charSequence) {
        Toolbar toolbar = this.f26333b;
        if (toolbar != null) {
            toolbar.setTitle(charSequence);
        }
    }

    /* access modifiers changed from: final */
    /* renamed from: b */
    public final void mo37688b(CharSequence charSequence) {
        Toolbar toolbar = this.f26333b;
        if (toolbar != null) {
            toolbar.setSubtitle(charSequence);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Context mo37690d() {
        return (Context) mo37714f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo37691e() {
        Activity activity = (Activity) mo37714f();
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        }
    }
}
