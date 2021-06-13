
package util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * 모든 클래스에서 사용하기 위한 공통 메서드 구현 클래스
 * </pre>
 * @author Hyunsoo Kim
 * @version ver.1.0
 * @since jdk1.8
 */
public class Utility {

	/**
	 * <pre>
	 * 현재 날짜 반환 메서드
	 * </pre>
	 * @see java.util.SimpleDateFormat
	 * @return 현재날짜 문자열
	 */
	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(new Date());
	}
	
	/**
	 * <pre>
	 * 아규먼트로 받은 정수형 숫자를 천단위마다 컴마표기 문자열 반환 메서드
	 * </pre>
	 * @see java.text.NumberFormat
	 * @param num 입력받은 정수
	 * @return 컴마가 표기된 문자열
	 */
	public static String putComma(int num) {
		NumberFormat nf = NumberFormat.getInstance();
		return nf.format(num);
	}
	
	/**
	 * <pre>
	 * 아규먼트로 문자열, 길이를 받아서 해당 자리수만 보여주고 나머지는 * 기호로 대체 변환한 문자열 반환 메서드
	 * </pre>
	 * @param str 입력받은 문자열
	 * @param len 보여줄 자리수
	 * @return 앞의 len 자리 제외 *로 대체한 문자열
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
	 * 0 ~ (num-1) 사이의 임의의 숫자 추출하는 메서드
	 * </pre>
	 * @see java.util.Random#nextInt(10) 
	 * @param num 추출할 난수의 범위
	 * @return 추출된 정수
	 */
	public static int getRandomNo(int num) {
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		int no = extractNo.nextInt(num);
		return no;
	}

	/**
	 * <pre>
	 * 보안문자 발급 메서드
	 * </pre>
	 * @see java.lang.StringBuilder#append()
	 * @param len 문자열의 길이
	 * @return len자리 보안문자
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
