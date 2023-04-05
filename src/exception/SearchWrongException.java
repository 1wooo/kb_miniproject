package exception;

/**
 * 작성자 : 서지수
 * 검색 오류 발생 시의 예외처리
 *
 */
public class SearchWrongException extends RuntimeException{
	private static final long serialVersionUID=1L;
	public SearchWrongException(){};
	public SearchWrongException(String message){
		super(message);
	};
}
