package com.sxkl.webapp.account.category.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sxkl.webapp.account.category.entity.Category;

/**
 * @author: wangyao
 * @date: 2018年4月19日 上午10:29:14
 * @description: 
 */
public interface ICategoryJpaDao extends JpaRepository<Category, String> {
	
	 List<Category> findByTypeAndAccountId(String type, String accountId);

	 Page<Category> findByTypeAndAccountId(String type, String accountId, Pageable pageable);

	 List<Category> findByTypeAndAccountIdAndNameLike(String categoryType, String accountId, String name);

}
