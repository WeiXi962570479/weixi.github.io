package com.xyy.gys.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 200:成功
 * 500:失败，信息在msg中
 * 501:bean验证错误，不管多少错误以map形式返回
 * 502:拦截器拦截到用户token出错
 * 555:异常抛出信息
 * @author WeiXi
 *
 */
public class ImoocJSONResult {
	// 定义json对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	// 响应业务状态
	private Integer status;

	// 响应消息
	private String msg;

	// 响应中的数据
	private Object data;

	public static ImoocJSONResult build(Integer status,String msg,Object data) {
		return new ImoocJSONResult(status, msg, data);
	}

	public static ImoocJSONResult ok(Object data) {
		return new ImoocJSONResult(data);
	}
	
	public static ImoocJSONResult ok() {
		return new ImoocJSONResult(null);
	}
	
	public static ImoocJSONResult errorMsg(String msg) {
		return new ImoocJSONResult(500, msg, null);
	}
	
	public static ImoocJSONResult errorMap(Object data) {
		return new ImoocJSONResult(501, "error", data);
	}
	
	public static ImoocJSONResult errorTokenMsg(String msg) {
		return new ImoocJSONResult(502, msg, null);
	}
	
	public static ImoocJSONResult errorException(String msg) {
		return new ImoocJSONResult(555, msg, null);
	}
	
	
	
	public ImoocJSONResult() {
	}

	public ImoocJSONResult(Object data) {
		this.status = 200;
		this.msg = "ok";
		this.data = data;
	}
	
	public ImoocJSONResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}


	public static ObjectMapper getMapper() {
		return MAPPER;
	}

}
