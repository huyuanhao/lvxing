package com.p368pw.inner.appwall;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.p368pw.inner.appwall.C5041p.C5042a;
import com.p368pw.inner.appwall.C5060y.C5066b;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5191i;
import com.p368pw.inner.base.p387d.C5196m;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.view.DownloadProgressBar;
import com.pw.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.pw.inner.appwall.j */
public class C5015j extends Adapter<ViewHolder> {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public Context f16329a;
    /* renamed from: b */
    private List<C5047t> f16330b = new ArrayList();
    /* renamed from: c */
    private List<C5138c> f16331c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public Drawable f16332d;
    /* renamed from: e */
    private C5025f f16333e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public C5026g f16334f;
    /* renamed from: g */
    private GradientDrawable f16335g;
    /* renamed from: h */
    private GradientDrawable f16336h = new GradientDrawable();
    /* renamed from: i */
    private C5060y f16337i;
    /* renamed from: j */
    private int f16338j;
    /* renamed from: k */
    private double f16339k;
    /* renamed from: l */
    private double f16340l;
    /* renamed from: m */
    private int f16341m;
    /* renamed from: n */
    private String f16342n;
    /* renamed from: o */
    private String f16343o;
    /* renamed from: p */
    private String f16344p;
    /* access modifiers changed from: private */
    /* renamed from: q */
    public C5024e f16345q;

    /* renamed from: com.pw.inner.appwall.j$a */
    class C5020a extends ViewHolder {
        /* renamed from: a */
        RelativeLayout f16356a;
        /* renamed from: b */
        ImageView f16357b;
        /* renamed from: c */
        TextView f16358c;
        /* renamed from: d */
        TextView f16359d;
        /* renamed from: e */
        DownloadProgressBar f16360e;
        /* renamed from: f */
        TextView f16361f;
        /* renamed from: g */
        TextView f16362g;

