package com.model;

import java.util.List;

public class PreTest {
    private List<String> questions;
    private List<String> answers;
    private String level;
    private int score;

    public PreTest(List<String> questions, List<String> answers, String level, int score) {
        this.questions = questions;
        this.answers = answers;
        this.level = level;
        this.score = score;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void takeQuiz() {
        System.out.println("Taking quiz at " + level + " level.");
    }

    public void evaluateScore(int newScore) {
        this.score = newScore;
        System.out.println("Quiz evaluated. New score: " + score);
    }
}
