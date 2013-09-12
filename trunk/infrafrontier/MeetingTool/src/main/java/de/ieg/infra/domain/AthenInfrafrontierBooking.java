package de.ieg.infra.domain;

public class AthenInfrafrontierBooking extends Booking{
	private String vegetarian;
	private Integer numberOfNights;
	private String hotelYesNo;
	private boolean needHotel;
	private String breakoutSession;


	

	public Integer getNumberOfNights() {
		return numberOfNights;
	}

	public void setNumberOfNights(Integer numberOfNights) {
		this.numberOfNights = numberOfNights;
	}

	public String getVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(String vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isNeedHotel() {
		return hotelYesNo!=null&& hotelYesNo.equals("yes")?true:false;
	}



	public String getHotelYesNo() {
		return hotelYesNo;
	}

	public void setHotelYesNo(String hotelNeeded) {
		this.hotelYesNo = hotelNeeded;
	}
	
	public String getBreakoutSession() {
		return breakoutSession;
	}

	public void setBreakoutSession(String breakoutSession) {
		this.breakoutSession = breakoutSession;
	}

}
