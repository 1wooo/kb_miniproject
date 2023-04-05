package exception;
/**
 * 작성자 : 서지수
 * insert, update, delete 결과 오류 시의 예외처리
 *
 */
public class DMLException extends RuntimeException{
	public DMLException() {};
	public DMLException(String message) {
		super(message);
	}
}
