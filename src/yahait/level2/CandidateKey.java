package src.yahait.level2;
//후보키
/*[["100","ryan","music","2"],
 ["200","apeach","math","2"],
 ["300","tube","computer","3"],
 ["400","con","computer","4"],
 ["500","muzi","music","3"],
 ["600","apeach","music","2"]]*/

import java.util.ArrayList;
import java.util.List;

/*
*/
public class CandidateKey {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String[][] relation) {
        int answer = 0;
        
        int column = relation.length;
        int row = relation[0].length;
        boolean[] unique = new boolean[relation.length];
        int index = 0;
        String tuple = "";
        for(int i=0; i<column; i++){
        	List<String> list = new ArrayList<String>();
        	for(int j=0; j<row; j++){
        		for(int k=i; k<=index; k++){
        			tuple += relation[i][k];
        		}
        		list.add(tuple);
        		tuple = "";
        	}
        	if(overlap(list)){
        		unique[i] = true;
        		index++;
        	}else{
        		index++;
        	}
        }
        
        return answer;
    }
	
	public boolean overlap(List<String> list){
		String temp1 = "";
		for(int i=0; i<list.size(); i++){
			temp1 = list.get(i);
			for(int j=i+1; j<list.size(); j++){
				if(temp1.equals(list.get(j))){
					return true;
				}
			}
		}
		return false;
	}
}
