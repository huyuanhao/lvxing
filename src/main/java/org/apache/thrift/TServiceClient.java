package org.apache.thrift;

import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;

/* renamed from: org.apache.thrift.g */
public abstract class TServiceClient {
    protected TProtocol iprot_;
    protected TProtocol oprot_;
    protected int seqid_;

    public TServiceClient(TProtocol fVar) {
        this(fVar, fVar);
    }

    public TServiceClient(TProtocol fVar, TProtocol fVar2) {
        this.iprot_ = fVar;
        this.oprot_ = fVar2;
    }

    public TProtocol getInputProtocol() {
        return this.iprot_;
    }

    public TProtocol getOutputProtocol() {
        return this.oprot_;
    }

    /* access modifiers changed from: protected */
    public void sendBase(String str, TBase<?, ?> tBase) throws TException {
        sendBase(str, tBase, 1);
    }

    /* access modifiers changed from: protected */
    public void sendBaseOneway(String str, TBase<?, ?> tBase) throws TException {
        sendBase(str, tBase, 4);
    }

    private void sendBase(String str, TBase<?, ?> tBase, byte b) throws TException {
        TProtocol fVar = this.oprot_;
        int i = this.seqid_ + 1;
        this.seqid_ = i;
        fVar.mo40896a(new TMessage(str, b, i));
        tBase.write(this.oprot_);
        this.oprot_.mo40890a();
        this.oprot_.mo40951B().mo40955b();
    }

    /* access modifiers changed from: protected */
    public void receiveBase(TBase<?, ?> tBase, String str) throws TException {
        TMessage f = this.iprot_.mo40904f();
        if (f.f29155b != 3) {
            System.out.format("Received %d%n", new Object[]{Integer.valueOf(f.f29156c)});
            int i = f.f29156c;
            int i2 = this.seqid_;
            if (i == i2) {
                tBase.read(this.iprot_);
                this.iprot_.mo40905g();
                return;
            }
            throw new TApplicationException(4, String.format("%s failed: out of sequence response: expected %d but got %d", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(f.f29156c)}));
        }
        TApplicationException tApplicationException = new TApplicationException();
        tApplicationException.read(this.iprot_);
        this.iprot_.mo40905g();
        throw tApplicationException;
    }
}
