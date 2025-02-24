package com.indus.training.core.impl;

public class Planet {
	 // Instance variables
    private final String planetName;
    private final int Ranking;

    // Private constructor
    private Planet(String planetName, int Ranking) {
        // 'this.planetName' refers to the instance variable,
        // while 'planetName' (on the right) refers to the parameter.
        this.planetName = planetName;
        this.Ranking = Ranking;
    }

    // Getter for planetName
    public String getPlanetName() {
        return planetName;
    }

    // Getter for distanceFromSun
    public double getRanking() {
        return Ranking;
    }

    // Static final instances for each planet in the solar system
    public static final Planet MERCURY = new Planet("Mercury", 1);
    public static final Planet VENUS = new Planet("Venus", 2);
    public static final Planet EARTH = new Planet("Earth", 3);
    public static final Planet MARS = new Planet("Mars", 4);
    public static final Planet JUPITER = new Planet("Jupiter", 5);
    public static final Planet SATURN = new Planet("Saturn", 6);
    public static final Planet URANUS = new Planet("Uranus", 7);
    public static final Planet NEPTUNE = new Planet("Neptune", 8);
}