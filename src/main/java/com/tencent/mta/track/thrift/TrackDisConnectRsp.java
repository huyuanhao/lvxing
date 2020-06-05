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
import org.apache.thrift.TBase;
import org.apache.thrift.TBaseHelper;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.SchemeFactory;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.protocol.TStruct;

/* compiled from: ProGuard */
public class TrackDisConnectRsp implements Serializable, Cloneable, Comparable, TBase {
    /* access modifiers changed from: private|static|final */
    public static final TField RESULT_FIELD_DESC;
    private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7424bg(null);
    /* access modifiers changed from: private|static|final */
    public static final TStruct STRUCT_DESC = new TStruct("TrackDisConnectRsp");
    private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7426bi(null);
    public static final Map metaDataMap;
    public ReqResult result;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.TrackDisConnectRsp$_Fields */
    public enum _Fields implements TFieldIdEnum {
        RESULT(1, ArgKey.KEY_RESULT);
        
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
        public static _Fields m32141a(int i) {
            if (i != 1) {
                return null;
            }
            return RESULT;
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
        String str = ArgKey.KEY_RESULT;
        RESULT_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 1);
        EnumMap enumMap = new EnumMap(_Fields.class);
        enumMap.put(_Fields.RESULT, new FieldMetaData(str, 1, new StructMetaData(JceStruct.ZERO_TAG, ReqResult.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        FieldMetaData.addStructMetaDataMap(TrackDisConnectRsp.class, metaDataMap);
    }

    public TrackDisConnectRsp() {
    }

    public TrackDisConnectRsp(TrackDisConnectRsp trackDisConnectRsp) {
        if (trackDisConnectRsp.mo36252d()) {
            this.result = new ReqResult(trackDisConnectRsp.result);
        }
    }

    /* renamed from: a */
    public TrackDisConnectRsp deepCopy() {
        return new TrackDisConnectRsp(this);
    }

    public void clear() {
        this.result = null;
    }

    /* renamed from: b */
    public ReqResult mo36248b() {
        return this.result;
    }

    /* renamed from: a */
    public TrackDisConnectRsp mo36242a(ReqResult reqResult) {
        this.result = reqResult;
        return this;
    }

    /* renamed from: c */
    public void mo36250c() {
        this.result = null;
    }

    /* renamed from: d */
    public boolean mo36252d() {
        return this.result != null;
    }

    /* renamed from: a */
    public void mo36245a(boolean z) {
        if (!z) {
            this.result = null;
        }
    }

    /* renamed from: a */
    public void setFieldValue(_Fields _fields, Object obj) {
        if (C7422be.f24988a[_fields.ordinal()] == 1) {
            if (obj == null) {
                mo36250c();
            } else {
                mo36242a((ReqResult) obj);
            }
        }
    }

    /* renamed from: a */
    public Object getFieldValue(_Fields _fields) {
        if (C7422be.f24988a[_fields.ordinal()] == 1) {
            return mo36248b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public boolean isSet(_Fields _fields) {
        if (_fields == null) {
            throw new IllegalArgumentException();
        } else if (C7422be.f24988a[_fields.ordinal()] == 1) {
            return mo36252d();
        } else {
            throw new IllegalStateException();
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TrackDisConnectRsp)) {
            return mo36246a((TrackDisConnectRsp) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo36246a(TrackDisConnectRsp trackDisConnectRsp) {
        if (trackDisConnectRsp == null) {
            return false;
        }
        if (this == trackDisConnectRsp) {
            return true;
        }
        boolean d = mo36252d();
        boolean d2 = trackDisConnectRsp.mo36252d();
        return (!d && !d2) || (d && d2 && this.result.mo36120a(trackDisConnectRsp.result));
    }

    public int hashCode() {
        int i = 8191 + (mo36252d() ? 131071 : 524287);
        return mo36252d() ? (i * 8191) + this.result.hashCode() : i;
    }

    /* renamed from: b */
    public int compareTo(TrackDisConnectRsp trackDisConnectRsp) {
        if (!getClass().equals(trackDisConnectRsp.getClass())) {
            return getClass().getName().compareTo(trackDisConnectRsp.getClass().getName());
        }
        int compareTo = Boolean.valueOf(mo36252d()).compareTo(Boolean.valueOf(trackDisConnectRsp.mo36252d()));
        if (compareTo != 0) {
            return compareTo;
        }
        if (mo36252d()) {
            int a = TBaseHelper.m36979a((Comparable) this.result, (Comparable) trackDisConnectRsp.result);
            if (a != 0) {
                return a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public _Fields fieldForId(int i) {
        return _Fields.m32141a(i);
    }

    public void read(TProtocol fVar) {
        m32125a(fVar).read(fVar, this);
    }

    public void write(TProtocol fVar) {
        m32125a(fVar).write(fVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackDisConnectRsp(");
        sb.append("result:");
        ReqResult reqResult = this.result;
        if (reqResult == null) {
            sb.append("null");
        } else {
            sb.append(reqResult);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: e */
    public void mo36253e() {
        ReqResult reqResult = this.result;
        if (reqResult == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Required field 'result' was not present! Struct: ");
            sb.append(toString());
            throw new TProtocolException(sb.toString());
        } else if (reqResult != null) {
            reqResult.mo36132h();
        }
    }

    /* renamed from: a */
    private static IScheme m32125a(TProtocol fVar) {
        return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
}
