package com.luo.factory.challenge;

import java.util.List;
/**
 * 简单工厂 + 工厂方法
 * @author luoxuzheng
 * @create 2019-09-15 21:15
 **/
public class PacificCalendar extends Calendar {
	public PacificCalendar(ZoneFactory zoneFactory) {
		zone = zoneFactory.createZone("US/Pacific");
		// make a calendar for the pacific zone
		// ...
	}
	public void createCalendar(List<String> appointments) {
		// make calendar from appointments
		System.out.println("Making the calendar");
	}
}