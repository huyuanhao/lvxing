package com.tencent.android.tpush.service.channel.p592b;

import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.p580b.C6864a;
import com.tencent.android.tpush.service.channel.exception.IORefusedException;
import com.tencent.android.tpush.service.channel.exception.InnerException;
import com.tencent.android.tpush.service.channel.exception.UnexpectedDataException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
/* renamed from: com.tencent.android.tpush.service.channel.b.a */
public class C7021a extends C7026f implements C7024d {
    /* renamed from: k */
    private static final Pattern f23326k = Pattern.compile("\\A(\\S+) +(\\d+) +(.*)\r\n");
    /* renamed from: l */
    private static final Pattern f23327l = Pattern.compile("(.*) *: *(.*)\r\n");
    /* renamed from: a */
    protected StringBuffer f23328a = new StringBuffer();
    /* renamed from: b */
    protected String f23329b;
    /* renamed from: c */
    public int f23330c;
    /* renamed from: d */
    protected String f23331d;
    /* renamed from: e */
    protected final HashMap<String, String> f23332e = new HashMap<>();
    /* renamed from: f */
    protected int f23333f = -1;
    /* renamed from: g */
    protected int f23334g = 0;
    /* renamed from: h */
    protected int f23335h = -1;
    /* renamed from: i */
    public final ArrayList<C7027g> f23336i = new ArrayList<>();
    /* renamed from: m */
    private int f23337m = 0;
    /* renamed from: n */
    private C7027g f23338n = null;

    /* renamed from: a */
    public int mo33411a(InputStream inputStream) {
        int i;
        int i2;
        mo33425c();
        int i3 = 0;
        if (inputStream.available() == 0) {
            return 0;
        }
        try {
            this.f23334g = 0;
            while (!mo33424b()) {
                int i4 = this.f23334g;
                this.f23334g = i4 + 1;
                if (i4 <= 2) {
                    int i5 = this.f23335h;
                    if (i5 == -3) {
                        i2 = mo33415d(inputStream);
                    } else if (i5 == -2) {
                        i2 = mo33414c(inputStream);
                    } else if (i5 == -1) {
                        i2 = mo33413b(inputStream);
                    } else if (i5 == 0) {
                        mo33426d();
                        if (this.f23335h == 0 && inputStream.available() == 0) {
                            return i3;
                        }
                    } else {
                        throw new InnerException("illegal step value!");
                    }
                    i3 += i2;
                    if (this.f23335h == 0) {
                    }
                } else {
                    throw new InnerException("the duration of the current step is too long!");
                }
            }
        } catch (IORefusedException e) {
            C6864a.m29302d("Channel.HttpRecvPacket", "read >>> IORefusedException thrown", e);
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33412a(int i) {
        if (this.f23335h != i) {
            this.f23334g = 0;
        }
        this.f23335h = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo33413b(InputStream inputStream) {
        String str = "";
        String str2 = Constants.LogTag;
        int available = inputStream.available();
        int i = 0;
        while (true) {
            int i2 = available - 1;
            if (available <= 0) {
                return i;
            }
            i++;
            int read = inputStream.read();
            if (read != -1) {
                if (read != 10) {
                    this.f23328a.append((char) read);
                } else {
                    this.f23328a.append((char) read);
                    int length = this.f23328a.length();
                    if (length >= 4) {
                        if ("\r\n\r\n".contentEquals(this.f23328a.subSequence(length - 4, length))) {
                            Pattern pattern = f23326k;
                            StringBuffer stringBuffer = this.f23328a;
                            Matcher matcher = pattern.matcher(stringBuffer.subSequence(0, stringBuffer.length()));
                            String str3 = "http statusLine can not parsed!";
                            if (!matcher.find() || matcher.groupCount() != 3) {
                                throw new UnexpectedDataException(str3);
                            }
                            this.f23329b = matcher.group(1);
                            try {
                                this.f23330c = Integer.parseInt(matcher.group(2).trim());
                                this.f23331d = matcher.group(3);
                                Pattern pattern2 = f23327l;
                                StringBuffer stringBuffer2 = this.f23328a;
                                Matcher matcher2 = pattern2.matcher(stringBuffer2.subSequence(0, stringBuffer2.length()));
                                while (matcher2.find() && matcher2.groupCount() == 2) {
                                    this.f23332e.put(matcher2.group(1).toLowerCase(Locale.US), matcher2.group(2));
                                }
                                String str4 = "Transfer-Encoding";
                                if (!this.f23332e.containsKey(str4.toLowerCase(Locale.US)) || !((String) this.f23332e.get(str4.toLowerCase(Locale.US))).equalsIgnoreCase("chunked")) {
                                    String str5 = "Content-Length";
                                    if (this.f23332e.get(str5.toLowerCase(Locale.US)) != null) {
                                        try {
                                            this.f23333f = Integer.parseInt(((String) this.f23332e.get(str5.toLowerCase(Locale.US))).trim());
                                            mo33412a(-2);
                                            return i;
                                        } catch (NumberFormatException e) {
                                            C6864a.m29302d(str2, str, e);
                                            throw new UnexpectedDataException("http Content-Length can not parsed!");
                                        }
                                    } else {
                                        throw new UnexpectedDataException("http Content-Length == null && Transfer-Encoding not equal to 'chunked'!");
                                    }
                                } else {
                                    this.f23333f = -1;
                                    mo33412a(-3);
                                    return i;
                                }
                            } catch (NumberFormatException e2) {
                                C6864a.m29302d(str2, str, e2);
                                throw new UnexpectedDataException(str3);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                available = i2;
            } else {
                throw new IOException("the end of stream has been reached!");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo33414c(InputStream inputStream) {
        int i = 0;
        while (inputStream.available() >= 0) {
            int i2 = this.f23337m;
            int i3 = this.f23333f;
            if (i2 > i3) {
                throw new UnexpectedDataException("readBodyLength > contentLength ?!!");
            } else if (i2 != i3) {
                if (this.f23338n == null) {
                    this.f23338n = new C7027g();
                    this.f23338n.mo33423a(this.f23348j);
                }
                int a = this.f23338n.mo33411a(inputStream);
                int i4 = i + a;
                this.f23337m += a;
                if (this.f23338n.mo33424b()) {
                    this.f23336i.add(this.f23338n);
                    this.f23338n = null;
                }
                if (i == i4) {
                    return i4;
                }
                i = i4;
            } else if (this.f23338n == null) {
                mo33412a(0);
                return i;
            } else {
                throw new InnerException("currentRecvPacket != null ?!!");
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public int mo33415d(InputStream inputStream) {
        throw new InnerException("not support chunked transfer encoding!");
    }
}
