package mtopsdk.mtop.domain;

public enum MethodEnum {
    GET(r2),
    POST(r3),
    HEAD(r4),
    PATCH(r5);
    
    private String method;

    public final String getMethod() {
        return this.method;
    }

    private MethodEnum(String str) {
        this.method = str;
    }
}
