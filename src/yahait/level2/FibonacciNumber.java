package src.yahait.level2;

//피보나치 수
public class FibonacciNumber {
	public int solution(int n) {
		int answer = 0;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		if (n <= 3) {
			return dp[n];
		}
		for (int i = 4; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		return dp[n];
	}
}
