package com.company.kakao.skillTree;

public class SkillTree2 {

    private boolean[] isRelevantSkill = new boolean[26];

    public int solution(String skill, String[] skillTrees) {
        setRelevantSkills(skill);
        return getRightSkillTreeCount(skill, skillTrees);
    }

    private void setRelevantSkills(String skill) {
        for (int i = 0; i < skill.length(); i++) {
            isRelevantSkill[skill.charAt(i) - 'A'] = true;
        }
    }

    private int getRightSkillTreeCount(String skill, String[] skillTrees) {
        int rightSkillCount = 0;
        for (String skillTree : skillTrees) {
            if (isRightSkillTree(skill, skillTree)) {
                rightSkillCount++;
            }
        }
        return rightSkillCount;
    }

    private boolean isRightSkillTree(String skill, String skillTree) {
        int j = 0;
        for (int i = 0; i < skillTree.length(); i++) {
            if(isRelevantSkill[skillTree.charAt(i) - 'A']
            && (skill.charAt(j++) != skillTree.charAt(i))) return false;
        }
        return true;
    }
}
