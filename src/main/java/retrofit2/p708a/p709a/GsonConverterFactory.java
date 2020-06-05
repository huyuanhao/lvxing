package retrofit2.p708a.p709a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.C8358aa;
import okhttp3.C8364ac;
import retrofit2.Converter;
import retrofit2.Converter.C8626a;
import retrofit2.Retrofit;

/* renamed from: retrofit2.a.a.a */
public final class GsonConverterFactory extends C8626a {
    /* renamed from: a */
    private final Gson f29305a;

    /* renamed from: a */
    public static GsonConverterFactory m37471a() {
        return m37472a(new Gson());
    }

    /* renamed from: a */
    public static GsonConverterFactory m37472a(Gson gson) {
        if (gson != null) {
            return new GsonConverterFactory(gson);
        }
        throw new NullPointerException("gson == null");
    }

    private GsonConverterFactory(Gson gson) {
        this.f29305a = gson;
    }

    /* renamed from: a */
    public Converter<C8364ac, ?> mo41272a(Type type, Annotation[] annotationArr, Retrofit mVar) {
        return new GsonResponseBodyConverter(this.f29305a, this.f29305a.getAdapter(TypeToken.get(type)));
    }

    /* renamed from: a */
    public Converter<?, C8358aa> mo41273a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit mVar) {
        return new GsonRequestBodyConverter(this.f29305a, this.f29305a.getAdapter(TypeToken.get(type)));
    }
}
