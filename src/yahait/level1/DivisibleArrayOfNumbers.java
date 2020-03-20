package src.yahait.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//나누어 떨어지는 배열
public class DivisibleArrayOfNumbers {
	public static void main(String[] args){
		DivisibleArrayOfNumbers obj = new DivisibleArrayOfNumbers();
		int[] arr = {3,2,6,};
		int divisor = 10;
		
		int[] solution = obj.solution(arr, divisor);
		for(int i=0; i<solution.length; i++){
			System.out.println(solution[i]);
		}
	}
	
	public int[] solution(int[] arr, int divisor) {
	      int[] answer = {};
	      List<Integer> list = new ArrayList<>();
	      for(int i=0; i<arr.length; i++){
	    	  if(arr[i] % divisor == 0){
	    		  list.add(arr[i]);
	    	  }
	      }
	      if(list.size() == 0){
	    	 answer = new int[1];
	    	 answer[0] = -1;
	    	 return answer;
	      }else{
		      Collections.sort(list);
		      answer = new int[list.size()];
		      for(int i=0; i<list.size(); i++){
		    	  answer[i] = list.get(i);
		      }
	      }
	      
	      return answer;
	  }
}
