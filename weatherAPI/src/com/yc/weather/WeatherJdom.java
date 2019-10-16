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
		xml("衡阳");
		json("衡阳");
	}
 
}
下午 7:38:12
樱桃小雪姨，你好棒哦😊 2019/10/16 星期三 下午 7:38:12
樱桃小雪姨，你好棒哦 2019/10/16 19:38:09
package com.yc.weather;
 
import java.util.ArrayList;
import java.util.List;
 
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
/**
 * 天气数据xml解析
 * @author Administrator
 *
 */
public class WeatherJdom {
 
	public static Weather xml(String City) throws Exception {
 
		Weather weather = new Weather();
		// 使用的是sax遍历
		SAXBuilder builder = new SAXBuilder();
		// builder返回值是一个document类型的值,给出需要解析的xml的路径,可能会抛异常
		Document document = null;
		try {
			document = WeatherApi.xml(City);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取根节点，返回值是一个元素类型的值
		Element resp = document.getRootElement();
		// 获取根节点下的子节点，返回类型为List类型的值
		Element city = resp.getChild("city");// 获得city元素
		weather.setCity(city.getText());
 
		Element updatetime = resp.getChild("updatetime");
		weather.setUpdatetime(updatetime.getText());
 
		Element wendu = resp.getChild("wendu");
		weather.setWendu(wendu.getText());
 
		Element fengli = resp.getChild("fengli");
		weather.setFengli(fengli.getText());
 
		Element shidu = resp.getChild("shidu");
		weather.setShidu(shidu.getText());
 
		Element fengxiang = resp.getChild("fengxiang");
		weather.setFengxiang(fengxiang.getText());
 
		Element sunrise = resp.getChild("sunrise_1");
		weather.setSunrise(sunrise.getText());
 
		Element sunset = resp.getChild("sunset_1");
		weather.setSunset(sunset.getText());
 
		Element yesterday = resp.getChild("yesterday");
		Element date_1 = yesterday.getChild("date_1");
		weather.setYesterday_date(date_1.getText());
 
		Element high_1 = yesterday.getChild("high_1");
		weather.setYesterday_high(high_1.getText());
 
		Element low_1 = yesterday.getChild("low_1");
		weather.setYesterday_low(low_1.getText());
 
		Element day_1 = yesterday.getChild("day_1");
		Element type_1 = day_1.getChild("type_1");
		weather.setYesterday_day_type(type_1.getText());
 
		Element fx_1 = day_1.getChild("fx_1");
		weather.setYesterday_day_fx(fx_1.getText());
 
		Element fl_1 = day_1.getChild("fl_1");
		weather.setYesterday_day_fl(fl_1.getText());
 
		Element night_1 = yesterday.getChild("night_1");
		Element night_type_1 = night_1.getChild("type_1");
		weather.setYesterday_night_type(night_type_1.getText());
 
		Element night_fx_1 = night_1.getChild("fx_1");
		weather.setYesterday_night_fx(night_fx_1.getText());
 
		Element night_fl_1 = night_1.getChild("fl_1");
		weather.setYesterday_night_fl(night_fl_1.getText());
 
		Element forecast = resp.getChild("forecast");
		List weather_list = forecast.getChildren();
 
		weather.list_weather = new ArrayList<ForecastWeather>();
 
		for (int i = 0; i < weather_list.size(); i++) {
 
			Element Weather = (Element) weather_list.get(i);
			ForecastWeather ForecastWeather = new ForecastWeather();
 
			ForecastWeather.setDate(Weather.getChildText("date"));
			ForecastWeather.setHigh(Weather.getChildText("high"));
			ForecastWeather.setLow(Weather.getChildText("low"));
 
			Element weather_day = Weather.getChild("day");
			ForecastWeather.setDay_type(weather_day.getChildText("type"));
			ForecastWeather.setDay_fengxiang(weather_day.getChildText("fengxiang"));
			ForecastWeather.setDay_fengli(weather_day.getChildText("fengli"));
 
			Element weather_night = Weather.getChild("night");
			ForecastWeather.setNight_type(weather_night.getChildText("type"));
			ForecastWeather.setNight_fengxiang(weather_night.getChildText("fengxiang"));
			ForecastWeather.setNight_fengli(weather_night.getChildText("fengli"));
 
			weather.list_weather.add(ForecastWeather);
		}
 
		Element zhishu = resp.getChild("zhishus");
		List zhishu_list = zhishu.getChildren();
 
		weather.list_zhishu = new ArrayList<Zhishu>();
		for (int j = 0; j < zhishu_list.size(); j++) {
 
			Element Zhishu = (Element) zhishu_list.get(j);
			Zhishu ZH = new Zhishu();
 
			ZH.setName(Zhishu.getChildText("name"));
			ZH.setValue(Zhishu.getChildText("value"));
			ZH.setDetail(Zhishu.getChildText("detail"));
 
			weather.list_zhishu.add(ZH);
		}
 
		System.out.println(weather);
		System.out.println(weather.list_weather);
 
		return weather;
	}
 
	/**
	 * 测试一下
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		xml("衡阳");
	}
}
