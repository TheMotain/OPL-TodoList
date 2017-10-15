package fr.iagl.opl.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	@Test
	public void parseStringStandardFormatToDateWithFormat_yyyyMMdd_AndTiretSeparatorTest() throws ParseException{
		Calendar cal = Calendar.getInstance();
		String dateToParse = "2017-10-12";
		Date result = DateUtils.parseDateStandardFormat(dateToParse);
		cal.setTime(result);
		Assert.assertTrue(2017 == cal.get(Calendar.YEAR));
		Assert.assertTrue(Calendar.OCTOBER == cal.get(Calendar.MONTH));
		Assert.assertTrue(12 == cal.get(Calendar.DAY_OF_MONTH));
	}
}
