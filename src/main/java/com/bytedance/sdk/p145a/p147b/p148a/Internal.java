package com.bytedance.sdk.p145a.p147b.p148a;

import com.bytedance.sdk.p145a.p147b.Address;
import com.bytedance.sdk.p145a.p147b.C1935u.C1936a;
import com.bytedance.sdk.p145a.p147b.ConnectionPool;
import com.bytedance.sdk.p145a.p147b.ConnectionSpec;
import com.bytedance.sdk.p145a.p147b.Response.C1921a;
import com.bytedance.sdk.p145a.p147b.Route;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RealConnection;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.RouteDatabase;
import com.bytedance.sdk.p145a.p147b.p148a.p150b.StreamAllocation;
import java.net.Socket;
import javax.net.ssl.SSLSocket;

/* renamed from: com.bytedance.sdk.a.b.a.a */
public abstract class Internal {
    /* renamed from: a */
    public static Internal f5302a;

    /* renamed from: a */
    public abstract int mo13654a(C1921a aVar);

    /* renamed from: a */
    public abstract RealConnection mo13655a(ConnectionPool mVar, Address aVar, StreamAllocation gVar, Route dVar);

    /* renamed from: a */
    public abstract RouteDatabase mo13656a(ConnectionPool mVar);

    /* renamed from: a */
    public abstract Socket mo13657a(ConnectionPool mVar, Address aVar, StreamAllocation gVar);

    /* renamed from: a */
    public abstract void mo13658a(ConnectionPool mVar, RealConnection cVar);

    /* renamed from: a */
    public abstract void mo13659a(ConnectionSpec nVar, SSLSocket sSLSocket, boolean z);

    /* renamed from: a */
    public abstract void mo13660a(C1936a aVar, String str);

    /* renamed from: a */
    public abstract void mo13661a(C1936a aVar, String str, String str2);

    /* renamed from: a */
    public abstract boolean mo13662a(Address aVar, Address aVar2);

    /* renamed from: b */
    public abstract boolean mo13663b(ConnectionPool mVar, RealConnection cVar);
}
