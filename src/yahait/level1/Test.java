package yahait.level1;

import java.math.BigInteger;
public class Test {
	public static void main(String[] args){
		String str = "PM 01:00:00";
		String ampm = str.substring(0,2);
		int hour = Integer.parseInt(str.substring(3,5));
		int min = Integer.parseInt(str.substring(6,8));
		int sec = Integer.parseInt(str.substring(9,11));
		
		if(ampm.equals("PM")){
			hour += 12;
		}else if(ampm.equals("AM") && hour == 12){
			
		}
		
		
		
	}
	
}
