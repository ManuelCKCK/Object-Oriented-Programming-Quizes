package Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
	Scanner scan = new Scanner(System.in);
	ArrayList<Book> bookList = new ArrayList<>();

	public void getBook(String name, int price, String description, String libname, String bookID) {
		bookList.get(new Book(name, price, description, libname, bookID));
	}

	public void viewBook() {
		if (bookList.isEmpty()) {
			System.out.println("There is no book.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		} else {
			System.out.println("List of Book :");
			System.out.println(
					"==============================================================================================================================");
			System.out.println(
					"|| Library Name  || Book Id  || Book name          || Book Price    || Book Description       || Library Country ||");
			for (Book view : bookList) {

				if (view.getLibname().equals("EchLib")) {
					System.out.println("  " + view.getLibname() + "            " + view.getBookID() + "         "
							+ view.getName() + "      " + "Rp." + view.getPrice() + "      " + view.getDescription()
							+ "    Singapore");
				} else if (view.getLibname().equals("JustGoLib")) {
					System.out.println("  " + view.getLibname() + "            " + view.getBookID() + "         "
							+ view.getName() + "      " + "Rp." + view.getPrice() + "      " + view.getDescription()
							+ "    Indonesia");
				} else if (view.getLibname().equals("XLib")) {
					System.out.println("  " + view.getLibname() + "            " + view.getBookID() + "         "
							+ view.getName() + "      " + "Rp." + view.getPrice() + "      " + view.getDescription()
							+ "    Malaysia");
				}
			}
			System.out.println(
					"==============================================================================================================================");
			System.out.println("Press enter to continue");
			scan.nextLine();

		}
	}

	public void updateBook() {
		if (bookList.isEmpty()) {
			System.out.println("There is no book.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		} else {
			int choice = -1;
			String iDcheck = " ";

			System.out.print("Input Book Id [ e.g. BOOK 1234] >>");
			iDcheck = scan.nextLine();
			for (int i = 0; i < bookList.size(); i++) {
				Book up = bookList.get(i);
				if (iDcheck.equals(bookList.get(i).getBookID())) {
					do {
						System.out.println("Update :");
						System.out.println("1. Update book name");
						System.out.println("2. Update book price");
						System.out.println("3. Update book description");
						System.out.print("Choose [ 1 - 3] >>");

						try {
							choice = scan.nextInt();
						} catch (Exception e) {

						}
						scan.nextLine();
					} while (choice < 1 || choice > 3);
					if (choice == 1) {

						String upname;
						do {
							System.out.print("Input book name >>");
							upname = scan.nextLine();
						} while (upname.length() < 1);
						for (Book update : bookList) {
							update.setName(upname);
							System.out.println("Successfully changed book name!");
							System.out.println("Press enter to continue...");
							scan.nextLine();
							break;
						}
					} else if (choice == 2) {
						for (Book update : bookList) {
							int upprice = -1;
							do {
								System.out.print("Input book price [ more than 20000 ] >>");
								try {
									upprice = scan.nextInt();
								} catch (Exception e) {

								}
								scan.nextLine();
							} while (upprice < 20001);
							update.setPrice(upprice);
							System.out.println("Successfully changed book price!");
							System.out.println("Press enter to continue...");
							scan.nextLine();
							break;
						}
					} else if (choice == 3) {
						for (Book update : bookList) {
							String updesc;

							do {
								System.out.print("Input book description [ 5..20] >>");
								updesc = scan.nextLine();
							} while (updesc.length() < 5 && updesc.length() > 20);
							update.setDescription(updesc);
							System.out.println("Successfully changed book description!");
							System.out.println("Press enter to continue...");
							scan.nextLine();
							break;
						}
					}
				} else {
					System.out.println("Book Id not found!");
					System.out.println("Press enter to continue...");
					scan.nextLine();
				}
			}
		}
	}
}
