package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.qiyukf.basesdk.p393a.C5264a;
import com.qiyukf.unicorn.C5961R;
import com.qiyukf.unicorn.p502e.C6045d.C6046a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qiyukf.nim.uikit.session.emoji.c */
public final class C5535c {
    /* renamed from: a */
    public OnItemClickListener f17838a = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int currentItem = C5535c.this.f17840c.getCurrentItem();
            if (!(C5535c.this.f17848k == null || C5535c.this.f17849l == null)) {
                C5535c.this.m22522b(currentItem);
                currentItem = C5535c.this.f17850m[1];
            }
            int i2 = (currentItem * 27) + i;
            if (C5535c.this.f17844g != null) {
                int a = C5531b.m22508a();
                if (i == 27 || i2 >= a) {
                    C5535c.this.f17844g.mo27654a("/DEL");
                    return;
                }
                String a2 = C5531b.m22511a((int) j);
                if (!TextUtils.isEmpty(a2)) {
                    C5535c.this.f17844g.mo27654a(a2);
                }
            }
        }
    };
    /* renamed from: b */
    public OnItemClickListener f17839b = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C5535c.this.m22522b(C5535c.this.f17840c.getCurrentItem());
            int i2 = C5535c.this.f17850m[0];
            C5547h hVar = (C5547h) C5535c.this.f17848k.get(i2);
            int i3 = (C5535c.this.f17850m[1] * 27) + i;
            if (i3 > hVar.mo27665a().size()) {
                StringBuilder sb = new StringBuilder("index ");
                sb.append(i3);
                sb.append(" larger than size ");
                sb.append(hVar.mo27665a().size());
                C5264a.m21617a("sticker", sb.toString());
                return;
            }
            if (C5535c.this.f17844g != null) {
                List a = hVar.mo27665a();
                int size = a.size();
                if (i == 27 || i3 >= size) {
                    C5535c.this.f17844g.mo27654a("/DEL_CUSTOM");
                } else {
                    String a2 = ((C6046a) a.get(i3)).mo28896a();
                    String str = ".";
                    if (a2.indexOf(str) > 0) {
                        a2 = a2.substring(0, a2.indexOf(str));
                    }
                    StringBuilder sb2 = new StringBuilder("[:");
                    sb2.append(a2);
                    sb2.append("]");
                    String sb3 = sb2.toString();
                    if (!TextUtils.isEmpty(sb3)) {
                        C5535c.this.f17844g.mo27654a(sb3);
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    /* renamed from: c */
    public ViewPager f17840c;
    /* access modifiers changed from: private */
    /* renamed from: d */
    public LinearLayout f17841d;
    /* access modifiers changed from: private */
    /* renamed from: e */
    public int f17842e;
    /* access modifiers changed from: private */
    /* renamed from: f */
    public Context f17843f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public C5542e f17844g;
    /* renamed from: h */
    private C5540a f17845h = new C5540a(this, 0);
    /* renamed from: i */
    private int f17846i;
    /* renamed from: j */
    private boolean f17847j = false;
    /* access modifiers changed from: private */
    /* renamed from: k */
    public List<C5547h> f17848k;
    /* access modifiers changed from: private */
    /* renamed from: l */
    public List<Integer> f17849l;
    /* access modifiers changed from: private */
    /* renamed from: m */
    public int[] f17850m = new int[20];
    /* access modifiers changed from: private */
    /* renamed from: n */
    public C5541d f17851n;
    /* access modifiers changed from: private */
    /* renamed from: o */
    public OnItemClickListener f17852o = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C5535c.this.m22522b(C5535c.this.f17840c.getCurrentItem());
            int i2 = C5535c.this.f17850m[0];
            C5547h hVar = (C5547h) C5535c.this.f17848k.get(i2);
            int i3 = i + (C5535c.this.f17850m[1] << 3);
            if (i3 >= hVar.mo27665a().size()) {
                StringBuilder sb = new StringBuilder("index ");
                sb.append(i3);
                sb.append(" larger than size ");
                sb.append(hVar.mo27665a().size());
                C5264a.m21617a("sticker", sb.toString());
                return;
            }
            if (C5535c.this.f17844g != null) {
                C6046a aVar = (C6046a) hVar.mo27665a().get(i3);
                C5535c.this.f17844g.mo27655a(aVar.mo28896a(), aVar.mo28897b());
            }
        }
    };

    /* renamed from: com.qiyukf.nim.uikit.session.emoji.c$a */
    private class C5540a extends PagerAdapter {
        private C5540a() {
        }

        /* synthetic */ C5540a(C5535c cVar, byte b) {
            this();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final int getCount() {
            if (C5535c.this.f17842e == 0) {
                return 1;
            }
            return C5535c.this.f17842e;
        }

        public final int getItemPosition(Object obj) {
            return -2;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            int i2;
            C5547h hVar;
            GridView gridView;
            if (C5535c.this.f17848k == null || C5535c.this.f17848k.size() <= 0 || C5535c.this.f17849l == null || C5535c.this.f17849l.size() <= 0) {
                hVar = null;
                i2 = 0;
            } else {
                C5535c.this.m22522b(i);
                hVar = (C5547h) C5535c.this.f17848k.get(C5535c.this.f17850m[0]);
                i2 = C5535c.this.f17850m[1];
            }
            if (hVar == null) {
                C5535c.this.f17841d.setVisibility(0);
                GridView gridView2 = new GridView(C5535c.this.f17843f);
                gridView2.setOnItemClickListener(C5535c.this.f17838a);
                gridView2.setAdapter(new C5530a(C5535c.this.f17843f, i * 27));
                gridView2.setNumColumns(7);
                gridView2.setHorizontalSpacing(5);
                gridView2.setVerticalSpacing(5);
                gridView2.setGravity(17);
                gridView2.setSelector(C5961R.C5962drawable.ysf_emoji_item_selector);
                viewGroup.addView(gridView2);
                return gridView2;
            }
            if (hVar.mo27668d() == 2) {
                C5535c.this.f17841d.setVisibility(0);
                gridView = new GridView(C5535c.this.f17843f);
                gridView.setOnItemClickListener(C5535c.this.f17839b);
                gridView.setAdapter(new C5530a(C5535c.this.f17843f, i2 * 27, hVar));
                gridView.setNumColumns(7);
                gridView.setHorizontalSpacing(5);
                gridView.setVerticalSpacing(5);
            } else {
                C5535c.this.f17841d.setVisibility(0);
                gridView = new GridView(C5535c.this.f17843f);
                gridView.setPadding(10, 0, 10, 0);
                gridView.setOnItemClickListener(C5535c.this.f17852o);
                gridView.setAdapter(new C5545g(C5535c.this.f17843f, hVar, i2 << 3));
                gridView.setNumColumns(4);
                gridView.setHorizontalSpacing(5);
            }
            gridView.setGravity(17);
            gridView.setSelector(C5961R.C5962drawable.ysf_emoji_item_selector);
            viewGroup.addView(gridView);
            return gridView;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public C5535c(Context context, C5542e eVar, ViewPager viewPager, LinearLayout linearLayout) {
        this.f17843f = context.getApplicationContext();
        this.f17844g = eVar;
        this.f17841d = linearLayout;
        this.f17840c = viewPager;
        this.f17840c.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                if (C5535c.this.f17848k != null) {
                    C5535c.this.m22523c(i);
                    if (C5535c.this.f17851n != null) {
                        C5535c.this.f17851n.mo27628a(C5535c.this.f17850m[0]);
                    }
                } else {
                    C5535c.this.m22518a(i, C5535c.this.f17842e);
                }
            }
        });
        this.f17840c.setAdapter(this.f17845h);
        this.f17840c.setOffscreenPageLimit(1);
    }

    /* renamed from: a */
    private static int m22516a(C5547h hVar) {
        int size;
        float size2;
        float f = 27.0f;
        if (hVar == null) {
            size = C5531b.m22508a();
        } else if (!hVar.mo27666b()) {
            return 1;
        } else {
            List a = hVar.mo27665a();
            if (hVar.mo27668d() == 1) {
                size2 = (float) a.size();
                f = 8.0f;
                return (int) Math.ceil((double) (size2 / f));
            }
            size = a.size();
        }
        size2 = (float) size;
        return (int) Math.ceil((double) (size2 / f));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0054  */
    /* renamed from: a */
    public void m22518a(int r9, int r10) {
        /*
        r8 = this;
        android.widget.LinearLayout r0 = r8.f17841d
        int r0 = r0.getChildCount()
        int r1 = java.lang.Math.max(r0, r10)
        r2 = 0
        r3 = 0
    L_0x000c:
        if (r3 >= r1) goto L_0x005e
        if (r10 > r0) goto L_0x001e
        if (r3 < r10) goto L_0x0020
        android.widget.LinearLayout r4 = r8.f17841d
        android.view.View r4 = r4.getChildAt(r3)
        r5 = 8
        r4.setVisibility(r5)
        goto L_0x005b
    L_0x001e:
        if (r3 >= r0) goto L_0x0029
    L_0x0020:
        android.widget.LinearLayout r4 = r8.f17841d
        android.view.View r4 = r4.getChildAt(r3)
        android.widget.ImageView r4 = (android.widget.ImageView) r4
        goto L_0x004d
    L_0x0029:
        android.widget.ImageView r4 = new android.widget.ImageView
        android.content.Context r5 = r8.f17843f
        r4.<init>(r5)
        int r5 = com.qiyukf.unicorn.C5961R.C5962drawable.ysf_view_pager_indicator_selector
        r4.setBackgroundResource(r5)
        android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
        r6 = -2
        r5.<init>(r6, r6)
        r6 = 1073741824(0x40000000, float:2.0)
        int r7 = com.qiyukf.basesdk.p412c.p417d.C5412d.m22146a(r6)
        int r6 = com.qiyukf.basesdk.p412c.p417d.C5412d.m22146a(r6)
        r5.setMargins(r7, r2, r6, r2)
        android.widget.LinearLayout r6 = r8.f17841d
        r6.addView(r4, r5)
    L_0x004d:
        r4.setId(r3)
        if (r3 != r9) goto L_0x0054
        r5 = 1
        goto L_0x0055
    L_0x0054:
        r5 = 0
    L_0x0055:
        r4.setSelected(r5)
        r4.setVisibility(r2)
    L_0x005b:
        int r3 = r3 + 1
        goto L_0x000c
    L_0x005e:
        return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.emoji.C5535c.m22518a(int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int[] m22522b(int i) {
        if (this.f17848k == null || this.f17849l == null) {
            return this.f17850m;
        }
        int i2 = this.f17846i;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= this.f17849l.size()) {
                break;
            }
            int intValue = ((Integer) this.f17849l.get(i3)).intValue() + i4;
            if (i < intValue) {
                i2 = i3;
                break;
            }
            i3++;
            i4 = intValue;
        }
        int[] iArr = this.f17850m;
        iArr[0] = i2;
        iArr[1] = i - i4;
        return iArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m22523c(int i) {
        m22522b(i);
        int[] iArr = this.f17850m;
        m22518a(iArr[1], ((Integer) this.f17849l.get(iArr[0])).intValue());
    }

    /* renamed from: a */
    public final void mo27648a() {
        this.f17845h.notifyDataSetChanged();
    }

    /* renamed from: a */
    public final void mo27649a(int i) {
        if (this.f17847j && m22522b(this.f17840c.getCurrentItem()) != null) {
            int[] iArr = this.f17850m;
            if (iArr[0] == i && iArr[1] == 0) {
                return;
            }
        }
        this.f17846i = i;
        C5548i a = C5548i.m22560a();
        if (!this.f17847j || a.mo27676e()) {
            if (this.f17848k == null) {
                this.f17848k = new ArrayList();
            }
            if (this.f17849l == null) {
                this.f17849l = new ArrayList();
            }
            this.f17848k.clear();
            this.f17849l.clear();
            if (a.mo27675d()) {
                this.f17848k.add(null);
                this.f17849l.add(Integer.valueOf(m22516a((C5547h) null)));
            }
            List<C5547h> c = a.mo27674c();
            this.f17848k.addAll(c);
            for (C5547h a2 : c) {
                this.f17849l.add(Integer.valueOf(m22516a(a2)));
            }
            this.f17842e = 0;
            for (Integer intValue : this.f17849l) {
                this.f17842e += intValue.intValue();
            }
            a.mo27677f();
            this.f17847j = true;
        }
        this.f17845h.notifyDataSetChanged();
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f17849l.size() && i2 != this.f17846i) {
            i3 += ((Integer) this.f17849l.get(i2)).intValue();
            i2++;
        }
        m22523c(i3);
        this.f17840c.setCurrentItem(i3, false);
    }

    /* renamed from: a */
    public final void mo27650a(C5541d dVar) {
        this.f17851n = dVar;
    }
}
