package com.sxkl.webapp.account.accountbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxkl.webapp.account.accountbook.entity.Account;
import com.sxkl.webapp.account.accountbook.service.AccountService;
import com.sxkl.webapp.utils.JsonUtils;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:42:26
 * @description: 
 */
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/save")
	public String save(String account){
		Account bean = (Account) JsonUtils.convert2Bean(account, Account.class);
		return accountService.save(bean);
	}
	
	@PostMapping("/update")
	public String update(String account){
		Account bean = (Account) JsonUtils.convert2Bean(account, Account.class);
		return accountService.update(bean);
	}
	
	@PostMapping("/getAccountBooks")
	public String getAccountBooks(String userId){
		return accountService.getAccountBooks(userId);
	}
}
