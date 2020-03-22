package src.yahait.level2;
//탑
public class Top {
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];

		for (int i = 0; i < heights.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}

		return answer;
	}
}
