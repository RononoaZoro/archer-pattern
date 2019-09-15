package com.luo.factory.challenge;

import java.util.Arrays;
import java.util.List;
/**
 * @author luoxuzheng
 * @create 2019-09-15 21:15
 **/
public class CalendarTestDrive {
 
	public static void main(String[] args) {
		ZoneFactory zoneFactory = new ZoneFactory();
		Calendar calendar = new PacificCalendar(zoneFactory);
		List<String> appts = Arrays.asList("appt 1", "appt 2");
		calendar.createCalendar(appts);
		calendar.print();
	}
}
