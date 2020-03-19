package yahait.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//압축
public class Compression {
	
	public static void main(String[] args){
		Compression obj = new Compression();
		int[] a = obj.solution("TOBEORNOTTOBEORTOBEORNOT");
		for(int b : a){
			System.out.println(b);
		}
	}
	public int[] solution(String msg) {
		int[] answer = {};
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (int i = 0; i < 27; i++) {
			char c = (char)('A' + i);
			hash.put( String.valueOf(c), i + 1 );
		}
		
		List<Integer> list = new ArrayList<>();
		String temp = String.valueOf(msg.charAt(0));
		int count = 27;
		
		for (int i = 1; i < msg.length(); i++) {
			if (hash.containsKey(String.valueOf((temp + msg.charAt(i))))) {
				temp = temp + String.valueOf(msg.charAt(i));
				continue;
			}else {
				list.add(hash.get(temp));
				hash.put(String.valueOf(temp+msg.charAt(i)), count);
				temp = String.valueOf(msg.charAt(i));
				count++;
			}
		}
		list.add(hash.get(temp));
		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++){
			answer[i] = list.get(i);
		}
		return answer;
	}
}
