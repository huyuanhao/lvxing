package com.p368pw.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.p368pw.inner.appwall.C4970aa;
import com.p368pw.inner.appwall.C4970aa.C4978a;
import com.p368pw.inner.appwall.C4981ac;
import com.p368pw.inner.appwall.C4990b;
import com.p368pw.inner.appwall.C4996c;
import com.p368pw.inner.appwall.C5004g;
import com.p368pw.inner.appwall.C5005h;
import com.p368pw.inner.appwall.C5015j.C5024e;
import com.p368pw.inner.appwall.C5015j.C5025f;
import com.p368pw.inner.appwall.C5015j.C5026g;
import com.p368pw.inner.appwall.C5030k;
import com.p368pw.inner.appwall.C5034m;
import com.p368pw.inner.appwall.C5035n;
import com.p368pw.inner.appwall.C5035n.C5038a;
import com.p368pw.inner.appwall.C5041p.C5042a;
import com.p368pw.inner.appwall.C5046s;
import com.p368pw.inner.appwall.C5047t;
import com.p368pw.inner.appwall.C5048u;
import com.p368pw.inner.appwall.C5048u.C5052b;
import com.p368pw.inner.appwall.C5055x;
import com.p368pw.inner.appwall.C5055x.C5058a;
import com.p368pw.inner.appwall.C5055x.C5059b;
import com.p368pw.inner.base.p384a.C5125f;
import com.p368pw.inner.base.p385b.C5138c;
import com.p368pw.inner.base.p387d.C5187e;
import com.p368pw.inner.base.p387d.C5188f;
import com.p368pw.inner.base.p387d.C5192j;
import com.p368pw.inner.base.p387d.C5204n;
import com.p368pw.inner.base.p387d.C5205o;
import com.p368pw.inner.base.p387d.C5207q;
import com.p368pw.inner.base.p387d.C5208r;
import com.p368pw.inner.base.p387d.C5211s;
import com.p368pw.inner.base.p387d.p388a.C5153c;
import com.p368pw.inner.base.p387d.p388a.C5153c.C5157a;
import com.pw.R;
import com.tmsdk.module.coin.ErrorCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.pw.view.AppWallActivity */
public class AppWallActivity extends Activity {
    public static final String AD_DATA = "ad_data";
    private static final int REQUEST_CODE_READ = 291;
    /* access modifiers changed from: private */
    public List<C5138c> bannerList;
    /* access modifiers changed from: private */
    public C5138c clickOurAdBean;
    /* access modifiers changed from: private */
    public boolean gotoSetPermission;
    /* access modifiers changed from: private */
    public List<C5034m> guessList;
    /* access modifiers changed from: private */
    public List<C5034m> hotList;
    private boolean isResume;
    private C5038a mAppWallBoardListener = new C5038a() {
        public void onInstalled(C5034m mVar) {
            C5205o.m21462a("aw act bd install");
            C5004g.m20946a().mo26397b(mVar, 2);
        }

        public void onRefresh() {
            C5205o.m21462a("aw act bd fresh");
            AppWallActivity.this.handleRefresh();
        }
    };
    private C4978a mAppWallMngListener = new C4978a() {
        public void onActivate(String str) {
            if (AppWallActivity.this.mNextStepBean != null && str != null && str.equals(AppWallActivity.this.mNextStepBean.mo26542d().mo26466a().mo26743a())) {
                AppWallActivity.this.mNextStepBean = null;
            }
        }

        public void onInstallStart(C5047t tVar) {
            AppWallActivity.this.mNextStepBean = tVar;
        }

        public void onInstalled() {
            AppWallActivity.this.handleRefresh();
        }

        public void onOfferDialogDismiss() {
            if (AppWallActivity.this.mNeedRefresh) {
                AppWallActivity.this.mNeedRefresh = false;
                AppWallActivity.this.loadAdData(false);
            }
        }

        public void onRefresh() {
            AppWallActivity.this.handleRefresh();
        }
    };
    /* access modifiers changed from: private */
    public AppWallView mAppWallView;
    private C5047t mClickBean;
    private ColorDrawable mColorDrawable;
    private List<Pair<String, C5157a>> mDownloadingListener = new ArrayList();
    /* access modifiers changed from: private */
    public boolean mNeedRefresh;
    /* access modifiers changed from: private */
    public C5047t mNextStepBean;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, Integer> mProgressRecorder = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public C5138c mSettingOurAdBean;
    private TextView mTitleView;
    /* access modifiers changed from: private */
    public List<C5034m> signList;

