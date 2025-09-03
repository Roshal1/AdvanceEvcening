package javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {

	
		// TODO Auto-generated method stub
		public String getCurrentDate() {
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
			String currentDate = sim.format(date);
			System.out.println(currentDate);
			return currentDate;
		}
		
		public String togetRequired(int days) {
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
			sim.format(date);
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH, days);
		   String daterequired = sim.format(cal.getTime());
		   return daterequired;
		}

	}


