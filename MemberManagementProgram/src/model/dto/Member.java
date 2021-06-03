/**
 * 
 */
package model.dto;

/**
 * <pre>
 * ȸ���� �Ӽ�(������) �׸�
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 *
 */
public class Member {
		// �ʼ� - ���Խ� �Է�
		/** ���̵�, �ĺ�Ű */
		private String memberId; // unique value

		/** ��й�ȣ, �ʼ� */
		public String memberPw;

		/** �̸�, �ʼ� */
		public String name;

		/** �޴���, �ʼ� */
		public String mobile; // unique value

		/** �̸���, �ʼ� */
		public String email; // unique value

		// �ʼ� - �ý���
		/** ������, �ʼ�, �ý��� �Է� */
		public String entryDate;

		/** ���, �ʼ�, �ý��� �Է� */
		public String grade; // �Ϲ�(G) / ���(S) / ������(A)


		/** �⺻ ������ */
		public Member() {}

		/**
		 * ������Է� �ʼ������� �ʱ�ȭ ������
		 * @param memberId ���̵�
		 * @param memberPw ��й�ȣ
		 * @param name �̸�
		 * @param mobile �޴���
		 * @param email �̸���
		 */
		public Member(String memberId, String memberPw, String name, String mobile, String email) {
			this.memberId = memberId;
			this.memberPw = memberPw;
			this.name = name;
			this.mobile = mobile;
			this.email = email;
		}

		/**
		 * ȸ�� �ʼ������� �ʱ�ȭ ������
		 * @param memberId ���̵�
		 * @param memberPw ��й�ȣ
		 * @param name �̸�
		 * @param mobile �޴���
		 * @param email �̸���
		 * @param entryDate ������
		 * @param grade ���
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
		 * ���̵� ������Ģ :
		 * -- �ּ� 6�ڸ�, �ִ� 30�ڸ�
		 * -- ���ڿ� ���� �޼��� : {@link String#length}
		 * @param memberId the memberId to set
		 */
		public void setMemberId(String memberId) {
			boolean result = isMemberId(memberId);
			if(result) {
				this.memberId = memberId;
			} else {
				System.out.println("[����] ���̵�� 6~30�ڸ� �̳��� �Է��ϼ���");
			}
		}
		
		/**
		 * ���̵� ���� �޼���
		 * @param memberId ���̵�
		 * @return ���̵� ���̰� 6~30�ڸ� �̳��� true, �׷��� ������ false
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
		 * ��й�ȣ ������Ģ :
		 * -- �ּ� 6�ڸ�, �ִ� 20�ڸ�
		 * @param memberPw the memberPw to set
		 */
		public void setMemberPw(String memberPw) {
			boolean result = isMemberPw(memberPw);
			if(result) this.memberPw = memberPw;
			else System.out.println("[����] ��й�ȣ�� 6~30�ڸ� �̳��� �Է��ϼ���");
		}
		
		/**
		 * ��й�ȣ ���� �޼���
		 * @param memberPw ��й�ȣ
		 * @return ��й�ȣ ���̰� 6~20�ڸ� �̳��� true, �׷��� ������ false
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
		 * ��� ���� ��Ģ
		 * -- G �Ǵ� S �Ǵ� A
		 * @param grade the grade to set
		 */
		public void setGrade(String grade) {
			if(isGrade(grade)) this.grade = grade;
			else System.out.println("[����] ����� G, S, A �� �ϳ��Դϴ�.");
		}
		
		/**
		 * ��� ���� �޼���
		 * @param grade ���� ���
		 * @return ����� G, S, A �� �ϳ��̸� true, �׷��� ������ false
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
				if (other.memberId != null)	// null : ��� ��ü�� �����ϰ� ���� ����
					return false;
			} else if (!memberId.equals(other.memberId))
				return false;
			return true;
		}
}
