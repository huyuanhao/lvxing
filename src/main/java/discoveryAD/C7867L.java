package discoveryAD;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.qqpim.discovery.AdDisplayModel;
import com.tencent.qqpim.discovery.internal.model.ClickDataModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* renamed from: discoveryAD.L */
public class C7867L implements OnClickListener, C7871M {
    /* renamed from: Ad */
    private static final int f26758Ad = 100663295;
    /* renamed from: Bd */
    private static final int f26759Bd = 117440511;
    /* renamed from: Cd */
    static final List<Integer> f26760Cd = new ArrayList();
    /* renamed from: yd */
    private static final int f26761yd = 67108863;
    /* renamed from: zd */
    private static final int f26762zd = 83886079;
    /* renamed from: Dd */
    private final int f26763Dd = 1000;
    /* renamed from: Ed */
    private final int f26764Ed = PathInterpolatorCompat.MAX_NUM_POINTS;
    /* renamed from: Fd */
    private List<String> f26765Fd = new ArrayList(5);
    /* access modifiers changed from: private */
    /* renamed from: Gd */
    public HashMap<String, WeakReference<View>> f26766Gd = new HashMap<>(5);
    /* access modifiers changed from: private */
    /* renamed from: Hd */
    public HashMap<String, Boolean> f26767Hd = new HashMap<>(5);
    /* access modifiers changed from: private */
    /* renamed from: Id */
    public HashMap<String, AdDisplayModel> f26768Id = new HashMap<>(5);
    /* access modifiers changed from: private */
    /* renamed from: Jd */
    public HashMap<String, Runnable> f26769Jd = new HashMap<>(5);
    /* access modifiers changed from: private */
    /* renamed from: Kd */
    public C7868a f26770Kd;
    /* access modifiers changed from: private */
    /* renamed from: Ld */
    public boolean f26771Ld = false;
    private final String TAG = "DisplayControl";
    /* access modifiers changed from: private|final */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: discoveryAD.L$a */
    public interface C7868a {
        void onClick(AdDisplayModel adDisplayModel, Bundle bundle);

        void onDisPlay(AdDisplayModel adDisplayModel);
    }

    /* renamed from: discoveryAD.L$b */
    class C7869b implements Runnable {
        /* renamed from: xd */
        final String f26772xd;

        public C7869b(String str) {
            this.f26772xd = str;
        }

        public void run() {
            String str = "DisplayControl";
            if (((Boolean) C7867L.this.f26767Hd.get(this.f26772xd)).booleanValue()) {
                C7867L.this.f26769Jd.remove(this.f26772xd);
                StringBuilder sb = new StringBuilder();
                sb.append("DetectRunnable mRuningTask.remove(Idle) Idle=");
                sb.append(this.f26772xd);
                C7852Aa.m34154d(str, sb.toString());
                return;
            }
            C7867L.this.m34213O(this.f26772xd);
            Runnable runnable = (Runnable) C7867L.this.f26769Jd.get(this.f26772xd);
            if (runnable != null) {
                C7867L.this.mHandler.removeCallbacks(runnable);
                C7867L.this.mHandler.postDelayed(runnable, 3000);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DetectRunnablem RuningTask.get(Idle)==NULL Idle=");
                sb2.append(this.f26772xd);
                C7852Aa.m34154d(str, sb2.toString());
            }
        }
    }

    /* renamed from: discoveryAD.L$c */
    class C7870c implements Runnable {
        /* renamed from: xd */
        final String f26773xd;

        public C7870c(String str) {
            this.f26773xd = str;
        }

