package view;

import java.util.List;

import dto.boarddto.BoardDTO;

public class SuccessView {
	public static String getPreview(BoardDTO board) { // 특정 게시글의 미리보기를 제공
		final StringBuilder sb = new StringBuilder();
		sb.append(board.getBoardNo()).append(" | ");
		sb.append(board.getTitle()).append(" | ");
		sb.append(board.getWriter()).append(" | ");
		sb.append(board.getBoardDate());

		return sb.toString();
	}

	public static void boardListPrint(List<BoardDTO> list, int pageIndex) { // 게시판 페이지 번호에 맞게 최대 10개의 게시글 리스트를 확인
		System.out.println("---- 총 (" + list.size() + ") 개의 게시글이 있습니다. ----");
		System.out.println("---- 현재 " + pageIndex + " 페이지 조회 중입니다. ----");
		for (int i = (pageIndex - 1) * 10; i < pageIndex * 10 && i < list.size(); i++) {
			System.out.println(getPreview(list.get(i)));
		}
	}

	public static void boardPrint(BoardDTO board) { // 단일 게시글 상세 조회
		System.out.println(board); // board.toString();
	}

}
