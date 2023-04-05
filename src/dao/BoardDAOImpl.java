/**
 * 작성자 : 서지수
 * Board DAO 메소드
 */
package dao;

import java.util.List;

import dto.boarddto.BoardDTO;
import exception.DMLException;
import exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO boardSelectByUserId(int userId) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectByLike() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectByView() throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
