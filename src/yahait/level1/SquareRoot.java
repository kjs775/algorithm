package yahait.level1;

public class SquareRoot {
	
	public static void main(String[] args){
		SquareRoot obj = new SquareRoot();
		long answer = obj.solution(121);
	}
	
	public long solution(long n) {
		long answer = 0;
		answer = (long) Math.sqrt(n);
		if(answer*answer == n){
			return (answer+1)*(answer+1);
		}else{
			return -1;
		}
	}
}
