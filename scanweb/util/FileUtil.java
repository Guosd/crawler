package scanweb.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 	读取文件使用
 * @author Guosd
 *
 */
public class FileUtil {
	
	/**
	 * 读取文件
	 * @param file 文件
	 * @return 使用list返回每一行
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
	 * 根据路径读取文件
	 * @param file 文件路径
	 * @return 使用list返回每一行
	 */
	public static List<String> readFile(String path){
		File file = new File(path);
		return readFile(file);
	}
	
}
