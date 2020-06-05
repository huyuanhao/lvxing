package com.kwad.sdk.contentalliance.detail.photo.comment;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.kwad.sdk.contentalliance.detail.photo.comment.b */
public class C3965b {
    /* renamed from: a */
    private static Set<String> f13349a = new HashSet();

    /* renamed from: a */
    public static void m16409a(long j, long j2) {
        f13349a.add(m16412d(j, j2));
    }

    /* renamed from: b */
    public static void m16410b(long j, long j2) {
        f13349a.remove(m16412d(j, j2));
    }

    /* renamed from: c */
    public static boolean m16411c(long j, long j2) {
        return f13349a.contains(m16412d(j, j2));
    }

    /* renamed from: d */
    private static String m16412d(long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append(j2);
        return sb.toString();
    }
}
