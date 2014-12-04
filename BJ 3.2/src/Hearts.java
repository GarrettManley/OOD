
public class Hearts extends Card{
	public int cardValue;
	public int suite;
	public void assignSuite() {
		suite = 3;
	}
	public void assignValue(int i) {
		cardValue = i;
	}
	public String getSuite(){
		return "Heart";
	}
	public String getValue() {
		String value = "";
		if (cardValue == 0)
			value = "2";
		if (cardValue == 1)
			value = "3";
		if (cardValue == 2)
			value = "4";
		if (cardValue == 3)
			value = "5";
		if (cardValue == 4)
			value = "6";
		if (cardValue == 5)
			value = "7";
		if (cardValue == 6)
			value = "8";
		if (cardValue == 7)
			value = "9";
		if (cardValue == 8)
			value = "10";
		if (cardValue == 9)
			value = "Jack";
		if (cardValue == 10)
			value = "Queen";
		if (cardValue == 11)
			value = "King";
		if (cardValue == 12)
			value = "Ace";
		return value;
	}

	public int getNumValue() {
		int value = 0;
		if (cardValue == 0)
			value = 2;
		if (cardValue == 1)
			value = 3;
		if (cardValue == 2)
			value = 4;
		if (cardValue == 3)
			value = 5;
		if (cardValue == 4)
			value = 6;
		if (cardValue == 5)
			value = 7;
		if (cardValue == 6)
			value = 8;
		if (cardValue == 7)
			value = 9;
		if (cardValue == 8)
			value = 10;
		if (cardValue == 9)
			value = 10;
		if (cardValue == 10)
			value = 10;
		if (cardValue == 11)
			value = 10;
		if (cardValue == 12)
			value = 11;
		return value;
	}
	
	
}
