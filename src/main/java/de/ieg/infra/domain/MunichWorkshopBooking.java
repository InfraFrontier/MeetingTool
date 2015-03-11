package de.ieg.infra.domain;

import java.util.Date;
import java.util.List;

public class MunichWorkshopBooking extends Booking {

    private List<String> numberOfNights;
    private String accommodationYesNo;
    private boolean needAccommodation;
    private String dinnerYesNo;
    private String specialDietary;
    private String dinnerRemarks;
    private boolean needDinner;
    private String sex;
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
    private String flightBookedByOwnInstitution;
    private String flightBookedByInfrafrontier;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;

    }

    public List<String> getNumberOfNights() {
        return numberOfNights;

    }

    public void setNumberOfNights(List<String> numberOfNights) {
        this.numberOfNights = numberOfNights;


    }

    public String getAccommodationYesNo() {
        return accommodationYesNo;

    }

    public void setAccommodationYesNo(String accommodationYesNo) {
        this.accommodationYesNo = accommodationYesNo;

    }

    public boolean isNeedAccommodation() {
        return needAccommodation;

    }

    public void setNeedAccommodation(boolean needAccommodation) {
        this.needAccommodation = needAccommodation;



    }

    public String getDinnerYesNo() {
        return dinnerYesNo;

    }

    public void setDinnerYesNo(String dinnerYesNo) {
        this.dinnerYesNo = dinnerYesNo;

    }

    /**
     * @return the specialDietary
     */
    public String getSpecialDietary() {
        return specialDietary;
    }

    /**
     * @param specialDietary the specialDietary to set
     */
    public void setSpecialDietary(String specialDietary) {
        this.specialDietary = specialDietary;
    }

    public boolean isNeedDinner() {
        return needDinner;

    }

    public void setNeedDinner(boolean needDinner) {
        this.needDinner = needDinner;
    }

    public String getDinnerRemarks() {
        return dinnerRemarks;
    }

    public void setDinnerRemarks(String dinnerRemarks) {
        this.dinnerRemarks = dinnerRemarks;
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

    public String getFlightBookedByOwnInstitution() {
        return flightBookedByOwnInstitution;

    }

    public void setFlightBookedByOwnInstitution(String flightBookedByOwnInstitution) {
        this.flightBookedByOwnInstitution = flightBookedByOwnInstitution;

    }

    public String getFlightBookedByInfrafrontier() {
        return flightBookedByInfrafrontier;

    }

    public void setFlightBookedByInfrafrontier(String flightBookedByInfrafrontier) {
        this.flightBookedByInfrafrontier = flightBookedByInfrafrontier;

    }

    public boolean isFlightBookedInfra() {
        return flightBookedByInfrafrontier != null && flightBookedByInfrafrontier.equals("yes") ? true : false;

    }

    public String getOutboundFlightTime() {
        this.outboundFlightHour = this.outboundFlightHour == null || this.outboundFlightHour.equals("-please_select-") ? "" : this.outboundFlightHour;

        this.outboundFlightMinute = this.outboundFlightMinute == null || this.outboundFlightMinute.equals("-please_select-") ? "" : this.outboundFlightMinute;

        outboundFlightTime = this.outboundFlightHour + ":" + this.outboundFlightMinute;


        return outboundFlightTime;

    }

    public String getReturnFlightTime() {
        this.returnFlightHour = this.returnFlightHour == null || this.returnFlightHour.equals("-please_select-") ? "" : this.returnFlightHour;

        this.returnFlightMinute = this.returnFlightMinute == null || this.returnFlightMinute.equals("-please_select-") ? "" : this.returnFlightMinute;
        returnFlightTime = this.returnFlightHour + ":" + this.returnFlightMinute;

        return returnFlightTime;
    }
}
