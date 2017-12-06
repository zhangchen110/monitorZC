package com.flyusoft.apps.jointoil.test;

import java.util.List;


public class ThreadClass implements Runnable{

	public List<String> list;
	
	public ThreadClass(){
		
	}
	
	public ThreadClass(List<String> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i <list.size(); i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(list.get(i));
		}
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}
