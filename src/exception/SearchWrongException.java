package exception;

/**
 * @author 서지수
 * @param 검색오류 예외처리
 */
public class SearchWrongException extends RuntimeException{
	private static final long serialVersionUID=1L;
	public SearchWrongException(){};
	public SearchWrongException(String message){
		super(message);
	};
}
