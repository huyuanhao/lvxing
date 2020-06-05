package ezy.app.data;

import android.util.Base64;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.C8271i;
import kotlin.text.C8313m;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0002J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo39189d2 = {"Lezy/app/data/Token;", "Ljava/io/Serializable;", "accessToken", "", "refreshToken", "expiresIn", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getAccessToken", "()Ljava/lang/String;", "getExpiresIn", "()I", "getRefreshToken", "uid", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "parseUid", "token", "toString", "Companion", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
/* compiled from: Token.kt */
public final class Token implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    private final String accessToken;
    private final int expiresIn;
    private final String refreshToken;
    private String uid;

    @Metadata(mo39187bv = {1, 0, 3}, mo39188d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo39189d2 = {"Lezy/app/data/Token$Companion;", "", "()V", "serialVersionUID", "", "lib.framework_release"}, mo39190k = 1, mo39191mv = {1, 1, 15})
    /* compiled from: Token.kt */
    /* renamed from: ezy.app.data.Token$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker fVar) {
            this();
        }
    }

    public Token() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ Token copy$default(Token token, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = token.accessToken;
        }
        if ((i2 & 2) != 0) {
            str2 = token.refreshToken;
        }
        if ((i2 & 4) != 0) {
            i = token.expiresIn;
        }
        return token.copy(str, str2, i);
    }

    public final String component1() {
        return this.accessToken;
    }

    public final String component2() {
        return this.refreshToken;
    }

    public final int component3() {
        return this.expiresIn;
    }

    public final Token copy(String str, String str2, int i) {
        return new Token(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Token) {
                Token token = (Token) obj;
                if (C8271i.m35384a((Object) this.accessToken, (Object) token.accessToken) && C8271i.m35384a((Object) this.refreshToken, (Object) token.refreshToken)) {
                    if (this.expiresIn == token.expiresIn) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.accessToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.refreshToken;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.expiresIn;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Token(accessToken=");
        sb.append(this.accessToken);
        sb.append(", refreshToken=");
        sb.append(this.refreshToken);
        sb.append(", expiresIn=");
        sb.append(this.expiresIn);
        sb.append(")");
        return sb.toString();
    }

    public Token(String str, String str2, int i) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.expiresIn = i;
    }

    public /* synthetic */ Token(String str, String str2, int i, int i2, DefaultConstructorMarker fVar) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(str, str2, i);
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final int getExpiresIn() {
        return this.expiresIn;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String uid() {
        if (this.uid == null) {
            this.uid = parseUid(this.accessToken);
        }
        return this.uid;
    }

    private final String parseUid(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode((String) C8313m.m35485b((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null).get(1), 0);
            C8271i.m35382a((Object) decode, "Base64.decode(it.split(\".\")[1], Base64.DEFAULT)");
            return new JSONObject(new String(decode, Charsets.f27799a)).get("sub").toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
