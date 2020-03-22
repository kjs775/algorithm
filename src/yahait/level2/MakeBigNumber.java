package src.yahait.level2;

import java.util.Arrays;

//큰수 만들기
public class MakeBigNumber {
	
	public static void main(String[] args){
		MakeBigNumber obj = new MakeBigNumber();
		String answer = obj.solution("11110", 3);
		System.out.println(answer);
	}
	
	public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int index = 1;
        int deleteCount = 0;
        
        while(deleteCount != k){
        	if(index >= 1 && sb.charAt(index) > sb.charAt(index-1)){
        		sb.deleteCharAt(index-1);
        		index--;
        		deleteCount++;
        	}else{
        		if(index == sb.length()-1 && sb.charAt(index) <= sb.charAt(index-1)){
        			sb.deleteCharAt(index);
            		index--;
            		deleteCount++;
        		}else{
        			index++;
        		}
        	}
        }
        
        return sb.toString();
    }
}	
