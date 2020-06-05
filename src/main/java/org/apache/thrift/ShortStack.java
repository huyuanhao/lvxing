package org.apache.thrift;

/* renamed from: org.apache.thrift.b */
public class ShortStack {
    /* renamed from: a */
    private short[] f29064a;
    /* renamed from: b */
    private int f29065b = -1;

    public ShortStack(int i) {
        this.f29064a = new short[i];
    }

    /* renamed from: a */
    public short mo40873a() {
        short[] sArr = this.f29064a;
        int i = this.f29065b;
        this.f29065b = i - 1;
        return sArr[i];
    }

    /* renamed from: a */
    public void mo40874a(short s) {
        if (this.f29064a.length == this.f29065b + 1) {
            m36974b();
        }
        short[] sArr = this.f29064a;
        int i = this.f29065b + 1;
        this.f29065b = i;
        sArr[i] = s;
    }

    /* renamed from: b */
    private void m36974b() {
        short[] sArr = this.f29064a;
        short[] sArr2 = new short[(sArr.length * 2)];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f29064a = sArr2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f29064a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f29065b) {
                sb.append(">>");
            }
            sb.append(this.f29064a[i]);
            if (i == this.f29065b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
