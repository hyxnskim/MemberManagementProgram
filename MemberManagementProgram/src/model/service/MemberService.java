package model.service;

import java.util.ArrayList;

import model.dto.AdminMember;
import model.dto.GeneralMember;
import model.dto.Member;
import model.dto.SpecialMember;
import util.Utility;

/**
 * <pre>
 * 회원 관리 위한 메서드 구현
 * </pre> 
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class MemberService extends MemberServiceAbstract{
	/** 회원들을 저장/관리하기 위한 자료 저장구조 */
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/** 기본생성자 : 초기화 회원 등록 수행 */
	public MemberService() {
		System.out.println("초기화회원 등록작업이 완료되었습니다: " + initMember());
	}
	
	/** 
	 * <pre>
	 * 현재 등록 인원수 조회
	 * </pre>
	 * @return 현재 등록 인원수
	 */
	public int getCount() {
		return list.size();
	}
	
	/**
	 * <pre>
	 * 아이디 중복 체크 메서드
	 * </pre>
	 * @param memberId 아이디
	 * @return 존재시에 저장위치 번호, 존재하지 않으면 -1
	 */
	public int exist(String memberId) {
		for(int i = 0; i < getCount(); i++) {
			if(memberId.equals(list.get(i).getMemberId())) return i;
		}		
		return -1;
	}
	
	/**
	 * <pre>
	 * 휴대폰 번호 중복 체크 메서드
	 * </pre>
	 * @param mobile 체크 대상 휴대폰 번호
	 * @return 존재시에 저장위치 번호, 존재하지 않으면 -1
	 */
	public int existMobile(String mobile) {
		for(int i = 0; i < getCount(); i++) {
			if(mobile.equals(list.get(i).getMobile())) return i;
		}	
		return -1;
	}
	
	/**
	 * <pre>
	 * 이메일 주소 중복 체크 메서드
	 * </pre>
	 * @param email 체크 대상 이메일 주소
	 * @return 존재시에 저장위치 번호, 존재하지 않으면 -1
	 */
	public int existEmail(String email) {
		for(int i = 0; i < getCount(); i++) {
			if(email.equals(list.get(i).getEmail())) return i;
		}	
		return -1;
	}
	
	
	/**
	 * <pre>
	 * 테스트를 위한 회원 초기화 등록 메서드
	 * </pre>
	 * @return 초기화 회원등록 인원수
	 */
	public int initMember(){
		
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
		addMember(dto1);
		addMember(dto2);
		addMember(dto3);
		addMember(dto4);
		addMember(dto5);
		
		return getCount();
	}
	
	/**
	 * <pre>
	 * 회원 등록 메서드
	 * <pre>
	 * @param dto 등록 회원
	 */
	public void addMember(Member dto) {
		if(exist(dto.getMemberId()) == -1) {
			list.add(dto);
		}
		else {
			System.out.println("[오류] " + dto.getMemberId() + "는 중복된 아이디입니다");
		}
	}
	
	/**
	 * <pre>
	 * 회원 등록 메서드
	 * <pre>
	 * @param memberId 회원 아이디
	 * @param memberPw 회원 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	public void addMember (String memberId, String memberPw, String name, String mobile, String email){
	
		int idxMobile = existMobile(mobile);
		int idxEmail = existEmail(email);
		
		if(idxMobile >= 0) {
			System.out.println("[오류] " + mobile + "은 이미 등록된 휴대폰 번호입니다");
		} else if(idxEmail >= 0) {
			System.out.println("[오류] " + email + "은 이미 등록된 이메일 주소입니다");
		} else {
			GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
			dto.setGrade("G");
			dto.setEntryDate(Utility.getCurrentDate());
			dto.setMileage(1000);
			addMember(dto);
		}
	}
	
	/**
	 * <pre>
	 * 전체 회원 정보 조회 메서드
	 * </pre>
	 */
	public ArrayList<Member> getMember() {
		return list;
	}
	
	/**
	 * <pre>
	 * 특정 회원 정보 조회 메서드
	 * </pre>
	 * @param memberId 조회할 회원 아이디
	 * @return 조회할 회원 객체
	 */
	public Member getMember(String memberId) {
		int idx = exist(memberId);
		if(idx >= 0) {
			return list.get(idx);
		}
		
		System.out.println("[오류] " + memberId + "는 존재하지 않는 아이디입니다");
		return null; 
	}
	
	/**
	 * <pre>
	 * 특정 회원 정보 조회 메서드
	 * </pre>
	 * @param memberId 조회할 회원 아이디
	 * @return 조회할 회원 객체
	 */
	public Member getMember(int idx) {
		if(idx >= 0 && idx < list.size()) {
			Member mem = list.get(idx);
			return mem; 
		}
		return null;
	}

	/**
	 * <pre>
	 * 회원정보 전체 변경 - 사용자 입력 받도록 수정 필요함
	 * </pre>
	 * @param dto 변경할 회원 객체
	 * @return 성공 여부
	 */
	public boolean setMember(Member dto) {
		int idx = exist(dto.getMemberId());
		
		if(idx > -1) {
			list.set(idx, dto);
			System.out.println("성공적으로 변경되었습니다");
			return true;	
		}
		System.out.println("[오류] 등록되지 않은 회원입니다");
		return false;
	}
	
	/**
	 * <pre>
	 * 입력 회원 정보 확인 메서드
	 * </pre>
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공시 배열 요소 인덱스, 그렇지 않으면 -1
	 */
	public int verifyMember(String memberId, String memberPw) {
		int idx = exist(memberId);
		if(idx >= 0 && list.get(idx).getMemberPw().equals(memberPw)) {
			return idx;
		}
		return -1;
	}
	
	/**
	 * <pre>
	 * 회원 비밀번호 변경
	 * </pre>
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param newPw 변경 비밀번호
	 * @return 변경 성공 여부
	 */
	public boolean setMemberPw(String memberId, String memberPw, String newPw) {
		int idx = verifyMember(memberId, memberPw);
		if(idx >= 0) {
			list.get(idx).setMemberPw(newPw);
			System.out.println("비밀번호가 성공적으로 변경되었습니다");
			return true;
		}
		System.out.println("[오류] 잘못된 회원 정보입니다." );
		return false;
	}

	/**
	 * <pre>
	 * 회원 탈퇴 메서드
	 * </pre>
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공시 탈퇴회원 기존 정보, 실패시 null
	 */
	public Member removeMember(String memberId, String memberPw) {
		
		int idx = verifyMember(memberId, memberPw);
		if(idx >= 0) {
			System.out.println("정상적으로 탈퇴되었습니다");
			Member dto = list.remove(idx);
			return dto;
		}
		System.out.println("[오류] 잘못된 회원 정보입니다");
		return null;
	}

	/**
	 * <pre>
	 * 전체 회원 탈퇴 메서드
	 * </pre>
	 */
	public void removeMember() {
		list.clear();
	}

	/**
	 * </pre>
	 * 우수회원 등업 처리
	 * </pre>
	 * @param dto 등업하려는 회원 객체
	 * @param manager 담당자
	 * @return 성공시 true, 실패시 false
	 */
	public boolean gradeUp(Member dto, String manager) {
		if(dto instanceof GeneralMember) {
			GeneralMember gm = (GeneralMember)dto;
			if(gm.getMileage() >= 100000) {
				SpecialMember sm = new SpecialMember();
				sm.setMemberId(dto.getMemberId());
				sm.setMemberPw(dto.getMemberPw());
				sm.setName(dto.getName());
				sm.setEmail(dto.getEmail());
				sm.setMobile(dto.getMobile());
				sm.setEntryDate(dto.getEntryDate());
				sm.setGrade("S");
				sm.setManager(manager);
				list.add(sm);
				list.remove(dto);
				System.out.println(sm.getName() + "님은 우수 회원으로 등업되었습니다.");
				return true;
			}
		else if(gm.getMileage() < 100000) {
			System.out.println("누적 마일리지 100,000점 이상이면 우수 회원으로 등업됩니다");
			System.out.println(gm.getName() + "님의 현재 마일리지는 " + Utility.putComma(gm.getMileage()) + "점 입니다.");
			}
		}
		return false;
	}
	
	/**
	 * <pre>
	 * 회원 로그인 메서드
	 * <pre>
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공시 회원 등급, 실패시 null
	 */
	public String login(String memberId, String memberPw) {
		int idx = verifyMember(memberId, memberPw);
		if(idx >= 0) {
			System.out.println("로그인 성공");
			String grade = list.get(idx).getGrade();
			if(grade.equals("G")) {
				GeneralMember gm = (GeneralMember)list.get(idx);
				gm.setMileage(gm.getMileage() + 500 );
				gradeUp(gm, "담당자");
			}
			else if(grade.equals("S")) {
				System.out.println(list.get(idx).getName() + "님은 우수회원입니다.");
			}
			return list.get(idx).getGrade();
		}
		System.out.println("로그인 실패");
		return null;
	}
	
	/**
	 * <pre>
	 * 회원 아이디 찾기 메서드
	 * </pre>
	 * @param name 이름
	 * @param str 휴대폰 번호 또는 이메일 주소
	 * @return 성공시 마스킹 처리한 회원 아이디, 실패시 null
	 */
	public String findId(String name, String str) {
		Member tmp = new Member();
		
		for(int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			if(tmp.getName().equals(name) && (tmp.getEmail().equals(str) || tmp.getMobile().equals(str))) {
				return Utility.alterString(tmp.getMemberId(), 4);
			}
		}
		System.out.println("[오류] 입력한 정보로 등록된 회원이 존재하지 않습니다");
		return null;
	}
	
	/**
	 * <pre>
	 * 비밀번호 찾기 메서드
	 * </pre>
	 * @param memberId 아이디
	 * @param str 휴대폰 번호 또는 이메일 주소
	 * @return 성공 시 true, 실패시 false
	 */
	public boolean findPw(String memberId, String str) {
		int idx = exist(memberId);
	
		if(idx >= 0 && (list.get(idx).getEmail().equals(str) || list.get(idx).getMobile().equals(str))) {
			System.out.println("임시 비밀번호가 " + str + "로 전송되었습니다.");
			System.out.println("발급된 임시 비밀번호로 로그인 후 비밀빈호 변경 바랍니다.");
			list.get(idx).setMemberPw(Utility.secureNum(6));
			return true;
		}
		System.out.println("[오류] 입력한 정보로 등록된 회원이 존재하지 않습니다");
		return false;
	}
	
}
