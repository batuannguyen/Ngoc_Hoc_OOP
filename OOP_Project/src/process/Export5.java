package process;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import input.Information;
import input.Session;
import pre_process.Export;

public class Export5 extends Sentences implements Export {

	private int timesIncConsecutive(Session session) {
		String nameIndex = session.getNameIndex();
		String day = session.getDay();
		try {
			int times = 0;
			int indexBegin = Information.rowIndex(nameIndex, day);
			for (int i = 0; i < 20; i++) {
				Session ses = Information.getRow(nameIndex, indexBegin + i);
				if (ses == null)
					break;
				if (ses.getState() > 0)
					times++;
				else
					break;

			}
			return times;
		} catch (Exception e) {
			return -1;
		}
	}

	private int timesDecConsecutive(Session session) {
		String nameIndex = session.getNameIndex();
		String day = session.getDay();
		try {
			int times = 0;
			int indexBegin = Information.rowIndex(nameIndex, day);
			for (int i = 0; i < 20; i++) {
				Session ses = Information.getRow(nameIndex, indexBegin + i);
				if (ses == null)
					break;
				if (ses.getState() < 0)
					times++;
				else
					break;

			}
			return times;
		} catch (Exception e) {
			return -1;
		}
	}

	private int incAfterDec(Session session) {
		String nameIndex = session.getNameIndex();
		String day = session.getDay();
		try {
			int row = Information.rowIndex(nameIndex, day);
			if (session.getState() > 0)
				return timesDecConsecutive(Information.getRow(nameIndex, row));
			else
				return -1;
		} catch (Exception e) {
			return -1;
		}

	}

	private int decAfterInc(Session session) {
		String nameIndex = session.getNameIndex();
		String day = session.getDay();
		try {
			int row = Information.rowIndex(nameIndex, day);
			if (session.getState() < 0) {
				return timesIncConsecutive(Information.getRow(nameIndex, row));
			} else
				return -1;
		} catch (Exception e) {
			return -1;
		}
	}

	private String getNameFile(Session session) {
		if (timesIncConsecutive(session) > 1)
			return TANGLIENTUC_TXT;
		else if (timesDecConsecutive(session) > 1)
			return GIAMLIENTUC_TXT;
		else if (incAfterDec(session) >= 0)
			return TANGROIGIAMLIENTUC_TXT;
		else if (decAfterInc(session) >= 0)
			return GIAMROITANGLIENTUC_TXT;
		else
			return null;
	}

	private Map<String, String> getData(Session session) {
		HashMap<String, String> info = new HashMap<String, String>();
		info.put(NAME_INDEX, session.getNameIndex());
		info.put(PRICE, Float.toString(session.getPrice()));
		info.put(STATE, Float.toString(session.getState()));
		info.put(CHANGE, Float.toString(session.getChange()));
		return info;

	}

	@Override
	public String replace(String st, Session session) {
		List<String> list = StringProcess.convertToList(st);
		Map<String, String> info = getData(session);
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			for (Entry<String, String> entry : info.entrySet()) {
				if (s.contains(entry.getKey()))
					list.set(i, StringProcess.process(s, entry.getKey(), entry.getValue()));
			}
		}
		String[] times = { TIMES };
		int index = StringProcess.findIndex(list, times);
		if (index >= 0) {
			if (timesIncConsecutive(session) > 0)
				list.set(index, Integer.toString(timesIncConsecutive(session)));
			else if (timesDecConsecutive(session) > 0)
				list.set(index, Integer.toString(timesDecConsecutive(session)));
			else if (incAfterDec(session) > 0)
				list.set(index, Integer.toString(incAfterDec(session)));
			else if (decAfterInc(session) > 0)
				list.set(index, Integer.toString(decAfterInc(session)));
		}

		return StringProcess.convertToString(list);
	}

	@Override
	public void export(String nameIndex, String day) {
		try {
			Session session = Information.getSession(nameIndex, day);
			List<String> list = Information.getList(new File(getNameFile(session)));
			Random rd = new Random();
			String st = list.get(rd.nextInt(list.size()));
			Model5 md = new Model5();
			listSentences.add(replace(md.modeling(st), session));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Export5 exp = new Export5();
		exp.export("VN-INDEX", "07/05/2020");
		for (String st : listSentences) {
			System.out.println(st);
		}
	}

}
