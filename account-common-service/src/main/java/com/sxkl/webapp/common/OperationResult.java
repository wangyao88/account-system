package com.sxkl.webapp.common;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Data;

/**
 * @author: wangyao
 * @date: 2018年4月10日 下午1:30:40
 * @description: 
 */
@Data
public class OperationResult {

	private String msg;
	private boolean status;
	private Object data;
	private Integer total;
	
	public static String configurateSuccessResult(){
		Gson gson = new Gson();
		OperationResult operateResult = new OperationResult();
		operateResult.setMsg("操作成功");
		operateResult.setStatus(true);
		return gson.toJson(operateResult);
	}
	
	public static String configurateSuccessResult(Object data){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		OperationResult operateResult = new OperationResult();
		operateResult.setMsg("操作成功");
		operateResult.setStatus(true);
		operateResult.setData(data);
		return gson.toJson(operateResult);
	}
	
	public static String configurateFailureResult(){
		Gson gson = new Gson();
		OperationResult operateResult = new OperationResult();
		operateResult.setMsg("操作失败");
		operateResult.setStatus(false);
		return gson.toJson(operateResult);
	}
	
	public static String configurateFailureResult(String err){
		Gson gson = new Gson();
		OperationResult operateResult = new OperationResult();
		operateResult.setMsg("操作失败！"+err);
		operateResult.setStatus(false);
		return gson.toJson(operateResult);
	}

	@SuppressWarnings("rawtypes")
	public static String configurateSuccessDataGridResult(List datas, int total) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		OperationResult operateResult = new OperationResult();
		operateResult.setMsg("操作成功");
		operateResult.setStatus(true);
		operateResult.setData(datas);
		operateResult.setTotal(total);
		return gson.toJson(operateResult);
	}
	
	public static OperationResult deserialize(String result){
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(result, OperationResult.class);
	}
}
