package ma.ael.message.util;

import java.util.Calendar;
import java.util.Date;

public class DateFormatter {
	public static Date string2Date(String dateString, int heure, int minute) {

		Calendar c = Calendar.getInstance();
		c.set(Integer.decode((String) dateString.subSequence(6, 10)),
				Integer.decode((String) dateString.subSequence(3, 5)) - 1,
				Integer.decode((String) dateString.subSequence(0, 2)), heure,
				minute);
		return c.getTime();
	}

	public static Date FirstDate() {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 00);
		c.set(Calendar.MINUTE, 00);
		return c.getTime();
	}

	public static Date LastDate() {

		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		
		return c.getTime();
	}
}
