package de.ieg.infra.dao;

import org.springframework.dao.DataAccessException;

import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.InfImpcIkmcRome1Booking;
import de.ieg.infra.domain.InfImpcIkmcRomeWorkshopBooking;
import de.ieg.infra.domain.InfrafrontierI3KickOffMeetingBooking;
import de.ieg.infra.domain.AthenInfrafrontierBooking;
import de.ieg.infra.domain.ManagementWorkshopBooking;
import de.ieg.infra.domain.MunichWorkshopBooking;
import de.ieg.infra.domain.PragueWorkshopBooking;
import de.ieg.infra.domain.BarcelonaWorkshopBooking;
import de.ieg.infra.domain.IpadMdKoWorkshopBooking;
import de.ieg.infra.domain.MarseilleWorkshopBooking;
import de.ieg.infra.domain.impcAnnualMeetingBooking;

/**
 * @author steinkamp A dao for booking entities
 *
 */
public interface BookingDao {

    /**
     * Inserts a new booking for a given event
     *
     * @param eventId
     * @param booking
     * @throws DataAccessException
     */
    public void insertInfrafrontierI3KickOffMeetingBooking(Integer eventId, InfrafrontierI3KickOffMeetingBooking booking) throws DataAccessException;

    public void insertInfImpcIkmcRome1Booking(Integer eventId, InfImpcIkmcRome1Booking booking) throws DataAccessException;

    public void insertInfImpcIkmcRomeWorkshopBooking(Integer eventId, InfImpcIkmcRomeWorkshopBooking booking) throws DataAccessException;

    public void insertInfrafrontierI3AthensMeetingBooking(Integer eventId, AthenInfrafrontierBooking booking) throws DataAccessException;

    public void insertMunichWorkshopBooking(Integer eventId, MunichWorkshopBooking booking) throws DataAccessException;

    public void insertManagementWorkshopBooking(Integer eventId, ManagementWorkshopBooking booking) throws DataAccessException;

    public void insertPragueWorkshopBooking(Integer eventId, PragueWorkshopBooking booking) throws DataAccessException;

    public void insertBarcelonaWorkshopBooking(Integer eventId, BarcelonaWorkshopBooking booking) throws DataAccessException;

    public void insertMarseilleWorkshopBooking(Integer eventId, MarseilleWorkshopBooking booking) throws DataAccessException;

    public void insertIpadMdKoWorkshopBooking(Integer eventId, IpadMdKoWorkshopBooking booking) throws DataAccessException;

    public void insertImpcAnnualMeetingBooking(Integer id, impcAnnualMeetingBooking booking) throws DataAccessException;
}
