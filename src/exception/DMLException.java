package exception;
/**
 * @author 서지수
 * @param insert, update, delete 오류 예외처리
 */
public class DMLException extends RuntimeException{
	public DMLException() {};
	public DMLException(String message) {
		super(message);
	}
}
