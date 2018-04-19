package com.sxkl.webapp.account.category.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author: wangyao
 * @date: 2018年4月10日 上午10:30:31
 * @description:
 */
@Data
@Entity
@Table(name = "a_category")
@GenericGenerator(name = "uuid", strategy = "uuid")
public class Category {

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@Column(name = "create_date", unique = false, nullable = false)
	private Date createDate;
	
	@Column(name = "type", unique = false, nullable = false)
	private String type;
	
	@Column(name = "parent_id", unique = false, nullable = false)
	private String parentId;

	@Column(name = "account_id", unique = false, nullable = false)
	private String accountId;
}
