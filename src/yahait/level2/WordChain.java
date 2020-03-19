package yahait.level2;

import java.util.HashSet;
import java.util.Set;

public class WordChain {
	
	public static void main(String[] args){
		WordChain obj = new WordChain();
		int[] a = obj.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
		for(int i=0; i<2; i++){
			System.out.print(a[i]+",");
		}
		
	}
	
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int[] people = new int[n+1];
		int index = 1;
		Set<String> set = new HashSet<>();
		set.add(words[0]);
		people[1] = 1;
		for(int i=1; i<words.length; i++){
			index = index+1 > n ? 1 : index+1;
			people[index]++;
			if(set.contains(words[i]) || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)){
				answer[0] = index;
				answer[1] = people[index];
				break;
			}else{
				set.add(words[i]);
			}
		}
		return answer;
	}
}
