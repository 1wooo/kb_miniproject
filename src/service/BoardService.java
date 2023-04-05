package service;

import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;

public interface BoardService {
	/**
	 * 모든 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectAll() throws SearchWrongException;
	
	/**
	 * 특정 게시판의 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectBySubject(String subject) throws SearchWrongException;

	/**
	 * 제목 + 내용에 특정 문자열을 포함한 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectByKeyword(String keyWord) throws SearchWrongException;

	/**
	 * 게시물 등록
	 */
	void boardInsert(BoardDTO boardDTO) throws DMLException;

	/**
	 * 게시물 수정
	 */
	void boardUpdate(BoardDTO boardDTO) throws DMLException;

	/**
	 * 게시물 삭제
	 */
	void boardDelete(int boardNo) throws DMLException;

	/**
	 * 댓글등록하기
	 */
	void replyInsert(ReplyDTO replyDTO) throws DMLException;

	/**
	 * 부모글에 해당하는 댓글 리스트 가져오기
	 */
	List<ReplyDTO> replySelectByParentNo(int boardNo) throws SearchWrongException;
}
