package com.indus.training.core.svc;

import java.util.Arrays;

import com.indus.training.core.domain.ScoreInput;
import com.indus.training.core.domain.ScoreOutput;
import com.indus.training.core.excp.ArrayIndexException;
import com.indus.training.core.impl.Score;

import junit.framework.TestCase;

public class testScore extends TestCase {
	
	private Score scoreObj;
	protected void setUp() throws Exception {
		scoreObj = new Score(2);
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		scoreObj = null;
	}
	
	public void testArrayAlloc() throws ArrayIndexException {
		ScoreInput scoreInpObj = new ScoreInput();
		scoreInpObj.setScore(3.7);
		scoreObj.arrayAlloc(scoreInpObj);
		scoreInpObj.setScore(1.7);
		scoreObj.arrayAlloc(scoreInpObj);
		scoreInpObj.setScore(5.7);
		scoreObj.arrayAlloc(scoreInpObj);
		scoreInpObj.setScore(4.7);
		scoreObj.arrayAlloc(scoreInpObj);
		scoreInpObj.setScore(2.7);
		scoreObj.arrayAlloc(scoreInpObj);
		
		ScoreOutput actOutObj = scoreObj.sortScores();
		double [] expPresortedArray = {3.7, 1.7, 5.7, 4.7, 2.7};
		double[] actPresortedArray = actOutObj.getPreSortedScores();
		assertEquals(Arrays.toString(expPresortedArray), Arrays.toString(actPresortedArray));
		
		double[] expSortedArray = {1.7, 2.7, 3.7, 4.7, 5.7};
		double[] actSortedArray = actOutObj.getSortedScores();
		assertEquals(Arrays.toString(expSortedArray), Arrays.toString(actSortedArray));
		System.out.print(actOutObj.getSortingTime());
		int index = -5;		
		try {
			scoreObj.getScoreAt(index);
			fail("Index " + index + " is out of bounds.");
		} catch (ArrayIndexException e) {
			assertEquals("Index " + index + " is out of bounds.", e.getMessage());
		}
	}
}
