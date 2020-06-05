package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.C7127a;
import com.tencent.bugly.beta.global.C7131e;
import com.tencent.bugly.beta.p602ui.C7146e;
import com.tencent.bugly.beta.p602ui.C7148g;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.tinker.TinkerManager.TinkerListener;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.Iterator;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.r */
public class C7273r {
    /* renamed from: a */
    public static synchronized void m31419a(Context context) {
        Context context2 = context;
        synchronized (C7273r.class) {
            final C7131e eVar = C7131e.f23698E;
            String absolutePath = context2.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
            String absolutePath2 = context2.getDir("tmpPatch", 32768).getAbsolutePath();
            eVar.f23705G = new File(absolutePath, TinkerManager.PATCH_NAME);
            if (TextUtils.isEmpty(C7127a.m30555b("PatchFile", ""))) {
                C7127a.m30547a("PatchFile", eVar.f23705G.getAbsolutePath());
            }
            eVar.f23706H = new File(absolutePath2, "tmpPatch.apk");
            if (eVar.f23705G != null && TextUtils.isEmpty(C7127a.m30555b("PatchFile", ""))) {
                C7127a.m30547a("PatchFile", eVar.f23705G.getAbsolutePath());
            }
            eVar.f23707I = context2.getDir("tmpPatch", 0);
            if (eVar.f23707I != null && TextUtils.isEmpty(C7127a.m30555b("PatchTmpDir", ""))) {
                C7127a.m30547a("PatchTmpDir", eVar.f23705G.getAbsolutePath());
            }
            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C7127a.m30544a("st.bch", BetaGrayStrategy.CREATOR);
            if (betaGrayStrategy == null || betaGrayStrategy.f23818a == null || betaGrayStrategy.f23818a.f24668p != 3) {
                if (TinkerManager.getInstance().getPatchDirectory(eVar.f23747s) != null && !TinkerManager.getInstance().getPatchDirectory(eVar.f23747s).exists()) {
                    C7127a.m30548a("IS_PATCH_ROLL_BACK", false);
                }
                if (C7127a.m30556b("IS_PATCH_ROLL_BACK", false)) {
                    TinkerManager.getInstance().onPatchRollback(false);
                }
            } else {
                if (betaGrayStrategy.f23818a.f24664l != null) {
                    eVar.f23711M = (String) betaGrayStrategy.f23818a.f24664l.get("H2");
                }
                eVar.f23712N = C7127a.m30556b("PatchResult", false);
                eVar.f23713O = Integer.valueOf(C7127a.m30555b("PATCH_MAX_TIMES", "0")).intValue();
                if (!eVar.f23712N) {
                    C7226an.m31141a("[patch] inject failure", new Object[0]);
                    if (!C7127a.m30556b("UPLOAD_PATCH_RESULT", false)) {
                        C7127a.m30548a("UPLOAD_PATCH_RESULT", true);
                        C7270p pVar = C7270p.f24600a;
                        C7280w wVar = r7;
                        C7280w wVar2 = new C7280w("active", System.currentTimeMillis(), 1, 0, null, betaGrayStrategy.f23818a.f24665m, betaGrayStrategy.f23818a.f24668p, null);
                        if (pVar.mo34953a(wVar)) {
                            C7226an.m31141a("save patch failed event success!", new Object[0]);
                        } else {
                            C7226an.m31149e("save patch failed event failed!", new Object[0]);
                        }
                        if (C7131e.f23698E.f23705G != null && C7131e.f23698E.f23705G.exists() && C7131e.f23698E.f23705G.delete()) {
                            C7226an.m31141a("[patch] delete patch.apk success", new Object[0]);
                        }
                    }
                } else {
                    C7226an.m31141a("[patch] inject success", new Object[0]);
                    if (!C7127a.m30556b("UPLOAD_PATCH_RESULT", false)) {
                        C7127a.m30548a("UPLOAD_PATCH_RESULT", true);
                        C7270p pVar2 = C7270p.f24600a;
                        C7280w wVar3 = r6;
                        C7280w wVar4 = new C7280w("active", System.currentTimeMillis(), 0, 0, null, betaGrayStrategy.f23818a.f24665m, betaGrayStrategy.f23818a.f24668p, null);
                        if (pVar2.mo34953a(wVar3)) {
                            C7226an.m31141a("save patch success event success!", new Object[0]);
                        } else {
                            C7226an.m31149e("save patch success event failed!", new Object[0]);
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(TinkerManager.getNewTinkerId())) {
                C7226an.m31148d("[patch] tinker new id is null ,so patch version is invalid", new Object[0]);
                eVar.f23711M = "";
            }
            C7232aq.m31212b("G15", eVar.f23711M);
            File file = C7131e.f23698E.f23706H;
            if (file != null && file.exists() && file.delete()) {
                C7226an.m31141a("[patch] delete tmpPatch.apk success", new Object[0]);
            }
            File file2 = C7131e.f23698E.f23705G;
            if (file2 != null && file2.exists()) {
                String a = C7232aq.m31182a(file2, "SHA");
                if (a != null) {
                    C7131e.f23698E.f23710L = a;
                }
            }
            if (TinkerManager.isTinkerManagerInstalled()) {
                if (TextUtils.isEmpty(eVar.f23708J)) {
                    eVar.f23708J = TinkerManager.getTinkerId();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("TINKER_ID:");
                sb.append(eVar.f23708J);
                C7226an.m31141a(sb.toString(), new Object[0]);
                eVar.f23709K = TinkerManager.getNewTinkerId();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NEW_TINKER_ID:");
                sb2.append(eVar.f23709K);
                C7226an.m31141a(sb2.toString(), new Object[0]);
                TinkerManager.getInstance().setTinkerListener(new TinkerListener() {
                    public void onDownloadSuccess(String str) {
                        if (eVar.f23721W != null) {
                            eVar.f23721W.onDownloadSuccess(str);
                        }
                    }

                    public void onDownloadFailure(String str) {
                        if (eVar.f23721W != null) {
                            eVar.f23721W.onDownloadFailure(str);
                        }
                    }

                    public void onPatchStart() {
                        eVar.f23727ac = true;
                        C7127a.m30548a("IS_PATCHING", true);
                    }

                    public void onApplySuccess(String str) {
                        C7131e eVar = eVar;
                        eVar.f23727ac = false;
                        eVar.f23712N = true;
                        C7127a.m30548a("IS_PATCHING", false);
                        C7127a.m30548a("PatchResult", true);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Tinker patch success, result: ");
                        sb.append(str);
                        C7226an.m31141a(sb.toString(), new Object[0]);
                        if (eVar.f23722X) {
                            C7148g.m30581a(new C7146e(), true);
                        }
                        if (eVar.f23721W != null) {
                            eVar.f23721W.onApplySuccess(str);
                        }
                    }

                    public void onApplyFailure(String str) {
                        eVar.f23712N = false;
                        C7127a.m30548a("PatchResult", false);
                        C7127a.m30548a("IS_PATCHING", false);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Tinker patch failure, result: ");
                        sb.append(str);
                        C7226an.m31141a(sb.toString(), new Object[0]);
                        if (eVar.f23721W != null) {
                            eVar.f23721W.onApplyFailure(str);
                        }
                    }

                    public void onPatchRollback() {
                        C7226an.m31141a("patch rollback callback.", new Object[0]);
                        if (eVar.f23721W != null) {
                            eVar.f23721W.onPatchRollback();
                        }
                        if (TinkerManager.getInstance().getPatchDirectory(eVar.f23747s) != null && !TinkerManager.getInstance().getPatchDirectory(eVar.f23747s).exists()) {
                            C7127a.m30548a("IS_PATCH_ROLL_BACK", false);
                        }
                    }
                });
            }
            if (TextUtils.isEmpty(C7127a.m30555b("BaseArchName", ""))) {
                String str = eVar.f23747s.getApplicationInfo().nativeLibraryDir;
                if (str != null) {
                    File[] listFiles = new File(str).listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        boolean z = false;
                        for (File file3 : listFiles) {
                            if (file3.getName().endsWith(".so")) {
                                String replace = file3.getName().replace(".so", "");
                                if (replace.startsWith("lib")) {
                                    replace = replace.substring(replace.indexOf("lib") + 3);
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("libName:");
                                sb3.append(replace);
                                C7226an.m31141a(sb3.toString(), new Object[0]);
                                String absolutePath3 = file3.getAbsolutePath();
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("soFilePath:");
                                sb4.append(absolutePath3);
                                C7226an.m31141a(sb4.toString(), new Object[0]);
                                Iterator it = eVar.f23725aa.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (replace.equals((String) it.next())) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (!z) {
                                    String b = C7127a.m30554b(absolutePath3);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("archName:");
                                    sb5.append(b);
                                    C7226an.m31141a(sb5.toString(), new Object[0]);
                                    if (b != null && b.equals("armeabi-v5te")) {
                                        b = "armeabi";
                                    }
                                    C7127a.m30547a(replace, b);
                                    if (TextUtils.isEmpty(C7127a.m30555b("BaseArchName", ""))) {
                                        C7127a.m30547a("BaseArchName", b);
                                    }
                                    z = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
