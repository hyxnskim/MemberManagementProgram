package view;

import java.util.ArrayList;
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
				addMemberMenu();
				break;
			case 3:
				System.out.println("3. 아이디찾기");
				findIdMenu();
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
			adminMainMenu(mem);
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

	private void adminMainMenu(Member mem) {
		printTitle("관리자 메뉴");
		
		System.out.println("1. 내정보조회");
		System.out.println("2. 내정보변경");
		System.out.println("3. 비밀번호변경");
		System.out.println("4. 회원관리[전체회원조회]");
		System.out.println("5. 로그아웃");
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
			printTitle("4. 회원관리[전체회원조회]");
			ArrayList<Member> memList = service.getMember();
			for(Member i : memList) {
				System.out.println(i);
			}
		case 5:
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
	
	public void addMemberMenu() {
		printTitle("회원 가입 메뉴");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw = sc.next();

		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("휴대폰 : ");
		String mobile = sc.next();

		System.out.print("이메일 : ");
		String email = sc.next();
		
		boolean isAdded = service.addMember(memberId, memberPw, name, mobile, email);
		if(isAdded) {
			System.out.println("[성공] " + memberId + "님 회원등록 완료되었습니다. 로그인 후 회원전용 서비스를 이용하시기 바랍니다.");
			loginMenu();
		} else {
			mainMenu();
		}
	}
	
	private void findIdMenu() {
		printTitle("아이디 찾기 메뉴");
		
		System.out.println("1. 휴대폰 번호로 찾기");
		System.out.println("2. 이메일 주소로 찾기");
		System.out.println("0. 이전 메뉴로 돌아가기");
		System.out.println("-------------------------");
		System.out.print("메뉴번호 입력 : ");
		
		int menuNo = sc.nextInt();
		
		switch(menuNo) {
		case 1:
			System.out.println("이름 : ");
			String name = sc.next();
			
			System.out.println("휴대폰 : ");
			String mobile = sc.next();
			
			String memberId = service.findId(name, mobile);
			if(memberId != null) {
				System.out.println(name + "님의 아이디는 " + memberId + "입니다.");
			}
			return;
		case 2:
			System.out.println("이름 : ");
			name = sc.next();
			
			System.out.println("이메일 : ");
			String email = sc.next();
			
			memberId = service.findId(name, email);
			if(memberId != null) {
				System.out.println(name + "님의 아이디는 " + memberId + "입니다.");
			}
			return;
		case 0:
			System.out.println("메인 메뉴로 돌아갑니다.");
			return;
		default:
			System.out.println("메뉴번호 오류");
			break;
		}
		
		
	}
	
}
