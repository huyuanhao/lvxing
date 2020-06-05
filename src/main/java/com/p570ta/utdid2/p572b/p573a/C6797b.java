package com.p570ta.utdid2.p572b.p573a;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;

/* compiled from: Base64 */
/* renamed from: com.ta.utdid2.b.a.b */
public class C6797b {
    /* renamed from: a */
    static final /* synthetic */ boolean f22486a = (!C6797b.class.desiredAssertionStatus());

    /* compiled from: Base64 */
    /* renamed from: com.ta.utdid2.b.a.b$a */
    static abstract class C6798a {
        /* renamed from: a */
        public int f22487a;
        /* renamed from: b */
        public byte[] f22488b;

        C6798a() {
        }
    }

    /* compiled from: Base64 */
    /* renamed from: com.ta.utdid2.b.a.b$b */
    static class C6799b extends C6798a {
        /* renamed from: a */
        private static final int[] f22489a;
        /* renamed from: b */
        private static final int[] f22490b;
        /* renamed from: c */
        private final int[] f22491c;
        private int state;
        private int value;

        static {
            int[] iArr = new int[256];
            iArr[0] = -1;
            iArr[1] = -1;
            iArr[2] = -1;
            iArr[3] = -1;
            iArr[4] = -1;
            iArr[5] = -1;
            iArr[6] = -1;
            iArr[7] = -1;
            iArr[8] = -1;
            iArr[9] = -1;
            iArr[10] = -1;
            iArr[11] = -1;
            iArr[12] = -1;
            iArr[13] = -1;
            iArr[14] = -1;
            iArr[15] = -1;
            iArr[16] = -1;
            iArr[17] = -1;
            iArr[18] = -1;
            iArr[19] = -1;
            iArr[20] = -1;
            iArr[21] = -1;
            iArr[22] = -1;
            iArr[23] = -1;
            iArr[24] = -1;
            iArr[25] = -1;
            iArr[26] = -1;
            iArr[27] = -1;
            iArr[28] = -1;
            iArr[29] = -1;
            iArr[30] = -1;
            iArr[31] = -1;
            iArr[32] = -1;
            iArr[33] = -1;
            iArr[34] = -1;
            iArr[35] = -1;
            iArr[36] = -1;
            iArr[37] = -1;
            iArr[38] = -1;
            iArr[39] = -1;
            iArr[40] = -1;
            iArr[41] = -1;
            iArr[42] = -1;
            iArr[43] = 62;
            iArr[44] = -1;
            iArr[45] = -1;
            iArr[46] = -1;
            iArr[47] = 63;
            iArr[48] = 52;
            iArr[49] = 53;
            iArr[50] = 54;
            iArr[51] = 55;
            iArr[52] = 56;
            iArr[53] = 57;
            iArr[54] = 58;
            iArr[55] = 59;
            iArr[56] = 60;
            iArr[57] = 61;
            iArr[58] = -1;
            iArr[59] = -1;
            iArr[60] = -1;
            iArr[61] = -2;
            iArr[62] = -1;
            iArr[63] = -1;
            iArr[64] = -1;
            iArr[66] = 1;
            iArr[67] = 2;
            iArr[68] = 3;
            iArr[69] = 4;
            iArr[70] = 5;
            iArr[71] = 6;
            iArr[72] = 7;
            iArr[73] = 8;
            iArr[74] = 9;
            iArr[75] = 10;
            iArr[76] = 11;
            iArr[77] = 12;
            iArr[78] = 13;
            iArr[79] = 14;
            iArr[80] = 15;
            iArr[81] = 16;
            iArr[82] = 17;
            iArr[83] = 18;
            iArr[84] = 19;
            iArr[85] = 20;
            iArr[86] = 21;
            iArr[87] = 22;
            iArr[88] = 23;
            iArr[89] = 24;
            iArr[90] = 25;
            iArr[91] = -1;
            iArr[92] = -1;
            iArr[93] = -1;
            iArr[94] = -1;
            iArr[95] = -1;
            iArr[96] = -1;
            iArr[97] = 26;
            iArr[98] = 27;
            iArr[99] = 28;
            iArr[100] = 29;
            iArr[101(0x65)] = 30;
            iArr[102(0x66)] = 31;
            iArr[103(0x67)] = 32;
            iArr[104(0x68)] = 33;
            iArr[105(0x69)] = 34;
            iArr[106(0x6a)] = 35;
            iArr[107(0x6b)] = 36;
            iArr[108(0x6c)] = 37;
            iArr[109(0x6d)] = 38;
            iArr[110(0x6e)] = 39;
            iArr[111(0x6f)] = 40;
            iArr[112(0x70)] = 41;
            iArr[113(0x71)] = 42;
            iArr[114(0x72)] = 43;
            iArr[115(0x73)] = 44;
            iArr[116(0x74)] = 45;
            iArr[117(0x75)] = 46;
            iArr[118(0x76)] = 47;
            iArr[119(0x77)] = 48;
            iArr[120(0x78)] = 49;
            iArr[121(0x79)] = 50;
            iArr[122(0x7a)] = 51;
            iArr[123(0x7b)] = -1;
            iArr[124(0x7c)] = -1;
            iArr[125(0x7d)] = -1;
            iArr[126(0x7e)] = -1;
            iArr[127(0x7f)] = -1;
            iArr[128(0x80)] = -1;
            iArr[129(0x81)] = -1;
            iArr[130(0x82)] = -1;
            iArr[131(0x83)] = -1;
            iArr[132(0x84)] = -1;
            iArr[133(0x85)] = -1;
            iArr[134(0x86)] = -1;
            iArr[135(0x87)] = -1;
            iArr[136(0x88)] = -1;
            iArr[137(0x89)] = -1;
            iArr[138(0x8a)] = -1;
            iArr[139(0x8b)] = -1;
            iArr[140(0x8c)] = -1;
            iArr[141(0x8d)] = -1;
            iArr[142(0x8e)] = -1;
            iArr[143(0x8f)] = -1;
            iArr[144(0x90)] = -1;
            iArr[145(0x91)] = -1;
            iArr[146(0x92)] = -1;
            iArr[147(0x93)] = -1;
            iArr[148(0x94)] = -1;
            iArr[149(0x95)] = -1;
            iArr[150(0x96)] = -1;
            iArr[151(0x97)] = -1;
            iArr[152(0x98)] = -1;
            iArr[153(0x99)] = -1;
            iArr[154(0x9a)] = -1;
            iArr[155(0x9b)] = -1;
            iArr[156(0x9c)] = -1;
            iArr[157(0x9d)] = -1;
            iArr[158(0x9e)] = -1;
            iArr[159(0x9f)] = -1;
            iArr[160(0xa0)] = -1;
            iArr[161(0xa1)] = -1;
            iArr[162(0xa2)] = -1;
            iArr[163(0xa3)] = -1;
            iArr[164(0xa4)] = -1;
            iArr[165(0xa5)] = -1;
            iArr[166(0xa6)] = -1;
            iArr[167(0xa7)] = -1;
            iArr[168(0xa8)] = -1;
            iArr[169(0xa9)] = -1;
            iArr[170(0xaa)] = -1;
            iArr[171(0xab)] = -1;
            iArr[172(0xac)] = -1;
            iArr[173(0xad)] = -1;
            iArr[174(0xae)] = -1;
            iArr[175(0xaf)] = -1;
            iArr[176(0xb0)] = -1;
            iArr[177(0xb1)] = -1;
            iArr[178(0xb2)] = -1;
            iArr[179(0xb3)] = -1;
            iArr[180(0xb4)] = -1;
            iArr[181(0xb5)] = -1;
            iArr[182(0xb6)] = -1;
            iArr[183(0xb7)] = -1;
            iArr[184(0xb8)] = -1;
            iArr[185(0xb9)] = -1;
            iArr[186(0xba)] = -1;
            iArr[187(0xbb)] = -1;
            iArr[188(0xbc)] = -1;
            iArr[189(0xbd)] = -1;
            iArr[190(0xbe)] = -1;
            iArr[191(0xbf)] = -1;
            iArr[192(0xc0)] = -1;
            iArr[193(0xc1)] = -1;
            iArr[194(0xc2)] = -1;
            iArr[195(0xc3)] = -1;
            iArr[196(0xc4)] = -1;
            iArr[197(0xc5)] = -1;
            iArr[198(0xc6)] = -1;
            iArr[199(0xc7)] = -1;
            iArr[200(0xc8)] = -1;
            iArr[201(0xc9)] = -1;
            iArr[202(0xca)] = -1;
            iArr[203(0xcb)] = -1;
            iArr[204(0xcc)] = -1;
            iArr[205(0xcd)] = -1;
            iArr[206(0xce)] = -1;
            iArr[207(0xcf)] = -1;
            iArr[208(0xd0)] = -1;
            iArr[209(0xd1)] = -1;
            iArr[210(0xd2)] = -1;
            iArr[211(0xd3)] = -1;
            iArr[212(0xd4)] = -1;
            iArr[213(0xd5)] = -1;
            iArr[214(0xd6)] = -1;
            iArr[215(0xd7)] = -1;
            iArr[216(0xd8)] = -1;
            iArr[217(0xd9)] = -1;
            iArr[218(0xda)] = -1;
            iArr[219(0xdb)] = -1;
            iArr[220(0xdc)] = -1;
            iArr[221(0xdd)] = -1;
            iArr[222(0xde)] = -1;
            iArr[223(0xdf)] = -1;
            iArr[224(0xe0)] = -1;
            iArr[225(0xe1)] = -1;
            iArr[226(0xe2)] = -1;
            iArr[227(0xe3)] = -1;
            iArr[228(0xe4)] = -1;
            iArr[229(0xe5)] = -1;
            iArr[230(0xe6)] = -1;
            iArr[231(0xe7)] = -1;
            iArr[232(0xe8)] = -1;
            iArr[233(0xe9)] = -1;
            iArr[234(0xea)] = -1;
            iArr[235(0xeb)] = -1;
            iArr[236(0xec)] = -1;
            iArr[237(0xed)] = -1;
            iArr[238(0xee)] = -1;
            iArr[239(0xef)] = -1;
            iArr[240(0xf0)] = -1;
            iArr[241(0xf1)] = -1;
            iArr[242(0xf2)] = -1;
            iArr[243(0xf3)] = -1;
            iArr[244(0xf4)] = -1;
            iArr[245(0xf5)] = -1;
            iArr[246(0xf6)] = -1;
            iArr[247(0xf7)] = -1;
            iArr[248(0xf8)] = -1;
            iArr[249(0xf9)] = -1;
            iArr[250(0xfa)] = -1;
            iArr[251(0xfb)] = -1;
            iArr[252(0xfc)] = -1;
            iArr[253(0xfd)] = -1;
            iArr[254(0xfe)] = -1;
            iArr[255(0xff)] = -1;
            f22489a = iArr;
            int[] iArr2 = new int[256];
            iArr2[0] = -1;
            iArr2[1] = -1;
            iArr2[2] = -1;
            iArr2[3] = -1;
            iArr2[4] = -1;
            iArr2[5] = -1;
            iArr2[6] = -1;
            iArr2[7] = -1;
            iArr2[8] = -1;
            iArr2[9] = -1;
            iArr2[10] = -1;
            iArr2[11] = -1;
            iArr2[12] = -1;
            iArr2[13] = -1;
            iArr2[14] = -1;
            iArr2[15] = -1;
            iArr2[16] = -1;
            iArr2[17] = -1;
            iArr2[18] = -1;
            iArr2[19] = -1;
            iArr2[20] = -1;
            iArr2[21] = -1;
            iArr2[22] = -1;
            iArr2[23] = -1;
            iArr2[24] = -1;
            iArr2[25] = -1;
            iArr2[26] = -1;
            iArr2[27] = -1;
            iArr2[28] = -1;
            iArr2[29] = -1;
            iArr2[30] = -1;
            iArr2[31] = -1;
            iArr2[32] = -1;
            iArr2[33] = -1;
            iArr2[34] = -1;
            iArr2[35] = -1;
            iArr2[36] = -1;
            iArr2[37] = -1;
            iArr2[38] = -1;
            iArr2[39] = -1;
            iArr2[40] = -1;
            iArr2[41] = -1;
            iArr2[42] = -1;
            iArr2[43] = -1;
            iArr2[44] = -1;
            iArr2[45] = 62;
            iArr2[46] = -1;
            iArr2[47] = -1;
            iArr2[48] = 52;
            iArr2[49] = 53;
            iArr2[50] = 54;
            iArr2[51] = 55;
            iArr2[52] = 56;
            iArr2[53] = 57;
            iArr2[54] = 58;
            iArr2[55] = 59;
            iArr2[56] = 60;
            iArr2[57] = 61;
            iArr2[58] = -1;
            iArr2[59] = -1;
            iArr2[60] = -1;
            iArr2[61] = -2;
            iArr2[62] = -1;
            iArr2[63] = -1;
            iArr2[64] = -1;
            iArr2[66] = 1;
            iArr2[67] = 2;
            iArr2[68] = 3;
            iArr2[69] = 4;
            iArr2[70] = 5;
            iArr2[71] = 6;
            iArr2[72] = 7;
            iArr2[73] = 8;
            iArr2[74] = 9;
            iArr2[75] = 10;
            iArr2[76] = 11;
            iArr2[77] = 12;
            iArr2[78] = 13;
            iArr2[79] = 14;
            iArr2[80] = 15;
            iArr2[81] = 16;
            iArr2[82] = 17;
            iArr2[83] = 18;
            iArr2[84] = 19;
            iArr2[85] = 20;
            iArr2[86] = 21;
            iArr2[87] = 22;
            iArr2[88] = 23;
            iArr2[89] = 24;
            iArr2[90] = 25;
            iArr2[91] = -1;
            iArr2[92] = -1;
            iArr2[93] = -1;
            iArr2[94] = -1;
            iArr2[95] = 63;
            iArr2[96] = -1;
            iArr2[97] = 26;
            iArr2[98] = 27;
            iArr2[99] = 28;
            iArr2[100] = 29;
            iArr2[101(0x65)] = 30;
            iArr2[102(0x66)] = 31;
            iArr2[103(0x67)] = 32;
            iArr2[104(0x68)] = 33;
            iArr2[105(0x69)] = 34;
            iArr2[106(0x6a)] = 35;
            iArr2[107(0x6b)] = 36;
            iArr2[108(0x6c)] = 37;
            iArr2[109(0x6d)] = 38;
            iArr2[110(0x6e)] = 39;
            iArr2[111(0x6f)] = 40;
            iArr2[112(0x70)] = 41;
            iArr2[113(0x71)] = 42;
            iArr2[114(0x72)] = 43;
            iArr2[115(0x73)] = 44;
            iArr2[116(0x74)] = 45;
            iArr2[117(0x75)] = 46;
            iArr2[118(0x76)] = 47;
            iArr2[119(0x77)] = 48;
            iArr2[120(0x78)] = 49;
            iArr2[121(0x79)] = 50;
            iArr2[122(0x7a)] = 51;
            iArr2[123(0x7b)] = -1;
            iArr2[124(0x7c)] = -1;
            iArr2[125(0x7d)] = -1;
            iArr2[126(0x7e)] = -1;
            iArr2[127(0x7f)] = -1;
            iArr2[128(0x80)] = -1;
            iArr2[129(0x81)] = -1;
            iArr2[130(0x82)] = -1;
            iArr2[131(0x83)] = -1;
            iArr2[132(0x84)] = -1;
            iArr2[133(0x85)] = -1;
            iArr2[134(0x86)] = -1;
            iArr2[135(0x87)] = -1;
            iArr2[136(0x88)] = -1;
            iArr2[137(0x89)] = -1;
            iArr2[138(0x8a)] = -1;
            iArr2[139(0x8b)] = -1;
            iArr2[140(0x8c)] = -1;
            iArr2[141(0x8d)] = -1;
            iArr2[142(0x8e)] = -1;
            iArr2[143(0x8f)] = -1;
            iArr2[144(0x90)] = -1;
            iArr2[145(0x91)] = -1;
            iArr2[146(0x92)] = -1;
            iArr2[147(0x93)] = -1;
            iArr2[148(0x94)] = -1;
            iArr2[149(0x95)] = -1;
            iArr2[150(0x96)] = -1;
            iArr2[151(0x97)] = -1;
            iArr2[152(0x98)] = -1;
            iArr2[153(0x99)] = -1;
            iArr2[154(0x9a)] = -1;
            iArr2[155(0x9b)] = -1;
            iArr2[156(0x9c)] = -1;
            iArr2[157(0x9d)] = -1;
            iArr2[158(0x9e)] = -1;
            iArr2[159(0x9f)] = -1;
            iArr2[160(0xa0)] = -1;
            iArr2[161(0xa1)] = -1;
            iArr2[162(0xa2)] = -1;
            iArr2[163(0xa3)] = -1;
            iArr2[164(0xa4)] = -1;
            iArr2[165(0xa5)] = -1;
            iArr2[166(0xa6)] = -1;
            iArr2[167(0xa7)] = -1;
            iArr2[168(0xa8)] = -1;
            iArr2[169(0xa9)] = -1;
            iArr2[170(0xaa)] = -1;
            iArr2[171(0xab)] = -1;
            iArr2[172(0xac)] = -1;
            iArr2[173(0xad)] = -1;
            iArr2[174(0xae)] = -1;
            iArr2[175(0xaf)] = -1;
            iArr2[176(0xb0)] = -1;
            iArr2[177(0xb1)] = -1;
            iArr2[178(0xb2)] = -1;
            iArr2[179(0xb3)] = -1;
            iArr2[180(0xb4)] = -1;
            iArr2[181(0xb5)] = -1;
            iArr2[182(0xb6)] = -1;
            iArr2[183(0xb7)] = -1;
            iArr2[184(0xb8)] = -1;
            iArr2[185(0xb9)] = -1;
            iArr2[186(0xba)] = -1;
            iArr2[187(0xbb)] = -1;
            iArr2[188(0xbc)] = -1;
            iArr2[189(0xbd)] = -1;
            iArr2[190(0xbe)] = -1;
            iArr2[191(0xbf)] = -1;
            iArr2[192(0xc0)] = -1;
            iArr2[193(0xc1)] = -1;
            iArr2[194(0xc2)] = -1;
            iArr2[195(0xc3)] = -1;
            iArr2[196(0xc4)] = -1;
            iArr2[197(0xc5)] = -1;
            iArr2[198(0xc6)] = -1;
            iArr2[199(0xc7)] = -1;
            iArr2[200(0xc8)] = -1;
            iArr2[201(0xc9)] = -1;
            iArr2[202(0xca)] = -1;
            iArr2[203(0xcb)] = -1;
            iArr2[204(0xcc)] = -1;
            iArr2[205(0xcd)] = -1;
            iArr2[206(0xce)] = -1;
            iArr2[207(0xcf)] = -1;
            iArr2[208(0xd0)] = -1;
            iArr2[209(0xd1)] = -1;
            iArr2[210(0xd2)] = -1;
            iArr2[211(0xd3)] = -1;
            iArr2[212(0xd4)] = -1;
            iArr2[213(0xd5)] = -1;
            iArr2[214(0xd6)] = -1;
            iArr2[215(0xd7)] = -1;
            iArr2[216(0xd8)] = -1;
            iArr2[217(0xd9)] = -1;
            iArr2[218(0xda)] = -1;
            iArr2[219(0xdb)] = -1;
            iArr2[220(0xdc)] = -1;
            iArr2[221(0xdd)] = -1;
            iArr2[222(0xde)] = -1;
            iArr2[223(0xdf)] = -1;
            iArr2[224(0xe0)] = -1;
            iArr2[225(0xe1)] = -1;
            iArr2[226(0xe2)] = -1;
            iArr2[227(0xe3)] = -1;
            iArr2[228(0xe4)] = -1;
            iArr2[229(0xe5)] = -1;
            iArr2[230(0xe6)] = -1;
            iArr2[231(0xe7)] = -1;
            iArr2[232(0xe8)] = -1;
            iArr2[233(0xe9)] = -1;
            iArr2[234(0xea)] = -1;
            iArr2[235(0xeb)] = -1;
            iArr2[236(0xec)] = -1;
            iArr2[237(0xed)] = -1;
            iArr2[238(0xee)] = -1;
            iArr2[239(0xef)] = -1;
            iArr2[240(0xf0)] = -1;
            iArr2[241(0xf1)] = -1;
            iArr2[242(0xf2)] = -1;
            iArr2[243(0xf3)] = -1;
            iArr2[244(0xf4)] = -1;
            iArr2[245(0xf5)] = -1;
            iArr2[246(0xf6)] = -1;
            iArr2[247(0xf7)] = -1;
            iArr2[248(0xf8)] = -1;
            iArr2[249(0xf9)] = -1;
            iArr2[250(0xfa)] = -1;
            iArr2[251(0xfb)] = -1;
            iArr2[252(0xfc)] = -1;
            iArr2[253(0xfd)] = -1;
            iArr2[254(0xfe)] = -1;
            iArr2[255(0xff)] = -1;
            f22490b = iArr2;
        }