    private void clearListener() {
        for (Pair pair : this.mDownloadingListener) {
            C5153c.m21275a().mo26764b((String) pair.first, (C5157a) pair.second);
        }
    }

    private void handleNextStepDialog() {
        final C5047t tVar = this.mNextStepBean;
        if (tVar != null) {
            this.mNextStepBean = null;
            double d = this.mSettingOurAdBean.f16796y;
            if (tVar.mo26540b() == 2) {
                C5042a d2 = tVar.mo26542d().mo26469d();
                if (d2 != null) {
                    d = d2.mo26479a(C4970aa.m20784a().mo26333e());
                }
            }
            C5048u a = C5046s.m21064a(this, "完成安装任务并打开，\n获得高额奖励！", d, this.mSettingOurAdBean.f16769D);
            a.mo26546a((C5052b) new C5052b() {
                public void onClick() {
                    AppWallActivity.this.handlerItemClick(tVar, false);
                }

                public void onDismiss() {
                }
            });
            if (!isFinishing()) {
                a.show();
            }
        }
    }

    private boolean handlePermission(C5034m mVar) {
        C5042a d = mVar.mo26469d();
        if (d == null || d.mo26480a() != 1 || C4970aa.m20789a((Context) this)) {
            return false;
        }
        C5138c a = mVar.mo26466a();
        C4981ac acVar = new C4981ac(this);
        acVar.setOwnerActivity(this);
        acVar.mo26354a((OnClickListener) new OnClickListener() {
            public void onClick(View view) {
                AppWallActivity.this.gotoSetPermission = true;
                AppWallActivity.this.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
            }
        });
        acVar.show();
        C4970aa.m20784a().mo26313a((int) ErrorCode.ERC_TASK_CHECK_FAIL, a);
        return true;
    }

    /* access modifiers changed from: private */
    public void handleRefresh() {
        if (this.isResume) {
            this.mNeedRefresh = false;
            loadAdData(false);
            return;
        }
        this.mNeedRefresh = true;
    }

