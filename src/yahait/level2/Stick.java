package yahait.level2;

import java.util.Stack;

public class Stick {
	public static void main(String[] args){
		Stick obj = new Stick();
		int a = obj.solution("()(((()())(())()))(())");
		System.out.println(a);
	}
	
	public int solution(String arrangement) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arrangement.length(); i++) {
			if (i < arrangement.length()-1 && arrangement.charAt(i) == '(' && arrangement.charAt(i+1) == ')') {
				i++;
				answer += stack.size();
			}else if (arrangement.charAt(i) == '(') {
				stack.add(1);
			}else if (arrangement.charAt(i) == ')') {
				stack.remove(stack.size() - 1);
				answer++;
			}
		}
		return answer;
	}
}
