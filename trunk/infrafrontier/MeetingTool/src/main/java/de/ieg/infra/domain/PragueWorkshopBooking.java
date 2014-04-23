package de.ieg.infra.domain;

import java.util.Date;

import java.util.List;

public class PragueWorkshopBooking extends Booking {

	private List<String> numberOfNights;
	private String accommodationYesNo;
	private boolean needAccommodation;
	private String dinnerNeeded;
		

	public List<String> getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(List<String> numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getAccommodationYesNo() {
		return accommodationYesNo;
	}

	public void setAccommodationYesNo(String accommodationYesNo) {
		this.accommodationYesNo = accommodationYesNo;
	}

	public boolean isNeedAccommodation() {
		return needAccommodation;
	}

	public void setNeedAccommodation(boolean needAccommodation) {
		this.needAccommodation = needAccommodation;
	}

	public String getDinnerNeeded() {
		return dinnerNeeded;
	}

	public void setDinnerNeeded(String dinnerNeeded) {
		this.dinnerNeeded = dinnerNeeded;
	}
}
	
	