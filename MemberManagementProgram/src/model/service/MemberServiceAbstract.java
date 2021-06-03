package model.service;

import java.util.ArrayList;

import model.dto.Member;

/**
 * <pre>
 * ȸ�� ���� ���� �޼��� ����
 * </pre> 
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */


public abstract class MemberServiceAbstract {
	
	/**
	 * <pre>
	 * CRUD �޼��忡�� ����ϱ� ���� ȸ�� �������� �� ���� ��ġ ��ȸ �޼���
	 * 1. ���� ��ϵ� ȸ������ŭ �ݺ��ϸ鼭
	 * 2. �迭�� ����� ������� ����� ��ü�� ���̵��(dto.getMemberId()) �ƱԸ�Ʈ�� ���޹��� ���̵� ������ ��
	 * 3. ���̵� ������ ���� ����� �迭����� �ε�����ȣ�� ��ȯ 
	 * 4. �ݺ��� �� �ߴµ��� return ���� �ʾҴٸ� �ߺ����� ���� ���̵��̹Ƿ� -1 ��ȯ
	 * </pre>
	 * @param memberId ���̵�
	 * @return ����ÿ� ������ġ��ȣ, ������� -1
	 */
	public abstract int exist(String memberId);
	
	/**
	 * <pre>
	 * ȸ�����
	 * -- �޼���� : addMember
	 * -- �Ű����� : �������ݿ� ���ȸ���� ����ϱ� ���� �޼���
	 * -- ��ȯŸ�� : void
	 * </pre>
	 * @param dto ����� ȸ�� ��ü
	 */
	public abstract void addMember(Member dto);
	
	/**
	 * <pre>
	 * ȸ�� ��� - �ʼ� ����
	 * </pre>
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @param name �̸�
	 * @param mobile �޴�����ȣ
	 * @param email �̸���
	 */
	public abstract void addMember(String memberId, String memberPw, String name, String mobile, String email);
	
	/**
	 * <pre>
	 * ȸ�� ������ ��ȸ
	 * 1. exist(String memberId) ������ : ������ġ ��ȯ
	 * 2. ������ġ 0 �̻��̸� ����, �ش�迭����� ��ü�� return
	 * 3. 0���� ������ �������� ����, return null
	 * </pre>
	 * @param memberId ������ ��ȸ�� ����� ���̵�
	 * @return ��ȸ�� ��� ��ü
	 */
	public abstract Member getMember(String memberId);
	
	/**
	 * <pre>
	 * ȸ�� ��ü���� ��ȸ
	 * -- �޼���� : getMember()
	 * -- �Ű����� : no argument
	 * -- ��ȯŸ�� : ���� ��ϵ� ��� ȸ������ �������� ������ �迭, ������ Member []
	 * </pre>
	 * @return ��ü ��� ��ü �迭
	 */
	public abstract ArrayList<Member> getMember();
	
	/**
	 * <pre>
	 * ȸ������ ��ü����
	 * -- �޼���� : setMember()
	 * -- �Ű����� : Member
	 * -- ��ȯŸ�� : boolean
	 * </pre>
	 * @param dto ���� ������ ȸ�� ��ü
	 */
	public abstract boolean setMember(Member dto);
	
	/**
	 * <pre>
	 * ȸ�� ��й�ȣ ����
	 * -- �޼���� : setMemberPw()
	 * -- �Ű����� : ���̵�, ��й�ȣ, �����й�ȣ
	 * -- ��ȯŸ�� : boolean ��ȣ���漺�� true, �����ϸ� false
	 * </pre>
	 * @param memberId ��й�ȣ�� ������ ȸ���� ���̵�
	 * @param memberPw ���� �� ��й�ȣ
	 * @param newPw ���� �� ��й�ȣ
	 * @return ���������� ����Ǿ����� ����
	 */
	public abstract boolean setMemberPw(String memberId, String memberPw, String newPw);
	
	/**
	 * <pre>
	 * ȸ��Ż��
	 * -- �޼���� : removeMember()
	 * -- �Ű����� : ���̵�, ��й�ȣ
	 * -- ��ȯŸ�� : Member
	 * </pre>
	 * @param memberId Ż���� ȸ�� ���̵�
	 * @param memberPw Ż���� ȸ�� ��й�ȣ
	 */
	public abstract Member removeMember(String memberId, String memberPw);
	
	/**
	 * <pre>
	 * ȸ����üŻ��
	 * -- �޼���� : removeMember()
	 * -- �Ű����� : no argument
	 * -- ��ȯŸ�� : void
	 * </pre>
	 */
	public abstract void removeMember();
	
	/**
	 * <pre>
	 * ���ȸ�� ���
	 * -- �޼���� : gradeUp()
	 * -- �Ű����� : ȸ�� ��ü, �����
	 * -- ��ȯŸ�� : boolean
	 * </pre>
	 */
	public abstract boolean gradeUp(Member dto, String manager);
	
	/**
	 * <pre>
	 * ȸ�� �α���
	 * -- �޼���� : login()
	 * -- �Ű����� : ȸ�� ���̵�, ��й�ȣ
	 * -- ��ȯŸ�� : boolean
	 * </pre>
	 */
	public abstract boolean login(String memberId, String memberPw);
	
	/**
	 * <pre>
	 * ȸ�� ���̵� ã��
	 * -- �޼���� : findId()
	 * -- �Ű����� : �̸�, �޴��� ��ȣ �Ǵ� �̸��� �ּҸ� �����ϴ� ���ڿ�
	 * -- ��ȯŸ�� : String
	 * </pre>
	 */
	public abstract String findId(String name, String str);
	
	/**
	 * <pre>
	 * ȸ�� ��й�ȣ ã��
	 * -- �޼���� : findPw()
	 * -- �Ű����� : ���̵�, �޴��� ��ȣ �Ǵ� �̸��� �ּҸ� �����ϴ� ���ڿ�
	 * -- ��ȯŸ�� : boolean
	 * </pre>
	 */
	public abstract boolean findPw(String memberId, String str);
}
