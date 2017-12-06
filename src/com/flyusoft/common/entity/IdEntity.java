package com.flyusoft.common.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 * @author helin
 */
//JPA Entity基类的标识
@MappedSuperclass
public abstract class IdEntity {

	protected String id;

	@Id
	@GeneratedValue(generator = "UIDGenerator")
	@GenericGenerator(name = "UIDGenerator", strategy = "com.flyusoft.common.dao.UIDGenerator")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
