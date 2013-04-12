package de.ieg.infra.controller;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import de.ieg.infra.dao.EventDao;

import de.ieg.infra.domain.Event;
import de.ieg.infra.utils.Utils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author steinkamp
 * A managed bean for the event form
 */

//@Component
//@ManagedBean
//@Scope("session")
public class EventBean {
	private List<Event> events;
	
	@Autowired
	private EventDao eventDao;
	
	private HtmlDataTable eventTable;
	private Event selectedEvent;

	protected org.apache.log4j.Logger logger = Logger.getLogger(EventBean.class);
			
	
	public EventBean() {
		//this.init();
	}
	
	/**
	 * Initialize the event table
	 */
	public void init() {
		try {
			logger.debug("======================\n");
			logger.debug("init");
			this.events=eventDao.findAllActiveEvents();
			logger.debug("number of events" + events.size());
			logger.debug("======================\n");
		}
		catch(DataAccessException ex) {
			ex.printStackTrace();
			org.apache.log4j.Logger.getLogger(EventBean.class).error("The initialization of the event table failed! "+ ex.getMessage());
		}
	}

	/**
	 * Refresh's the event table view
	 */
	public void refreshEvents() {
		logger.debug("refreshEvents");
		this.init();
	}

	/**
	 * Returns a list with events
	 * @return {@link List<Event>}
	 */
	public List<Event> getEvents() {
		logger.debug("getEvents");
		return events;
	}

	/**
	 * Returns a reference of the event data table
	 * @return {@link HtmlDataTable}
	 */
	public HtmlDataTable getEventTable() {
		logger.debug("getEventTable");
		return eventTable;
	}

	/**
	 * Sets a reference to the event data table
	 * @param {@link HtmlDataTable}
	 */
	public void setEventTable(HtmlDataTable eventTable) {
		logger.debug("setEventTable");
		this.eventTable = eventTable;
	}

	/**
	 * Sets a dao for event booking
	 * @param eventDao
	 */
	public void setEventDao(EventDao eventBookingDao) {
		logger.debug("setEventDao");
		this.eventDao = eventBookingDao;
		//refreshEvents();
	}

//*******************************actions******************************************

	/**
	 * Navigates to the booking form
	 * @return {@link String} the navigation outcome
	 */
	public String showBookingForm() {
		String navigationOutcome="";
		selectedEvent=(Event)this.eventTable.getRowData();
		String beanName=selectedEvent.getForm()+"Bean";
		logger.debug("showBookingForm: " + beanName);
		// BookingFormI3KickOffBean i3KickOffBookingBean
		navigationOutcome=selectedEvent.getForm();
		BookingBean bookingBean=(BookingBean)Utils.getManagedBean(beanName);

		bookingBean.setEvent(selectedEvent);
		if(selectedEvent!=null) {
			navigationOutcome= selectedEvent.getForm();
		}
		return navigationOutcome;
	}

}
