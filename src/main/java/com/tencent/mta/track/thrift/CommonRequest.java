package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
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
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.SchemeFactory;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;

/* compiled from: ProGuard */
public class CommonRequest implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField BODY_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField CMD_TYPE_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField SEQ_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7437c(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("CommonRequest");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7439e(null);
    private static final int __SEQ_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.BODY};
    private byte __isset_bitfield = 0;
    public String body;
    public CommonCmdType cmdType;
    public int seq;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.CommonRequest$_Fields */
    public enum _Fields implements TFieldIdEnum {
        SEQ(1, "seq"),
        CMD_TYPE(2, "cmdType"),
        BODY(3, "body");
        
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
        public static _Fields m31851a(int i) {
            if (i == 1) {
                return SEQ;
            }
            if (i == 2) {
                return CMD_TYPE;
            }
            if (i != 3) {
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
        String str3 = "body";
        BODY_FIELD_DESC = new TField(str3, JceStruct.STRUCT_END, 3);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.SEQ, new FieldMetaData(str, 1, new FieldValueMetaData(8)));
        enumMap.put(_Fields.CMD_TYPE, new FieldMetaData(str2, 1, new EnumMetaData(16, CommonCmdType.class)));
        enumMap.put(_Fields.BODY, new FieldMetaData(str3, 2, new FieldValueMetaData(JceStruct.STRUCT_END)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(CommonRequest.class, metaDataMap);
    }

    public CommonRequest() {
    }

    public CommonRequest(CommonRequest commonRequest) {
        this.__isset_bitfield = commonRequest.__isset_bitfield;
        this.seq = commonRequest.seq;
        if (commonRequest.mo35956g()) {
            this.cmdType = commonRequest.cmdType;
        }
        if (commonRequest.mo35962j()) {
            this.body = commonRequest.body;
        }
    }

    /* renamed from: a */
    public CommonRequest deepCopy() {
        return new CommonRequest(this);
    }

    public void clear() {
        mo35939a(false);
        this.seq = 0;
        this.cmdType = null;
        this.body = null;
    }

    /* renamed from: b */
    public int mo35941b() {
        return this.seq;
    }

    /* renamed from: a */
    public CommonRequest mo35934a(int i) {
        this.seq = i;
        mo35939a(true);
        return this;
    }

    /* renamed from: c */
    public void mo35946c() {
        this.__isset_bitfield = EncodingUtils.m36972b(this.__isset_bitfield, 0);
    }

    /* renamed from: d */
    public boolean mo35950d() {
        return EncodingUtils.m36970a(this.__isset_bitfield, 0);
    }

    /* renamed from: a */
    public void mo35939a(boolean z) {
        this.__isset_bitfield = EncodingUtils.m36966a(this.__isset_bitfield, 0, z);
    }

    /* renamed from: e */
    public CommonCmdType mo35952e() {
        return this.cmdType;
    }

    /* renamed from: a */
    public CommonRequest mo35935a(CommonCmdType commonCmdType) {
        this.cmdType = commonCmdType;
        return this;
    }

    /* renamed from: f */
    public void mo35954f() {
        this.cmdType = null;
    }

    /* renamed from: g */
    public boolean mo35956g() {
        return this.cmdType != null;
    }

    /* renamed from: b */
    public void mo35944b(boolean z) {
        if (!z) {
            this.cmdType = null;
        }
    }

    /* renamed from: h */
    public String mo35958h() {
        return this.body;
    }

    /* renamed from: a */
    public CommonRequest mo35936a(String str) {
        this.body = str;
        return this;
    }

    /* renamed from: i */
    public void mo35960i() {
        this.body = null;
    }

    /* renamed from: j */
    public boolean mo35962j() {
        return this.body != null;
    }

    /* renamed from: c */
    public void mo35947c(boolean z) {
        if (!z) {
            this.body = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7390a.f24983a[_fields.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (obj == null) {
                        mo35960i();
                    } else {
                        mo35936a((String) obj);
                    }
                }
            } else if (obj == null) {
                mo35954f();
            } else {
                mo35935a((CommonCmdType) obj);
            }
        } else if (obj == null) {
            mo35946c();
        } else {
            mo35934a(((Integer) obj).intValue());
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7390a.f24983a[_fields.ordinal()];
        if (i == 1) {
            return Integer.valueOf(mo35941b());
        }
        if (i == 2) {
            return mo35952e();
        }
        if (i == 3) {
            return mo35958h();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7390a.f24983a[_fields.ordinal()];
            if (i == 1) {
                return mo35950d();
            }
            if (i == 2) {
                return mo35956g();
            }
            if (i == 3) {
                return mo35962j();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof CommonRequest)) {
            return mo35940a((CommonRequest) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo35940a(CommonRequest commonRequest) {
        if (commonRequest == null) {
            return false;
        }
        if (this == commonRequest) {
            return true;
        }
        if (this.seq != commonRequest.seq) {
            return false;
        }
        boolean g = mo35956g();
        boolean g2 = commonRequest.mo35956g();
        if ((g || g2) && (!g || !g2 || !this.cmdType.equals(commonRequest.cmdType))) {
            return false;
        }
        boolean j = mo35962j();
        boolean j2 = commonRequest.mo35962j();
        return (!j && !j2) || (j && j2 && this.body.equals(commonRequest.body));
    }

    public int hashCode() {
        int i = 131071;
        int i2 = ((this.seq + 8191) * 8191) + (mo35956g() ? 131071 : 524287);
        if (mo35956g()) {
            i2 = (i2 * 8191) + this.cmdType.getValue();
        }
        int i3 = i2 * 8191;
        if (!mo35962j()) {
            i = 524287;
        }
        int i4 = i3 + i;
        return mo35962j() ? (i4 * 8191) + this.body.hashCode() : i4;
    }

    /* renamed from: b */
    public int compareTo(CommonRequest commonRequest) {
        if (!getClass().equals(commonRequest.getClass())) {
            return getClass().getName().compareTo(commonRequest.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo35950d()).compareTo(Boolean.valueOf(commonRequest.mo35950d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo35950d()) {
            int a = TBaseHelper.m36978a(this.seq, commonRequest.seq);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo35956g()).compareTo(Boolean.valueOf(commonRequest.mo35956g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo35956g()) {
            int a2 = TBaseHelper.m36979a((Comparable) this.cmdType, (Comparable) commonRequest.cmdType);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo3 = Boolean.valueOf(mo35962j()).compareTo(Boolean.valueOf(commonRequest.mo35962j()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo35962j()) {
            int a3 = TBaseHelper.m36980a(this.body, commonRequest.body);
            if (a3 != 0) {
                return a3;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public _Fields fieldForId(int i) {
        return _Fields.m31851a(i);
    }

    public void read(TProtocol fVar) {
        m31823a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m31823a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CommonRequest(");
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
        if (mo35962j()) {
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

    /* renamed from: k */
    public void mo35963k() {
        if (this.cmdType == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'cmdType' was not present! Struct: ");
            sb.append(toString());
            throw new TProtocolException(sb.toString());
        }
    }

    /* renamed from: a */
    private static IScheme m31823a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
