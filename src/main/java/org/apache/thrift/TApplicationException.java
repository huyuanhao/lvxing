package org.apache.thrift;

import com.p522qq.taf.jce.JceStruct;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolUtil;
import org.apache.thrift.protocol.TStruct;

public class TApplicationException extends TException implements TSerializable {
    public static final int BAD_SEQUENCE_ID = 4;
    public static final int INTERNAL_ERROR = 6;
    public static final int INVALID_MESSAGE_TYPE = 2;
    public static final int INVALID_PROTOCOL = 9;
    public static final int INVALID_TRANSFORM = 8;
    private static final TField MESSAGE_FIELD = new TField("message", JceStruct.STRUCT_END, 1);
    public static final int MISSING_RESULT = 5;
    public static final int PROTOCOL_ERROR = 7;
    private static final TStruct TAPPLICATION_EXCEPTION_STRUCT = new TStruct("TApplicationException");
    private static final TField TYPE_FIELD = new TField("type", 8, 2);
    public static final int UNKNOWN = 0;
    public static final int UNKNOWN_METHOD = 1;
    public static final int UNSUPPORTED_CLIENT_TYPE = 10;
    public static final int WRONG_METHOD_NAME = 3;
    private static final long serialVersionUID = 1;
    private String message_ = null;
    protected int type_ = 0;

    public TApplicationException() {
    }

    public TApplicationException(int i) {
        this.type_ = i;
    }

    public TApplicationException(int i, String str) {
        super(str);
        this.type_ = i;
    }

    public TApplicationException(String str) {
        super(str);
    }

    public int getType() {
        return this.type_;
    }

    public String getMessage() {
        String str = this.message_;
        return str == null ? super.getMessage() : str;
    }

    public void read(TProtocol fVar) throws TException {
        fVar.mo40906h();
        String str = null;
        int i = 0;
        while (true) {
            TField j = fVar.mo40908j();
            if (j.f29147b == 0) {
                fVar.mo40907i();
                this.type_ = i;
                this.message_ = str;
                return;
            }
            short s = j.f29148c;
            if (s != 1) {
                if (s != 2) {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                } else if (j.f29147b == 8) {
                    i = fVar.mo40919u();
                } else {
                    TProtocolUtil.m37231a(fVar, j.f29147b);
                }
            } else if (j.f29147b == 11) {
                str = fVar.mo40922x();
            } else {
                TProtocolUtil.m37231a(fVar, j.f29147b);
            }
            fVar.mo40909k();
        }
    }

    public static TApplicationException readFrom(TProtocol fVar) throws TException {
        TApplicationException tApplicationException = new TApplicationException();
        tApplicationException.read(fVar);
        return tApplicationException;
    }

    public void write(TProtocol fVar) throws TException {
        fVar.mo40897a(TAPPLICATION_EXCEPTION_STRUCT);
        if (getMessage() != null) {
            fVar.mo40894a(MESSAGE_FIELD);
            fVar.mo40893a(getMessage());
            fVar.mo40901c();
        }
        fVar.mo40894a(TYPE_FIELD);
        fVar.mo40892a(this.type_);
        fVar.mo40901c();
        fVar.mo40902d();
        fVar.mo40900b();
    }
}
