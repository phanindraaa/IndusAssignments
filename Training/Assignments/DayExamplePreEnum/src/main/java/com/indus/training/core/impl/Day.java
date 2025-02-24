package com.indus.training.core.impl;

public class Day {
	 // Private variables
    private final String dayName;

    // Private constructor
    private Day(String dayName) {
        this.dayName = dayName;
    }

    // Getter for dayName
    public String getDayName() {
        return dayName;
    }

    // Static final instances for each day of the week
    public static final Day MONDAY = new Day("Monday");
    public static final Day TUESDAY = new Day("Tuesday");
    public static final Day WEDNESDAY = new Day("Wednesday");
    public static final Day THURSDAY = new Day("Thursday");
    public static final Day FRIDAY = new Day("Friday");
    public static final Day SATURDAY = new Day("Saturday");
    public static final Day SUNDAY = new Day("Sunday");

}
