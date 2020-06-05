package ezy.sdk3rd.social.platforms.send;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import ezy.sdk3rd.social.sdk.OnCallback;
import ezy.sdk3rd.social.sdk.Platform;
import ezy.sdk3rd.social.share.IShareable;
import ezy.sdk3rd.social.share.ShareData;
import ezy.sdk3rd.social.share.p650a.p651a.BitmapResource;
import ezy.sdk3rd.social.share.p650a.p651a.FileResource;
import ezy.sdk3rd.social.share.p650a.p651a.ImageResource;
import ezy.sdk3rd.social.share.p652b.MoImage;
import java.util.List;

public class SendShare implements IShareable {
    static final String PACKAGE_QQ = "com.tencent.mobileqq";
    static final String PACKAGE_WX = "com.tencent.mm";
    public static final String TAG = "ezy.sdk3rd.qq.share";
    Activity mActivity;
    Platform mPlatform;

    public void onResult(int i, int i2, Intent intent) {
    }

    SendShare(Activity activity, Platform platform) {
        this.mActivity = activity;
        this.mPlatform = platform;
    }

    public void share(ShareData aVar, OnCallback<String> fVar) {
        String str = "toqq";
        boolean equals = this.mPlatform.getName().equals(str);
        String str2 = PACKAGE_QQ;
        String str3 = "com.tencent.mm";
        if (equals) {
            if (!isApplicationInstalled(this.mActivity, str2)) {
                fVar.mo20728a(this.mActivity, 3, "无法分享，请先安装QQ");
                return;
            }
        } else if (!isApplicationInstalled(this.mActivity, str3)) {
            fVar.mo20728a(this.mActivity, 3, "无法分享，请先安装微信");
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (this.mPlatform.getName().equals(str)) {
            intent.setClassName(str2, "com.tencent.mobileqq.activity.JumpActivity");
        } else if (this.mPlatform.getName().equals("towxsession")) {
            intent.setClassName(str3, "com.tencent.mm.ui.tools.ShareImgUI");
        } else {
            intent.setClassName(str3, "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        }
        int f = aVar.mo38635f();
        if (f == 1) {
            intent.setType("text/plain");
            intent.putExtra("Kdescription", aVar.f27307b);
            intent.putExtra("android.intent.extra.TEXT", aVar.f27307b);
            intent.setFlags(268435456);
        } else if (f != 2) {
            fVar.mo20728a(this.mActivity, 3, "不支持的分享类型");
            return;
        } else {
            intent.setType("image/*");
            intent.setFlags(268468225);
            ImageResource cVar = ((MoImage) aVar.f27311f).f27316a;
            String str4 = "android.intent.extra.STREAM";
            if (cVar instanceof BitmapResource) {
                intent.putExtra(str4, Uri.parse(Media.insertImage(this.mActivity.getContentResolver(), cVar.mo38638b(), null, null)));
            } else if (cVar instanceof FileResource) {
                intent.putExtra(str4, Uri.fromFile(((FileResource) cVar).f27315a));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(Uri.parse(cVar.mo38637a()));
                Log.e("ezy", sb.toString());
                intent.setData(Uri.parse(cVar.mo38637a()));
            }
        }
        if (isIntentAvailable(this.mActivity, intent)) {
            this.mActivity.startActivity(intent);
        } else {
            fVar.mo20728a(this.mActivity, 3, "分享失败");
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean isApplicationInstalled(Context context, String str) {
        List installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            if (((PackageInfo) installedPackages.get(i)).packageName.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
