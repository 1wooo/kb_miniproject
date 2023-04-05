package view;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("------ 프로그램 시작 ------");
		while (true) {
			LoginView.loginChoice();
			MainView.menuChoice();
		}
	}
}
