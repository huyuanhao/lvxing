package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
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
public class TrackConnectRsp implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField POLL_INTERVAL_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField RESULT_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField SESSION_ID_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7413aw(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("TrackConnectRsp");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7415ay(null);
    /* access modifiers changed from: private|static|final */
    public static final TField VERSION_FIELD_DESC;
    private static final int __POLLINTERVAL_ISSET_ID = 1;
    private static final int __VERSION_ISSET_ID = 0;
    public static final Map metaDataMap;
    private byte __isset_bitfield = 0;
    public int pollInterval;
    public ReqResult result;
    public String sessionId;
    public short version;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.TrackConnectRsp$_Fields */
    public enum _Fields implements TFieldIdEnum {
        SESSION_ID(1, "sessionId"),
        VERSION(2, AppEntity.KEY_VERSION_STR),
        RESULT(3, ArgKey.KEY_RESULT),
        POLL_INTERVAL(4, "pollInterval");
        
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
        public static _Fields m32101a(int i) {
            if (i == 1) {
                return SESSION_ID;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i == 3) {
                return RESULT;
            }
            if (i != 4) {
                return null;
            }
            return POLL_INTERVAL;
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
        String str2 = AppEntity.KEY_VERSION_STR;
        VERSION_FIELD_DESC = new TField(str2, 6, 2);
        String str3 = ArgKey.KEY_RESULT;
        RESULT_FIELD_DESC = new TField(str3, JceStruct.ZERO_TAG, 3);
        String str4 = "pollInterval";
        POLL_INTERVAL_FIELD_DESC = new TField(str4, 8, 4);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData(str, 1, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.VERSION, new FieldMetaData(str2, 1, new FieldValueMetaData(6)));
        enumMap.put(_Fields.RESULT, new FieldMetaData(str3, 1, new StructMetaData(JceStruct.ZERO_TAG, ReqResult.class)));
        enumMap.put(_Fields.POLL_INTERVAL, new FieldMetaData(str4, 1, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TrackConnectRsp.class, metaDataMap);
    }

    public TrackConnectRsp() {
    }

    public TrackConnectRsp(TrackConnectRsp trackConnectRsp) {
        this.__isset_bitfield = trackConnectRsp.__isset_bitfield;
        if (trackConnectRsp.mo36202d()) {
            this.sessionId = trackConnectRsp.sessionId;
        }
        this.version = trackConnectRsp.version;
        if (trackConnectRsp.mo36210j()) {
            this.result = new ReqResult(trackConnectRsp.result);
        }
        this.pollInterval = trackConnectRsp.pollInterval;
    }

    /* renamed from: a */
    public TrackConnectRsp deepCopy() {
        return new TrackConnectRsp(this);
    }

    public void clear() {
        this.sessionId = null;
        mo36196b(false);
        this.version = 0;
        this.result = null;
        mo36201d(false);
        this.pollInterval = 0;
    }

    /* renamed from: b */
    public String mo36195b() {
        return this.sessionId;
    }

    /* renamed from: a */
    public TrackConnectRsp mo36187a(String str) {
        this.sessionId = str;
        return this;
    }

    /* renamed from: c */
    public void mo36198c() {
        this.sessionId = null;
    }

    /* renamed from: d */
    public boolean mo36202d() {
        return this.sessionId != null;
    }

    /* renamed from: a */
    public void mo36191a(boolean z) {
        if (!z) {
            this.sessionId = null;
        }
    }

    /* renamed from: e */
    public short mo36203e() {
        return this.version;
    }

    /* renamed from: a */
    public TrackConnectRsp mo36188a(short s) {
        this.version = s;
        mo36196b(true);
        return this;
    }

    /* renamed from: f */
    public void mo36205f() {
        this.__isset_bitfield = EncodingUtils.m36972b(this.__isset_bitfield, 0);
    }

    /* renamed from: g */
    public boolean mo36206g() {
        return EncodingUtils.m36970a(this.__isset_bitfield, 0);
    }

    /* renamed from: b */
    public void mo36196b(boolean z) {
        this.__isset_bitfield = EncodingUtils.m36966a(this.__isset_bitfield, 0, z);
    }

    /* renamed from: h */
    public ReqResult mo36207h() {
        return this.result;
    }

    /* renamed from: a */
    public TrackConnectRsp mo36186a(ReqResult reqResult) {
        this.result = reqResult;
        return this;
    }

    /* renamed from: i */
    public void mo36209i() {
        this.result = null;
    }

    /* renamed from: j */
    public boolean mo36210j() {
        return this.result != null;
    }

    /* renamed from: c */
    public void mo36199c(boolean z) {
        if (!z) {
            this.result = null;
        }
    }

    /* renamed from: k */
    public int mo36211k() {
        return this.pollInterval;
    }

    /* renamed from: a */
    public TrackConnectRsp mo36185a(int i) {
        this.pollInterval = i;
        mo36201d(true);
        return this;
    }

    /* renamed from: l */
    public void mo36212l() {
        this.__isset_bitfield = EncodingUtils.m36972b(this.__isset_bitfield, 1);
    }

    /* renamed from: m */
    public boolean mo36213m() {
        return EncodingUtils.m36970a(this.__isset_bitfield, 1);
    }

    /* renamed from: d */
    public void mo36201d(boolean z) {
        this.__isset_bitfield = EncodingUtils.m36966a(this.__isset_bitfield, 1, z);
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7411au.f24986a[_fields.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (obj == null) {
                            mo36212l();
                        } else {
                            mo36185a(((Integer) obj).intValue());
                        }
                    }
                } else if (obj == null) {
                    mo36209i();
                } else {
                    mo36186a((ReqResult) obj);
                }
            } else if (obj == null) {
                mo36205f();
            } else {
                mo36188a(((Short) obj).shortValue());
            }
        } else if (obj == null) {
            mo36198c();
        } else {
            mo36187a((String) obj);
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7411au.f24986a[_fields.ordinal()];
        if (i == 1) {
            return mo36195b();
        }
        if (i == 2) {
            return Short.valueOf(mo36203e());
        }
        if (i == 3) {
            return mo36207h();
        }
        if (i == 4) {
            return Integer.valueOf(mo36211k());
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7411au.f24986a[_fields.ordinal()];
            if (i == 1) {
                return mo36202d();
            }
            if (i == 2) {
                return mo36206g();
            }
            if (i == 3) {
                return mo36210j();
            }
            if (i == 4) {
                return mo36213m();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TrackConnectRsp)) {
            return mo36192a((TrackConnectRsp) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36192a(TrackConnectRsp trackConnectRsp) {
        if (trackConnectRsp == null) {
            return false;
        }
        if (this == trackConnectRsp) {
            return true;
        }
        boolean d = mo36202d();
        boolean d2 = trackConnectRsp.mo36202d();
        if (((d || d2) && (!d || !d2 || !this.sessionId.equals(trackConnectRsp.sessionId))) || this.version != trackConnectRsp.version) {
            return false;
        }
        boolean j = mo36210j();
        boolean j2 = trackConnectRsp.mo36210j();
        return ((!j && !j2) || (j && j2 && this.result.mo36120a(trackConnectRsp.result))) && this.pollInterval == trackConnectRsp.pollInterval;
    }

    public int hashCode() {
        int i = 131071;
        int i2 = (mo36202d() ? 131071 : 524287) + 8191;
        if (mo36202d()) {
            i2 = (i2 * 8191) + this.sessionId.hashCode();
        }
        int i3 = ((i2 * 8191) + this.version) * 8191;
        if (!mo36210j()) {
            i = 524287;
        }
        int i4 = i3 + i;
        if (mo36210j()) {
            i4 = (i4 * 8191) + this.result.hashCode();
        }
        return (i4 * 8191) + this.pollInterval;
    }

    /* renamed from: b */
    public int compareTo(TrackConnectRsp trackConnectRsp) {
        if (!getClass().equals(trackConnectRsp.getClass())) {
            return getClass().getName().compareTo(trackConnectRsp.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36202d()).compareTo(Boolean.valueOf(trackConnectRsp.mo36202d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36202d()) {
            int a = TBaseHelper.m36980a(this.sessionId, trackConnectRsp.sessionId);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo36206g()).compareTo(Boolean.valueOf(trackConnectRsp.mo36206g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo36206g()) {
            int a2 = TBaseHelper.m36984a(this.version, trackConnectRsp.version);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo3 = Boolean.valueOf(mo36210j()).compareTo(Boolean.valueOf(trackConnectRsp.mo36210j()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo36210j()) {
            int a3 = TBaseHelper.m36979a((Comparable) this.result, (Comparable) trackConnectRsp.result);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo4 = Boolean.valueOf(mo36213m()).compareTo(Boolean.valueOf(trackConnectRsp.mo36213m()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo36213m()) {
            int a4 = TBaseHelper.m36978a(this.pollInterval, trackConnectRsp.pollInterval);
            if (a4 != 0) {
                return a4;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public _Fields fieldForId(int i) {
        return _Fields.m32101a(i);
    }

    public void read(TProtocol fVar) {
        m32067a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m32067a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackConnectRsp(");
        sb.append("sessionId:");
        String str = this.sessionId;
        String str2 = "null";
        if (str == null) {
            sb.append(str2);
        } else {
            sb.append(str);
        }
        String str3 = ", ";
        sb.append(str3);
        sb.append("version:");
        sb.append(this.version);
        sb.append(str3);
        sb.append("result:");
        ReqResult reqResult = this.result;
        if (reqResult == null) {
            sb.append(str2);
        } else {
            sb.append(reqResult);
        }
        sb.append(str3);
        sb.append("pollInterval:");
        sb.append(this.pollInterval);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: n */
    public void mo36214n() {
        if (this.sessionId != null) {
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
            sb2.append("Required field 'sessionId' was not present! Struct: ");
            sb2.append(toString());
            throw new TProtocolException(sb2.toString());
        }
    }

    /* renamed from: a */
    private static IScheme m32067a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
