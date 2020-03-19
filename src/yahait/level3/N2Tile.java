package yahait.level3;

public class N2Tile {
	static final int DIV_NUM= 1000000007;
	public static void main(String[] args){
		
	}
	public int solution(int n) {
		int answer = 0;
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 5;
		for(int i=5; i<=n; i++){
			arr[i] = (arr[i-2] + arr[i-1])%DIV_NUM;
		}
		answer = arr[n];
		return answer;
	}
	
	// n == 2 / answer == 2
	// n == 3 / anawer == 3
	// n == 4 / answer == 5
	// n == 5 / 
	// n = (n-2) + (n-1)
}
