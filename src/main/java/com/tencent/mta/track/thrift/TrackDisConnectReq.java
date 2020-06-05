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
public class TrackDisConnectReq implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField REASON_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField SESSION_ID_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7419bb(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("TrackDisConnectReq");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7421bd(null);
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.REASON};
    public String reason;
    public String sessionId;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.TrackDisConnectReq$_Fields */
    public enum _Fields implements TFieldIdEnum {
        SESSION_ID(1, "sessionId"),
        REASON(2, "reason");
        
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
        public static _Fields m32124a(int i) {
            if (i == 1) {
                return SESSION_ID;
            }
            if (i != 2) {
                return null;
            }
            return REASON;
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
        String str = "sessionId";
        SESSION_ID_FIELD_DESC = new TField(str, JceStruct.STRUCT_END, 1);
        String str2 = "reason";
        REASON_FIELD_DESC = new TField(str2, JceStruct.STRUCT_END, 2);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData(str, 1, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.REASON, new FieldMetaData(str2, 2, new FieldValueMetaData(JceStruct.STRUCT_END)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TrackDisConnectReq.class, metaDataMap);
    }

    public TrackDisConnectReq() {
    }

    public TrackDisConnectReq(TrackDisConnectReq trackDisConnectReq) {
        if (trackDisConnectReq.mo36231d()) {
            this.sessionId = trackDisConnectReq.sessionId;
        }
        if (trackDisConnectReq.mo36235g()) {
            this.reason = trackDisConnectReq.reason;
        }
    }

    /* renamed from: a */
    public TrackDisConnectReq deepCopy() {
        return new TrackDisConnectReq(this);
    }

    public void clear() {
        this.sessionId = null;
        this.reason = null;
    }

    /* renamed from: b */
    public String mo36226b() {
        return this.sessionId;
    }

    /* renamed from: a */
    public TrackDisConnectReq mo36219a(String str) {
        this.sessionId = str;
        return this;
    }

    /* renamed from: c */
    public void mo36229c() {
        this.sessionId = null;
    }

    /* renamed from: d */
    public boolean mo36231d() {
        return this.sessionId != null;
    }

    /* renamed from: a */
    public void mo36222a(boolean z) {
        if (!z) {
            this.sessionId = null;
        }
    }

    /* renamed from: e */
    public String mo36232e() {
        return this.reason;
    }

    /* renamed from: b */
    public TrackDisConnectReq mo36225b(String str) {
        this.reason = str;
        return this;
    }

    /* renamed from: f */
    public void mo36234f() {
        this.reason = null;
    }

    /* renamed from: g */
    public boolean mo36235g() {
        return this.reason != null;
    }

    /* renamed from: b */
    public void mo36227b(boolean z) {
        if (!z) {
            this.reason = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7416az.f24987a[_fields.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (obj == null) {
                    mo36234f();
                } else {
                    mo36225b((String) obj);
                }
            }
        } else if (obj == null) {
            mo36229c();
        } else {
            mo36219a((String) obj);
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7416az.f24987a[_fields.ordinal()];
        if (i == 1) {
            return mo36226b();
        }
        if (i == 2) {
            return mo36232e();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7416az.f24987a[_fields.ordinal()];
            if (i == 1) {
                return mo36231d();
            }
            if (i == 2) {
                return mo36235g();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TrackDisConnectReq)) {
            return mo36223a((TrackDisConnectReq) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36223a(TrackDisConnectReq trackDisConnectReq) {
        if (trackDisConnectReq == null) {
            return false;
        }
        if (this == trackDisConnectReq) {
            return true;
        }
        boolean d = mo36231d();
        boolean d2 = trackDisConnectReq.mo36231d();
        if ((d || d2) && (!d || !d2 || !this.sessionId.equals(trackDisConnectReq.sessionId))) {
            return false;
        }
        boolean g = mo36235g();
        boolean g2 = trackDisConnectReq.mo36235g();
        return (!g && !g2) || (g && g2 && this.reason.equals(trackDisConnectReq.reason));
    }

    public int hashCode() {
        int i = 131071;
        int i2 = (mo36231d() ? 131071 : 524287) + 8191;
        if (mo36231d()) {
            i2 = (i2 * 8191) + this.sessionId.hashCode();
        }
        int i3 = i2 * 8191;
        if (!mo36235g()) {
            i = 524287;
        }
        int i4 = i3 + i;
        return mo36235g() ? (i4 * 8191) + this.reason.hashCode() : i4;
    }

    /* renamed from: b */
    public int compareTo(TrackDisConnectReq trackDisConnectReq) {
        if (!getClass().equals(trackDisConnectReq.getClass())) {
            return getClass().getName().compareTo(trackDisConnectReq.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36231d()).compareTo(Boolean.valueOf(trackDisConnectReq.mo36231d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36231d()) {
            int a = TBaseHelper.m36980a(this.sessionId, trackDisConnectReq.sessionId);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo36235g()).compareTo(Boolean.valueOf(trackDisConnectReq.mo36235g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo36235g()) {
            int a2 = TBaseHelper.m36980a(this.reason, trackDisConnectReq.reason);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public _Fields fieldForId(int i) {
        return _Fields.m32124a(i);
    }

    public void read(TProtocol fVar) {
        m32102a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m32102a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackDisConnectReq(");
        sb.append("sessionId:");
        String str = this.sessionId;
        String str2 = "null";
        if (str == null) {
            sb.append(str2);
        } else {
            sb.append(str);
        }
        if (mo36235g()) {
            sb.append(", ");
            sb.append("reason:");
            String str3 = this.reason;
            if (str3 == null) {
                sb.append(str2);
            } else {
                sb.append(str3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: h */
    public void mo36236h() {
        if (this.sessionId == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'sessionId' was not present! Struct: ");
            sb.append(toString());
            throw new TProtocolException(sb.toString());
        }
    }

    /* renamed from: a */
    private static IScheme m32102a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
