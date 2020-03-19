package yahait.level1;

public class MakingStrangeString {
	public static void main(String[] args){
		MakingStrangeString obj = new MakingStrangeString();
		String str = obj.solution("try hello world");
		System.out.println(str);
	}
	public String solution(String s) {
		String answer = "";
		String[] arr = s.split(" ",-1);
		for (int i = 0; i < arr.length; i++) {
			char[] arrChar = arr[i].toCharArray();
			
			for (int j = 0; j < arrChar.length; j++) {
				if (j % 2 == 0) {
					
					if(arrChar[j] >= 'a' && arrChar[j] <='z'){
						arrChar[j] -= 32;
					}
					
				}else {
					
					if(arrChar[j] >='A' && arrChar[j] <='Z'){
						arrChar[j] += 32;
					}
					
				}
			}
			
			for(int j=0; j<arrChar.length; j++){
				answer += arrChar[j];
				
			}
			if(i < arr.length-1){
				answer += " ";
			}
		}
		return answer;
	}
}