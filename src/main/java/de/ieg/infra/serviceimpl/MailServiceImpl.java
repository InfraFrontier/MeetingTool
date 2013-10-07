package de.ieg.infra.serviceimpl;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.Event;
import de.ieg.infra.service.MailService;
import de.ieg.infra.utils.Utils;

/**
 * @author steinkamp
 * The implementation of the mail service
 */
public class MailServiceImpl implements MailService {
	private JavaMailSender mailSender;
	private String from;
	private String disaster;
	private String subject;
	private String subjectUpdatedBookingList;

	/**
	 * Sets a reference of the mail sender
	 * @param mailSender
	 */
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * @return the disaster
	 */
	public String getDisaster() {
		return disaster;
	}

	/**
	 * @param disaster the disaster to set
	 */
	public void setDisaster(String disaster) {
		this.disaster = disaster;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSubjectUpdatedBookingList(String subjectUpdatedBookingList) {
		this.subjectUpdatedBookingList = subjectUpdatedBookingList;
	}


	/* (non-Javadoc)
	 * @see de.ieg.infra.service.MailService#sendBookingConfirmation(de.ieg.infra.domain.Event)
	 */
	public synchronized void  sendBookingConfirmation(Event event,String text)throws MessagingException {
		List<String> emailAddesses = new ArrayList<String>();
		String commingFrom;
			if(event.getEventContact()!=null){
				commingFrom=event.getEventContact();//RST 310112
			}
			else{
				commingFrom=from;
			}
			emailAddesses.add(commingFrom);
			Booking booking=event.getBooking();
			emailAddesses.add(booking.getEmail());
			String subject=this.subject + event.getName();

			String[] addresses = ( String[] )emailAddesses.toArray( new String[ emailAddesses.size() ] );


			this.sendEmail(addresses, text,commingFrom, subject);
	}


	/* (non-Javadoc)
	 * @see de.ieg.infra.service.MailService#sendBookings4Event(de.ieg.infra.domain.Event)
	 */
	public synchronized void sendBookings4Event(Event event,String text)throws MessagingException {
		List<String> emailAddesses = new ArrayList<String>();
		Booking booking=event.getBooking();

		String commingFrom;
		if(event.getEventContact()!=null){
			commingFrom=event.getEventContact();//RST 310112
		}
		else{
			commingFrom=from;
		}
		emailAddesses.add(commingFrom);

		String[] addresses = ( String[] )emailAddesses.toArray( new String[ emailAddesses.size() ] );
		String subject=this.subjectUpdatedBookingList + event.getName();
		this.sendEmail(addresses, text,commingFrom, subject);
	}


	/**
	 * Sends an email
	 * @param emailAddresses
	 * @param text
	 * @param subject
	 * @throws MessagingException
	 */
	private void sendEmail(String [] emailAddresses, String text,String commingFrom, String subject) throws MessagingException{
		MimeMessage message = mailSender.createMimeMessage();
		message.setSubject(subject);
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(emailAddresses);
		helper.setText(text);
		helper.setFrom(commingFrom);
		mailSender.send(message);
	}




	/* (non-Javadoc)
	 * @see de.ieg.infra.service.MailService#getEmailAddresses()
	 */
	public InternetAddress[] getEmailAddresses() throws DataAccessException,AddressException {
		InternetAddress[] emailAddresses=null;

		return emailAddresses;
	}

}
