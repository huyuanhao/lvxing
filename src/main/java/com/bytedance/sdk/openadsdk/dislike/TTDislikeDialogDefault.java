package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.p170d.MaterialMeta;
import com.bytedance.sdk.openadsdk.utils.ResourceHelp;
import com.bytedance.sdk.openadsdk.utils.UIUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.dislike.c */
public class TTDislikeDialogDefault extends TTDislikeDialogAbstract {
    /* renamed from: a */
    private TTDislikeListView f8504a;
    /* renamed from: b */
    private TTDislikeListView f8505b;
    /* renamed from: c */
    private RelativeLayout f8506c;
    /* renamed from: d */
    private View f8507d;
    /* renamed from: e */
    private C2394b f8508e;
    /* renamed from: f */
    private C2394b f8509f;
    /* access modifiers changed from: private */
    /* renamed from: g */
    public MaterialMeta f8510g;
    /* access modifiers changed from: private */
    /* renamed from: h */
    public C2393a f8511h;

    /* compiled from: TTDislikeDialogDefault */
    /* renamed from: com.bytedance.sdk.openadsdk.dislike.c$a */
    public interface C2393a {
        /* renamed from: a */
        void mo16454a();

        /* renamed from: a */
        void mo16455a(int i, FilterWord filterWord);

        /* renamed from: b */
        void mo16456b();

        /* renamed from: c */
        void mo16457c();
    }

    /* compiled from: TTDislikeDialogDefault */
    /* renamed from: com.bytedance.sdk.openadsdk.dislike.c$b */
    public static class C2394b extends BaseAdapter {
        /* renamed from: a */
        private boolean f8517a = true;
        /* renamed from: b */
        private final List<FilterWord> f8518b;
        /* renamed from: c */
        private final LayoutInflater f8519c;

        /* compiled from: TTDislikeDialogDefault */
        /* renamed from: com.bytedance.sdk.openadsdk.dislike.c$b$a */
        private static class C2395a {
            /* renamed from: a */
            TextView f8520a;
            /* renamed from: b */
            ImageView f8521b;

            private C2395a() {
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public C2394b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f8518b = list;
            this.f8519c = layoutInflater;
        }

        /* renamed from: a */
        public void mo16468a(boolean z) {
            this.f8517a = z;
        }

        public int getCount() {
            List<FilterWord> list = this.f8518b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public Object getItem(int i) {
            return this.f8518b.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            C2395a aVar;
            if (view == null) {
                aVar = new C2395a();
                LayoutInflater layoutInflater = this.f8519c;
                view2 = layoutInflater.inflate(ResourceHelp.m11936f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f8520a = (TextView) view2.findViewById(ResourceHelp.m11935e(this.f8519c.getContext(), "tt_item_tv"));
                aVar.f8521b = (ImageView) view2.findViewById(ResourceHelp.m11935e(this.f8519c.getContext(), "tt_item_arrow"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (C2395a) view.getTag();
            }
            FilterWord filterWord = (FilterWord) this.f8518b.get(i);
            aVar.f8520a.setText(filterWord.getName());
            if (i != this.f8518b.size() - 1) {
                aVar.f8520a.setBackgroundResource(ResourceHelp.m11934d(this.f8519c.getContext(), "tt_dislike_middle_seletor"));
            } else {
                aVar.f8520a.setBackgroundResource(ResourceHelp.m11934d(this.f8519c.getContext(), "tt_dislike_bottom_seletor"));
            }
            if (this.f8517a && i == 0) {
                aVar.f8520a.setBackgroundResource(ResourceHelp.m11934d(this.f8519c.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f8521b.setVisibility(0);
            } else {
                aVar.f8521b.setVisibility(8);
            }
            return view2;
        }

        /* renamed from: a */
        public void mo16467a(List<FilterWord> list) {
            if (list != null && !list.isEmpty()) {
                this.f8518b.clear();
                this.f8518b.addAll(list);
                notifyDataSetChanged();
            }
        }

        /* renamed from: a */
        public void mo16466a() {
            this.f8518b.clear();
            notifyDataSetChanged();
        }
    }

    public TTDislikeDialogDefault(Context context, MaterialMeta kVar) {
        super(context, ResourceHelp.m11937g(context, "tt_dislikeDialog"));
        this.f8510g = kVar;
    }

    /* renamed from: a */
    public void mo16458a(MaterialMeta kVar) {
        C2394b bVar = this.f8508e;
        if (bVar != null && kVar != null) {
            this.f8510g = kVar;
            bVar.mo16467a(this.f8510g.mo15430R());
            setMaterialMeta(this.f8510g);
        }
    }

    /* renamed from: a */
    public void mo16459a(C2393a aVar) {
        this.f8511h = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        m11054a();
        m11055a(getContext());
        m11058b();
        setMaterialMeta(this.f8510g);
    }

    public int getLayoutId() {
        return ResourceHelp.m11936f(getContext(), "tt_dislike_dialog_layout");
    }

    public int[] getTTDislikeListViewIds() {
        return new int[]{ResourceHelp.m11935e(getContext(), "tt_filer_words_lv"), ResourceHelp.m11935e(getContext(), "tt_filer_words_lv_second")};
    }

    public LayoutParams getLayoutParams() {
        return new LayoutParams(UIUtils.m12078c(getContext()) - 120, -2);
    }

    public void show() {
        super.show();
        m11061c();
    }

    /* renamed from: a */
    private void m11054a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = 50;
            window.setAttributes(attributes);
        }
    }

    /* renamed from: b */
    private void m11058b() {
        setOnShowListener(new OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                if (TTDislikeDialogDefault.this.f8511h != null) {
                    TTDislikeDialogDefault.this.f8511h.mo16454a();
                }
            }
        });
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (TTDislikeDialogDefault.this.f8511h != null) {
                    TTDislikeDialogDefault.this.f8511h.mo16456b();
                }
            }
        });
        this.f8508e = new C2394b(getLayoutInflater(), this.f8510g.mo15430R());
        this.f8504a.setAdapter(this.f8508e);
        this.f8509f = new C2394b(getLayoutInflater(), new ArrayList());
        this.f8509f.mo16468a(false);
        this.f8505b.setAdapter(this.f8509f);
    }

