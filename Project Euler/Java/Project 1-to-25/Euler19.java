/*
	Counting Sundays
	Problem 19
		You are given the following information, but you may prefer to do some research for yourself.

		1 Jan 1900 was a Monday.
		Thirty days has September,
		April, June and November.
		All the rest have thirty-one,
		Saving February alone,
		Which has twenty-eight, rain or shine.
		And on leap years, twenty-nine.
		A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
		How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

import java.util.Calendar;
import java.util.Date;

public class Euler19 {

	public static void main(String[] args) {

		Calendar startDateCal = Calendar.getInstance();
		startDateCal.set(Calendar.YEAR, 1901);
		startDateCal.set(Calendar.MONTH, 0);
		startDateCal.set(Calendar.DATE, 1);
 
		Calendar endDateCal = Calendar.getInstance();
		endDateCal.set(Calendar.YEAR, 2000);
		endDateCal.set(Calendar.MONTH, 11);
		endDateCal.set(Calendar.DATE, 31);
		checkSundays(startDateCal.getTime(), endDateCal.getTime());
 
	}
 
	private static void checkSundays(Date start, Date end) {
		int dayNum;
 
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(start);
 
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(end);
		int count = 0;
 
		while (startDate.before(endDate)) {
 
			dayNum = startDate.get(Calendar.DAY_OF_WEEK);
			if (dayNum == 1) {
				count++;
			}
 
 
			startDate.add(Calendar.MONTH, 1);
 
 
 
		}
		System.out.println("Count " + count);
	}
 
}