package de.ieg.infra.domain;


import java.util.Date;

import java.util.List;


public class ManagementWorkshopBooking extends Booking {
	private List<String> numberOfNights;
	private String accommodationYesNo;
	private boolean needAccommodation;
	private String arrivalTime;
	private String depatureTime;

	public List<String> getNumberOfNights() {
		return numberOfNights;

	}

	public void setNumberOfNights(List<String> numberOfNights) {
		this.numberOfNights = numberOfNights;

	}

	public String getAccommodationYesNo() {
		return accommodationYesNo;

	}

	public void setAccommodationYesNo(String AccommodationYesNo) {
		this.accommodationYesNo = AccommodationYesNo;

	}

	public boolean isNeedaccommodation() {
		return needAccommodation;

	}

	public void setNeedAccommodation(boolean needAccommodation) {
		this.needAccommodation = needAccommodation;

	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

}
