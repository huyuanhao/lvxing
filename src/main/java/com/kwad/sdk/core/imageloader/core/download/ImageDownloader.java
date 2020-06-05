package com.kwad.sdk.core.imageloader.core.download;

import com.tencent.android.tpush.common.MessageKey;
import java.io.InputStream;
import java.util.Locale;

public interface ImageDownloader {

    /* renamed from: com.kwad.sdk.core.imageloader.core.download.ImageDownloader$Scheme */
    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT(MessageKey.MSG_CONTENT),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");
        
        private String scheme;
        private String uriPrefix;

        private Scheme(String str) {
            this.scheme = str;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("://");
            this.uriPrefix = sb.toString();
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            Scheme[] values;
            if (str != null) {
                for (Scheme scheme2 : values()) {
                    if (scheme2.belongsTo(str)) {
                        return scheme2;
                    }
                }
            }
            return UNKNOWN;
        }

        public String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[]{str, this.scheme}));
        }

        public String wrap(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.uriPrefix);
            sb.append(str);
            return sb.toString();
        }
    }

    InputStream getStream(String str, Object obj);
}
