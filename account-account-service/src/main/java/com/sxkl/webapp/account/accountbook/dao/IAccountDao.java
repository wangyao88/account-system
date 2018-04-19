package com.sxkl.webapp.account.accountbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxkl.webapp.account.accountbook.entity.Account;

/**
 * @author: wangyao
 * @date: 2018年4月10日 上午10:57:44
 * @description: 
 */
public interface IAccountDao extends JpaRepository<Account, String>{

	List<Account> findByUserId(String userId);

}
