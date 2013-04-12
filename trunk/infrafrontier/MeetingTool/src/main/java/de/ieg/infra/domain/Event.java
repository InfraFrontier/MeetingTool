package de.ieg.infra.domain;

import java.util.Date;
import java.util.List;

/**
 * @author steinkamp
 *	Represents an infrafrontier event
 */
public class Event {
	private Integer id;
	private String name;
	private String start;
	private String end;
	private String place;
	private String eventContact;
	private String eventRecordNumber;
	private String comment;
	private String form;
	private boolean active;
	private List<Booking> bookings;
	private Booking booking;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getEventContact() {
		return eventContact;
	}
	public void setEventContact(String eventNumber) {
		this.eventContact = eventNumber;
	}
	public String getEventRecordNumber() {
		return eventRecordNumber;
	}
	public void setEventRecordNumber(String eventRecordNumber) {
		this.eventRecordNumber = eventRecordNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}

}
