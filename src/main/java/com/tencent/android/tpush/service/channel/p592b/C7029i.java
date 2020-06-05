package com.tencent.android.tpush.service.channel.p592b;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b.i */
public abstract class C7029i extends C7026f {
    /* renamed from: o */
    static final /* synthetic */ boolean f23355o = (!C7029i.class.desiredAssertionStatus());
    /* renamed from: d */
    protected short f23356d;
    /* renamed from: e */
    protected int f23357e;
    /* renamed from: f */
    protected long f23358f;
    /* renamed from: g */
    protected long f23359g;
    /* renamed from: h */
    protected short f23360h;
    /* renamed from: i */
    protected short f23361i;
    /* renamed from: k */
    protected short f23362k;
    /* renamed from: l */
    protected short f23363l;
    /* renamed from: m */
    protected short f23364m;
    /* renamed from: n */
    protected byte[] f23365n = new byte[0];

    /* renamed from: e */
    public boolean mo33444e() {
        return (this.f23360h & 128) != 0;
    }

    /* renamed from: f */
    public byte mo33445f() {
        return (byte) (this.f23360h & 127);
    }

    /* renamed from: g */
    public String mo33446g() {
        switch (mo33445f()) {
            case 1:
                return "TPNS_COMMAND_PUSH";
            case 2:
                return "TPNS_COMMAND_GET_APLIST";
            case 3:
                return "TPNS_COMMAND_PULLCONFIG";
            case 4:
                return "TPNS_COMMAND_REGISTER";
            case 5:
                return "TPNS_COMMAND_UNREGISTER";
            case 6:
                return "TPNS_COMMAND_RECONNECT";
            case 7:
                return "TPNS_COMMAND_HEARTBEAT";
            case 8:
                return "TPNS_COMMAND_UNINSTALL";
            case 9:
                return "TPNS_COMMAND_CLIENTREPORT";
            case 10:
                return "TPNS_COMMAND_REDIRECT";
            case 11:
                return "TPNS_COMMAND_PUSH_VERIFY";
            case 12:
                return "TPNS_COMMAND_SPEEDTEST";
            case 13:
                return "TPNS_COMMAND_TRIGGER_REPORT";
            case 14:
                return "TPNS_COMMAND_CHECK_MSG";
            case 15:
                return "TPNS_COMMAND_TAG";
            case 16:
                return "TPNS_COMMAND_PUSH_CLICK";
            case 17:
                return "TPNS_COMMAND_UPDATE_OTH_TOKEN";
            case 18:
                return "TPNS_COMMAND_PUSH_COMM_REPORT";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("TPNS_COMMAND_UNKNOWN ");
                sb.append(mo33445f());
                return sb.toString();
        }
    }

    /* renamed from: h */
    public short mo33447h() {
        return this.f23360h;
    }

    /* renamed from: a */
    public void mo33441a(short s) {
        this.f23360h = s;
    }

    /* renamed from: i */
    public int mo33448i() {
        return this.f23357e;
    }

    /* renamed from: j */
    public short mo33449j() {
        return this.f23362k;
    }

    /* renamed from: b */
    public void mo33443b(short s) {
        this.f23362k = s;
    }

    /* renamed from: k */
    public byte[] mo33450k() {
        return this.f23365n;
    }

    /* renamed from: a */
    public void mo33442a(byte[] bArr) {
        this.f23365n = bArr;
    }

    /* renamed from: l */
    public short mo33451l() {
        return this.f23364m;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append("(p:");
        stringBuffer.append(this.f23362k);
        stringBuffer.append("|v:");
        stringBuffer.append(this.f23363l);
        String str = "|r:";
        stringBuffer.append(str);
        stringBuffer.append(this.f23359g);
        stringBuffer.append("|s:");
        stringBuffer.append(this.f23357e);
        stringBuffer.append("|c:");
        stringBuffer.append(Integer.toHexString(this.f23360h));
        stringBuffer.append(str);
        stringBuffer.append(this.f23364m);
        stringBuffer.append("|l:");
        stringBuffer.append(this.f23358f);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* renamed from: m */
    public String mo33452m() {
        StringBuffer stringBuffer = new StringBuffer(getClass().getSimpleName());
        stringBuffer.append(" protocol = ");
        stringBuffer.append(this.f23362k);
        stringBuffer.append(" command = ");
        stringBuffer.append(mo33446g());
        stringBuffer.append(" isResponse = ");
        stringBuffer.append(mo33444e());
        stringBuffer.append(" packetLength = ");
        stringBuffer.append(this.f23358f);
        return stringBuffer.toString();
    }
}
