package dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatesTest {

	
/*	public static void main(String[] args) throws InterruptedException {
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
	}*/
	
	public static void main(String[] args) throws ParseException {
		
		//LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Z"));

		//System.out.println(sdf.parse(sdf.format(calendar.getTime())));
		long f = 1546318799000L;
		//long f = 1546105688000L;
		//long f = 1512190799000L;
		Date d  = new Date(f);
		System.out.println(d);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		System.out.println(formatter.format(d));
		LocalDateTime ldt =     LocalDateTime.parse(formatter.format(d));
		/*System.out.println(ldt);
		
		LocalDateTime ldt1 = LocalDateTime.now(ZoneOffset.UTC);
		
		System.out.println( ldt1);
		
		
		System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy")));*/
	}
}
