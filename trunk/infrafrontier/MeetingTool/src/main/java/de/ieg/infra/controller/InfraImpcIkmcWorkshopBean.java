package de.ieg.infra.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import de.ieg.infra.domain.Event;
import de.ieg.infra.domain.InfImpcIkmcRome1Booking;
import de.ieg.infra.domain.InfImpcIkmcRomeWorkshopBooking;
import de.ieg.infra.utils.Utils;

public class InfraImpcIkmcWorkshopBean  extends BookingBean{
private InfImpcIkmcRomeWorkshopBooking booking=new InfImpcIkmcRomeWorkshopBooking();
	
	
	
	public InfImpcIkmcRomeWorkshopBooking getBooking() {
		return booking;
	}

	public void setBooking(InfImpcIkmcRomeWorkshopBooking infImpcIkmcWorkshopBooking) {
		this.booking = infImpcIkmcWorkshopBooking;
	}
	
	public String parseDate(Date date){
		String sDate;
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
		sDate=sdf.format(date);
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

		//workshops
		text.append("Workshops\r\n");
		text.append("IMPC Workshop:     ");
		text.append(booking.getImpcWorkshop());
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
		text.append(booking.getInstitution());
		text.append("\t");
		text.append(booking.getCountry());
		text.append("\t");
		text.append(booking.getImpcWorkshop());
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
			
			bookingDao.insertInfImpcIkmcRomeWorkshopBooking(event.getId(),booking);
			String confirmationText=this.generateEmailConfirmationText();
			String bookingText=this.generateBookingText();
			super.sendEmailConfirmation(event,confirmationText,bookingText);
			Utils.addInfoMessage("bookingForm", "Your booking was submitted. A confirmation message will be sent to your email address.");
			booking=new InfImpcIkmcRomeWorkshopBooking();;
		}
		catch(Exception ex) {
			Logger.getLogger(BookingBean.class).error("bookEvent() creates an error: " +ex.getMessage());
			Utils.addErrorMessage("bookingForm:bookGrid","Error! Booking failed. Please contact the infrafrontier management");
		}

	}

}
