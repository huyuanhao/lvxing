package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private Key key;

    /* renamed from: com.bumptech.glide.load.engine.GlideException$a */
    private static final class C1632a implements Appendable {
        /* renamed from: a */
        private final Appendable f4433a;
        /* renamed from: b */
        private boolean f4434b = true;

        /* renamed from: a */
        private CharSequence m5390a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        C1632a(Appendable appendable) {
            this.f4433a = appendable;
        }

        public Appendable append(char c) throws IOException {
            boolean z = false;
            if (this.f4434b) {
                this.f4434b = false;
                this.f4433a.append("  ");
            }
            if (c == 10) {
                z = true;
            }
            this.f4434b = z;
            this.f4433a.append(c);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a = m5390a(charSequence);
            return append(a, 0, a.length());
        }

        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence a = m5390a(charSequence);
            boolean z = false;
            if (this.f4434b) {
                this.f4434b = false;
                this.f4433a.append("  ");
            }
            if (a.length() > 0 && a.charAt(i2 - 1) == 10) {
                z = true;
            }
            this.f4434b = z;
            this.f4433a.append(a, i, i2);
            return this;
        }
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    /* access modifiers changed from: 0000 */
    public void setLoggingDetails(Key cVar, DataSource dataSource2) {
        setLoggingDetails(cVar, dataSource2, null);
    }

    /* access modifiers changed from: 0000 */
    public void setLoggingDetails(Key cVar, DataSource dataSource2, Class<?> cls) {
        this.key = cVar;
        this.dataSource = dataSource2;
        this.dataClass = cls;
    }

    public void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), (Throwable) rootCauses.get(i));
            i = i2;
        }
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable addRootCauses : ((GlideException) th).getCauses()) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th);
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new C1632a(appendable));
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String str3 = ", ";
        String str4 = "";
        if (this.dataClass != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(this.dataClass);
            str = sb2.toString();
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.dataSource != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str3);
            sb3.append(this.dataSource);
            str2 = sb3.toString();
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.key != null) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str3);
            sb4.append(this.key);
            str4 = sb4.toString();
        }
        sb.append(str4);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" causes:");
        }
        for (Throwable th : rootCauses) {
            sb.append(10);
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    private static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i = i2;
        }
    }
}
