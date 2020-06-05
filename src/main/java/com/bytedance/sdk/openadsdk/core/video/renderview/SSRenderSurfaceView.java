package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.bytedance.sdk.openadsdk.core.video.renderview.IRenderView.C2348a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class SSRenderSurfaceView extends SSSurfaceView implements Callback, IRenderView {
    /* renamed from: c */
    private static final ArrayList<WeakSurfaceCallback> f8221c = new ArrayList<>();
    /* renamed from: a */
    private WeakReference<IRenderCallback> f8222a;
    /* renamed from: b */
    private WeakSurfaceCallback f8223b;
    /* renamed from: d */
    private C2348a f8224d;

    public View getView() {
        return this;
    }

    public SSRenderSurfaceView(Context context) {
        super(context);
        m10722a();
    }

    /* renamed from: a */
    private void m10722a() {
        this.f8223b = new WeakSurfaceCallback(this);
        f8221c.add(this.f8223b);
    }

    /* renamed from: a */
    public void mo16216a(IRenderCallback aVar) {
        this.f8222a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator it = f8221c.iterator();
        while (it.hasNext()) {
            WeakSurfaceCallback cVar = (WeakSurfaceCallback) it.next();
            if (cVar.mo16235a() == null) {
                holder.removeCallback(cVar);
                it.remove();
            }
        }
        holder.addCallback(this.f8223b);
    }

    /* renamed from: a */
    public void mo16215a(int i, int i2) {
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<IRenderCallback> weakReference = this.f8222a;
        if (weakReference != null && weakReference.get() != null) {
            ((IRenderCallback) this.f8222a.get()).mo16179a(surfaceHolder);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<IRenderCallback> weakReference = this.f8222a;
        if (weakReference != null && weakReference.get() != null) {
            ((IRenderCallback) this.f8222a.get()).mo16180a(surfaceHolder, i, i2, i3);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<IRenderCallback> weakReference = this.f8222a;
        if (weakReference != null && weakReference.get() != null) {
            ((IRenderCallback) this.f8222a.get()).mo16189b(surfaceHolder);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        C2348a aVar = this.f8224d;
        if (aVar != null) {
            aVar.mo16234a(i);
        }
    }

    public void setWindowVisibilityChangedListener(C2348a aVar) {
        this.f8224d = aVar;
    }
}
