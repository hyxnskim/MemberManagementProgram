package model.service;

import java.util.ArrayList;

import model.dto.Member;

/**
 * <pre>
 * 회원 관리 위한 메서드 정의
 * </pre> 
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public abstract class MemberServiceAbstract {
	
	/**
	 * <pre>
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * 1. 현재 등록된 회원수만큼 반복하면서
	 * 2. 배열에 저장된 순서대로 저장된 객체의 아이디와(dto.getMemberId()) 아규먼트로 전달받은 아이디가 같은지 비교
	 * 3. 아이디가 같으면 현재 저장된 배열요소의 인덱스번호를 반환 
	 * 4. 반복을 다 했는데도 return 되지 않았다면 중복되지 않은 아이디이므로 -1 반환
	 * </pre>
	 * @param memberId 아이디
	 * @return 존재시에 저장위치번호, 미존재시 -1
	 */
	public abstract int exist(String memberId);
	
	/**
	 * <pre>
	 * 회원등록
	 * -- 메서드명 : addMember
	 * -- 매개변수 : 다형성반영 모든회원을 등록하기 위한 메서드
	 * -- 반환타입 : void
	 * </pre>
	 * @param dto 등록할 회원 객체
	 */
	public abstract void addMember(Member dto);
	
	/**
	 * <pre>
	 * 회원 등록 - 필수 정보
	 * </pre>
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰번호
	 * @param email 이메일
	 */
	public abstract void addMember(String memberId, String memberPw, String name, String mobile, String email);
	
	/**
	 * <pre>
	 * 회원 상세정보 조회
	 * 1. exist(String memberId) 수행결과 : 저장위치 반환
	 * 2. 저장위치 0 이상이면 존재, 해당배열요소의 객체를 return
	 * 3. 0보다 작으면 존재하지 않음, return null
	 * </pre>
	 * @param memberId 정보를 조회할 멤버의 아이디
	 * @return 조회할 멤버 객체
	 */
	public abstract Member getMember(String memberId);
	
	/**
	 * <pre>
	 * 회원 전체정보 조회
	 * -- 메서드명 : getMember()
	 * -- 매개변수 : no argument
	 * -- 반환타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 Member []
	 * </pre>
	 * @return 전체 멤버 객체 배열
	 */
	public abstract ArrayList<Member> getMember();
	
	/**
	 * <pre>
	 * 회원정보 전체변경
	 * -- 메서드명 : setMember()
	 * -- 매개변수 : Member
	 * -- 반환타입 : boolean
	 * </pre>
	 * @param dto 정보 변경할 회원 객체
	 */
	public abstract boolean setMember(Member dto);
	
	/**
	 * <pre>
	 * 회원 비밀번호 변경
	 * -- 메서드명 : setMemberPw()
	 * -- 매개변수 : 아이디, 비밀번호, 변경비밀번호
	 * -- 반환타입 : boolean 암호변경성공 true, 실패하면 false
	 * </pre>
	 * @param memberId 비밀번호를 변경할 회원의 아이디
	 * @param memberPw 변경 전 비밀번호
	 * @param newPw 변경 후 비밀번호
	 * @return 정상적으로 변경되었는지 여부
	 */
	public abstract boolean setMemberPw(String memberId, String memberPw, String newPw);
	
	/**
	 * <pre>
	 * 회원탈퇴
	 * -- 메서드명 : removeMember()
	 * -- 매개변수 : 아이디, 비밀번호
	 * -- 반환타입 : Member
	 * </pre>
	 * @param memberId 탈퇴할 회원 아이디
	 * @param memberPw 탈퇴할 회원 비밀번호
	 */
	public abstract Member removeMember(String memberId, String memberPw);
	
	/**
	 * <pre>
	 * 회원전체탈퇴
	 * -- 메서드명 : removeMember()
	 * -- 매개변수 : no argument
	 * -- 반환타입 : void
	 * </pre>
	 */
	public abstract void removeMember();
	
	/**
	 * <pre>
	 * 우수회원 등업
	 * -- 메서드명 : gradeUp()
	 * -- 매개변수 : 회원 객체, 담당자
	 * -- 반환타입 : boolean
	 * </pre>
	 */
	public abstract boolean gradeUp(Member dto, String manager);
	
	/**
	 * <pre>
	 * 회원 로그인
	 * -- 메서드명 : login()
	 * -- 매개변수 : 회원 아이디, 비밀번호
	 * -- 반환타입 : String
	 * </pre>
	 */
	public abstract String login(String memberId, String memberPw);
	
	/**
	 * <pre>
	 * 회원 아이디 찾기
	 * -- 메서드명 : findId()
	 * -- 매개변수 : 이름, 휴대폰 번호 또는 이메일 주소를 저장하는 문자열
	 * -- 반환타입 : String
	 * </pre>
	 */
	public abstract String findId(String name, String str);
	
	/**
	 * <pre>
	 * 회원 비밀번호 찾기
	 * -- 메서드명 : findPw()
	 * -- 매개변수 : 아이디, 휴대폰 번호 또는 이메일 주소를 저장하는 문자열
	 * -- 반환타입 : boolean
	 * </pre>
	 */
	public abstract boolean findPw(String memberId, String str);
}
