package com.param;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Description: 正则表达式工具类
 * @Author lucy@mvtech.com.cn
 */
public class RegexTools {
	/**
	 * Description:根据正则表达式匹配字符串，并将所有匹配到的结果返回
	 * @Author lucy@mvtech.com.cn
	 * @param i
	 * @param r
	 * @return
	 */
	public static List<String> getAllMatching(String i, String r) {
		Pattern p = Pattern.compile(r);
		Matcher m = p.matcher(i.trim());
		List<String> l = new ArrayList<String>();
		while (m.find()) {
			l.add(m.group(0).trim());
		}
		return l;
	}
	/**
	 * Description:判断字符串是否被正则表达式匹配到
	 * @Author lucy@mvtech.com.cn
	 * @param s
	 * @param r
	 * @return
	 */
	public static boolean isMatched(String s, String r) {
		Pattern p = Pattern.compile(r);
		Matcher m = p.matcher(s);
		if(m.find()) {
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		/*String fileNameRel = "JSON-info-20210126163355.doc";

		String fileNa = fileNameRel.substring(0, fileNameRel.lastIndexOf("-"));
		String fileNamesuffix = fileNameRel.substring(fileNameRel.lastIndexOf("."));


//		System.out.format("fileNa : %s ,fileNamesuffix: %s",fileNa,fileNamesuffix);
		System.out.println(fileNa+fileNamesuffix);
//		System.out.format("fileNa : %s ,fileNamesuffix: %s","","");*/



	}
	 

}

	