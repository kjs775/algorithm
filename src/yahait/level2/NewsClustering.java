package yahait.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NewsClustering {
	public static void main(String[] args){
		NewsClustering obj = new NewsClustering();
		int a = obj.solution("E=M*C^2", "e=m*c^2");
		System.out.println(a);
	}
	public int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		int answer = 0;
		Map<String, Integer> a = makeElement(str1);
		Map<String, Integer> b = makeElement(str2);
		List<String> union = union(a, b);
		List<String> intersection = intersection(a, b);
		if(union.size() == 0 && intersection.size() == 0){
			answer = 65536;
		}else{
			answer = (int)(intersection.size()/(double)union.size()*65536);
		}
		return answer;
	}
	
	public static Map<String,Integer> makeElement(String str){
		Map<String, Integer> a = new HashMap<String, Integer>();
		String element = "";
		int value = 0;
		for(int i=0; i<str.length()-1; i++){
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				if(str.charAt(i+1) >= 'A' && str.charAt(i+1) <= 'Z'){
					element = str.substring(i,i+2);
					if(a.containsKey(element)){
						value = a.get(element)+1;
						a.replace(element, value);
					}else{
						a.put(element, 1);
					}
				}else{
					i++;
				}
			}
		}
		return a;
	}
	
	public static List<String> union(Map<String,Integer> a, Map<String,Integer> b ){
		Iterator<String> aKeys = a.keySet().iterator();
		Iterator<String> bKeys = b.keySet().iterator();
		List<String> list = new ArrayList<>();
		while(aKeys.hasNext()){
			String aKey = aKeys.next();
			if(b.containsKey(aKey)){
				if(b.get(aKey) > a.get(aKey)){
					for(int i=0; i<b.get(aKey); i++){
						list.add(aKey);
					}
				}else{
					for(int i=0; i<a.get(aKey); i++){
						list.add(aKey);
					}
				}
			}else{
				for(int i=0; i<a.get(aKey); i++){
					list.add(aKey);
				}
			}
		}
		while(bKeys.hasNext()){
			String bKey = bKeys.next();
			if(!list.contains(bKey)){
				for(int i=0; i<b.get(bKey); i++){
					list.add(bKey);
				}
			}
		}
		return list;
	}

	public static List<String> intersection(Map<String,Integer> a, Map<String,Integer> b){
		Iterator<String> aKeys = a.keySet().iterator();
		List<String> list = new ArrayList<>();
		while(aKeys.hasNext()){
			String aKey = aKeys.next();
			if(b.containsKey(aKey)){
				if(b.get(aKey) > a.get(aKey)){
					for(int i=0; i<a.get(aKey); i++){
						list.add(aKey);
					}
				}else{
					for(int i=0; i<b.get(aKey); i++){
						list.add(aKey);
					}
				}
			}
		}
		
		return list;
	}
}
