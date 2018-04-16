package com.sxkl.webapp.logincenter.entity;

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
@Table(name = "a_user")
@GenericGenerator(name = "uuid", strategy = "uuid")
public class User {

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "nick_name", unique = true, nullable = true)
	private String nickName;

	@Column(name = "password", unique = false, nullable = false)
	private String password;

	@Column(name = "create_date", unique = false, nullable = true)
	private Date createDate;

	@Column(name = "picture_url", unique = false, nullable = true)
	private String pictureUrl;

	@Column(name = "online", unique = false, nullable = true)
	private int online;
	
	@Transient
	private String sessionId;
}
