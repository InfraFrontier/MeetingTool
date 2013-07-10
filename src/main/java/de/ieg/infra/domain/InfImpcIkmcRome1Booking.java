package de.ieg.infra.domain;

import java.util.Date;
import java.util.List;

import de.ieg.infra.utils.Utils;

public class InfImpcIkmcRome1Booking extends Booking{
	private String sex;
	private String needHotel;
	private String hotelYesNo;
	private String hotelRemarks;
	private List<String> numberOfNights;
	private String flightNeeded;
	private String outboundFlightFrom;
	private String outboundFlightTo;
	private Date outboundFlightDate;
	private String outboundFlightTime;
	private String outboundFlightHour;
	private String outboundFlightMinute;
	private String returnFlightFrom;
	private String returnFlightTo;
	private Date returnFlightDate;
	private String returnFlightTime;
	private String returnFlightHour;
	private String returnFlightMinute;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNeedHotel() {
		return needHotel;
	}
	public void setNeedHotel(String needHotel) {
		this.needHotel = needHotel;
	}
	public String getHotelYesNo() {
		return hotelYesNo;
	}
	public void setHotelYesNo(String hotelYesNo) {
		this.hotelYesNo = hotelYesNo;
	}
	public List<String> getNumberOfNights() {
		return numberOfNights;
	}
	public void setNumberOfNights(List<String> numberOfNights) {
		this.numberOfNights = numberOfNights;
	}
	public String getFlightNeeded() {
		return flightNeeded;
	}
	public void setFlightNeeded(String flightNeeded) {
		this.flightNeeded = flightNeeded;
	}
	public String getOutboundFlightFrom() {
		return outboundFlightFrom;
	}
	public void setOutboundFlightFrom(String outboundFlightFrom) {
		this.outboundFlightFrom = outboundFlightFrom;
	}
	public String getOutboundFlightTo() {
		return outboundFlightTo;
	}
	public void setOutboundFlightTo(String outboundFlightTo) {
		this.outboundFlightTo = outboundFlightTo;
	}
	public Date getOutboundFlightDate() {
		return outboundFlightDate;
	}
	public void setOutboundFlightDate(Date outboundFlightDate) {
		this.outboundFlightDate = outboundFlightDate;
	}
	
	public String getOutboundFlightHour() {
		return outboundFlightHour;
	}
	public void setOutboundFlightHour(String outboundFlightHour) {
		this.outboundFlightHour = outboundFlightHour;
	}
	public String getOutboundFlightMinute() {
		return outboundFlightMinute;
	}
	public void setOutboundFlightMinute(String outboundFlightMinute) {
		this.outboundFlightMinute = outboundFlightMinute;
	}
	public String getReturnFlightFrom() {
		return returnFlightFrom;
	}
	public void setReturnFlightFrom(String returnFlightFrom) {
		this.returnFlightFrom = returnFlightFrom;
	}
	public String getReturnFlightTo() {
		return returnFlightTo;
	}
	public void setReturnFlightTo(String returnFlightTo) {
		this.returnFlightTo = returnFlightTo;
	}
	public Date getReturnFlightDate() {
		return returnFlightDate;
	}
	public void setReturnFlightDate(Date returnFlightDate) {
		this.returnFlightDate = returnFlightDate;
	}
	
	public String getReturnFlightHour() {
		return returnFlightHour;
	}
	public void setReturnFlightHour(String returnFlightHour) {
		this.returnFlightHour = returnFlightHour;
	}
	public String getReturnFlightMinute() {
		return returnFlightMinute;
	}
	public void setReturnFlightMinute(String returnFlightMinute) {
		this.returnFlightMinute = returnFlightMinute;
	}
	
	public String getOutboundFlightTime() {
		this.outboundFlightHour=this.outboundFlightHour==null || this.outboundFlightHour.equals("-please_select-")? "":this.outboundFlightHour;
		this.outboundFlightMinute=this.outboundFlightMinute==null || this.outboundFlightMinute.equals("-please_select-")? "":this.outboundFlightMinute;
		outboundFlightTime=this.outboundFlightHour + ":" + this.outboundFlightMinute;

		return outboundFlightTime;
	}
	
	public String getReturnFlightTime() {
		this.returnFlightHour=this.returnFlightHour==null || this.returnFlightHour.equals("-please_select-")? "":this.returnFlightHour;
		this.returnFlightMinute=this.returnFlightMinute==null || this.returnFlightMinute.equals("-please_select-")? "":this.returnFlightMinute;
		returnFlightTime=this.returnFlightHour +":" +this.returnFlightMinute;
		return returnFlightTime;
	}
	
	public String getHotelRemarks() {
		return hotelRemarks;
	}
	public void setHotelRemarks(String hotelRemarks) {
		this.hotelRemarks = hotelRemarks;
	}
	
	
	

}
