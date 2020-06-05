package com.ksad.lottie.p302c;

import android.util.JsonReader;
import com.ksad.lottie.model.content.MergePaths;
import com.ksad.lottie.model.content.MergePaths.MergePathsMode;

/* renamed from: com.ksad.lottie.c.af */
class C3672af {
    /* renamed from: a */
    static MergePaths m15272a(JsonReader jsonReader) {
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
