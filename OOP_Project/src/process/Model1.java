package process;
import java.util.ArrayList;

import java.util.List;

import pre_process.*;
/**
 * Chứa các luật để mô hình câu
 * @author Ngốc_Học_OOP
 *
 */
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
		baseModel(list);
		for (String s:list) {
			buffer.append(s);
			buffer.append(' ');
		}
		return buffer.toString();
	}
	
	
	

	
}
