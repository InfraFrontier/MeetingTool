package de.ieg.infra.dao;

import org.springframework.dao.DataAccessException;

import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.InfImpcIkmcRome1Booking;
import de.ieg.infra.domain.InfImpcIkmcRomeWorkshopBooking;
import de.ieg.infra.domain.InfrafrontierI3KickOffMeetingBooking;

/**
 * @author steinkamp
 * A dao for booking entities
 *
 */
public interface BookingDao {

	/**
	 * Inserts a new booking for a given event
	 * @param eventId
	 * @param booking
	 * @throws DataAccessException
	 */
	public void insertInfrafrontierI3KickOffMeetingBooking(Integer eventId,InfrafrontierI3KickOffMeetingBooking booking) throws DataAccessException;
	
	public void insertInfImpcIkmcRome1Booking(Integer eventId, InfImpcIkmcRome1Booking booking) throws DataAccessException;
	
	public void insertInfImpcIkmcRomeWorkshopBooking(Integer eventId,InfImpcIkmcRomeWorkshopBooking booking) throws DataAccessException;

}
