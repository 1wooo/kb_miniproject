package dao;

import java.util.List;

import dto.boarddto.BoardDTO;
import exception.SearchWrongException;

/**
 * 작성자 : 서지수
 * 게시판 boardDAO
 * @param tag
 */
public interface BoradDAO {
	/**
	 * 레코드 전체 검색
	 * select * from boarddto;
	 */
	List<BoardDTO> boardSelectAll() throws SearchWrongException;
	
	/**
	 * 레코드 유저 아이디별 검색
	 * select * from boarddto where userId=?;
	 */
	List<BoardDTO> boardSelectByUserId(int userId) throws SearchWrongException;
	
	/**
	 * 레코드 좋아요수 순서대로 검색
	 */
	List<BoardDTO> boardSelectByLike() throws SearchWrongException;
	
	/**
	 * 레코드 조회수 순서대로 검색
	 */
	List<BoardDTO> boardSelectByView() throws SearchWrongException;
}
