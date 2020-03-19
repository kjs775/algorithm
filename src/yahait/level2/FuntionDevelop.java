package yahait.level2;

import java.util.ArrayList;
import java.util.List;

public class FuntionDevelop {
	
	public static void main(String[] args){
		FuntionDevelop obj = new FuntionDevelop();
		int[] a = obj.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
		for(int n: a)
			System.out.println(n);
		String[] str = new String[1];
		
	}
	
	public int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        
        int dayCount = 1;
    	for(int i=0; i<speeds.length; i++){
    		if( (100 - progresses[i])%speeds[i] == 0 ){
    			temp[i] = (100-progresses[i])/speeds[i];
    		}else{
    			temp[i] = (100-progresses[i])/speeds[i]+1;
    		}
    	}
    	
    	int max = temp[0];
  
    	for(int i=1; i<temp.length; i++){
    		if(max >= temp[i]){
    			dayCount++;
    		}else{
    			max = temp[i];
    			list.add(dayCount);
    			dayCount=1;
    		}
    	}
    	list.add(dayCount);
    	
    	int[] answer = new int[list.size()];
    	for(int i=0; i<list.size(); i++){
    		answer[i] = list.get(i);
    	}
        return answer;
    }
}
