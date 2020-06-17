package pre_process;

import java.util.List;

/**
 * Chứa các từ quy ước dùng để mô hình câu
 * 
 * @author Ngốc_Học_OOP
 *
 */
public interface Convention {
	public static final int MAXROW = 23;
	public static final int MINROW = 3;
	public static final String NAME_INDEX = "NameIndex";
	public static final String STATE = "State";
	public static final String PRICE = "Price";
	public static final String DAY = "Day";
	public static final String MATCHING_TRADE_WEIGHT = "MatchingTradeWeight";
	public static final String MATCHING_TRADE_VALUE = "MatchingTradeValue";
	public static final String TRANSACTION_WEIGHT = "TransactionWeight";
	public static final String TRANSACTION_VALUE = "TransactionValue";
	public static final String CHANGE = "Change";
	public static final String COLORCANDLE = "ColorCandle";
	public static final String STARTPRICE = "StartPrice";
	public static String[] setNameIndex = {"VN-INDEX","VN30-INDEX","HNX-INDEX","HNX30-INDEX","UPCOM-INDEX"};
	public static String CURRENTPRICE = "CurrentPrice";
	public String TIMEINC = "TimesIncreases";
	public String TIMEDEC = "TimesDecreases";
	public String TIMES = "TIMES";
	public static String[] Giam  = {"giảm", "xuống"};
	public static String[] Tang  = {"tăng"};
	public static final String CHANGEPRICE = "ChangePrice";
	
	public static final String TANGLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Tanglientiep.txt";
	public static final String GIAMLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Giamlientiep.txt";
	public static final String TANGROIGIAMLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\GiamlientieprooiTang.txt";
	public static final String GIAMROITANGLIENTUC_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Tanglientieproigiam.txt";
	public static final String SOLANTANGGIAM = "C:\\Users\\Admin\\Desktop\\filetxt\\solantang.txt";
	public static final String TANG_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Tang.txt";
	public static final String GIAM_TXT = "C:\\Users\\Admin\\Desktop\\filetxt\\Giam.txt";
	public static final String DATMOC_TXT  = "C:\\Users\\Admin\\Desktop\\filetxt\\DATMOC.txt";
	
	public void modelNameIndex(List<String> list);
	public void modelDay(List<String> list);
	public void modelInc(List<String> list);
	public void modelState(List<String> list);
	public void modelWeight(List<String> list);
	
}
