package yahait.level2;

	import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//소수찾기
public class SearchSosu {
	public static void main(String[] args){
		SearchSosu obj = new SearchSosu();
		
		System.out.println(obj.solution("7843"));
	}
	
	public int solution(String numbers) {
        int answer = 0;
        char[] arr = numbers.toCharArray();
        Arrays.sort(arr);
        String max = "";
        for(int i=arr.length-1; i>=0 ;i--){
        	max += arr[i];
        }
        StringBuilder sb = null;
        String temp="";
        String[] temps = null;
        
        boolean[] visited = new boolean[Integer.valueOf(max)+1];
        
        for(int i=2; i<=Integer.valueOf(max); i++){
        	if(visited[i] == true){
        		continue;
        	}
        	
        	for(int j=i*2; j<=Integer.valueOf(max); j+=i){
        		visited[j] = true;
        	}
        	
        	sb = new StringBuilder(numbers);
        	temp = String.valueOf(i);
        	temps = temp.split("");
        	
        	boolean possible = true;
        	for(int m=0; m<temps.length; m++){
        		if(sb.indexOf(temps[m]) == -1){
        			possible = false;
            		break;
            	}else{
            		sb.deleteCharAt(sb.indexOf(temps[m]));
            	}
    		}
        	if(!possible){
        		continue;
        	}
        	if(numbers.length() - sb.length() != temps.length){
        		continue;
        	}
        	System.out.println(i);
        	answer++;
        }
        
        return answer;
    }
	
	public boolean isPossible(int number, List<Integer> list){
		for(int i=0; i<list.size(); i++){
			if(number%list.get(i)==0){
				return false;
			}
		}
		return true;
	}
}
