/**
 * 작성자 : 서지수
 * 게시판 메소드 정의
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.boarddto.BoardDTO;
import dto.replydto.ReplyDTO;
import exception.DMLException;
import exception.SearchWrongException;
import common.DBManager;
import dao.BoardDAO;

public class BoardDAOImpl implements BoardDAO {

	private static BoardDAO instance = new BoardDAOImpl();
	/**
	 * 외부에서 객체생성 막음.
	 * */
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	/**
	 * 게시판 전체 조회
	 */
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from boarddto order by board_no desc";
		try {
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt("board_no"), rs.getString("title"),rs.getString("content"),rs.getString("writer"), 
						rs.getInt("uuid"),rs.getString("subject"), rs.getString("tag"),rs.getInt("like_cnt"),rs.getInt("view_cnt"),
						rs.getString("board_date"));
				
				list.add(dto);
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new SearchWrongException("전체 조회에 실패했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	
	@Override
	public BoardDTO boardSelectByUserId(int userId) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		BoardDTO boardDTO=null;
		String sql= "select * from boarddto where uuid = ? ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				boardDTO = new BoardDTO(
						rs.getInt("board_no"), rs.getString("title"),rs.getString("content"),rs.getString("writer"), 
						rs.getInt("uuid"),rs.getString("subject"), rs.getString("tag"),rs.getInt("like_cnt"),rs.getInt("view_cnt"),
						rs.getString("board_date"));
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new SearchWrongException("내가 쓴 게시글을 검색하는데 문제가 발생했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return boardDTO;
	}

	/**
	 * 게시판별 조회
	 */
	@Override
	public List<BoardDTO> boardSelectBySubject(String subject) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoardDTO> list = new ArrayList<BoardDTO>(); //리턴값
		String sql= "select * from boarddto where subject=?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, subject); // 
			
			rs = ps.executeQuery();
			while(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				BoardDTO dto = new BoardDTO(
						rs.getInt("board_no"), rs.getString("title"),rs.getString("content"),rs.getString("writer"), 
						rs.getInt("uuid"),rs.getString("subject"), rs.getString("tag"),rs.getInt("like_cnt"),rs.getInt("view_cnt"),
						rs.getString("board_date"));
							
				//BoardDTO를 list에 추가한다.
				list.add(dto);
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new SearchWrongException(subject+"게시판 전체 조회에 실패했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
		
	}

	/**
	 * 게시판 키워드 검색
	 */
	@Override
	public List<BoardDTO> boardSelectByKeyword(String keyWord) throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoardDTO> list = new ArrayList<BoardDTO>(); //리턴값
		String sql= "select * from boarddto where upper(subject) like upper(?)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%"); // 
			
			rs = ps.executeQuery();
			while(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				BoardDTO dto = new BoardDTO(
						rs.getInt("board_no"), rs.getString("title"),rs.getString("content"),rs.getString("writer"), 
						rs.getInt("uuid"),rs.getString("subject"), rs.getString("tag"),rs.getInt("like_cnt"),rs.getInt("view_cnt"),
						rs.getString("board_date"));
							
				//BoardDTO를 list에 추가한다.
				list.add(dto);
			}
			
		}catch (SQLException e) {
		//	e.printStackTrace();
			throw new SearchWrongException(keyWord+"를 포함하는 게시판 조회에 실패했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		return list;
		
	}

	@Override
	public List<BoardDTO> boardSelectByLike() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from boarddto order by like_cnt asc";
		try {
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt("board_no"), rs.getString("title"),rs.getString("content"),rs.getString("writer"), 
						rs.getInt("uuid"),rs.getString("subject"), rs.getString("tag"),rs.getInt("like_cnt"),rs.getInt("view_cnt"),
						rs.getString("board_date"));
				
				list.add(dto);
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new SearchWrongException("좋아요수 순서 조회에 실패했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectByView() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from boarddto order by view_cnt asc";
		try {
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt("board_no"), rs.getString("title"),rs.getString("content"),rs.getString("writer"), 
						rs.getInt("uuid"),rs.getString("subject"), rs.getString("tag"),rs.getInt("like_cnt"),rs.getInt("view_cnt"),
						rs.getString("board_date"));
				
				list.add(dto);
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new SearchWrongException("조회수 순서 조회에 실패했습니다.");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="insert into boarddto (board_no, title, content, writer, uuid, subject, tag, like_cnt, view_cnt, board_date) \r\n"
				+ "	values (board_seq.nextval, ?, ?, ?,?,?,?,0,0, sysdate)";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setString(1, boardDTO.getTitle());
			ps.setString(2, boardDTO.getContent());
			ps.setString(3, boardDTO.getWriter());
			ps.setInt(4, boardDTO.getUuid());
			ps.setString(5, boardDTO.getSubject());
			ps.setString(6, boardDTO.getTag());

			result = ps.executeUpdate();
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new DMLException("등록하는데 오류가 발생하여 등록되지 않았습니다."); 
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="update boarddto set content = ? where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			result = ps.executeUpdate();
			
		}catch (Exception e) {
			//e.printStackTrace();
			throw new DMLException("수정하는데 오류가 발생하여 수정되지 않았습니다.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String sql="delete from boarddto where board_no = ?";
		try {
			con = DBManager.getConnection();
			ps= con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxx설정 필요.
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();
			
		}catch (SQLException e) {
			//e.printStackTrace();
			throw new DMLException("댓글을 삭제 한 후 삭제해주세요.");
		}finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyDTO> replySelectByParentNo(int boardNo) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}

}
