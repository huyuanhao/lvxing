package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.InternalContainer;
import com.bytedance.sdk.openadsdk.core.p170d.VideoInfo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.INewMediaCallback;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;

/* renamed from: com.bytedance.sdk.openadsdk.core.widget.e */
public class VideoTrafficTipLayout {
    /* renamed from: a */
    private View f8348a;
    /* renamed from: b */
    private TextView f8349b;
    /* renamed from: c */
    private Context f8350c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public INewMediaCallback f8351d;
    /* renamed from: e */
    private C2366b f8352e;
    /* renamed from: f */
    private boolean f8353f = false;
    /* renamed from: g */
    private VideoInfo f8354g;
    /* renamed from: h */
    private ViewStub f8355h;
    /* renamed from: i */
    private View f8356i;

    /* compiled from: VideoTrafficTipLayout */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.e$a */
    public enum C2365a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* compiled from: VideoTrafficTipLayout */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.e$b */
    public interface C2366b {
        /* renamed from: h */
        boolean mo16162h();

        /* renamed from: j */
        void mo16164j();
    }

    /* renamed from: a */
    public void mo16319a(Context context, View view) {
        if (context != null && (view instanceof ViewGroup)) {
            this.f8356i = view;
            this.f8350c = InternalContainer.m10059a().getApplicationContext();
            this.f8355h = (ViewStub) LayoutInflater.from(context).inflate(ResourceHelp.m11936f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(ResourceHelp.m11935e(context, "tt_video_traffic_tip_layout_viewStub"));
        }
    }

    /* renamed from: b */
    private void m10830b(Context context, View view) {
        if (context != null && view != null) {
            ViewStub viewStub = this.f8355h;
            if (viewStub != null && viewStub.getParent() != null && this.f8348a == null) {
                this.f8355h.inflate();
                this.f8348a = view.findViewById(ResourceHelp.m11935e(context, "tt_video_traffic_tip_layout"));
                this.f8349b = (TextView) view.findViewById(ResourceHelp.m11935e(context, "tt_video_traffic_tip_tv"));
                view.findViewById(ResourceHelp.m11935e(context, "tt_video_traffic_continue_play_btn")).setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        VideoTrafficTipLayout.this.m10831c();
                        if (VideoTrafficTipLayout.this.f8351d != null) {
                            VideoTrafficTipLayout.this.f8351d.mo15962a(C2365a.START_VIDEO, null);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public void mo16320a(INewMediaCallback dVar, C2366b bVar) {
        this.f8352e = bVar;
        this.f8351d = dVar;
    }

    /* renamed from: b */
    private void m10829b() {
        this.f8354g = null;
    }

    /* renamed from: a */
    public boolean mo16323a(int i, VideoInfo rVar) {
        Context context = this.f8350c;
        if (context == null || rVar == null) {
            return true;
        }
        m10830b(context, this.f8356i);
        this.f8354g = rVar;
        if (i == 1 || i == 2) {
            return m10827a(i);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10827a(int i) {
        if (mo16322a() || this.f8353f) {
            return true;
        }
        if (this.f8351d != null) {
            C2366b bVar = this.f8352e;
            if (bVar != null) {
                if (bVar.mo16162h()) {
                    this.f8351d.mo15979e(null, null);
                }
                this.f8351d.mo15962a(C2365a.PAUSE_VIDEO, null);
            }
        }
        m10825a(this.f8354g, true);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10831c() {
        if (this.f8350c != null) {
            m10832d();
        }
    }

    /* renamed from: a */
    public void mo16321a(boolean z) {
        if (z) {
            m10829b();
        }
        m10832d();
    }

    /* renamed from: a */
    public boolean mo16322a() {
        View view = this.f8348a;
        return view != null && view.getVisibility() == 0;
    }

    /* renamed from: d */
    private void m10832d() {
        View view = this.f8348a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* renamed from: a */
    private void m10825a(VideoInfo rVar, boolean z) {
        String str;
        if (rVar != null) {
            View view = this.f8348a;
            if (view != null && this.f8350c != null && view.getVisibility() != 0) {
                C2366b bVar = this.f8352e;
                if (bVar != null) {
                    bVar.mo16164j();
                }
                int ceil = (int) Math.ceil((((double) rVar.mo15593c()) * 1.0d) / 1048576.0d);
                String str2 = "tt_video_bytesize";
                String str3 = "tt_video_without_wifi_tips";
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(ResourceHelp.m11931a(this.f8350c, str3));
                    sb.append(ceil);
                    sb.append(ResourceHelp.m11931a(this.f8350c, "tt_video_bytesize_MB"));
                    sb.append(ResourceHelp.m11931a(this.f8350c, str2));
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(ResourceHelp.m11931a(this.f8350c, str3));
                    sb2.append(ResourceHelp.m11931a(this.f8350c, str2));
                    str = sb2.toString();
                }
                UIUtils.m12059a(this.f8348a, 0);
                UIUtils.m12064a(this.f8349b, (CharSequence) str);
                if (UIUtils.m12083c(this.f8348a)) {
                    View view2 = this.f8348a;
                    if (view2 != null) {
                        view2.bringToFront();
                    }
                }
            }
        }
    }
}
