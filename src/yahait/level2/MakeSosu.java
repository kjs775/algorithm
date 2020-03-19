package yahait.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//소수만들기
public class MakeSosu {
	public static void main(String[] args) {
		MakeSosu obj = new MakeSosu();
		int a= obj.solution(new int[]{1,2,7,6,4});
		System.out.println(a);
	}
	
	public int solution(int[] nums){
		int answer = 0;
		Arrays.sort(nums);
		int len = nums.length;
		int max = nums[len-1] + nums[len-2] + nums[len-3];
		boolean[] dp = new boolean[max+1];
		boolean check = true;
		dp[2] = dp[3] = true;
		
		for(int i=4; i<=max; i++){
			if(i%2!=0){
				for(int j=3; j<i/2+1; j++){
					if(i%j==0){
						dp[i] = false;
						check = false;
						break;
					}
				}
				if(check){
					dp[i] = true;
				}else{
					check = true;
				}
			}
		}
		
		for(int i=0; i<nums.length-2; i++){
			for(int j=i+1; j<nums.length-1; j++){
				for(int k=j+1; k<nums.length; k++){
					if(dp[nums[i] + nums[j] + nums[k]]){
						answer++;
					}
				
				}
			}
		}
	
		return answer;
	}
}
