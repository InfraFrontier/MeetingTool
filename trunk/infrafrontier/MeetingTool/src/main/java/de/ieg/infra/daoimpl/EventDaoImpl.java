package de.ieg.infra.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import de.ieg.infra.dao.EventDao;
import de.ieg.infra.domain.Event;

/**
 * @author steinkamp
 * Implementation of the {@link EventDao}
 *
 */
public class EventDaoImpl extends JdbcTemplate implements EventDao {

	protected org.apache.log4j.Logger logger = Logger.getLogger(EventDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see de.ieg.infra.dao.EventBookingDao#findAllActiveEvents()
	 */
	public List<Event> findAllActiveEvents() throws DataAccessException {
		logger.info("findAllActiveEvents");
		String sql= "SELECT event_id,event_name,event_start,event_end,event_place,"
					+"event_contact,event_record_number,event_is_active,event_comment,event_form "
					+"FROM events where event_is_active=? order by event_id ASC";
		List<Event> events=query(sql,new Object [] {1},new EventRowMapper());
		return events;
	}





	/**
	 * @author steinkamp
	 * Event mapper
	 *
	 */
	class EventRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Event event= new Event();
			event.setId(rs.getInt("event_id"));
			event.setName(rs.getString("event_name"));
			event.setStart(rs.getString("event_start"));
			event.setEnd(rs.getString("event_end"));
			event.setPlace(rs.getString("event_place"));
			event.setEventContact(rs.getString("event_contact"));
			event.setEventRecordNumber(rs.getString("event_record_number"));
			event.setActive(rs.getBoolean("event_is_active"));
			event.setComment(rs.getString("event_comment"));
			event.setForm(rs.getString("event_form"));
			return event;

		}
	}

}
