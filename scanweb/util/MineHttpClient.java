package scanweb.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MineHttpClient {
	public static String getWebContent(String url) {
		String content ="";
		try {
			HttpClient client = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse execute = client.execute(httpGet);
			content = EntityUtils.toString(execute.getEntity(), "UTF-8");
		} catch (ClientProtocolException e) {
			System.err.println("通过以下URL获取数据失败\n" + url);
			e.printStackTrace();
		} catch (ParseException e) {
			System.err.println("通过以下URL获取数据失败\n" + url);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("通过以下URL获取数据失败\n" + url);
			e.printStackTrace();
		}
		return content;
	}

}