        public C5020a(View view) {
            super(view);
            this.f16356a = (RelativeLayout) view.findViewById(R.id.win_item_layout);
            this.f16357b = (ImageView) view.findViewById(R.id.win_item_icon);
            this.f16358c = (TextView) view.findViewById(R.id.win_item_name);
            this.f16359d = (TextView) view.findViewById(R.id.win_item_desc);
            this.f16360e = (DownloadProgressBar) view.findViewById(R.id.win_sdk_progress_download_button);
            this.f16361f = (TextView) view.findViewById(R.id.win_item_button);
            this.f16362g = (TextView) view.findViewById(R.id.win_item_reward_info);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo26426a(double d) {
            boolean e = C4970aa.m20784a().mo26333e();
            if (d == 0.0d) {
                this.f16361f.setText("");
            } else {
                this.f16361f.setText(C4970aa.m20787a(e, d));
            }
            this.f16361f.setTypeface(Typeface.defaultFromStyle(1));
            if (C5015j.this.f16332d != null) {
                this.f16361f.setCompoundDrawables(C5015j.this.f16332d, null, null, null);
                this.f16361f.setCompoundDrawablePadding(C5191i.m21391b(C5015j.this.f16329a, 3));
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo26427a(String str, int i) {
            StringBuilder sb = new StringBuilder();
            if (str.length() > 10) {
                sb.append(str, 0, 10);
                str = "...";
            }
            sb.append(str);
            this.f16358c.setText(sb.toString());
        }
    }

    /* renamed from: com.pw.inner.appwall.j$b */
    class C5021b extends ViewHolder {
        public C5021b(View view) {
            super(view);
        }
    }

    /* renamed from: com.pw.inner.appwall.j$c */
    class C5022c extends ViewHolder {
        public C5022c(View view) {
            super(view);
        }
    }

    /* renamed from: com.pw.inner.appwall.j$d */
    class C5023d extends ViewHolder {
        /* renamed from: a */
        TextView f16366a;
        /* renamed from: b */
        TextView f16367b;

        public C5023d(View view) {
            super(view);
            this.f16366a = (TextView) view.findViewById(R.id.win_sdk_head_title);
            this.f16367b = (TextView) view.findViewById(R.id.win_sdk_head_desc);
        }
    }

    /* renamed from: com.pw.inner.appwall.j$e */
    public interface C5024e {
        void onItemClick(C5138c cVar);
    }

    /* renamed from: com.pw.inner.appwall.j$f */
    public interface C5025f {
        void onClick(int i, C5047t tVar);
    }

    /* renamed from: com.pw.inner.appwall.j$g */
    public interface C5026g {
        void onClick(int i, C5047t tVar);
    }

    /* renamed from: com.pw.inner.appwall.j$h */
    class C5027h extends ViewHolder {
        public C5027h(View view) {
            super(view);
        }
    }

    /* renamed from: com.pw.inner.appwall.j$i */
    class C5028i extends ViewHolder {
        /* renamed from: a */
        RelativeLayout f16370a;
        /* renamed from: b */
        ImageView f16371b;
        /* renamed from: c */
        TextView f16372c;
        /* renamed from: d */
        TextView f16373d;
        /* renamed from: e */
        FrameLayout f16374e;
        /* renamed from: f */
        DownloadProgressBar f16375f;
        /* renamed from: g */
        TextView f16376g;
        /* renamed from: h */
        ImageView f16377h;
        /* renamed from: i */
        ProgressBar f16378i;
        /* renamed from: j */
        ImageView[] f16379j = new ImageView[7];
        /* renamed from: k */
        TextView[] f16380k = new TextView[7];

        public C5028i(View view) {
            super(view);
            this.f16370a = (RelativeLayout) view.findViewById(R.id.win_item_sign_layout);
            this.f16371b = (ImageView) view.findViewById(R.id.win_item_sign_icon);
            this.f16372c = (TextView) view.findViewById(R.id.win_item_sign_name);
            this.f16373d = (TextView) view.findViewById(R.id.win_item_sign_desc);
            this.f16374e = (FrameLayout) view.findViewById(R.id.win_item_sign_button_layout);
            this.f16375f = (DownloadProgressBar) view.findViewById(R.id.win_sdk_progress_download_button);
            this.f16376g = (TextView) view.findViewById(R.id.win_item_sign_button);
            this.f16377h = (ImageView) view.findViewById(R.id.win_item_sign_tips_img);
            this.f16378i = (ProgressBar) view.findViewById(R.id.win_item_sign_progress_bar);
            View findViewById = view.findViewById(R.id.win_item_sign_day_one);
            this.f16379j[0] = (ImageView) findViewById.findViewById(R.id.win_sign_line_img);
            this.f16380k[0] = (TextView) findViewById.findViewById(R.id.win_sign_line_text);
            View findViewById2 = view.findViewById(R.id.win_item_sign_day_two);
            this.f16379j[1] = (ImageView) findViewById2.findViewById(R.id.win_sign_line_img);
            this.f16380k[1] = (TextView) findViewById2.findViewById(R.id.win_sign_line_text);
            View findViewById3 = view.findViewById(R.id.win_item_sign_day_three);
            this.f16379j[2] = (ImageView) findViewById3.findViewById(R.id.win_sign_line_img);
            this.f16380k[2] = (TextView) findViewById3.findViewById(R.id.win_sign_line_text);
            View findViewById4 = view.findViewById(R.id.win_item_sign_day_four);
            this.f16379j[3] = (ImageView) findViewById4.findViewById(R.id.win_sign_line_img);
            this.f16380k[3] = (TextView) findViewById4.findViewById(R.id.win_sign_line_text);
            View findViewById5 = view.findViewById(R.id.win_item_sign_day_five);
            this.f16379j[4] = (ImageView) findViewById5.findViewById(R.id.win_sign_line_img);
            this.f16380k[4] = (TextView) findViewById5.findViewById(R.id.win_sign_line_text);
            View findViewById6 = view.findViewById(R.id.win_item_sign_day_six);
            this.f16379j[5] = (ImageView) findViewById6.findViewById(R.id.win_sign_line_img);
            this.f16380k[5] = (TextView) findViewById6.findViewById(R.id.win_sign_line_text);
            View findViewById7 = view.findViewById(R.id.win_item_sign_day_seven);
            this.f16379j[6] = (ImageView) findViewById7.findViewById(R.id.win_sign_line_img);
            this.f16380k[6] = (TextView) findViewById7.findViewById(R.id.win_sign_line_text);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo26431a(C5034m mVar) {
            C5042a d = mVar.mo26469d();
            int g = d.mo26486g();
            if (g > 7) {
                g = 7;
            }
            boolean e = C4970aa.m20784a().mo26333e();
            this.f16376g.setText(C4970aa.m20787a(e, d.mo26479a(e)));
            this.f16376g.setTypeface(Typeface.defaultFromStyle(1));
            if (C5015j.this.f16332d != null) {
                this.f16376g.setCompoundDrawables(C5015j.this.f16332d, null, null, null);
                this.f16376g.setCompoundDrawablePadding(C5191i.m21391b(C5015j.this.f16329a, 3));
            }
            if (g == 7 && d.mo26487h() == 1) {
                this.f16376g.setText("打开");
                this.f16376g.setTypeface(Typeface.defaultFromStyle(1));
                this.f16376g.setCompoundDrawables(null, null, null, null);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo26432a(String str) {
            StringBuilder sb = new StringBuilder();
            if (str.length() > 10) {
                sb.append(str, 0, 10);
                str = "...";
            }
            sb.append(str);
            this.f16372c.setText(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo26433b(C5034m mVar) {
            float f;
            FrameLayout frameLayout;
            TextView textView;
            String str;
            ImageView imageView;
            int i;
            C5042a d = mVar.mo26469d();
            int g = d.mo26486g();
            if (g > 7) {
                g = 7;
            }
            int i2 = 0;
            if (g > 1) {
                this.f16378i.setProgress(Math.round(((float) (g - 1)) * 16.666666f));
            } else {
                this.f16378i.setProgress(0);
            }
            if (!d.mo26488i() || g >= 7) {
                this.f16377h.setVisibility(8);
                frameLayout = this.f16374e;
                f = 1.0f;
            } else {
                this.f16377h.setVisibility(0);
                frameLayout = this.f16374e;
                f = 0.6f;
            }
            frameLayout.setAlpha(f);
            this.f16376g.setAlpha(f);
            boolean e = C4970aa.m20784a().mo26333e();
            while (i2 < 7) {
                this.f16380k[i2].setText(C4970aa.m20787a(e, e ? (double) ((Integer) d.f16447b.get(i2)).intValue() : ((Double) d.f16448c.get(i2)).doubleValue()));
                int i3 = i2 + 1;
                TextView[] textViewArr = this.f16380k;
                if (i3 < g) {
                    textView = textViewArr[i2];
                    str = "#FFD1D1D1";
                } else if (i3 == g) {
                    textView = textViewArr[i2];
                    str = "#FFFFC856";
                } else {
                    textView = textViewArr[i2];
                    str = "#FF999999";
                }
                textView.setTextColor(Color.parseColor(str));
                if (((Integer) d.f16449d.get(i2)).intValue() == 1) {
                    imageView = this.f16379j[i2];
                    i = R.drawable.win_sign_done;
                } else {
                    ImageView[] imageViewArr = this.f16379j;
                    if (i3 < g) {
                        imageView = imageViewArr[i2];
                        i = R.drawable.win_sign_miss;
                    } else {
                        imageView = imageViewArr[i2];
                        i = R.drawable.win_sign_undo;
                    }
                }
                imageView.setImageResource(i);
                boolean j = d.mo26489j();
                if (i2 == 6 && !j) {
                    this.f16380k[i2].setText(C4970aa.m20787a(e, e ? (double) (((Integer) d.f16447b.get(i2)).intValue() + d.mo26484e()) : ((Double) d.f16448c.get(i2)).doubleValue() + d.mo26485f()));
                    if (((Integer) d.f16449d.get(i2)).intValue() == 0) {
                        this.f16379j[i2].setImageResource(R.drawable.win_sign_gift);
                    }
                }
                i2 = i3;
            }
        }
    }

    /* renamed from: com.pw.inner.appwall.j$j */
    class C5029j extends ViewHolder {
        /* renamed from: a */
        C5060y f16382a;

        public C5029j(View view) {
            super(view);
            this.f16382a = (C5060y) view;
        }
    }

    public C5015j(Context context) {
        this.f16329a = context;
        this.f16336h.setCornerRadius((float) C5191i.m21391b(context, 2));
        this.f16336h.setColor(Color.parseColor("#FFFF7A77"));
        this.f16335g = new GradientDrawable();
        this.f16335g.setCornerRadius((float) C5191i.m21391b(context, 2));
        this.f16335g.setColor(Color.parseColor("#FF5DE4B0"));
        C5030k e = C5125f.m21216a().mo26728e();
        this.f16344p = e.mo26444k();
        this.f16342n = e.mo26442i();
        this.f16343o = e.mo26443j();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20965a(int i, C5047t tVar) {
        C5205o.m21462a("ada clk evn");
        if (this.f16333e != null) {
            C5034m d = tVar.mo26542d();
            if (d != null) {
                C5138c a = d.mo26466a();
                a.f16775d = this.f16339k;
                d.mo26463a(a);
                this.f16333e.onClick(i, tVar);
            }
        }
    }

    /* renamed from: a */
    private boolean m20967a(int i) {
        return ((C5047t) this.f16330b.get(i)).mo26540b() == 3;
    }

    /* renamed from: b */
    private boolean m20969b(int i) {
        return ((C5047t) this.f16330b.get(i)).mo26540b() == 1;
    }

    /* renamed from: a */
    public C5015j mo26415a(C5024e eVar) {
        this.f16345q = eVar;
        return this;
    }

    /* renamed from: a */
    public void mo26416a() {
        C5060y yVar = this.f16337i;
        if (yVar != null) {
            yVar.mo26568b();
        }
    }

    /* renamed from: a */
    public void mo26417a(double d, double d2, int i, int i2) {
        try {
            this.f16339k = d;
            this.f16340l = d2;
            this.f16341m = i;
            this.f16332d = this.f16329a.getResources().getDrawable(R.drawable.win_sdk_button_coin);
            if (i2 > 0) {
                this.f16332d = ContextCompat.getDrawable(this.f16329a, i2);
            }
            if (this.f16332d != null) {
                this.f16332d.setBounds(0, 0, this.f16332d.getMinimumWidth(), this.f16332d.getMinimumHeight());
            }
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    /* renamed from: a */
    public void mo26418a(C5025f fVar) {
        this.f16333e = fVar;
    }

    /* renamed from: a */
    public void mo26419a(C5026g gVar) {
        this.f16334f = gVar;
    }

    /* renamed from: a */
    public void mo26420a(List<C5047t> list, List<C5138c> list2) {
        if (list != null || list2 != null) {
            this.f16330b = list;
            this.f16331c = list2;
            notifyDataSetChanged();
        }
    }

    /* renamed from: b */
    public void mo26421b() {
        C5060y yVar = this.f16337i;
        if (yVar != null) {
            yVar.mo26566a();
        }
    }

    public int getItemCount() {
        return this.f16330b.size();
    }

    public int getItemViewType(int i) {
        return ((C5047t) this.f16330b.get(i)).mo26541c();
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        String str;
        TextView textView;
        final C5047t tVar = (C5047t) this.f16330b.get(i);
        if (getItemViewType(i) == 0 && (viewHolder instanceof C5021b)) {
            C4989af afVar = (C4989af) viewHolder.itemView;
            afVar.setTitleText(tVar.mo26543e().mo26555a());
            afVar.setDescText(tVar.mo26543e().mo26556b());
            afVar.setColor(this.f16341m);
        } else if (getItemViewType(i) == 6 && (viewHolder instanceof C5029j)) {
            C5029j jVar = (C5029j) viewHolder;
            jVar.f16382a.setData(this.f16331c);
            jVar.f16382a.mo26565a((C5066b) new C5066b() {
                /* renamed from: a */
                public void mo26422a(C5138c cVar) {
                    if (C5015j.this.f16345q != null) {
                        C5015j.this.f16345q.onItemClick(cVar);
                    }
                }
            });
        } else if (getItemViewType(i) == 1 && (viewHolder instanceof C5023d)) {
            C5023d dVar = (C5023d) viewHolder;
            C5053v e = tVar.mo26543e();
            dVar.f16366a.setText(e.mo26555a());
            dVar.f16367b.setText(e.mo26556b());
        } else if (getItemViewType(i) == 2 && (viewHolder instanceof C5020a)) {
            C5020a aVar = (C5020a) viewHolder;
            LayoutParams layoutParams = aVar.itemView.getLayoutParams();
            if (tVar.mo26544f()) {
                aVar.itemView.setBackground(ContextCompat.getDrawable(this.f16329a, R.drawable.win_sdk_bg_item_app_wall_last));
            } else {
                aVar.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
            aVar.itemView.setLayoutParams(layoutParams);
            C5034m d = tVar.mo26542d();
            C5138c a = d.mo26466a();
            C5196m.m21445a(this.f16329a.getApplicationContext(), a.f16774c, aVar.f16357b);
            aVar.mo26427a(a.f16772a, a.f16781j);
            C5042a d2 = d.mo26469d();
            if (m20967a(i)) {
                if (d2 != null) {
                    aVar.f16359d.setText(d2.mo26483d());
                }
                aVar.f16362g.setBackground(this.f16335g);
                if (a.f16781j == 2) {
                    textView = aVar.f16362g;
                    str = this.f16343o;
                } else {
                    textView = aVar.f16362g;
                    str = this.f16342n;
                }
            } else {
                if (m20969b(i)) {
                    if (d2 != null) {
                        aVar.f16359d.setText(d2.mo26482c());
                    }
                    aVar.f16362g.setBackground(this.f16336h);
                    textView = aVar.f16362g;
                    str = this.f16344p;
                }
                aVar.f16360e.setColor(this.f16341m);
                aVar.f16360e.setMax(100);
                aVar.f16360e.setProgress(0);
                aVar.f16360e.setProgress(tVar.mo26545g());
                aVar.mo26426a(this.f16339k);
                aVar.f16356a.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C5015j.this.m20965a(i, tVar);
                    }
                });
            }
            textView.setText(str);
            aVar.f16360e.setColor(this.f16341m);
            aVar.f16360e.setMax(100);
            aVar.f16360e.setProgress(0);
            aVar.f16360e.setProgress(tVar.mo26545g());
            aVar.mo26426a(this.f16339k);
            aVar.f16356a.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C5015j.this.m20965a(i, tVar);
                }
            });
        } else if (getItemViewType(i) == 3 && (viewHolder instanceof C5027h)) {
            C4988ae aeVar = (C4988ae) viewHolder.itemView;
            aeVar.setTitleText(tVar.mo26543e().mo26555a());
            aeVar.setDescText(tVar.mo26543e().mo26556b());
        } else if (getItemViewType(i) != 4 || !(viewHolder instanceof C5028i)) {
            if (viewHolder instanceof C5022c) {
                viewHolder.itemView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        if (C5015j.this.f16334f != null) {
                            C5015j.this.f16334f.onClick(i, tVar);
                        }
                    }
                });
            }
        } else {
            C5028i iVar = (C5028i) viewHolder;
            C5034m d3 = tVar.mo26542d();
            C5138c a2 = d3.mo26466a();
            C5042a d4 = d3.mo26469d();
            C5196m.m21445a(this.f16329a.getApplicationContext(), a2.f16774c, iVar.f16371b);
            iVar.mo26432a(a2.f16772a);
            iVar.f16373d.setText(String.format("已签到%d天", new Object[]{Integer.valueOf(d4.f16446a)}));
            iVar.f16375f.setColor(this.f16341m);
            iVar.f16375f.setMax(100);
            iVar.f16375f.setProgress(0);
            iVar.f16375f.setProgress(tVar.mo26545g());
            iVar.mo26431a(d3);
            iVar.mo26433b(d3);
            iVar.f16370a.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C5015j.this.m20965a(i, tVar);
                }
            });
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i, List<Object> list) {
        DownloadProgressBar downloadProgressBar;
        if (list == null || list.isEmpty()) {
            super.onBindViewHolder(viewHolder, i, list);
            return;
        }
        int intValue = ((Integer) list.get(list.size() - 1)).intValue();
        ((C5047t) this.f16330b.get(viewHolder.getAdapterPosition())).mo26538a(intValue);
        if (viewHolder instanceof C5020a) {
            downloadProgressBar = ((C5020a) viewHolder).f16360e;
        } else {
            if (viewHolder instanceof C5028i) {
                downloadProgressBar = ((C5028i) viewHolder).f16375f;
            }
        }
        downloadProgressBar.setProgress(intValue);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new C5021b(new C4989af(this.f16329a));
        }
        if (i == 6) {
            this.f16337i = new C5060y(this.f16329a);
            this.f16337i.mo26567a(this.f16338j, this.f16341m);
            return new C5029j(this.f16337i);
        } else if (i == 1) {
            return new C5023d(LayoutInflater.from(this.f16329a).inflate(R.layout.win_sdk_item_app_wall_head, viewGroup, false));
        } else {
            if (i == 2) {
                return new C5020a(LayoutInflater.from(this.f16329a).inflate(R.layout.win_sdk_item_app_wall, viewGroup, false));
            }
            if (i == 3) {
                return new C5027h(new C4988ae(this.f16329a));
            }
            if (i == 4) {
                return new C5028i(LayoutInflater.from(this.f16329a).inflate(R.layout.win_sdk_item_signin, viewGroup, false));
            }
            if (i == 5) {
                return new C5022c(LayoutInflater.from(this.f16329a).inflate(R.layout.win_sdk_item_more, viewGroup, false));
            }
            return null;
        }
    }

    public void onViewAttachedToWindow(ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (viewHolder instanceof C5029j) {
            ((C5029j) viewHolder).f16382a.mo26568b();
        }
    }

    public void onViewDetachedFromWindow(ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (viewHolder instanceof C5029j) {
            ((C5029j) viewHolder).f16382a.mo26566a();
        }
    }
}