        public C6799b(int i, byte[] bArr) {
            this.f22488b = bArr;
            this.f22491c = (i & 8) == 0 ? f22489a : f22490b;
            this.state = 0;
            this.value = 0;
        }

        /* renamed from: a */
        public boolean mo32655a(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4 = this.state;
            if (i4 == 6) {
                return false;
            }
            int i5 = i2 + i;
            int i6 = this.value;
            byte[] bArr2 = this.f22488b;
            int[] iArr = this.f22491c;
            int i7 = i6;
            int i8 = 0;
            int i9 = i4;
            int i10 = i;
            while (i3 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i3 + 4;
                        if (i11 > i5) {
                            break;
                        }
                        i7 = iArr[bArr[i3 + 3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] | (iArr[bArr[i3 + 1] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] << 12) | (iArr[bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] << 18) | (iArr[bArr[i3 + 2] & DeviceInfos.NETWORK_TYPE_UNCONNECTED] << 6);
                        if (i7 < 0) {
                            break;
                        }
                        bArr2[i8 + 2] = (byte) i7;
                        bArr2[i8 + 1] = (byte) (i7 >> 8);
                        bArr2[i8] = (byte) (i7 >> 16);
                        i8 += 3;
                        i3 = i11;
                    }
                    if (i3 >= i5) {
                        break;
                    }
                }
                int i12 = i3 + 1;
                int i13 = iArr[bArr[i3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED];
                if (i9 != 0) {
                    if (i9 != 1) {
                        if (i9 != 2) {
                            if (i9 != 3) {
                                if (i9 == 4) {
                                    if (i13 != -2) {
                                        if (i13 != -1) {
                                            this.state = 6;
                                            return false;
                                        }
                                    }
                                    i9++;
                                } else if (i9 == 5 && i13 != -1) {
                                    this.state = 6;
                                    return false;
                                }
                            } else if (i13 >= 0) {
                                i7 = (i7 << 6) | i13;
                                bArr2[i8 + 2] = (byte) i7;
                                bArr2[i8 + 1] = (byte) (i7 >> 8);
                                bArr2[i8] = (byte) (i7 >> 16);
                                i8 += 3;
                                i10 = i12;
                                i9 = 0;
                            } else if (i13 == -2) {
                                bArr2[i8 + 1] = (byte) (i7 >> 2);
                                bArr2[i8] = (byte) (i7 >> 10);
                                i8 += 2;
                                i10 = i12;
                                i9 = 5;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i13 < 0) {
                            if (i13 == -2) {
                                int i14 = i8 + 1;
                                bArr2[i8] = (byte) (i7 >> 4);
                                i8 = i14;
                                i10 = i12;
                                i9 = 4;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                    } else if (i13 < 0) {
                        if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    int i15 = (i7 << 6) | i13;
                    i9++;
                } else if (i13 >= 0) {
                    i9++;
                    i7 = i13;
                } else if (i13 != -1) {
                    this.state = 6;
                    return false;
                }
                i10 = i12;
            }
            if (!z) {
                this.state = i9;
                this.value = i7;
                this.f22487a = i8;
                return true;
            }
            if (i9 != 0) {
                if (i9 == 1) {
                    this.state = 6;
                    return false;
                } else if (i9 == 2) {
                    int i16 = i8 + 1;
                    bArr2[i8] = (byte) (i7 >> 4);
                    i8 = i16;
                } else if (i9 == 3) {
                    int i17 = i8 + 1;
                    bArr2[i8] = (byte) (i7 >> 10);
                    i8 = i17 + 1;
                    bArr2[i17] = (byte) (i7 >> 2);
                } else if (i9 == 4) {
                    this.state = 6;
                    return false;
                }
            }
            this.state = i9;
            this.f22487a = i8;
            return true;
        }
    }

    /* compiled from: Base64 */
    /* renamed from: com.ta.utdid2.b.a.b$c */
    static class C6800c extends C6798a {
        /* renamed from: a */
        static final /* synthetic */ boolean f22492a = (!C6797b.class.desiredAssertionStatus());
        /* renamed from: c */
        private static final byte[] f22493c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        /* renamed from: d */
        private static final byte[] f22494d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        /* renamed from: b */
        int f22495b;
        /* renamed from: b */
        public final boolean f22496b;
        /* renamed from: c */
        public final boolean f22497c;
        private int count;
        /* renamed from: d */
        public final boolean f22498d;
        /* renamed from: e */
        private final byte[] f22499e;
        /* renamed from: f */
        private final byte[] f22500f;

        public C6800c(int i, byte[] bArr) {
            this.f22488b = bArr;
            boolean z = true;
            this.f22496b = (i & 1) == 0;
            this.f22497c = (i & 2) == 0;
            if ((i & 4) == 0) {
                z = false;
            }
            this.f22498d = z;
            this.f22500f = (i & 8) == 0 ? f22493c : f22494d;
            this.f22499e = new byte[2];
            this.f22495b = 0;
            this.count = this.f22497c ? 19 : -1;
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x018e  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x01be  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0097 A[EDGE_INSN: B:99:0x0097->B:24:0x0097 ?: BREAK  
EDGE_INSN: B:99:0x0097->B:24:0x0097 ?: BREAK  
EDGE_INSN: B:99:0x0097->B:24:0x0097 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0097 A[EDGE_INSN: B:99:0x0097->B:24:0x0097 ?: BREAK  
EDGE_INSN: B:99:0x0097->B:24:0x0097 ?: BREAK  , SYNTHETIC] */
        /* renamed from: a */
        public boolean mo32656a(byte[] r18, int r19, int r20, boolean r21) {
            /*
            r17 = this;
            r0 = r17
            byte[] r1 = r0.f22500f
            byte[] r2 = r0.f22488b
            int r3 = r0.count
            int r4 = r20 + r19
            int r5 = r0.f22495b
            r6 = -1
            r7 = 0
            r8 = 2
            r9 = 1
            if (r5 == 0) goto L_0x0053
            if (r5 == r9) goto L_0x0034
            if (r5 == r8) goto L_0x0017
            goto L_0x0053
        L_0x0017:
            int r5 = r19 + 1
            if (r5 > r4) goto L_0x0053
            byte[] r10 = r0.f22499e
            byte r11 = r10[r7]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            byte r10 = r10[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r11
            byte r11 = r18[r19]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            r0.f22495b = r7
            r11 = r5
            r5 = r10
            goto L_0x0056
        L_0x0034:
            int r5 = r19 + 2
            if (r5 > r4) goto L_0x0053
            byte[] r5 = r0.f22499e
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            int r10 = r19 + 1
            byte r11 = r18[r19]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r5 = r5 | r11
            int r11 = r10 + 1
            byte r10 = r18[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r5 = r5 | r10
            r0.f22495b = r7
            goto L_0x0056
        L_0x0053:
            r11 = r19
            r5 = -1
        L_0x0056:
            r12 = 4
            r13 = 13
            r14 = 10
            if (r5 == r6) goto L_0x0092
            int r6 = r5 >> 18
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r7] = r6
            int r6 = r5 >> 12
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r9] = r6
            int r6 = r5 >> 6
            r6 = r6 & 63
            byte r6 = r1[r6]
            r2[r8] = r6
            r5 = r5 & 63
            byte r5 = r1[r5]
            r6 = 3
            r2[r6] = r5
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x0090
            boolean r3 = r0.f22498d
            if (r3 == 0) goto L_0x0088
            r3 = 5
            r2[r12] = r13
            goto L_0x0089
        L_0x0088:
            r3 = 4
        L_0x0089:
            int r5 = r3 + 1
            r2[r3] = r14
            r3 = 19
            goto L_0x0093
        L_0x0090:
            r5 = 4
            goto L_0x0093
        L_0x0092:
            r5 = 0
        L_0x0093:
            int r6 = r11 + 3
            if (r6 <= r4) goto L_0x01be
            if (r21 == 0) goto L_0x018e
            int r6 = r0.f22495b
            int r15 = r11 - r6
            int r10 = r4 + -1
            if (r15 != r10) goto L_0x00eb
            if (r6 <= 0) goto L_0x00a9
            byte[] r6 = r0.f22499e
            byte r6 = r6[r7]
            r7 = 1
            goto L_0x00af
        L_0x00a9:
            int r6 = r11 + 1
            byte r8 = r18[r11]
            r11 = r6
            r6 = r8
        L_0x00af:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r12
            int r8 = r0.f22495b
            int r8 = r8 - r7
            r0.f22495b = r8
            int r7 = r5 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r7] = r1
            boolean r1 = r0.f22496b
            if (r1 == 0) goto L_0x00d7
            int r1 = r5 + 1
            r6 = 61
            r2[r5] = r6
            int r5 = r1 + 1
            r2[r1] = r6
        L_0x00d7:
            boolean r1 = r0.f22497c
            if (r1 == 0) goto L_0x0172
            boolean r1 = r0.f22498d
            if (r1 == 0) goto L_0x00e4
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x00e5
        L_0x00e4:
            r1 = r5
        L_0x00e5:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x0172
        L_0x00eb:
            int r10 = r11 - r6
            int r12 = r4 + -2
            if (r10 != r12) goto L_0x015a
            if (r6 <= r9) goto L_0x00f9
            byte[] r6 = r0.f22499e
            byte r6 = r6[r7]
            r7 = 1
            goto L_0x00ff
        L_0x00f9:
            int r6 = r11 + 1
            byte r10 = r18[r11]
            r11 = r6
            r6 = r10
        L_0x00ff:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r14
            int r10 = r0.f22495b
            if (r10 <= 0) goto L_0x010f
            byte[] r10 = r0.f22499e
            int r12 = r7 + 1
            byte r7 = r10[r7]
            r10 = r11
            r11 = r7
            goto L_0x0114
        L_0x010f:
            int r10 = r11 + 1
            byte r11 = r18[r11]
            r12 = r7
        L_0x0114:
            r7 = r11 & 255(0xff, float:3.57E-43)
            int r7 = r7 << r8
            r6 = r6 | r7
            int r7 = r0.f22495b
            int r7 = r7 - r12
            r0.f22495b = r7
            int r7 = r5 + 1
            int r8 = r6 >> 12
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r5] = r8
            int r5 = r7 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r7] = r8
            int r7 = r5 + 1
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r5] = r1
            boolean r1 = r0.f22496b
            if (r1 == 0) goto L_0x0144
            int r1 = r7 + 1
            r5 = 61
            r2[r7] = r5
            goto L_0x0145
        L_0x0144:
            r1 = r7
        L_0x0145:
            boolean r5 = r0.f22497c
            if (r5 == 0) goto L_0x0157
            boolean r5 = r0.f22498d
            if (r5 == 0) goto L_0x0152
            int r5 = r1 + 1
            r2[r1] = r13
            r1 = r5
        L_0x0152:
            int r5 = r1 + 1
            r2[r1] = r14
            goto L_0x0158
        L_0x0157:
            r5 = r1
        L_0x0158:
            r11 = r10
            goto L_0x0172
        L_0x015a:
            boolean r1 = r0.f22497c
            if (r1 == 0) goto L_0x0172
            if (r5 <= 0) goto L_0x0172
            r10 = 19
            if (r3 == r10) goto L_0x0172
            boolean r1 = r0.f22498d
            if (r1 == 0) goto L_0x016d
            int r1 = r5 + 1
            r2[r5] = r13
            goto L_0x016e
        L_0x016d:
            r1 = r5
        L_0x016e:
            int r5 = r1 + 1
            r2[r1] = r14
        L_0x0172:
            boolean r1 = f22492a
            if (r1 != 0) goto L_0x0181
            int r1 = r0.f22495b
            if (r1 != 0) goto L_0x017b
            goto L_0x0181
        L_0x017b:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x0181:
            boolean r1 = f22492a
            if (r1 != 0) goto L_0x01b9
            if (r11 != r4) goto L_0x0188
            goto L_0x01b9
        L_0x0188:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x018e:
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x019f
            byte[] r1 = r0.f22499e
            int r2 = r0.f22495b
            int r4 = r2 + 1
            r0.f22495b = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            goto L_0x01b9
        L_0x019f:
            int r4 = r4 - r8
            if (r11 != r4) goto L_0x01b9
            byte[] r1 = r0.f22499e
            int r2 = r0.f22495b
            int r4 = r2 + 1
            r0.f22495b = r4
            byte r4 = r18[r11]
            r1[r2] = r4
            int r2 = r0.f22495b
            int r4 = r2 + 1
            r0.f22495b = r4
            int r11 = r11 + r9
            byte r4 = r18[r11]
            r1[r2] = r4
        L_0x01b9:
            r0.f22487a = r5
            r0.count = r3
            return r9
        L_0x01be:
            r10 = 19
            byte r15 = r18[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            int r16 = r11 + 1
            byte r7 = r18[r16]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            r7 = r7 | r15
            int r11 = r11 + 2
            byte r11 = r18[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r7 = r7 | r11
            int r11 = r7 >> 18
            r11 = r11 & 63
            byte r11 = r1[r11]
            r2[r5] = r11
            int r11 = r5 + 1
            int r15 = r7 >> 12
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r5 + 2
            int r15 = r7 >> 6
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r5 + 3
            r7 = r7 & 63
            byte r7 = r1[r7]
            r2[r11] = r7
            int r5 = r5 + 4
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x0212
            boolean r3 = r0.f22498d
            if (r3 == 0) goto L_0x0209
            int r3 = r5 + 1
            r2[r5] = r13
            goto L_0x020a
        L_0x0209:
            r3 = r5
        L_0x020a:
            int r5 = r3 + 1
            r2[r3] = r14
            r11 = r6
            r3 = 19
            goto L_0x0213
        L_0x0212:
            r11 = r6
        L_0x0213:
            r7 = 0
            goto L_0x0093
            */
            throw new UnsupportedOperationException("Method not decompiled: com.p570ta.utdid2.p572b.p573a.C6797b.C6800c.mo32656a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i3) {
        C6799b bVar = new C6799b(i3, new byte[((i2 * 3) / 4)]);
        if (!bVar.mo32655a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (bVar.f22487a == bVar.f22488b.length) {
            return bVar.f22488b;
        } else {
            byte[] bArr2 = new byte[bVar.f22487a];
            System.arraycopy(bVar.f22488b, 0, bArr2, 0, bVar.f22487a);
            return bArr2;
        }
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i3) {
        C6800c cVar = new C6800c(i3, null);
        int i4 = (i2 / 3) * 4;
        int i5 = 2;
        if (!cVar.f22496b) {
            int i6 = i2 % 3;
            if (i6 != 0) {
                if (i6 == 1) {
                    i4 += 2;
                } else if (i6 == 2) {
                    i4 += 3;
                }
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.f22497c && i2 > 0) {
            int i7 = ((i2 - 1) / 57) + 1;
            if (!cVar.f22498d) {
                i5 = 1;
            }
            i4 += i7 * i5;
        }
        cVar.f22488b = new byte[i4];
        cVar.mo32656a(bArr, i, i2, true);
        if (f22486a || cVar.f22487a == i4) {
            return cVar.f22488b;
        }
        throw new AssertionError();
    }

    private C6797b() {
    }
}
