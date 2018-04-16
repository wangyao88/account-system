package com.sxkl.webapp.websystem.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisPoolConfig; 

/**
 * @author: wangyao
 * @date: 2018年4月10日 下午3:44:49
 * @description: 
 */
@EnableRedisHttpSession
@Configuration  
@EnableAutoConfiguration 
public class RedisConfig {

	@Value("${spring.redis.host}")  
    private String host;  
	
	@Value("${spring.redis.password}")  
    private String password;  
  
  
    /** 
     * @Bean 和 @ConfigurationProperties 
     * 该功能在官方文档是没有提到的，我们可以把@ConfigurationProperties和@Bean和在一起使用。 
     * 举个例子，我们需要用@Bean配置一个Config对象，Config对象有a，b，c成员变量需要配置， 
     * 那么我们只要在yml或properties中定义了a=1,b=2,c=3， 
     * 然后通过@ConfigurationProperties就能把值注入进Config对象中 
     * @return 
     */  
    @Bean  
    @ConfigurationProperties(prefix = "spring.redis.pool")  
    public JedisPoolConfig getRedisConfig() {  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
  
    @SuppressWarnings("deprecation")
	@Bean  
    @ConfigurationProperties(prefix = "spring.redis")  
    public JedisConnectionFactory getConnectionFactory() {  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        factory.setUsePool(true);  
        JedisPoolConfig config = getRedisConfig();  
        factory.setPoolConfig(config);  
        return factory;  
    }  
  
  
    @Bean  
    public RedisTemplate<?, ?> getRedisTemplate() {  
        JedisConnectionFactory factory = getConnectionFactory();  
        RedisTemplate<?, ?> template = new StringRedisTemplate(factory);
        return template;  
    }  
}
