package test;

import java.util.*;
import java.text.*;

public class FormData {

	public static java.util.Date startDate;
	public static java.util.Date endDate;
	String startDateString;
	String endDateString;

   public void FormatDates() {

	    SimpleDateFormat dateInput = new SimpleDateFormat ("MMddyyyy");
	    Dates();
	    startDateString = dateInput.format(startDate);
	    endDateString = dateInput.format(endDate);

   }
   
   private static void Dates() {	   
      
	      Calendar cal = Calendar.getInstance(); 
	      cal.add(Calendar.MONTH, 3);
	      startDate = cal.getTime();
	      cal.add(Calendar.DATE, 7);
	      endDate = cal.getTime();
	   
   }
}