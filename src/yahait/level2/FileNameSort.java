package src.yahait.level2;

import java.util.Arrays;
import java.util.Comparator;

//파일명 정렬

public class FileNameSort {

	public static void main(String[] args) {
		FileNameSort obj = new FileNameSort();
		String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		String[] arr = obj.solution(files);
		for(String a : arr){
//			System.out.println(a);
		}
	}
//1,10,02,12,01,2
//1,01,02,12,10,2
//1,01,02,12,10,2
//1,01,02,2,10,12
	
	public String[] solution(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            // 첫번째 오브젝트 head, num 추출
	        	for(String s : files){
	        		System.out.println(s);
	        	}
	        	
	            String head1 = s1.split("[0-9]")[0];
	            s1 = s1.replace(head1, "");
	            head1 = head1.toUpperCase();
	            
	            String tempNum = "";
	            for(char c : s1.toCharArray()) {
	                if(Character.isDigit(c) && tempNum.length() < 5) {
	                    tempNum += c;
	                } else {
	                    break;
	                }
	            }
	            int num1 = Integer.parseInt(tempNum);
	            
	            // 두번째 오브젝트 head, num 추출
	            String head2 = s2.split("[0-9]")[0];
	            s2 = s2.replace(head2, "");
	            head2 = head2.toUpperCase();
	            
	            tempNum = "";
	            for(char c : s2.toCharArray()) {
	                if(Character.isDigit(c) && tempNum.length() < 5) {
	                    tempNum += c;
	                } else {
	                    break;
	                }
	            }
	            int num2 = Integer.parseInt(tempNum);
	            System.out.println(s1 + "/" + s2 + "? " +head1.equals(head2)+"----"+ num1 +"/"+num2);
	            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	            // 비교 처리
	            return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2); 
	        }
	    });
		return files;
	}
	
	public static String[] sort(String[] input) {
	    Arrays.sort(input, new Comparator<String>() {
	        @Override
	        public int compare(String s1, String s2) {
	            // 첫번째 오브젝트 head, num 추출
	        	for(String s : input){
	        		System.out.println(s);
	        	}
	        	
	            String head1 = s1.split("[0-9]")[0];
	            s1 = s1.replace(head1, "");
	            head1 = head1.toUpperCase();
	            
	            String tempNum = "";
	            for(char c : s1.toCharArray()) {
	                if(Character.isDigit(c) && tempNum.length() < 5) {
	                    tempNum += c;
	                } else {
	                    break;
	                }
	            }
	            int num1 = Integer.parseInt(tempNum);
	            
	            // 두번째 오브젝트 head, num 추출
	            String head2 = s2.split("[0-9]")[0];
	            s2 = s2.replace(head2, "");
	            head2 = head2.toUpperCase();
	            
	            tempNum = "";
	            for(char c : s2.toCharArray()) {
	                if(Character.isDigit(c) && tempNum.length() < 5) {
	                    tempNum += c;
	                } else {
	                    break;
	                }
	            }
	            int num2 = Integer.parseInt(tempNum);
	            System.out.println(s1 + "/" + s2 + "? " +head1.equals(head2)+"----"+ num1 +"/"+num2);
	            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	            // 비교 처리
	            return head1.equals(head2) ? num1 - num2 : head1.compareTo(head2); 
	        }
	    });
	    
	    return input;
	}


	/*
	public String[] solution(String[] files) {
		String[] answer = new String[files.length];
		int[] sortCheck = new int[files.length];
		for (int i = 0; i < files.length; i++) {
			sortCheck[i] = -1;
		}

		StringBuilder sb = new StringBuilder();
		String[] head = new String[files.length];
		Integer[] number = new Integer[files.length];
		String[] tail = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			sb.delete(0, sb.length());
			for (int j = 0; j < files[i].length(); j++) {
				if (head[i] == null) {
					if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
						head[i] = sb.toString();
						head[i] = head[i].toUpperCase();
						sb.delete(0, sb.length());
						sb.append(files[i].charAt(j));
					} else {
						sb.append(files[i].charAt(j));
					}
				} else if (number[i] == null) {
					if (files[i].charAt(j) >= '0' && files[i].charAt(j) <= '9') {
						sb.append(files[i].charAt(j));
						if(sb.charAt(0) == '0'){
							sb.deleteCharAt(0);
						}
					} else {
						if(sb.length() > 5){
							number[i] = Integer.valueOf(sb.substring(0,5));
						}else{
							number[i] = Integer.valueOf(sb.toString());
						}
						sb.delete(0, 5);
						sb.append(files[i].substring(i));
					}
				}
			}
		}

		int[] priority = new int[files.length];
		int count = 0;
		int max = 0;
		int sameCount = 0;
		String temp = "";
		
		//HEAD비교
		for (int i = 0; i < files.length - 1; i++) {
			max = i;
			for (int j = i + 1; j < files.length; j++) {
				if (head[j].compareTo(head[i]) < 0) {
					if (head[j].compareTo(head[max]) < 0) {
						max = j;
					}
				}else if (head[i].compareTo(head[j]) == 0) {
					sameCount++;
				}
			}
			if(sameCount == files.length-1-i){
				break;
			}else{
				temp = "";
				temp = files[i];
				
				files[i] = files[max];
				files[max] = temp;
				priority[count] = max;
				
				temp = head[i];
				head[i] = head[max];
				head[max] = temp;
				
				count++;
			}
		}
		
		if(count == files.length){
			return files;
		}
		
		//number비교
		int min = files.length+1;
		int numberCompare =0;
		int num = 0;
		for(int i=count; i<files.length; i++){
			min = i;
			for(int j=i+1; j<files.length; j++){
				if(number[min] > number[j]){
					min = j;
				}
			}
			temp = "";
			temp = files[i];
			
			files[i] = files[min];
			files[min] = temp;
			priority[count] = min;
			
			num = number[i];
			number[i] = number[min];
			number[min] = num;
			
			numberCompare++;
		}
		
		count += numberCompare;
		for(String a : files){
			System.out.println(a);
		}
		
		if(count == files.length){
			return files;
		}
		
		
		
		answer = files;
		

		return answer;
	}
	*/
	
}
