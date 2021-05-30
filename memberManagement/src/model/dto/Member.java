package model.dto;

/**
 * <pre>
 * ȸ���� �Ӽ� �׸�
 * </pre> 
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
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
		public String mobile;
		
		/** �̸���, �ʼ� */
		public String email;
		
		// �ʼ� - �ý���
		/** ������, �ʼ�, �ý��� �Է� */
		public String entryDate;
		
		/** ���, �ʼ�, �ý��� �Է� */
		public String grade; // �Ϲ�(G) / ���(S) / ������(A)
		
		// ����
		/** ���ϸ���, ����, �ý��� �Է� */
		public int mileage;	// �Ϲ�ȸ�� - 100,000�̻��̸� ���ȸ������ ���
		
		/** �����, ����, �ý��� �Է� */
		public String manager; // ���ȸ������ ������ ����, can be NULL
}
