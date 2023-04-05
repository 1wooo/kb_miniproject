package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
import kb.mvc.common.DBManager;

public class ReplyDAOImpl implements ReplyDAO {

	private static ReplyDAO instance = new ReplyDAOImpl();
	/**
	 * 외부에서 객체생성 막음.
	 * */
	private ReplyDAOImpl() {}
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	/**
	 * 게시글별 댓글 조회
	 * select * from board join reply using(board_no)  where board_no=?
	 */
	@Override
	public List<ReplyDTO> replySelectByBoardNo(int boardNo) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}
	private List<ReplyDTO> replySelect(Connection con, int boardNo)throws SearchWrongException{
		 PreparedStatement ps =null;
		 ResultSet rs =null;
		 List<ReplyDTO> repliesList = new ArrayList<>();
		 String sql="select * from reply where board_no=?";
		try {
		    ps = con.prepareStatement(sql);
		    ps.setInt(1, boardNo);
		    
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	ReplyDTO reply = 
		    		new ReplyDTO(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4));
		    	repliesList.add(reply);
		    }
		
		}finally {
			DBManager.releaseConnection(null, ps, rs);
		}
		return repliesList;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replyUpdate(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replyDelete(int replyNo) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int replySelect(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
