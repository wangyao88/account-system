package com.sxkl.webapp.websystem.category.service;

import java.util.Collection;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.sxkl.webapp.utils.ObjectUtils;
import com.sxkl.webapp.utils.StringUtils;
import com.sxkl.webapp.websystem.category.entity.Category;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午4:31:32
 * @description: 
 */
public class TreeService {
	
	private Collection<Category> categories;
	
	public TreeService(Collection<Category> categories) {
		this.categories = categories;
	}

	public static TreeService newTreeService(Collection<Category> categories){
		return new TreeService(categories);
	}

	public String getTree(){
		if(ObjectUtils.isNull(categories) || categories.isEmpty()){
			return StringUtils.EMPTY;
		}
		StringBuilder tree = new StringBuilder();
		Collection<Category> roots = getRoot();
		for(Category root : roots){
			doTree(tree,root);
		}
		return tree.toString();
	}
	
	private void doTree(StringBuilder tree, Category category){
		Collection<Category> children = getChildren(category);
		if(children.isEmpty()){
			tree.append(getBasehtmlUnit(category));
			return;
		}
		tree.append(getPreChildhtmlUnit(category));
		for(Category child : children){
			doTree(tree,child);
		}
		tree.append(getPostChildhtmlUnit(category));
	}
	
	private Collection<Category> getRoot(){
		Collection<Category> filterList = Collections2.filter(categories, new Predicate<Category>() {
			@Override
			public boolean apply(Category input) {
				return StringUtils.isEmpty(input.getParentId());
			}
		});
		return filterList;
	}
	
	private Collection<Category> getChildren(Category category){
		Collection<Category> filterList = Collections2.filter(categories, new Predicate<Category>() {
			@Override
			public boolean apply(Category input) {
				return category.getId().equals(input.getParentId());
			}
		});
		return filterList;
	}
	
	private String getBasehtmlUnit(Category category ){
		StringBuilder node = new StringBuilder();
		node.append("<li data-id=\"").append(category.getId()).append("\" class=\"dd-item dd3-item\">")
		    .append("<div class=\"dd-handle dd3-handle\"></div>")
		    .append("<div onclick=\"addActiveClass(this)\" class=\"dd3-content\">").append(category.getName()).append("</div>")
		    .append("</li>");
		return node.toString();
	}
	
	private String getPreChildhtmlUnit(Category category ){
		StringBuilder node = new StringBuilder();
		node.append("<li data-id=\"").append(category.getId()).append("\" class=\"dd-item dd3-item\">")
		    .append("<div class=\"dd-handle dd3-handle\"></div>")
		    .append("<div onclick=\"addActiveClass(this)\" class=\"dd3-content\">").append(category.getName()).append("</div>")
		    .append("<ol class=\"dd-list\">");
		return node.toString();
	}
	
	private String getPostChildhtmlUnit(Category category ){
		StringBuilder node = new StringBuilder();
		node.append("</ol>").append("</li>");
		return node.toString();
	}
}
