package com.sxkl.webapp.account.accountbook.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.sxkl.webapp.account.accountbook.dao.IAccountDao;
import com.sxkl.webapp.account.accountbook.entity.Account;
import com.sxkl.webapp.account.tally.entity.Tally;
import com.sxkl.webapp.account.tally.service.TallyService;
import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.utils.StringUtils;

/**
 * @author: wangyao
 * @date: 2018年4月17日 下午4:38:40
 * @description: 
 */
@Service
public class AccountService {

	@Autowired
	private IAccountDao accountDao;
	@Autowired
	private TallyService tallyService;
	
	public String save(Account account){
		try {
			if(StringUtils.isEmpty(account.getName())){
				return OperationResult.configurateFailureResult("账本名称不能为空");
			}
			long size = getAccountBookSize(account.getUserId());
			if(size > 9){
				return OperationResult.configurateFailureResult("最多创建八个账本");
			}
			accountDao.save(account);
			return OperationResult.configurateSuccessResult("账本保存成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("账本保存失败！错误信息："+e.getMessage());
		}
	}
	
	public String update(Account bean) {
		try {
			if(StringUtils.isEmpty(bean.getName())){
				return OperationResult.configurateFailureResult("账本名称不能为空");
			}
			Optional<Account> optional = accountDao.findById(bean.getId());
			Account account = optional.get();
			account.setName(bean.getName());
			account.setDescribe(bean.getDescribe());
			accountDao.save(account);
			return OperationResult.configurateSuccessResult("账本修改成功");
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("账本修改失败！错误信息："+e.getMessage());
		}
	}
	
	public long getAccountBookSize(String userId){
		Account account = new Account();
		account.setUserId(userId);
        Example<Account> example = Example.of(account); 
		return accountDao.count(example);
	}

	public String getAccountBooks(String userId) {
		try {
			List<Account> accounts = accountDao.findByUserId(userId);
			if(!accounts.isEmpty()){
				List<Tally> tallies = tallyService.getSumPerAccount();
				Map<String,Tally> map = Maps.uniqueIndex(tallies, new Function <Tally,String> () {  
			          public String apply(Tally from) {  
			            return StringUtils.appendJoinEmpty(from.getAccountId(),from.getCategoryType()); 
			    }});  
				for(Account account : accounts){
					String key = StringUtils.appendJoinEmpty(account.getId(),"INCOME"); 
					if(map.containsKey(key)){
						account.setIncome(map.get(key).getMoney());
					}
					key = StringUtils.appendJoinEmpty(account.getId(),"OUTCOME"); 
					if(map.containsKey(key)){
						account.setOutcome(map.get(key).getMoney());
					}
				}
			}
			return OperationResult.configurateSuccessResult(accounts);
		} catch (Exception e) {
			return OperationResult.configurateFailureResult("账本保存失败！错误信息："+e.getMessage());
		}
	}
}
