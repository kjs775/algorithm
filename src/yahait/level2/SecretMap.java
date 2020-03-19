package yahait.level2;

public class SecretMap {
	public static void main(String[] args){
		SecretMap obj = new SecretMap();
		String[] a = obj.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
		for(String b:a){
			System.out.println(b);
		}
		
	}
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		char[][] temp = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				temp[i][j] = ' ';
			}
		}
		StringBuilder binary1 = new StringBuilder();
		int distance = 0;
		for(int i=0; i<n; i++){
			binary1.append(Integer.toBinaryString(arr1[i]));
			distance = n-binary1.length();
			for(int j=distance; j<n; j++){
				if(binary1.charAt(j-distance) == '1'){
					temp[i][j] = '#';
				}
			}
			binary1.delete(0,n);
			binary1.append(Integer.toBinaryString(arr2[i]));
			distance = n - binary1.length();
			for(int j=distance; j<n; j++){
				if(binary1.charAt(j-distance) == '1'){
					temp[i][j] = '#';
				}
			}
			answer[i] = String.valueOf(temp[i]);
			binary1.delete(0,n);
		}
		return answer;
	}
}
