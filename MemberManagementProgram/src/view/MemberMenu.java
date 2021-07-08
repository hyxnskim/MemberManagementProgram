package view;

import java.util.Scanner;

import model.service.MemberService;

/**
 * <pre>
 * 회원 관리 프로그램 메뉴 구성
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	public MemberService service = new MemberService();
	
	public void mainMenu() {
		
		while(true) {
	
			System.out.println("************************");
			System.out.println("\t회원관리시스템 메인메뉴");
			System.out.println("************************");
			
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디찾기");
			System.out.println("4. 비밀번호찾기");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴번호 입력 : ");
			int menuNo = sc.nextInt();
			
			switch(menuNo) {
			case 1:
				System.out.println("1. 로그인");
				break;
			case 2:
				System.out.println("2. 회원가입");
				break;
			case 3:
				System.out.println("3. 아이디찾기");
				break;
			case 4:
				System.out.println("4. 비밀번호찾기");
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				System.exit(0);
			default:
				System.out.println("[오류] 0~4 사이의 숫자를 입력해주십시오");
			}
		}
	}
	
	/**
	 * 제목 출력
	 * @param title 제목
	 */
	public void printTitle(String title) {
		System.out.println();
		System.out.println("-------------------------");
		System.out.println(title);
		System.out.println("-------------------------");
	}
	
	/**
	 * 로그인
	 */
	public void loginMenu() {
		printTitle("로그인");
		System.out.print("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw = sc.next();

		String grade = service.login(memberId, memberPw);
		System.out.println("[로그인성공] " + memberId + "님 (등급: " + grade + ")");
		switch(grade) {
		case "G":
		case "S":
			serviceMainMenu();
			break;
		case "A":
			adminMainMenu();
			break;
		}
	}	
	
	/**
	 * 회원 전용 서비스 메인메뉴
	 */
	private void serviceMainMenu() {
		printTitle("회원 메뉴");
	}

	private void adminMainMenu() {
		printTitle("관리자 메뉴");
	}
	
}
