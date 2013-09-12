package de.ieg.infra.daoimpl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import de.ieg.infra.dao.BookingDao;
import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.InfImpcIkmcRome1Booking;
import de.ieg.infra.domain.InfImpcIkmcRomeWorkshopBooking;
import de.ieg.infra.domain.InfrafrontierI3KickOffMeetingBooking;
import de.ieg.infra.domain.AthenInfrafrontierBooking;

public class BookingDaoImpl extends JdbcTemplate implements BookingDao{

	public void insertInfrafrontierI3AthensMeetingBooking(Integer eventId, AthenInfrafrontierBooking booking) throws DataAccessException{
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
	
	public void insertInfImpcIkmcRome1Booking(Integer eventId, InfImpcIkmcRome1Booking booking) throws DataAccessException{
		String sql="INSERT INTO bookings ("
        +"booking_event,"
		+"booking_first_name,"
        +"booking_second_name,"
        +"booking_email,"
        +"booking_remarks,"
        +"booking_institution,"
        +"booking_country," +
        "booking_sex," +
        "booking_hotel_needed," +
        "booking_hotel_details," +
        "booking_flight_needed," +
        "booking_outbound_flight_from," +
        "booking_outbound_flight_to," +
        "booking_outbound_flight_date," +
        "booking_outbound_flight_time," +
        "booking_return_flight_from," +
        "booking_return_flight_to," +
        "booking_return_flight_date," +
        "booking_return_flight_time" +
        "" +
        ") "
        +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry(),booking.getSex(),booking.getNeedHotel(),
			booking.getHotelRemarks(),booking.getFlightNeeded(),booking.getOutboundFlightFrom(),booking.getOutboundFlightTo(),booking.getOutboundFlightDate(),booking.getOutboundFlightTime(),
			booking.getReturnFlightFrom(),booking.getReturnFlightTo(),booking.getReturnFlightDate(),booking.getReturnFlightTime()});
}
	
	public void insertInfImpcIkmcRomeWorkshopBooking(Integer eventId,InfImpcIkmcRomeWorkshopBooking booking) throws DataAccessException{
		String sql="INSERT INTO bookings ("
        +"booking_event,"
		+"booking_first_name,"
        +"booking_second_name,"
        +"booking_email,"
        +"booking_remarks,"
        +"booking_institution,"
        +"booking_country" +
        ") "
        +"VALUES (?,?,?,?,?,?,?)";

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry()});
}
	
	


}
