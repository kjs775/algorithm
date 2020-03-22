package src.yahait.level2;

public class JadenCase {
	public static void main(String[] args){
		JadenCase obj = new JadenCase();
		String a = obj.solution("3asd saz ");
		System.out.println(a);
	}
	public String solution(String s) {
		String answer = "";
		s = s.toLowerCase();
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
            if(str[i].trim().equals("")){
                answer += " ";
				continue;
			}
			if (str[i].charAt(0) >= 'a' && str[i].charAt(0) <= 'z') {
				str[i] = (char)(str[i].charAt(0)-32) + str[i].substring(1);
			}
			answer += str[i]+" ";
		}
		if(s.charAt(s.length()-1) != ' '){
			answer = answer.substring(0, answer.length()-1);
		}
		return answer;
	}
}
