package com.sxkl.webapp.websystem.login.service;

import org.jasypt.encryption.StringEncryptor;

/**
 * @author: wangyao
 * @date: 2018年4月10日 下午2:09:37
 * @description: 
 */
//@RunWith(SpringJUnit4ClassRunner.class)    
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下    
//@SpringBootTest(classes = AccountsystemApplication.class)    
//@WebAppConfiguration
public class EncryptorTest {

//	@Autowired  
    private StringEncryptor encryptor;  
      
//    @Test  
    public void getPass() { 
        String name = encryptor.encrypt("root");  
        String password = encryptor.encrypt("5ff8ff5f-c0fe-4cf0-8d4f-a56d956e9284");  
        System.out.println(name+"----------------");   
        System.out.println(password+"----------------");   
    }  
}
