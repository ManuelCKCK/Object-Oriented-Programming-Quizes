package Quiz;

import java.util.Random;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Library library = new Library();
	
	public void space() {
		for (int i = 0; i<15;i++) {
			System.out.println(" ");
		}
	}
	
	public void Menu() {
		int choice = -1;
		
		do {
		System.out.println("Welcome to JuGlib");
		System.out.println("1. View Book");
		System.out.println("2. Add Book");
		System.out.println("3. Update Book");
		System.out.println("4. Exit");
		System.out.print("Choose [1 - 4] >>");
		try {
			choice = scan.nextInt();
		} catch (Exception e) {
			
		}
		scan.nextLine();
		}while(choice < 1 || choice > 4);
		
		switch (choice) {
		case 1:
			viewBook();
			break;
		case 2:
			addBook();
			break;
		case 3:
			updateBook();
			break;
		case 4:
			System.exit(0);
		}

		
	}
	
	
	private void viewBook() {
		library.viewBook();
		Menu();
		space();
	}

	private void addBook() {
		String name;
		int price = -1;
		String description;
		String libname;
		String bookID = " ";
		
		do {
			System.out.print("Input book name >>");
			name = scan.nextLine();
		} while (name.length()<1); //harus ada
		
		do {
			System.out.print("Input book price [ more than 20000] >>");
			try {
				price = scan.nextInt();
			} catch (Exception e) {
				
			}
			scan.nextLine();
		} while (price < 20001);
		
		do {
			System.out.print("Input book description [5..20 ] >>");
			description = scan.nextLine();
		} while (description.length()<5 || description.length()>20);
		
		do {
			System.out.print("Input library name [ EchLib | JustGoLib | XLib ] >>");
			libname = scan.nextLine();
		} while (!libname.equals("EchLib") &&
				!libname.equals("JustGoLib") &&
				!libname.equals("XLib"));
		
		bookID = ("BOOK" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10));
		
		library.bookList.add(new Book(name, price, description, libname, bookID));
		System.out.println("Successfully added new book! ");
		System.out.println("Press enter to continue");
		scan.nextLine();
		space();
		Menu();
		
	}

	private void updateBook() {
		library.updateBook();
		Menu();
	}

	public Main() {
		Menu();
	}

	public static void main(String[] args) {
		new Main();

	}

}
