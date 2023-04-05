package service;

import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String subject) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectByKeyword(String keyWord) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(int boardNo) throws DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReplyDTO> replySelectByParentNo(int boardNo) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
