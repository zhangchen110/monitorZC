package com.flyusoft.apps.jointoil.action;

import org.springframework.stereotype.Controller;

import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ToSingleCameraAction extends ActionSupport{

	private static final long serialVersionUID = -231731558556110391L;
	
	private int num=1;
	
	public String execute(){
		String cnum=Struts2Utils.getParameter("cnum");
		if(cnum!=null&&!cnum.equals("")){
			try{
			num=Integer.parseInt(cnum);
			}catch (Exception e) {
				System.out.println("---------穿过来的num不是一个数字---------");
			}
		}
		
		return SUCCESS;
	}

	public int getNum() {
		return num;
	}
	
}
