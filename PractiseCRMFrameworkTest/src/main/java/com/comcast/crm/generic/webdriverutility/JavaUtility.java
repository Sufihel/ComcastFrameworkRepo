package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateInDDMMYYYY() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = simpleDateFormat.format(date);
		System.out.println(dateString);
		return dateString;
	}

	public String getRequiredDateDDMMYYYY(int days) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar calendar = simpleDateFormat.getCalendar();
//		calendar.add(Calendar.DAY_OF_MONTH, days);
//		String reqDate = simpleDateFormat.format(calendar.getTime());
//		System.out.println(reqDate);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = simpleDateFormat.format(calendar.getTime());
		System.out.println(reqDate);
		return reqDate;
	}

}
