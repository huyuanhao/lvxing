package com.alibaba.baichuan.trade.biz.context;

public class AlibcTradeShowParam {
    /* renamed from: a */
    private boolean f2389a;
    /* renamed from: b */
    private OpenType f2390b;
    /* renamed from: c */
    private String f2391c;

    /* renamed from: com.alibaba.baichuan.trade.biz.context.AlibcTradeShowParam$OpenType */
    public enum OpenType {
        Auto,
        Native
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlibcShowParams{isClose=");
        sb.append(this.f2389a);
        sb.append(", openType=");
        sb.append(this.f2390b);
        sb.append(", backUrl='");
        sb.append(this.f2391c);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
