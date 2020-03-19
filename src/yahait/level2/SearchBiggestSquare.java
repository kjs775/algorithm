package yahait.level2;
//가장 큰 정사각형 찾기
public class SearchBiggestSquare {
	public static void main(String[] args){
		SearchBiggestSquare obj = new SearchBiggestSquare();
		
		int[][] a= new int[][] {
								{0,1,1,1,1,0,0},
								{1,1,1,1,1,0,1},
								{1,1,1,1,1,1,1},
								{0,1,0,1,1,1,1},
								{0,1,1,0,1,0,1},
								{0,1,1,0,1,0,1}
//			{0,0,0,0},
//			{1,1,1,1}
								};

		System.out.println(obj.solution(a));
	}
	
	public int solution(int [][]board){
        int[][] dp = new int[board.length][board[0].length];
        for(int i=0; i<board[0].length; i++){
        	dp[0][i] = board[0][i];
        }
        for(int i=0; i<board.length; i++){
        	dp[i][0] = board[i][0];
        }
        int min=0;
        int up = 0;
        int left = 0;
        int leftUp = 0;
        for(int i=1; i<board.length; i++){
        	for(int j=1; j<board[0].length; j++){
        		up = dp[i-1][j];
        		left = dp[i][j-1];
        		leftUp = dp[i-1][j-1];
        		min = Math.min(up, Math.min(left, leftUp));
        		if(board[i][j] == 1){
    				if(min == 0){
    					dp[i][j] = 1;
    				}else{
    					dp[i][j] = min+1;
						
    				}
        		}
        	}
        }

        int max = 0;
        for(int i=0; i<dp.length; i++){
        	for(int j=0; j<dp[0].length; j++){
        		System.out.print(dp[i][j]+",");
        		if(max < dp[i][j]){
        			max = dp[i][j];
        		}
        	}
        	System.out.println();
        }
        return max*max;
    }
}
