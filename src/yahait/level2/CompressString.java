package src.yahait.level2;
//문자열 압축
public class CompressString {
	public static void main(String[] args){
		String a = "aabbaccc";
		CompressString obj = new CompressString();
		System.out.println(Math.log10(2));
//		System.out.println(obj.solution(a));
	}
	public int solution(String s) {
        int answer = s.length();
        int count = 0;
        String temp = "";
        StringBuilder buffer = new StringBuilder();
        
        
        for(int i=1; i<s.length()/2+1; i++){//압축 글자 수
        	
        	temp = s.substring(0, i);
        	
        	for(int j=0; j<=s.length(); j+=i){
        		if( j+i <= s.length() && temp.equals(s.substring(j, j+i))){
        			count++;
        		}else{
        			if(count > 1){
        				buffer.append(count+temp);
        			}else{
        				buffer.append(temp);
        			}
        			
    				temp = s.substring(j, j+i > s.length() ? s.length() : j+i);
    				if(temp.length() != i){
    					buffer.append(temp);
    					break;
    				}
        			count = 1;
        		}
        		System.out.println(buffer + "/ temp = " + temp + "["+j+", "+(j+i)+"]");
        	}
        	System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        	System.out.println("buffer = " + buffer+"\n");
        	count = 0;
        	answer = answer > buffer.length() ? buffer.length():answer;
        	buffer.replace(0, buffer.length(), "");
        }
        
        return answer;
    }
}
