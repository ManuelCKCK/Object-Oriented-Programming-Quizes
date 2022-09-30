package Product;

public abstract class Foods {

	protected String DrinkID;
	protected String DrinkName;
	protected String DrinkType;
	protected int DrinkPrice;
	public Foods(String drinkID, String drinkName, String drinkType, int drinkPrice) {
		super();
		DrinkID = drinkID;
		DrinkName = drinkName;
		DrinkType = drinkType;
		DrinkPrice = drinkPrice;
	}
	public String getDrinkID() {
		return DrinkID;
	}
	public void setDrinkID(String drinkID) {
		DrinkID = drinkID;
	}
	public String getDrinkName() {
		return DrinkName;
	}
	public void setDrinkName(String drinkName) {
		DrinkName = drinkName;
	}
	public String getDrinkType() {
		return DrinkType;
	}
	public void setDrinkType(String drinkType) {
		DrinkType = drinkType;
	}
	public int getDrinkPrice() {
		return DrinkPrice;
	}
	public void setDrinkPrice(int drinkPrice) {
		DrinkPrice = drinkPrice;
	}
	
	public abstract void Print();

}
