package exception;

public class SignupWrongException extends RuntimeException {
    public SignupWrongException() {};
    public SignupWrongException(String message) {
        super(message);
    }
}
