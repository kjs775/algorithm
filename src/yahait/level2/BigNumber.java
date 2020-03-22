package src.yahait.level2;

import java.util.Arrays;
import java.util.Comparator;

//가장 큰 수
public class BigNumber {
	
	public static void main(String[] args){
		BigNumber obj = new BigNumber();
		int[] numbers = new int[]{1,1,111,2};
		StringBuilder sb1 = new StringBuilder(obj.solution(numbers));
		System.out.println(sb1);
	}
	public String solution(int[] numbers) {
		String answer = "";
		String[] arr = new String[numbers.length];
		for(int i=0; i<numbers.length; i++){
			arr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(arr,new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2);
			}
		});
		
		if(arr[0].equals("0")){
			return "0";
		}
		for(int i=0; i<numbers.length; i++){
			answer += arr[i] ;
		}
        return answer;
    }
}
