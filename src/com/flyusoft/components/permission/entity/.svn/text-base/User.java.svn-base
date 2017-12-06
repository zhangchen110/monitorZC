package com.flyusoft.components.permission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.flyusoft.common.entity.IdEntity;

/**
 * 用户.
 * 
 * 使用JPA annotation定义ORM关系.
 * 使用Hibernate annotation定义JPA 1.0未覆盖的部分.
 * 
 * @author helin
 */
@Entity
@Table(name = "FLY_USER")
public class User extends IdEntity {

	private String loginName;
	private String name;
	private String password;

	/** 字段非空且唯一, 用于提醒Entity使用者及生成DDL */
	@Column(nullable = false, unique = true)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
