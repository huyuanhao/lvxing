package btmsdkobf;

import com.p522qq.taf.jce.JceInputStream;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;

/* renamed from: btmsdkobf.bt */
public final class C0631bt extends JceStruct {
    /* renamed from: at */
    public String f279at;
    /* renamed from: cv */
    public String f280cv;
    /* renamed from: cw */
    public int f281cw;
    /* renamed from: cx */
    public String f282cx;
    /* renamed from: dT */
    public String f283dT;
    /* renamed from: dU */
    public String f284dU;
    /* renamed from: dV */
    public String f285dV;
    /* renamed from: dW */
    public String f286dW;
    /* renamed from: dX */
    public int f287dX = 1;
    /* renamed from: dY */
    public int f288dY;
    /* renamed from: dZ */
    public int f289dZ;
    /* renamed from: eA */
    public String f290eA;
    /* renamed from: eB */
    public String f291eB;
    /* renamed from: eC */
    public boolean f292eC;
    /* renamed from: eD */
    public boolean f293eD;
    /* renamed from: eE */
    public int f294eE;
    /* renamed from: eF */
    public String f295eF;
    /* renamed from: eG */
    public String f296eG;
    /* renamed from: eH */
    public String f297eH;
    /* renamed from: eI */
    public String f298eI;
    /* renamed from: eJ */
    public String f299eJ;
    /* renamed from: eK */
    public String f300eK;
    /* renamed from: eL */
    public String f301eL;
    /* renamed from: eM */
    public String f302eM;
    /* renamed from: eN */
    public String f303eN;
    /* renamed from: eO */
    public long f304eO;
    /* renamed from: eP */
    public String f305eP;
    /* renamed from: eQ */
    public String f306eQ;
    /* renamed from: eR */
    public int f307eR;
    /* renamed from: eS */
    public String f308eS;
    /* renamed from: eT */
    public String f309eT;
    /* renamed from: eU */
    public String f310eU;
    /* renamed from: eV */
    public int f311eV;
    /* renamed from: eW */
    public String f312eW;
    /* renamed from: eX */
    public String f313eX;
    /* renamed from: eY */
    public String f314eY;
    /* renamed from: eZ */
    public String f315eZ;
    /* renamed from: ea */
    public boolean f316ea;
    /* renamed from: eb */
    public String f317eb;
    /* renamed from: ec */
    public String f318ec;
    /* renamed from: ed */
    public int f319ed;
    /* renamed from: ee */
    public String f320ee;
    /* renamed from: ef */
    public short f321ef;
    /* renamed from: eg */
    public int f322eg;
    /* renamed from: eh */
    public String f323eh;
    /* renamed from: ei */
    public String f324ei;
    /* renamed from: ej */
    public int f325ej;
    /* renamed from: ek */
    public String f326ek;
    /* renamed from: el */
    public long f327el;
    /* renamed from: em */
    public long f328em;
    /* renamed from: en */
    public long f329en;
    /* renamed from: eo */
    public String f330eo;
    /* renamed from: ep */
    public String f331ep;
    /* renamed from: eq */
    public String f332eq;
    /* renamed from: er */
    public String f333er;
    /* renamed from: es */
    public String f334es;
    /* renamed from: et */
    public String f335et;
    /* renamed from: eu */
    public String f336eu;
    /* renamed from: ev */
    public String f337ev;
    /* renamed from: ew */
    public int f338ew;
    /* renamed from: ex */
    public int f339ex;
    /* renamed from: ey */
    public boolean f340ey;
    /* renamed from: ez */
    public String f341ez;
    /* renamed from: fa */
    public String f342fa;
    /* renamed from: fb */
    public String f343fb;
    /* renamed from: fc */
    public String f344fc;
    public String version;

