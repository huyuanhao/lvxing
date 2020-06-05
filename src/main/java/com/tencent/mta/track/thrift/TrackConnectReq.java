package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import com.tencent.android.tpush.common.Constants;
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
public class TrackConnectReq implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField APP_KEY_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField DEVICE_ID_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField DEVICE_INFO_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField DEVICE_TYPE_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField LAST_SESSION_ID_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField SESSION_ID_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7408ar(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("TrackConnectReq");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7410at(null);
    /* access modifiers changed from: private|static|final */
    public static final TField VERSION_FIELD_DESC;
    private static final int __VERSION_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.DEVICE_ID, _Fields.LAST_SESSION_ID};
    private byte __isset_bitfield = 0;
    public String appKey;
    public String deviceId;
    public String deviceInfo;
    public DeviceType deviceType;
    public String lastSessionId;
    public String sessionId;
    public short version;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.TrackConnectReq$_Fields */
    public enum _Fields implements TFieldIdEnum {
        SESSION_ID(1, "sessionId"),
        VERSION(2, AppEntity.KEY_VERSION_STR),
        APP_KEY(3, "appKey"),
        DEVICE_INFO(4, "deviceInfo"),
        DEVICE_TYPE(5, "deviceType"),
        DEVICE_ID(6, Constants.FLAG_DEVICE_ID),
        LAST_SESSION_ID(7, "lastSessionId");
        
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
        public static _Fields m32066a(int i) {
            switch (i) {
                case 1:
                    return SESSION_ID;
                case 2:
                    return VERSION;
                case 3:
                    return APP_KEY;
                case 4:
                    return DEVICE_INFO;
                case 5:
                    return DEVICE_TYPE;
                case 6:
                    return DEVICE_ID;
                case 7:
                    return LAST_SESSION_ID;
                default:
                    return null;
            }
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
        String str3 = "appKey";
        APP_KEY_FIELD_DESC = new TField(str3, JceStruct.STRUCT_END, 3);
        String str4 = "deviceInfo";
        DEVICE_INFO_FIELD_DESC = new TField(str4, JceStruct.STRUCT_END, 4);
        String str5 = "deviceType";
        DEVICE_TYPE_FIELD_DESC = new TField(str5, 8, 5);
        String str6 = Constants.FLAG_DEVICE_ID;
        DEVICE_ID_FIELD_DESC = new TField(str6, JceStruct.STRUCT_END, 6);
        String str7 = "lastSessionId";
        LAST_SESSION_ID_FIELD_DESC = new TField(str7, JceStruct.STRUCT_END, 7);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData(str, 1, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.VERSION, new FieldMetaData(str2, 1, new FieldValueMetaData(6)));
        enumMap.put(_Fields.APP_KEY, new FieldMetaData(str3, 1, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.DEVICE_INFO, new FieldMetaData(str4, 1, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.DEVICE_TYPE, new FieldMetaData(str5, 1, new EnumMetaData(16, DeviceType.class)));
        enumMap.put(_Fields.DEVICE_ID, new FieldMetaData(str6, 2, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.LAST_SESSION_ID, new FieldMetaData(str7, 2, new FieldValueMetaData(JceStruct.STRUCT_END)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TrackConnectReq.class, metaDataMap);
    }

    public TrackConnectReq() {
    }

    public TrackConnectReq(TrackConnectReq trackConnectReq) {
        this.__isset_bitfield = trackConnectReq.__isset_bitfield;
        if (trackConnectReq.mo36156d()) {
            this.sessionId = trackConnectReq.sessionId;
        }
        this.version = trackConnectReq.version;
        if (trackConnectReq.mo36168j()) {
            this.appKey = trackConnectReq.appKey;
        }
        if (trackConnectReq.mo36171m()) {
            this.deviceInfo = trackConnectReq.deviceInfo;
        }
        if (trackConnectReq.mo36174p()) {
            this.deviceType = trackConnectReq.deviceType;
        }
        if (trackConnectReq.mo36177s()) {
            this.deviceId = trackConnectReq.deviceId;
        }
        if (trackConnectReq.mo36181v()) {
            this.lastSessionId = trackConnectReq.lastSessionId;
        }
    }

    /* renamed from: a */
    public TrackConnectReq deepCopy() {
        return new TrackConnectReq(this);
    }

    public void clear() {
        this.sessionId = null;
        mo36148b(false);
        this.version = 0;
        this.appKey = null;
        this.deviceInfo = null;
        this.deviceType = null;
        this.deviceId = null;
        this.lastSessionId = null;
    }

    /* renamed from: b */
    public String mo36147b() {
        return this.sessionId;
    }

    /* renamed from: a */
    public TrackConnectReq mo36139a(String str) {
        this.sessionId = str;
        return this;
    }

    /* renamed from: c */
    public void mo36151c() {
        this.sessionId = null;
    }

    /* renamed from: d */
    public boolean mo36156d() {
        return this.sessionId != null;
    }

    /* renamed from: a */
    public void mo36143a(boolean z) {
        if (!z) {
            this.sessionId = null;
        }
    }

    /* renamed from: e */
    public short mo36158e() {
        return this.version;
    }

    /* renamed from: a */
    public TrackConnectReq mo36140a(short s) {
        this.version = s;
        mo36148b(true);
        return this;
    }

    /* renamed from: f */
    public void mo36161f() {
        this.__isset_bitfield = EncodingUtils.m36972b(this.__isset_bitfield, 0);
    }

    /* renamed from: g */
    public boolean mo36164g() {
        return EncodingUtils.m36970a(this.__isset_bitfield, 0);
    }

    /* renamed from: b */
    public void mo36148b(boolean z) {
        this.__isset_bitfield = EncodingUtils.m36966a(this.__isset_bitfield, 0, z);
    }

    /* renamed from: h */
    public String mo36165h() {
        return this.appKey;
    }

    /* renamed from: b */
    public TrackConnectReq mo36146b(String str) {
        this.appKey = str;
        return this;
    }

    /* renamed from: i */
    public void mo36167i() {
        this.appKey = null;
    }

    /* renamed from: j */
    public boolean mo36168j() {
        return this.appKey != null;
    }

    /* renamed from: c */
    public void mo36152c(boolean z) {
        if (!z) {
            this.appKey = null;
        }
    }

    /* renamed from: k */
    public String mo36169k() {
        return this.deviceInfo;
    }

    /* renamed from: c */
    public TrackConnectReq mo36150c(String str) {
        this.deviceInfo = str;
        return this;
    }

    /* renamed from: l */
    public void mo36170l() {
        this.deviceInfo = null;
    }

    /* renamed from: m */
    public boolean mo36171m() {
        return this.deviceInfo != null;
    }

    /* renamed from: d */
    public void mo36155d(boolean z) {
        if (!z) {
            this.deviceInfo = null;
        }
    }

    /* renamed from: n */
    public DeviceType mo36172n() {
        return this.deviceType;
    }

    /* renamed from: a */
    public TrackConnectReq mo36138a(DeviceType deviceType2) {
        this.deviceType = deviceType2;
        return this;
    }

    /* renamed from: o */
    public void mo36173o() {
        this.deviceType = null;
    }

    /* renamed from: p */
    public boolean mo36174p() {
        return this.deviceType != null;
    }

    /* renamed from: e */
    public void mo36159e(boolean z) {
        if (!z) {
            this.deviceType = null;
        }
    }

    /* renamed from: q */
    public String mo36175q() {
        return this.deviceId;
    }

    /* renamed from: d */
    public TrackConnectReq mo36154d(String str) {
        this.deviceId = str;
        return this;
    }

    /* renamed from: r */
    public void mo36176r() {
        this.deviceId = null;
    }

    /* renamed from: s */
    public boolean mo36177s() {
        return this.deviceId != null;
    }

    /* renamed from: f */
    public void mo36162f(boolean z) {
        if (!z) {
            this.deviceId = null;
        }
    }

    /* renamed from: t */
    public String mo36178t() {
        return this.lastSessionId;
    }

    /* renamed from: e */
    public TrackConnectReq mo36157e(String str) {
        this.lastSessionId = str;
        return this;
    }

    /* renamed from: u */
    public void mo36180u() {
        this.lastSessionId = null;
    }

    /* renamed from: v */
    public boolean mo36181v() {
        return this.lastSessionId != null;
    }

    /* renamed from: g */
    public void mo36163g(boolean z) {
        if (!z) {
            this.lastSessionId = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        switch (C7406ap.f24985a[_fields.ordinal()]) {
            case 1:
                if (obj == null) {
                    mo36151c();
                    return;
                } else {
                    mo36139a((String) obj);
                    return;
                }
            case 2:
                if (obj == null) {
                    mo36161f();
                    return;
                } else {
                    mo36140a(((Short) obj).shortValue());
                    return;
                }
            case 3:
                if (obj == null) {
                    mo36167i();
                    return;
                } else {
                    mo36146b((String) obj);
                    return;
                }
            case 4:
                if (obj == null) {
                    mo36170l();
                    return;
                } else {
                    mo36150c((String) obj);
                    return;
                }
            case 5:
                if (obj == null) {
                    mo36173o();
                    return;
                } else {
                    mo36138a((DeviceType) obj);
                    return;
                }
            case 6:
                if (obj == null) {
                    mo36176r();
                    return;
                } else {
                    mo36154d((String) obj);
                    return;
                }
            case 7:
                if (obj == null) {
                    mo36180u();
                    return;
                } else {
                    mo36157e((String) obj);
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        switch (C7406ap.f24985a[_fields.ordinal()]) {
            case 1:
                return mo36147b();
            case 2:
                return Short.valueOf(mo36158e());
            case 3:
                return mo36165h();
            case 4:
                return mo36169k();
            case 5:
                return mo36172n();
            case 6:
                return mo36175q();
            case 7:
                return mo36178t();
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            switch (C7406ap.f24985a[_fields.ordinal()]) {
                case 1:
                    return mo36156d();
                case 2:
                    return mo36164g();
                case 3:
                    return mo36168j();
                case 4:
                    return mo36171m();
                case 5:
                    return mo36174p();
                case 6:
                    return mo36177s();
                case 7:
                    return mo36181v();
                default:
                    throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TrackConnectReq)) {
            return mo36144a((TrackConnectReq) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36144a(TrackConnectReq trackConnectReq) {
        if (trackConnectReq == null) {
            return false;
        }
        if (this == trackConnectReq) {
            return true;
        }
        boolean d = mo36156d();
        boolean d2 = trackConnectReq.mo36156d();
        if (((d || d2) && (!d || !d2 || !this.sessionId.equals(trackConnectReq.sessionId))) || this.version != trackConnectReq.version) {
            return false;
        }
        boolean j = mo36168j();
        boolean j2 = trackConnectReq.mo36168j();
        if ((j || j2) && (!j || !j2 || !this.appKey.equals(trackConnectReq.appKey))) {
            return false;
        }
        boolean m = mo36171m();
        boolean m2 = trackConnectReq.mo36171m();
        if ((m || m2) && (!m || !m2 || !this.deviceInfo.equals(trackConnectReq.deviceInfo))) {
            return false;
        }
        boolean p = mo36174p();
        boolean p2 = trackConnectReq.mo36174p();
        if ((p || p2) && (!p || !p2 || !this.deviceType.equals(trackConnectReq.deviceType))) {
            return false;
        }
        boolean s = mo36177s();
        boolean s2 = trackConnectReq.mo36177s();
        if ((s || s2) && (!s || !s2 || !this.deviceId.equals(trackConnectReq.deviceId))) {
            return false;
        }
        boolean v = mo36181v();
        boolean v2 = trackConnectReq.mo36181v();
        return (!v && !v2) || (v && v2 && this.lastSessionId.equals(trackConnectReq.lastSessionId));
    }

    public int hashCode() {
        int i = 131071;
        int i2 = (mo36156d() ? 131071 : 524287) + 8191;
        if (mo36156d()) {
            i2 = (i2 * 8191) + this.sessionId.hashCode();
        }
        int i3 = (((i2 * 8191) + this.version) * 8191) + (mo36168j() ? 131071 : 524287);
        if (mo36168j()) {
            i3 = (i3 * 8191) + this.appKey.hashCode();
        }
        int i4 = (i3 * 8191) + (mo36171m() ? 131071 : 524287);
        if (mo36171m()) {
            i4 = (i4 * 8191) + this.deviceInfo.hashCode();
        }
        int i5 = (i4 * 8191) + (mo36174p() ? 131071 : 524287);
        if (mo36174p()) {
            i5 = (i5 * 8191) + this.deviceType.getValue();
        }
        int i6 = (i5 * 8191) + (mo36177s() ? 131071 : 524287);
        if (mo36177s()) {
            i6 = (i6 * 8191) + this.deviceId.hashCode();
        }
        int i7 = i6 * 8191;
        if (!mo36181v()) {
            i = 524287;
        }
        int i8 = i7 + i;
        return mo36181v() ? (i8 * 8191) + this.lastSessionId.hashCode() : i8;
    }

    /* renamed from: b */
    public int compareTo(TrackConnectReq trackConnectReq) {
        if (!getClass().equals(trackConnectReq.getClass())) {
            return getClass().getName().compareTo(trackConnectReq.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36156d()).compareTo(Boolean.valueOf(trackConnectReq.mo36156d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36156d()) {
            int a = TBaseHelper.m36980a(this.sessionId, trackConnectReq.sessionId);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo36164g()).compareTo(Boolean.valueOf(trackConnectReq.mo36164g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo36164g()) {
            int a2 = TBaseHelper.m36984a(this.version, trackConnectReq.version);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo3 = Boolean.valueOf(mo36168j()).compareTo(Boolean.valueOf(trackConnectReq.mo36168j()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo36168j()) {
            int a3 = TBaseHelper.m36980a(this.appKey, trackConnectReq.appKey);
            if (a3 != 0) {
                return a3;
            }
        }
        int compareTo4 = Boolean.valueOf(mo36171m()).compareTo(Boolean.valueOf(trackConnectReq.mo36171m()));
        if (compareTo4 != 0) {
            return compareTo4;
        }
        if (mo36171m()) {
            int a4 = TBaseHelper.m36980a(this.deviceInfo, trackConnectReq.deviceInfo);
            if (a4 != 0) {
                return a4;
            }
        }
        int compareTo5 = Boolean.valueOf(mo36174p()).compareTo(Boolean.valueOf(trackConnectReq.mo36174p()));
        if (compareTo5 != 0) {
            return compareTo5;
        }
        if (mo36174p()) {
            int a5 = TBaseHelper.m36979a((Comparable) this.deviceType, (Comparable) trackConnectReq.deviceType);
            if (a5 != 0) {
                return a5;
            }
        }
        int compareTo6 = Boolean.valueOf(mo36177s()).compareTo(Boolean.valueOf(trackConnectReq.mo36177s()));
        if (compareTo6 != 0) {
            return compareTo6;
        }
        if (mo36177s()) {
            int a6 = TBaseHelper.m36980a(this.deviceId, trackConnectReq.deviceId);
            if (a6 != 0) {
                return a6;
            }
        }
        int compareTo7 = Boolean.valueOf(mo36181v()).compareTo(Boolean.valueOf(trackConnectReq.mo36181v()));
        if (compareTo7 != 0) {
            return compareTo7;
        }
        if (mo36181v()) {
            int a7 = TBaseHelper.m36980a(this.lastSessionId, trackConnectReq.lastSessionId);
            if (a7 != 0) {
                return a7;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public _Fields fieldForId(int i) {
        return _Fields.m32066a(i);
    }

    public void read(TProtocol fVar) {
        m32019a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m32019a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackConnectReq(");
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
        sb.append("appKey:");
        String str4 = this.appKey;
        if (str4 == null) {
            sb.append(str2);
        } else {
            sb.append(str4);
        }
        sb.append(str3);
        sb.append("deviceInfo:");
        String str5 = this.deviceInfo;
        if (str5 == null) {
            sb.append(str2);
        } else {
            sb.append(str5);
        }
        sb.append(str3);
        sb.append("deviceType:");
        DeviceType deviceType2 = this.deviceType;
        if (deviceType2 == null) {
            sb.append(str2);
        } else {
            sb.append(deviceType2);
        }
        if (mo36177s()) {
            sb.append(str3);
            sb.append("deviceId:");
            String str6 = this.deviceId;
            if (str6 == null) {
                sb.append(str2);
            } else {
                sb.append(str6);
            }
        }
        if (mo36181v()) {
            sb.append(str3);
            sb.append("lastSessionId:");
            String str7 = this.lastSessionId;
            if (str7 == null) {
                sb.append(str2);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: w */
    public void mo36182w() {
        if (this.sessionId == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'sessionId' was not present! Struct: ");
            sb.append(toString());
            throw new TProtocolException(sb.toString());
        } else if (this.appKey == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Required field 'appKey' was not present! Struct: ");
            sb2.append(toString());
            throw new TProtocolException(sb2.toString());
        } else if (this.deviceInfo == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required field 'deviceInfo' was not present! Struct: ");
            sb3.append(toString());
            throw new TProtocolException(sb3.toString());
        } else if (this.deviceType == null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Required field 'deviceType' was not present! Struct: ");
            sb4.append(toString());
            throw new TProtocolException(sb4.toString());
        }
    }

    /* renamed from: a */
    private static IScheme m32019a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
