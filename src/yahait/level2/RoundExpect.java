package src.yahait.level2;

import java.util.ArrayList;
import java.util.List;

//예상 대진표
// return Integer.toBinaryString((a-1)^(b-1)).length(); 생각도 못한 답.
public class RoundExpect {
	public static void main(String[] args){
		RoundExpect obj = new RoundExpect();
//		System.out.println(obj.solution(8, 4, 7));
		System.out.println(s(8,4,7));
		System.out.println(Integer.toBinaryString(3));
		System.out.println(Integer.toBinaryString(6));
	}
	
	public static int s(int n , int a, int b){
		return Integer.toBinaryString((a-1)^(b-1)).length();
	}
	
	public int solution(int n, int a, int b){
        int answer = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
        	list.add(i+1);
        }
        int index = 1;
        List<Integer> temp = new ArrayList<>();
        while(list.size() > 1){
        	if(index >= n){
        		list.clear();
        		list.addAll(temp);
        		System.out.println(list);
        		System.out.println(a+"/"+b);
        		temp.clear();
        		index = 1;
        		n /= 2;
        		answer++;
        	}else if(a == index && a+1 == b){
        		break;
        	}else if(b == index && b+1 == a ){
        		break;
        	}else{
        		if(index == a || index+1 == a){
        			a = temp.size()+1;
        		}else if(index == b || index+1 == b){
        			b = temp.size()+1;
        		}
        		temp.add(temp.size()+1);
        		index += 2;
        	}
        }

        return answer;
    }
}
