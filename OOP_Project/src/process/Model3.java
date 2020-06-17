package process;

import java.util.ArrayList;
import java.util.List;

import pre_process.*;

public class Model3 extends Sentences implements Modeling {
	private void modelCandle(String result) {
		if (result.indexOf("nến") >= 0) {
			if (result.indexOf("hôm nay") >= 0)
				result = result.replace("hôm nay", DAY);
			String[] color = { "màu đen", "màu trắng", "màu đỏ", "màu xanh" };
			String stringColor = "màu".concat(" " + COLORCANDLE);
			for (int i = 0; i < 4; i++)
				if (result.indexOf(color[i]) >= 0)
					result = result.replace(color[i], stringColor);
		}
	}

	@Override
	public String modeling(String st) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		StringBuffer buffer = new StringBuffer();
		String[] arr = st.split(" ");
		for (String s : arr) {
			list.add(s);
		}
		baseModel(list);
		modelWeight(list);
		for (String s : list) {
			buffer.append(s);
			buffer.append(' ');
		}
		String result = buffer.toString();
		// Model mẫu câu về nến:
		modelCandle(result);
		return result;
	}

}
