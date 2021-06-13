/**
 * 
 */
package model.dto;

/**
 * 일반 회원 도메인 클래스
 * @author Hyunsoo Kim
 * @ version ver.1.0
 * @ since jdk1.8
 */
public class GeneralMember extends Member{
	/** 일반회원 마일리지 */
	private int mileage;


	/** 기본생성자 */
	public GeneralMember() {}

	/**
	 * 회원 입력 필수데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email) {
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);

		setGrade("G");
		setEntryDate("2021-05-26");
	}

	/**
	 * 일반회원 전체 데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 * @param mileage 마일리지
	 */
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.mileage = mileage;
	}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * 마일리지 검증 규칙
	 * -- 0 이상 100000 이하
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		boolean result = isMileage(mileage);
		if(result) this.mileage = mileage;
		else System.out.println("[����] ���ϸ����� 0~100,000 �̳��Դϴ�");
	}
	
	/**
	 * 마일리지 검증 메서드
	 * @param mileage 마일리지
	 * @return 마일리지가 0~100000 사이면 true, 그렇지 않으면 false
	 */
	private boolean isMileage(int mileage) {
		if(mileage >= 0 && mileage <= 100000) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return getMemberId() + ", " + getMemberPw() + ", " + getName() + ", " + getMobile() + ", " + getEmail() + ", " + getEntryDate() + ", "
				+ getGrade() + ", " + mileage;
	}
}
