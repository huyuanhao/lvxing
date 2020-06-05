package org.apache.thrift.protocol;

import java.nio.ByteBuffer;
import org.apache.thrift.TException;
import org.apache.thrift.p704a.IScheme;
import org.apache.thrift.p704a.StandardScheme;
import org.apache.thrift.transport.TTransport;

/* renamed from: org.apache.thrift.protocol.f */
public abstract class TProtocol {
    /* renamed from: c */
    protected TTransport f29157c;

    /* renamed from: a */
    public abstract void mo40890a() throws TException;

    /* renamed from: a */
    public abstract void mo40892a(int i) throws TException;

    /* renamed from: a */
    public abstract void mo40893a(String str) throws TException;

    /* renamed from: a */
    public abstract void mo40894a(TField bVar) throws TException;

    /* renamed from: a */
    public abstract void mo40895a(TList cVar) throws TException;

    /* renamed from: a */
    public abstract void mo40896a(TMessage eVar) throws TException;

    /* renamed from: a */
    public abstract void mo40897a(TStruct iVar) throws TException;

    /* renamed from: a */
    public abstract void mo40898a(short s) throws TException;

    /* renamed from: b */
    public abstract void mo40900b() throws TException;

    /* renamed from: c */
    public abstract void mo40901c() throws TException;

    /* renamed from: d */
    public abstract void mo40902d() throws TException;

    /* renamed from: e */
    public abstract void mo40903e() throws TException;

    /* renamed from: f */
    public abstract TMessage mo40904f() throws TException;

    /* renamed from: g */
    public abstract void mo40905g() throws TException;

    /* renamed from: h */
    public abstract TStruct mo40906h() throws TException;

    /* renamed from: i */
    public abstract void mo40907i() throws TException;

    /* renamed from: j */
    public abstract TField mo40908j() throws TException;

    /* renamed from: k */
    public abstract void mo40909k() throws TException;

    /* renamed from: l */
    public abstract TMap mo40910l() throws TException;

    /* renamed from: m */
    public abstract void mo40911m() throws TException;

    /* renamed from: n */
    public abstract TList mo40912n() throws TException;

    /* renamed from: o */
    public abstract void mo40913o() throws TException;

    /* renamed from: p */
    public abstract TSet mo40914p() throws TException;

    /* renamed from: q */
    public abstract void mo40915q() throws TException;

    /* renamed from: r */
    public abstract boolean mo40916r() throws TException;

    /* renamed from: s */
    public abstract byte mo40917s() throws TException;

    /* renamed from: t */
    public abstract short mo40918t() throws TException;

    /* renamed from: u */
    public abstract int mo40919u() throws TException;

    /* renamed from: v */
    public abstract long mo40920v() throws TException;

    /* renamed from: w */
    public abstract double mo40921w() throws TException;

    /* renamed from: x */
    public abstract String mo40922x() throws TException;

    /* renamed from: y */
    public abstract ByteBuffer mo40923y() throws TException;

    protected TProtocol(TTransport fVar) {
        this.f29157c = fVar;
    }

    /* renamed from: B */
    public TTransport mo40951B() {
        return this.f29157c;
    }

    /* renamed from: C */
    public Class<? extends IScheme> mo40942C() {
        return StandardScheme.class;
    }
}
