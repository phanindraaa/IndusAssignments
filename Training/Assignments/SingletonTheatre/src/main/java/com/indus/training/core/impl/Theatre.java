package com.indus.training.core.impl;

public class Theatre {

	// Static instance of the singleton class
	private static Theatre movieTheatreObj = null;

	public static int totalSeats;

	// Private constructor to prevent instantiation
	private Theatre(int totalSeats) {
		Theatre.totalSeats = totalSeats;
	}

	// Public method to provide access to the instance
	public static Theatre getMovieTheatreInstance(int totalSeats) {
		if (movieTheatreObj == null) {
			movieTheatreObj = new Theatre(totalSeats);
		}
		return movieTheatreObj;
	}

	public boolean bookSeat() {
		if (totalSeats > 0) {
			totalSeats -= 1;
			return true;
		}
		return false;
	}

	public int getRemSeats() {
		return totalSeats;
	}
}
