package yahait.level1;
//체육복
public class GymCloth {
	 public int solution(int n, int[] lost, int[] reserve){
	        int answer = n - lost.length;
			for (int i = 0; i < lost.length; i++) {

				for (int j = 0; j < reserve.length; j++) {
					if (lost[i] == reserve[j]) {
						answer++;
						reserve[j] = -1;
						lost[i] = -1;
						break;
					}
				}
			}
			for (int i = 0; i < lost.length; i++) {
				for (int j = 0; j < reserve.length; j++) {
					if (reserve[j] == -1) {
						continue;
					} else if ((lost[i] - 1) == reserve[j] || (lost[i] + 1) == reserve[j]) {
						answer++;
						reserve[j] = -1;
						lost[i] = -1;
						break;
					}
				}
			}
			return answer;
	        }
}
