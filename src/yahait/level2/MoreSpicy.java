package yahait.level2;

import java.util.Arrays;
import java.util.PriorityQueue;

// 더 맵게
// 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
public class MoreSpicy {
	public static void main(String[] args){
		MoreSpicy obj = new MoreSpicy();
		System.out.println(obj.solution(new int[]{1, 1, 1, 1}, 20));
	}
	public int solution(int[] scoville, int k) {
        int answer = 0;
        Arrays.sort(scoville);
        int obj1 = 0;
        int obj2 = 0;
        int sum = 0;
        int i = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        
        for(int j=0; j<scoville.length; j++){
        	heap.offer(scoville[j]);
        }
        
        for(; i<scoville.length; i++){
        	if(heap.size() == 1){
        		break;
        	}
        	if(heap.peek() < k){
        		answer++;
        		obj1 = heap.poll();
            	obj2 = heap.poll();
            	sum = obj1 + (obj2*2);
            	heap.offer(sum);
        	}else{
        		break;
        	}
        }
        if(heap.peek() < k){
        	return -1;
        }
        return answer;
    }
}
