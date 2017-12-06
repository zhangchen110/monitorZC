package com.flyusoft.components.permission.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.flyusoft.components.permission.entity.User;
import com.flyusoft.components.permission.service.UserService;
import com.flyusoft.components.permission.utils.Constants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录管理Action.
 * 
 * @author helin
 */
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -7072634619093732090L;

	/** 自动注入 */
	@Autowired
	private UserService userService;

	//-- 页面属性 --//
	private String loginName;
	private String password;
	private String msg;
	private User user;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toLogin() {
		return "toLogin";
	}

	@Override
	public String execute() {
		try {
			//取seesion
			HttpSession session = Struts2Utils.getSession();
			//通过登录名取用户实体
			user = userService.findUserByLoginName(loginName);
			if (user != null) {
				if (user.getPassword() != null) {
					if (!user.getPassword().equals(password)) {
						msg = "请检查用户名和密码";
						addActionMessage(msg);
						return "fail";
					}
				} else {
					msg = "请检查用户名和密码";
					addActionMessage(msg);
					return "fail";
				}
				//正常登录后 数据放入session
				session.setAttribute(Constants.USER_SESSION, user);
				return SUCCESS;

			} else {
				msg = "请检查用户名和密码";
				addActionMessage(msg);
				return "fail";
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg = "系统出现异常,请联系管理员";
			addActionMessage(msg);
			return "fail";
		}
	}

	public String logout() {
		Struts2Utils.getSession().removeAttribute(Constants.USER_SESSION);
		return "toLogin";
	}

}
