package src.yahait.level2;

import java.util.HashSet;

//포켓몬
public class Poketmon {
	public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        if(set.size() < nums.length/2){
            return set.size();
        }
        return nums.length/2;
    }
}
