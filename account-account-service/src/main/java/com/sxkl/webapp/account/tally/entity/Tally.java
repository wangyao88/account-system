package com.sxkl.webapp.account.tally.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author: wangyao
 * @date: 2018年4月23日 上午9:12:21
 * @description: 
 */
@Data
@Entity
@Table(name = "a_tally")
@GenericGenerator(name = "uuid", strategy = "uuid")
public class Tally {

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "money", unique = false, nullable = false)
	private float money;

	@Column(name = "create_date", unique = false, nullable = false)
	private Date createDate;
	
	@Column(name = "category_type", unique = false, nullable = false)
	private String categoryType;
	
	@Column(name = "category_id", unique = false, nullable = false)
	private String categoryId;
	
	@Column(name = "category_name", unique = false, nullable = false)
	private String categoryName;

	@Column(name = "account_id", unique = false, nullable = false)
	private String accountId;
	
	@Transient
	private Date beginDate;
	
	@Transient
	private Date endDate;
}
