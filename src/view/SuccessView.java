package view;

import java.util.List;
import java.util.Scanner;

import controller.BoardController;
import controller.ReplyController;
import dto.boarddto.BoardDTO;
import dto.mealdto.MealDTO;
import dto.userdto.UserSession;
import dto.replydto.ReplyDTO;

public class SuccessView {
	public static String getPreview(BoardDTO board) { // 특정 게시글의 미리보기를 제공
		final StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-4d", board.getBoardNo())).append(" | ");
		sb.append(String.format("%15s", board.getTitle())).append(" | ");
		sb.append(board.getWriter()).append(" | ");
		sb.append(board.getBoardDate());

		return sb.toString();
	}

	/**
	 * @author jaehyun
	 * @param List<BoardDTO> list 열람 가능한 게시글 리스트
	 * @param pageIndex      현재 열람중인 페이지 번호
	 * @description 게시판 페이지 번호에 맞게 최대 10개의 게시글 리스트를 확인
	 */
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
			if (pageIndex > 1)
				sb.append(", 이전 페이지를 보려면 P를");
			if (pageIndex < (list.size() / 10) + 1)
				sb.append(", 다음 페이지를 보려면 N을");
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
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못된 명령어입니다.");
		} finally {

		}
	}

	/**
	 * 단일 게시글 상세 조회
	 */
	public static void boardPrint(BoardDTO board) {
		System.out.println(board); // board.toString();
		Scanner sc = new Scanner(System.in);
		BoardController.updateViewCnt(board.getBoardNo());
		final StringBuilder sb = new StringBuilder();
		boolean isAdmin = UserSession.getInstance().isAdmin();
		boolean isMyBoard = UserSession.getInstance().getUuid() == board.getUuid();
		sb.append("----------------------------\n");
		sb.append("추가로 선택할 작업을 선택해주세요.\n");
		sb.append("1. 메인 화면으로   ");
		sb.append("2. 댓글 조회하기   ");
		sb.append("3. 좋아요!   ");
		if (isMyBoard || isAdmin)
			sb.append("4. 글 삭제하기   ");
		if (isMyBoard)
			sb.append("5. 글 수정하기   ");
		sb.append("\n----------------------------\n");
		System.out.println(sb.toString());
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				return;
			case 2:
				ReplyController.replySelectByBoardNo(board.getBoardNo());
				break;
			case 3:
				if (board.getUuid() == UserSession.getInstance().getUuid())
					System.out.println("내 글은 좋아요를 누를 수 없습니다.");
				else
					BoardController.updateLikeCnt(board.getBoardNo());
				break;
			case 4:
				if (!isMyBoard && !isAdmin) {
					throw new NumberFormatException();
				}
				MainView.deleteBoard(board.getBoardNo());
				break;
			case 5:
				if (!isMyBoard)
					throw new NumberFormatException();
				MainView.updateBoard(board);
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못된 명령어입니다.");
		}
	}

	/**
	 * 단순 성공 메시지
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	/**
	 * @author 서지수, 임재현
	 * @param 댓글 조회, 생성, 수정, 삭제 성공 뷰
	 */

	public static void searchReplyPrint(List<ReplyDTO> replyList, int boardNo) {
		for (ReplyDTO reply : replyList) {
			System.out.println(" ⁕⁕⁕ " + reply);
		}
		Scanner sc = new Scanner(System.in);

		boolean isAdmin = UserSession.getInstance().isAdmin();
		boolean isMyBoard = true; // 부모 보드의 uuid 가져올 방법 필요
//		boolean isMyBoard = UserSession.getInstance().getUuid() == boardNo;
		final StringBuilder sb = new StringBuilder();
		sb.append("----------------------------\n");
		sb.append("추가로 선택할 작업을 선택해주세요.\n");
		sb.append("1. 댓글 달기   ");
		sb.append("2. 댓글 수정하기   ");
		sb.append("3. 댓글 삭제하기   ");
		sb.append("\n----------------------------\n");
		System.out.println(sb.toString());
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MainView.insertReply(boardNo);
				return;
			case 2:
				MainView.updateReply(boardNo);
				break;
			case 3:
				if (!isMyBoard && !isAdmin)
					throw new NumberFormatException();
				MainView.deleteReply(boardNo);
				break;
			}
		} catch (NumberFormatException e) {
			System.out.println("잘못된 명령어입니다.");
		}

	}

	/**
	 * 오늘의 메뉴 출력
	 */
	public static void mealPrint(MealDTO mealDTO) {
		final StringBuilder sb = new StringBuilder();
		sb.append(mealDTO.getDate()).append(" 오늘의 메뉴\n");
		sb.append(mealDTO.getMeal());
		System.out.println(sb.toString());

	}

}
