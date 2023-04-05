package exception;
/**
 * insert, update, delete 결과 오류 시의 예외처리
 * @author Seojisoo
 *
 */
public class DMLException extends RuntimeException{
	public DMLException() {};
	public DMLException(String message) {
		super(message);
	}
}
