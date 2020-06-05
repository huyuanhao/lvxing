package com.tencent.p605ep.common.adapt.iservice.vip;

/* renamed from: com.tencent.ep.common.adapt.iservice.vip.VIPPrice */
public class VIPPrice {
    public int month;
    public double oldPrice;
    public double price;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VIPPrice{month=");
        sb.append(this.month);
        sb.append(", oldPrice=");
        sb.append(this.oldPrice);
        sb.append(", price=");
        sb.append(this.price);
        sb.append('}');
        return sb.toString();
    }
}
