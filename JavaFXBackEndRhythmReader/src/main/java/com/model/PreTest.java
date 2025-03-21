package com.model;

import java.util.List;
/**
 * Represents a pre-test with a set of questions, answers, level, and score. 
 * This class allows setting and getting test details, as well as evaluating the score.
 */
public class PreTest {
    private List<String> questions;
    private List<String> answers;
    private String level;
    private int score;

    /**
     * Constructs a PreTest with the specified questions, answers, level, and score.
     * @param que
     */
    public PreTest(List<String> questions, List<String> answers, String level, int score) {
        this.questions = questions;
        this.answers = answers;
        this.level = level;
        this.score = score;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public boolean setQuestions(List<String> questions) {
        if (questions == null ) return false;
        this.questions = questions ;
        return true;   
    }

    public List<String> getAnswers() {
        return answers;
    }

    public boolean setAnswers(List<String> answers) {
        if (answers == null ) return false;
        this.answers = answers ;
        return true;   
    }

    public String getLevel() {
        return level;
    }

    public boolean setLevel(String level) {
        if (level == null ) return false;
        this.level = level ;
        return true;   
    }

    public int getScore() {
        return score;
    }

    public boolean setScore(int score) {
        if (score < 0 ) return false;
        this.score = score ;
        return true;   
    }

    public String pretesttoString() {
        return"Taking quiz at " + level + " level.";
    }

    public String evaluateScore(int newScore) {
        this.score = newScore;
       return "Quiz evaluated. New score: " + score;
    }
}
