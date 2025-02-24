package com.indus.training.core.impl;

import com.indus.training.core.domain.ScoreInput;
import com.indus.training.core.domain.ScoreOutput;
import com.indus.training.core.excp.ArrayIndexException;
import com.indus.training.core.svc.IScore;

public class Score implements IScore {

	private double[] scores;
	private int size;
	private int limit;

	public Score(int initialArraySize) {
		this.limit = initialArraySize;
		this.scores = new double[limit];
		this.size = 0;
	}

	@Override
	public void arrayAlloc(ScoreInput input) {
		if (size == limit) {
			limit *= 2;
			double[] newArr = new double[limit];
			System.arraycopy(scores, 0, newArr, 0, size);
			scores = newArr;
		}
		scores[size++] = input.getScore();
	}

	@Override
	public ScoreOutput sortScores() {
		ScoreOutput output = new ScoreOutput();
		// Save the pre-sorted array
		double[] preSorted = new double[size];
		System.arraycopy(scores, 0, preSorted, 0, size);
		output.setPreSortedScores(preSorted);

		double[] arrySorted = new double[size];
		long startTime = System.nanoTime();
		// Sorting
		for (int i = 0; i < size; i++) {
			double a = scores[i];
			int count = 0;
			for (int j = 0; j < size; j++) {
				if (a > scores[j]) {
					count += 1;
				}
			}
			arrySorted[count] = a;
		}

		long endTime = System.nanoTime();

		// Set the sorted array and sorting time
		output.setSortedScores(arrySorted);
		output.setSortingTime(endTime - startTime);

		return output;
	}

	@Override
	public void getScoreAt(int index) throws ArrayIndexException {
        if (index < 0 || index >= size) {
            throw new ArrayIndexException("Index " + index + " is out of bounds.");
        } else {
        	System.out.println("Element at the index " + index + " is: " + scores[index]);
        }
    }
	
}
