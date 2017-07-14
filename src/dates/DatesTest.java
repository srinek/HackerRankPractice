package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatesTest {

	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c1.setTime(new Date(0));
		//c1.add(Calendar.YEAR, -50);
		Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c2.setTime(new Date(1492370986000L));
		System.out.println(sdf.format(c1.getTime()));
		System.out.println(sdf.format(c2.getTime()));
		System.out.println(c1.after(c2));
	}
}
