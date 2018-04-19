package com.sxkl.webapp.account.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: wangyao
 * @date: 2018年4月10日 上午10:54:46
 * @description: 
 */
@Configuration
@EntityScan(basePackages="com.sxkl.webapp.account.*.entity")
@EnableJpaRepositories(basePackages="com.sxkl.webapp.account.*.dao")
@EnableTransactionManagement
public class HIbernateJpaConfig {

}
