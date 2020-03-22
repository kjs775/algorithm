package src.yahait.level2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//프레즌4블록
public class Friends4Block {
	public static void main(String[] args) {
		Friends4Block obj = new Friends4Block();
		int answer = obj.solution(6, 5, new String[] { 
				"BBBAA", 
				"AAABB",
				"CCAAA",
				"AAAAA",
				"AAABB",
				"CCCAA"});
		System.out.println(answer);
	}
	public static Set<String> list = new HashSet<>();

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		int x = 0;
		int y = 0;
		char[][] board2 = new char[board.length][];
		for(int i=0; i<board.length; i++){
			board2[i] = board[i].toCharArray();
		}
		while(true) {
			for(int i=0; i<m-1; i++){
				for(int j=0; j<n-1; j++){
					if(board2[i][j] == ' '){
						continue;
					}else if(board2[i][j] == board2[i][j+1] && board2[i][j] == board2[i+1][j] && board2[i][j] == board2[i+1][j+1]){
						list.add(i+"/"+j+"/"+board2[i][j]);
					}
				}
			}
			if(list.size() == 0){
				break;
			}
			board2 = dropBlock(board2);
		}
		
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				System.out.print(board2[i][j]);
				if(board2[i][j] == ' '){
					answer++;
				}
			}
			System.out.println();
		}
		return answer;
	}
	
	public char[][] dropBlock(char[][] board){
		Iterator<String> iterator = list.iterator();
		String tempXY = "";
		int x = 0;
		int y = 0;
		char temp = ' ';
		while(iterator.hasNext()){
			tempXY = iterator.next();
			x = Integer.valueOf(tempXY.split("/")[0]);
			y = Integer.valueOf(tempXY.split("/")[1]);
			char pre = tempXY.split("/")[2].charAt(0);
			board[x][y] = ' ';
			if(pre == board[x][y+1]){
				board[x][y+1] = ' ';
			}
			if(pre == board[x+1][y]){
				board[x+1][y] = ' ';
			}
			if(pre == board[x+1][y+1]){
				board[x+1][y+1] = ' ';
			}
		}
		
		int spaceCount = 0;
        for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(board[i][j]==' '){
					x = i;
					for(int k=i+1; k<board.length; k++){
						if(board[k][j] == ' '){
							spaceCount++;
						}
					}
					for(int k=i-1; k>=0; k--, x--){
						if(board[k][j] == ' '){
							break;
						}
						board[x+spaceCount][j] = board[k][j];
						board[k][j] = ' ';
					}
					spaceCount = 0;
				}
			}
		}
		list.clear();
		return board;
	}
}
