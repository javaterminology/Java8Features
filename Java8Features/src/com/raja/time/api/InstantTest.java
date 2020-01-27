package com.raja.time.api;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class InstantTest {

	//1st Concept: Instant is a point on the time line.
	//Instant is immutable where as in Java 7 java.util.Date is mutable.in java 6/7 to make immutable date object we need to create defensive copy of that date object as below.
	// return new Date(this.createdDate)
	//so creating new date object for each call it will be overhead for garbage collector.
	//so java 8 introduced new date time api where you can create immutable date object using instant.
	
	//Java 8 introduced one more new concept Duration to find time difference between 2 dates.
	
	//3rd Concept: A Duration is the amount of time b/w two Instant.

	//There are many cases not covered where a date is not a <Instant>.
	
	//Ex: Rajasekhar was born on June 26th, 1986 which is not covered by Instant.
	//Ex: Let us meet tomorrow at 1pm for lunch at restaurant which is not covered by Instant.
	//to support above 2 representations we need another concepts for those dates i.e LocalDate.
	
	//4th Concept:Period is the amount of time between 2 LocalDate same concept like Duration and same kind of methods.
	
	//5th Concept : Date Adjusters - to add or subtract an amount of time from an instant or LocalDate
	
	//6th Concept: LocalTime - is a time of a day
	
	//7th Concept - ZonedDateTime - there are Time Zones all over the earth.
	// java uses IANA Database for Time Zones
	//the new date api proposes DateTimeFormatter for format the dates
	public static void main(String[] args) {
		
		Instant now = Instant.now();
		
		System.out.println(now);
		
		Instant before = Instant.MIN;
		
		System.out.println("1 billion years ago:"+before);

		
		Instant later = Instant.MAX;

		System.out.println("1 billion years after:"+later);
		
		Instant now1 = Instant.now();
		
		Duration d = Duration.between(now, now1);
		long elapsedTimeInMilliseconds = d.toMillis();
		
		System.out.println("elapsedTimeInMilliseconds:"+elapsedTimeInMilliseconds);

		
		LocalDate localDate = LocalDate.now();
		
		LocalDate dateOfBirth = LocalDate.of(1985,Month.JUNE,26);
		
		/*
		 * Period p = Period.between(dateOfBirth, localDate); int yearsOfDifference =
		 * p.getYears(); System.out.println(yearsOfDifference);
		 */
		
		Period p1 = dateOfBirth.until(localDate);
		long days = dateOfBirth.until(localDate,ChronoUnit.DAYS);
		int years  = p1.getYears();

		System.out.println("years:"+years+" Days:"+days);
		
		LocalDate currentDate1 = LocalDate.now();

		LocalDate latest = currentDate1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		
		System.out.println("Next Sunday Date:"+latest);
		
		LocalTime time = LocalTime.now();
		
		System.out.println("time:"+time);

		
		LocalTime meetingTime = LocalTime.of(10,30);//10:30
		
		System.out.println("meetingTime:"+meetingTime);


		LocalTime bedTime = LocalTime.of(11, 30);
		LocalTime wakeupTime = bedTime.plusHours(8);
		
		System.out.println("wakeupTime:"+wakeupTime);
		
		
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		
		ZoneId ukTz = ZoneId.of("Europe/London");
		
		//create ZonedDateTime
		
		System.out.println("ZonedDateTime:"+ZonedDateTime.of(2020, 01, 20, 10, 20, 10, 0, ukTz));
		
		ZonedDateTime currentMeeting = ZonedDateTime.of(2020, 01, 20, 10, 20, 10, 0, ukTz);
		
		ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));
		
		System.out.println("Next Meeting using ZonedDateTime="+nextMeeting);
		
		ZonedDateTime usMeetingTime = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
		
		System.out.println("USA Meeting Time ="+usMeetingTime);
		
		String formattedDateTime = DateTimeFormatter.ISO_DATE_TIME.format(usMeetingTime);
		
		System.out.println("formattedDateTime:"+formattedDateTime);
		
	}

}
