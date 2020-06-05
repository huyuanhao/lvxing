package androidx.core.content;

import android.content.SharedPreferences.Editor;

@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    /* renamed from: androidx.core.content.SharedPreferencesCompat$EditorCompat */
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper = new Helper();

        /* renamed from: androidx.core.content.SharedPreferencesCompat$EditorCompat$Helper */
        private static class Helper {
            Helper() {
            }

            public void apply(Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private EditorCompat() {
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        @Deprecated
        public void apply(Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    private SharedPreferencesCompat() {
    }
}
