package ezy.assist.exception;

public class UncheckedException extends RuntimeException {
    private static final long serialVersionUID = 4140223302171577501L;

    public UncheckedException(Throwable th) {
        super(th);
    }

    public String getMessage() {
        return super.getCause().getMessage();
    }
}
