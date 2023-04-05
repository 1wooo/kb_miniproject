package view;

import dto.userdto.UserSesseion;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("------ 프로그램 시작 ------");
		while (true) {
			UserSesseion userSesseion = LoginView.loginChoice();
			MainView.menuChoice(userSesseion);
		}
	}
}
