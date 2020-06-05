package com.tencent.stat;

public class StatGameUser implements Cloneable {
    /* renamed from: a */
    private String f25398a;
    /* renamed from: b */
    private String f25399b;
    /* renamed from: c */
    private String f25400c;

    public StatGameUser(String str, String str2, String str3) {
        String str4 = "";
        this.f25398a = str4;
        this.f25399b = str4;
        this.f25400c = str4;
        this.f25399b = str;
        this.f25398a = str2;
        this.f25400c = str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StatGameUser [worldName=");
        sb.append(this.f25398a);
        sb.append(", account=");
        sb.append(this.f25399b);
        sb.append(", level=");
        sb.append(this.f25400c);
        sb.append("]");
        return sb.toString();
    }

    public StatGameUser() {
        String str = "";
        this.f25398a = str;
        this.f25399b = str;
        this.f25400c = str;
    }

    public String getWorldName() {
        return this.f25398a;
    }

    public void setWorldName(String str) {
        this.f25398a = str;
    }

    public String getAccount() {
        return this.f25399b;
    }

    public void setAccount(String str) {
        this.f25399b = str;
    }

    public String getLevel() {
        return this.f25400c;
    }

    public void setLevel(String str) {
        this.f25400c = str;
    }

    public StatGameUser clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
