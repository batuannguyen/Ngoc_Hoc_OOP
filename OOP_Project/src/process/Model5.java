package process;

import java.util.List;

import pre_process.Modeling;

public class Model5 extends Sentences implements Modeling {
	private String[] phien = {"phiên"};
	
	private void modelTimes(List<String> list) {
		int index = StringProcess.findIndex(list, phien);
        if (index >= 0) {
            String s;
            s= list.get(index - 1);
            if (StringProcess.isNumeric(s)) {
                list.set(index - 1, TIMES);
            }
            else {
                for(int j = index; j < index+4;j++) {
                    s = list.get(j);
                    if(StringProcess.isNumericb(s)) {
                        list.set(j,TIMES);
                    }
                }
            }
        }
	}
	@Override
	public void baseModel(List<String> list) {
		new Model4().baseModel(list);
	}
	@Override
	public String modeling(String st) {
		List<String> list = StringProcess.convertToList(st);
		baseModel(list);
		modelTimes(list);
		return StringProcess.convertToString(list);
	}
	
	public static void main(String[] args) {
		Model5 md = new Model5();
		System.out.println(md.modeling("Chỉ số VN-Index sau 2 phiên tăng liên tiếp, lên 172,66 điểm (tăng 0,37%)."));
	}

}