    public C0631bt() {
        String str = "";
        this.f279at = str;
        this.f283dT = str;
        this.f284dU = str;
        this.f285dV = str;
        this.f286dW = str;
        this.f280cv = str;
        this.f281cw = 0;
        this.f282cx = str;
        this.f288dY = 0;
        this.f289dZ = 0;
        this.f316ea = false;
        this.f317eb = str;
        this.f318ec = str;
        this.f319ed = 0;
        this.f320ee = str;
        this.f321ef = 0;
        this.f322eg = 0;
        this.f323eh = str;
        this.f324ei = str;
        this.f325ej = 0;
        this.f326ek = str;
        this.f327el = 0;
        this.f328em = 0;
        this.f329en = 0;
        this.f330eo = str;
        this.f331ep = str;
        this.f332eq = str;
        this.f333er = str;
        this.f334es = str;
        this.f335et = str;
        this.f336eu = str;
        this.f337ev = str;
        this.f338ew = 0;
        this.f339ex = 0;
        this.f340ey = false;
        this.f341ez = str;
        this.f290eA = str;
        this.f291eB = str;
        this.f292eC = false;
        this.f293eD = false;
        this.version = str;
        this.f294eE = 1;
        this.f295eF = str;
        this.f296eG = str;
        this.f297eH = str;
        this.f298eI = str;
        this.f299eJ = str;
        this.f300eK = str;
        this.f301eL = str;
        this.f302eM = str;
        this.f303eN = str;
        this.f304eO = 0;
        this.f305eP = str;
        this.f306eQ = str;
        this.f307eR = 0;
        this.f308eS = str;
        this.f309eT = str;
        this.f310eU = str;
        this.f311eV = 1;
        this.f312eW = str;
        this.f313eX = str;
        this.f314eY = str;
        this.f315eZ = str;
        this.f342fa = str;
        this.f343fb = str;
        this.f344fc = str;
    }

    public JceStruct newInit() {
        return new C0631bt();
    }

