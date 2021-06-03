/**
 * 
 */
package model.dto;

/**
 * <pre>
 * 회원의 속성(데이터) 항목
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 *
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
		public String mobile; // unique value

		/** 이메일, 필수 */
		public String email; // unique value

		// 필수 - 시스템
		/** 가입일, 필수, 시스템 입력 */
		public String entryDate;

		/** 등급, 필수, 시스템 입력 */
		public String grade; // 일반(G) / 우수(S) / 관리자(A)


		/** 기본 생성자 */
		public Member() {}

		/**
		 * 사용자입력 필수데이터 초기화 생성자
		 * @param memberId 아이디
		 * @param memberPw 비밀번호
		 * @param name 이름
		 * @param mobile 휴대폰
		 * @param email 이메일
		 */
		public Member(String memberId, String memberPw, String name, String mobile, String email) {
			this.memberId = memberId;
			this.memberPw = memberPw;
			this.name = name;
			this.mobile = mobile;
			this.email = email;
		}

		/**
		 * 회원 필수데이터 초기화 생성자
		 * @param memberId 아이디
		 * @param memberPw 비밀번호
		 * @param name 이름
		 * @param mobile 휴대폰
		 * @param email 이메일
		 * @param entryDate 가입일
		 * @param grade 등급
		 */
		public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
				String grade) {
			this(memberId, memberPw, name, mobile, email);
			this.entryDate = entryDate;
			this.grade = grade;
		}

		/**
		 * @return the memberId
		 */
		public String getMemberId() {
			return memberId;
		}

		/**
		 * 아이디 검증규칙 :
		 * -- 최소 6자리, 최대 30자리
		 * -- 문자열 길이 메서드 : {@link String#length}
		 * @param memberId the memberId to set
		 */
		public void setMemberId(String memberId) {
			boolean result = isMemberId(memberId);
			if(result) {
				this.memberId = memberId;
			} else {
				System.out.println("[오류] 아이디는 6~30자리 이내로 입력하세요");
			}
		}
		
		/**
		 * 아이디 검증 메서드
		 * @param memberId 아이디
		 * @return 아이디 길이가 6~30자리 이내면 true, 그렇지 않으면 false
		 */
		private boolean isMemberId(String memberId) {
			if(memberId.length() >= 6 && memberId.length() <= 30) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @return the memberPw
		 */
		public String getMemberPw() {
			return memberPw;
		}

		/**
		 * 비밀번호 검증규칙 :
		 * -- 최소 6자리, 최대 20자리
		 * @param memberPw the memberPw to set
		 */
		public void setMemberPw(String memberPw) {
			boolean result = isMemberPw(memberPw);
			if(result) this.memberPw = memberPw;
			else System.out.println("[오류] 비밀번호는 6~30자리 이내로 입력하세요");
		}
		
		/**
		 * 비밀번호 검증 메서드
		 * @param memberPw 비밀번호
		 * @return 비밀번호 길이가 6~20자리 이내면 true, 그렇지 않으면 false
		 */
		private boolean isMemberPw(String memberPw) {
			if(memberPw.length() >= 6 && memberPw.length() <= 20) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the mobile
		 */
		public String getMobile() {
			return mobile;
		}

		/**
		 * @param mobile the mobile to set
		 */
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the entryDate
		 */
		public String getEntryDate() {
			return entryDate;
		}

		/**
		 * @param entryDate the entryDate to set
		 */
		public void setEntryDate(String entryDate) {
			this.entryDate = entryDate;
		}

		/**
		 * @return the grade
		 */
		public String getGrade() {
			return grade;
		}

		/**
		 * 등급 검증 규칙
		 * -- G 또는 S 또는 A
		 * @param grade the grade to set
		 */
		public void setGrade(String grade) {
			if(isGrade(grade)) this.grade = grade;
			else System.out.println("[오류] 등급은 G, S, A 중 하나입니다.");
		}
		
		/**
		 * 등급 검증 메서드
		 * @param grade 변경 등급
		 * @return 등급이 G, S, A 중 하나이면 true, 그렇지 않으면 false
		 */
		private boolean isGrade(String grade) {
			return (grade.equals("G") || grade.equals("S") || grade.equals("A"));
		}

		@Override
		public String toString() {
			return memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", "
					+ grade;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;

			Member other = (Member) obj;
			if (memberId == null) {
				if (other.memberId != null)	// null : 어떠한 객체도 참조하고 있지 않음
					return false;
			} else if (!memberId.equals(other.memberId))
				return false;
			return true;
		}
}
