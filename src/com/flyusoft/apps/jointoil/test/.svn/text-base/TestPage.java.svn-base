package com.flyusoft.apps.jointoil.test;

import java.util.ArrayList;
import java.util.List;

public class TestPage {
	public static void main(String[] args) throws Exception {
		while (true) {
			List<String> list=new ArrayList<String>();
			for (int j = 0; j < 20; j++) {
				System.out.println(j);
				if(j%2==0)list.add(j+"我村");
			}
			ThreadClass t=new ThreadClass(list);
			Thread thread=new Thread(t);
			thread.start();
			Thread.sleep(1000);
		}
	}
}
