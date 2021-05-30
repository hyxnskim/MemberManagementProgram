package model.dto;

/**
 * <pre>
 * 회원의 속성 항목
 * </pre> 
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class Member {
		// 필수 - 가입시 입력
		/** 아이디, 식별키 */
		private String memberId; // unique value
		
		/** 비밀번호, 필수 */
		public String memberPw;
		
		/** 이름, 필수 */
		public String name;
		
		/** 휴대폰, 필수 */
		public String mobile;
		
		/** 이메일, 필수 */
		public String email;
		
		// 필수 - 시스템
		/** 가입일, 필수, 시스템 입력 */
		public String entryDate;
		
		/** 등급, 필수, 시스템 입력 */
		public String grade; // 일반(G) / 우수(S) / 관리자(A)
		
		// 선택
		/** 마일리지, 선택, 시스템 입력 */
		public int mileage;	// 일반회원 - 100,000이상이면 우수회원으로 등업
		
		/** 담당자, 선택, 시스템 입력 */
		public String manager; // 우수회원에게 관리자 배정, can be NULL
}
