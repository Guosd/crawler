package scanweb.util;

/**
 * 字符串转码
 * @author Guosd
 *
 */
public class StringUtil {

	/**
	 * 解析单个Unicode编码
	 * @param encode
	 * @return
	 */
	public static String unicode2cn(String encode) {
		char decode = (char) Integer.valueOf(encode, 16).intValue();
		return decode+"";
	}
	
	/**
	 * 将Unicode字符串解析成能识别的字符
	 * @param content 网页内容
	 * @return
	 */
	public static String translate(String content) {
		if(content.contains("\\u")) {
			int index = content.indexOf("\\u");
			String contentBefore = content.substring(0, index);
			String decode = unicode2cn(content.substring(index+2,index+6));
			String contentAfter = content.substring(index+6);
			return translate(contentBefore+decode+contentAfter);
		}else {
			return content;
		}
		
	}
}
