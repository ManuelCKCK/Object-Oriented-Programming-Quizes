package Product;

public class Tea extends Foods{

	private String SugarType;
	
	public Tea(String drinkID, String drinkName, String drinkType, int drinkPrice, String SugarType) {
		super(drinkID, drinkName, drinkType, drinkPrice);
		this.SugarType = SugarType;
	}

	@Override
	public void Print() {
		System.out.printf("| %s | %s | %s | %d | %s | - |\n",DrinkID,DrinkName,DrinkType,DrinkPrice,SugarType);
		
	}

	

}
