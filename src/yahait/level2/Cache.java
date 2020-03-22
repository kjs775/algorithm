package src.yahait.level2;

import java.util.LinkedList;

//캐시
public class Cache {
	public static void main(String[] args) {
		Cache obj = new Cache();
		int a=obj.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
		System.out.println(a);
	}

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		LinkedList<String> list = new LinkedList<>();
		if(cacheSize == 0){
			return cities.length*5;
		}
		for(int i=0; i<cities.length; i++){
			cities[i] = cities[i].toUpperCase();
		}
		
		for(int i=0; i<cities.length; i++){
			if(list.contains(cities[i])){
				answer+=1;
				list.remove(cities[i]);
				list.addLast(cities[i]);
			}else{
				if(list.size() == cacheSize){
					list.removeFirst();
					list.addLast(cities[i]);
				}else{
					list.add(cities[i]);
				}
				answer+=5;
			}
		}
		return answer;
	}
}
