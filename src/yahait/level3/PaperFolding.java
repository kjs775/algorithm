package yahait.level3;

public class PaperFolding {
	public static void main(String[] args){
		PaperFolding pf = new PaperFolding();
		int[] solve = pf.solution(3);
		for(int i=0; i<solve.length; i++){
			System.out.print(solve[i]+" ");
		}
	}
	public int[] solution(int n) {
	      if(n == 1){
	          return new int[]{0};
	      }

	      int[] precase = {0};
	      int[] testcase = null;
	      
	      for(int i=2; i<=n; i++){
	    	  testcase = new int[precase.length*2+1];
	          int j=0;
	          for(j=0; j<precase.length; j++ ){
	             testcase[j] = precase[j];
	          }
	          testcase[j] = 0;
	          int k= 0;
	          j++;
	          for(k=precase.length-1 ; k>=0 && j<testcase.length; k--,j++){
	              if(precase[k] == 0){
	                  testcase[j] = 1;
	              }else{
	                  testcase[j] = 0;
	              }
	          }
	          precase = testcase;
	      }
	      return testcase;
	  }
}