        public void run() {
            String str = "DisplayControl";
            C7852Aa.m34154d(str, "showRunnable()");
            WeakReference weakReference = (WeakReference) C7867L.this.f26766Gd.get(this.f26773xd);
            if (weakReference == null) {
                if (!C7867L.this.f26771Ld) {
                    AdDisplayModel adDisplayModel = (AdDisplayModel) C7867L.this.f26768Id.get(this.f26773xd);
                    if (adDisplayModel != null) {
                        C7867L.this.f26771Ld = C7867L.m34220a(adDisplayModel, C7920oa.VIEW_DISMISS.ordinal());
                    }
                }
                return;
            }
            View view = (View) weakReference.get();
            boolean z = false;
            if (view != null) {
                C7920oa d = C7935va.m34356d(view);
                StringBuilder sb = new StringBuilder();
                sb.append("showRunnable() AD_UI_ERROR=");
                sb.append(d);
                C7852Aa.m34154d(str, sb.toString());
                if (d == C7920oa.NO_ERROR) {
                    z = true;
                }
                if (!C7867L.this.f26771Ld) {
                    AdDisplayModel adDisplayModel2 = (AdDisplayModel) C7867L.this.f26768Id.get(this.f26773xd);
                    if (adDisplayModel2 != null) {
                        C7867L.this.f26771Ld = C7867L.m34220a(adDisplayModel2, d.ordinal());
                    }
                }
            }
            if (z) {
                C7867L.this.f26767Hd.put(this.f26773xd, Boolean.valueOf(true));
                if (C7867L.this.f26770Kd != null) {
                    AdDisplayModel adDisplayModel3 = (AdDisplayModel) C7867L.this.f26768Id.get(this.f26773xd);
                    if (adDisplayModel3 == null) {
                        C7852Aa.m34154d(str, "showRunnable null == model");
                    } else {
                        C7867L.this.f26770Kd.onDisPlay(adDisplayModel3);
                    }
                }
            }
        }
    }

