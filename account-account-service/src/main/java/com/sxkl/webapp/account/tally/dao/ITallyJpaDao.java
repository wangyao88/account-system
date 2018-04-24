package com.sxkl.webapp.account.tally.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sxkl.webapp.account.tally.entity.Tally;

/**
 * @author: wangyao
 * @date: 2018年4月19日 上午10:29:14
 * @description: 
 */
public interface ITallyJpaDao extends JpaRepository<Tally, String>, JpaSpecificationExecutor<Tally>{

	Page<Tally> findAllByOrderByCreateDateDesc(Example<Tally> example, Pageable pageable);
	
//	@Query("select category_type ad categoryType, sum(money) as money from a_tally where account_id = :accountid group by category_type")
//	List<Object[]> getSearchSumMoney(@Param("accountid")String accountid);
}
