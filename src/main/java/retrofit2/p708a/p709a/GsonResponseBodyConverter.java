package retrofit2.p708a.p709a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.C8364ac;
import retrofit2.Converter;

/* renamed from: retrofit2.a.a.c */
final class GsonResponseBodyConverter<T> implements Converter<C8364ac, T> {
    /* renamed from: a */
    private final Gson f29310a;
    /* renamed from: b */
    private final TypeAdapter<T> f29311b;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f29310a = gson;
        this.f29311b = typeAdapter;
    }

    /* renamed from: a */
    public T mo41274a(C8364ac acVar) throws IOException {
        JsonReader newJsonReader = this.f29310a.newJsonReader(acVar.mo40126f());
        try {
            T read = this.f29311b.read(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            acVar.close();
        }
    }
}
