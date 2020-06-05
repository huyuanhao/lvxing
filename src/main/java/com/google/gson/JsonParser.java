package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse((Reader) new StringReader(str));
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (!parse.isJsonNull()) {
                if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("Did not consume the entire document.");
                }
            }
            return parse;
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException((Throwable) e);
        } catch (IOException e2) {
            throw new JsonIOException((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new JsonSyntaxException((Throwable) e3);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public com.google.gson.JsonElement parse(com.google.gson.stream.JsonReader r7) throws com.google.gson.JsonIOException, com.google.gson.JsonSyntaxException {
        /*
        r6 = this;
        java.lang.String r0 = " to Json"
        java.lang.String r1 = "Failed parsing JSON source: "
        boolean r2 = r7.isLenient()
        r3 = 1
        r7.setLenient(r3)
        com.google.gson.JsonElement r0 = com.google.gson.internal.Streams.parse(r7)     // Catch:{ StackOverflowError -> 0x002f, OutOfMemoryError -> 0x0016 }
        r7.setLenient(r2)
        return r0
    L_0x0014:
        r0 = move-exception
        goto L_0x0048
    L_0x0016:
        r3 = move-exception
        com.google.gson.JsonParseException r4 = new com.google.gson.JsonParseException     // Catch:{ all -> 0x0014 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
        r5.<init>()     // Catch:{ all -> 0x0014 }
        r5.append(r1)     // Catch:{ all -> 0x0014 }
        r5.append(r7)     // Catch:{ all -> 0x0014 }
        r5.append(r0)     // Catch:{ all -> 0x0014 }
        java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0014 }
        r4.m44850init(r0, r3)     // Catch:{ all -> 0x0014 }
        throw r4     // Catch:{ all -> 0x0014 }
    L_0x002f:
        r3 = move-exception
        com.google.gson.JsonParseException r4 = new com.google.gson.JsonParseException     // Catch:{ all -> 0x0014 }
        java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0014 }
        r5.<init>()     // Catch:{ all -> 0x0014 }
        r5.append(r1)     // Catch:{ all -> 0x0014 }
        r5.append(r7)     // Catch:{ all -> 0x0014 }
        r5.append(r0)     // Catch:{ all -> 0x0014 }
        java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0014 }
        r4.m44850init(r0, r3)     // Catch:{ all -> 0x0014 }
        throw r4     // Catch:{ all -> 0x0014 }
    L_0x0048:
        r7.setLenient(r2)
        throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonParser.parse(com.google.gson.stream.JsonReader):com.google.gson.JsonElement");
    }
}
