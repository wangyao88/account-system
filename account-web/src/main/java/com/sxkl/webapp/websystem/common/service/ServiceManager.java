package com.sxkl.webapp.websystem.common.service;

import java.util.List;

import com.google.common.collect.Lists;
import com.sxkl.webapp.websystem.common.entity.Service;

/**
 * @author: wangyao
 * @date: 2018年4月18日 上午10:01:11
 * @description: 
 */
public class ServiceManager {

	private List<Service> services;
	
	private ServiceManager() {
		services = Lists.newArrayList();
	}

	public static ServiceManager newService(){
		return new ServiceManager();
	}
	
	public ServiceManager addService(Service service){
		services.add(service);
		return this;
	}
	
//	public OperationResult doServices(){
//		
//	}
}
