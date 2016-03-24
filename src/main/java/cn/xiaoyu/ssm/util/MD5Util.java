package cn.xiaoyu.ssm.util;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

/**
 * @author 章小雨
 * @date 2016年3月24日
 * @email roingeek@qq.com
 */
public class MD5Util {
	public static String encrypt(String str) {
		try {
			// 确定计算方法
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64 = new BASE64Encoder();
			// 加密后的字符串
			String result = base64.encode(md5.digest(str.getBytes("utf-8")));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
