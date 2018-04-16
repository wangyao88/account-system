package com.sxkl.webapp.logincenter.service;

import java.security.Key;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.sxkl.webapp.logincenter.utils.RSACoder;
import com.sxkl.webapp.logincenter.utils.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: wangyao
 * @date: 2018年4月13日 上午10:39:48
 * @description: 
 */
@Slf4j
@Service
public class RSACoderService {

	private static Map<String, Key> keyMap = Maps.newHashMap();
	
	@PostConstruct
	private void initKey(){
		try {
			keyMap = RSACoder.initKey();
		} catch (Exception e) {
			log.error("初始化公钥秘钥失败！错误信息:{}", e.getMessage());
		}
	}
	
	public String getPublicKey(){
		try {
			return RSACoder.getPublicKey(keyMap);
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}
	
	public String getPrivateKey(){
		try {
			return RSACoder.getPrivateKey(keyMap);
		} catch (Exception e) {
			return StringUtils.EMPTY;
		}
	}
	
	public String decryptByPrivateKey(String password){
		byte[] decodedData = null;
		try {
			decodedData = RSACoder.decryptByPrivateKey(password,getPrivateKey());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  new String(decodedData);
	}
	
	
}
