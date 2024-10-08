import java.util.Scanner;

//TEAM MEMBERS: NICK BILOTTO, CADEN C, DEVIN RIVAS

public class Main
{
	public static void main(String[] args)
	{
		int count = 10;
		CaffeinatedBeverage[] inventory = new CaffeinatedBeverage[count];
		Scanner keyboard = new Scanner(System.in);
		// Prompt user with options in a loop
		int choice, ounces, brewTemp, count = 0;
		String name;
		double price;

		do {
			System.out.println("1) Enter new Tea");
			System.out.println("2) Enter new Yerba Mate");
			System.out.println("3) Exit");
			System.out.print(">>");
			choice = keyboard.nextInt();
			keyboard.nextLine(); // Consume the newline character

			switch (choice) {
				case 1: // Tea
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					// Create a Tea, put into array
					inventory[count] = new Tea(name, ounces, price, brewTemp);

					System.out.println("Your tea order has been added: " + inventory[count]);
					count++;
					break;

				case 2: //Yerba Mate
					System.out.print("Enter name      : ");
					name = keyboard.nextLine();
					System.out.print("Enter ounces    : ");
					ounces = keyboard.nextInt();
					System.out.print("Enter price     $ ");
					price = keyboard.nextDouble();
					System.out.print("Enter brew temperature (in Celsius): ");
					brewTemp = keyboard.nextInt();

					//Create Yerba Mate, put into array
					inventory[count] = new YerbaMate(name, ounces, price, brewTemp, 0);

					System.out.println("Your Yerba Mate order has been added: " + inventory[count]);
					count++;
					break;

				case 3: // Exit
					System.out.println("Inventory:");
					for (int i = 0; i < count; i++) {
						System.out.println(inventory[i]);
					}
					findAveragePrice(inventory, count);
					findHighestPricedYerbaMate(inventory, count);
					break;

				default:
					System.out.println("Invalid Choice, please select again.");
					break;

			}

		} while (choice != 3);
	}
	
	public static double findAveragePrice(CaffeinatedBeverage[] inventory, int count) {
		if (count == 0) return 0.0; // Prevent division by zero
	
		double sum = 0.0;
		for (int i = 0; i < count; i++) {
			sum += inventory[i].getPrice(); // Sum up the prices of all beverages
		}
	
		return sum / count; // Return the average price
	}
	
	public static YerbaMate findHighestPricedYerbaMate(CaffeinatedBeverage[] inventory, int count) {
		YerbaMate highest = null;

		for (int i = 0; i < count; i++) {
			if (inventory[i] instanceof YerbaMate) {
				YerbaMate current = (YerbaMate) inventory[i];

				if (highest == null || current.getPrice() > highest.getPrice()) {
					highest = current;
				}
			}
		}
		return highest;
	}
}