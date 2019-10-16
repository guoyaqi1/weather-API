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
 * ����Ԥ���ӿ�
 * 
 * @author Administrator
 *
 */
public class WeatherApi {
	/**
	 * ��Json����
	 * 
	 * @param City
	 * @throws Exception
	 */
	public static void json(String City) throws Exception {
		// ����url��
		String city = URLEncoder.encode(City, "utf-8");
		// ƴ��ַ
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s", city);
		// ��ʼ����
		URL url = new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		// ����ת��ΪString
		String result = IOUtils.toString(input, "utf-8");
		// ���
		System.out.println(result);
	}
 
	/**
	 * ��xml����
	 * 
	 * @param City
	 * @return
	 * @throws Exception
	 */
	public static Document xml(String City) throws Exception {
		// ����url��
		String city = URLEncoder.encode(City, "utf-8");
		// ƴ��ַ
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/xml.shtml?city=%s", city);
		// ��ʼ����
		URL url = new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = null;
		try {
			input = open.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ����ת��ΪString
		String result = IOUtils.toString(input, "utf-8");
		// ���
		System.out.println(result);
		StringReader sr = new StringReader(result);
		InputSource is = new InputSource(sr);
		Document doc = (new SAXBuilder()).build(is);
		return doc;
	}
 
	/**
	 * ����һ��
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		xml("����");
		json("����");
	}
 
}
