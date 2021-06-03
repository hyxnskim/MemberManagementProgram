/**
 * 
 */
package model.dto;

/**
 * �Ϲ� ȸ�� ������ Ŭ����
 * @author Hyunsoo Kim
 * @ version ver.1.0
 * @ since jdk1.8
 */
public class GeneralMember extends Member{
	/** �Ϲ�ȸ�� ���ϸ��� */
	private int mileage;


	/** �⺻������ */
	public GeneralMember() {}

	/**
	 * ȸ�� �Է� �ʼ������� �ʱ�ȭ ������
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @param name �̸�
	 * @param mobile �޴���
	 * @param email �̸���
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
	 * �Ϲ�ȸ�� ��ü ������ �ʱ�ȭ ������
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @param name �̸�
	 * @param mobile �޴���
	 * @param email �̸���
	 * @param entryDate ������
	 * @param grade ���
	 * @param mileage ���ϸ���
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
	 * ���ϸ��� ���� ��Ģ
	 * -- 0 �̻� 100000 ����
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		boolean result = isMileage(mileage);
		if(result) this.mileage = mileage;
		else System.out.println("[����] ���ϸ����� 0~100,000 �̳��Դϴ�");
	}
	
	/**
	 * ���ϸ��� ���� �޼���
	 * @param mileage ���ϸ���
	 * @return ���ϸ����� 0~100000 ���̸� true, �׷��� ������ false
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
