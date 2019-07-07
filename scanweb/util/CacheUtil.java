package scanweb.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ֱ��ʹ��Map���л���
 * @author Guosd
 */
public class CacheUtil {
	private static Map<String, String> map = new HashMap<String, String>();
	//��ʼ������
	static {
		String path = FileUtil.class.getResource("").getPath()+"Application.parameter";
		List<String> readFile = FileUtil.readFile(path);
		for(String row : readFile) {
			//ȥ�����У�����ע�͡�
			if(row.startsWith("#") ||row.trim().length()==0) {
				continue;
			}
			String key = row.substring(0, row.indexOf(":")).trim();
			String value = row.substring(row.indexOf(":")+1,row.length()).trim();
			map.put(key, value);
		}
	}
	
	//��ȡ��ʼ������
	public static String getParam(String key) {
		return map.get(key);
	}
}
