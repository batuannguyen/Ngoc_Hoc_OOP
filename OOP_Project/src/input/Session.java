package input;

public class Session {//Phien giao dich
	private String nameIndex;//Ten chi so
	private String day;//Ngay giao dich
	private float change;//Bien dong so voi ngay hom truoc
	private float state;//Trang thai so voi hom truoc do(tang giam,....)
	private float price;//Gia
	private String matchingTradeWeight;//Khoi luong giao dich khop lenh
	private String matchingTradeValue;//Gia tri giao dich khop lenh
	private String transactionWeight;//Khoi luong giao dich thoa thuan
	private String transactionValue;//Gia tri giao dich thoa thuan
	public static final float strongIncrease = 1.5f; // tăng mạnh
	public static final float increase = 1.0f; // tăng
	public static final float weakIncrease = 0.5f; // tăng nhẹ
	public static final float strongDecrease = -1.5f;// giảm mạnh
	public static final float decrease = -1.0f;// giảm 
	public static final float weakDecrease = -0.5f;// giảm nhẹ

	/*
	* getter and 
	*/
	public String getNameIndex() {
		return nameIndex;
	}
	public void setNameIndex(String nameIndex) {
		this.nameIndex = nameIndex;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public float getState() {
		return state;
	}
	public void setState(float state) {
		this.state = state;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getPrice() {
		return price;
	}
	public String getMatchingTradeWeight() {
		return matchingTradeWeight;
	}
	public void setMatchingTradeWeight(String matchingTradeWeight) {
		this.matchingTradeWeight = matchingTradeWeight;
	}
	public String getMatchingTradeValue() {
		return matchingTradeValue;
	}
	public void setMatchingTradeValue(String matchingTradeValue) {
		this.matchingTradeValue = matchingTradeValue;
	}
	public String getTransactionWeight() {
		return transactionWeight;
	}
	public void setTransactionWeight(String transactionWeight) {
		this.transactionWeight = transactionWeight;
	}
	public String getTransactionValue() {
		return transactionValue;
	}
	public void setTransactionValue(String transactionValue) {
		this.transactionValue = transactionValue;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
	
	
}