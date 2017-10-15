package fr.iagl.opl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static String STANDARD_FORMAT = "yyyy-MM-dd";
	
	private static SimpleDateFormat SDF_STANDARD_FORMAT = new SimpleDateFormat(STANDARD_FORMAT);
	
	public static Date parseDateStandardFormat(String dateToParse) throws ParseException{
		return SDF_STANDARD_FORMAT.parse(dateToParse);
	}
}
