package com.bytedance.sdk.p145a.p147b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* renamed from: com.bytedance.sdk.a.b.r */
public interface Dns {
    /* renamed from: a */
    public static final Dns f5952a = new Dns() {
        /* JADX WARNING: type inference failed for: r5v4, types: [java.util.List, java.util.List<java.net.InetAddress>] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* renamed from: a */
        public java.util.List<java.net.InetAddress> mo14043a(java.lang.String r5) throws java.net.UnknownHostException {
            /*
            r4 = this;
            if (r5 == 0) goto L_0x0026
            java.net.InetAddress[] r0 = java.net.InetAddress.getAllByName(r5)     // Catch:{ NullPointerException -> 0x000b }
            java.util.List r5 = java.util.Arrays.asList(r0)     // Catch:{ NullPointerException -> 0x000b }
            return r5
        L_0x000b:
            r0 = move-exception
            java.net.UnknownHostException r1 = new java.net.UnknownHostException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Broken system behaviour for dns lookup of "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5)
            r1.initCause(r0)
            throw r1
        L_0x0026:
            java.net.UnknownHostException r5 = new java.net.UnknownHostException
            java.lang.String r0 = "hostname == null"
            r5.<init>(r0)
            throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.p145a.p147b.Dns.C19311.mo14043a(java.lang.String):java.util.List");
        }
    };

    /* renamed from: a */
    List<InetAddress> mo14043a(String str) throws UnknownHostException;
}
