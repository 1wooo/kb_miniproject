package view;

import dto.userdto.UserSession;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("------ 프로그램 시작 ------");
		while (true) {
			UserSession userSession = LoginView.loginChoice();
			MainView.menuChoice(userSession);
		}
	}
}
