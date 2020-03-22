package src.yahait.level2;

public class SkillTree {
	public static void main(String[] args){
		SkillTree obj = new SkillTree();
		int n = obj.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
		System.out.println(n);
	}

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		boolean possibleTree = true;
		boolean[][] learnedSkill = new boolean[skill_trees.length][skill.length()];
		for (int i = 0; i < skill_trees.length; i++) {
			for (int j = 0; j < skill_trees[i].length(); j++) {
				int index = findSkill(skill, skill_trees[i].charAt(j));
				if (index == 0) {
					learnedSkill[i][index] = true;
				} else if (index > 0) {
					boolean res = possible(learnedSkill[i], index);
					if (res) {
						learnedSkill[i][index] = true;
					} else {
						possibleTree = false;
						break;
					}
				}
			}
			if (possibleTree) {
				answer++;
			}
			possibleTree = true;
		}
		return answer;
	}

	public static boolean possible(boolean[] learnedSkills, int index) {
		boolean notLearned = true;
		for (int i = 0; i < index; i++) {
			if (learnedSkills[i] == false) {
				notLearned = false;
			}
		}
		return notLearned;
	}

	public static int findSkill(String skill, char skillTree) {
		int result = -1;
		for (int i = 0; i < skill.length(); i++) {
			if (skill.charAt(i) == skillTree) {
				result = i;
			}
		}
		return result;

	}
}
