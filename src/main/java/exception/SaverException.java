package exception;

public class SaverException extends Exception {
    public SaverException() {
        super();
    }

    public SaverException(String message) {
        super(message);
    }

    public SaverException(String message, Throwable cause) {
        super(message, cause);
    }
}
