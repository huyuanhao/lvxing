package com.airbnb.lottie.p012c;

import android.util.JsonReader;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.MergePaths.MergePathsMode;
import java.io.IOException;

/* renamed from: com.airbnb.lottie.c.v */
class MergePathsParser {
    /* renamed from: a */
    static MergePaths m1386a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePathsMode mergePathsMode = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3488) {
                if (hashCode == 3519 && nextName.equals("nm")) {
                    c = 0;
                }
            } else if (nextName.equals("mm")) {
                c = 1;
            }
            if (c == 0) {
                str = jsonReader.nextString();
            } else if (c != 1) {
                jsonReader.skipValue();
            } else {
                mergePathsMode = MergePathsMode.forId(jsonReader.nextInt());
            }
        }
        return new MergePaths(str, mergePathsMode);
    }
}
