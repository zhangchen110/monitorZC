package com.flyusoft.apps.jointoil.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.dom4j.Node;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.flyusoft.common.utils.XmlAdapter;

public class TestClass {
	public static void main(String[] args) throws Exception {
		 A1 a1=new A1("aaa","111");
		 Class clazz=a1.getClass();
		 Method method=clazz.getDeclaredMethod("getAge");
		 Method method2=clazz.getDeclaredMethod("setAge",String.class);
		 System.out.println(method.invoke(a1));
		 System.out.println(TestClass.class.toString());
		 
		 method2.invoke(a1, "2222");
		 System.out.println(a1.getAge());
		 
		 
		 
		 
//		ClassPathResource resource = new ClassPathResource(
//				"compressorMethod1.xml");
//		System.out.println(resource.getFile().getAbsolutePath());
//		String path=resource.getFile().getAbsolutePath();
//		System.out.println(resource.getPath());
//		Document doc = XmlAdapter
//				.load(path);
//
//		NodeList nodes = doc.getElementsByTagName("method");
//		for (int i = 0; i < nodes.getLength(); i++) {
//			Element e = (Element) nodes.item(i);
//			if (e.getAttribute("name").equals("m1")) {
//				System.out.println(e.getTextContent());
//			}
//		}

//		aaa();
	}
	public static void aaa(){
		String a1="hello";
		String ss=a1.substring(0,1);
		String aa1=ss.toUpperCase();
		System.out.println("get"+a1.substring(0,1).toUpperCase()+a1.substring(1));
	}
}
