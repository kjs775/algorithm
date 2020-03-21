package src.yahait.level1;
//시저 암호
public class CaesarCipher {
	public String solution(String s, int n) {
		String answer = "";
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				if (arr[i] + n > 'Z') {
					arr[i] = (char) (64 + ((arr[i] + n) - 'Z'));
				} else {
					arr[i] += n;
				}
			} else if (arr[i] >= 'a' && arr[i] <= 'z') {
				if (arr[i] + n > 'z') {
					arr[i] = (char) (96 + ((arr[i] + n) - 'z'));
				} else {
					arr[i] += n;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		return answer;
	}
}
