package src.yahait.level2;
//숫자으 표현
public class ExpressNumber {
	public int solution(int n) {
	      int answer = 0;
	      int sum = 0;
	      int j = 0;
	      for(int i=1; i<=n; i++){
	          if(i==n){
	              answer++;
	              break;
	          }
	          sum = i;

	          for(j=i+1; j<n && i<j; j++){
	              if(sum + j <= n){
	                  sum += j;
	              }else if(sum == n){
	                  answer++;
	                  break;
	              }else{
	                  break;
	              }
	          }
	      }
	      return answer;
	  }
}
