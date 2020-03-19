package yahait.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//실패율
public class FailureRate {
	public static void main(String[] args){
		FailureRate obj = new FailureRate();
		int[] a = obj.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
		for(int b : a){
			System.out.println(b);
		}
	}
	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<String> list = new ArrayList<>(); 
        int index = 1;
        int count = 0;
        double temp1 = 0;
        double temp2 = 0;
        for(int i=0; i<N; i++){
        	for(int j=0; j<stages.length; j++){
        		if(index == stages[j]){
        			answer[i]++;
        		}
        		if(index <= stages[j]){
        			count++;
        		}
        	}
        	temp1 = (double)answer[i]/count;
        	int size = list.size();
        	if(size>0){
        		for(int j=0; j<size; j++){
        			temp2 = Double.valueOf(list.get(j).split(",")[1]);
        			if(temp2 < temp1){
        				list.add(j, (i+1)+","+temp1);
        				break;
        			}
            	}
        		if(size == list.size()){
        			list.add((i+1)+","+temp1);
        		}
        	}else{
        		list.add((i+1)+","+temp1);
        	}
        	index++;
        	count=0;
        }
        index = 0;
        for(String str : list){
        	answer[index] = Integer.valueOf(str.split(",")[0]);
        	index++;
        }
        return answer;
    }
}
