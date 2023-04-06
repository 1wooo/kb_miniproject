package service;

import java.util.List;

import dao.ReplyDAO;
import dao.ReplyDAOImpl;
import dto.replydto.QuestionReply;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
/**
 * @author 서지수
 * @param 댓글서비스impl
 */
public class ReplyServiceImpl implements ReplyService {
	private static ReplyService instance = new ReplyServiceImpl();

	private ReplyDAO replyDAO = ReplyDAOImpl.getInstance();

	private ReplyServiceImpl() {
	}

	public static ReplyService getInstance() {
		return instance;
	}

	@Override
	public List<ReplyDTO> replySelectByBoardNo(int boardNo) throws SearchWrongException {
		List<ReplyDTO> list = replyDAO.replySelectByBoardNo(boardNo);
//		if (list.isEmpty())
//			throw new SearchWrongException(boardNo + "번 게시글의 댓글이 아직 없습니다...");
		return list;
	}

	@Override
	public void replyUpdate(ReplyDTO replyDTO) throws DMLException {
		int result = replyDAO.replyUpdate(replyDTO);
		if (result == 0)
			throw new DMLException("댓글 수정에 실패했습니다.");

	}

	@Override
	public void replyDelete(int replyNo) throws DMLException {
		int result = replyDAO.replyDelete(replyNo);
		if (result == 0)
			throw new DMLException("댓글 삭제에 실패했습니다.");
	}

	@Override
	public void replySelect(QuestionReply quetionReplyDTO) throws DMLException {
		int result = replyDAO.replySelect(quetionReplyDTO);
		if (result == 0)
			throw new DMLException("댓글 채택에 실패했습니다.");
	}

}
