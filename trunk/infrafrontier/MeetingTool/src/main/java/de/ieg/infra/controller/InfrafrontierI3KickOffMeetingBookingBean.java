package de.ieg.infra.controller;

import javax.faces.event.ActionEvent;
import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.MailException;

import de.ieg.infra.domain.Event;
import de.ieg.infra.domain.InfrafrontierI3KickOffMeetingBooking;
import de.ieg.infra.utils.Utils;

/**
 * @author steinkamp
 * Managed bean for the specified event
 *
 */
public class InfrafrontierI3KickOffMeetingBookingBean extends BookingBean {

	private InfrafrontierI3KickOffMeetingBooking booking=new InfrafrontierI3KickOffMeetingBooking();


	/**
	 * Returns a booking
	 * @return
	 */
	public InfrafrontierI3KickOffMeetingBooking getBooking() {
		return booking;
	}

	/**
	 * Sets a booking
	 * @param booking
	 */
	public void setBooking(InfrafrontierI3KickOffMeetingBooking booking) {
		this.booking = booking;
	}

	/* (non-Javadoc)
	 * @see de.ieg.infra.controller.BookingBean#generateEmailConfirmationText()
	 */
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
		text.append("\r\n");
		text.append("E-mail:           ");
		text.append(booking.getEmail());
		text.append("\r\n");
		text.append("Country:          ");
		text.append(booking.getCountry());
		text.append("\r\n");
		text.append("Institution:      ");
		text.append(booking.getInstitution());
		text.append("\r\n");
		text.append("\r\n");

		//Dinner
		text.append("Dinner 22 April 2013 at 20:00\r\n");
		text.append("Vegetarian:        ");
		text.append(booking.getVegetarian());
		text.append("\r\n");
		text.append("\r\n");

		//Remarks
		text.append("Remarks:        ");
		text.append(booking.getRemarks());
		text.append("\r\n");
		text.append("\r\n");

		return text.toString();
	}

	/* (non-Javadoc)
	 * @see de.ieg.infra.controller.BookingBean#generateBookingText()
	 */
	@Override
	public  String generateBookingText(){
		StringBuffer text= new StringBuffer("Bookings for " + event.getName() + "so far (copy and paste lines below to Excel\r\n\r\n");
		text.append(event.getName());
		text.append("\t");
		text.append(booking.getFirstName());
		text.append("\t");
		text.append(booking.getLastName());
		text.append("\t");
		text.append(booking.getEmail());
		text.append("\t");
		text.append(booking.getCountry());
		text.append("\t");
		text.append(booking.getInstitution());
		text.append("\t");
		text.append(booking.getVegetarian());
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
			this.getBookingDao().insertInfrafrontierI3KickOffMeetingBooking(event.getId(),booking);
			String confirmationText=this.generateEmailConfirmationText();
			String bookingText=this.generateBookingText();
			super.sendEmailConfirmation(event,confirmationText,bookingText);
			Utils.addInfoMessage("bookingForm", "Your booking was submitted. A confirmation message will be sent to your email address.");
			booking=new InfrafrontierI3KickOffMeetingBooking();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(BookingBean.class).error("bookEvent() creates an error: " +ex.getMessage());
			Utils.addErrorMessage("bookingForm:bookGrid","Error! Booking failed. Please contact the infrafrontier management");
		}

	}



}
