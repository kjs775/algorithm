package src.yahait.level1;

//소수 찾기
public class SearchSosu1 {
	public static void main(String[] args) {
		SearchSosu1 obj = new SearchSosu1();
		int a = obj.solution(10);
		System.out.println(a);

	}

	public int solution(int n) {
		boolean[] check = new boolean[n+1];
        int answer = 0;
        for(int i=2; i<=n; i++){
            for(int j=2*i; j<=n; j+=i){
                check[j] = true;
            }
        }
        for(int i=2; i<=n; i++){
            if(!check[i]){
                answer++;
            }
        }
        for(boolean a : check){
        	System.out.println(a);
        }
        return answer;
	}
}
