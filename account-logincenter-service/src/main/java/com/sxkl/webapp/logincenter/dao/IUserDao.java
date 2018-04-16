package com.sxkl.webapp.logincenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxkl.webapp.logincenter.entity.User;

/**
 * @author: wangyao
 * @date: 2018年4月10日 上午10:57:44
 * @description: 
 */
public interface IUserDao extends JpaRepository<User, String>{

	User findByNameAndPassword(String name, String password);

	User findByName(String name);
}
