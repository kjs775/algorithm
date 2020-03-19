package yahait.level2;
//숫자 야구
public class Baseball {
	public static void main(String[] args){
		Baseball obj = new Baseball();
		System.out.println(obj.solution(new int[][]{{123,1,1}, {356,1,0}, {327,2,0}, {489,0,1}}));
	}
	public int solution(int[][] baseball) {
        int answer = 0;
        String questNumber = "";
        String caseNumber = "";
        for(int i=123; i<=987; i++){
            questNumber = String.valueOf(i);
            
            if(questNumber.contains(String.valueOf(0))){
                continue;
            }else if(questNumber.charAt(0) == questNumber.charAt(1) || 
                     questNumber.charAt(0) == questNumber.charAt(2) ||
                     questNumber.charAt(1) == questNumber.charAt(2)){
                continue;
            }
               
            for(int j=0; j<baseball.length; j++){
                caseNumber = String.valueOf(baseball[j][0]);
                int strike = 0;
                int ball = 0;
                for(int k=2; k>=0; k--){
                    if(questNumber.charAt(k) == caseNumber.charAt(k)){
                        strike++;
                    }
                }
                
                if( strike != baseball[j][1]){
                    break;
                }
                if(questNumber.charAt(0) == caseNumber.charAt(1) ||
                   questNumber.charAt(0) == caseNumber.charAt(2)) {
                         ball++;
                }if(questNumber.charAt(1) == caseNumber.charAt(0) ||
                   questNumber.charAt(1) == caseNumber.charAt(2) ){
                        ball++;
                }if(questNumber.charAt(2) == caseNumber.charAt(0) ||
                   questNumber.charAt(2) == caseNumber.charAt(1)){
                        ball++;
                }
                if(ball != baseball[j][2]){
                    break;
                }
                if(j==baseball.length-1){
                    answer++;
                }
            }
            
        }
        return answer;
    }

}
