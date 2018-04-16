package com.sxkl.webapp.logincenter.service;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sxkl.webapp.common.OperationResult;
import com.sxkl.webapp.logincenter.dao.IUserDao;
import com.sxkl.webapp.logincenter.entity.User;
import com.sxkl.webapp.logincenter.utils.DESUtil;
import com.sxkl.webapp.logincenter.utils.ObjectUtils;
import com.sxkl.webapp.logincenter.utils.StringUtils;

/**
 * @author: wangyao
 * @date: 2018年4月10日 上午11:02:50
 * @description: 
 */
@Service
public class UserService {

	@Autowired  
    private StringEncryptor encryptor;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;  
	@Autowired
	private RSACoderService rsaCoderService;
	
	public void registe(String name, String password){
        password = rsaCoderService.decryptByPrivateKey(password);//前台加密，后台解密
        password = DESUtil.encrypt(password);//后台加密，存数据库
		User user = new User();
		user.setCreateDate(new Date());
		user.setName(name);
		user.setPassword(password);
		userDao.save(user);
	}

	public String checkName(String name) {
		User reuslt = userDao.findByName(name);
		if(Objects.isNull(reuslt)){
			return OperationResult.configurateSuccessResult("用户名合法");
		}
		return OperationResult.configurateFailureResult("用户名已存在，请更改重试！");
	}

	public String refreshUserLoginStatus(String name) {
		String nameTemp = redisTemplate.opsForValue().get(name);
		if(StringUtils.isEmpty(nameTemp)){
			return OperationResult.configurateFailureResult("该用户未登录");
		}
		redisTemplate.opsForValue().set(name, name);
		redisTemplate.expire(name, 30, TimeUnit.MINUTES);
		return OperationResult.configurateSuccessResult("更新用户登陆状态成功");
	}

	public String login(String name, String password) {
		password = rsaCoderService.decryptByPrivateKey(password);//前台加密，后台解密
        password = DESUtil.encrypt(password);//后台加密，存数据库
		User result = userDao.findByNameAndPassword(name, password);
		if(ObjectUtils.isNull(result)){
			return OperationResult.configurateFailureResult("用户名或密码错误");
		}
		redisTemplate.opsForValue().set(name, name);
		redisTemplate.expire(name, 30, TimeUnit.MINUTES);
		return OperationResult.configurateSuccessResult("用户登陆成功");
	}
	
	public String logout(String sessionid) {
		redisTemplate.delete(sessionid);
		return OperationResult.configurateSuccessResult("退出成功");
	}

	public String getPassword(String password) {
		String pwd = encryptor.encrypt(password);  
		return OperationResult.configurateSuccessResult(pwd);
	}
}
