package com.sxkl.webapp.account.accountbook.entity;

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
 * @date: 2018年4月10日 上午10:30:31
 * @description:
 */
@Data
@Entity
@Table(name = "a_account")
@GenericGenerator(name = "uuid", strategy = "uuid")
public class Account {

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "description", unique = true, nullable = true)
	private String describe;//数据库关键字

	@Column(name = "create_date", unique = false, nullable = false)
	private Date createDate;

	@Column(name = "user_id", unique = false, nullable = false)
	private String userId;

	@Transient
	private float income;
	
	@Transient
	private float outcome;
}
