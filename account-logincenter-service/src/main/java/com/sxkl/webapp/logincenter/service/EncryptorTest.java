package com.sxkl.webapp.logincenter.service;

import org.jasypt.encryption.StringEncryptor;

/**
 * @author: wangyao
 * @date: 2018年4月10日 下午2:09:37
 * @description: 
 */
//@RunWith(SpringJUnit4ClassRunner.class)    
//@SpringBootTest(classes = LogincenterApplication.class)    
//@WebAppConfiguration
public class EncryptorTest {
	
//	@Autowired
//	private DataSource dataSource;

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
