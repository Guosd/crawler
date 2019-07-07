package scanweb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 直接使用Map进行缓存
 * @author Guosd
 */
public class CacheUtil {
	private static Map<String, String> map = new HashMap<String, String>();
	//初始化参数
	static {
		String path = FileUtil.class.getResource("").getPath()+"Application.parameter";
		List<String> readFile = FileUtil.readFile(path);
		for(String row : readFile) {
			//去除空行，还有注释。
			if(row.startsWith("#") ||row.trim().length()==0) {
				continue;
			}
			String key = row.substring(0, row.indexOf(":")).trim();
			String value = row.substring(row.indexOf(":")+1,row.length()).trim();
			map.put(key, value);
		}
	}
	
	//获取初始化参数
	public static String getParam(String key) {
		return map.get(key);
	}
}
