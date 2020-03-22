package src.yahait.level2;
//카펫
public class Carpet {
	
	public static void main(String[] args){
		Carpet obj = new Carpet();
		int[] a = obj.solution(16,1);
		System.out.println(a[0] + "," + a[1]);
	}
	
	public int[] solution(int brown, int red) {
		int width = 0;
        int height = 0;
        int[] answer = new int[2];
        
        for(int i=1; i<=red/2+1; i++) {
            width = i;            
            height = (red%i==0) ? red/i:red/i+1;
            if(2*width + 2*height + 4 == brown) {
            	answer[0] = Math.max(width, height)+2;
            	answer[1] = Math.min(width, height)+2;    	
            	break;
            }
        }
        
        return answer;
    }
}
