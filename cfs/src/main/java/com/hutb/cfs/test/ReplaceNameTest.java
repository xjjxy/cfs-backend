package com.hutb.cfs.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceNameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(replaceNameX("张志健"));
	}

	public static String replaceNameX(String str) {
		String custName = str;
		int len = custName.length();

		String reg = ".{1}";
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		int i = 0;
		while (m.find()) {
			i++;
			if (i == len || i == 1) {
				continue;
			}
			m.appendReplacement(sb, "*");
		}
		m.appendTail(sb);
		return sb.toString();
	}

}
