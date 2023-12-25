package site.ugaeng.ugaeng.exception;

public abstract class UgaengException extends RuntimeException {

    public UgaengException(String message) {
        super(message);
    }

    public UgaengException(String message, Exception exception) {
        super(message, exception);
    }
}
