package yahait.level2;
//라면 공장
public class RamenFactory {
	public static void main(String[] args){
		RamenFactory obj = new RamenFactory();
		int stock = 4;
		int[] dates = new int[]{4,10,15};
		int[] supplies = new int[]{20,5,10};
		int k = 30;
		System.out.println(obj.solution(stock, dates, supplies, k));
	}
	
	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;//공급받은 횟수
        
        int day = stock;//현재 공장 가동한 날짜 수
        int max = 0;//현재 날짜에서 공급받을 수 있는 최대 공급량
        int index = 0;//max에 해당하는 인덱스
        
        while(day < k){
            for(int i=0; i<dates.length; i++){
            	if(dates[i] == 0){
            		continue;
            	}
            	if(day >= dates[i] && max < supplies[i]){
            		index = i;
            		max = supplies[i];
            	}
            }
            answer++;
            stock = max;
            day += stock;
            dates[index] = 0;
            supplies[index] = 0;
            max = 0;
        }
        
        return answer;
    }
	
}
