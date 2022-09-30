package Station;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connector.Connect;
import Product.Foods;
import Product.Milktea;
import Product.Tea;

public class Station {
	
	Connect connect = Connect.getConnection();
	
	public void getTransaction(ArrayList<Transaction> transactionlList) {
		String query = "SELECT * FROM transaction";
		
		ResultSet rsTransaction = connect.executeQuery(query);
		try {
			while(rsTransaction.next()) {
				String TransactionID = rsTransaction.getString("TransactionID");
				String DrinkID = rsTransaction.getString("DrinkID");
				String BuyerName = rsTransaction.getString("BuyerName");
				int Quantity = rsTransaction.getInt("Quantity");
				
				transactionlList.add(new Transaction(TransactionID, DrinkID, BuyerName, Quantity));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getMilks(ArrayList<Foods> foodlList) {
		foodlList.clear();
		String queryTea = "SELECT * FROM tea";
		String queryMilktea = "SELECT * FROM milktea";
		
		ResultSet rsTea = connect.executeQuery(queryTea);
		
		try {
			while(rsTea.next()) {
				String drinkID = rsTea.getString("DrinkID");
				String DrinkName = rsTea.getString("DrinkName");
				String DrinkType = rsTea.getString("DrinkType");
				int DrinkPrice = rsTea.getInt("DrinkPrice");
				String SugarType = rsTea.getString("SugarType");
				
				foodlList.add(new Tea(drinkID, DrinkName, DrinkType, DrinkPrice, SugarType));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ResultSet rsMilktea = connect.executeQuery(queryMilktea);
		try {
			while(rsMilktea.next()) {
				String drinkID = rsMilktea.getString("DrinkID");
				String DrinkName = rsMilktea.getString("DrinkName");
				String DrinkType = rsMilktea.getString("DrinkType");
				int DrinkPrice = rsMilktea.getInt("DrinkPrice");
				String MilkType = rsMilktea.getString("MilkType");
				
				foodlList.add(new Milktea(drinkID, DrinkName, DrinkType, DrinkPrice, MilkType));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String generateID() {
		String query = "SELECT * FROM transaction";
		ResultSet rsQuery = connect.executeQuery(query);
		String iD = "";
		try {
			while(rsQuery.next()) {
				iD = rsQuery.getString("TransactionID");
				
				if (iD.equals("")) {
					return "TE001";
				}
			String idNum = iD.substring(2,5);
			int idNumfinal = Integer.parseInt(idNum);
			idNumfinal++;
			if (idNumfinal < 10) {
				return "TE00" + idNumfinal;
			}
			else if(idNumfinal < 100) {
				return "TE0" + idNumfinal;
			}
			else if(idNumfinal < 1000) {
				return "TE" + idNumfinal;
			}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void insertTransaction(String TransactionID,String DrinkID, String BuyerName, int Quantity) {
		String Query = String.format("INSERT INTO transaction VALUE ('%s','%s','%s','%d')", TransactionID,DrinkID,BuyerName,Quantity);
		connect.executeUpdate(Query);
	}
	
	public void deleteTransaction (String TransactionID) {
		String query = String.format("DELETE FROM transaction WHERE TransactionID = '%s'", TransactionID);
		connect.executeUpdate(query);
	}

}
