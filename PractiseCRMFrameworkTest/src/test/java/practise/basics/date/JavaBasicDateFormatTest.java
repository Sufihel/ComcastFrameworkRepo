package practise.basics.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasicDateFormatTest {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String actualformatdate = simpleDateFormat.format(date);
		Calendar calendar = simpleDateFormat.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		String daterequired = simpleDateFormat.format(calendar.getTime());
		System.out.println(actualformatdate);
		System.out.println(daterequired);
	}
}
