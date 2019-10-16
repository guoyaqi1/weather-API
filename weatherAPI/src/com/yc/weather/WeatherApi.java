package com.yc.weather;
 
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
import org.apache.commons.io.IOUtils;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;
 
/**
 * 天气预报接口
 * 
 * @author Administrator
 *
 */
public class WeatherApi {
	/**
	 * 以Json返回
	 * 
	 * @param City
	 * @throws Exception
	 */
	public static void json(String City) throws Exception {
		// 参数url化
		String city = URLEncoder.encode(City, "utf-8");
		// 拼地址
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
		// 开始请求
		URL url = new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		// 这里转换为String
		String result = IOUtils.toString(input, "utf-8");
		// 输出
		System.out.println(result);
	}
 
	/**
	 * 以xml返回
	 * 
	 * @param City
	 * @return
	 * @throws Exception
	 */
	public static Document xml(String City) throws Exception {
		// 参数url化
		String city = URLEncoder.encode(City, "utf-8");
		// 拼地址
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/xml.shtml?city=%s", city);
		// 开始请求
		URL url = new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = null;
		try {
			input = open.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 这里转换为String
		String result = IOUtils.toString(input, "utf-8");
		// 输出
		System.out.println(result);
		StringReader sr = new StringReader(result);
		InputSource is = new InputSource(sr);
		Document doc = (new SAXBuilder()).build(is);
		return doc;
	}
 
	/**
	 * 测试一下
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		xml("荆州");
		json("荆州");
	}
 
}
