package process;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import input.Information;
import input.Session;
import pre_process.Export;

public class Export3 extends Sentences implements Export {

	private String checkSizeCandle(String sheet, int row) throws Exception {
		Session session = Information.getRow(sheet, row);
		float closePrice = session.getPrice();
		float startPrice = session.getStartPrice();
		if (Math.abs(closePrice - startPrice) > Session.THRESHOLD)
			return "thân dài";
		else
			return "thân ngắn";
	}

	private String checkColorCandle(String sheet, int row) throws Exception {
		Session session = Information.getRow(sheet, row);
		if (session.getPrice() > session.getStartPrice())
			return "xanh";
		else
			return "đỏ";
	}

	private boolean checkDataIncrease(String sheet, int row) throws Exception {
		Session session1 = Information.getRow(sheet, row);
		Session session2 = Information.getRow(sheet, row + 1);
		if (session1.getMatchingTradeWeight().compareTo(session2.getMatchingTradeWeight()) > 0)
			return true;
		else
			return false;
	}

	private void replaceCandle(String result, Session session) {
		String sheet = session.getNameIndex();
		String day = session.getDay();
		System.out.println(sheet + " " + day);
		int row = -1;
		try {
			row = Information.rowIndex(sheet, day);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (result.indexOf("nến") >= 0) {
			if (result.indexOf(COLORCANDLE) >= 0)
				try {
					result = result.replace(COLORCANDLE, this.checkColorCandle(sheet, row));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		String[] shape = { "thân rất dài", "thân dài", "thân rất ngắn", "thân ngắn", "thân to", "thân nhỏ" };
		for (int i = 0; i < shape.length; i++) // Replace size:
			if (result.indexOf(shape[i]) >= 0)
				try {
					result = result.replace(shape[i], this.checkSizeCandle(sheet, row));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		if (result.indexOf("so với ngày hôm qua") >= 0) {
			try {
				if (this.checkDataIncrease(sheet, row))
					result = result.replace("giảm", "tăng");
				else
					result = result.replace("tăng", "giảm");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String replace(String st, Session session) {
		// TODO Auto-generated method stub
		Float price = session.getPrice(); // Lấy giá
		Float change = session.getChange(); // Lấy giá thay đổi
		Float state = session.getState(); // Lấy trạng thái (%)
		// Tất cả các thông tin của phiên được string
		String[] repl = { session.getNameIndex(), session.getDay(), price.toString(), change.toString(),
				state.toString(), session.getMatchingTradeWeight(), session.getMatchingTradeValue(),
				session.getTransactionWeight(), session.getTransactionValue() };
		// Tất cả các key đã được mã hoá trong xâu st
		String[] conv = { NAME_INDEX, DAY, PRICE, CHANGE, STATE, MATCHING_TRADE_WEIGHT, MATCHING_TRADE_VALUE,
				TRANSACTION_WEIGHT, TRANSACTION_VALUE, COLORCANDLE };
		StringBuffer buffer = new StringBuffer();
		List<String> list = new ArrayList<String>();
		for (String s : st.split(" ")) {
			list.add(s); // Chia xâu đã được model => Các từ
		}
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			for (int j = 0; j < 9; j++) {
				if (str.indexOf(conv[j]) >= 0)
					list.set(i, StringProcess.process(str, conv[j], repl[j]));
			}
		}
		for (String s : list) {
			buffer.append(s);
			buffer.append(' ');
		}
		String result = buffer.toString(); // Replace mẫu câu NẾN:
		replaceCandle(result, session);
		return result;
	}

	@Override
	public void export(String nameIndex, String day) {
		exportDefault(nameIndex, day, new Model3(), this, new File("tang3.txt"));
	}

	public static void main(String[] args) {
		Export3 exp = new Export3();
		exp.export("VN-INDEX", "22/05/2020");
		for (String st : Sentences.listSentences) {
			System.out.println(st);
		}
	}

}
