package controller;

import java.util.List;

import dto.replydto.QuestionReply;
import dto.replydto.ReplyDTO;
import exception.SearchWrongException;
import exception.DMLException;
import view.FailView;
import view.SuccessView;
import service.ReplyService;
import service.ReplyServiceImpl;

/**
 * @author 서지수
 * @param 댓글 컨트롤러.댓글 메소드별 성공/실패 보여주기
 */
public class ReplyController {

	private static ReplyService replyService = ReplyServiceImpl.getInstance();
	/**
	 * 댓글 게시글별검색
	 * select * from reply where board_no=?;
	 */
	public static void replySelectByBoardNo(int boardNo) {
		try {
			List<ReplyDTO> replyList = replyService.replySelectByBoardNo(boardNo);
			// TODO: need Reply view
			SuccessView.searchReplyPrint(replyList);
		  
		}catch (SearchWrongException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 댓글번호에 해당하는 댓글 내용 수정하기
	 * update reply set content = ? where reply_no = ?
	 */
	public static void replyUpdate(ReplyDTO replyNo) {
		try {
			replyService.replyUpdate(replyNo);
		  SuccessView.messagePrint("댓글을 수정하였습니다.");
		}catch (DMLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 댓글번호에 해당하는 댓글 삭제
	 * delete from reply where reply_no = ?
	 */
	public static void replyDelete(int replyNo) {
		try {
			replyService.replyDelete(replyNo);
			SuccessView.messagePrint("댓글이 삭제되었습니다.");
		}catch (DMLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 댓글 채택하기
	 * update reply set selected_reply = ? where reply_no = ?
	 */
	public static void replySelect(QuestionReply quetionReplyDTO) {
		try {
			replyService.replySelect(quetionReplyDTO);
		    SuccessView.messagePrint("댓글을 채택하였습니다.");
		}catch (DMLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}
}
