package view;

import java.util.Scanner;

import controller.BoardController;
import controller.ReplyController;
import dto.boarddto.BoardDTO;
import dto.userdto.UserSession;
import exception.DMLException;
import dto.replydto.QuestionReply;
import dto.replydto.ReplyDTO;

public class MainView {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 메뉴 선택 (동작 선택)
	 */
	public static void menuChoice() {
		
		while (true) {
			int selectionIndex = 1;
			System.out.println("\n----------------------------------------");
			System.out.print("[ " + selectionIndex++ + ". 게시판 조회   ");
			System.out.print(selectionIndex++ + ". 게시글 작성   ");
			System.out.print(selectionIndex++ + ". 게시글 검색   ");
			System.out.print(selectionIndex++ + ". 내 게시글 조회   ");
			System.out.print(selectionIndex++ + ". 마이페이지   \n");
			System.out.print("  " + selectionIndex++ + ". 로그아웃   ");
			System.out.print(selectionIndex++ + ". 오늘의 식단   ");
			System.out.print(selectionIndex++ + ". 댓글정보검색  ");
			if (UserSession.getInstance().isAdmin())
				System.out.print(selectionIndex++ + ". 오늘의 식단 등록하기   ");
			System.out.print(selectionIndex + ". 앱 종료 ]");
			

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
					checkTodayMeal();
					break;
				case 8:
					replyChoice();
					break;
				case 9:
					if (UserSession.getInstance().isAdmin()) {
						insertTodayMeal();
						break;
					}
					System.out.println("게시판 사용을 종료합니다.");
					System.exit(0);
					break;
				case 10:
					if (UserSession.getInstance().isAdmin()) {
						System.out.println("게시판 사용을 종료합니다.");
						System.exit(0);
						break;
					} else
						throw new NumberFormatException();
				default:
					throw new NumberFormatException();
				}

			} catch (NumberFormatException e) {
				System.out.println("원하는 작업을 1 ~ " + selectionIndex + " 사이의 숫자로 입력해주세요.");
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
		System.out.println("게시판은?");
		System.out.print("1. 공지   ");
		System.out.print("2. 자유   ");
		System.out.print("3. 질문   ");
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

		System.out.println("제목은?");
		String title = sc.nextLine();

		System.out.println("내용은?");
		String content = sc.nextLine();

		BoardDTO board = new BoardDTO(title, content, UserSession.getInstance().getNickName(),
				UserSession.getInstance().getUuid(), subject);
		board.setTag(null);
		BoardController.boardInsert(board);
	}

	/**
	 * 게시글 수정
	 */
	public static void updateBoard(BoardDTO boardDTO) {
		System.out.println("수정할 게시글의 제목을 입력해주세요. 입력이 없으면 제목이 유지됩니다.");
		String title = sc.nextLine();
		System.out.println("수정할 게시글의 내용을 입력해주세요. 입력이 없으면 내용이 유지됩니다.");
		String content = sc.nextLine();
		if (!title.isBlank()) boardDTO.setTitle(title); 
		if (!content.isBlank()) boardDTO.setContent(content); 
		BoardController.boardUpdate(boardDTO);
	}

	/**
	 * 게시글 삭제
	 */
	public static void deleteBoard(int boardNo) {
		System.out.println("게시글을 삭제하시겠습니까?");
		System.out.print("1. 삭제   ");
		System.out.println("2. 취소   ");
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				BoardController.boardDelete(boardNo);
				break;
			case 2:
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("원하는 게시판을 1 ~ 2 사이의 숫자로 입력해주세요.");
		}
	}

	/**
	 * 게시글 검색
	 */
	public static void searchBoard() {
		System.out.println("검색 대상을 선택해주세요.");
		System.out.print("1. 제목 + 내용    ");
		System.out.println("2. 작성자");
		String target = "";
		try {
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				target = "title&content";
				break;
			case 2:
				target = "writer";
				break;
			default:
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("원하는 게시판을 1 ~ 2 사이의 숫자로 입력해주세요.");
		}

		System.out.println("검색하려는 키워드를 입력해주세요.");
		String keyword = sc.nextLine();
		BoardController.boardSelectByKeyword(target, keyword);
	}

	/**
	 * 내 게시글 조회
	 */
	public static void checkMyBoard() {
		BoardController.boardSelectByUserId(UserSession.getInstance().getUuid());
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
		UserSession.getInstance().clear();
	}
	
	/**
	 * @author 서지수
	 * @param 댓글 관련 뷰
	 */
	
	/**
	 * 댓글 메뉴 선택 (동작 선택)
	 */
	public static void replyChoice() {
			int selectionIndex = 1;
			System.out.println("\n----------------------------------------");
			System.out.print("[ " + selectionIndex++ + ". 댓글 조회   ");
			System.out.print(selectionIndex++ + ". 댓글 작성   ");
			System.out.print(selectionIndex++ + ". 댓글 수정   ");
			System.out.print(selectionIndex++ + ". 댓글 삭제  ");

			System.out.println("\n--------------------------------------------");
			System.out.println("원하는 작업을 숫자로 입력해주세요.");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1: //댓글 조회
					searchReply();
					break;
				case 2: //댓글 작성
					insertReply();
					break;
				case 3: //댓글 수정
					updateReply();
					break;
				case 4: //댓글 삭제
					deleteReply();
					break;
				default:
					throw new NumberFormatException();
				}

			} catch (NumberFormatException e) {
				System.out.println("원하는 작업을 1 ~ " + selectionIndex + " 사이의 숫자로 입력해주세요.");
			}
		}


	
	/**
	 * 댓글 조회
	 */
	public static void searchReply() {
		System.out.println("검색하려는 댓글의 부모 글번호 ?");
  	  	int boardNo = Integer.parseInt(sc.nextLine());
		ReplyController.replySelectByBoardNo(boardNo);
	}
	
	/**
	 * 댓글 작성
	 */
	public static void insertReply() {
		System.out.println("작성하려는 댓글의 부모 글번호 ?");
  	  	int boardNo = Integer.parseInt(sc.nextLine());
  	  	
    	 System.out.println("작성자?");
    	 String writer = sc.nextLine();
    	 
    	 System.out.println("내용은?");
    	 String content = sc.nextLine();
    	 
    	 ReplyDTO reply =  new ReplyDTO(0, writer, content, boardNo, null);
    	 BoardController.replyInsert(reply);
	}
	
	/**
	 * 댓글 수정
	 */
	public static void updateReply() {
		System.out.println("수정하려는 댓글의 부모 글번호 ?");
  	  	int boardNo = Integer.parseInt(sc.nextLine());
  	  	
	 	 System.out.println("수정할 댓글 번호는?");
    	 int no = Integer.parseInt(sc.nextLine());
    	 
    	 System.out.println("수정 내용은?");
    	 String content = sc.nextLine();
    	
    	 ReplyDTO reply =  new ReplyDTO(no, null, content, boardNo, null);
    	 ReplyController.replyUpdate(reply);
	}
	
	/**
	 * 댓글 삭제
	 */
	public static void deleteReply() {
		System.out.println("삭제하려는 댓글의 부모 글번호 ?");
  	  	int boardNo = Integer.parseInt(sc.nextLine());
  	  	
	  	 System.out.println("삭제할 댓글 번호는?");
    	 int no = Integer.parseInt(sc.nextLine());
    	 ReplyController.replyDelete(no);
	}
	

}
