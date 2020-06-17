package process;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringProcess {
	
	public static boolean isNumericb(String str) {
		String[] tmp = {"một","hai","ba","bốn","năm","sáu","bảy","tám","chín"};
		for (String s:tmp) if (str.contains(s)) {
			return true;
		}
		return false;
	}
	public static String process(String st, String s, String replace) {
		StringBuffer buf = new StringBuffer();
		if (st.indexOf(s) < 0) {
			return null;
		} else {
			int l = st.indexOf(s);
			buf.append(st.substring(0, l));
			buf.append(replace);
			buf.append(st.substring(l + s.length()));
			return buf.toString();
		}
	}

	public static String convertToString(List<String> list) {
		StringBuffer buffer = new StringBuffer();
		for (String st : list) {
			buffer.append(st);
			buffer.append(" ");
		}
		return buffer.toString();
	}
	
	public static List<String> convertToList(String st){
		List<String> list = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(st);
		while (token.hasMoreTokens()) {
			list.add(token.nextToken());
		}
		return list;
	}
	
	public static String toUpperString(String st) {
		StringBuffer buffer = new StringBuffer();
		for (int i=0;i<st.length();i++) {
			buffer.append(Character.toUpperCase(st.charAt(i)));
		}
		return buffer.toString();
	}
	public static boolean isContain(String[] list, String t) {
		int size = list.length;
		for (int i = 0; i < size; i++) {
			if (t.contains(list[i])) {
				return true;
			}
		}
		return false;
	}
	
	public static int findIndex(List<String> list, String[] temp) {
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for (int j = 0; j < temp.length; j++) {
				if (s.contains(temp[j]))
					return i;
			}
		}
		return -1;
	}
	
	public static boolean isNumeric(String str) {
		for (int i = 0;i < str.length();i++) if (Character.isDigit(str.charAt(i))) {
			return true;
		}
		return false;
	}
	
	public static int[] findIndexArray(List<String> list, String[] temp) {
		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			a[i] = -1;
		}
		int k = 0;
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for (int j = 0; j < temp.length; j++) {
				if (s.contains(temp[j])) {
					a[k] = i;
					k++;
				}
			}
		}
		return a;
	}
}
