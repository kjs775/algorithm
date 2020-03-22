package src.yahait.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinAndMaxValue {

	public static void main(String[] args) {
		MinAndMaxValue obj = new MinAndMaxValue();
		System.out.println(obj.solution("-1 -2 -3 -4"));
	}

	public String solution(String s) {
		String answer = "";
		String[] arr = s.split(" ");
		int min, max;
		min = max = Integer.parseInt(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(Integer.parseInt(arr[0]), min);
			max = Math.max(Integer.parseInt(arr[0]), max);
		}

		answer = min + " " + max;
		return answer;
	}
}
