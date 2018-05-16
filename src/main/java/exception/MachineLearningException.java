package exception;

public class MachineLearningException extends Exception {
    public MachineLearningException() {
        super();
    }

    public MachineLearningException(String message) {
        super(message);
    }

    public MachineLearningException(String message, Throwable cause) {
        super(message, cause);
    }
}
