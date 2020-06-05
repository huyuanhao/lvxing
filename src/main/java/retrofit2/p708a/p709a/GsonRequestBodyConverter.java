package retrofit2.p708a.p709a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.C8358aa;
import okhttp3.C8510v;
import okio.C8525c;
import retrofit2.Converter;

/* renamed from: retrofit2.a.a.b */
final class GsonRequestBodyConverter<T> implements Converter<T, C8358aa> {
    /* renamed from: a */
    private static final C8510v f29306a = C8510v.m36598b("application/json; charset=UTF-8");
    /* renamed from: b */
    private static final Charset f29307b = Charset.forName("UTF-8");
    /* renamed from: c */
    private final Gson f29308c;
    /* renamed from: d */
    private final TypeAdapter<T> f29309d;

    GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f29308c = gson;
        this.f29309d = typeAdapter;
    }

    /* renamed from: b */
    public C8358aa mo41274a(T t) throws IOException {
        C8525c cVar = new C8525c();
        JsonWriter newJsonWriter = this.f29308c.newJsonWriter(new OutputStreamWriter(cVar.mo40746d(), f29307b));
        this.f29309d.write(newJsonWriter, t);
        newJsonWriter.close();
        return C8358aa.m35766a(f29306a, cVar.mo40776p());
    }
}
