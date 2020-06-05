package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
public class ReqResult implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField ERROR_CODE_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField ERROR_MSG_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7403am(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("ReqResult");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7405ao(null);
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.ERROR_MSG};
    public ErrorCode errorCode;
    public String errorMsg;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.ReqResult$_Fields */
    public enum _Fields implements TFieldIdEnum {
        ERROR_CODE(1, "errorCode"),
        ERROR_MSG(2, "errorMsg");
        
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
        public static _Fields m32013a(int i) {
            if (i == 1) {
                return ERROR_CODE;
            }
            if (i != 2) {
                return null;
            }
            return ERROR_MSG;
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
        String str = "errorCode";
        ERROR_CODE_FIELD_DESC = new TField(str, 8, 1);
        String str2 = "errorMsg";
        ERROR_MSG_FIELD_DESC = new TField(str2, JceStruct.STRUCT_END, 2);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.ERROR_CODE, new FieldMetaData(str, 1, new EnumMetaData(16, ErrorCode.class)));
        enumMap.put(_Fields.ERROR_MSG, new FieldMetaData(str2, 2, new FieldValueMetaData(JceStruct.STRUCT_END)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(ReqResult.class, metaDataMap);
    }

    public ReqResult() {
    }

    public ReqResult(ReqResult reqResult) {
        if (reqResult.mo36127d()) {
            this.errorCode = reqResult.errorCode;
        }
        if (reqResult.mo36131g()) {
            this.errorMsg = reqResult.errorMsg;
        }
    }

    /* renamed from: a */
    public ReqResult deepCopy() {
        return new ReqResult(this);
    }

    public void clear() {
        this.errorCode = null;
        this.errorMsg = null;
    }

    /* renamed from: b */
    public ErrorCode mo36122b() {
        return this.errorCode;
    }

    /* renamed from: a */
    public ReqResult mo36115a(ErrorCode errorCode2) {
        this.errorCode = errorCode2;
        return this;
    }

    /* renamed from: c */
    public void mo36125c() {
        this.errorCode = null;
    }

    /* renamed from: d */
    public boolean mo36127d() {
        return this.errorCode != null;
    }

    /* renamed from: a */
    public void mo36119a(boolean z) {
        if (!z) {
            this.errorCode = null;
        }
    }

    /* renamed from: e */
    public String mo36128e() {
        return this.errorMsg;
    }

    /* renamed from: a */
    public ReqResult mo36116a(String str) {
        this.errorMsg = str;
        return this;
    }

    /* renamed from: f */
    public void mo36130f() {
        this.errorMsg = null;
    }

    /* renamed from: g */
    public boolean mo36131g() {
        return this.errorMsg != null;
    }

    /* renamed from: b */
    public void mo36123b(boolean z) {
        if (!z) {
            this.errorMsg = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7401ak.f24984a[_fields.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (obj == null) {
                    mo36130f();
                } else {
                    mo36116a((String) obj);
                }
            }
        } else if (obj == null) {
            mo36125c();
        } else {
            mo36115a((ErrorCode) obj);
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7401ak.f24984a[_fields.ordinal()];
        if (i == 1) {
            return mo36122b();
        }
        if (i == 2) {
            return mo36128e();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7401ak.f24984a[_fields.ordinal()];
            if (i == 1) {
                return mo36127d();
            }
            if (i == 2) {
                return mo36131g();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ReqResult)) {
            return mo36120a((ReqResult) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36120a(ReqResult reqResult) {
        if (reqResult == null) {
            return false;
        }
        if (this == reqResult) {
            return true;
        }
        boolean d = mo36127d();
        boolean d2 = reqResult.mo36127d();
        if ((d || d2) && (!d || !d2 || !this.errorCode.equals(reqResult.errorCode))) {
            return false;
        }
        boolean g = mo36131g();
        boolean g2 = reqResult.mo36131g();
        return (!g && !g2) || (g && g2 && this.errorMsg.equals(reqResult.errorMsg));
    }

    public int hashCode() {
        int i = 131071;
        int i2 = (mo36127d() ? 131071 : 524287) + 8191;
        if (mo36127d()) {
            i2 = (i2 * 8191) + this.errorCode.getValue();
        }
        int i3 = i2 * 8191;
        if (!mo36131g()) {
            i = 524287;
        }
        int i4 = i3 + i;
        return mo36131g() ? (i4 * 8191) + this.errorMsg.hashCode() : i4;
    }

    /* renamed from: b */
    public int compareTo(ReqResult reqResult) {
        if (!getClass().equals(reqResult.getClass())) {
            return getClass().getName().compareTo(reqResult.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36127d()).compareTo(Boolean.valueOf(reqResult.mo36127d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36127d()) {
            int a = TBaseHelper.m36979a((Comparable) this.errorCode, (Comparable) reqResult.errorCode);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo36131g()).compareTo(Boolean.valueOf(reqResult.mo36131g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo36131g()) {
            int a2 = TBaseHelper.m36980a(this.errorMsg, reqResult.errorMsg);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public _Fields fieldForId(int i) {
        return _Fields.m32013a(i);
    }

    public void read(TProtocol fVar) {
        m31991a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m31991a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ReqResult(");
        sb.append("errorCode:");
        ErrorCode errorCode2 = this.errorCode;
        String str = "null";
        if (errorCode2 == null) {
            sb.append(str);
        } else {
            sb.append(errorCode2);
        }
        if (mo36131g()) {
            sb.append(", ");
            sb.append("errorMsg:");
            String str2 = this.errorMsg;
            if (str2 == null) {
                sb.append(str);
            } else {
                sb.append(str2);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: h */
    public void mo36132h() {
        if (this.errorCode == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'errorCode' was not present! Struct: ");
            sb.append(toString());
            throw new TProtocolException(sb.toString());
        }
    }

    /* renamed from: a */
    private static IScheme m31991a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
