package src.yahait.level2;

import java.util.Stack;

//올바른 괄호
public class InspectBracket {
	public static void main(String[] args) {
		InspectBracket obj = new InspectBracket();
		System.out.println(obj.solution("()()"));
	}

	boolean solution(String s) {
		boolean answer = true;

		if(s.charAt(0) == ')'){
			return false;
		}
		char[] arr = s.toCharArray();
		char[] stack = new char[s.length()];
		int top = -1;

		for (int i = 0; i < arr.length; i++) {
			if(top>=0){
				if(stack[top]== '(' && arr[i] == ')'){
					stack[top] = ' ';
					top--;
				}else{
					top++;
					stack[top] = arr[i];
				}
			}else if(top<0 && arr[i] == ')'){
				return false;
			}else{
				top++;
				stack[top] = arr[i];
			}
			System.out.println(top);
		}
		if(top != -1){
			answer = false;
		}
		return answer;
	}
}