    /* renamed from: a */
    private void m11055a(Context context) {
        this.f8506c = (RelativeLayout) findViewById(ResourceHelp.m11935e(getContext(), "tt_dislike_title_content"));
        this.f8507d = findViewById(ResourceHelp.m11935e(getContext(), "tt_dislike_line1"));
        findViewById(ResourceHelp.m11935e(getContext(), "tt_dislike_header_back")).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TTDislikeDialogDefault.this.m11061c();
                if (TTDislikeDialogDefault.this.f8511h != null) {
                    TTDislikeDialogDefault.this.f8511h.mo16457c();
                }
            }
        });
        this.f8504a = (TTDislikeListView) findViewById(ResourceHelp.m11935e(getContext(), "tt_filer_words_lv"));
        this.f8504a.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                try {
                    FilterWord filterWord = (FilterWord) adapterView.getAdapter().getItem(i);
                    if (filterWord.hasSecondOptions()) {
                        TTDislikeDialogDefault.this.m11056a(filterWord);
                        if (TTDislikeDialogDefault.this.f8511h != null) {
                            TTDislikeDialogDefault.this.f8511h.mo16455a(i, filterWord);
                        }
                        return;
                    }
                } catch (Throwable unused) {
                }
                if (TTDislikeDialogDefault.this.f8511h != null) {
                    try {
                        TTDislikeDialogDefault.this.f8511h.mo16455a(i, (FilterWord) TTDislikeDialogDefault.this.f8510g.mo15430R().get(i));
                    } catch (Throwable unused2) {
                    }
                }
                TTDislikeDialogDefault.this.dismiss();
            }
        });
        this.f8505b = (TTDislikeListView) findViewById(ResourceHelp.m11935e(getContext(), "tt_filer_words_lv_second"));
        this.f8505b.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeDialogDefault.this.f8511h != null) {
                    try {
                        TTDislikeDialogDefault.this.f8511h.mo16455a(i, (FilterWord) adapterView.getAdapter().getItem(i));
                    } catch (Throwable unused) {
                    }
                }
                TTDislikeDialogDefault.this.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11061c() {
        RelativeLayout relativeLayout = this.f8506c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        View view = this.f8507d;
        if (view != null) {
            view.setVisibility(8);
        }
        TTDislikeListView tTDislikeListView = this.f8504a;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
        C2394b bVar = this.f8509f;
        if (bVar != null) {
            bVar.mo16466a();
        }
        TTDislikeListView tTDislikeListView2 = this.f8505b;
        if (tTDislikeListView2 != null) {
            tTDislikeListView2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11056a(FilterWord filterWord) {
        if (filterWord != null) {
            C2394b bVar = this.f8509f;
            if (bVar != null) {
                bVar.mo16467a(filterWord.getOptions());
            }
            RelativeLayout relativeLayout = this.f8506c;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            View view = this.f8507d;
            if (view != null) {
                view.setVisibility(0);
            }
            TTDislikeListView tTDislikeListView = this.f8504a;
            if (tTDislikeListView != null) {
                tTDislikeListView.setVisibility(8);
            }
            TTDislikeListView tTDislikeListView2 = this.f8505b;
            if (tTDislikeListView2 != null) {
                tTDislikeListView2.setVisibility(0);
            }
        }
    }
}
