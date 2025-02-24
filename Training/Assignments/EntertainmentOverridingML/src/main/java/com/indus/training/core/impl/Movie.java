package com.indus.training.core.impl;

import com.indus.training.core.svc.Entertainment;
import com.indus.training.core.svc.Playable;

public class Movie implements Entertainment, Playable {
    @Override
    public String getDetails(String title, double duration) {
        return "Movie Title: " + title + ", Duration: " + duration + " hours";
    }

    @Override
    public String play() {
        return "Playing movie";
    }
}
