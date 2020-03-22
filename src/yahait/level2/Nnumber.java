package src.yahait.level2;

//[3차] n진수 게임
public class Nnumber {
	public static void main(String[] args) {
		Nnumber obj = new Nnumber();
		System.out.println(obj.solution(16, 16, 2, 1));
	}

	public String solution(int n, int t, int m, int p) {
		// 10진수 이하는 0 ~ 진수 -1 까지
		// 11진수 이상은 [10 - > A], [11 -> B], [12 -> C], [13 -> D], [14 -> E], [15
		// -> F]
		// m=3, p=1 0(나) 1 2 3(나)
		// t*m까지 구하면 됨.
		// 시작 = p-1;
		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		String answer = "";
		int count = 0;
		int temp = 0;
		StringBuilder total = new StringBuilder("0");

		for (int i = 1; i < t * m; i++) {
			StringBuilder tempSb = new StringBuilder();
			temp = i;
			while (temp > 0) {
				tempSb.insert(0, numbers[temp % n]);
				temp = temp / n;
			}
			total.append(tempSb);
		}

		for (int i = p - 1; count < t; count++, i += m) {
			answer += total.charAt(i);
		}

		return answer;
	}

}