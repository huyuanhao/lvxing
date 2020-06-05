package com.elvishew.xlog;

import com.elvishew.xlog.formatter.p227a.BorderFormatter;
import com.elvishew.xlog.formatter.p228b.p229a.JsonFormatter;
import com.elvishew.xlog.formatter.p228b.p230b.C2608c;
import com.elvishew.xlog.formatter.p228b.p231c.ThrowableFormatter;
import com.elvishew.xlog.formatter.p228b.p232d.XmlFormatter;
import com.elvishew.xlog.formatter.p233c.StackTraceFormatter;
import com.elvishew.xlog.formatter.p234d.ThreadFormatter;
import com.elvishew.xlog.p223b.C2604a;
import com.elvishew.xlog.p224c.DefaultsFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.elvishew.xlog.a */
public class LogConfiguration {
    /* renamed from: a */
    public final int f9418a;
    /* renamed from: b */
    public final String f9419b;
    /* renamed from: c */
    public final boolean f9420c;
    /* renamed from: d */
    public final boolean f9421d;
    /* renamed from: e */
    public final String f9422e;
    /* renamed from: f */
    public final int f9423f;
    /* renamed from: g */
    public final boolean f9424g;
    /* renamed from: h */
    public final JsonFormatter f9425h;
    /* renamed from: i */
    public final XmlFormatter f9426i;
    /* renamed from: j */
    public final ThrowableFormatter f9427j;
    /* renamed from: k */
    public final ThreadFormatter f9428k;
    /* renamed from: l */
    public final StackTraceFormatter f9429l;
    /* renamed from: m */
    public final BorderFormatter f9430m;
    /* renamed from: n */
    public final List<C2604a> f9431n;
    /* renamed from: o */
    private final Map<Class<?>, C2608c<?>> f9432o;

    /* compiled from: LogConfiguration */
    /* renamed from: com.elvishew.xlog.a$a */
    public static class C2603a {
        /* access modifiers changed from: private */
        /* renamed from: a */
        public int f9433a = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        /* renamed from: b */
        public String f9434b = "X-LOG";
        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean f9435c;
        /* access modifiers changed from: private */
        /* renamed from: d */
        public boolean f9436d;
        /* access modifiers changed from: private */
        /* renamed from: e */
        public String f9437e;
        /* access modifiers changed from: private */
        /* renamed from: f */
        public int f9438f;
        /* access modifiers changed from: private */
        /* renamed from: g */
        public boolean f9439g;
        /* access modifiers changed from: private */
        /* renamed from: h */
        public JsonFormatter f9440h;
        /* access modifiers changed from: private */
        /* renamed from: i */
        public XmlFormatter f9441i;
        /* access modifiers changed from: private */
        /* renamed from: j */
        public ThrowableFormatter f9442j;
        /* access modifiers changed from: private */
        /* renamed from: k */
        public ThreadFormatter f9443k;
        /* access modifiers changed from: private */
        /* renamed from: l */
        public StackTraceFormatter f9444l;
        /* access modifiers changed from: private */
        /* renamed from: m */
        public BorderFormatter f9445m;
        /* access modifiers changed from: private */
        /* renamed from: n */
        public Map<Class<?>, C2608c<?>> f9446n;
        /* access modifiers changed from: private */
        /* renamed from: o */
        public List<C2604a> f9447o;

        /* renamed from: a */
        public C2603a mo17086a(String str) {
            this.f9434b = str;
            return this;
        }

        /* renamed from: a */
        public C2603a mo17085a(JsonFormatter bVar) {
            this.f9440h = bVar;
            return this;
        }

        /* renamed from: a */
        public C2603a mo17084a(BorderFormatter aVar) {
            this.f9445m = aVar;
            return this;
        }

        /* renamed from: a */
        public LogConfiguration mo17087a() {
            m12629b();
            return new LogConfiguration(this);
        }

        /* renamed from: b */
        private void m12629b() {
            if (this.f9440h == null) {
                this.f9440h = DefaultsFactory.m12652a();
            }
            if (this.f9441i == null) {
                this.f9441i = DefaultsFactory.m12653b();
            }
            if (this.f9442j == null) {
                this.f9442j = DefaultsFactory.m12654c();
            }
            if (this.f9443k == null) {
                this.f9443k = DefaultsFactory.m12655d();
            }
            if (this.f9444l == null) {
                this.f9444l = DefaultsFactory.m12656e();
            }
            if (this.f9445m == null) {
                this.f9445m = DefaultsFactory.m12657f();
            }
            if (this.f9446n == null) {
                this.f9446n = new HashMap(DefaultsFactory.m12660i());
            }
        }
    }

    LogConfiguration(C2603a aVar) {
        this.f9418a = aVar.f9433a;
        this.f9419b = aVar.f9434b;
        this.f9420c = aVar.f9435c;
        this.f9421d = aVar.f9436d;
        this.f9422e = aVar.f9437e;
        this.f9423f = aVar.f9438f;
        this.f9424g = aVar.f9439g;
        this.f9425h = aVar.f9440h;
        this.f9426i = aVar.f9441i;
        this.f9427j = aVar.f9442j;
        this.f9428k = aVar.f9443k;
        this.f9429l = aVar.f9444l;
        this.f9430m = aVar.f9445m;
        this.f9432o = aVar.f9446n;
        this.f9431n = aVar.f9447o;
    }
}