    /* access modifiers changed from: private */
    public void handlerSurpriseDialog(C5047t tVar) {
        if (tVar != null) {
            try {
                if (C5125f.m21216a().mo26728e().mo26458y() == 1) {
                    final C5047t tVar2 = (C5047t) C5204n.m21459a(C5204n.m21460a(tVar), C5047t.class);
                    tVar2.mo26542d().mo26466a().f16783l = 5;
                    C4970aa.m20784a().mo26313a(3, tVar2.mo26542d().mo26466a());
                    C5055x a = new C5058a(this).mo26561a(C4970aa.m20784a().mo26328b(tVar2)).mo26562a();
                    a.mo26558a((C5059b) new C5059b() {
                        public void onClick() {
                            AppWallActivity.this.handlerItemClick(tVar2, true);
                        }

                        public void onDismiss() {
                        }
                    });
                    a.show();
                }
            } catch (Throwable th) {
                C5205o.m21464a(th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void initListener(List<C5047t> list) {
        clearListener();
        this.mDownloadingListener.clear();
        if (list != null && !list.isEmpty()) {
            for (final int i = 0; i < list.size(); i++) {
                C5034m d = ((C5047t) list.get(i)).mo26542d();
                if (d != null) {
                    final String a = d.mo26466a().mo26743a();
                    if (!TextUtils.isEmpty(a)) {
                        C524413 r2 = new C5157a() {
                            public void onComplete(String str, String str2) {
                                if (AppWallActivity.this.mAppWallView != null) {
                                    AppWallActivity.this.mAppWallView.notifyItemChanged(i, Integer.valueOf(100));
                                }
                                AppWallActivity.this.mProgressRecorder.remove(str);
                            }

                            public void onProgress(int i) {
                                if (AppWallActivity.this.mAppWallView != null) {
                                    Integer num = (Integer) AppWallActivity.this.mProgressRecorder.get(a);
                                    if (num == null) {
                                        AppWallActivity.this.mProgressRecorder.put(a, Integer.valueOf(0));
                                        AppWallActivity.this.mAppWallView.notifyItemChanged(i, Integer.valueOf(i));
                                    } else if (num.intValue() != i) {
                                        AppWallActivity.this.mProgressRecorder.put(a, Integer.valueOf(i));
                                        AppWallActivity.this.mAppWallView.notifyItemChanged(i, Integer.valueOf(i));
                                    }
                                }
                            }
                        };
                        this.mDownloadingListener.add(new Pair(a, r2));
                        C5153c.m21275a().mo26763a(a, (C5157a) r2);
                    }
                }
            }
        }
    }

    private void initView() {
        C5030k e = C5125f.m21216a().mo26728e();
        C5207q.m21474a(e.mo26438e(), "精选热门应用");
        C5207q.m21474a(e.mo26439f(), "下载试玩应用得奖励，应用官方已认证\n请放心下载。");
    }

    /* access modifiers changed from: private */
    public void loadAdData(final boolean z) {
        if (!isFinishing()) {
            C5205o.m21462a("开始加载应用墙列表数据");
            C5208r.m21482b(new Runnable() {
                public void run() {
                    boolean z;
                    String str = "load";
                    try {
                        C5192j.m21424a(str);
                        Context applicationContext = AppWallActivity.this.getApplicationContext();
                        if (z) {
                            C4996c.m20913a().mo26383a(1, null, AppWallActivity.this.mSettingOurAdBean);
                            AppWallActivity.this.mSettingOurAdBean.f16783l = 1;
                            C4970aa.m20784a().mo26313a(1, AppWallActivity.this.mSettingOurAdBean);
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        C5005h.m20951a().mo26408a((List<C5034m>) arrayList2, (List<C5034m>) arrayList, (List<C5138c>) arrayList3, AppWallActivity.this.mSettingOurAdBean.f16787p);
                        AppWallActivity.this.setSomeField(arrayList2, false);
                        AppWallActivity.this.setSomeField(arrayList, false);
                        List a = C4990b.m20867a().mo26374a(applicationContext, AppWallActivity.this.mSettingOurAdBean.f16787p, AppWallActivity.this.mSettingOurAdBean.f16795x);
                        AppWallActivity.this.setSomeField(a, true);
                        C5005h.m20951a().mo26403a(applicationContext, (List<C5034m>) arrayList2, (List<C5034m>) arrayList, a, AppWallActivity.this.mSettingOurAdBean.f16787p);
                        boolean b = C5188f.m21379b(arrayList2);
                        boolean b2 = C5188f.m21379b(arrayList);
                        boolean b3 = C5188f.m21379b(a);
                        boolean b4 = C5188f.m21379b(arrayList3);
                        if (b) {
                            if (z) {
                                C4996c.m20913a().mo26383a(2, (List<C5034m>) arrayList2, AppWallActivity.this.mSettingOurAdBean);
                            }
                            C4996c.m20913a().mo26386a((List<C5034m>) arrayList2);
                        }
                        if (b2) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                C5138c a2 = ((C5034m) it.next()).mo26466a();
                                if (a2 != null) {
                                    if (C4970aa.m20784a().mo26330b(a2.mo26743a())) {
                                        it.remove();
                                    }
                                }
                            }
                            if (z) {
                                C4970aa.m20784a().mo26323a(AppWallActivity.this.mSettingOurAdBean, (List<C5034m>) arrayList);
                                int size = arrayList.size();
                                int i = 0;
                                while (i < size) {
                                    C5034m mVar = (C5034m) arrayList.get(i);
                                    int i2 = size;
                                    C4970aa.m20784a().mo26313a(3, mVar.mo26466a());
                                    C4970aa.m20784a().mo26313a(4, mVar.mo26466a());
                                    i++;
                                    size = i2;
                                }
                            }
                        }
                        if (b4) {
                            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                                C4970aa.m20784a().mo26313a(3, (C5138c) arrayList3.get(i3));
                            }
                        }
                        C4990b.m20867a().mo26379a(applicationContext, a);
                        AppWallActivity.this.guessList = arrayList;
                        AppWallActivity.this.hotList = a;
                        AppWallActivity.this.signList = arrayList2;
                        AppWallActivity.this.bannerList = arrayList3;
                        if (!b4 && !b3 && !b2) {
                            if (!b) {
                                z = false;
                                List a3 = C4970aa.m20784a().mo26312a((List<C5138c>) arrayList3, (List<C5034m>) arrayList, a, (List<C5034m>) arrayList2, false);
                                C5047t a4 = C4970aa.m20784a().mo26311a(a3);
                                AppWallActivity.this.initListener(a3);
                                AppWallActivity.this.showDataIntoList(z, z, a3, a4);
                                C5192j.m21425b(str);
                            }
                        }
                        z = true;
                        List a32 = C4970aa.m20784a().mo26312a((List<C5138c>) arrayList3, (List<C5034m>) arrayList, a, (List<C5034m>) arrayList2, false);
                        C5047t a42 = C4970aa.m20784a().mo26311a(a32);
                        AppWallActivity.this.initListener(a32);
                        AppWallActivity.this.showDataIntoList(z, z, a32, a42);
                        C5192j.m21425b(str);
                    } catch (Throwable th) {
                        C5205o.m21464a(th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setSomeField(List<C5034m> list, boolean z) {
        if (!C5188f.m21377a((Collection) list)) {
            for (int i = 0; i < list.size(); i++) {
                C5138c a = ((C5034m) list.get(i)).mo26466a();
                a.f16785n = z ? 5 : 8;
                a.f16795x = this.mSettingOurAdBean.f16795x;
                a.f16787p = this.mSettingOurAdBean.f16787p;
                a.f16788q = this.mSettingOurAdBean.f16788q;
                a.f16789r = this.mSettingOurAdBean.f16789r;
                a.f16769D = this.mSettingOurAdBean.f16769D;
            }
        }
    }

    private void setTitleView(String str) {
        TextView textView;
        String str2;
        if (this.mTitleView == null) {
            this.mTitleView = (TextView) findViewById(R.id.win_app_wall_title);
        }
        if (TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(this.mSettingOurAdBean.f16766A)) {
                textView = this.mTitleView;
                str2 = this.mSettingOurAdBean.f16766A;
            } else {
                textView = this.mTitleView;
                str2 = "应用墙";
            }
            textView.setText(str2);
            return;
        }
        this.mTitleView.setText(str);
    }

    /* access modifiers changed from: private */
    public void showDataIntoList(boolean z, boolean z2, List<C5047t> list, C5047t tVar) {
        final boolean z3 = z;
        final boolean z4 = z2;
        final C5047t tVar2 = tVar;
        final List<C5047t> list2 = list;
        C524312 r0 = new Runnable() {
            public void run() {
                if (!AppWallActivity.this.isFinishing()) {
                    if (z3) {
                        if (z4) {
                            C5047t tVar = tVar2;
                            if (tVar != null) {
                                AppWallActivity.this.handlerSurpriseDialog(tVar);
                            }
                        }
                        AppWallActivity.this.mAppWallView.showAppList(true);
                        AppWallActivity.this.mAppWallView.showEmptyView(false);
                        AppWallActivity.this.mAppWallView.setData(list2, AppWallActivity.this.bannerList);
                    } else {
                        AppWallActivity.this.mAppWallView.showAppList(false);
                        AppWallActivity.this.mAppWallView.showEmptyView(true);
                    }
                }
            }
        };
        C5208r.m21479a(r0);
    }

    private void showToast(String str, int i) {
        C5211s.m21484a(getApplicationContext(), str, i);
    }

    public void handlerItemClick(C5047t tVar, boolean z) {
        this.mClickBean = tVar;
        C5034m d = tVar.mo26542d();
        int b = tVar.mo26540b();
        C5138c a = d.mo26466a();
        if (z) {
            if (b == 1) {
                C4990b.m20867a().mo26375a(getApplicationContext(), d);
            } else {
                C4970aa.m20784a().mo26313a(5, a);
            }
        }
        if (b == 2) {
            if (!handlePermission(d)) {
                C4996c.m20913a().mo26384a(getApplicationContext(), d);
            }
        } else if (b == 1) {
            showToast(C5125f.m21216a().mo26728e().mo26456w(), 1);
            C4970aa.m20784a().mo26315a(getApplicationContext(), tVar);
            handlePermission(d);
        } else if (b == 3 && !handlePermission(d)) {
            C4970aa.m20784a().mo26315a(getApplicationContext(), tVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == REQUEST_CODE_READ && this.clickOurAdBean != null && intent != null && intent.getBooleanExtra(ReadActivity.INTENT_DATA_FINISH_TASK, false)) {
            C4970aa.m20784a().mo26321a(this.clickOurAdBean);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.win_sdk_activity_app_wall);
        try {
            C5187e.m21369a();
            this.mSettingOurAdBean = (C5138c) getIntent().getSerializableExtra(AD_DATA);
            this.mColorDrawable = new ColorDrawable();
            this.mAppWallView = (AppWallView) findViewById(R.id.appWallView);
            this.mAppWallView.setAppWallInfo(this.mSettingOurAdBean.f16796y, this.mSettingOurAdBean.f16797z, this.mSettingOurAdBean.f16768C, this.mSettingOurAdBean.f16769D);
            this.mColorDrawable.setColor(this.mSettingOurAdBean.f16768C);
            findViewById(R.id.win_app_wall_layout).setBackground(this.mColorDrawable);
            ImageView imageView = (ImageView) findViewById(R.id.win_app_wall_back);
            if (this.mSettingOurAdBean.f16767B > 0) {
                imageView.setImageResource(this.mSettingOurAdBean.f16767B);
            }
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    AppWallActivity.this.finish();
                }
            });
            setTitleView(null);
            this.mAppWallView.setOnItemClickListener(new C5025f() {
                public void onClick(int i, C5047t tVar) {
                    AppWallActivity.this.handlerItemClick(tVar, true);
                }
            });
            this.mAppWallView.setOnMoreClickListener(new C5026g() {
                public void onClick(int i, C5047t tVar) {
                    AppWallActivity.this.mAppWallView.setData(C4970aa.m20784a().mo26312a(AppWallActivity.this.bannerList, AppWallActivity.this.guessList, AppWallActivity.this.hotList, AppWallActivity.this.signList, true), AppWallActivity.this.bannerList);
                }
            });
            this.mAppWallView.setOnBannerItemClickListener(new C5024e() {
                public void onItemClick(C5138c cVar) {
                    AppWallActivity.this.clickOurAdBean = cVar;
                    C4970aa.m20784a().mo26313a(5, AppWallActivity.this.clickOurAdBean);
                    ReadActivity.start(AppWallActivity.this, AppWallActivity.REQUEST_CODE_READ, cVar.f16779h, cVar.f16775d, cVar.f16780i);
                }
            });
            this.mAppWallView.setOnRefreshClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(AppWallActivity.this, "加载中", 0).show();
                    AppWallActivity.this.handleRefresh();
                }
            });
            initView();
            C4970aa.m20784a().mo26325a(this);
            C4970aa.m20784a().mo26318a(this.mAppWallMngListener);
            loadAdData(true);
            C5035n.m21025a().mo26471a(getApplicationContext(), this.mAppWallBoardListener);
            C4970aa.m20784a().mo26327a(true);
            C4970aa.m20784a().mo26332d().getAppwallListener().onShowed();
        } catch (Throwable th) {
            C5205o.m21464a(th);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        clearListener();
        C4970aa.m20784a().mo26335g();
        C4970aa.m20784a().mo26327a(false);
        C5035n.m21025a().mo26473b();
        C4990b.m20867a().mo26381b();
        C4996c.m20913a().mo26387b();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.isResume = false;
        this.mAppWallView.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppWallView appWallView = this.mAppWallView;
        if (appWallView != null) {
            appWallView.onResume();
        }
        this.isResume = true;
        if (!this.gotoSetPermission || this.mClickBean == null) {
            this.mClickBean = null;
            handleNextStepDialog();
            C5004g.m20946a().mo26396b();
            if (this.mNeedRefresh) {
                this.mNeedRefresh = false;
                loadAdData(false);
            }
            return;
        }
        this.gotoSetPermission = false;
        if (!C4970aa.m20789a(getApplicationContext())) {
            C5211s.m21484a(this, "没有设置完成，可能无法获取奖励", 0);
            handlePermission(this.mClickBean.mo26542d());
        } else {
            C4970aa.m20784a().mo26313a(10, this.mClickBean.mo26542d().mo26466a());
            handlerItemClick(this.mClickBean, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        C5004g.m20946a().mo26398c();
    }
}
