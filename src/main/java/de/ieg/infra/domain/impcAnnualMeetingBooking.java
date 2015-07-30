package de.ieg.infra.domain;

import java.util.Date;
import java.util.List;

public class impcAnnualMeetingBooking extends Booking {
	private List<String> numberOfNights;
	private List<String> numberOfNightsAdditional;
	private String tourYesNo;
	private String mealYesNo;
	private boolean needTour;
	private boolean needMeal;
	private String accommodationYesNo;
	private boolean needAccommodation;
	private String sex;
	
		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public String gettourYesNo() {
			return tourYesNo;
		}

		public void settourYesNo(String tourYesNo) {
			this.tourYesNo = tourYesNo;
		}

		public String getmealYesNo() {
			return mealYesNo;
		}

		public void setmealYesNo(String mealYesNo) {
			this.mealYesNo = mealYesNo;
		}
		public boolean isneedTour() {
			return needTour;
		}

		public void setneedTour(boolean needTour) {
			this.needTour = needTour;
		}
		public boolean isneedMeal() {
			return needMeal;
		}

		public void setneedMeal(boolean needMeal) {
			this.needMeal = needMeal;
		}

		public List<String> getNumberOfNights() {
			return numberOfNights;
		}

		public void setNumberOfNights(
				List<String> numberOfNights) {
			this.numberOfNights = numberOfNights;
		}

		public List<String> getnumberOfNightsAdditional() {
			return numberOfNightsAdditional;
		}

		public void setnumberOfNightsAdditional(
				List<String> numberOfNightsAdditional) {
			this.numberOfNightsAdditional = numberOfNightsAdditional;
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

}
