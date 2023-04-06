package exception;
/**
 * @author 서지수
 * @param 로그인 예외처리
 */
public class LoginWrongException extends RuntimeException{
	public LoginWrongException() {};
	public LoginWrongException(String message) {
		super(message);
	}
}
