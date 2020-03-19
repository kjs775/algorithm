package yahait.level2;
//전화번호 목록
public class PhoneNumberList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneNumberList obj = new PhoneNumberList();
		String[] str = new String[]{"1192456","119" };
		System.out.println(obj.solution(str));
	}
	
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book.length && i!=j; j++){
                if(phone_book[i].contains(phone_book[j]) && 
                   phone_book[i].indexOf(phone_book[j])==0){
                    return false;
                }else if(phone_book[j].contains(phone_book[i]) && 
                        phone_book[j].indexOf(phone_book[i])==0){
                	return false;	
                }
            }
        }
        return answer;
    }

}
