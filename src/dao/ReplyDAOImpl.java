package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.QuestionReply;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
import common.DBManager;

/**
 * @author 서지수
 * @param 댓글daoimpl
 */
public class ReplyDAOImpl implements ReplyDAO {

	private static ReplyDAO instance = new ReplyDAOImpl();

	/**
	 * 외부에서 객체생성 막음.
	 */
	private ReplyDAOImpl() {
	}

	public static ReplyDAO getInstance() {
		return instance;
	}

	/**
	 * 댓글 게시글별검색 select * from reply where board_no=?;
	 */
	@Override
	public List<ReplyDTO> replySelectByBoardNo(int boardNo) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ReplyDTO> list = new ArrayList<ReplyDTO>(); // 리턴값
		String sql = "select * from reply where board_no=?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo); //

			rs = ps.executeQuery();
			while (rs.next()) {
				// 열의 정보를 가져와서 BoardDTO에 담는다.
				ReplyDTO dto = new ReplyDTO(rs.getInt("reply_no"), rs.getString("reply_writer"),
						rs.getString("reply_content"), rs.getInt("board_no"), rs.getString("reply_date"));

				// BoardDTO를 list에 추가한다.
				list.add(dto);
			}

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new SearchWrongException(boardNo + "번 게시판 댓글 조회에 실패했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}

		return list;
	}

	/**
	 * 댓글 수정 update reply set content = ? where reply_no = ?
	 */
	@Override
	public int replyUpdate(ReplyDTO replyDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update reply set reply_content = ? where reply_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			// ?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getReplyNo());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DMLException("댓글을 수정하는데 오류가 발생하여 수정되지 않았습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	/**
	 * 댓글 삭제
	 */
	@Override
	public int replyDelete(int replyNo) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from reply where reply_no = ?";
		try {
			System.out.println("들어옴");
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			// ?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setInt(1, replyNo);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("들어감" + result);
			throw new DMLException("댓글 삭제에 실패했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	/**
	 * 댓글 채택하기
	 */
	@Override
	public int replySelect(QuestionReply quetionReplyDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update reply set selected_reply = ? where reply_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			// ?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setInt(1, quetionReplyDTO.getSelectedReply());
			ps.setInt(2, quetionReplyDTO.getReplyNo());

			result = ps.executeUpdate();

		} catch (Exception e) {
			// e.printStackTrace();
			throw new DMLException("댓글 채택에 실패했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

}
