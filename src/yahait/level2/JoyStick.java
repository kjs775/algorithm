package yahait.level2;

//조이스틱
public class JoyStick {

	public static void main(String[] args) {
		String name = "AAABAAAA";
		JoyStick obj = new JoyStick();
		System.out.println("\n"+obj.solution(name));
	}

	public int solution(String name) {
			int[] h = new int[name.length()];// 좌우
			int[] v = new int[name.length()];// 상하 알파벳찾기
			int max = name.length() / 2;
			int index = 1;
			int pointer = -1;
			for (int i = 0; i <= max; i++) {
				h[i] = i;
				v[i] = searchAlpha(name.charAt(i));
			}
	
			for (int i = name.length() - 1; i > max; i--) {
				h[i] = index;
				v[i] = searchAlpha(name.charAt(i));
				index++;
			}
			
			int leftVSum = 0;
			int leftHSum = 0;
			for (int i = max; i >= 0; i--) {
				
				if (v[i] != 0) {
					leftVSum += v[i];
					if(pointer == -1){
						pointer = i;
						leftHSum = h[i];
					}
				}
			}
	
			int rightHSum = 0;
			int rightVSum = 0;
			int rightPointer = 0;
			for (int i = max + 1; i < name.length(); i++) {
				if (v[i] != 0) {
					rightVSum += v[i];
					if(rightHSum == 0){
						rightHSum = h[i];
						rightPointer = i;
					}
				}
			}
			
			int sum = rightHSum + leftHSum > name.length()-1 ? name.length()-1 :rightHSum + leftHSum;
			System.out.println(sum + "/" + leftVSum + "/" +rightVSum);
			
			if(sum != name.length() -1){
				if(leftHSum < max && pointer != -1 && rightPointer != 0){
					if(pointer <= rightPointer - pointer ){
						sum += pointer;
					}else if( pointer != -1){
						sum += rightPointer - pointer;
					}
				}
			}
			System.out.println(sum);
			return leftVSum + rightVSum + sum;
	}

	public int searchAlpha(char alpha) {
		int temp = alpha - 'A' > 'Z' - alpha + 1 ? 'Z' - alpha +1 : alpha - 'A';
		if(temp != 0)
		System.out.println(alpha+"/"+temp);
		
		return temp;
	}
}
