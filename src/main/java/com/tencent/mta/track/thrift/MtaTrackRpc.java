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
import org.apache.thrift.meta_data.StructMetaData;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.SchemeFactory;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TStruct;

/* compiled from: ProGuard */
public class MtaTrackRpc {

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$connect_args */
    public class connect_args implements Serializable, Cloneable, Comparable, TBase {
        /* access modifiers changed from: private|static|final */
        public static final TField REQ_FIELD_DESC;
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7448n(null);
        /* access modifiers changed from: private|static|final */
        public static final TStruct STRUCT_DESC = new TStruct("connect_args");
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7450p(null);
        public static final Map metaDataMap;
        public TrackConnectReq req;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$connect_args$_Fields */
        public enum _Fields implements TFieldIdEnum {
            REQ(1, "req");
            
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
            public static _Fields m31905a(int i) {
                if (i != 1) {
                    return null;
                }
                return REQ;
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
            String str = "req";
            REQ_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 1);
            EnumMap enumMap = new EnumMap(_Fields.class);
            enumMap.put(_Fields.REQ, new FieldMetaData(str, 3, new StructMetaData(JceStruct.ZERO_TAG, TrackConnectReq.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(connect_args.class, metaDataMap);
        }

        public connect_args() {
        }

        public connect_args(connect_args connect_args) {
            if (connect_args.mo36017d()) {
                this.req = new TrackConnectReq(connect_args.req);
            }
        }

        /* renamed from: a */
        public connect_args deepCopy() {
            return new connect_args(this);
        }

        public void clear() {
            this.req = null;
        }

        /* renamed from: b */
        public TrackConnectReq mo36013b() {
            return this.req;
        }

        /* renamed from: a */
        public connect_args mo36007a(TrackConnectReq trackConnectReq) {
            this.req = trackConnectReq;
            return this;
        }

        /* renamed from: c */
        public void mo36015c() {
            this.req = null;
        }

        /* renamed from: d */
        public boolean mo36017d() {
            return this.req != null;
        }

        /* renamed from: a */
        public void mo36010a(boolean z) {
            if (!z) {
                this.req = null;
            }
        }

        /* renamed from: a */
        public void setFieldValue(_Fields _fields, Object obj) {
            if (C7445k.f24992a[_fields.ordinal()] == 1) {
                if (obj == null) {
                    mo36015c();
                } else {
                    mo36007a((TrackConnectReq) obj);
                }
            }
        }

        /* renamed from: a */
        public Object getFieldValue(_Fields _fields) {
            if (C7445k.f24992a[_fields.ordinal()] == 1) {
                return mo36013b();
            }
            throw new IllegalStateException();
        }

        /* renamed from: b */
        public boolean isSet(_Fields _fields) {
            if (_fields == null) {
                throw new IllegalArgumentException();
            } else if (C7445k.f24992a[_fields.ordinal()] == 1) {
                return mo36017d();
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof connect_args)) {
                return mo36011a((connect_args) obj);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo36011a(connect_args connect_args) {
            if (connect_args == null) {
                return false;
            }
            if (this == connect_args) {
                return true;
            }
            boolean d = mo36017d();
            boolean d2 = connect_args.mo36017d();
            return (!d && !d2) || (d && d2 && this.req.mo36144a(connect_args.req));
        }

        public int hashCode() {
            int i = 8191 + (mo36017d() ? 131071 : 524287);
            return mo36017d() ? (i * 8191) + this.req.hashCode() : i;
        }

        /* renamed from: b */
        public int compareTo(connect_args connect_args) {
            if (!getClass().equals(connect_args.getClass())) {
                return getClass().getName().compareTo(connect_args.getClass().getName());
            }
            int compareTo = Boolean.valueOf(mo36017d()).compareTo(Boolean.valueOf(connect_args.mo36017d()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (mo36017d()) {
                int a = TBaseHelper.m36979a((Comparable) this.req, (Comparable) connect_args.req);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }

        /* renamed from: a */
        public _Fields fieldForId(int i) {
            return _Fields.m31905a(i);
        }

        public void read(TProtocol fVar) {
            m31889a(fVar).read(fVar, this);
        }

        public void write(TProtocol fVar) {
            m31889a(fVar).write(fVar, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("connect_args(");
            sb.append("req:");
            TrackConnectReq trackConnectReq = this.req;
            if (trackConnectReq == null) {
                sb.append("null");
            } else {
                sb.append(trackConnectReq);
            }
            sb.append(")");
            return sb.toString();
        }

        /* renamed from: e */
        public void mo36018e() {
            TrackConnectReq trackConnectReq = this.req;
            if (trackConnectReq != null) {
                trackConnectReq.mo36182w();
            }
        }

        /* renamed from: a */
        private static IScheme m31889a(TProtocol fVar) {
            return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$connect_result */
    public class connect_result implements Serializable, Cloneable, Comparable, TBase {
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7452r(null);
        /* access modifiers changed from: private|static|final */
        public static final TStruct STRUCT_DESC = new TStruct("connect_result");
        /* access modifiers changed from: private|static|final */
        public static final TField SUCCESS_FIELD_DESC;
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7454t(null);
        public static final Map metaDataMap;
        public TrackConnectRsp success;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$connect_result$_Fields */
        public enum _Fields implements TFieldIdEnum {
            SUCCESS(0, "success");
            
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
            public static _Fields m31922a(int i) {
                if (i != 0) {
                    return null;
                }
                return SUCCESS;
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
            String str = "success";
            SUCCESS_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 0);
            EnumMap enumMap = new EnumMap(_Fields.class);
            enumMap.put(_Fields.SUCCESS, new FieldMetaData(str, 3, new StructMetaData(JceStruct.ZERO_TAG, TrackConnectRsp.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(connect_result.class, metaDataMap);
        }

        public connect_result() {
        }

        public connect_result(connect_result connect_result) {
            if (connect_result.mo36035d()) {
                this.success = new TrackConnectRsp(connect_result.success);
            }
        }

        /* renamed from: a */
        public connect_result deepCopy() {
            return new connect_result(this);
        }

        public void clear() {
            this.success = null;
        }

        /* renamed from: b */
        public TrackConnectRsp mo36031b() {
            return this.success;
        }

        /* renamed from: a */
        public connect_result mo36025a(TrackConnectRsp trackConnectRsp) {
            this.success = trackConnectRsp;
            return this;
        }

        /* renamed from: c */
        public void mo36033c() {
            this.success = null;
        }

        /* renamed from: d */
        public boolean mo36035d() {
            return this.success != null;
        }

        /* renamed from: a */
        public void mo36028a(boolean z) {
            if (!z) {
                this.success = null;
            }
        }

        /* renamed from: a */
        public void setFieldValue(_Fields _fields, Object obj) {
            if (C7445k.f24993b[_fields.ordinal()] == 1) {
                if (obj == null) {
                    mo36033c();
                } else {
                    mo36025a((TrackConnectRsp) obj);
                }
            }
        }

        /* renamed from: a */
        public Object getFieldValue(_Fields _fields) {
            if (C7445k.f24993b[_fields.ordinal()] == 1) {
                return mo36031b();
            }
            throw new IllegalStateException();
        }

        /* renamed from: b */
        public boolean isSet(_Fields _fields) {
            if (_fields == null) {
                throw new IllegalArgumentException();
            } else if (C7445k.f24993b[_fields.ordinal()] == 1) {
                return mo36035d();
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof connect_result)) {
                return mo36029a((connect_result) obj);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo36029a(connect_result connect_result) {
            if (connect_result == null) {
                return false;
            }
            if (this == connect_result) {
                return true;
            }
            boolean d = mo36035d();
            boolean d2 = connect_result.mo36035d();
            return (!d && !d2) || (d && d2 && this.success.mo36192a(connect_result.success));
        }

        public int hashCode() {
            int i = 8191 + (mo36035d() ? 131071 : 524287);
            return mo36035d() ? (i * 8191) + this.success.hashCode() : i;
        }

        /* renamed from: b */
        public int compareTo(connect_result connect_result) {
            if (!getClass().equals(connect_result.getClass())) {
                return getClass().getName().compareTo(connect_result.getClass().getName());
            }
            int compareTo = Boolean.valueOf(mo36035d()).compareTo(Boolean.valueOf(connect_result.mo36035d()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (mo36035d()) {
                int a = TBaseHelper.m36979a((Comparable) this.success, (Comparable) connect_result.success);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }

        /* renamed from: a */
        public _Fields fieldForId(int i) {
            return _Fields.m31922a(i);
        }

        public void read(TProtocol fVar) {
            m31906a(fVar).read(fVar, this);
        }

        public void write(TProtocol fVar) {
            m31906a(fVar).write(fVar, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("connect_result(");
            sb.append("success:");
            TrackConnectRsp trackConnectRsp = this.success;
            if (trackConnectRsp == null) {
                sb.append("null");
            } else {
                sb.append(trackConnectRsp);
            }
            sb.append(")");
            return sb.toString();
        }

        /* renamed from: e */
        public void mo36036e() {
            TrackConnectRsp trackConnectRsp = this.success;
            if (trackConnectRsp != null) {
                trackConnectRsp.mo36214n();
            }
        }

        /* renamed from: a */
        private static IScheme m31906a(TProtocol fVar) {
            return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$disconnect_args */
    public class disconnect_args implements Serializable, Cloneable, Comparable, TBase {
        /* access modifiers changed from: private|static|final */
        public static final TField REQ_FIELD_DESC;
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7456v(null);
        /* access modifiers changed from: private|static|final */
        public static final TStruct STRUCT_DESC = new TStruct("disconnect_args");
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7458x(null);
        public static final Map metaDataMap;
        public TrackDisConnectReq req;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$disconnect_args$_Fields */
        public enum _Fields implements TFieldIdEnum {
            REQ(1, "req");
            
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
            public static _Fields m31939a(int i) {
                if (i != 1) {
                    return null;
                }
                return REQ;
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
            String str = "req";
            REQ_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 1);
            EnumMap enumMap = new EnumMap(_Fields.class);
            enumMap.put(_Fields.REQ, new FieldMetaData(str, 3, new StructMetaData(JceStruct.ZERO_TAG, TrackDisConnectReq.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(disconnect_args.class, metaDataMap);
        }

        public disconnect_args() {
        }

        public disconnect_args(disconnect_args disconnect_args) {
            if (disconnect_args.mo36053d()) {
                this.req = new TrackDisConnectReq(disconnect_args.req);
            }
        }

        /* renamed from: a */
        public disconnect_args deepCopy() {
            return new disconnect_args(this);
        }

        public void clear() {
            this.req = null;
        }

        /* renamed from: b */
        public TrackDisConnectReq mo36049b() {
            return this.req;
        }

        /* renamed from: a */
        public disconnect_args mo36043a(TrackDisConnectReq trackDisConnectReq) {
            this.req = trackDisConnectReq;
            return this;
        }

        /* renamed from: c */
        public void mo36051c() {
            this.req = null;
        }

        /* renamed from: d */
        public boolean mo36053d() {
            return this.req != null;
        }

        /* renamed from: a */
        public void mo36046a(boolean z) {
            if (!z) {
                this.req = null;
            }
        }

        /* renamed from: a */
        public void setFieldValue(_Fields _fields, Object obj) {
            if (C7445k.f24996e[_fields.ordinal()] == 1) {
                if (obj == null) {
                    mo36051c();
                } else {
                    mo36043a((TrackDisConnectReq) obj);
                }
            }
        }

        /* renamed from: a */
        public Object getFieldValue(_Fields _fields) {
            if (C7445k.f24996e[_fields.ordinal()] == 1) {
                return mo36049b();
            }
            throw new IllegalStateException();
        }

        /* renamed from: b */
        public boolean isSet(_Fields _fields) {
            if (_fields == null) {
                throw new IllegalArgumentException();
            } else if (C7445k.f24996e[_fields.ordinal()] == 1) {
                return mo36053d();
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof disconnect_args)) {
                return mo36047a((disconnect_args) obj);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo36047a(disconnect_args disconnect_args) {
            if (disconnect_args == null) {
                return false;
            }
            if (this == disconnect_args) {
                return true;
            }
            boolean d = mo36053d();
            boolean d2 = disconnect_args.mo36053d();
            return (!d && !d2) || (d && d2 && this.req.mo36223a(disconnect_args.req));
        }

        public int hashCode() {
            int i = 8191 + (mo36053d() ? 131071 : 524287);
            return mo36053d() ? (i * 8191) + this.req.hashCode() : i;
        }

        /* renamed from: b */
        public int compareTo(disconnect_args disconnect_args) {
            if (!getClass().equals(disconnect_args.getClass())) {
                return getClass().getName().compareTo(disconnect_args.getClass().getName());
            }
            int compareTo = Boolean.valueOf(mo36053d()).compareTo(Boolean.valueOf(disconnect_args.mo36053d()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (mo36053d()) {
                int a = TBaseHelper.m36979a((Comparable) this.req, (Comparable) disconnect_args.req);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }

        /* renamed from: a */
        public _Fields fieldForId(int i) {
            return _Fields.m31939a(i);
        }

        public void read(TProtocol fVar) {
            m31923a(fVar).read(fVar, this);
        }

        public void write(TProtocol fVar) {
            m31923a(fVar).write(fVar, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("disconnect_args(");
            sb.append("req:");
            TrackDisConnectReq trackDisConnectReq = this.req;
            if (trackDisConnectReq == null) {
                sb.append("null");
            } else {
                sb.append(trackDisConnectReq);
            }
            sb.append(")");
            return sb.toString();
        }

        /* renamed from: e */
        public void mo36054e() {
            TrackDisConnectReq trackDisConnectReq = this.req;
            if (trackDisConnectReq != null) {
                trackDisConnectReq.mo36236h();
            }
        }

        /* renamed from: a */
        private static IScheme m31923a(TProtocol fVar) {
            return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$disconnect_result */
    public class disconnect_result implements Serializable, Cloneable, Comparable, TBase {
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7460z(null);
        /* access modifiers changed from: private|static|final */
        public static final TStruct STRUCT_DESC = new TStruct("disconnect_result");
        /* access modifiers changed from: private|static|final */
        public static final TField SUCCESS_FIELD_DESC;
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7392ab(null);
        public static final Map metaDataMap;
        public TrackDisConnectRsp success;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$disconnect_result$_Fields */
        public enum _Fields implements TFieldIdEnum {
            SUCCESS(0, "success");
            
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
            public static _Fields m31956a(int i) {
                if (i != 0) {
                    return null;
                }
                return SUCCESS;
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
            String str = "success";
            SUCCESS_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 0);
            EnumMap enumMap = new EnumMap(_Fields.class);
            enumMap.put(_Fields.SUCCESS, new FieldMetaData(str, 3, new StructMetaData(JceStruct.ZERO_TAG, TrackDisConnectRsp.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(disconnect_result.class, metaDataMap);
        }

        public disconnect_result() {
        }

        public disconnect_result(disconnect_result disconnect_result) {
            if (disconnect_result.mo36071d()) {
                this.success = new TrackDisConnectRsp(disconnect_result.success);
            }
        }

        /* renamed from: a */
        public disconnect_result deepCopy() {
            return new disconnect_result(this);
        }

        public void clear() {
            this.success = null;
        }

        /* renamed from: b */
        public TrackDisConnectRsp mo36067b() {
            return this.success;
        }

        /* renamed from: a */
        public disconnect_result mo36061a(TrackDisConnectRsp trackDisConnectRsp) {
            this.success = trackDisConnectRsp;
            return this;
        }

        /* renamed from: c */
        public void mo36069c() {
            this.success = null;
        }

        /* renamed from: d */
        public boolean mo36071d() {
            return this.success != null;
        }

        /* renamed from: a */
        public void mo36064a(boolean z) {
            if (!z) {
                this.success = null;
            }
        }

        /* renamed from: a */
        public void setFieldValue(_Fields _fields, Object obj) {
            if (C7445k.f24997f[_fields.ordinal()] == 1) {
                if (obj == null) {
                    mo36069c();
                } else {
                    mo36061a((TrackDisConnectRsp) obj);
                }
            }
        }

        /* renamed from: a */
        public Object getFieldValue(_Fields _fields) {
            if (C7445k.f24997f[_fields.ordinal()] == 1) {
                return mo36067b();
            }
            throw new IllegalStateException();
        }

        /* renamed from: b */
        public boolean isSet(_Fields _fields) {
            if (_fields == null) {
                throw new IllegalArgumentException();
            } else if (C7445k.f24997f[_fields.ordinal()] == 1) {
                return mo36071d();
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof disconnect_result)) {
                return mo36065a((disconnect_result) obj);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo36065a(disconnect_result disconnect_result) {
            if (disconnect_result == null) {
                return false;
            }
            if (this == disconnect_result) {
                return true;
            }
            boolean d = mo36071d();
            boolean d2 = disconnect_result.mo36071d();
            return (!d && !d2) || (d && d2 && this.success.mo36246a(disconnect_result.success));
        }

        public int hashCode() {
            int i = 8191 + (mo36071d() ? 131071 : 524287);
            return mo36071d() ? (i * 8191) + this.success.hashCode() : i;
        }

        /* renamed from: b */
        public int compareTo(disconnect_result disconnect_result) {
            if (!getClass().equals(disconnect_result.getClass())) {
                return getClass().getName().compareTo(disconnect_result.getClass().getName());
            }
            int compareTo = Boolean.valueOf(mo36071d()).compareTo(Boolean.valueOf(disconnect_result.mo36071d()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (mo36071d()) {
                int a = TBaseHelper.m36979a((Comparable) this.success, (Comparable) disconnect_result.success);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }

        /* renamed from: a */
        public _Fields fieldForId(int i) {
            return _Fields.m31956a(i);
        }

        public void read(TProtocol fVar) {
            m31940a(fVar).read(fVar, this);
        }

        public void write(TProtocol fVar) {
            m31940a(fVar).write(fVar, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("disconnect_result(");
            sb.append("success:");
            TrackDisConnectRsp trackDisConnectRsp = this.success;
            if (trackDisConnectRsp == null) {
                sb.append("null");
            } else {
                sb.append(trackDisConnectRsp);
            }
            sb.append(")");
            return sb.toString();
        }

        /* renamed from: e */
        public void mo36072e() {
            TrackDisConnectRsp trackDisConnectRsp = this.success;
            if (trackDisConnectRsp != null) {
                trackDisConnectRsp.mo36253e();
            }
        }

        /* renamed from: a */
        private static IScheme m31940a(TProtocol fVar) {
            return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$pollRequest_args */
    public class pollRequest_args implements Serializable, Cloneable, Comparable, TBase {
        /* access modifiers changed from: private|static|final */
        public static final TField REQ_FIELD_DESC;
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7394ad(null);
        /* access modifiers changed from: private|static|final */
        public static final TStruct STRUCT_DESC = new TStruct("pollRequest_args");
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7396af(null);
        public static final Map metaDataMap;
        public TrackPollReq req;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$pollRequest_args$_Fields */
        public enum _Fields implements TFieldIdEnum {
            REQ(1, "req");
            
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
            public static _Fields m31973a(int i) {
                if (i != 1) {
                    return null;
                }
                return REQ;
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
            String str = "req";
            REQ_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 1);
            EnumMap enumMap = new EnumMap(_Fields.class);
            enumMap.put(_Fields.REQ, new FieldMetaData(str, 3, new StructMetaData(JceStruct.ZERO_TAG, TrackPollReq.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(pollRequest_args.class, metaDataMap);
        }

        public pollRequest_args() {
        }

        public pollRequest_args(pollRequest_args pollrequest_args) {
            if (pollrequest_args.mo36089d()) {
                this.req = new TrackPollReq(pollrequest_args.req);
            }
        }

        /* renamed from: a */
        public pollRequest_args deepCopy() {
            return new pollRequest_args(this);
        }

        public void clear() {
            this.req = null;
        }

        /* renamed from: b */
        public TrackPollReq mo36085b() {
            return this.req;
        }

        /* renamed from: a */
        public pollRequest_args mo36079a(TrackPollReq trackPollReq) {
            this.req = trackPollReq;
            return this;
        }

        /* renamed from: c */
        public void mo36087c() {
            this.req = null;
        }

        /* renamed from: d */
        public boolean mo36089d() {
            return this.req != null;
        }

        /* renamed from: a */
        public void mo36082a(boolean z) {
            if (!z) {
                this.req = null;
            }
        }

        /* renamed from: a */
        public void setFieldValue(_Fields _fields, Object obj) {
            if (C7445k.f24994c[_fields.ordinal()] == 1) {
                if (obj == null) {
                    mo36087c();
                } else {
                    mo36079a((TrackPollReq) obj);
                }
            }
        }

        /* renamed from: a */
        public Object getFieldValue(_Fields _fields) {
            if (C7445k.f24994c[_fields.ordinal()] == 1) {
                return mo36085b();
            }
            throw new IllegalStateException();
        }

        /* renamed from: b */
        public boolean isSet(_Fields _fields) {
            if (_fields == null) {
                throw new IllegalArgumentException();
            } else if (C7445k.f24994c[_fields.ordinal()] == 1) {
                return mo36089d();
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof pollRequest_args)) {
                return mo36083a((pollRequest_args) obj);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo36083a(pollRequest_args pollrequest_args) {
            if (pollrequest_args == null) {
                return false;
            }
            if (this == pollrequest_args) {
                return true;
            }
            boolean d = mo36089d();
            boolean d2 = pollrequest_args.mo36089d();
            return (!d && !d2) || (d && d2 && this.req.mo36266a(pollrequest_args.req));
        }

        public int hashCode() {
            int i = 8191 + (mo36089d() ? 131071 : 524287);
            return mo36089d() ? (i * 8191) + this.req.hashCode() : i;
        }

        /* renamed from: b */
        public int compareTo(pollRequest_args pollrequest_args) {
            if (!getClass().equals(pollrequest_args.getClass())) {
                return getClass().getName().compareTo(pollrequest_args.getClass().getName());
            }
            int compareTo = Boolean.valueOf(mo36089d()).compareTo(Boolean.valueOf(pollrequest_args.mo36089d()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (mo36089d()) {
                int a = TBaseHelper.m36979a((Comparable) this.req, (Comparable) pollrequest_args.req);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }

        /* renamed from: a */
        public _Fields fieldForId(int i) {
            return _Fields.m31973a(i);
        }

        public void read(TProtocol fVar) {
            m31957a(fVar).read(fVar, this);
        }

        public void write(TProtocol fVar) {
            m31957a(fVar).write(fVar, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("pollRequest_args(");
            sb.append("req:");
            TrackPollReq trackPollReq = this.req;
            if (trackPollReq == null) {
                sb.append("null");
            } else {
                sb.append(trackPollReq);
            }
            sb.append(")");
            return sb.toString();
        }

        /* renamed from: e */
        public void mo36090e() {
            TrackPollReq trackPollReq = this.req;
            if (trackPollReq != null) {
                trackPollReq.mo36283k();
            }
        }

        /* renamed from: a */
        private static IScheme m31957a(TProtocol fVar) {
            return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$pollRequest_result */
    public class pollRequest_result implements Serializable, Cloneable, Comparable, TBase {
        private static final SchemeFactory STANDARD_SCHEME_FACTORY = new C7398ah(null);
        /* access modifiers changed from: private|static|final */
        public static final TStruct STRUCT_DESC = new TStruct("pollRequest_result");
        /* access modifiers changed from: private|static|final */
        public static final TField SUCCESS_FIELD_DESC;
        private static final SchemeFactory TUPLE_SCHEME_FACTORY = new C7400aj(null);
        public static final Map metaDataMap;
        public TrackPollRsp success;

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.mta.track.thrift.MtaTrackRpc$pollRequest_result$_Fields */
        public enum _Fields implements TFieldIdEnum {
            SUCCESS(0, "success");
            
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
            public static _Fields m31990a(int i) {
                if (i != 0) {
                    return null;
                }
                return SUCCESS;
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
            String str = "success";
            SUCCESS_FIELD_DESC = new TField(str, JceStruct.ZERO_TAG, 0);
            EnumMap enumMap = new EnumMap(_Fields.class);
            enumMap.put(_Fields.SUCCESS, new FieldMetaData(str, 3, new StructMetaData(JceStruct.ZERO_TAG, TrackPollRsp.class)));
            metaDataMap = Collections.unmodifiableMap(enumMap);
            FieldMetaData.addStructMetaDataMap(pollRequest_result.class, metaDataMap);
        }

        public pollRequest_result() {
        }

        public pollRequest_result(pollRequest_result pollrequest_result) {
            if (pollrequest_result.mo36107d()) {
                this.success = new TrackPollRsp(pollrequest_result.success);
            }
        }

        /* renamed from: a */
        public pollRequest_result deepCopy() {
            return new pollRequest_result(this);
        }

        public void clear() {
            this.success = null;
        }

        /* renamed from: b */
        public TrackPollRsp mo36103b() {
            return this.success;
        }

        /* renamed from: a */
        public pollRequest_result mo36097a(TrackPollRsp trackPollRsp) {
            this.success = trackPollRsp;
            return this;
        }

        /* renamed from: c */
        public void mo36105c() {
            this.success = null;
        }

        /* renamed from: d */
        public boolean mo36107d() {
            return this.success != null;
        }

        /* renamed from: a */
        public void mo36100a(boolean z) {
            if (!z) {
                this.success = null;
            }
        }

        /* renamed from: a */
        public void setFieldValue(_Fields _fields, Object obj) {
            if (C7445k.f24995d[_fields.ordinal()] == 1) {
                if (obj == null) {
                    mo36105c();
                } else {
                    mo36097a((TrackPollRsp) obj);
                }
            }
        }

        /* renamed from: a */
        public Object getFieldValue(_Fields _fields) {
            if (C7445k.f24995d[_fields.ordinal()] == 1) {
                return mo36103b();
            }
            throw new IllegalStateException();
        }

        /* renamed from: b */
        public boolean isSet(_Fields _fields) {
            if (_fields == null) {
                throw new IllegalArgumentException();
            } else if (C7445k.f24995d[_fields.ordinal()] == 1) {
                return mo36107d();
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof pollRequest_result)) {
                return mo36101a((pollRequest_result) obj);
            }
            return false;
        }

        /* renamed from: a */
        public boolean mo36101a(pollRequest_result pollrequest_result) {
            if (pollrequest_result == null) {
                return false;
            }
            if (this == pollrequest_result) {
                return true;
            }
            boolean d = mo36107d();
            boolean d2 = pollrequest_result.mo36107d();
            return (!d && !d2) || (d && d2 && this.success.mo36293a(pollrequest_result.success));
        }

        public int hashCode() {
            int i = 8191 + (mo36107d() ? 131071 : 524287);
            return mo36107d() ? (i * 8191) + this.success.hashCode() : i;
        }

        /* renamed from: b */
        public int compareTo(pollRequest_result pollrequest_result) {
            if (!getClass().equals(pollrequest_result.getClass())) {
                return getClass().getName().compareTo(pollrequest_result.getClass().getName());
            }
            int compareTo = Boolean.valueOf(mo36107d()).compareTo(Boolean.valueOf(pollrequest_result.mo36107d()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (mo36107d()) {
                int a = TBaseHelper.m36979a((Comparable) this.success, (Comparable) pollrequest_result.success);
                if (a != 0) {
                    return a;
                }
            }
            return 0;
        }

        /* renamed from: a */
        public _Fields fieldForId(int i) {
            return _Fields.m31990a(i);
        }

        public void read(TProtocol fVar) {
            m31974a(fVar).read(fVar, this);
        }

        public void write(TProtocol fVar) {
            m31974a(fVar).write(fVar, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("pollRequest_result(");
            sb.append("success:");
            TrackPollRsp trackPollRsp = this.success;
            if (trackPollRsp == null) {
                sb.append("null");
            } else {
                sb.append(trackPollRsp);
            }
            sb.append(")");
            return sb.toString();
        }

        /* renamed from: e */
        public void mo36108e() {
            TrackPollRsp trackPollRsp = this.success;
            if (trackPollRsp != null) {
                trackPollRsp.mo36311k();
            }
        }

        /* renamed from: a */
        private static IScheme m31974a(TProtocol fVar) {
            return (StandardScheme.class.equals(fVar.mo40942C()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
        }
    }
}
