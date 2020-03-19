package yahait.level2;

import java.util.Stack;

public class TargetNumber {
	public static void main(String[] args){
		TargetNumber obj = new TargetNumber();
		int a = obj.solution(new int[] {1,1,1,1,1}, 5);
		System.out.println(a);
	}
	public int solution(int[] numbers, int target) {
		int answer = 0;
		
		String stackE = "";
		Stack<String> stack = new Stack<>();
		
		stack.push("0/0");
		int number = 0;
		int index = 0;
		
		while(stack.size()>0){
			stackE = stack.pop();
			number = Integer.valueOf(stackE.split("/")[0]);
			index = Integer.valueOf(stackE.split("/")[1]);
			
			if(index == numbers.length && number == target){
				answer++;
				continue;
			}else if(index >= numbers.length){
				continue;
			}
			stack.push((number+numbers[index]) +"/"+ (index+1));
			stack.push((number-numbers[index]) +"/"+ (index+1));
		}
		return answer;
	}	
}
