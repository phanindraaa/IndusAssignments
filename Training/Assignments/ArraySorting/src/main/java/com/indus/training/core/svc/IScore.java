package com.indus.training.core.svc;

import com.indus.training.core.domain.ScoreInput;
import com.indus.training.core.domain.ScoreOutput;
import com.indus.training.core.excp.ArrayIndexException;

public interface IScore {
    public void arrayAlloc(ScoreInput input) throws ArrayIndexException;
    public ScoreOutput sortScores() throws ArrayIndexException;
    public void getScoreAt(int index) throws ArrayIndexException;
}
