package exception;
/**
 * 작성자 : 서지수
 * 로그인 오류 시 예외처리
 *
 */
public class LoginWrongException extends RuntimeException{
	public LoginWrongException() {};
	public LoginWrongException(String message) {
		super(message);
	}
}
