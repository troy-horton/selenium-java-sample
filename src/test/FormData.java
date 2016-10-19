package test;

import java.util.*;
import java.text.*;

public class FormData {

	public static java.util.Date startDate;
	public static java.util.Date endDate;
	public String startDateString;
	public String endDateString;
	
	//get start and end date and format them to strings
   public void Dates() {

	    SimpleDateFormat dateInput = new SimpleDateFormat ("MMddyyyy");
	    getDates();
	    startDateString = dateInput.format(startDate);
	    endDateString = dateInput.format(endDate);

   }
   
   //get date 3 months for now for start date and then add 7 days for end date
   private static void getDates() {	   
      
	      Calendar cal = Calendar.getInstance(); 
	      cal.add(Calendar.MONTH, 3);
	      startDate = cal.getTime();
	      cal.add(Calendar.DATE, 7);
	      endDate = cal.getTime();
	   
   }
}