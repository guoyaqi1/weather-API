package com.yc.weather;
 
/**
 * 天气预报实体类
 * @author Administrator
 *
 */
public class ForecastWeather {
 
	private String date="";
	private String high="";
	private String low="";
	// day
	private String day_type="";
	private String day_fengxiang="";
	private String day_fengli="";
	// night
	private String night_type="";
	private String night_fengxiang="";
	private String night_fengli="";
 
	public String getDate() {
		return date;
	}
 
	public void setDate(String date) {
		this.date = date;
	}
 
	public String getHigh() {
		return high;
	}
 
	public void setHigh(String high) {
		this.high = high;
	}
 
	public String getLow() {
		return low;
	}
 
	public void setLow(String low) {
		this.low = low;
	}
 
	public String getDay_type() {
		return day_type;
	}
 
	public void setDay_type(String day_type) {
		this.day_type = day_type;
	}
 
	public String getDay_fengxiang() {
		return day_fengxiang;
	}
 
	public void setDay_fengxiang(String day_fengxiang) {
		this.day_fengxiang = day_fengxiang;
	}
 
	public String getDay_fengli() {
		return day_fengli;
	}
 
	public void setDay_fengli(String day_fengli) {
		this.day_fengli = day_fengli;
	}
 
	public String getNight_type() {
		return night_type;
	}
 
	public void setNight_type(String night_type) {
		this.night_type = night_type;
	}
 
	public String getNight_fengxiang() {
		return night_fengxiang;
	}
 
	public void setNight_fengxiang(String night_fengxiang) {
		this.night_fengxiang = night_fengxiang;
	}
 
	public String getNight_fengli() {
		return night_fengli;
	}
 
	public void setNight_fengli(String night_fengli) {
		this.night_fengli = night_fengli;
	}
 
	@Override
	public String toString() {
		return "ForecastWeather [date=" + date + ", high=" + high + ", low=" + low + ", day_type=" + day_type
				+ ", day_fengxiang=" + day_fengxiang + ", day_fengli=" + day_fengli + ", night_type=" + night_type
				+ ", night_fengxiang=" + night_fengxiang + ", night_fengli=" + night_fengli + "]";
	}
 
}

