package view;

import java.util.Scanner;

import model.dto.Member;
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
				loginMenu();
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
		
		Member mem = service.getMember(service.verifyMember(memberId, memberPw));
		
		switch(grade) {
		case "G":
		case "S":
			serviceMainMenu(mem);
			break;
		case "A":
			adminMainMenu();
			break;
		}
		
		
	}	
	
	/**
	 * 회원 전용 서비스 메인메뉴
	 */
	private void serviceMainMenu(Member mem) {
		printTitle("회원 메뉴");
		
		System.out.println("1. 내 정보 조회");
		System.out.println("2. 내 정보 변경");
		System.out.println("3. 비밀번호 변경");
		System.out.println("4. 로그아웃");
		System.out.println("0. 프로그램 종료");
		System.out.println("-------------------------");
		System.out.print("메뉴번호 입력 : ");
		
		int menuNo = sc.nextInt();
		
		switch(menuNo) {
		case 1:
			printTitle("내 정보 조회");
			System.out.println(service.getMember(mem.getMemberId()));
			break;
		case 2:
			printTitle("내 정보 변경");
			service.setMember(mem);
			break;
		case 3:
			printTitle("비밀번호 변경");
			System.out.print("기존 비밀번호: ");
			String pw = sc.next();
			System.out.print("변경할 비밀번호: ");
			String newPw = sc.next();
			
			service.setMemberPw(mem.getMemberId(), pw, newPw);
			break;
		case 4:
			System.out.println("[로그아웃 성공] 이용해주셔서 감사합니다..");
			mainMenu();
			break;
		case 0:
			System.out.println("프로그램을 종료합니다.");
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("메뉴번호 오류");
			break;
		}
	}

	private void adminMainMenu() {
		printTitle("관리자 메뉴");
	}
	
}