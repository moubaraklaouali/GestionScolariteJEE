package college.ing2.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ConvertDate {
private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static String dateToString(LocalDate localDate) {
		return localDate.format(DATE_FORMATTER);
	}
	
	public static LocalDate stringToDate(String date) {
		LocalDate localDate = LocalDate.parse(date, DATE_FORMATTER.withLocale(Locale.ENGLISH));
		return localDate;
	}
}
