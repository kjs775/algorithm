package src.yahait.level2;

import java.util.*;
//오픈채팅방
public class OpenChating {
	public static void main(String[] args){
		OpenChating obj = new OpenChating();
		String[] a = obj.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(String temp : a){
			System.out.println(temp);
		}
	}
		public String[] solution(String[] record) {
	        String[] answer = {};
	        List<String> list = new ArrayList<>();
	        Map<String, String> recordId = new HashMap<String, String>();
	//        Enter[0] uid1234[1] Muzi[2]
	        for(int i=0; i<record.length; i++){
	        	String[] info = record[i].split(" ");
	        	if(info[0].equals("Change")){
	        		recordId.replace(info[1], info[2]);
	        	}else if(info[0].equals("Enter")){
	        		if(recordId.containsKey(info[1])){
	        			if(recordId.get(info[1]).equals(info[2])){
	    					list.add(record[i]);
	        			}else{
	        				list = change(list, record[i]);
	        				list.add(record[i]);
	        				recordId.replace(info[1], info[2]);
	        			}
	        		}else{
	        			list.add(record[i]);
	        			recordId.put(info[1], info[2]);
	        		}
	        	}else{
	        		list.add(record[i]);
	        	}
	        }
	        String nickname = "";
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<list.size(); i++){
	        	nickname = recordId.get(list.get(i).split(" ")[1]);
	        	sb.append(nickname+"님이");
	        	switch(list.get(i).split(" ")[0]){
	        	case "Enter":
	        		sb.append(" 들어왔습니다.");
	        		break;
	        	case "Leave":
	        		sb.append(" 나갔습니다.");
	        		break;
	        	}
	        	sb.append(", ");
	        }
	        
	        return sb.toString().split(", ");
	    }
		
		public List<String> change(List<String> list, String info){
			String userId = info.split(" ")[1];
			String nickname = info.split(" ")[2];
			for(int i=0; i<list.size(); i++){
				if(list.get(i).equals(userId)){
					String preNickname = list.get(i).split(" ")[2];
					if(!preNickname.equals(nickname)){
						list.get(i).replace(preNickname, nickname);
					}
				}
			}
			return list;
		}
}