    public void readFrom(JceInputStream jceInputStream) {
        this.f279at = jceInputStream.readString(0, true);
        this.f283dT = jceInputStream.readString(1, false);
        this.f284dU = jceInputStream.readString(2, false);
        this.f285dV = jceInputStream.readString(3, false);
        this.f286dW = jceInputStream.readString(4, false);
        this.f287dX = jceInputStream.read(this.f287dX, 5, false);
        this.f280cv = jceInputStream.readString(6, false);
        this.f281cw = jceInputStream.read(this.f281cw, 7, false);
        this.f282cx = jceInputStream.readString(8, false);
        this.f288dY = jceInputStream.read(this.f288dY, 9, false);
        this.f289dZ = jceInputStream.read(this.f289dZ, 10, false);
        this.f316ea = jceInputStream.read(this.f316ea, 11, false);
        this.f317eb = jceInputStream.readString(12, false);
        this.f318ec = jceInputStream.readString(13, false);
        this.f319ed = jceInputStream.read(this.f319ed, 14, false);
        this.f320ee = jceInputStream.readString(15, false);
        this.f321ef = jceInputStream.read(this.f321ef, 16, false);
        this.f322eg = jceInputStream.read(this.f322eg, 17, false);
        this.f323eh = jceInputStream.readString(18, false);
        this.f324ei = jceInputStream.readString(19, false);
        this.f325ej = jceInputStream.read(this.f325ej, 20, false);
        this.f326ek = jceInputStream.readString(21, false);
        this.f327el = jceInputStream.read(this.f327el, 22, false);
        this.f328em = jceInputStream.read(this.f328em, 23, false);
        this.f329en = jceInputStream.read(this.f329en, 24, false);
        this.f330eo = jceInputStream.readString(25, false);
        this.f331ep = jceInputStream.readString(26, false);
        this.f332eq = jceInputStream.readString(27, false);
        this.f333er = jceInputStream.readString(28, false);
        this.f334es = jceInputStream.readString(29, false);
        this.f335et = jceInputStream.readString(30, false);
        this.f336eu = jceInputStream.readString(31, false);
        this.f337ev = jceInputStream.readString(32, false);
        this.f338ew = jceInputStream.read(this.f338ew, 33, false);
        this.f339ex = jceInputStream.read(this.f339ex, 34, false);
        this.f340ey = jceInputStream.read(this.f340ey, 35, false);
        this.f341ez = jceInputStream.readString(36, false);
        this.f290eA = jceInputStream.readString(37, false);
        this.f291eB = jceInputStream.readString(38, false);
        this.f292eC = jceInputStream.read(this.f292eC, 39, false);
        this.f293eD = jceInputStream.read(this.f293eD, 40, false);
        this.version = jceInputStream.readString(41, false);
        this.f294eE = jceInputStream.read(this.f294eE, 42, false);
        this.f295eF = jceInputStream.readString(43, false);
        this.f296eG = jceInputStream.readString(44, false);
        this.f297eH = jceInputStream.readString(45, false);
        this.f298eI = jceInputStream.readString(46, false);
        this.f299eJ = jceInputStream.readString(47, false);
        this.f300eK = jceInputStream.readString(48, false);
        this.f301eL = jceInputStream.readString(49, false);
        this.f302eM = jceInputStream.readString(50, false);
        this.f303eN = jceInputStream.readString(51, false);
        this.f304eO = jceInputStream.read(this.f304eO, 52, false);
        this.f305eP = jceInputStream.readString(53, false);
        this.f306eQ = jceInputStream.readString(54, false);
        this.f307eR = jceInputStream.read(this.f307eR, 55, false);
        this.f308eS = jceInputStream.readString(56, false);
        this.f309eT = jceInputStream.readString(57, false);
        this.f310eU = jceInputStream.readString(58, false);
        this.f311eV = jceInputStream.read(this.f311eV, 59, false);
        this.f312eW = jceInputStream.readString(60, false);
        this.f313eX = jceInputStream.readString(61, false);
        this.f314eY = jceInputStream.readString(62, false);
        this.f315eZ = jceInputStream.readString(63, false);
        this.f342fa = jceInputStream.readString(64, false);
        this.f343fb = jceInputStream.readString(65, false);
        this.f344fc = jceInputStream.readString(66, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.f279at, 0);
        String str = this.f283dT;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.f284dU;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.f285dV;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.f286dW;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        int i = this.f287dX;
        if (1 != i) {
            jceOutputStream.write(i, 5);
        }
        String str5 = this.f280cv;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        int i2 = this.f281cw;
        if (i2 != 0) {
            jceOutputStream.write(i2, 7);
        }
        String str6 = this.f282cx;
        if (str6 != null) {
            jceOutputStream.write(str6, 8);
        }
        int i3 = this.f288dY;
        if (i3 != 0) {
            jceOutputStream.write(i3, 9);
        }
        int i4 = this.f289dZ;
        if (i4 != 0) {
            jceOutputStream.write(i4, 10);
        }
        jceOutputStream.write(this.f316ea, 11);
        String str7 = this.f317eb;
        if (str7 != null) {
            jceOutputStream.write(str7, 12);
        }
        String str8 = this.f318ec;
        if (str8 != null) {
            jceOutputStream.write(str8, 13);
        }
        int i5 = this.f319ed;
        if (i5 != 0) {
            jceOutputStream.write(i5, 14);
        }
        String str9 = this.f320ee;
        if (str9 != null) {
            jceOutputStream.write(str9, 15);
        }
        short s = this.f321ef;
        if (s != 0) {
            jceOutputStream.write(s, 16);
        }
        int i6 = this.f322eg;
        if (i6 != 0) {
            jceOutputStream.write(i6, 17);
        }
        String str10 = this.f323eh;
        if (str10 != null) {
            jceOutputStream.write(str10, 18);
        }
        String str11 = this.f324ei;
        if (str11 != null) {
            jceOutputStream.write(str11, 19);
        }
        int i7 = this.f325ej;
        if (i7 != 0) {
            jceOutputStream.write(i7, 20);
        }
        String str12 = this.f326ek;
        if (str12 != null) {
            jceOutputStream.write(str12, 21);
        }
        long j = this.f327el;
        if (j != 0) {
            jceOutputStream.write(j, 22);
        }
        long j2 = this.f328em;
        if (j2 != 0) {
            jceOutputStream.write(j2, 23);
        }
        long j3 = this.f329en;
        if (j3 != 0) {
            jceOutputStream.write(j3, 24);
        }
        String str13 = this.f330eo;
        if (str13 != null) {
            jceOutputStream.write(str13, 25);
        }
        String str14 = this.f331ep;
        if (str14 != null) {
            jceOutputStream.write(str14, 26);
        }
        String str15 = this.f332eq;
        if (str15 != null) {
            jceOutputStream.write(str15, 27);
        }
        String str16 = this.f333er;
        if (str16 != null) {
            jceOutputStream.write(str16, 28);
        }
        String str17 = this.f334es;
        if (str17 != null) {
            jceOutputStream.write(str17, 29);
        }
        String str18 = this.f335et;
        if (str18 != null) {
            jceOutputStream.write(str18, 30);
        }
        String str19 = this.f336eu;
        if (str19 != null) {
            jceOutputStream.write(str19, 31);
        }
        String str20 = this.f337ev;
        if (str20 != null) {
            jceOutputStream.write(str20, 32);
        }
        int i8 = this.f338ew;
        if (i8 != 0) {
            jceOutputStream.write(i8, 33);
        }
        int i9 = this.f339ex;
        if (i9 != 0) {
            jceOutputStream.write(i9, 34);
        }
        jceOutputStream.write(this.f340ey, 35);
        String str21 = this.f341ez;
        if (str21 != null) {
            jceOutputStream.write(str21, 36);
        }
        String str22 = this.f290eA;
        if (str22 != null) {
            jceOutputStream.write(str22, 37);
        }
        String str23 = this.f291eB;
        if (str23 != null) {
            jceOutputStream.write(str23, 38);
        }
        jceOutputStream.write(this.f292eC, 39);
        jceOutputStream.write(this.f293eD, 40);
        String str24 = this.version;
        if (str24 != null) {
            jceOutputStream.write(str24, 41);
        }
        int i10 = this.f294eE;
        if (i10 != 1) {
            jceOutputStream.write(i10, 42);
        }
        String str25 = this.f295eF;
        if (str25 != null) {
            jceOutputStream.write(str25, 43);
        }
        String str26 = this.f296eG;
        if (str26 != null) {
            jceOutputStream.write(str26, 44);
        }
        String str27 = this.f297eH;
        if (str27 != null) {
            jceOutputStream.write(str27, 45);
        }
        String str28 = this.f298eI;
        if (str28 != null) {
            jceOutputStream.write(str28, 46);
        }
        String str29 = this.f299eJ;
        if (str29 != null) {
            jceOutputStream.write(str29, 47);
        }
        String str30 = this.f300eK;
        if (str30 != null) {
            jceOutputStream.write(str30, 48);
        }
        String str31 = this.f301eL;
        if (str31 != null) {
            jceOutputStream.write(str31, 49);
        }
        String str32 = this.f302eM;
        if (str32 != null) {
            jceOutputStream.write(str32, 50);
        }
        String str33 = this.f303eN;
        if (str33 != null) {
            jceOutputStream.write(str33, 51);
        }
        long j4 = this.f304eO;
        if (j4 != 0) {
            jceOutputStream.write(j4, 52);
        }
        String str34 = this.f305eP;
        if (str34 != null) {
            jceOutputStream.write(str34, 53);
        }
        String str35 = this.f306eQ;
        if (str35 != null) {
            jceOutputStream.write(str35, 54);
        }
        int i11 = this.f307eR;
        if (i11 != 0) {
            jceOutputStream.write(i11, 55);
        }
        String str36 = this.f308eS;
        if (str36 != null) {
            jceOutputStream.write(str36, 56);
        }
        String str37 = this.f309eT;
        if (str37 != null) {
            jceOutputStream.write(str37, 57);
        }
        String str38 = this.f310eU;
        if (str38 != null) {
            jceOutputStream.write(str38, 58);
        }
        int i12 = this.f311eV;
        if (i12 != 1) {
            jceOutputStream.write(i12, 59);
        }
        String str39 = this.f312eW;
        if (str39 != null) {
            jceOutputStream.write(str39, 60);
        }
        String str40 = this.f313eX;
        if (str40 != null) {
            jceOutputStream.write(str40, 61);
        }
        String str41 = this.f314eY;
        if (str41 != null) {
            jceOutputStream.write(str41, 62);
        }
        String str42 = this.f315eZ;
        if (str42 != null) {
            jceOutputStream.write(str42, 63);
        }
        String str43 = this.f342fa;
        if (str43 != null) {
            jceOutputStream.write(str43, 64);
        }
        String str44 = this.f343fb;
        if (str44 != null) {
            jceOutputStream.write(str44, 65);
        }
        String str45 = this.f344fc;
        if (str45 != null) {
            jceOutputStream.write(str45, 66);
        }
    }
}
