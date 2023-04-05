/**
 * 작성자 : 임재현, 서지수
 */
package service;

import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
import dao.BoardDAO;
import dao.BoardDAOImpl;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardServiceImpl implements BoardService {
	private static BoardService instance = new BoardServiceImpl();
	
	private BoardDAO boardDAO = BoardDAOImpl.getInstance();

	
	private BoardServiceImpl() {}
	public static BoardService getInstance() {
		return instance;
	}
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		List<BoardDTO> boardList = boardDAO.boardSelectAll();
		if(boardList.size()==0)
			throw new SearchWrongException("아직 게시글이 없습니다...");
		
		return boardList;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String subject) throws SearchWrongException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(subject);
		if(list.isEmpty()) throw new SearchWrongException(subject+"게시판의 게시글이 아직 없습니다...");
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectByKeyword(String keyWord) throws SearchWrongException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		if(list.isEmpty()) throw new SearchWrongException(keyWord+"단어를 포함한 정보가 없습니다.");
		return list;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws DMLException {
		int result = boardDAO.boardInsert(boardDTO);
		if(result==0)throw new DMLException("게시글 등록에 실패했습니다.");
		
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws DMLException {
		int result = boardDAO.boardUpdate(boardDTO);
		if(result==0)throw new DMLException("게시글 수정에 실패했습니다.");
		
	}

	@Override
	public void boardDelete(int boardNo) throws DMLException {
		int result = boardDAO.boardDelete(boardNo);
		if(result==0)throw new DMLException("게시글 삭제에 실패했습니다.");
		
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
