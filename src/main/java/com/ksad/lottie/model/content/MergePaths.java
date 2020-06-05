package com.ksad.lottie.model.content;

import com.ksad.lottie.C3665c;
import com.ksad.lottie.C3721f;
import com.ksad.lottie.model.layer.C3774a;
import com.ksad.lottie.p298a.p299a.C3627b;
import com.ksad.lottie.p298a.p299a.C3636k;

public class MergePaths implements C3761b {
    /* renamed from: a */
    private final String f12742a;
    /* renamed from: b */
    private final MergePathsMode f12743b;

    /* renamed from: com.ksad.lottie.model.content.MergePaths$MergePathsMode */
    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        public static MergePathsMode forId(int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? Merge : ExcludeIntersections : Intersect : Subtract : Add : Merge;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f12742a = str;
        this.f12743b = mergePathsMode;
    }

    /* renamed from: a */
    public C3627b mo23039a(C3721f fVar, C3774a aVar) {
        if (fVar.mo22961a()) {
            return new C3636k(this);
        }
        C3665c.m15251b("Animation contains merge paths but they are disabled.");
        return null;
    }

    /* renamed from: a */
    public String mo23055a() {
        return this.f12742a;
    }

    /* renamed from: b */
    public MergePathsMode mo23056b() {
        return this.f12743b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MergePaths{mode=");
        sb.append(this.f12743b);
        sb.append('}');
        return sb.toString();
    }
}
