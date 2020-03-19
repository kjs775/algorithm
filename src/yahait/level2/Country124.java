package yahait.level2;

import java.util.ArrayList;
import java.util.List;

public class Country124 {
	public static void main(String[] args){
		Country124 obj = new Country124();
		String str = obj.solution(3000);
		System.out.println(str);
	}
	
	// n==61, 몫 ==20 나머지==1 => 몫 6, 나머지 2 1421
	// n==601, 몫==200 나머지==1 "1"=> 몫66 나머지 2 "21" => 몫22 나머지0 "421"=> 몫7 나머지1 "421"
	// n==600, 몫==200 나머지==0 "4"=> 몫66 나머지 2 "24" 
	
	/*public String solution(int n) {
	 	String answer = "";
			int num = 0;
	      switch(n){
	          case 1:
	              return "1";
	          case 2:
	              return "2";
	          case 3:
	              return "4";
	          case 4: 
	              return "11";
	          case 5:
	              return "12";
	          case 6:
	              return "14";
	          case 7:
	              return "21";
	          case 8:
	              return "22";
	          case 9:
	              return "24";
	          case 10:
	              return "41";
	      }
			String[] stringArray = new String[n+1];
			stringArray[0] = "";
			stringArray[1] = "1";
			stringArray[2] = "2";
			stringArray[3] = "4";
	        stringArray[4] = "11";
			stringArray[5] = "12";
			stringArray[6] = "14";
			stringArray[7] = "21";
			stringArray[8] = "22";
			stringArray[9] = "24";
			stringArray[10] = "41";*/
/*

			for (int i = 11; i <= n; i++) {
				num = i / 3;
				if(i % 3 == 0){
					stringArray[i] = stringArray[num-1] + stringArray[3];
				}else{
					stringArray[i] = stringArray[num] + stringArray[i%3];
				}
			}
			answer = stringArray[n];
			return answer;
	  }*/
	
	public String solution(int n) {
      	String answer = "";
		int num = 0;
		String[] stringArray = new String[n+1];
		stringArray[0] = "4";
		stringArray[1] = "1";
		stringArray[2] = "2";
		stringArray[3] = "4";
		List<String> list = new ArrayList<>();
		int remain = 0;
		while(n>3){
			remain = n%3;
			n /= 3;
			if(remain == 0){
				list.add(0,stringArray[remain]);
				n--;
				System.out.println(list.toString());
			}else{
				list.add(0,stringArray[remain]);
				System.out.println(list.toString());
			}
		}
		list.add(0, stringArray[n]);
		StringBuilder sb = new StringBuilder();
		for(String st : list){
			sb.append(st);
		}
		return sb.toString();
  }
	
}
