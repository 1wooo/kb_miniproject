package service;

import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;

public class BoardServiceImpl implements BoardService {
	// singleton
	private static BoardService instance = new BoardServiceImpl();
//	pritate static BoardDAO boardDAO = BoardDAOImpl.getInstance();
	
	private BoardServiceImpl() {}
	public static BoardService getInstance() {
		return instance;
	}
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		// List<BoardDTO> boardList = boardDAO.boardSelectAll();
		// if (boardList.size() == 0) throw new SearchWrongException("아직 게시글이 없습니다...");
		// return boardList;
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String subject) throws SearchWrongException {
		// List<BoardDTO> boardList = boardDAO.boardSelectBySubject();
		// if (boardList.size() == 0) throw new SearchWrongException("아직 게시글이 없습니다...");
		// return boardList;
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectByKeyword(String keyWord) throws SearchWrongException {
		// List<BoardDTO> boardList = boardDAO.boardSelectByKeyword();
		// if (boardList.size() == 0) throw new SearchWrongException("검색어에 해당하는 게시글이 없습니다...");
		// return boardList;
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
