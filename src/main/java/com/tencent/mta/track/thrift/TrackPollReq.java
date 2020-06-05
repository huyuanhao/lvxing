package com.tencent.mta.track.thrift;

import com.p522qq.taf.jce.JceStruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.meta_data.ListMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.SchemeFactory;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;

/* compiled from: ProGuard */
public class TrackPollReq implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField C_REQUEST_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField SESSION_ID_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7429bl(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("TrackPollReq");
    /* access modifiers changed from: private|static|final */
    public static final TField S_RSP_LIST_FIELD_DESC;
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7431bn(null);
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.C_REQUEST, _Fields.S_RSP_LIST};
    public CommonRequest cRequest;
    public List sRspList;
    public String sessionId;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.TrackPollReq$_Fields */
    public enum _Fields implements TFieldIdEnum {
        SESSION_ID(1, "sessionId"),
        C_REQUEST(2, "cRequest"),
        S_RSP_LIST(3, "sRspList");
        
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
        public static _Fields m32170a(int i) {
            if (i == 1) {
                return SESSION_ID;
            }
            if (i == 2) {
                return C_REQUEST;
            }
            if (i != 3) {
                return null;
            }
            return S_RSP_LIST;
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
        String str2 = "cRequest";
        C_REQUEST_FIELD_DESC = new TField(str2, JceStruct.ZERO_TAG, 2);
        String str3 = "sRspList";
        S_RSP_LIST_FIELD_DESC = new TField(str3, 15, 3);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.SESSION_ID, new FieldMetaData(str, 1, new FieldValueMetaData(JceStruct.STRUCT_END)));
        enumMap.put(_Fields.C_REQUEST, new FieldMetaData(str2, 2, new StructMetaData(JceStruct.ZERO_TAG, CommonRequest.class)));
        enumMap.put(_Fields.S_RSP_LIST, new FieldMetaData(str3, 2, new ListMetaData(15, new StructMetaData(JceStruct.ZERO_TAG, CommonResponse.class))));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TrackPollReq.class, metaDataMap);
    }

    public TrackPollReq() {
    }

    public TrackPollReq(TrackPollReq trackPollReq) {
        if (trackPollReq.mo36274d()) {
            this.sessionId = trackPollReq.sessionId;
        }
        if (trackPollReq.mo36278g()) {
            this.cRequest = new CommonRequest(trackPollReq.cRequest);
        }
        if (trackPollReq.mo36282j()) {
            ArrayList arrayList = new ArrayList(trackPollReq.sRspList.size());
            for (CommonResponse commonResponse : trackPollReq.sRspList) {
                arrayList.add(new CommonResponse(commonResponse));
            }
            this.sRspList = arrayList;
        }
    }

    /* renamed from: a */
    public TrackPollReq deepCopy() {
        return new TrackPollReq(this);
    }

    public void clear() {
        this.sessionId = null;
        this.cRequest = null;
        this.sRspList = null;
    }

    /* renamed from: b */
    public String mo36268b() {
        return this.sessionId;
    }

    /* renamed from: a */
    public TrackPollReq mo36261a(String str) {
        this.sessionId = str;
        return this;
    }

    /* renamed from: c */
    public void mo36271c() {
        this.sessionId = null;
    }

    /* renamed from: d */
    public boolean mo36274d() {
        return this.sessionId != null;
    }

    /* renamed from: a */
    public void mo36265a(boolean z) {
        if (!z) {
            this.sessionId = null;
        }
    }

    /* renamed from: e */
    public CommonRequest mo36275e() {
        return this.cRequest;
    }

    /* renamed from: a */
    public TrackPollReq mo36260a(CommonRequest commonRequest) {
        this.cRequest = commonRequest;
        return this;
    }

    /* renamed from: f */
    public void mo36277f() {
        this.cRequest = null;
    }

    /* renamed from: g */
    public boolean mo36278g() {
        return this.cRequest != null;
    }

    /* renamed from: b */
    public void mo36269b(boolean z) {
        if (!z) {
            this.cRequest = null;
        }
    }

    /* renamed from: h */
    public List mo36279h() {
        return this.sRspList;
    }

    /* renamed from: a */
    public TrackPollReq mo36262a(List list) {
        this.sRspList = list;
        return this;
    }

    /* renamed from: i */
    public void mo36281i() {
        this.sRspList = null;
    }

    /* renamed from: j */
    public boolean mo36282j() {
        return this.sRspList != null;
    }

    /* renamed from: c */
    public void mo36272c(boolean z) {
        if (!z) {
            this.sRspList = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7427bj.f24989a[_fields.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (obj == null) {
                        mo36281i();
                    } else {
                        mo36262a((List) obj);
                    }
                }
            } else if (obj == null) {
                mo36277f();
            } else {
                mo36260a((CommonRequest) obj);
            }
        } else if (obj == null) {
            mo36271c();
        } else {
            mo36261a((String) obj);
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7427bj.f24989a[_fields.ordinal()];
        if (i == 1) {
            return mo36268b();
        }
        if (i == 2) {
            return mo36275e();
        }
        if (i == 3) {
            return mo36279h();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7427bj.f24989a[_fields.ordinal()];
            if (i == 1) {
                return mo36274d();
            }
            if (i == 2) {
                return mo36278g();
            }
            if (i == 3) {
                return mo36282j();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TrackPollReq)) {
            return mo36266a((TrackPollReq) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36266a(TrackPollReq trackPollReq) {
        if (trackPollReq == null) {
            return false;
        }
        if (this == trackPollReq) {
            return true;
        }
        boolean d = mo36274d();
        boolean d2 = trackPollReq.mo36274d();
        if ((d || d2) && (!d || !d2 || !this.sessionId.equals(trackPollReq.sessionId))) {
            return false;
        }
        boolean g = mo36278g();
        boolean g2 = trackPollReq.mo36278g();
        if ((g || g2) && (!g || !g2 || !this.cRequest.mo35940a(trackPollReq.cRequest))) {
            return false;
        }
        boolean j = mo36282j();
        boolean j2 = trackPollReq.mo36282j();
        return (!j && !j2) || (j && j2 && this.sRspList.equals(trackPollReq.sRspList));
    }

    public int hashCode() {
        int i = 131071;
        int i2 = (mo36274d() ? 131071 : 524287) + 8191;
        if (mo36274d()) {
            i2 = (i2 * 8191) + this.sessionId.hashCode();
        }
        int i3 = (i2 * 8191) + (mo36278g() ? 131071 : 524287);
        if (mo36278g()) {
            i3 = (i3 * 8191) + this.cRequest.hashCode();
        }
        int i4 = i3 * 8191;
        if (!mo36282j()) {
            i = 524287;
        }
        int i5 = i4 + i;
        return mo36282j() ? (i5 * 8191) + this.sRspList.hashCode() : i5;
    }

    /* renamed from: b */
    public int compareTo(TrackPollReq trackPollReq) {
        if (!getClass().equals(trackPollReq.getClass())) {
            return getClass().getName().compareTo(trackPollReq.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36274d()).compareTo(Boolean.valueOf(trackPollReq.mo36274d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36274d()) {
            int a = TBaseHelper.m36980a(this.sessionId, trackPollReq.sessionId);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo36278g()).compareTo(Boolean.valueOf(trackPollReq.mo36278g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo36278g()) {
            int a2 = TBaseHelper.m36979a((Comparable) this.cRequest, (Comparable) trackPollReq.cRequest);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo3 = Boolean.valueOf(mo36282j()).compareTo(Boolean.valueOf(trackPollReq.mo36282j()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo36282j()) {
            int a3 = TBaseHelper.m36981a(this.sRspList, trackPollReq.sRspList);
            if (a3 != 0) {
                return a3;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public _Fields fieldForId(int i) {
        return _Fields.m32170a(i);
    }

    public void read(TProtocol fVar) {
        m32142a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m32142a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackPollReq(");
        sb.append("sessionId:");
        String str = this.sessionId;
        String str2 = "null";
        if (str == null) {
            sb.append(str2);
        } else {
            sb.append(str);
        }
        String str3 = ", ";
        if (mo36278g()) {
            sb.append(str3);
            sb.append("cRequest:");
            CommonRequest commonRequest = this.cRequest;
            if (commonRequest == null) {
                sb.append(str2);
            } else {
                sb.append(commonRequest);
            }
        }
        if (mo36282j()) {
            sb.append(str3);
            sb.append("sRspList:");
            List list = this.sRspList;
            if (list == null) {
                sb.append(str2);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: k */
    public void mo36283k() {
        if (this.sessionId != null) {
            CommonRequest commonRequest = this.cRequest;
            if (commonRequest != null) {
                commonRequest.mo35963k();
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Required field 'sessionId' was not present! Struct: ");
        sb.append(toString());
        throw new TProtocolException(sb.toString());
    }

    /* renamed from: a */
    private static IScheme m32142a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
