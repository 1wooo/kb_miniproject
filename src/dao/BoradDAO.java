package dao;
/**
 * 작성자 : 서지수
 * 게시판 boardDAO
 * @param tag
 */
public interface BoradDAO {
	+ boardSelectAlll() : List<Board>
	+ boardSelectByTag(String tag):
	List<BoardDTO>
}
