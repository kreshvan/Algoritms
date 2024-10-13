package IndexMinMaxException;

public class IndexMinMaxException extends RuntimeException{
    public IndexMinMaxException() {
    }

    public IndexMinMaxException(String message) {
        super(message);
    }

    public IndexMinMaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexMinMaxException(Throwable cause) {
        super(cause);
    }

    public IndexMinMaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
