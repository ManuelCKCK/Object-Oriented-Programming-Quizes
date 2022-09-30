package Store;

import java.util.ArrayList;
import java.util.Scanner;

import Product.Foods;
import Product.Milktea;
import Product.Tea;
import Station.Station;
import Station.Transaction;

public class Main {

	Scanner scan = new Scanner(System.in);
	Station station = new Station();
	ArrayList<Foods> foodList = new ArrayList<>();
	ArrayList<Transaction> transactionList = new ArrayList<>();
	
	public void Space() {
		for (int i=0;i<15;i++) {
			System.out.println(" ");
		}
	}
	
	public void Menu() {
		int choice = -1;
		
		do {
			System.out.println("Ngeteh Yuk!");
			System.out.println("================");
			System.out.println("1. Buy Tea");
			System.out.println("2. View Transaction");
			System.out.println("3. Delete Transaction");
			System.out.println("4. Exit");
			System.out.print(">>");
			
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				
			}
			scan.nextLine();
		} while (choice < 1 || choice > 4);
		
		switch(choice) {
		case 1:
			buyTea();
			break;
		case 2:
			viewTransaction();
			break;
		case 3:
			deleteTransaction();
			break;
		case 4:
			System.out.println("Thank you for using Ngeteh Yuk! Application!");
			System.exit(0);
		}
		
	}
	
	
	
	
	
	
	private void buyTea() { // test buying pakai ID
		ViewTeas();
		String teaID;
		int quantity = -1;
		String customername;
		
		do {
		//	System.out.print("Input the number of index you want to buy [1..10] : ");
			System.out.print("Input Drink ID : ");
			teaID = scan.nextLine();
		} while (teaID.length()<1);
		
		do {
			System.out.print("Input quantity [>0] : ");
			try {
				quantity = scan.nextInt();
			} catch (Exception e) {
				
			}
			scan.nextLine();
		} while (quantity < 1);
		
		do {
			System.out.print("Input your name [must be 2 words] : ");
			customername = scan.nextLine();
		} while (customername.length()<1);
		station.insertTransaction(station.generateID(), teaID, customername, quantity);
		System.out.println("Drink Purchased!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();
		
	}

	private void viewTransaction() {
		station.getTransaction(transactionList);
		if (transactionList.isEmpty()) {
			System.out.println("No Transaction...");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			Menu();
		}		

		for(Transaction transaction : transactionList) {
			transaction.PrintTransaction();
		}
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();
	}

	private void deleteTransaction() {
		station.getTransaction(transactionList);
		String idCheck = "";
		if (transactionList.isEmpty()) {
			System.out.println("No Transaction...");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			Menu();
		}
		do {
			System.out.println("Input Transaction ID to Delete : ");
			idCheck = scan.nextLine();
		} while (!validateID(idCheck));
		station.deleteTransaction(idCheck);
	}
	
	public void ViewTeas() {
		station.getMilks(foodList);
		
		System.out.println("| No  | Drink Name     | Drink Type  | Drink Price  | Sugar Type  | Milk Type    |");
		for(Foods tea : foodList) {
			if(tea instanceof Tea) {
				tea.Print();
			}
			if(tea instanceof Milktea) {
				tea.Print();
			}
		}
		System.out.println("===========================================================================================");
		
	}
	
	public boolean validateID(String ID) {
		for(Transaction transaction : transactionList)
		{
			if(transaction.getTransactionID().equals(ID)) {
				return true;
			}
		}
		
		
		return false;
		
	}
	
	public Main() {
		Space();
		Menu();
	}

	public static void main(String[] args) {
		new Main();

	}

}
