package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatesTest {

	
	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
		Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c1.setTime(new Date());
		Thread.sleep(1000);
		//c1.add(Calendar.YEAR, -50);
		Calendar c2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		c2.setTime(new Date());
		System.out.println(c1.get(Calendar.DATE));
		System.out.println(c2.get(Calendar.DATE));
		System.out.println(c1.get(Calendar.DATE) == c2.get(Calendar.DATE));
		System.out.println(c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH));
		System.out.println(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR));
	}
}
