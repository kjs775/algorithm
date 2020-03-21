package src.yahait.level1;

public class Collaz {
	static int num;
	public static void main(String[] args){
		Collaz obj = new Collaz();
		int answer = obj.solution(626331);
		System.out.println(answer);
	}
	public int solution(long num) {
		int answer = 0;
		while (num != 1) {
			answer++;
			if (answer >= 500) {
				return -1;
			}
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = num * 3 + 1;
			}
			
		}
		return answer;
	}
}
