package src.yahait.level2;

import java.util.HashMap;
import java.util.Iterator;

//위장
public class Camouflage {
	public static void main(String[] args){
		Camouflage obj = new Camouflage();
		int a = obj.solution(new String[][] {
								{"yellow_hat", "headgear"}, 
								{"blue_sunglasses", "eyewear"}, 
								{"green_turban", "headgear"}
								} );
		System.out.println(a);
	}
	public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        Integer number = null;
        for(int i=0; i<clothes.length; i++){
        	number = hash.get(clothes[i][1]);
        	if(number == null){
        		hash.put(clothes[i][1], 1);
        	}else{
        		hash.put(clothes[i][1], number+1);
        	}
        }
        
        
        Iterator<Integer> iterator = hash.values().iterator();
        int sum = 1;
        while(iterator.hasNext()){
        	sum *= (iterator.next()+1);
        }
        sum--;
        answer = sum;
        return answer;
    }
}
