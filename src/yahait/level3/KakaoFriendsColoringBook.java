package yahait.level3;

import java.util.Stack;

public class KakaoFriendsColoringBook {
	int M;
	int N;
	int[] arr = new int[M*N];
	public static void main(String[] args){
		KakaoFriendsColoringBook obj = new KakaoFriendsColoringBook();
		int[] arr = obj.solution1(6, 4, new int[][] { {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, 
			{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}} );
		
		for(int i=0; i<2; i++){
			System.out.println(arr[i]);
		}
	}
	public int[] solution1(int m, int n, int[][] picture) {
		boolean[][] visited = new boolean[m][n];
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		Stack<Integer> stackX = new Stack<>();
		Stack<Integer> stackY = new Stack<>();
		int count = 0;
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				count = 0;
				if(picture[i][j] != 0 && visited[i][j] == false){
					stackX.add(j);
					stackY.add(i);
					count ++;
					visited[i][j] = true;
					answer[0]++;
					
					while(!stackX.isEmpty()){
						int x = stackX.pop();
						int y = stackY.pop();
						if(x < n-1 && picture[i][j] == picture[y][x+1] && visited[y][x+1] == false){
							stackX.add(x+1);
							stackY.add(y);
							count++;
							visited[y][x+1] = true;
						}
						if(x>0 && picture[i][j] == picture[y][x-1] && visited[y][x-1] == false){
							stackX.add(x-1);
							stackY.add(y);
							count++;
							visited[y][x-1] = true;
						}
						if(y < m-1 && picture[i][j] == picture[y+1][x] && visited[y+1][x] == false){
							stackX.add(x);
							stackY.add(y+1);
							count++;
							visited[y+1][x] = true;
						}
						if(y > 0 && picture[i][j] == picture[y-1][x] && visited[y-1][x] == false){
							stackX.add(x);
							stackY.add(y-1);
							count++;
							visited[y-1][x] = true;
						}
					}
					
					if(answer[1] < count){
						answer[1] = count;
					}
				}
			}
		}
		
		
		return answer;
	}
	int maxX;
	int maxY;
	int count=0;
	int maxSizeOfOneArea;
	int numberOfArea;
	/*
	public int[] solution2(int m, int n, int[][] picture) {
		maxX = n;
		maxY = m;
		int[] answer = new int[2];
		bfs(0,0, picture, new boolean[maxY][maxX], picture[0][0]);
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
	
		return answer;
	}*/
	
	
	/*public void bfs(int x, int y, int[][]picture, boolean[][] visited, int beforeNum){
		
		if(x < 0 || y < 0 ){
			return;
		}else if(x >= maxX || y >= maxY){
			return;
		}else if(visited[y][x] == true){
			return;
		}
		else if(picture[y][x] == beforeNum){
			count++;
			visited[y][x] = true;
		}
		
		bfs(x+1, y, picture, visited, picture[y][x]);
		bfs(x-1, y, picture, visited, picture[y][x]);
		bfs(x, y+1, picture, visited, picture[y][x]);
		bfs(x, y-1, picture, visited, picture[y][x]);
		
		if(maxSizeOfOneArea < count){
			maxSizeOfOneArea = count;
		}
		numberOfArea++;
		count = 0;
	}*/
}
