package yahait.level2;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassBridge {
	public static void main(String[] args){
		TruckPassBridge obj = new TruckPassBridge();
		int a = obj.solution(2, 10, new int[]{7,4,5,6,});
		System.out.println(a);
	}
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0;
        int time = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
        	if(que.size() == 0){
        		que.add(truck_weights[i]);
        		currentWeight = truck_weights[i];
        		time++;
        	}else if(time > 0){
        		if(currentWeight+truck_weights[i] <= weight){
        			que.add(truck_weights[i]);
        			currentWeight += truck_weights[i];
        		}
        		time++;
        	}else{
        		que.add(truck_weights[i]);
        	}
        	
        	if(time == bridge_length){
        		answer += time;
        		time = 0;
        		que.remove();
        	}
        }
        return answer;
    }
}
