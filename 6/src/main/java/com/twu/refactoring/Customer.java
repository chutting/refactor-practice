package com.twu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();
	private final String STATEMENT_HEAD = "Rental Record for %s\n";
	private final String STATEMENT_FOOTER = "Amount owed is %.1f\n";
	private final String SHOW_RENTER_POINTS= "You earned %d frequent renter points";



	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = String.format(STATEMENT_HEAD, getName());

		while (rentals.hasNext()) {
			Rental eachRental = rentals.next();
			double thisAmount = calculateEachRentalAmount(eachRental);

			frequentRenterPoints++;

			if (couldGetDoublePoints(eachRental)) {
				frequentRenterPoints++;
			}

			result += showFiguresOfRental(eachRental, thisAmount);
			totalAmount += thisAmount;
		}

		return addFooter(result, totalAmount, frequentRenterPoints);
	}

	private double calculateEachRentalAmount(Rental rental) {
		Movie eachMovie = rental.getMovie();

		double thisAmount = eachMovie.getPrimaryPrice();
		if (rental.getDaysRented() > eachMovie.getCouldRentedForFree()) {
			thisAmount += (rental.getDaysRented() - eachMovie.getCouldRentedForFree()) * eachMovie.getPricePerDay();
		}
		return thisAmount;
	}

	private boolean couldGetDoublePoints(Rental rental) {
		return (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1;
	}

	private String showFiguresOfRental(Rental rental, double rentalAmount) {
		return String.format("\t%s\t%.1f\n", rental.getMovie().getTitle(), rentalAmount);
	}

	private String addFooter(String result, double totalAmount, int frequentRenterPoints) {
		result += String.format(STATEMENT_FOOTER, totalAmount);
		result += String.format(SHOW_RENTER_POINTS, frequentRenterPoints);
		return result;
	}

}
