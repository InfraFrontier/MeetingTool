package de.ieg.infra.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;

import de.ieg.infra.dao.BookingDao;
import de.ieg.infra.dao.EventDao;

import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.Event;
import de.ieg.infra.service.MailService;
import de.ieg.infra.utils.Utils;

/**
 * @author steinkamp
 * Abstract managed bean for the booking form
 *
 */
public abstract class BookingBean {
	protected Event event;
	protected BookingDao bookingDao;
	private MailService mailService;


	/**
	 * Returns an event
	 * @return
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Sets an event
	 * @param event
	 */
	public void setEvent(Event event) {
		this.event = event;
	}


	/**
	 * Sets a mail service
	 * @param mailService
	 */
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	/**
	 * Returns a reference to the {@link BookingDao}
	 * @return
	 */
	public BookingDao getBookingDao() {
		return bookingDao;
	}

	/**
	 * Sets a reference to the {@link BookingDao}
	 * @param bookingDao
	 */
	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}


//*************************** methods*******************************************


	/**
	 * Generates an email confirmation text for the subscriber
	 * @return
	 */
	public abstract String generateEmailConfirmationText();


	/**
	 * Generates a text with booking information that
	 * can be paste into an excel file. This information is used by the person who organized the meeting
	 * @return
	 */
	public abstract String generateBookingText();




	/**
	 * Validates the email address
	 * @param{@link FacesContext}
	 * @param {@link {@link UIComponent}}
	 * @param value {@link Object} the email address
	 * @throws ValidatorException
	 */
	public void validateEmail(FacesContext ctx,UIComponent component,Object value)throws ValidatorException {
		if(!((String)value).matches(".*@.*")){
			throw new ValidatorException(new FacesMessage("This is not a valid email address!"));
		}
	}

	/**
	 * Checks common mandatory form fields
	 * @return a boolean flag (true for ok)
	 */
	/*public boolean checkCommonFields(Booking booking) {
		boolean isOk=true;

		if(booking.getLastName()==null || booking.getLastName().equals("")){
			isOk=false;
			Utils.addInfoMessage("bookingForm:lastName","Last Name: Value is required");
		}
		if(booking.getFirstName()==null || booking.getFirstName().equals("")){
			isOk=false;
			Utils.addInfoMessage("bookingForm:firstName","First Name: Value is required");
		}
		if(booking.getInstitution()==null || booking.getInstitution().equals("")){
			isOk=false;
			Utils.addInfoMessage("bookingForm:institution","Institution: Value is required");
		}
		if(booking.getCountry()==null || booking.getCountry().equals("")){
			isOk=false;
			Utils.addInfoMessage("bookingForm:country","Country: Value is required");
		}

		return isOk;
	}*/




	/**
	 * Sends a confirmation to the subscriber
	 * @param {@link Event}
	 * @param confirmationtext
	 * @param bookingText
	 * @throws Exception
	 */
	public void sendEmailConfirmation(Event event,String confirmationtext,String bookingText)throws Exception {

		if(event!=null) {
				this.mailService.sendBookingConfirmation(event,confirmationtext);
				mailService.sendBookings4Event(event,bookingText);
		}
		else {
			Utils.addErrorMessage("bookingForm:bookGrid", "Info! You must first select an event!");
		}
	}

}
