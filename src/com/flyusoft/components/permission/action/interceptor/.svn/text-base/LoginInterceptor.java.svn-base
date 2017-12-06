package com.flyusoft.components.permission.action.interceptor;

import javax.servlet.http.HttpSession;

import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.flyusoft.components.permission.entity.User;
import com.flyusoft.components.permission.utils.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author helin 登录拦截器
 */

public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 633369498117774670L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		boolean flag = false;
		HttpSession session = Struts2Utils.getSession();
		if (session != null && session.getAttribute(Constants.USER_SESSION) != null) {
			User user = (User) session.getAttribute(Constants.USER_SESSION);
			if (user != null) {
				return invocation.invoke();
			} else {
				if (flag == false) {
					return Action.LOGIN;
				}
				return invocation.invoke();
			}
		} else {
			if (flag == false) {
				return Action.LOGIN;
			}
			return invocation.invoke();
		}
	}

}
