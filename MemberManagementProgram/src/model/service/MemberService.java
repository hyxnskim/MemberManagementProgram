package model.service;

import java.util.ArrayList;

import model.dto.AdminMember;
import model.dto.GeneralMember;
import model.dto.Member;
import model.dto.SpecialMember;
import util.Utility;

/**
 * <pre>
 * ȸ�� ���� ���� �޼��� ����
 * </pre> 
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */

public class MemberService extends MemberServiceAbstract{
	/** ȸ������ ����/�����ϱ� ���� �ڷ� ���屸�� */
	private ArrayList<Member> list = new ArrayList<Member>();
	
	/** �⺻������ : �ʱ�ȭ ȸ�� ��� ���� */
	public MemberService() {
		System.out.println("�ʱ�ȭȸ�� ����۾��� �Ϸ�Ǿ����ϴ� : " + initMember());
	}
	
	/** 
	 * <pre>
	 * ���� ��� �ο��� ��ȸ
	 * </pre>
	 * @return ���� ��� �ο���
	 */
	public int getCount() {
		return list.size();
	}
	
	/**
	 * <pre>
	 * ���̵� �ߺ� üũ �޼���
	 * </pre>
	 * @param memberId ���̵�
	 * @return ����ÿ� ������ġ ��ȣ, �������� ������ -1
	 */
	public int exist(String memberId) {
		for(int i = 0; i < getCount(); i++) {
			if(memberId.equals(list.get(i).getMemberId())) return i;
		}		
		return -1;
	}
	
	/**
	 * <pre>
	 * �޴��� ��ȣ �ߺ� üũ �޼���
	 * </pre>
	 * @param mobile üũ ��� �޴��� ��ȣ
	 * @return ����ÿ� ������ġ ��ȣ, �������� ������ -1
	 */
	public int existMobile(String mobile) {
		for(int i = 0; i < getCount(); i++) {
			if(mobile.equals(list.get(i).getMobile())) return i;
		}	
		return -1;
	}
	
	/**
	 * <pre>
	 * �̸��� �ּ� �ߺ� üũ �޼���
	 * </pre>
	 * @param email üũ ��� �̸��� �ּ�
	 * @return ����ÿ� ������ġ ��ȣ, �������� ������ -1
	 */
	public int existEmail(String email) {
		for(int i = 0; i < getCount(); i++) {
			if(email.equals(list.get(i).getEmail())) return i;
		}	
		return -1;
	}
	
	
	/**
	 * <pre>
	 * �׽�Ʈ�� ���� ȸ�� �ʱ�ȭ ��� �޼���
	 * </pre>
	 * @return �ʱ�ȭ ȸ����� �ο���
	 */
	public int initMember(){
		
		Member dto1 = new GeneralMember("user01", "password01", "ȫ�浿", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "������", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "�̼���", "01012343000", "user03@work.com", "2020-11-15", "S", "������");
		Member dto4 = new SpecialMember("user04", "password04", "������", "01012344000", "user04@work.com", "2021-01-05", "S", "���ϸ�");
		Member dto5 = new AdminMember("administrator", "admin1004", "������", "01012345000", "administrator@work.com", "2020-04-01", "A", "����");
		addMember(dto1);
		addMember(dto2);
		addMember(dto3);
		addMember(dto4);
		addMember(dto5);
		
		return getCount();
	}
	/**
	 * <pre>
	 * ȸ�� ��� �޼���
	 * <pre>
	 * @param dto ��� ȸ��
	 */
	public void addMember(Member dto) {
		if(exist(dto.getMemberId()) == -1) {
			list.add(dto);
		}
		else {
			System.out.println("[����] " + dto.getMemberId() + "�� �ߺ��� ���̵��Դϴ�");
		}
	}
	
