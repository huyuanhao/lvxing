package com.airbnb.lottie.model.content;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.p008a.p009a.Content;
import com.airbnb.lottie.p008a.p009a.MergePathsContent;

public class MergePaths implements ContentModel {
    /* renamed from: a */
    private final String f1603a;
    /* renamed from: b */
    private final MergePathsMode f1604b;

    /* renamed from: com.airbnb.lottie.model.content.MergePaths$MergePathsMode */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            if (i == 1) {
                return Merge;
            }
            if (i == 2) {
                return Add;
            }
            if (i == 3) {
                return Subtract;
            }
            if (i == 4) {
                return Intersect;
            }
            if (i != 5) {
                return Merge;
            }
            return ExcludeIntersections;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f1603a = str;
        this.f1604b = mergePathsMode;
    }

    /* renamed from: a */
    public String mo10036a() {
        return this.f1603a;
    }

    /* renamed from: b */
    public MergePathsMode mo10037b() {
        return this.f1604b;
    }

    /* renamed from: a */
    public Content mo10020a(LottieDrawable lottieDrawable, BaseLayer aVar) {
        if (lottieDrawable.mo9797a()) {
            return new MergePathsContent(this);
        }
        L.m1314b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergePaths{mode=");
        sb.append(this.f1604b);
        sb.append('}');
        return sb.toString();
    }
}
