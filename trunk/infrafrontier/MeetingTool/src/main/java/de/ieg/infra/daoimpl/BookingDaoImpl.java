package de.ieg.infra.daoimpl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import de.ieg.infra.dao.BookingDao;
import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.InfrafrontierI3KickOffMeetingBooking;

public class BookingDaoImpl extends JdbcTemplate implements BookingDao{

	public void insertInfrafrontierI3KickOffMeetingBooking(Integer eventId, InfrafrontierI3KickOffMeetingBooking booking) throws DataAccessException{
				String sql="INSERT INTO bookings ("
		        +"booking_event,"
				+"booking_first_name,"
		        +"booking_second_name,"
		        +"booking_email,"
		        +"booking_remarks,"
		        +"booking_institution,"
		        +"booking_country) "
		        +"VALUES (?,?,?,?,?,?,?)";

			update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry()});
		}


}
