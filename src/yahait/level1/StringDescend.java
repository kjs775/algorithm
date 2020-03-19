package yahait.level1;

import java.util.Arrays;

public class StringDescend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringDescend obj = new StringDescend();
		String s = "Zbcdefg";
		String answer = obj.solution(s);
		System.out.println(answer);
	}
	
	public String solution(String s) {
	      String answer = "";
	      char[] arr = s.toCharArray();
	      Arrays.sort(arr);
	      for(int i=arr.length-1; i>-1; i--){
	    	  answer += arr[i];
	      }
	      return answer;
	  }

}
