package ezy.app.p643a.p644a;

import android.util.Base64;
import ezy.assist.p648c.CryptoUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.C8185c;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;
import kotlin.text.Charsets;
import okhttp3.C8358aa;
import okhttp3.C8362ab;
import okhttp3.C8364ac;
import okhttp3.C8508u;
import okhttp3.C8508u.C8509a;
import okhttp3.C8510v;
import okhttp3.C8518z;
import okhttp3.C8518z.C8519a;
import okhttp3.FormBody;
import okio.ByteString;
import okio.C8525c;
import org.json.JSONObject;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo39189d2 = {"Lezy/app/net/interceptor/CryptoInterceptor;", "Lokhttp3/Interceptor;", "rsaPublicKey", "", "([B)V", "decrypt", "Lokhttp3/Response;", "response", "aesKey", "aesIV", "encrypt", "Lokhttp3/Request;", "request", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "rsaEncrypt", "data", "publicKey", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* renamed from: ezy.app.a.a.a */
public final class CryptoInterceptor implements C8508u {
    /* renamed from: a */
    private final byte[] f27253a;

    public CryptoInterceptor(byte[] bArr) {
        C8271i.m35386b(bArr, "rsaPublicKey");
        this.f27253a = bArr;
    }

    public C8362ab intercept(C8509a aVar) throws IOException {
        C8271i.m35386b(aVar, "chain");
        C8518z a = aVar.mo40246a();
        if (a.mo40644a("Encryption") != null) {
            byte[] a2 = CryptoUtil.m34794a(256);
            byte[] b = CryptoUtil.m34798b();
            C8271i.m35382a((Object) a, "request");
            C8271i.m35382a((Object) a2, "aesKey");
            C8271i.m35382a((Object) b, "aesIV");
            C8362ab a3 = aVar.mo40244a(m34753a(a, a2, b));
            C8271i.m35382a((Object) a3, "resp");
            return m34752a(a3, a2, b);
        }
        C8362ab a4 = aVar.mo40244a(a);
        C8271i.m35382a((Object) a4, "chain.proceed(request)");
        return a4;
    }

    /* renamed from: a */
    private final C8518z m34753a(C8518z zVar, byte[] bArr, byte[] bArr2) {
        byte[] bArr3;
        String encodeToString = Base64.encodeToString(m34754a(bArr, this.f27253a), 2);
        String hex = ByteString.m36698of(bArr2, 0, bArr2.length).hex();
        C8358aa d = zVar.mo40649d();
        if (d != null) {
            if (d instanceof FormBody) {
                JSONObject jSONObject = new JSONObject();
                FormBody qVar = (FormBody) d;
                int a = qVar.mo40517a() - 1;
                for (int i = 0; i < a; i++) {
                    jSONObject.putOpt(qVar.mo40519b(i), qVar.mo40521d(i));
                }
                String jSONObject2 = jSONObject.toString();
                C8271i.m35382a((Object) jSONObject2, "json.toString()");
                Charset charset = Charsets.f27799a;
                if (jSONObject2 != null) {
                    byte[] bytes = jSONObject2.getBytes(charset);
                    C8271i.m35382a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    bArr3 = CryptoUtil.m34795a(bytes, bArr, bArr2);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (C8313m.m35480a((CharSequence) String.valueOf(d.mo40084b()), (CharSequence) "application/json", false, 2, (Object) null)) {
                C8525c cVar = new C8525c();
                d.mo40083a(cVar);
                bArr3 = CryptoUtil.m34795a(cVar.mo40780s(), bArr, bArr2);
            } else {
                bArr3 = null;
            }
            if (bArr3 != null) {
                C8510v b = C8510v.m36598b("application/octet-stream");
                C8358aa a2 = C8358aa.m35767a(b, bArr3);
                C8519a a3 = zVar.mo40650e().mo40656a("Content-Type", String.valueOf(b)).mo40656a("Content-Length", String.valueOf(a2.mo40085c()));
                StringBuilder sb = new StringBuilder();
                sb.append(encodeToString);
                sb.append(';');
                sb.append(hex);
                C8518z b2 = a3.mo40656a("Encryption", sb.toString()).mo40657a(zVar.mo40646b(), a2).mo40663b();
                C8271i.m35382a((Object) b2, "request.newBuilder()\n   …                 .build()");
                return b2;
            }
            Void voidR = null;
        }
        return zVar;
    }

    /* renamed from: a */
    private final C8362ab m34752a(C8362ab abVar, byte[] bArr, byte[] bArr2) {
        C8364ac h = abVar.mo40097h();
        if (h == null) {
            return abVar;
        }
        String b = CryptoUtil.m34797b(h.mo40125e(), bArr, bArr2);
        C8510v b2 = C8510v.m36598b("application/json");
        C8364ac a = C8364ac.m35816a(b2, b);
        C8362ab a2 = abVar.mo40098i().mo40108a("Content-Type", String.valueOf(b2)).mo40108a("Content-Length", String.valueOf(a.mo40121b())).mo40111a(a).mo40115a();
        C8271i.m35382a((Object) a2, "response.newBuilder()\n  …                 .build()");
        return a2;
    }

    /* renamed from: a */
    private final byte[] m34754a(byte[] bArr, byte[] bArr2) {
        String str = "RSA";
        try {
            PublicKey generatePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArr2));
            Cipher instance = Cipher.getInstance(str);
            instance.init(1, generatePublic);
            byte[] doFinal = instance.doFinal(bArr);
            C8271i.m35382a((Object) doFinal, "cipher.doFinal(data)");
            return doFinal;
        } catch (Exception e) {
            e.printStackTrace();
            return C8185c.m35260a(new Byte[0]);
        }
    }
}
