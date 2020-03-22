package src.yahait.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//구명보트
public class LifeBoat {
	public static void main(String[] args){
		LifeBoat obj = new LifeBoat();
		System.out.println(obj.solution(new int[]{70, 50, 80, 50}, 100));
	}
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
        int answer = 0;
        int num1 = 0;
        int num2 = 0;
        int j = 0;
        for(int i=people.length-1; i>=0; i--){
        	num1 = people[i];
    		num2 = people[j];
    		if(j!=i){
    			if(num1 + num2 <= limit){
    				people[j] = limit+1;
            		people[i] = limit+1;
            		j++;
            		answer++;
    			}
    		}else{
    			break;
    		}
        }
        
        for(int i=0; i<people.length; i++){
        	if(people[i] != limit+1){
        		answer++;
        	}
        }
        return answer;
    }
}
