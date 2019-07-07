package scanweb;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scanweb.util.CacheUtil;
import scanweb.util.MineHttpClient;
import scanweb.util.StringUtil;
import scanweb.util.UrlUtil;

public class ScanWeb {
	public static void main(String[] args) {
		//findResource();
		getComment();
	}

	/**
	 * 获取评论
	 */
	private static void getComment() {
		String url = CacheUtil.getParam("commentUrl")+"act=list&mid=4391399103116991&uid=3938277745&smartFlag=false&smartCardComment=&isMain=true&suda-data=key%253Dtblog_search_weibo%2526value%253Dweibo_h_1_p_p&pageid=weibo&_t=0&__rnd=1562475663232";
		Map<String, String> map = new HashMap<String, String>();
		map.put("Cookie", CacheUtil.getParam("Cookie"));
		String webContent = MineHttpClient.getWebContent(url,map);
		String translate = StringUtil.translate(webContent);
		System.out.println(translate);
	}

	private static void findResource() {
		//查询条件需要URL两次编码
		String url = CacheUtil.getParam("baseUrl")+UrlUtil.encoder(CacheUtil.getParam("findContent"),2);
		//System.out.println(url);
		
		String webContent = MineHttpClient.getWebContent(url);
		Document parse = Jsoup.parse(webContent);
		Elements elements = parse.select("div[class=card-feed]");
		for(Element element:elements) {
			String cont = "";
			Elements select = element.select("p[class=txt]");
			for (Element content : select) {
				cont += content.text();
			}
			System.out.println(cont);
		}
	}
}
