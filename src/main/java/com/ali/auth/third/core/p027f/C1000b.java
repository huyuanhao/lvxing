package com.ali.auth.third.core.p027f;

import android.content.Context;
import com.ali.auth.third.core.p024c.C0989a;
import com.ali.auth.third.core.p033j.C1018a;
import com.ali.auth.third.core.util.C1041f;
import com.tencent.android.tpush.SettingsContentProvider;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.ali.auth.third.core.f.b */
public class C1000b {
    /* renamed from: a */
    private static Map<Integer, C0999a> f1946a = new HashMap();
    /* renamed from: b */
    private static ReentrantReadWriteLock f1947b = new ReentrantReadWriteLock();
    /* renamed from: c */
    private static final C0999a f1948c = new C0999a();
    /* renamed from: d */
    private static final C0999a f1949d = new C0999a();
    /* renamed from: e */
    private static C0999a f1950e;
    /* renamed from: f */
    private static C0999a f1951f;
    /* renamed from: g */
    private static final Object f1952g = new Object();

    static {
        C0999a aVar = f1948c;
        aVar.f1942a = 1;
        aVar.f1944c = "未在消息文件中找到 id 为 {0} 的消息";
        String str = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        aVar.f1945d = str;
        String str2 = "E";
        aVar.f1943b = str2;
        C0999a aVar2 = f1949d;
        aVar2.f1942a = 2;
        aVar2.f1944c = "检索消息时发生如下错误 {0}";
        aVar2.f1945d = str;
        aVar2.f1943b = str2;
    }

    /* renamed from: a */
    private static C0999a m1913a(int i) {
        if (f1950e == null) {
            synchronized (f1952g) {
                if (f1950e == null) {
                    f1950e = m1916b(1);
                    if (f1950e == null) {
                        f1950e = f1948c;
                    }
                }
            }
        }
        try {
            C0999a aVar = (C0999a) f1950e.clone();
            aVar.f1944c = MessageFormat.format(aVar.f1944c, new Object[]{String.valueOf(i)});
            return aVar;
        } catch (CloneNotSupportedException unused) {
            return f1950e;
        }
    }

    /* renamed from: a */
    public static C0999a m1914a(int i, Object... objArr) {
        try {
            f1947b.readLock().lock();
            C0999a aVar = (C0999a) f1946a.get(Integer.valueOf(i));
            if (aVar == null) {
                f1947b.readLock().unlock();
                f1947b.writeLock().lock();
                aVar = m1916b(i);
                if (aVar != null) {
                    f1946a.put(Integer.valueOf(i), aVar);
                }
                f1947b.readLock().lock();
                f1947b.writeLock().unlock();
            }
            if (aVar == null) {
                C0999a a = m1913a(i);
                f1947b.readLock().unlock();
                return a;
            } else if (objArr.length == 0) {
                f1947b.readLock().unlock();
                return aVar;
            } else {
                C0999a aVar2 = (C0999a) aVar.clone();
                aVar2.f1944c = MessageFormat.format(aVar.f1944c, objArr);
                f1947b.readLock().unlock();
                return aVar2;
            }
        } catch (Exception e) {
            return m1915a(e.getMessage());
        } catch (Throwable th) {
            f1947b.writeLock().unlock();
            throw th;
        }
    }

    /* renamed from: a */
    private static C0999a m1915a(String str) {
        if (f1951f == null) {
            synchronized (f1952g) {
                if (f1951f == null) {
                    f1951f = m1916b(2);
                    if (f1951f == null) {
                        f1951f = f1949d;
                    }
                }
            }
        }
        try {
            C0999a aVar = (C0999a) f1951f.clone();
            aVar.f1944c = MessageFormat.format(aVar.f1944c, new Object[]{str});
            return aVar;
        } catch (CloneNotSupportedException unused) {
            return f1951f;
        }
    }

    /* renamed from: b */
    private static C0999a m1916b(int i) {
        String str;
        String str2;
        String str3 = "_type";
        String str4 = "_action";
        String str5 = "_message";
        String str6 = SettingsContentProvider.STRING_TYPE;
        String str7 = "auth_sdk_message_";
        try {
            Context c = C0989a.m1887c();
            StringBuilder sb = new StringBuilder();
            sb.append(str7);
            sb.append(i);
            sb.append(str5);
            if (C1041f.m2003a(c, str6, sb.toString()) == 0) {
                return null;
            }
            C0999a aVar = new C0999a();
            aVar.f1942a = i;
            Context c2 = C0989a.m1887c();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str7);
            sb2.append(i);
            sb2.append(str5);
            aVar.f1944c = C1041f.m2004a(c2, sb2.toString());
            Context c3 = C0989a.m1887c();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str7);
            sb3.append(i);
            sb3.append(str4);
            if (C1041f.m2003a(c3, str6, sb3.toString()) != 0) {
                Context c4 = C0989a.m1887c();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str7);
                sb4.append(i);
                sb4.append(str4);
                str = C1041f.m2004a(c4, sb4.toString());
            } else {
                str = "";
            }
            aVar.f1945d = str;
            Context c5 = C0989a.m1887c();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str7);
            sb5.append(i);
            sb5.append(str3);
            if (C1041f.m2003a(c5, str6, sb5.toString()) != 0) {
                Context c6 = C0989a.m1887c();
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str7);
                sb6.append(i);
                sb6.append(str3);
                str2 = C1041f.m2004a(c6, sb6.toString());
            } else {
                str2 = "I";
            }
            aVar.f1943b = str2;
            return aVar;
        } catch (Exception e) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Fail to get message of the code ");
            sb7.append(i);
            sb7.append(", the error message is ");
            sb7.append(e.getMessage());
            C1018a.m1967d("kernel", sb7.toString());
            return null;
        }
    }

    /* renamed from: b */
    public static String m1917b(int i, Object... objArr) {
        try {
            f1947b.readLock().lock();
            C0999a aVar = (C0999a) f1946a.get(Integer.valueOf(i));
            if (aVar == null) {
                f1947b.readLock().unlock();
                f1947b.writeLock().lock();
                aVar = m1916b(i);
                if (aVar != null) {
                    f1946a.put(Integer.valueOf(i), aVar);
                }
                f1947b.readLock().lock();
                f1947b.writeLock().unlock();
            }
            if (aVar == null) {
                String str = m1913a(i).f1944c;
                f1947b.readLock().unlock();
                return str;
            }
            String format = MessageFormat.format(aVar.f1944c, objArr);
            f1947b.readLock().unlock();
            return format;
        } catch (Exception e) {
            return m1915a(e.getMessage()).f1944c;
        } catch (Throwable th) {
            f1947b.writeLock().unlock();
            throw th;
        }
    }
}
