package yahait.level3;

public class ExplainN {
	static int[] dp = new int[9];
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args){
		ExplainN obj = new ExplainN();
		obj.solution(5, 12);
		System.out.println(answer);
	}
	
	public int solution(int N, int number) {
		for(int i=1; i<=8; i++){
			dp[i] = Integer.parseInt(Integer.toBinaryString((int) Math.pow(2, i) - 1)) * N;
		}
		dfs(0,0,number);
		if(answer >8){
			answer = -1;
		}
		return answer;
	}
	
	public void dfs(int count, int num, int number){
		if(count > 8){
			return ;
		}
		if(num == number){
			if (count < answer || answer == -1) {
				answer = count;
		    }
			return;
		}
		for(int i=1; i<=8; i++){
			int N = dp[i];
			dfs(count+i, num+N, number);
			dfs(count+i, num-N, number);
			dfs(count+i, num*N, number);
			dfs(count+i, num/N, number);
		}
	}
}
