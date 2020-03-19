package yahait.level2;

import java.util.ArrayList;
import java.util.List;

public class WhatIsSong {
	public static void main(String[] args) {
		WhatIsSong obj = new WhatIsSong();
		System.out.println(obj.solution("CC#BCC#BCC#BCC#B",
				new String[] { "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B" }));
	}

	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int answerPlayTime = -1;
		int index = -1;
		m = m.replace("A#", "a");
		m = m.replace("C#", "c");
		m = m.replace("D#", "d");
		m = m.replace("F#", "f");
		m = m.replace("G#", "g");
		int playTime = 0;

		for (int i = 0; i < musicinfos.length; i++) {
			String[] music = musicinfos[i].split(",");
			StringBuilder sb = new StringBuilder();
			playTime = (Integer.valueOf(music[1].split(":")[0]) * 60 + Integer.valueOf(music[1].split(":")[1]))
					- (Integer.valueOf(music[0].split(":")[0]) * 60 + Integer.valueOf(music[0].split(":")[1]));
			for (int j = 0; j < playTime; j++) {
				sb.append(music[3].charAt(j % music[3].length()));
			}
			String melody = sb.toString();
			melody = melody.replace("A#", "a");
			melody = melody.replace("C#", "c");
			melody = melody.replace("D#", "d");
			melody = melody.replace("F#", "f");
			melody = melody.replace("G#", "g");
			if (melody.contains(m)) {
				if (answerPlayTime < playTime) {
					index = i;
					answerPlayTime = playTime;
					answer = music[2];
				}
			}
		}
		return answer;
	}
}
