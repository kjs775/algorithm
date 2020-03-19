package yahait.level2;

import java.util.Arrays;

public class CommonMultiple {

	public static void main(String[] args) {
		CommonMultiple obj = new CommonMultiple();
		int a = obj.solution(new int[]{60,48,40});
		System.out.println(a);
	}

	public int solution(int[] arr) {
		Arrays.sort(arr);
		int answer = arr[0];
		int temp = 0;
		for(int i=1; i<arr.length; i++){
			if(Math.max(answer, arr[i])%Math.min(answer, arr[i])== 0){
				answer = Math.max(answer, arr[i]);
			}else{
				temp = 2;
				int pre = answer;
				answer = 1;
				while(temp < arr[i]/2+1){
					if(arr[i]%temp==0 && pre%temp==0){
						arr[i] /= temp;
						pre /= temp;
						answer *= temp;
					}else{
						temp++;
					}
				}
				answer = arr[i]*pre*answer;
			}
		}
		return answer;
	}
	
}
