package service;

import java.util.List;

import dto.boarddto.BoardDTO;
import dto.mealdto.MealDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;

public interface BoardService {
	/**
	 * 모든 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectAll() throws SearchWrongException;

	List<BoardDTO> boardSelectRankByLikeCnt() throws SearchWrongException;

	List<BoardDTO> boardSelectRankByViewCnt() throws SearchWrongException;
	/** 
	 * 특정 uuid인 유저의 게시글 레코드 검색
	 * */
	List<BoardDTO> boardSelectByUserId(int uuid) throws SearchWrongException;

	/**
	 * 특정 게시판의 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectBySubject(String subject) throws SearchWrongException;

	/**
	 * 제목 + 내용에 특정 문자열을 포함한 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectByKeyword(String target, String keyWord) throws SearchWrongException;

	/**
	 * 좋아요 순으로 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectByLike() throws SearchWrongException;

	/**
	 * 조회수 순으로 게시글 레코드 검색
	 */
	List<BoardDTO> boardSelectByView() throws SearchWrongException;

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
	 * 댓글 작성
	 */
	void insertReply(ReplyDTO replyDTO) throws DMLException;

	/**
	 * 좋아요 반영
	 */
	void updateLikeCnt(int boardNo) throws DMLException;

	/**
	 * 조회수 증가
	 */
	void updateViewCnt(int boardNo) throws DMLException;

	/**
	 * 내가 받은 좋아요 수 가져오기
	 * @return 좋아요 수
	 * @throws DMLException
	 */
	int selectMyLikeCnt(int uuid) throws DMLException;

	/**
	 * 내가 쓴 글 개수
	 */
	int selectMyContentCnt(int uuid) throws DMLException;

	/**
	 * 내가 쓴 댓글 개수
	 */
	int selectMyReplyCnt(int uuid) throws DMLException;

	/**
	 * 오늘의 식사 가져오기
	 */
	MealDTO selectTodayMeal() throws DMLException;

	/**
	 * 식사 등록
	 * @param mealDTO
	 * @throws DMLException
	 */
	void insertTodayMeal(MealDTO mealDTO) throws DMLException;

	/**
	 * 부모글에 해당하는 댓글 리스트 가져오기
	 */
	List<ReplyDTO> replySelectByParentNo(int boardNo) throws SearchWrongException;
}
