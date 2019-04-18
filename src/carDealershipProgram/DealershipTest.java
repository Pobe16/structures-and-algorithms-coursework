/*
 *  B00331251 FRASER FEWSTER
 *  B00329768 MIKOLAJ LUKASIK
 * 
 * */
package carDealershipProgram;


public class DealershipTest {
	public static void main(String[] args) {
		Dealership dealer = new Dealership();
		Tree carTree = dealer.masterTree;
		Tree manufacturerTree = dealer.manufacturerTree;
		boolean RUNNING = true;
		String exitVerification;
		String tempString;
		while(RUNNING) {
//			Get user input
			int input = InputScanner.getInteger("Menu\n"
					+ "0 : Exit\n"
					+ "1 : Add new manufacturer\n"
					+ "2 : Remove manufacturer \n"
					+ "3 : Check if manufacturer exists in records \n"
					+ "4 : Display all listed manufacturers \n"
					+ "5 : Add new car \n"
					+ "6 : Remove car for post sale \n"
					+ "7 : Display the number of cars available for a specific make and model \n"
					+ "8 : Display ALL vehicles listed for sale \n"
					+ "Enter Choice\t:\t");
//			Handle input via menu
			switch(input) {
			case 0 :
				exitVerification = InputScanner.getString("Are you sure you want to quit?\nY or y to quit");
				RUNNING = exitVerification.equals("y") || exitVerification.equals("Y") ? false : true;
				break;
				
			case 1:
//				ADD NEW MANUFACTURER
				tempString = InputScanner.getString("Enter Manufacturer Name \t:\t");
				if (manufacturerTree.contains(tempString)) {
					System.out.println("There is already a " + tempString + " on the list.");					
				} else {
					Manufacturer temp = new Manufacturer(tempString);
					manufacturerTree.insertNode(temp);
					System.out.println("Manufacturer " + tempString + " added to records");
					tempString = null;
					manufacturerTree = manufacturerTree.balance();
				}
				break;
				
			case 2:
//				REMOVE MANFUACTURER
				tempString = InputScanner.getString("Enter the name of the manufacturer you wish to remove").toLowerCase();
				Manufacturer removeItem = new Manufacturer(tempString);
				tempString = (manufacturerTree.removeNode(removeItem) == true)
						? "Item removed successfully" 
						: "Item not found";
				System.out.println(tempString); 
				tempString = null;
				manufacturerTree = manufacturerTree.balance();
				break;
				
			case 3:
//				FIND PARTICULAR MANUFACTURER
				tempString = InputScanner.getString("Enter Manufacturer Name :\t");
				System.out.println("Searching for " + tempString);
				boolean containsResult = manufacturerTree.contains(tempString);
				String answer = (containsResult == true)
						? "Records for " + tempString + " found." 
						: "Manufacturer '" + tempString + "' Not Found";
				System.out.println(answer);
				break;
				
			case 4:
//				DISPLAY ALL LISTED MANUFACTURERS
				if(manufacturerTree.getRoot() == null) {
					System.out.println("No Manufacturers Found");
				}else{
					System.out.println("Manufacturs List : ");
					manufacturerTree.inOrderTraversal();
				}
				break;
				
			case 5:
//				ADD NEW CAR
				boolean operationSuccess = false;
				String makeName = InputScanner.getString("Enter Manufacturer Name \t:\t");
				boolean makeExist = manufacturerTree.contains(makeName);
				if (makeExist) {
					String registrationNumber = InputScanner.getString("Enter registration number :\t");
					boolean registrationNumberExist = carTree.containsInRegistration(registrationNumber);
					if (!registrationNumberExist) {
						String model = InputScanner.getString("Enter car model :\t");
						String colour = InputScanner.getString("Enter car color :\t");
						Car manuallyEnteredCar = new Car(makeName, registrationNumber, model, colour);
						carTree.insertNode(manuallyEnteredCar);
						operationSuccess = true;
					} else {
						System.out.println("Registration number " + registrationNumber + " is already on our list.");
					}
				} else {
					System.out.println("Make " + makeName + " does not exist on our list.");
				}
				
				if (operationSuccess) {
					System.out.println("New car added to the list.");
					carTree = carTree.balance();
				} else {
					System.out.println("Some of car data were wrong. Please try again.");
				}
				break;
				
			case 6:
//				REMOVE CAR FOR POST SALE
				String registrationNumber = InputScanner.getString("Enter the registration number of car you have just sold\t:\t").toLowerCase();
				boolean registrationNumberExist = carTree.containsInRegistration(registrationNumber);
				if (registrationNumberExist) {
					Car tempCar = new Car("no data", registrationNumber, "no data", "no data");
					tempString = (carTree.removeNode(tempCar)) ? "Car removed successfuly" : "Something went wrong";
					System.out.println(tempString);
					tempString = null;
					carTree = carTree.balance();
//					boolean carRemovalSuccess = carTree.removeNode(tempCar);
//					System.out.println(carRemovalSuccess);
					
				} else {
					System.out.println("There is no car with registration number " + registrationNumber + " in the dealership.");					
				}
				break;
				
			case 7:
//				DISPLAY NUMBER OF VEHICLES FOR A SPECIFIED MAKE AND MODEL
				String make = InputScanner.getString("Enter car make / manufacturer name");
				String model = InputScanner.getString("Enter the model of the car");
				Car tempCar = new Car(make, "no data", model, "no data");
				Integer numberFound = carTree.findNumberOf(tempCar);
				tempString = (numberFound == 0) 
						? "Sorry no cars matching those criteria were found"
						: "Number of available cars matching criteria : " + numberFound.toString();
				System.out.println(tempString);
				break;
				
			case 8:
//				DISPLAY ALL VEHICLES LISTED FOR SALE
				if(carTree.getRoot() == null) {
					System.out.println("No Cars Found");
				}else{
					System.out.println("Cars List : ");
					carTree.inOrderTraversal();
				}
				break;
				
//			case 9:
////				LOADS TEST DATA
//				/*	TEST DATA 1
//				 * 	Adds 6 manufacturers to the dealers manufacturerTree
//				 * */
//				Manufacturer man1 = new Manufacturer("Honda");
//				Manufacturer man2 = new Manufacturer("Alpha Romeo");
//				Manufacturer man3 = new Manufacturer("Subaru");
//				Manufacturer man4 = new Manufacturer("Nissan");
//				Manufacturer man5 = new Manufacturer("Tesla");
//				Manufacturer man6 = new Manufacturer("Bugatti");
//				manufacturerTree.insertNode(man1);
//				manufacturerTree.insertNode(man2);
//				manufacturerTree.insertNode(man3);
//				manufacturerTree.insertNode(man4);
//				manufacturerTree.insertNode(man5);
//				manufacturerTree.insertNode(man6);
//				manufacturerTree = manufacturerTree.balance();
//
//
//				/*	TEST DATA 2
//				 * 	Adds 6 cars to the dealers masterTree
//				 * */
//				Car testCar = new Car("Honda", "L332 KSF","Civic", "Blue");
//				Car testCar2 = new Car("Alpha Romeo", "L119 EPG", "Giulia", "Yellow");
//				Car testCar3 = new Car("Subaru", "L890 FAO", "Impreza", "Red");
//				Car testCar4 = new Car("Nissan", "L019 CCM", "Skyline", "Aqua");
//				Car testCar5 = new Car("Tesla", "B113 CDO", "Model S", "Green");
//				Car testCar6 = new Car("Bugatti", "L200 AMD", "Veyron", "Orange");
//				Car testCar7 = new Car("Alpha Romeo", "L119 EPH", "Giulia", "Red");
//				Car testCar8 = new Car("Bugatti", "L200 AMS", "Veyron", "Black");
//				Car testCar9 = new Car("Subaru", "L890 FGG", "Impreza", "Racing");
//				Car testCar10 = new Car("Tesla", "B114 CDO", "Model S", "Silver");
//				Car testCar11 = new Car("Tesla", "B115 CD2", "Model S", "Brown");
//				Car testCar12 = new Car("Tesla", "B115 CD1", "Model S", "Blue");
//				Car testCar13 = new Car("Tesla", "B115 CD4", "Model S", "White");
//				Car testCar14 = new Car("Tesla", "B115 CD5", "Model S", "Green");
//				Car testCar15 = new Car("Tesla", "B115 CD6", "Model S", "Aqua");
//				Car testCar16 = new Car("Tesla", "B115 CD7", "Model S", "White");
//
//				carTree.insertNode(testCar);
//				carTree.insertNode(testCar2);
//				carTree.insertNode(testCar3);
//				carTree.insertNode(testCar4);
//				carTree.insertNode(testCar5);
//				carTree.insertNode(testCar6);
//				carTree.insertNode(testCar7);
//				carTree.insertNode(testCar8);
//				carTree.insertNode(testCar9);
//				carTree.insertNode(testCar10);
//				carTree.insertNode(testCar11);
//				carTree.insertNode(testCar12);
//				carTree.insertNode(testCar13);
//				carTree.insertNode(testCar14);
//				carTree.insertNode(testCar15);
//				carTree.insertNode(testCar16);
//
//				carTree = carTree.balance();
////				testCar = testCar2 = testCar3 = testCar4 = null;
//				System.out.println("Test Data Added Successfully");
//				break;
			default:
				System.out.println("Invalid Input");
			} //End switch
		} //End while(RUNNING)
	} //End Main
} //End Class DealershipTest
