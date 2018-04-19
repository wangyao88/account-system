package com.sxkl.webapp.websystem.category.entity;

import java.util.List;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午4:32:07
 * @description: 
 */
public class Item {

	private String id;
	private String name;
	private boolean hasChildren;
	private List<Item> children;
}
