package src.yahait.level2;

import java.util.Arrays;
//HIndex
public class HIndex {
	public int solution(int[] citations) {
		int answer = 0;
		int[] dp = new int[citations.length];
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			for (int j = 0; j < citations.length; j++) {
				if (citations[i] <= citations[j]) {
					dp[i]++;
				}
			}
		}
		int max = 0;
		int temp = 0;
		for (int i = 0; i < dp.length; i++) {
			temp = Math.min(dp[i], citations[i]);
			if (max <= temp) {
				max = temp;
			}
		}
		answer = max;
		return answer;
	}
}
