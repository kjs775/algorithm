package src.yahait.level1;

public class PBetweenY {
	public static void main(String[] args){
		PBetweenY obj = new PBetweenY();
		String s = "pyY";
		boolean answer = obj.solution(s);
		System.out.println(answer);
	}
	boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        for(int i=0; i<s.length(); i++){
        	if(s.charAt(i) == 'p' || s.charAt(i) == 'P' ){
        		pCount++;
        	}else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
        		yCount++;
        	}
        }
        
        if(pCount != yCount){
        	answer = false;
        }
        
        return answer;
    }
}
