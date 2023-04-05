package view;

import java.util.Scanner;

import controller.BoardController;
import dto.boarddto.BoardDTO;
import dto.userdto.UserSesseion;

public class MainView {
	static Scanner sc = new Scanner(System.in);
	static UserSesseion userSesseion;

	/**
	 * 메뉴 선택 (동작 선택)
	 */
	public static void menuChoice(UserSesseion sesseion) {
		userSesseion = sesseion;

		System.out.println("메인뷰 단 세션 : " + sesseion);
		while (true) {
			int selectionIndex = 1;
			System.out.println("\n----------------------------------------");
			System.out.print("[ " + selectionIndex++ + ". 게시판 조회   ");
			System.out.print(selectionIndex++ + ". 게시글 작성   ");
			System.out.print(selectionIndex++ + ". 게시글 검색   ");
			System.out.print(selectionIndex++ + ". 내 게시글 조회   ");
			System.out.print(selectionIndex++ + ". 마이페이지   ");
			System.out.print(selectionIndex++ + ". 로그아웃   ");
			System.out.print(selectionIndex++ + ". 오늘의 식단   ");
			if (userSesseion.isAdmin()) System.out.print(selectionIndex++ + ". 오늘의 식단 등록하기   ");
			System.out.print(selectionIndex++ + ". 앱 종료 ]");

			System.out.println("\n--------------------------------------------");
			System.out.println("원하는 작업을 숫자로 입력해주세요.");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					selectBoard();
					break;
				case 2:
					insertBoard();
					break;
				case 3:
					searchBoard();
					break;
				case 4:
					checkMyBoard();
					break;
				case 5:
					checkMyPage();
					break;
				case 6:
					logOut();
					return;
				case 7:
					System.out.println("게시판 사용을 종료합니다.");
					System.exit(0);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("원하는 작업을 1 ~ 7 사이의 숫자로 입력해주세요.");
			}
		}

	}

	/**
	 * 게시판 조회 선택
	 */
	public static void selectBoard() {
		System.out.println("원하는 게시판은?");
		System.out.println("1. 공지   ");
		System.out.println("2. 자유   ");
		System.out.println("3. 질문   ");
		System.out.println("\n--------------------------------------------");
		System.out.println("원하는 게시판을 숫자로 입력해주세요.");
		String subject = "";
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				subject = "notice";
				break;
			case 2:
				subject = "free";
				break;
			case 3:
				subject = "question";
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("원하는 게시판을 1 ~ 3 사이의 숫자로 입력해주세요.");
		}
		BoardController.boardSelectBySubject(subject);
	}

	/**
	 * 게시글 작성
	 */
	public static void insertBoard() {
		System.out.println("제목은?");
		String title = sc.nextLine();

		System.out.println("게시판은?");
		System.out.print("1. 공지");
		System.out.print("2. 자유");
		System.out.print("3. 질문");
		String subject = "";
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				subject = "notice";
				break;
			case 2:
				subject = "free";
				break;
			case 3:
				subject = "question";
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("원하는 게시판을 1 ~ 3 사이의 숫자로 입력해주세요.");
		}

		System.out.println("내용은?");
		String content = sc.nextLine();

		BoardDTO board = new BoardDTO(title, content, userSesseion.getNickName(), userSesseion.getUuid(), subject);
		board.setTag(null);
		BoardController.boardInsert(board);
	}

	/**
	 * 게시글 수정
	 */
	public static void updateBoard() {

	}

	/**
	 * 게시글 검색
	 */
	public static void searchBoard() {
		System.out.println("검색하려는 키워드를 입력해주세요.");
		String keyword = sc.nextLine();
		BoardController.boardSelectByKeyword(keyword);
	}

	/**
	 * 내 게시글 조회
	 */
	public static void checkMyBoard() {

	}

	/**
	 * 마이페이지
	 */
	public static void checkMyPage() {

	}

	/**
	 * 식단출력
	 */
	public static void checkTodayMeal() {

	}
	
	/**
	 * 어드민 전용 식단 등록
	 */
	public static void insertTodayMeal() {

	}


	/**
	 * 로그아웃
	 */
	public static void logOut() {

	}
}
