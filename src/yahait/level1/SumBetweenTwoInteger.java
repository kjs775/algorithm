package src.yahait.level1;
//두 정수 사이의 합
public class SumBetweenTwoInteger {
	public static void main(String[] args){
		SumBetweenTwoInteger obj = new SumBetweenTwoInteger();
		int a=3;
		int b=3;
		long answer = obj.solution(a, b);
		System.out.println(answer);
	}
	public long solution(int a, int b) {
	      long answer = 0;
	      if(a == b){
	    	  answer = a;
	    	  return answer;
	      }else if(a > b){
	    	  for(int i=b; i<=a; i++){
	    		  answer +=i;
	    	  }
	      }else{
	    	  for(int i=a; i<=b; i++){
	    		  answer +=i;
	    	  }
	      }
	      return answer;
	  }
}
