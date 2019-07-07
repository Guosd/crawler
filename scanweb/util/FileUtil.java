package scanweb.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	��ȡ�ļ�ʹ��
 * @author Guosd
 *
 */
public class FileUtil {
	
	/**
	 * ��ȡ�ļ�
	 * @param file �ļ�
	 * @return ʹ��list����ÿһ��
	 */
	public static List<String> readFile(File file) {
		Scanner sc;
		List<String> row = new ArrayList<String>();
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				row.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	
	/**
	 * ����·����ȡ�ļ�
	 * @param file �ļ�·��
	 * @return ʹ��list����ÿһ��
	 */
	public static List<String> readFile(String path){
		File file = new File(path);
		return readFile(file);
	}
	
}
