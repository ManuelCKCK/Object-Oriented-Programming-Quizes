package Quizfinal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	int global = -1;
	int wallet = 300;
	int wallettemp = 0;
	int wallettotal = wallet - wallettemp;
	int oreglobal = 0;
	int fishglobal = 0;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Worker> workerlist = new ArrayList<>();
	Worker miner = new Miner(null, null, null, 0);
	Worker fisher = new Fisher(null, null, null, 0);
			

	public void Space() {
		for (int i = 0; i < 15; i++) {
			System.out.println(" ");
		}
	}

	public void Menu() {
		int choice = -1;

		System.out.println("Welcome to JobGame");
		System.out.println("1. View worker");
		System.out.println("2. Order worker");
		System.out.println("3. Hire worker");
		System.out.println("4. Fire worker");
		System.out.println("5. Sell Item");
		System.out.println("6. Exit");
		System.out.print("Choose [1 - 6] >>");

		do {
			try {
				choice = scan.nextInt();
			} catch (Exception e) {

			}
		} while (choice < 1 || choice > 6);

		scan.nextLine();

		switch (choice) {
		case 1:
			ViewWorker();
			Menu();
			break;
		case 2:
			OrderWorker();
			break;
		case 3:
			HireWorker();
			break;
		case 4:
			FireWorker();
			break;
		case 5:
			SellItem();
			break;
		case 6:
			System.exit(0);
		}

	}

	private void ViewWorker() {
		if (workerlist.isEmpty()) {
			System.out.println("There is no worker!");
			System.out.println("Press enter to continue");
			scan.nextLine();
			Menu();
		} else {
			System.out.println("List of Worker :");
			System.out.println("===========================");
			System.out.println("|| " + "Worker Id" + "||" + "Worker name" + "||" + "Worker Job ||");
			for (Worker worker : workerlist) {

				System.out.println("|| " + worker.getID() + "||" + worker.getName() + "||" + worker.getJob() + "||");

			}
			System.out.println("==============================");
			System.out.println("Press enter to continue");
			scan.nextLine();
			
		}

	}

	private void OrderWorker() {
		if (workerlist.isEmpty()) {
			System.out.println("There is no worker!");
			System.out.println("Press enter to continue");
			scan.nextLine();
			Menu();
		} else {
			
			System.out.println("Status :");
			System.out.println("=====================");
			System.out.println("Your Money : $" + (wallettotal));
			System.out.println("Miner      : " );
			System.out.println("Fisher     : "  );
			System.out.println("Ore        : " + oreglobal);
			System.out.println("Fish       : " + fishglobal);
			System.out.println("=====================");
			int choice1 = -1;
			do {
				System.out.println("1. Order Miner ( cost : $75 )");
				System.out.println("2. Order Fisher ( cost : $50 )");
				System.out.println("3. Exit");
				try {
					choice1 = scan.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				scan.nextLine();
			} while (choice1 < 1 || choice1 > 3);
			switch (choice1) {
			case 1:
				OrderMiner();
				break;
			case 2:
				OrderFisher();
				break;
			case 3:
				Menu();
			}
		}

	}

	private void OrderMiner() {
		int moneytemp = wallet;
		int modal = 0;
		int temp1 = 0;
		int ore = 0;
		String comp = " ";
		for (Worker miner : workerlist) {
			comp = miner.getJob();
			if (!comp.equals("Miner")) {
				System.out.println("You dont have any Miner.");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				Menu();
			} else
				if(wallettotal < modal) {
					System.out.println("You dont have enough money");
					System.out.println("Press enter to continue...");
					scan.nextLine();
					Menu();
				}
				else
					modal = 75 * temp1;
				for (int i = 0; i < workerlist.size(); i++) {
					do {
						temp1++;
					} while (!comp.equals("Miner"));
				}
			
			global = modal + 0;
			ore = (rand.nextInt(4) * temp1);
			System.out.println("Every Miner got " + ore + "ore(s)");
			oreglobal = oreglobal + ore;
			wallettemp = wallet - modal;
			System.out.println("Press enter to continue...");
			scan.nextLine();
			Menu();

		}

	}

	private void OrderFisher() {
		int moneytemp = wallet;
		int modal = 0;
		int temp2 = 0;
		int fish = 0;
		String comp = " ";
		for (Worker fisher : workerlist) {
			comp = fisher.getJob();
			if (!comp.equals("Fisher")) {
				System.out.println("You dont have any Fisher.");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				Menu();
			} else
				modal = 50 * temp2;
			if(wallettotal < modal) {
				System.out.println("You dont have enough money");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				Menu();
			}
			else
				for (int i = 0; i < workerlist.size(); i++) {
					do {
						temp2++;
					} while (!comp.equals("Fisher"));
				}
			
			global = modal + 0;
			fish = (rand.nextInt(4) * temp2);
			System.out.println("Every Fisher got " + fish + "fish(es)");
			fishglobal = fishglobal + fish;
			wallettemp = wallet-modal;
			System.out.println("Press enter to continue...");
			scan.nextLine();
			Menu();

		}

	}

	private void HireWorker() {
		String name;
		String job;
		String iD;
		do {
			System.out.print("Input worker name [3..15] >>");
			name = scan.nextLine();
		} while (name.length() < 3 || name.length() > 15);

		do {
			System.out.print("Input worker job [ Miner | Fisher ](case sensitive) >>");
			job = scan.nextLine();
		} while (!job.equals("Miner") && !job.equals("Fisher"));
		iD = ("EP" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10));
		workerlist.add(new Worker(name, job, iD));
		System.out.println("Successfully hired worker!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		Menu();
	}

	private void FireWorker() {
		if (workerlist.isEmpty()) {
			System.out.println("There is no worker!");
			System.out.println("Press enter to continue");
			scan.nextLine();
			Menu();
		}
		else {
			ViewWorker();
			
			String iD = " ";
			
				System.out.println("Input worker ID >>");
				iD = scan.nextLine();
			
				for(int i =0;i<workerlist.size();i++) {
					if (iD.equals(workerlist.get(i).getID())) {
						workerlist.remove(i);
						System.out.println("Worker has been fired");
						System.out.println("Press enter to continue...");
						scan.nextLine();
						Menu();
					}
					else {
						System.out.println("Theres no ID");
						Menu();
					}
				}
				
		}

	}

	private void SellItem() {
		// TODO Auto-generated method stub

	}

	public Main() {
		Menu();
	}

	public static void main(String[] args) {
		new Main();

	}

}
