package view;

import java.util.List;
import java.util.Scanner;

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

	/**
	 * @author jaehyun
	 * @param List<BoardDTO> list 열람 가능한 게시글 리스트
	 * @param pageIndex 현재 열람중인 페이지 번호
	 * 게시판 페이지 번호에 맞게 최대 10개의 게시글 리스트를 확인
	 * */
	public static void boardListPrint(List<BoardDTO> list, int pageIndex) { 	
		System.out.println("---- 총 (" + list.size() + ") 개의 게시글이 있습니다. ----");
		System.out.println("---- 현재 " + pageIndex + " 페이지 조회 중입니다. ----");
		Scanner sc = new Scanner(System.in); 
		for (int i = (pageIndex - 1) * 10; i < pageIndex * 10 && i < list.size(); i++) {
			System.out.println(getPreview(list.get(i)));
		}
		try { // 페이지 넘기기 혹은 원하는 게시글 선택
			final StringBuilder sb = new StringBuilder();
			sb.append("----------------------------\n");
			sb.append("게시글을 읽으려면 원하는 게시글의 번호를");
			if (pageIndex > 1) sb.append(", 이전 페이지를 보려면 P를");
			if (pageIndex < (list.size() / 10) + 1) sb.append(", 다음 페이지를 보려면 N을");
			sb.append(" 입력해 주세요.");
			System.out.println(sb.toString());
			String selection = sc.nextLine();
			
			if (pageIndex > 1 && selection.equals("P")) { // 이전 페이지
				boardListPrint(list, pageIndex - 1);
			} else if (pageIndex < (list.size() / 10) + 1 && selection.equals("N")) { // 다음 페이지
				boardListPrint(list, pageIndex + 1);
			} else {
				int bno = Integer.parseInt(selection);
				for (int i = (pageIndex - 1) * 10; i < pageIndex * 10 && i < list.size(); i++) {
					if (list.get(i).getBoardNo() == bno) {
						boardPrint(list.get(i));
						return;
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못된 명령어입니다. 다시 시도하시겠습니까?");
		} finally {
		}
	}

	/** 
	 * 단일 게시글 상세 조회
	 * */
	public static void boardPrint(BoardDTO board) { 
		System.out.println(board); // board.toString();
		final StringBuilder sb = new StringBuilder();
		sb.append("----------------------------\n");
		
		
		// TODO: check user session
		// if (board.getUuid() != session.uuid || !session.isAdmin) return;
		sb.append("\n----------------------------\n");
		
	}
	
	/**
	 * 단순 성공 메시지 
	 * */
	public static void messagePrint(String message) {
		System.out.println(message);	
	}

}
