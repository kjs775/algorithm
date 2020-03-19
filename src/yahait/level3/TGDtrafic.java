package yahait.level3;

//추석트래픽
public class TGDtrafic {
	public static void main(String[] args) {
		TGDtrafic obj = new TGDtrafic();
		int a = obj.solution(new String[] { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" });
		System.out.println(a);
	}

	public int solution(String[] lines) {
		int answer = 0;
		String[][] separation = new String[lines.length][3];
		String d = "";
		String[] time = new String[3];
		
		int h = 0;
		int m = 0;
		double s = 0;
		double request = 0;

		for (int i = 0; i < lines.length; i++) {
			d = lines[i].split(" ")[0];
			time = lines[i].split(" ")[1].split(":");
			separation[i][2] = time[0] + ":" + time[1] + ":" + time[2];
			h = Integer.parseInt(time[0]);
			m = Integer.parseInt(time[1]);
			s = Double.parseDouble(time[2]);
			request = Double.parseDouble(lines[i].split(" ")[2].split("s")[0]);

			if (s < request) {
				if (m < 1) {
					if (h < 1) {
						h = 0;
						m = 0;
						s = 0;
					} else {
						h -= 1;
						m = 59;
						s = s + 60.0 - request;
					}
					
				} else {
					m -= 1;
					s = s + 60.0 - request;
				}
				
			} else {
				s -= request;
			}
			separation[i][1] = h + ":" + m + ":" + s;
		}

		String[] start = separation[0][1].split(":");
		String[] end = separation[separation.length - 1][2].split(":");
		int section = 0;
		int startH = Integer.parseInt(start[0]);
		int endH = Integer.parseInt(end[0]);
		int startM = Integer.parseInt(start[1]);
		int endM = Integer.parseInt(end[1]);
		double startS = Double.parseDouble(start[2]);
		double endS = Double.parseDouble(end[2]);
		
		if(startH < endH){
			section = (endH*3600 + endM*60 + (int)endS) - (startH*3600 + startM*60 + (int)startS); 
		}else if(startM < endM){
			section = (endM*60 + (int)endS) - (startM*60 + (int)startS);
		}else if (startS > endS) {
			section = (int) (endS + 61 - startS);
		} else {
			section = (int) (endS - startS);
		}

		if(section == 0){
			return 1;
		}
		section++;
		int cnt = 0;
		endH = startH;
		endM = startM;
		double second = startS + 1.0;
		for (int i = 0; i < 2; i++) {
			System.out.println("start = " +startH+":"+startM+":"+startS);
			System.out.println("end = " +endH+":"+endM+":"+second);
			for (int j = 0; j < lines.length; j++) {
				int startTempH = Integer.parseInt(separation[j][1].split(":")[0]);
				int startTempM = Integer.parseInt(separation[j][1].split(":")[1]);
				double startTempS = Double.parseDouble(separation[j][1].split(":")[2]);

				int endTempH = Integer.parseInt(separation[j][2].split(":")[0]);
				int endTempM = Integer.parseInt(separation[j][2].split(":")[1]);
				double endTempS = Double.parseDouble(separation[j][2].split(":")[2]);

				if (startH == startTempH && startM == startTempM) {
					if (startS <= startTempS && second >= startTempS) {
						System.out.println(startTempH+":"+startTempM+":"+startTempS);
						System.out.println(endTempH+":"+endTempM+":"+endTempS);
						cnt++;
					}else if(startS <= endTempS && second >= endTempS){
						System.out.println(startTempH+":"+startTempM+":"+startTempS);
						System.out.println(endTempH+":"+endTempM+":"+endTempS);
						cnt++;
					}
				} else if (endH == startTempH && endM == startTempM) {
					if (second >= startTempS) {
						System.out.println(startTempH+":"+startTempM+":"+startTempS);
						System.out.println(endTempH+":"+endTempM+":"+endTempS);
						cnt++;
					}
				} else if (startH == endTempH && startM == endTempM) {
					if (startS <= endTempS && second >= endTempS) {
						System.out.println(startTempH+":"+startTempM+":"+startTempS);
						System.out.println(endTempH+":"+endTempM+":"+endTempS);
						cnt++;
					}
				} else if (endH == endTempH && endM == endTempM) {
					if (second >= endTempS) {
						System.out.println(startTempH+":"+startTempM+":"+startTempS);
						System.out.println(endTempH+":"+endTempM+":"+endTempS);
						cnt++;
					}
				}
			}
			startH = endH;
			startM = endM;
			startS = second;

			second++;
			if (second >= 60) {
				second = 0;
				if (endM + 1 < 60) {
					endM++;
				} else {
					endH++;
					endM = 0;
				}
			}
			if (answer < cnt) {
				answer = cnt;
			}
			cnt = 0;
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		}
		return answer;
	}
}