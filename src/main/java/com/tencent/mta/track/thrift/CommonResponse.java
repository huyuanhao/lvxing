package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.EnumMetaData;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.SchemeFactory;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;

/* compiled from: ProGuard */
public class CommonResponse implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField BODY_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField CMD_TYPE_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField RESULT_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField SEQ_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7442h(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("CommonResponse");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7444j(null);
    private static final int __SEQ_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.BODY};
    private byte __isset_bitfield = 0;
    public String body;
    public CommonCmdType cmdType;
    public ReqResult result;
    public int seq;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.CommonResponse$_Fields */
    public enum _Fields implements TFieldIdEnum {
        SEQ(1, "seq"),
        CMD_TYPE(2, "cmdType"),
        RESULT(3, ArgKey.KEY_RESULT),
        BODY(4, "body");
        
        private static final Map byName = null;
        private final String _fieldName;
        private final short _thriftId;

        static {
            byName = new HashMap();
            Iterator it = EnumSet.allOf(_Fields.class).iterator();
            while (it.hasNext()) {
                _Fields _fields = (_Fields) it.next();
                byName.put(_fields.getFieldName(), _fields);
            }
        }

        /* renamed from: a */
        public static _Fields m31886a(int i) {
            if (i == 1) {
                return SEQ;
            }
            if (i == 2) {
                return CMD_TYPE;
            }
            if (i == 3) {
                return RESULT;
            }
            if (i != 4) {
                return null;
            }
            return BODY;
        }

        private _Fields(short s, String str) {
            this._thriftId = s;
            this._fieldName = str;
        }

        public short getThriftFieldId() {
            return this._thriftId;
        }

        public String getFieldName() {
            return this._fieldName;
        }
    }

    static {
        String str = "seq";
        SEQ_FIELD_DESC = new TField(str, 8, 1);
        String str2 = "cmdType";
        CMD_TYPE_FIELD_DESC = new TField(str2, 8, 2);
        String str3 = ArgKey.KEY_RESULT;
        RESULT_FIELD_DESC = new TField(str3, JceStruct.ZERO_TAG, 3);
        String str4 = "body";
        BODY_FIELD_DESC = new TField(str4, JceStruct.STRUCT_END, 4);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.SEQ, new FieldMetaData(str, 1, new FieldValueMetaData(8)));
        enumMap.put(_Fields.CMD_TYPE, new FieldMetaData(str2, 1, new EnumMetaData(16, CommonCmdType.class)));
        enumMap.put(_Fields.RESULT, new FieldMetaData(str3, 1, new StructMetaData(JceStruct.ZERO_TAG, ReqResult.class)));
        enumMap.put(_Fields.BODY, new FieldMetaData(str4, 2, new FieldValueMetaData(JceStruct.STRUCT_END)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CommonResponse.class, metaDataMap);
    }

    public CommonResponse() {
    }

    public CommonResponse(CommonResponse commonResponse) {
        this.__isset_bitfield = commonResponse.__isset_bitfield;
        this.seq = commonResponse.seq;
        if (commonResponse.mo35992g()) {
            this.cmdType = commonResponse.cmdType;
        }
        if (commonResponse.mo35996j()) {
            this.result = new ReqResult(commonResponse.result);
        }
        if (commonResponse.mo35999m()) {
            this.body = commonResponse.body;
        }
    }

    /* renamed from: a */
    public CommonResponse deepCopy() {
        return new CommonResponse(this);
    }

    public void clear() {
        mo35977a(false);
        this.seq = 0;
        this.cmdType = null;
        this.result = null;
        this.body = null;
    }

    /* renamed from: b */
    public int mo35979b() {
        return this.seq;
    }

    /* renamed from: a */
    public CommonResponse mo35971a(int i) {
        this.seq = i;
        mo35977a(true);
        return this;
    }

    /* renamed from: c */
    public void mo35984c() {
        this.__isset_bitfield = EncodingUtils.m36972b(this.__isset_bitfield, 0);
    }

    /* renamed from: d */
    public boolean mo35988d() {
        return EncodingUtils.m36970a(this.__isset_bitfield, 0);
    }

    /* renamed from: a */
    public void mo35977a(boolean z) {
        this.__isset_bitfield = EncodingUtils.m36966a(this.__isset_bitfield, 0, z);
    }

    /* renamed from: e */
    public CommonCmdType mo35989e() {
        return this.cmdType;
    }

    /* renamed from: a */
    public CommonResponse mo35972a(CommonCmdType commonCmdType) {
        this.cmdType = commonCmdType;
        return this;
    }

    /* renamed from: f */
    public void mo35991f() {
        this.cmdType = null;
    }

    /* renamed from: g */
    public boolean mo35992g() {
        return this.cmdType != null;
    }

    /* renamed from: b */
    public void mo35982b(boolean z) {
        if (!z) {
            this.cmdType = null;
        }
    }

    /* renamed from: h */
    public ReqResult mo35993h() {
        return this.result;
    }

    /* renamed from: a */
    public CommonResponse mo35973a(ReqResult reqResult) {
        this.result = reqResult;
        return this;
    }

    /* renamed from: i */
    public void mo35995i() {
        this.result = null;
    }

    /* renamed from: j */
    public boolean mo35996j() {
        return this.result != null;
    }

    /* renamed from: c */
    public void mo35985c(boolean z) {
        if (!z) {
            this.result = null;
        }
    }

    /* renamed from: k */
    public String mo35997k() {
        return this.body;
    }

    /* renamed from: a */
    public CommonResponse mo35974a(String str) {
        this.body = str;
        return this;
    }

    /* renamed from: l */
    public void mo35998l() {
        this.body = null;
    }

    /* renamed from: m */
    public boolean mo35999m() {
        return this.body != null;
    }

    /* renamed from: d */
    public void mo35987d(boolean z) {
        if (!z) {
            this.body = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7440f.f24991a[_fields.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (obj == null) {
                            mo35998l();
                        } else {
                            mo35974a((String) obj);
                        }
                    }
                } else if (obj == null) {
                    mo35995i();
                } else {
                    mo35973a((ReqResult) obj);
                }
            } else if (obj == null) {
                mo35991f();
            } else {
                mo35972a((CommonCmdType) obj);
            }
        } else if (obj == null) {
            mo35984c();
        } else {
            mo35971a(((Integer) obj).intValue());
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7440f.f24991a[_fields.ordinal()];
        if (i == 1) {
            return Integer.valueOf(mo35979b());
        }
        if (i == 2) {
            return mo35989e();
        }
        if (i == 3) {
            return mo35993h();
        }
        if (i == 4) {
            return mo35997k();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7440f.f24991a[_fields.ordinal()];
            if (i == 1) {
                return mo35988d();
            }
            if (i == 2) {
                return mo35992g();
            }
            if (i == 3) {
                return mo35996j();
            }
            if (i == 4) {
                return mo35999m();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof CommonResponse)) {
            return mo35978a((CommonResponse) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo35978a(CommonResponse commonResponse) {
        if (commonResponse == null) {
            return false;
        }
        if (this == commonResponse) {
            return true;
        }
        if (this.seq != commonResponse.seq) {
            return false;
        }
        boolean g = mo35992g();
        boolean g2 = commonResponse.mo35992g();
        if ((g || g2) && (!g || !g2 || !this.cmdType.equals(commonResponse.cmdType))) {
            return false;
        }
        boolean j = mo35996j();
        boolean j2 = commonResponse.mo35996j();
        if ((j || j2) && (!j || !j2 || !this.result.mo36120a(commonResponse.result))) {
            return false;
        }
        boolean m = mo35999m();
        boolean m2 = commonResponse.mo35999m();
        return (!m && !m2) || (m && m2 && this.body.equals(commonResponse.body));
    }

    public int hashCode() {
        int i = 131071;
        int i2 = ((this.seq + 8191) * 8191) + (mo35992g() ? 131071 : 524287);
        if (mo35992g()) {
            i2 = (i2 * 8191) + this.cmdType.getValue();
        }
        int i3 = (i2 * 8191) + (mo35996j() ? 131071 : 524287);
        if (mo35996j()) {
            i3 = (i3 * 8191) + this.result.hashCode();
        }
        int i4 = i3 * 8191;
        if (!mo35999m()) {
            i = 524287;
        }
        int i5 = i4 + i;
        return mo35999m() ? (i5 * 8191) + this.body.hashCode() : i5;
    }

    /* renamed from: b */
    public int compareTo(CommonResponse commonResponse) {
        if (!getClass().equals(commonResponse.getClass())) {
            return getClass().getName().compareTo(commonResponse.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo35988d()).compareTo(Boolean.valueOf(commonResponse.mo35988d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo35988d()) {
            int a = TBaseHelper.m36978a(this.seq, commonResponse.seq);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo35992g()).compareTo(Boolean.valueOf(commonResponse.mo35992g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo35992g()) {
            int a2 = TBaseHelper.m36979a((Comparable) this.cmdType, (Comparable) commonResponse.cmdType);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo3 = Boolean.valueOf(mo35996j()).compareTo(Boolean.valueOf(commonResponse.mo35996j()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo35996j()) {
            int a3 = TBaseHelper.m36979a((Comparable) this.result, (Comparable) commonResponse.result);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo4 = Boolean.valueOf(mo35999m()).compareTo(Boolean.valueOf(commonResponse.mo35999m()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo35999m()) {
            int a4 = TBaseHelper.m36980a(this.body, commonResponse.body);
            if (a4 != 0) {
                return a4;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public _Fields fieldForId(int i) {
        return _Fields.m31886a(i);
    }

    public void read(TProtocol fVar) {
        m31852a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m31852a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CommonResponse(");
        sb.append("seq:");
        sb.append(this.seq);
        String str = ", ";
        sb.append(str);
        sb.append("cmdType:");
        CommonCmdType commonCmdType = this.cmdType;
        String str2 = "null";
        if (commonCmdType == null) {
            sb.append(str2);
        } else {
            sb.append(commonCmdType);
        }
        sb.append(str);
        sb.append("result:");
        ReqResult reqResult = this.result;
        if (reqResult == null) {
            sb.append(str2);
        } else {
            sb.append(reqResult);
        }
        if (mo35999m()) {
            sb.append(str);
            sb.append("body:");
            String str3 = this.body;
            if (str3 == null) {
                sb.append(str2);
            } else {
                sb.append(str3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: n */
    public void mo36000n() {
        if (this.cmdType != null) {
            ReqResult reqResult = this.result;
            if (reqResult == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Required field 'result' was not present! Struct: ");
                sb.append(toString());
                throw new TProtocolException(sb.toString());
            } else if (reqResult != null) {
                reqResult.mo36132h();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'cmdType' was not present! Struct: ");
            sb2.append(toString());
            throw new TProtocolException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static IScheme m31852a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
