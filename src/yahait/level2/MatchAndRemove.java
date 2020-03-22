package src.yahait.level2;

import java.util.Stack;

public class MatchAndRemove {
	public static void main(String[] args){
		MatchAndRemove obj = new MatchAndRemove();
		int a = obj.solution("abbabb");
		String s = "";
	}
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		stack.add(s.charAt(0));
		int index = 1;
		while(index < s.length()){
			if(stack.empty()){
				stack.add(s.charAt(index));
			}else if(stack.peek() == s.charAt(index)){
				stack.pop();
			}else{
				stack.add(s.charAt(index));
			}
			index++;
		}
		
		return stack.size() == 0 ? 1 : 0;
	}
}
