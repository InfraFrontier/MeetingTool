package de.ieg.infra.domain;

import java.util.Date;
import java.util.List;

public class InfImpcIkmcRomeWorkshopBooking extends Booking{
	private String impcWorkshop;
	private String eucommWorkshop;
	
	public String getImpcWorkshop() {
		return impcWorkshop;
	}
	public void setImpcWorkshop(String impcWorkshop) {
		this.impcWorkshop = impcWorkshop;
	}
	public String getEucommWorkshop() {
		return eucommWorkshop;
	}
	public void setEucommWorkshop(String eucommWorkshop) {
		this.eucommWorkshop = eucommWorkshop;
	}
	

}
