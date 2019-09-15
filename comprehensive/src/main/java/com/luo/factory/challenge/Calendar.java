package com.luo.factory.challenge;

import java.util.List;
/**
 * @author luoxuzheng
 * @create 2019-09-15 21:15
 **/
public abstract class Calendar {
	Zone zone;
	public void print() {
		System.out.println("--- " + zone.getDisplayName() + " Calendar ---");
		// print all appointments in correct time zone
		System.out.println("Offset from GMT: " + zone.getOffset());
	}
	public abstract void createCalendar(List<String> appointments);
}