    static {
        f26760Cd.add(Integer.valueOf(30183010));
        f26760Cd.add(Integer.valueOf(20183011));
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public void m34213O(String str) {
        WeakReference weakReference = (WeakReference) this.f26766Gd.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("startDetect() id=");
        sb.append(str);
        sb.append("||");
        sb.append(this.f26767Hd.get(str));
        sb.append("||null == tmpView:");
        boolean z = true;
        sb.append(weakReference == null);
        String str2 = "DisplayControl";
        C7852Aa.m34154d(str2, sb.toString());
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                Runnable runnable = (Runnable) this.f26769Jd.get(str);
                if (runnable != null) {
                    this.mHandler.removeCallbacks(runnable);
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("view =");
            sb2.append(view.getVisibility());
            C7852Aa.m34154d(str2, sb2.toString());
            C7920oa c = C7935va.m34354c(view);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("displayBegin() AD_UI_ERROR=");
            sb3.append(c);
            C7852Aa.m34154d(str2, sb3.toString());
            if (c != C7920oa.NO_ERROR) {
                z = false;
            }
            if (z) {
                C7870c cVar = new C7870c(str);
                this.mHandler.removeCallbacks(cVar);
                this.mHandler.postDelayed(cVar, 1000);
            }
        }
    }

    /* renamed from: a */
    private C7872N m34214a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof C7872N)) {
                i++;
            } else if (this.f26765Fd.contains(childAt.getTag(f26761yd))) {
                return (C7872N) childAt;
            } else {
                viewGroup.removeViewAt(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34215a(View view, AdDisplayModel adDisplayModel, Bundle bundle) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            C7872N a = m34214a(viewGroup);
            if (a == null) {
                a = new C7872N(view.getContext(), this);
                viewGroup.addView(a, new LayoutParams(0, 0));
                this.f26765Fd.add(adDisplayModel.uniqueKey);
            } else {
                String str = (String) a.getTag(f26761yd);
                if (!str.equals(adDisplayModel.uniqueKey)) {
                    Runnable runnable = (Runnable) this.f26769Jd.get(str);
                    if (runnable != null) {
                        this.f26769Jd.remove(str);
                        this.mHandler.removeCallbacks(runnable);
                    }
                }
                view.setTag(f26762zd, adDisplayModel.uniqueKey);
                view.setTag(f26758Ad, bundle);
                a.setTag(f26761yd, adDisplayModel.uniqueKey);
            }
            this.f26767Hd.put(adDisplayModel.uniqueKey, Boolean.valueOf(false));
            view.setTag(f26762zd, adDisplayModel.uniqueKey);
            view.setTag(f26758Ad, bundle);
            a.setTag(f26761yd, adDisplayModel.uniqueKey);
        }
        view.setTag(f26759Bd, new ClickDataModel());
        view.setOnClickListener(this);
        view.setOnTouchListener(new C7865J(this));
        this.f26766Gd.put(adDisplayModel.uniqueKey, new WeakReference(view));
        if (((AdDisplayModel) this.f26768Id.get(adDisplayModel.uniqueKey)) == null) {
            this.f26768Id.put(adDisplayModel.uniqueKey, adDisplayModel);
        }
        if (((C7869b) this.f26769Jd.get(adDisplayModel.uniqueKey)) == null) {
            C7869b bVar = new C7869b(adDisplayModel.uniqueKey);
            this.f26769Jd.put(adDisplayModel.uniqueKey, bVar);
            this.mHandler.removeCallbacks(bVar);
            this.mHandler.post(bVar);
        }
    }

    /* renamed from: a */
    static boolean m34220a(AdDisplayModel adDisplayModel, int i) {
        if (!f26760Cd.contains(Integer.valueOf(adDisplayModel.positionId))) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("checkandreport() model.positionId=");
        sb.append(adDisplayModel.positionId);
        sb.append(" AD_UI_ERROR=");
        sb.append(i);
        C7852Aa.m34154d("DisplayControl", sb.toString());
        C7873O instance = C7873O.getInstance();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(adDisplayModel.positionId);
        sb2.append("_");
        sb2.append(i);
        instance.reportString(C7879V.f26797ah, sb2.toString(), 4);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34223b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof C7872N) {
                this.f26766Gd.remove(childAt.getTag(f26761yd));
                viewGroup.removeViewAt(i);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: pb */
    public void m34230pb() {
        Set<String> keySet = this.f26767Hd.keySet();
        if (keySet != null) {
            for (String put : keySet) {
                this.f26767Hd.put(put, Boolean.valueOf(false));
            }
        }
    }

    /* renamed from: a */
    public void mo38138a(View view) {
        String str = (String) view.getTag(f26761yd);
        StringBuilder sb = new StringBuilder();
        sb.append("displayBegin() id=");
        sb.append(str);
        String str2 = "DisplayControl";
        C7852Aa.m34154d(str2, sb.toString());
        Runnable runnable = (Runnable) this.f26769Jd.get(str);
        if (runnable == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("displayBegin() null == runable id=");
            sb2.append(str);
            C7852Aa.m34154d(str2, sb2.toString());
            return;
        }
        this.mHandler.removeCallbacks(runnable);
        this.mHandler.post(runnable);
    }

    /* renamed from: a */
    public void mo38139a(C7868a aVar) {
        this.f26770Kd = aVar;
    }

    /* renamed from: b */
    public void mo38140b(View view) {
        String str = "DisplayControl";
        C7852Aa.m34154d(str, "displayEnd()");
        String str2 = (String) view.getTag(f26761yd);
        Runnable runnable = (Runnable) this.f26769Jd.get(str2);
        if (runnable == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("displayEnd() null == runable id=");
            sb.append(str2);
            C7852Aa.m34154d(str, sb.toString());
            return;
        }
        this.f26769Jd.remove(str2);
        this.mHandler.removeCallbacks(runnable);
    }

    public void onClick(View view) {
        if (this.f26770Kd != null) {
            Bundle bundle = (Bundle) view.getTag(f26758Ad);
            AdDisplayModel adDisplayModel = (AdDisplayModel) this.f26768Id.get((String) view.getTag(f26762zd));
            if (adDisplayModel == null) {
                C7852Aa.m34154d("DisplayControl", "null == model");
                return;
            }
            ClickDataModel clickDataModel = (ClickDataModel) view.getTag(f26759Bd);
            clickDataModel.view_w = (double) view.getWidth();
            clickDataModel.view_h = (double) view.getHeight();
            adDisplayModel.cModel = clickDataModel;
            this.f26770Kd.onClick(adDisplayModel, bundle);
        }
    }

    public void registerViewForInteraction(View view, AdDisplayModel adDisplayModel, Bundle bundle) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m34215a(view, adDisplayModel, bundle);
        } else {
            this.mHandler.post(new C7864I(this, view, adDisplayModel, bundle));
        }
    }

    public void reset() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            m34230pb();
        } else {
            this.mHandler.post(new C7866K(this));
        }
    }

    public void unregisterViewForInteraction(View view) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mHandler.post(new C7863H(this, view));
        } else if (view instanceof ViewGroup) {
            view.setOnClickListener(null);
            m34223b((ViewGroup) view);
        }
    }
}
