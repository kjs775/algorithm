package yahait.level1;

public class SortStringMyMind {
	public static void main(String[] args){
		SortStringMyMind obj = new SortStringMyMind();
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 2;
		String[] answer = obj.solution(strings, n);
		
		for(int i=0; i<answer.length; i++){
			System.out.println(answer[i]);
		}
	}
	  public String[] solution(String[] strings, int n) {
	      String[] answer = {};
	      String temp = "";
	      for(int i=0; i<strings.length-1; i++){
	    	  for(int j=i+1; j<strings.length; j++){
	    		  if(strings[i].charAt(n) > strings[j].charAt(n)){
	    			  temp = strings[i];
	    			  strings[i] = "" + strings[j];
	    			  strings[j] = "" + temp;
	    		  }else if(strings[i].charAt(n) == strings[j].charAt(n)){
	    			  if(strings[i].compareTo(strings[j]) > 0){
	    				  temp = strings[i];
		    			  strings[i] = "" + strings[j];
		    			  strings[j] = "" + temp; 
	    			  }
	    		  }
	    	  }
	      }
	      answer = strings;
	      return answer;
	  }
}
