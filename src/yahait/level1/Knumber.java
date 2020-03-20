package yahait.level1;

import java.util.Arrays;

public class Knumber {
	public static void main(String[] args){
		int[] arr = solution(new int[]{1,5,2,6,3,7,4},
				new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);
		}
	}
    public static int[] solution(int[] array, int[][] commands) {
    	int startIdx = 0;
    	int endIdx = 0;
    	int KNum = 0;
    	int[] answer = new int[commands.length];
    	int answerCnt= 0;
        for(int i=0; i<commands.length; i++){
        	startIdx = commands[i][0];
        	endIdx = commands[i][1];
        	KNum = commands[i][2];
        	
        	int[] arr = new int[endIdx - startIdx +1];
        	int arrCnt = 0;
        	
        	for(int j=startIdx-1; j<=endIdx-1; j++){
        		arr[arrCnt++] = array[j];
        	}
        	
        	Arrays.sort(arr);
        	answer[answerCnt++] = arr[KNum-1];
        }
        return answer;
    }
}
