package com.indus.training.core.domain;

public class ScoreOutput {
    private double[] preSortedScores;
    private double[] sortedScores;
    private long sortingTime;

	public double[] getPreSortedScores() {
        return preSortedScores;
    }

    public void setPreSortedScores(double[] preSortedScores) {
        this.preSortedScores = preSortedScores;
    }

    public double[] getSortedScores() {
        return sortedScores;
    }

    public void setSortedScores(double[] sortedScores) {
        this.sortedScores = sortedScores;
    }

    public long getSortingTime() {
        return sortingTime;
    }

    public void setSortingTime(long sortingTime) {
        this.sortingTime = sortingTime;
    }
}
