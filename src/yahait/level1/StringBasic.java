package src.yahait.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBasic {
	public static void main(String[] args){
		StringBasic obj = new StringBasic();
		String s = "a234";
		boolean answer = obj.solution(s);
		System.out.println(answer);
	}
	public boolean solution(String s) {
	      boolean answer = false;
	      if(s.length() >= 4 && s.length()<=6){
	    	  Pattern pattern = Pattern.compile("^[0-9]*$");
	    	  Matcher matcher = pattern.matcher(s);
	    	  if( matcher.find()){
	    		  answer = true;
	    	  }
	      }
	      return answer;
	  }
}
