package cn.xsshome.taip.util;

import java.util.Random;
/**
 * 获取随机字符串
 * @author 小帅丶
 * @version 0.0.1 
 */
public class RandomNonceStrUtil {
	/**
	 * @param length 表示生成字符串的长度  
	 * @return String
	 */
	public static String getRandomString(int length) {
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < length; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
	/**
	 * DECORATION 定长
	 * @return String
	 */
	public static String getRandomString() {
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i < 10; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }     
	    return sb.toString();     
	 }
}
