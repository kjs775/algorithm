package src.yahait.level2;

import java.util.Arrays;

//최솟값 만들기
public class MakeMinNumber {
	public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for(int i=0, j=A.length-1; i<A.length; i++, j--){
            answer += A[i] *B[j];
        }

        return answer;
    }
}
