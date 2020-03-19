package yahait.level3;

public class Network {
	public static void main(String[] args){
		Network obj = new Network();
		int[][] computers1 = new int[][] {{1,1,1}, {1,1,1}, {1,1,1}};
		int[][] computers2 = new int[][] {{1,1,1,0,0,0}, {0,1,0,1,0,0}, {0,0,1,0,0,0}, {0,0,0,1,0,0}, {0,0,0,0,1,0}, {0,0,0,0,0,1}};
		int[][] computers3 = new int[][] {{1,1,0,1}, {1,1,0,1}, {0,0,1,0}, {1,1,0,1}};
		int answer = obj.solution(3, computers1	);
		System.out.println(answer);
	}
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        answer = dfs(0,0, computers, new boolean[n][n], n, 0);        
        return answer;
    }
	
	public int dfs(int x, int y, int[][] computers, boolean[][] visited, int n, int cnt){
		if(x > n){
			return cnt;
		}
		for(int i=0; i<n; i++){
			if(x+i < n){
				if( x != y && computers[y][x+i] == 1 && visited[y][x] == false){
					visited[y][x] = true;
					cnt++;
					cnt = dfs(0, x+i, computers, visited, n, cnt);
				}
			}
		}
		
		return cnt;
	}
}
