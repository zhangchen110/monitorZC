package com.flyusoft.apps.jointoil.test;

import java.sql.Date;
import java.util.Calendar;


public class TestData {
	public static void main(String[] args) {
		int time=30;
		Calendar date=Calendar.getInstance();
		System.out.println(date.getTime());
		date.add(Calendar.MINUTE, -30);
		System.out.println(date.getTime());
	}
}
