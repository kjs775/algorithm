package yahait.level2;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class NextBiggerNumber {
	
	public static void main(String[] args){
		NextBiggerNumber obj = new NextBiggerNumber();
		System.out.println(15>>2);
//		obj.solution(78);
	}
	
	public int solution(int n) {
		int answer = 0;
		int temp = n;
		int count1 = 0, count2 = 0;//count1은 n을 2진수로 변환했을 때 1읠 개수
		StringBuilder binary = new StringBuilder();
		String remainder = "";
		while(temp > 0){
			remainder = String.valueOf(temp%2);
			if(remainder.equals("1")){
				count1++;
			}
			temp = temp/2;
		}
		
		temp = n+1;
		answer = temp;
		while(true){
			remainder = String.valueOf(temp%2);
			System.out.println(temp+"/"+remainder);
			if(remainder.equals("1")){
				count2++;
			}
			temp = temp/2;
			if(temp == 0){
				if(count1 == count2){
					break;
				}else{
					count2 = 0;
					temp=answer+1;
					answer = temp;
				}
			}
		}
		
		return answer;
	}
	
}
