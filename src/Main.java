
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Shoe> ALShoe = new ArrayList<>();
		int menu = 0;
		while(true) {
			System.out.println("Shoe Shop");
			System.out.println("=========");
			System.out.println("1. View Shoes");
			System.out.println("2. Add Shoes");
			System.out.println("3. Delete Shoes");
			System.out.println("4. Exit");
			System.out.print("Choice >> ");
			menu = scan.nextInt();
			scan.nextLine();
			if(menu == 1) {
				if(ALShoe.isEmpty()) {
					System.out.println("No Shoes Available..");
				} else {
					int count = 1;
					for (Iterator iterator = ALShoe.iterator(); iterator.hasNext();) {
						Shoe shoe = (Shoe) iterator.next();
						System.out.println(count++ + "  "+ shoe.name + "-" + shoe.IDShoe);
						System.out.println("========================");
						System.out.println("Category : " + shoe.category);
						System.out.println("Release date : " + shoe.releaseDate);
						System.out.println("Price : " + shoe.price);
						System.out.println();
					}
				}
				System.out.println("Press enter to continue..");
				scan.nextLine();
			} else if(menu == 2) {
				String shoeName, shoeCategory, shoeDate;
				int shoePrice;
				do {
					System.out.print("Input shoe's name[name ends with shoe, example: \"Fire shoe\"]: ");
					shoeName = scan.nextLine();
				} while(!shoeName.endsWith("shoe"));
				do {
					System.out.print("Input shoe's category[Sneaker | Running | Boot] (case sensitive): ");
					shoeCategory = scan.nextLine();
				} while(!shoeCategory.equals("Sneaker") && !shoeCategory.equals("Running") && !shoeCategory.equals("Boot"));
				do {
					System.out.print("Input shoe's release date[dd-mm-yyyy]: ");
					shoeDate = scan.nextLine();
				} while(!isDateValid(shoeDate));
				do {
					System.out.print("Input shoe's price[more than or equals to 5000]: ");
					shoePrice = scan.nextInt();
				} while(shoePrice < 5000);
				scan.nextLine();
				Random rand = new Random();
				ALShoe.add(new Shoe("SH" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10), shoeName, shoeCategory, shoeDate, shoePrice));
				System.out.println("Shoe Added!");
				System.out.println("Press enter to continue..");
				scan.nextLine();
			} else if(menu == 3) {
				if(ALShoe.isEmpty()) {
					System.out.println("No Shoes Available..");
					System.out.println("Press enter to continue..");
					scan.nextLine();
				} else {
					int count = 1, num;
					for (Iterator iterator = ALShoe.iterator(); iterator.hasNext();) {
						Shoe shoe = (Shoe) iterator.next();
						System.out.println(count++ + "  "+ shoe.name + "-" + shoe.IDShoe);
						System.out.println("========================");
						System.out.println("Category : " + shoe.category);
						System.out.println("Release date : " + shoe.releaseDate);
						System.out.println("Price : " + shoe.price);
						System.out.println();
					}
					do {
						System.out.print("Choose shoe's number to delete[1.."+ ALShoe.size() +"]: ");
						num = scan.nextInt();
						scan.nextLine();
					} while(num < 1 || num > ALShoe.size());
					ALShoe.remove(num-1);
					System.out.println("Shoe Removed!");
				}
			} else if(menu == 4) {
				System.out.println("Thank you for using this application!");
				break;
			}
		}
		scan.close();
	}
	
	public static boolean isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	        df.setLenient(false);
	        df.parse(date);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}

}
