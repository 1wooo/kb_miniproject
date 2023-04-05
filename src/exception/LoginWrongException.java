package exception;
/**
 * 로그인 오류 시 예외처리
 * @author Seojisoo
 *
 */
public class LoginWrongException extends RuntimeException{
	public LoginWrongException() {};
	public LoginWrongException(String message) {
		super(message);
	}
}
