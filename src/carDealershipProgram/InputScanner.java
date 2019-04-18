package carDealershipProgram;
import java.util.Scanner;

public class InputScanner {
	
	private static Scanner scanner = new Scanner(System.in);

	public static Integer getInteger(String message) {
	    Integer integerValue = null;
	    String line = null;
	    while (line == null) {
	      System.out.println(message);
	      line = scanner.nextLine();
	      try {
	    	line = line.trim();
	        integerValue = Integer.valueOf(line);
	        break;
	      } catch (NumberFormatException e) {
	        System.out.println("Numeric value expected, not: '" + line + "', try again.");
	        line = null;
	      }
	    }
	    return integerValue;
	  }
	
	
	
	public static Float getFloat(String message) {
		Float floatValue = null;
		String line = null;
		while(line == null) {
			System.out.println(message);
			line = scanner.nextLine();
			try {
				floatValue = Float.parseFloat(line);
				break;
			}catch(NumberFormatException NFE) {
				System.out.println("Numeric value expected, not '" + line + "', try again.");
				line = null;
			}
		}
		return floatValue;
	}	
	
	public static Double getDouble(String message) {
		Double doubleValue = null;
		String line = null;
		while(line == null) {
			System.out.println(message);
			line = scanner.nextLine();
			try {
				doubleValue = Double.parseDouble(line);
				break;
			}catch(NumberFormatException NFE) {
				System.out.println("Numeric value expected, not '" + line + "', try again.");
				line = null;
			}
		}
		return doubleValue;
	}	
	
	public static Long getLong(String message) {
		Long longValue = null;
		String line = null;
		while(line == null) {
			System.out.println(message);
			line = scanner.nextLine();
			try {
				longValue = Long.parseLong(line);
				break;
			}catch(NumberFormatException NFE) {
				System.out.println("Numeric value expected, not '" + line + "', try again.");
				line = null;
			}
		}
		return longValue;
	}
	
	public static String getString(String message) {
		String stringValue = null;
		String line = null;
		while(line == null) {
			System.out.println(message);
			line = scanner.nextLine();
			try {
				stringValue = String.valueOf(line);
				break;
			}catch(Exception e) {
				System.out.println("Bad input : Try again");
				line = null;
			}
		}
		return stringValue;
	}
	
	public static void main(String args[]) {
		InputScanner test = new InputScanner();
		test.getDouble("Insert double");
	}
	
}
