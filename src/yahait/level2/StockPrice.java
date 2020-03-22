package src.yahait.level2;

public class StockPrice {
	public static void main(String[] args){
		StockPrice obj = new StockPrice();
		int[] a = obj.solution(new int[]{1,2,3,2,3});
		for(int i=0; i< a.length; i++){
			System.out.print(a[i]+", ");
		}
	}
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		int temp;
		int cnt=0;
		for(int i=0; i< prices.length; i++){
			temp = prices[i];
			for(int j=i+1; j<prices.length; j++){
				answer[i]++;
				if(prices[j] < temp){
					break;
				}
			}
		}
		return answer;
	}
}
