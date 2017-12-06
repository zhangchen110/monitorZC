package com.flyusoft.apps.jointoil.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TestList {
	public static void main(String[] args) {
		List<A1> alist=new ArrayList<A1>();
		for (int i = 1; i <= 32; i++) {
			A1 a1=new A1("name"+i,"aaao"+i);
			alist.add(a1);
		}
		
		long t1=Calendar.getInstance().getTimeInMillis();
		for (int j = 1; j <=32; j++) {
			double tmp=Math.random();
			String nameString="name"+Math.round(tmp*32);
			System.out.println("######"+nameString);
			A1 aaA1=getA1(alist, nameString);
			System.out.println(aaA1.getName()+"==="+aaA1.getAge());
		}
		long t2=Calendar.getInstance().getTimeInMillis();
		System.out.println("总共耗时==="+(t2-t1));
	}
	static A1 getA1(List<A1> alist,String name){
		for (int i = 0; i < alist.size(); i++) {
			A1 a1=alist.get(i);
			if(a1.getName().equals(name)){
				return a1;
			}
		}
		return null;
	}
}
