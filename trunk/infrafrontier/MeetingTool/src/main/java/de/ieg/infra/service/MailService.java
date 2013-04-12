package de.ieg.infra.service;

import java.net.ConnectException;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.dao.DataAccessException;

import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.Event;

/**
 * @author steinkamp
 * A service for sending emails
 *
 */
public interface MailService {

	/**
	 * Sends a confirmation for a booking
	 * @param event
	 * @throws Exception
	 * @throws MessagingException
	 */
	public void sendBookingConfirmation(Event event,String text)throws Exception,MessagingException;

	/**
	 * Sends a mail that contains all bookings for an event
	 * @param event
	 * @throws Exception
	 * @throws MessagingException
	 */
	public void sendBookings4Event(Event event,String text)throws Exception,MessagingException;

	/**
	 * Returns the eamail addresses of the managers
	 * @return
	 * @throws DataAccessException
	 * @throws AddressException
	 */
	public InternetAddress [] getEmailAddresses() throws DataAccessException,AddressException;






}
