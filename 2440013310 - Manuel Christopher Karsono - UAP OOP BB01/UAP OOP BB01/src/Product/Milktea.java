package Product;

public class Milktea extends Foods{

	private String MilkType;
	
	public Milktea(String drinkID, String drinkName, String drinkType, int drinkPrice, String MilkType) {
		super(drinkID, drinkName, drinkType, drinkPrice);
		this.MilkType = MilkType;
	}

	@Override
	public void Print() {
		System.out.printf("| %s | %s | %s | %d | - | %s |\n",DrinkID,DrinkName,DrinkType,DrinkPrice,MilkType);
		
	}

	

}
