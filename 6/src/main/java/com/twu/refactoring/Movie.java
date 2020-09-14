package com.twu.refactoring;

public class Movie {
	public static final int  CHILDREN = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;
	private static final int CHILDREN_RENTED_DAY_NUM_FOR_FREE = 3;
	private static final int REGULAR_RENTED_DAY_NUM_FOR_FREE = 2;
	private static final int NEW_RELEASE_RENTED_DAY_NUM_FOR_FREE = 0;
	private static final double CHILDREN_PRICE = 1.5;
	private static final double REGULAR_PRICE = 1.5;
	private static final int NEW_RELEASE_PRICE = 3;
	private static final double CHILDREN_PRIMARY_PRICE = 1.5;
	private static final double REGULAR_PRIMARY_PRICE = 2;
	private static final int NEW_RELEASE_PRIMARY_PRICE = 0;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getCouldRentedForFree() {
		if (priceCode == CHILDREN) {
			return CHILDREN_RENTED_DAY_NUM_FOR_FREE;
		}
		if (priceCode == REGULAR) {
			return REGULAR_RENTED_DAY_NUM_FOR_FREE;
		}
		return NEW_RELEASE_RENTED_DAY_NUM_FOR_FREE;
	}

	public double getPrimaryPrice() {
		if (priceCode == CHILDREN) {
			return CHILDREN_PRIMARY_PRICE;
		}
		if (priceCode == REGULAR) {
			return REGULAR_PRIMARY_PRICE;
		}
		return NEW_RELEASE_PRIMARY_PRICE;
	}

	public  double getPricePerDay() {
		if (priceCode == CHILDREN) {
			return CHILDREN_PRICE;
		}
		if (priceCode == REGULAR) {
			return REGULAR_PRICE;
		}
		return NEW_RELEASE_PRICE;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}
}

