package com.company.kakao.skillTree;

public class SkillTree {

    private boolean[] isRelevantSkill = new boolean[26];

    public int solution(String skill, String[] skillTrees) {
        int answer = 0;

        for (int i = 0; i < skill.length(); i++) {
            System.out.println(skill.charAt(i) - 'A');
            isRelevantSkill[skill.charAt(i) - 'A'] = true;
        }

        for (String skillTree : skillTrees) {
            if (isRightSkillTree(skill, skillTree)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isRightSkillTree(String skill, String skillTree) {
        return isRight(skill, getRelevantSkills(skillTree));
    }

    private String getRelevantSkills(String skillTree) {
        String relevantSkills = "";

        for (int i = 0; i < skillTree.length(); i++) {
            if (isRelevantSkill[skillTree.charAt(i) - 'A']) {
                relevantSkills += skillTree.charAt(i);
            }
        }

        return relevantSkills;
    }

    private boolean isRight(String skill, String skillTree) {
        for (int i = 0; i < skillTree.length(); i++) {
            if(skill.charAt(i) != skillTree.charAt(i)) return false;
        }
        return true;
    }
}