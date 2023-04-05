package view;

import java.util.Scanner;

import controller.LoginController;

public class LoginView {
	static Scanner sc = new Scanner(System.in);

	public static void loginChoice() {
		while (true) {
			System.out.println("\n----------------------------------------");
			System.out.print("[ 1. 로그인   ");
			System.out.print("2. 회원가입   ");
			System.out.print("3. 종료 ]");

			System.out.println("\n--------------------------------------------");
			System.out.println("원하는 서비스를 선택해주세요.");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					signIn();
					return;
				case 2:
					signUp();
					break;
				case 3:
					System.out.println("앱을 종료합니다.");
					System.exit(0);
					break;
				default:
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("원하는 서비스를 1 ~ 3 사이의 숫자로 입력해주세요.");
			}
		}
	}
	
	/** 
	 * 로그인
	 * */
	public static void signIn() {
		try {
			System.out.println("---- 로그인 ----");
			System.out.println("로그인할 계정의 ID를 입력해주세요.");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요.");
			String pw = sc.nextLine();

			LoginController.signIn(id, pw);
		
		} catch (Exception e) {
			System.out.println("다시 시도하시겠습니까? yes / no");
			String choice = sc.nextLine();
			if (choice.toUpperCase().equals("YES")) {
				signIn();
			}
			if (choice.toUpperCase().equals("NO")) {
				System.out.println("앱을 종료합니다.");
				System.exit(0);
			}
		} 
	}
	
	/** 
	 * 회원가입
	 * */
	public static void signUp() {
		try {
			System.out.println("---- 회원가입 ----");
			System.out.println("사용할 계정의 ID를 입력해주세요.");
			String id = sc.nextLine();
			System.out.println("비밀번호를 입력해주세요.");
			String pw = sc.nextLine();

//			LoginController.signIn(id, pw);
			// test code
			throw new Exception();
		} catch (Exception e) {
			System.out.println("다시 시도하시겠습니까? yes / no");
			String choice = sc.nextLine();
			if (choice.toUpperCase().equals("YES")) {
				signUp();
			}
			if (choice.toUpperCase().equals("NO")) {
				System.out.println("로그인 화면으로 돌아갑니다.");
			}
		} 
	}
}
