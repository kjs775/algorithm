package src.yahait.level2;

//단체사진 찍기
public class TakePictureWithKakaoFriends {
	static int num = 0;
	public static void main(String[] args) {
		TakePictureWithKakaoFriends obj = new TakePictureWithKakaoFriends();
		System.out.println(obj.solution(2, new String[]{"N~F=0", "R~T>2"}));
	}

	static int count = 0;
	static int[] dp = new int[8];
	static boolean[] check = new boolean[8];
	public int solution(int n, String[] data) {
		int answer = 0;
		dfs(0,data);
		answer = count;
		return answer;
	}
	
	public void dfs(int location,String[] data){
		if(location == 8){
			if(!check(data)){
				return;
			}
			count++;
			return;
		}
		
		for(int i=0; i<8; i++){
			if(!check[i]){
				check[i] = true;
				dp[location] = i;
				dfs(location+1, data);
				check[i] = false;
			}
		}
	}

	public static boolean check(String[] data){
		for (int k = 0; k < data.length; k++) {
			char var1 = data[k].charAt(0);
			char var2 = data[k].charAt(2);
			int temp = Math.abs(dp[getKakao(var1)] - dp[getKakao(var2)])-1;
			char condition = data[k].charAt(3);
			int distance = data[k].charAt(4) - '0';
			if (condition == '=') {
				if (temp != distance) {
					return false	;
				}
			} else if (condition == '>') {
				if (temp <= distance) {
					return false;
				}
			} else if (condition == '<'){
				if (temp >= distance) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static int getKakao(char var) {
		switch (var) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'F':
			return 2;
		case 'J':
			return 3;
		case 'M':
			return 4;
		case 'N':
			return 5;
		case 'R':
			return 6;
		case 'T':
			return 7;
		}
		return -1;
	}
}
