package yahait.level1;
//2016년
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Year2016 {
	public static void main(String[] args) throws ParseException {
		Year2016 obj = new Year2016();
		String str = obj.solution(5, 24);
		System.out.println(str);
	}

	public String solution(int a, int b) throws ParseException {
		String answer = "";
		
		Calendar cal = Calendar.getInstance();
		cal.set(2016, a-1, b);
		
	
		int c = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(c){
		case 1:
			answer = "SUN";
			break;
		case 2:
			answer = "MON";
			break;
		case 3:
			answer = "TUE";
			break;
		case 4:
			answer = "WED";
			break;
		case 5:
			answer = "THU";
			break;
		case 6:
			answer = "FRI";
			break;
		case 7:
			answer = "SAT";
			break;
		}
		return answer;
	}
}
