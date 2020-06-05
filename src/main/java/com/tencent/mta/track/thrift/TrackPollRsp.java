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
import org.apache.thrift.EncodingUtils;
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
import org.apache.thrift.protocol.TStruct;

/* compiled from: ProGuard */
public class TrackPollRsp implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField C_RESPONSE_FIELD_DESC;
    /* access modifiers changed from: private|static|final */
    public static final TField POLL_INTERVAL_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7434bq(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("TrackPollRsp");
    /* access modifiers changed from: private|static|final */
    public static final TField S_REQ_LIST_FIELD_DESC;
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7436bs(null);
    private static final int __POLLINTERVAL_ISSET_ID = 0;
    public static final Map metaDataMap;
    private static final _Fields[] optionals = {_Fields.C_RESPONSE, _Fields.S_REQ_LIST, _Fields.POLL_INTERVAL};
    private byte __isset_bitfield = 0;
    public CommonResponse cResponse;
    public int pollInterval;
    public List sReqList;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.TrackPollRsp$_Fields */
    public enum _Fields implements TFieldIdEnum {
        C_RESPONSE(1, "cResponse"),
        S_REQ_LIST(2, "sReqList"),
        POLL_INTERVAL(3, "pollInterval");
        
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
        public static _Fields m32199a(int i) {
            if (i == 1) {
                return C_RESPONSE;
            }
            if (i == 2) {
                return S_REQ_LIST;
            }
            if (i != 3) {
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
        String str = "cResponse";
        C_RESPONSE_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 1);
        String str2 = "sReqList";
        S_REQ_LIST_FIELD_DESC = new TField(str2, 15, 2);
        String str3 = "pollInterval";
        POLL_INTERVAL_FIELD_DESC = new TField(str3, 8, 3);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.C_RESPONSE, new FieldMetaData(str, 2, new StructMetaData(JceStruct.ZERO_TAG, CommonResponse.class)));
        enumMap.put(_Fields.S_REQ_LIST, new FieldMetaData(str2, 2, new ListMetaData(15, new StructMetaData(JceStruct.ZERO_TAG, CommonRequest.class))));
        enumMap.put(_Fields.POLL_INTERVAL, new FieldMetaData(str3, 2, new FieldValueMetaData(8)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TrackPollRsp.class, metaDataMap);
    }

    public TrackPollRsp() {
    }

    public TrackPollRsp(TrackPollRsp trackPollRsp) {
        this.__isset_bitfield = trackPollRsp.__isset_bitfield;
        if (trackPollRsp.mo36302d()) {
            this.cResponse = new CommonResponse(trackPollRsp.cResponse);
        }
        if (trackPollRsp.mo36306g()) {
            ArrayList arrayList = new ArrayList(trackPollRsp.sReqList.size());
            for (CommonRequest commonRequest : trackPollRsp.sReqList) {
                arrayList.add(new CommonRequest(commonRequest));
            }
            this.sReqList = arrayList;
        }
        this.pollInterval = trackPollRsp.pollInterval;
    }

    /* renamed from: a */
    public TrackPollRsp deepCopy() {
        return new TrackPollRsp(this);
    }

    public void clear() {
        this.cResponse = null;
        this.sReqList = null;
        mo36300c(false);
        this.pollInterval = 0;
    }

    /* renamed from: b */
    public CommonResponse mo36295b() {
        return this.cResponse;
    }

    /* renamed from: a */
    public TrackPollRsp mo36288a(CommonResponse commonResponse) {
        this.cResponse = commonResponse;
        return this;
    }

    /* renamed from: c */
    public void mo36299c() {
        this.cResponse = null;
    }

    /* renamed from: d */
    public boolean mo36302d() {
        return this.cResponse != null;
    }

    /* renamed from: a */
    public void mo36292a(boolean z) {
        if (!z) {
            this.cResponse = null;
        }
    }

    /* renamed from: e */
    public List mo36303e() {
        return this.sReqList;
    }

    /* renamed from: a */
    public TrackPollRsp mo36289a(List list) {
        this.sReqList = list;
        return this;
    }

    /* renamed from: f */
    public void mo36305f() {
        this.sReqList = null;
    }

    /* renamed from: g */
    public boolean mo36306g() {
        return this.sReqList != null;
    }

    /* renamed from: b */
    public void mo36297b(boolean z) {
        if (!z) {
            this.sReqList = null;
        }
    }

    /* renamed from: h */
    public int mo36307h() {
        return this.pollInterval;
    }

    /* renamed from: a */
    public TrackPollRsp mo36287a(int i) {
        this.pollInterval = i;
        mo36300c(true);
        return this;
    }

    /* renamed from: i */
    public void mo36309i() {
        this.__isset_bitfield = EncodingUtils.m36972b(this.__isset_bitfield, 0);
    }

    /* renamed from: j */
    public boolean mo36310j() {
        return EncodingUtils.m36970a(this.__isset_bitfield, 0);
    }

    /* renamed from: c */
    public void mo36300c(boolean z) {
        this.__isset_bitfield = EncodingUtils.m36966a(this.__isset_bitfield, 0, z);
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        int i = C7432bo.f24990a[_fields.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (obj == null) {
                        mo36309i();
                    } else {
                        mo36287a(((Integer) obj).intValue());
                    }
                }
            } else if (obj == null) {
                mo36305f();
            } else {
                mo36289a((List) obj);
            }
        } else if (obj == null) {
            mo36299c();
        } else {
            mo36288a((CommonResponse) obj);
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        int i = C7432bo.f24990a[_fields.ordinal()];
        if (i == 1) {
            return mo36295b();
        }
        if (i == 2) {
            return mo36303e();
        }
        if (i == 3) {
            return Integer.valueOf(mo36307h());
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields != null) {
            int i = C7432bo.f24990a[_fields.ordinal()];
            if (i == 1) {
                return mo36302d();
            }
            if (i == 2) {
                return mo36306g();
            }
            if (i == 3) {
                return mo36310j();
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TrackPollRsp)) {
            return mo36293a((TrackPollRsp) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36293a(TrackPollRsp trackPollRsp) {
        if (trackPollRsp == null) {
            return false;
        }
        if (this == trackPollRsp) {
            return true;
        }
        boolean d = mo36302d();
        boolean d2 = trackPollRsp.mo36302d();
        if ((d || d2) && (!d || !d2 || !this.cResponse.mo35978a(trackPollRsp.cResponse))) {
            return false;
        }
        boolean g = mo36306g();
        boolean g2 = trackPollRsp.mo36306g();
        if ((g || g2) && (!g || !g2 || !this.sReqList.equals(trackPollRsp.sReqList))) {
            return false;
        }
        boolean j = mo36310j();
        boolean j2 = trackPollRsp.mo36310j();
        return (!j && !j2) || (j && j2 && this.pollInterval == trackPollRsp.pollInterval);
    }

    public int hashCode() {
        int i = 131071;
        int i2 = (mo36302d() ? 131071 : 524287) + 8191;
        if (mo36302d()) {
            i2 = (i2 * 8191) + this.cResponse.hashCode();
        }
        int i3 = (i2 * 8191) + (mo36306g() ? 131071 : 524287);
        if (mo36306g()) {
            i3 = (i3 * 8191) + this.sReqList.hashCode();
        }
        int i4 = i3 * 8191;
        if (!mo36310j()) {
            i = 524287;
        }
        int i5 = i4 + i;
        return mo36310j() ? (i5 * 8191) + this.pollInterval : i5;
    }

    /* renamed from: b */
    public int compareTo(TrackPollRsp trackPollRsp) {
        if (!getClass().equals(trackPollRsp.getClass())) {
            return getClass().getName().compareTo(trackPollRsp.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36302d()).compareTo(Boolean.valueOf(trackPollRsp.mo36302d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36302d()) {
            int a = TBaseHelper.m36979a((Comparable) this.cResponse, (Comparable) trackPollRsp.cResponse);
            if (a != 0) {
                return a;
            }
        }
        int compareTo2 = Boolean.valueOf(mo36306g()).compareTo(Boolean.valueOf(trackPollRsp.mo36306g()));
        if (compareTo2 != 0) {
            return compareTo2;
        }
        if (mo36306g()) {
            int a2 = TBaseHelper.m36981a(this.sReqList, trackPollRsp.sReqList);
            if (a2 != 0) {
                return a2;
            }
        }
        int compareTo3 = Boolean.valueOf(mo36310j()).compareTo(Boolean.valueOf(trackPollRsp.mo36310j()));
        if (compareTo3 != 0) {
            return compareTo3;
        }
        if (mo36310j()) {
            int a3 = TBaseHelper.m36978a(this.pollInterval, trackPollRsp.pollInterval);
            if (a3 != 0) {
                return a3;
            }
        }
        return 0;
    }

    /* renamed from: b */
    public _Fields fieldForId(int i) {
        return _Fields.m32199a(i);
    }

    public void read(TProtocol fVar) {
        m32171a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m32171a(fVar).write(fVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("TrackPollRsp(");
        String str = "null";
        if (mo36302d()) {
            sb.append("cResponse:");
            CommonResponse commonResponse = this.cResponse;
            if (commonResponse == null) {
                sb.append(str);
            } else {
                sb.append(commonResponse);
            }
            z = false;
        } else {
            z = true;
        }
        String str2 = ", ";
        if (mo36306g()) {
            if (!z) {
                sb.append(str2);
            }
            sb.append("sReqList:");
            List list = this.sReqList;
            if (list == null) {
                sb.append(str);
            } else {
                sb.append(list);
            }
            z = false;
        }
        if (mo36310j()) {
            if (!z) {
                sb.append(str2);
            }
            sb.append("pollInterval:");
            sb.append(this.pollInterval);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: k */
    public void mo36311k() {
        CommonResponse commonResponse = this.cResponse;
        if (commonResponse != null) {
            commonResponse.mo36000n();
        }
    }

    /* renamed from: a */
    private static IScheme m32171a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
