package de.ieg.infra.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import de.ieg.infra.domain.Event;
import de.ieg.infra.domain.InfImpcIkmcRome1Booking;
import de.ieg.infra.utils.Utils;

public class InfImpcIkmcRomeBookingBean extends BookingBean{
	
	private InfImpcIkmcRome1Booking booking=new InfImpcIkmcRome1Booking();
	
	
	
	public InfImpcIkmcRome1Booking getBooking() {
		return booking;
	}



	public void setBooking(
			InfImpcIkmcRome1Booking infImpcIkmcRome1Booking) {
		this.booking = infImpcIkmcRome1Booking;
	}
	
	public String parseDate(Date date){
		String sDate="";
		if(date!=null){
			SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
			sDate=sdf.format(date);
		}
		return sDate;
	}
	
	//public List<String> appendNumberOfNignts(List)



	@Override
	public String generateEmailConfirmationText(){
		StringBuffer text=new StringBuffer("New subscription by ");
		text.append(booking.getFirstName() + " " + booking.getLastName() +"\r\n\r\n");
		//event
		text.append("Event:            ");
		text.append(event.getName());
		text.append("\r\n");
		text.append("Place:            ");
		text.append(event.getPlace());
		text.append("\r\n");
		text.append("\r\n");
		text.append("From:             ");
		text.append(event.getStart());
		text.append("\r\n");
		text.append("To:               ");
		text.append(event.getEnd());
		text.append("\r\n");
		text.append("\r\n");

		//personal infos
		text.append("Personal information\r\n");
		text.append("Last name:        ");
		text.append(booking.getLastName());
		text.append("\r\n");
		text.append("First name:       ");
		text.append(booking.getFirstName());
		text.append("\r\n");
		text.append("Sex:              ");
		text.append(booking.getSex());
		text.append("\r\n");
		text.append("E-mail:           ");
		text.append(booking.getEmail());
		text.append("\r\n");
		text.append("Institution:      ");
		text.append(booking.getCountry());
		text.append("\r\n");
		text.append("Country:          ");
		text.append(booking.getInstitution());
		text.append("\r\n");
		text.append("\r\n");

		//Hotel
		text.append("Accomodation Bettoja Hotels\r\n");
		text.append("Hotel needed:     ");
		text.append(booking.getHotelYesNo());
		text.append("\r\n");
		text.append("Number of nights: ");
		text.append(booking.getNumberOfNights());
		text.append("\r\n");
		text.append("Other remarks:    ");
		text.append(booking.getHotelRemarks());
		text.append("\r\n");
		text.append("\r\n");
		
		//Travel
		text.append("Travel\r\n");
		text.append("Flight need:       ");
		text.append(booking.getFlightNeeded());
		text.append("\r\n");
		text.append("\r\n");
		
		text.append("Flight to meeting  "  );
		text.append("\r\n");
		text.append("From:              ");
		text.append(booking.getOutboundFlightFrom());
		text.append("\r\n");
		text.append("To:                ");
		text.append(booking.getOutboundFlightTo());
		text.append("\r\n");
		text.append("Date:               ");
		text.append(parseDate(booking.getOutboundFlightDate()));
		text.append("\r\n");
		text.append("Arrival time:       ");
		text.append(booking.getOutboundFlightTime());
		
		text.append("\r\n");
		text.append("\r\n");
		text.append("Flight from meeting  "  );
		text.append("\r\n");
		text.append("From:              ");
		text.append(booking.getReturnFlightFrom());
		text.append("\r\n");
		text.append("To:                ");
		text.append(booking.getReturnFlightTo());
		text.append("\r\n");
		text.append("Date:               ");
		text.append(parseDate(booking.getReturnFlightDate()));
		text.append("\r\n");
		text.append("Departure time:       ");
		text.append(booking.getReturnFlightTime());
		text.append("\r\n");
		text.append("\r\n");

		//Remarks
		text.append("Remarks:          ");
		text.append(booking.getRemarks());
		text.append("\r\n");
		text.append("\r\n");

		return text.toString();
	}
	
	
	@Override
	public  String generateBookingText(){
		StringBuffer text= new StringBuffer("Bookings for " + event.getName() + " so far (copy and paste lines below to Excel\r\n\r\n");
		text.append(event.getName());
		text.append("\t");
		text.append(booking.getFirstName());
		text.append("\t");
		text.append(booking.getLastName());
		text.append("\t");
		text.append(booking.getEmail());
		text.append("\t");
		text.append(booking.getSex());
		text.append("\t");
		text.append(booking.getInstitution());
		text.append("\t");
		text.append(booking.getCountry());
		text.append("\t");
		text.append(booking.getHotelYesNo());
		text.append("\t");
		text.append(booking.getNumberOfNights()!=null?booking.getNumberOfNights().toString():null);
		text.append("\t");
		text.append(booking.getHotelRemarks());
		text.append("\t");
		text.append("\t");
		text.append(booking.getFlightNeeded());
		text.append("\t");
		text.append(booking.getOutboundFlightFrom());
		text.append("\t");
		text.append(booking.getOutboundFlightTo());
		text.append("\t");
		text.append(parseDate(booking.getOutboundFlightDate()));
		text.append("\t");
		text.append(booking.getOutboundFlightTime());
		text.append("\t");
		text.append(booking.getReturnFlightFrom());
		text.append("\t");
		text.append(booking.getReturnFlightTo());
		text.append("\t");
		text.append(parseDate(booking.getReturnFlightDate()));
		text.append("\t");
		text.append(booking.getReturnFlightTime());
		text.append("\t");
		text.append(booking.getRemarks());
		text.append("\t");
		
		return text.toString();
	}
	
	/**
	 * Handles save events
	 * @param ev {@link ActionEvent}
	 */
	public void bookEvent(ActionEvent ev){
		try {
			Event event=this.getEvent();
			event.setBooking(booking);
			
			bookingDao.insertInfImpcIkmcRome1Booking(event.getId(),booking);
			String confirmationText=this.generateEmailConfirmationText();
			String bookingText=this.generateBookingText();
			super.sendEmailConfirmation(event,confirmationText,bookingText);
			Utils.addInfoMessage("bookingForm", "Your booking was submitted. A confirmation message will be sent to your email address.");
			booking=new InfImpcIkmcRome1Booking();;
		}
		catch(Exception ex) {
			Logger.getLogger(BookingBean.class).error("bookEvent() creates an error: " +ex.getMessage());
			Utils.addErrorMessage("bookingForm:bookGrid","Error! Booking failed. Please contact the infrafrontier management");
		}

	}

}
