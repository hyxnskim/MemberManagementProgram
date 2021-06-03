
package util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * ��� Ŭ�������� ����ϱ� ���� ���� �޼��� ���� Ŭ����
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */
public class Utility {

	/**
	 * <pre>
	 * ���� ��¥ ��ȯ �޼���
	 * </pre>
	 * @see java.util.SimpleDateFormat
	 * @return ���糯¥ ���ڿ�
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());
	}
	
	/**
	 * <pre>
	 * �ƱԸ�Ʈ�� ���� ������ ���ڸ� õ�������� �ĸ�ǥ�� ���ڿ� ��ȯ �޼���
	 * </pre>
	 * @see java.text.NumberFormat
	 * @param num �Է¹��� ����
	 * @return �ĸ��� ǥ��� ���ڿ�
	 */
	public static String putComma(int num) {
		NumberFormat nf = NumberFormat.getInstance();
		return nf.format(num);
	}
	
	/**
	 * <pre>
	 * �ƱԸ�Ʈ�� ���ڿ�, ���̸� �޾Ƽ� �ش� �ڸ����� �����ְ� �������� * ��ȣ�� ��ü ��ȯ�� ���ڿ� ��ȯ �޼���
	 * </pre>
	 * @param str �Է¹��� ���ڿ�
	 * @param len ������ �ڸ���
	 * @return ���� len �ڸ� ���� *�� ��ü�� ���ڿ�
	 */
	public static String alterString(String str, int len) {
		String res = new String("");
		for(int i = 0; i < str.length(); i++) {
			if(i < len) res += str.charAt(i);
			else res += '*';
		}
		return res;
	}
	
	/**
	 * <pre>
	 * 0 ~ (num-1) ������ ������ ���� �����ϴ� �޼���
	 * </pre>
	 * @see java.util.Random#nextInt(10) 
	 * @param num ������ ������ ����
	 * @return ����� ����
	 */
	public static int getRandomNo(int num) {
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		int no = extractNo.nextInt(num);
		return no;
	}

	/**
	 * <pre>
	 * ���ȹ��� �߱� �޼���
	 * </pre>
	 * @see java.lang.StringBuilder#append()
	 * @param len ���ڿ��� ����
	 * @return len�ڸ� ���ȹ���
	}
	 */
	public static String secureNum(int len) {
		StringBuilder str = new StringBuilder();

		for(int i = 0; i < len; i++) {
			switch(getRandomNo(3)) {
			case 0:
				str.append(getRandomNo(10));
				break;
			case 1:
				str.append((char)(getRandomNo(26) + 'A'));
				break;
			case 2:
				str.append((char)(getRandomNo(26) + 'a'));
				break;
			}
		}
		return str.toString();
	}
}
