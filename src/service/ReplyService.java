package service;

import java.util.List;

import dto.replydto.QuestionReply;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
/**
 * @author 서지수
 * @param 댓글서비스
 */
public interface ReplyService {
	/**
	 * 댓글 게시글별검색
	 * select * from reply where board_no=?;
	 */
	List<ReplyDTO> replySelectByBoardNo(int boardNo) throws SearchWrongException;
	
	/**
	 * 댓글번호에 해당하는 댓글 내용 수정하기
	 * update reply set content = ? where reply_no = ?
	 */
	void replyUpdate(ReplyDTO replyDTO) throws DMLException;

	/**
	 * 댓글번호에 해당하는 댓글 삭제
	 * delete from reply where reply_no = ?
	 */
	void replyDelete(int replyNo) throws DMLException;

	/**
	 * 댓글 채택하기
	 * update reply set selected_reply = ? where reply_no = ?
	 */
	void replySelect(QuestionReply quetionReplyDTO) throws DMLException;
}
