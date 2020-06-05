package com.tmsdk.module.coin;

public class CoinTask {
    public String app;
    public int coin_num = 0;
    public int coin_num_login = 0;
    public String extra;
    public String icon_1;
    public String icon_2;
    public String icon_3;
    public int order_assign_timestamp = 0;
    public byte[] order_data = new byte[1];
    public int order_expire_timestamp = 0;
    public String order_id;
    public int order_submit_timestamp = 0;
    public int task_status = 0;
    public int task_type = 0;
    public String text_1;
    public String text_2;
    public String text_3;
    public int type_id = 0;
    public String url;

    /* renamed from: com.tmsdk.module.coin.CoinTask$TaskStatus */
    public interface TaskStatus {
        public static final int DONE = 2;
        public static final int NEW = 1;
    }

    public CoinTask() {
        String str = "";
        this.order_id = str;
        this.text_1 = str;
        this.text_2 = str;
        this.text_3 = str;
        this.icon_1 = str;
        this.icon_2 = str;
        this.icon_3 = str;
        this.url = str;
        this.app = str;
        this.extra = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("order_id:[");
        sb2.append(this.order_id);
        String str = "]\n";
        sb2.append(str);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("task_type:[");
        sb3.append(this.task_type);
        sb3.append(str);
        sb.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("task_status:[");
        sb4.append(this.task_status);
        sb4.append(str);
        sb.append(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("coin_num:[");
        sb5.append(this.coin_num);
        sb5.append(str);
        sb.append(sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append("coin_num_login:[");
        sb6.append(this.coin_num_login);
        sb6.append(str);
        sb.append(sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append("text_1:[");
        sb7.append(this.text_1);
        sb7.append(str);
        sb.append(sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append("text_2:[");
        sb8.append(this.text_2);
        sb8.append(str);
        sb.append(sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append("text_3:[");
        sb9.append(this.text_3);
        sb9.append(str);
        sb.append(sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append("icon_1:[");
        sb10.append(this.icon_1);
        sb10.append(str);
        sb.append(sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append("icon_2:[");
        sb11.append(this.icon_2);
        sb11.append(str);
        sb.append(sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append("icon_3:[");
        sb12.append(this.icon_3);
        sb12.append(str);
        sb.append(sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append("url:[");
        sb13.append(this.url);
        sb13.append(str);
        sb.append(sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append("app:[");
        sb14.append(this.app);
        sb14.append(str);
        sb.append(sb14.toString());
        StringBuilder sb15 = new StringBuilder();
        sb15.append("extra:[");
        sb15.append(this.extra);
        sb15.append(str);
        sb.append(sb15.toString());
        return sb.toString();
    }
}
