package de.ieg.infra.daoimpl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import de.ieg.infra.dao.BookingDao;
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
	
	
	public void insertMunichWorkshopBooking(Integer eventId,MunichWorkshopBooking  booking) throws DataAccessException{
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
        +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry(),booking.getSex(),booking.getAccommodationYesNo(),
			booking.getFlightNeeded(),booking.getOutboundFlightFrom(),booking.getOutboundFlightTo(),booking.getOutboundFlightDate(),booking.getOutboundFlightTime(),
			booking.getReturnFlightFrom(),booking.getReturnFlightTo(),booking.getReturnFlightDate(),booking.getReturnFlightTime()});
	}
	
	
	public void insertManagementWorkshopBooking(Integer eventId,ManagementWorkshopBooking  booking) throws DataAccessException{
		String sql="INSERT INTO bookings ("
        +"booking_event,"
		+"booking_first_name,"
        +"booking_second_name,"
        +"booking_email"
        +") "
        +"VALUES (?,?,?,?)";

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail()});
	}
	
	public void insertPragueWorkshopBooking(Integer eventId,PragueWorkshopBooking  booking) throws DataAccessException{
		String sql="INSERT INTO bookings ("
        +"booking_event,"
		+"booking_first_name,"
        +"booking_second_name,"
        +"booking_email,"
        +"booking_remarks,"
        +"booking_institution,"
        +"booking_country," 
        +"booking_hotel_needed,"
        +"booking_attend_dinner"
        +") "
        +"VALUES (?,?,?,?,?,?,?,?,?)";

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry(),booking.getAccommodationYesNo(),booking.getDinnerNeeded()});
	}
        
        
        public void insertBarcelonaWorkshopBooking(Integer eventId, BarcelonaWorkshopBooking booking) throws DataAccessException{
            System.out.println("the method to insert booking has been called");
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
        +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry(),booking.getSex(),booking.getAccommodationYesNo(),
			booking.getFlightNeeded(),booking.getOutboundFlightFrom(),booking.getOutboundFlightTo(),booking.getOutboundFlightDate(),booking.getOutboundFlightTime(),
			booking.getReturnFlightFrom(),booking.getReturnFlightTo(),booking.getReturnFlightDate(),booking.getReturnFlightTime()});
}
	
public void insertMarseilleWorkshopBooking(Integer eventId, MarseilleWorkshopBooking booking) throws DataAccessException{
            System.out.println("the method to insert booking has been called");
		String sql="INSERT INTO bookings ("
        +"booking_event,"
		+"booking_first_name,"
        +"booking_second_name,"
        +"booking_email,"
        +"booking_remarks,"
        +"booking_institution,"
        +"booking_country," +
        "booking_sex," +
        "booking_hotel_needed,"
        +"booking_attend_dinner,"
        +"booking_flight_needed," +
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

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry(),booking.getSex(),booking.getAccommodationYesNo(),
			booking.getDinnerYesNo(),booking.getFlightNeeded(),booking.getOutboundFlightFrom(),booking.getOutboundFlightTo(),booking.getOutboundFlightDate(),booking.getOutboundFlightTime(),
			booking.getReturnFlightFrom(),booking.getReturnFlightTo(),booking.getReturnFlightDate(),booking.getReturnFlightTime()});
}

    @Override
    public void insertIpadMdKoWorkshopBooking(Integer eventId, IpadMdKoWorkshopBooking booking) throws DataAccessException{
            System.out.println("the method to insert booking has been called");
		String sql="INSERT INTO bookings ("
        +"booking_event,"
		+"booking_first_name,"
        +"booking_second_name,"
        +"booking_email,"
        +"booking_remarks,"
        +"booking_institution,"
        +"booking_country," +
        "booking_sex," +
        "booking_hotel_needed,"
        +"booking_attend_dinner,"
        +"booking_flight_needed," +
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
                
                System.out.println("IPAD MEETING BOOKING SQL IS :: " + sql);

	update(sql,new Object [] {eventId,booking.getFirstName(),booking.getLastName(),booking.getEmail(),booking.getRemarks(),booking.getInstitution(),booking.getCountry(),booking.getSex(),booking.getAccommodationYesNo(),
			booking.getDinnerYesNo(),booking.getFlightNeeded(),booking.getOutboundFlightFrom(),booking.getOutboundFlightTo(),booking.getOutboundFlightDate(),booking.getOutboundFlightTime(),
			booking.getReturnFlightFrom(),booking.getReturnFlightTo(),booking.getReturnFlightDate(),booking.getReturnFlightTime()});
}
}
