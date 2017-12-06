package com.flyusoft.components.permission.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.flyusoft.common.service.ServiceException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.flyusoft.common.action.CrudActionSupport;
import com.flyusoft.common.orm.Page;
import com.flyusoft.common.orm.PropertyFilter;
import com.flyusoft.common.utils.web.struts2.Struts2Utils;
import com.flyusoft.components.permission.entity.User;
import com.flyusoft.components.permission.service.UserService;

/**
 * 用户管理Action.
 * 
 * @author helin
 */
@Controller
@Scope("prototype")
public class UserAction extends CrudActionSupport<User> {

	private static final long serialVersionUID = 8683878162525847072L;

	@Autowired
	private UserService userService;

	//-- 页面属性 --//
	private String id;
	private List<String> ids;
	private User user;
	private Page<User> page = new Page<User>(10);//每页10条记录

	//-- ModelDriven 与 Preparable函数 --//
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public User getModel() {
		return user;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null && !"".equals(id)) {
			user = userService.getUser(id);
		} else {
			user = new User();
		}
	}

	//-- CRUD Action 函数 --//
	@Override
	public String list() throws Exception {
		List<PropertyFilter> filters = PropertyFilter.buildFromHttpRequest(Struts2Utils.getRequest());
		//设置默认排序方式
		if (!page.isOrderBySetted()) {
			page.setOrderBy("id");
			page.setOrder(Page.ASC);
		}
		page = userService.searchUser(page, filters);
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	public String save() throws Exception {
		userService.saveUser(user);
		addActionMessage("保存用户成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			userService.batchDeleteUser(ids);
			addActionMessage("删除用户成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			addActionMessage("删除用户失败");
		}
		return RELOAD;
	}

	//-- 其他Action函数 --//
	/**
	 * 支持使用Jquery.validate Ajax检验用户名是否重复.
	 */
	public String checkLoginName() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String newLoginName = request.getParameter("loginName");
		String oldLoginName = request.getParameter("oldLoginName");

		if (userService.isLoginNameUnique(newLoginName, oldLoginName)) {
			Struts2Utils.renderText("true");
		} else {
			Struts2Utils.renderText("false");
		}
		//因为直接输出内容而不经过jsp,因此返回null.
		return null;
	}

	//-- 页面属性访问函数 --//
	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	/**
	 * list页面显示用户分页列表.
	 */
	public Page<User> getPage() {
		return page;
	}

}
