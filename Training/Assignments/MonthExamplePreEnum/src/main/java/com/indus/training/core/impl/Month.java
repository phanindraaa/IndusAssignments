package com.indus.training.core.impl;

public final class Month {
    // Private variables
    private final String monthName;
    private final int days;

    // Private constructor
    private Month(String monthName, int days) {
        this.monthName = monthName;
        this.days = days;
    }

    // Getter for monthName
    public String getMonthName() {
        return monthName;
    }

    // Getter for days
    public int getDays() {
        return days;
    }

    // Static final instances for each month of the year
    public static final Month JANUARY = new Month("January", 31);
    public static final Month FEBRUARY = new Month("February", 28); // Assuming non-leap year
    public static final Month MARCH = new Month("March", 31);
    public static final Month APRIL = new Month("April", 30);
    public static final Month MAY = new Month("May", 31);
    public static final Month JUNE = new Month("June", 30);
    public static final Month JULY = new Month("July", 31);
    public static final Month AUGUST = new Month("August", 31);
    public static final Month SEPTEMBER = new Month("September", 30);
    public static final Month OCTOBER = new Month("October", 31);
    public static final Month NOVEMBER = new Month("November", 30);
    public static final Month DECEMBER = new Month("December", 31);

}
