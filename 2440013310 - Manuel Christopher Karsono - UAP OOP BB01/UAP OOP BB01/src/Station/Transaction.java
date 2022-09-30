package Station;

public class Transaction {

	protected String TransactionID;
	protected String DrinkID;
	protected String BuyerName;
	protected int Quantity;
	public Transaction(String transactionID, String drinkID, String buyerName, int quantity) {
		super();
		TransactionID = transactionID;
		DrinkID = drinkID;
		BuyerName = buyerName;
		Quantity = quantity;
	}
	public String getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(String transactionID) {
		TransactionID = transactionID;
	}
	public String getDrinkID() {
		return DrinkID;
	}
	public void setDrinkID(String drinkID) {
		DrinkID = drinkID;
	}
	public String getBuyerName() {
		return BuyerName;
	}
	public void setBuyerName(String buyerName) {
		BuyerName = buyerName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public void PrintTransaction() {
		System.out.printf("| %s | %s | %s | %d |",TransactionID,DrinkID,BuyerName,Quantity);
	}
	
}
