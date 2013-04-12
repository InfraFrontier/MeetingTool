package de.ieg.infra.selectitems;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * @author steinkamp
 * Generates select item list with time objects
 * 
 */
public class TimeSelectItems {
	private List<SelectItem> hours;
	private List<SelectItem> minutes;
	
	/**
	 * Returns a hour select item list 
	 * @return
	 */
	public List<SelectItem>  getHours() {
		if(hours==null) {
			hours=new ArrayList<SelectItem>();
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMinimumIntegerDigits(2);
			hours.add(new SelectItem("-please_select-","-please_select-"));
			for(int i=0;i<=23;i++) {
				hours.add(new SelectItem(nf.format(i),nf.format(i)));
			}
		}
		return hours;
	}
	
	/**
	 * Returns a minute select item list
	 * @return
	 */
	public List<SelectItem>  getMinutes() {
		if(minutes==null) {
			minutes=new ArrayList<SelectItem>();
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMinimumIntegerDigits(2);
			minutes.add(new SelectItem("-please_select-","-please_select-"));
			for(int i=0;i<=59;i++) {
				minutes.add(new SelectItem(nf.format(i),nf.format(i)));
			}
		}
		return minutes;
	}

}
