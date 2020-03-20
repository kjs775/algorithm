package src.yahait.level1;

import java.util.ArrayList;
import java.util.List;

public class HateSameNumber {
	public static void main(String[] args){
		HateSameNumber obj = new HateSameNumber();
		int[] arr ={1,1,3,3,0,1,1};
		int[] answer = obj.solution(arr);
		for(int i=0; i<answer.length; i++){
			System.out.println(answer[i]);
		}
	}
	public int[] solution(int[] arr){
		int[] answer = {};
		List<Integer> list = new ArrayList<Integer>();
		
		int now = arr[0];
		list.add(now);
		
		for(int i=1; i<arr.length; i++){
			if(now == arr[i]){
				;
			}else{
				now = arr[i];
				list.add(now);
			}
		}
		
		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			answer[i] = list.get(i);
		}
		return answer;
	}
}
