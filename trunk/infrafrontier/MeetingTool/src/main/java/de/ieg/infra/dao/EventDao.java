package de.ieg.infra.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import de.ieg.infra.domain.Booking;
import de.ieg.infra.domain.Event;

/**
 * A dao for event entities
 * @author steinkamp
 *
 */
public interface EventDao {

	/**
	 * Selects all active events
	 * @return {@link List<Event>}
	 * @throws DataAccessException
	 */
	public List<Event> findAllActiveEvents() throws DataAccessException;



}
