package process;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import input.*;
import java.util.List;
import java.util.Random;
import java.util.Set;


import pre_process.*;
public class Model1 extends Sentences  implements Modeling{

	@Override
	public String modeling(String st) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		StringBuffer buffer = new StringBuffer();
		String[] arr = st.split(" ");
		for (String s:arr) {
			list.add(s);
		}
		for (int i = 0;i<list.size();i++) {
			String s = list.get(i);
			if (s.indexOf("Vn-Index")>=0||s.indexOf("VN-Index")>=0) {
				list.set(i, NAME_INDEX);
			}
			else if (s.indexOf('/')>=0) {
				int l = s.indexOf('/')-1;
				int r = l+2;
				while (Character.isDigit(s.charAt(l))==true) {
					l--;
					if (l==-1) break;
				}
				while (Character.isDigit(s.charAt(r))==true) {
					r++;
					if (r==s.length()) break;
				}
				StringBuffer buf = new StringBuffer();
				buf.append(s.substring(0,l+1));
				buf.append(DAY);
				buf.append(s.substring(r));
				list.set(i, buf.toString());
			}
			else if (s.indexOf('%')>=0) {
				int l = 0;
				while (Character.isDigit(s.charAt(l))==false) l++;
				int r = s.indexOf('%');
				StringBuffer buf = new StringBuffer();
				buf.append(s.substring(0, l));
				buf.append(STATE);
				buf.append(s.substring(r));
				list.set(i, buf.toString());
			}
			else if (Character.isDigit(s.charAt(0))==true) {
				String pre = list.get(i-1);
				if (pre.equals("tăng")||pre.equals("giảm")) {
					list.set(i, CHANGE);
				}
				else list.set(i, PRICE);
			}
			
		}
		for (String s:list) {
			buffer.append(s);
			buffer.append(' ');
		}
		return buffer.toString();
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		try {
			List<String> list = Information.getList(new File("tang.txt"));
			for (String s:list) {
				addSentences(modeling(s));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<String> xuat(int num){
		List<String> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Random rd = new Random();
		int n = size();
		while (set.size()<num) {
			set.add(rd.nextInt(n));
		}
		for (int i:set) {
			list.add(getIndex(i));
		}
		return list;
	}
	
}
