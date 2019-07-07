package scanweb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Url解码类
 * @author Guosd
 *
 */
public class UrlUtil {
	/**
	 * URL 进行解码
	 * @param content 编码内容
	 * @param charset 编码字符类型
	 * @return
	 */
	public static String decoder(String content,String charset) {
		String decode = "";
		try {
			decode = URLDecoder.decode(content,charset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decode;
	}
	
	
	/**
	 * URL 进行解码
	 * @param content 编码内容
	 * @param charset 编码字符类型
	 * @param count  转码次数
	 * @return
	 */
	public static String decoder(String content,String charset,int count) {
		if(count <=0) {
			return content;
		}else {
			String decoder = decoder(content, charset);
			return decoder(decoder, charset,count-1);
		}
	}
	
	/**
	 * URL 进行解码
	 * @param content 编码内容
	 * @param count  转码次数
	 * @return
	 */
	public static String decoder(String content,int count) {
		String charset = CacheUtil.getParam("charset");
		return decoder(content, charset,count);
	}
	
	/**
	 * URL 进行解码
	 * @param content 编码内容
	 * @return
	 */
	public static String decoder(String content) {
		String charset = CacheUtil.getParam("charset");
		return decoder(content, charset,1);
	}

	
	
	/**
	 * URL 进行编码
	 * @param content 编码内容
	 * @param charset 编码字符类型
	 * @return
	 */
	public static String encoder(String content,String charset) {
		String encode = "";
		try {
			encode = URLEncoder.encode(content, charset);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encode;
	}
	
	/**
	 * URL 进行编码
	 * @param content 编码内容
	 * @param charset 编码字符类型
	 * @param count  转码次数
	 * @return
	 */
	public static String encoder(String content,String charset,int count) {
		if(count <=0) {
			return content;
		}else {
			String encoder = encoder(content, charset);
			return encoder(encoder, charset,count-1);
		}
	}
	
	/**
	 * URL 进行编码
	 * @param content 编码内容
	 * @param count  转码次数
	 * @return
	 */
	public static String encoder(String content,int count) {
		String charset = CacheUtil.getParam("charset");
		return encoder(content, charset,count);
	}
	
	/**
	 * URL 进行编码
	 * @param content 编码内容
	 * @return
	 */
	public static String encoder(String content) {
		String charset = CacheUtil.getParam("charset");
		return encoder(content, charset,1);
	}

}
