package com.sxkl.webapp.websystem.category.entity;

import lombok.Data;

/**
 * @author: wangyao
 * @date: 2018年4月19日 下午3:53:02
 * @description: 
 */
@Data
public class Category {

	private String id;
	private String name;
	private String parentId;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
}
