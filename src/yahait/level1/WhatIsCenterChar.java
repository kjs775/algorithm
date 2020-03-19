package yahait.level1;

public class WhatIsCenterChar {
	public static void main(String[] args){
		String str = "abcde";
		WhatIsCenterChar obj = new WhatIsCenterChar();
		str = obj.solution(str);
		System.out.println(str);
	}
	
	String solution(String s) {
	    String answer = "";
	    int center = s.length()/2;
	    if(s.length()%2 == 0){
	    	answer = s.substring(center-1, center+1);
	    }else{
	    	answer = s.substring(center, center+1);
	    }
	    return answer;
	}
}
