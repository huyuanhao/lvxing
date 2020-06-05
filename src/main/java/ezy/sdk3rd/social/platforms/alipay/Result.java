package ezy.sdk3rd.social.platforms.alipay;

import android.text.TextUtils;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ezy.sdk3rd.social.platforms.alipay.a */
public class Result {
    /* renamed from: e */
    private static final Map<String, String> f27283e = new HashMap();
    /* renamed from: a */
    public String f27284a;
    /* renamed from: b */
    public String f27285b;
    /* renamed from: c */
    public String f27286c;
    /* renamed from: d */
    public String f27287d;

    static {
        f27283e.put("9000", "支付成功");
        f27283e.put("8000", "支付结果确认中");
        f27283e.put("4000", "系统异常");
        f27283e.put("4001", "数据格式不正确");
        f27283e.put("4003", "该用户绑定的支付宝账户被冻结或不允许支付");
        f27283e.put("4004", "该用户已解除绑定");
        f27283e.put("4005", "绑定失败或没有绑定");
        f27283e.put("4006", "订单支付失败");
        f27283e.put("4010", "重新绑定账户");
        f27283e.put("6000", "支付服务正在进行升级操作");
        f27283e.put("6001", "用户中途取消支付操作");
        f27283e.put("7001", "网页支付失败");
    }

    public Result(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                if (TextUtils.equals(str, "resultStatus")) {
                    this.f27285b = (String) map.get(str);
                } else if (TextUtils.equals(str, ArgKey.KEY_RESULT)) {
                    this.f27284a = (String) map.get(str);
                } else if (TextUtils.equals(str, "memo")) {
                    this.f27286c = (String) map.get(str);
                }
            }
            if (f27283e.containsKey(this.f27285b)) {
                this.f27287d = (String) f27283e.get(this.f27285b);
            } else {
                this.f27287d = "支付失败";
            }
        }
    }

    /* renamed from: a */
    public boolean mo38583a() {
        return "9000".equals(this.f27285b);
    }

    /* renamed from: b */
    public boolean mo38584b() {
        return "8000".equals(this.f27285b);
    }

    /* renamed from: c */
    public boolean mo38585c() {
        return "6001".equals(this.f27285b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("resultStatus={");
        sb.append(this.f27285b);
        sb.append("};memo={");
        sb.append(this.f27286c);
        sb.append("};result={");
        sb.append(this.f27284a);
        sb.append("}");
        return sb.toString();
    }
}
