package com.yc.weather;
 
/**
 * 天气指数类
 * @author Administrator
 *
 */
public class Zhishu {
 
	private String name="";
	private String value="";
	private String detail="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Zhishu [name=" + name + ", value=" + value + ", detail=" + detail + "]";
	}
	
	
}