	/**
	 * <pre>
	 * ȸ�� ��� �޼���
	 * <pre>
	 * @param memberId ȸ�� ���̵�
	 * @param memberPw ȸ�� ��й�ȣ
	 * @param name �̸�
	 * @param mobile �޴���
	 * @param email �̸���
	 */
	public void addMember (String memberId, String memberPw, String name, String mobile, String email){
	
		int idxMobile = existMobile(mobile);
		int idxEmail = existEmail(email);
		
		if(idxMobile >= 0) {
			System.out.println("[����] " + mobile + "�� �̹� ��ϵ� �޴��� ��ȣ�Դϴ�");
		} else if(idxEmail >= 0) {
			System.out.println("[����] " + email + "�� �̹� ��ϵ� �̸��� �ּ��Դϴ�.");
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
	 * ��ü ȸ�� ���� ��ȸ �޼���
	 * </pre>
	 */
	public ArrayList<Member> getMember() {
		return list;
	}
	
	/**
	 * <pre>
	 * Ư�� ȸ�� ���� ��ȸ �޼���
	 * </pre>
	 * @param memberId ��ȸ�� ȸ�� ���̵�
	 * @return ��ȸ�� ȸ�� ��ü
	 */
	public Member getMember(String memberId) {
		int idx = exist(memberId);
		if(idx >= 0) {
			return list.get(idx);
		}
		
		System.out.println("[����] " + memberId + "�� �������� �ʴ� ���̵��Դϴ�");
		return null; 
	}

	/**
	 * <pre>
	 * ȸ������ ��ü ���� - ����� �Է� �޵��� ���� �ʿ���
	 * </pre>
	 * @param dto ������ ȸ�� ��ü
	 * @return ���� ����
	 */
	public boolean setMember(Member dto) {
		int idx = exist(dto.getMemberId());
		
		if(idx > -1) {
			list.set(idx, dto);
			System.out.println("���������� ����Ǿ����ϴ�.");
			return true;	
		}
		System.out.println("[����] ��ϵ��� ���� ȸ���Դϴ�.");
		return false;
	}
	
	/**
	 * <pre>
	 * �Է� ȸ�� ���� Ȯ�� �޼���
	 * </pre>
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @return ������ �迭 ��� �ε���, �׷��� ������ -1
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
	 * ȸ�� ��й�ȣ ����
	 * </pre>
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @param newPw ���� ��й�ȣ
	 * @return ���� ���� ����
	 */
	public boolean setMemberPw(String memberId, String memberPw, String newPw) {
		int idx = verifyMember(memberId, memberPw);
		if(idx >= 0) {
			System.out.println("��й�ȣ�� ���������� ����Ǿ����ϴ�.");
			list.get(idx).setMemberPw(newPw);
			return true;
		}
		System.out.println("[����] �߸��� ȸ�� �����Դϴ�." );
		return false;
	}

	/**
	 * <pre>
	 * ȸ�� Ż�� �޼���
	 * </pre>
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @return ������ Ż��ȸ�� ���� ����, ���н� null
	 */
	public Member removeMember(String memberId, String memberPw) {
		
		int idx = verifyMember(memberId, memberPw);
		if(idx >= 0) {
			System.out.println("���������� Ż��Ǿ����ϴ�.");
			Member dto = list.remove(idx);
			return dto;
		}
		System.out.println("[����] �߸��� ȸ�� �����Դϴ�.");
		return null;
	}

	/**
	 * <pre>
	 * ��ü ȸ�� Ż�� �޼���
	 * </pre>
	 */
	public void removeMember() {
		list.clear();
	}

	/**
	 * </pre>
	 * ���ȸ�� ��� ó��
	 * </pre>
	 * @param dto ����Ϸ��� ȸ�� ��ü
	 * @param manager �����
	 * @return ������ true, ���н� false
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
				System.out.println(sm.getName() + "���� ��� ȸ������ ����Ǿ����ϴ�.");
				return true;
			}
		else if(gm.getMileage() < 100000) {
			System.out.println("���� ���ϸ��� 100,000�� �̻��̸� ��� ȸ������ ����˴ϴ�");
			System.out.println(gm.getName() + "���� ���� ���ϸ����� " + Utility.putComma(gm.getMileage()) + "�� �Դϴ�.");
			}
		}
		return false;
	}
	
	/**
	 * <pre>
	 * ȸ�� �α��� �޼���
	 * <pre>
	 * @param memberId ���̵�
	 * @param memberPw ��й�ȣ
	 * @return ������ true, ���н� false
	 */
	public boolean login(String memberId, String memberPw) {
		int idx = verifyMember(memberId, memberPw);
		if(idx >= 0) {
			System.out.println("�α��� ����");
			String grade = list.get(idx).getGrade();
			if(grade.equals("G")) {
				GeneralMember gm = (GeneralMember)list.get(idx);
				gm.setMileage(gm.getMileage() + 500 );
				gradeUp(gm, "�����");
			}
			else if(grade.equals("S")) {
				System.out.println(list.get(idx).getName() + "���� ���ȸ���Դϴ�.");
			}
			return true;
		}
		System.out.println("�α��� ����");
		return false;
	}
	
	/**
	 * <pre>
	 * ȸ�� ���̵� ã�� �޼���
	 * </pre>
	 * @param name �̸�
	 * @param str �޴��� ��ȣ �Ǵ� �̸��� �ּ�
	 * @return ������ ����ŷ ó���� ȸ�� ���̵�, ���н� null
	 */
	public String findId(String name, String str) {
		Member tmp = new Member();
		
		for(int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			if(tmp.getName().equals(name) && (tmp.getEmail().equals(str) || tmp.getMobile().equals(str))) {
				return Utility.alterString(tmp.getMemberId(), 4);
			}
		}
		System.out.println("[����] �Է��� ������ ��ϵ� ȸ���� �������� �ʽ��ϴ�");
		return null;
	}
	
	/**
	 * <pre>
	 * ��й�ȣ ã�� �޼���
	 * </pre>
	 * @param memberId ���̵�
	 * @param str �޴��� ��ȣ �Ǵ� �̸��� �ּ�
	 * @return ���� �� true, ���н� false
	 */
	public boolean findPw(String memberId, String str) {
		int idx = exist(memberId);
	
		if(idx >= 0 && (list.get(idx).getEmail().equals(str) || list.get(idx).getMobile().equals(str))) {
			System.out.println("�ӽ� ��й�ȣ�� " + str + "�� ���۵Ǿ����ϴ�.");
			System.out.println("�߱޵� �ӽ� ��й�ȣ�� �α��� �� ��к�ȣ ���� �ٶ��ϴ�.");
			list.get(idx).setMemberPw(Utility.secureNum(6));
			return true;
		}
		System.out.println("[����] �Է��� ������ ��ϵ� ȸ���� �������� �ʽ��ϴ�");
		return false;
	}
	
}
