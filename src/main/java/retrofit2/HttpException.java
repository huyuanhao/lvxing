package retrofit2;

public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient C8658l<?> response;

    private static String getMessage(C8658l<?> lVar) {
        C8662o.m37637a(lVar, "response == null");
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(lVar.mo41351a());
        sb.append(" ");
        sb.append(lVar.mo41352b());
        return sb.toString();
    }

    public HttpException(C8658l<?> lVar) {
        super(getMessage(lVar));
        this.code = lVar.mo41351a();
        this.message = lVar.mo41352b();
        this.response = lVar;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public C8658l<?> response() {
        return this.response;
    }
}
