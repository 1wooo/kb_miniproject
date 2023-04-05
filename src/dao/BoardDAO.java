package dao;

import java.util.List;

import dto.boarddto.BoardDTO;
import exception.*;

/**
 * 작성자 : 서지수
 * 게시판 boardDAO
 * @param tag
 */
public interface BoardDAO {
	/**
	 * 레코드 전체 검색
	 * select * from boarddto;
	 */
	List<BoardDTO> boardSelectAll() throws SearchWrongException;
	
	/**
	 * 레코드 유저 아이디별 검색
	 * select * from boarddto where userId=?;
	 */
	BoardDTO boardSelectByUserId(int userId) throws SearchWrongException;
	
	/**
	 * 레코드 좋아요수 순서대로 검색
	 */
	List<BoardDTO> boardSelectByLike() throws SearchWrongException;
	
	/**
	 * 레코드 조회수 순서대로 검색
	 */
	List<BoardDTO> boardSelectByView() throws SearchWrongException;
	
	/**
	 * 게시물 등록하기
	 * insert into boarddto (board_no, title, content, writer, uuid, subject, tag, like_cnt, view_cnt, board_date, is_solved,selected_reply) 
	 * values (board_seq.nextval, ?, ?, ?,?,?,?,?,?, sysdate,?,?)
	 */
	int boardInsert(BoardDTO boardDTO) throws DMLException;
	
	/**
	 * 글번호에 해당하는 게시물 내용 수정하기
	 * update boarddto set content = ? where board_no = ?
	 */
	int boardUpdate(BoardDTO boardDTO) throws DMLException;
	
	/**
	 * 글번호에 해당하는 레코드 삭제
	 * delete from boarddto where board_no = ?
	 */
	int boardDelete(int boardNo) throws DMLException;
	
}
