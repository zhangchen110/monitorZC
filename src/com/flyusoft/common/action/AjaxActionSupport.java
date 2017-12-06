package com.flyusoft.common.action;

import com.flyusoft.common.utils.encode.JsonBinder;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2中典型Ajax Action的抽象基类.
 * 
 * @author helin
 */
public class AjaxActionSupport extends ActionSupport {

	private static final long serialVersionUID = 198186391501132741L;

	private static JsonBinder binder = JsonBinder.buildNonDefaultBinder();

	public void outJson(Object obj) {
		String json = binder.toJson(obj);
		Struts2Utils.renderJson(json);
	}

}
