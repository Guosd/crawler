package scanweb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Url������
 * @author Guosd
 *
 */
public class UrlUtil {
	/**
	 * URL ���н���
	 * @param content ��������
	 * @param charset �����ַ�����
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
	 * URL ���н���
	 * @param content ��������
	 * @param charset �����ַ�����
	 * @param count  ת�����
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
	 * URL ���н���
	 * @param content ��������
	 * @param count  ת�����
	 * @return
	 */
	public static String decoder(String content,int count) {
		String charset = CacheUtil.getParam("charset");
		return decoder(content, charset,count);
	}
	
	/**
	 * URL ���н���
	 * @param content ��������
	 * @return
	 */
	public static String decoder(String content) {
		String charset = CacheUtil.getParam("charset");
		return decoder(content, charset,1);
	}

	
	
	/**
	 * URL ���б���
	 * @param content ��������
	 * @param charset �����ַ�����
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
	 * URL ���б���
	 * @param content ��������
	 * @param charset �����ַ�����
	 * @param count  ת�����
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
	 * URL ���б���
	 * @param content ��������
	 * @param count  ת�����
	 * @return
	 */
	public static String encoder(String content,int count) {
		String charset = CacheUtil.getParam("charset");
		return encoder(content, charset,count);
	}
	
	/**
	 * URL ���б���
	 * @param content ��������
	 * @return
	 */
	public static String encoder(String content) {
		String charset = CacheUtil.getParam("charset");
		return encoder(content, charset,1);
	}

	
}
