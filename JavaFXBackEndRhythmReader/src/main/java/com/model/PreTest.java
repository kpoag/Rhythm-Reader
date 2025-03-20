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
     */
    public PreTest(List<String> questions, List<String> answers, String level, int score) {
        this.questions = questions;
        this.answers = answers;
        this.level = level;
        this.score = score;
    }

    /**
     * Returns the list of questions in the pre-test.
     */
    public List<String> getQuestions() {
        return questions;
    }

    /**
     * Sets the questions for the pre-test.
     */
    public boolean setQuestions(List<String> questions) {
        if (questions == null) return false;
        this.questions = questions;
        return true;
    }

    /**
     * Returns the list of answers for the pre-test.
     */
    public List<String> getAnswers() {
        return answers;
    }

    /**
     * Sets the answers for the pre-test.
     */
    public boolean setAnswers(List<String> answers) {
        if (answers == null) return false;
        this.answers = answers;
        return true;
    }

    /**
     * Returns the level of the pre-test.
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets the level for the pre-test.
     */
    public boolean setLevel(String level) {
        if (level == null) return false;
        this.level = level;
        return true;
    }

    /**
     * Returns the score of the pre-test.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score for the pre-test.
     */
    public boolean setScore(int score) {
        if (score < 0) return false;
        this.score = score;
        return true;
    }

    /**
     * Returns a string representation of the pre-test, including its level.
     */
    public String pretesttoString() {
        return "Taking quiz at " + level + " level.";
    }

    /**
     * Evaluates the score and returns the result.
     */
    public String evaluateScore(int newScore) {
        this.score = newScore;
        return "Quiz evaluated. New score: " + score;
    }
}
