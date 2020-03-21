package src.yahait.level1;
//문자열 내림차순으로 배치하기.
import java.util.Arrays;

public class StringDescending {
	public String solution(String s) {
		String answer = "";
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		for (int i = arr.length - 1; i > -1; i--) {
			answer += arr[i];
		}
		return answer;
	}
}
