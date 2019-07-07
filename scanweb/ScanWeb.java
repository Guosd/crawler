package scanweb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scanweb.util.CacheUtil;
import scanweb.util.MineHttpClient;
import scanweb.util.UrlUtil;

public class ScanWeb {
	public static void main(String[] args) {
		findResource();
		
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
