
import java.util.Scanner;

public class Demo {
    private static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
		System.out.println();
		System.out.println();
		System.out.println("Welcome to the CoinFlips Demo!");

		fixedDemo();
		interactiveDemo();
	
		System.out.println();
		System.out.println();
		System.out.println("Thanks for watching the CoinFlips Demo.");
		System.out.println("Have a wonderful day!");
		System.out.println();
    }

    private static void fixedDemo() {
		System.out.println();
		System.out.println();
		System.out.println("Making a Coin()");
		System.out.println("Result:" + new Coin());
		System.out.println("Making a Penny()");
		System.out.println("Result:" + new Penny());
		System.out.println("Making a Nickel()");
		System.out.println("Result:" + new Nickel());
		System.out.println("Making a Dime()");
		System.out.println("Result:" + new Dime());
		System.out.println("Making a Coin()");
		System.out.println("Result:" + new Quarter());
		System.out.println("Making a Half Dollar()");
		System.out.println("Result:" + new HalfDollar());
		System.out.println("Making a Dollar()");
		System.out.println("Result:" + new Dollar());
		System.out.println("Making a Coin(1.00, 1991)");
		System.out.println("Result:" + new Coin(1.00,1991));
		System.out.println("Making a Coin(99.99)");
		System.out.println("Result:" + new Coin(99.99));
    }

    private static void printMenu() {
		System.out.println();
		System.out.println();
		System.out.println("I'm ready to make you a coin!");
		System.out.println("Enter G for a dollar coin.");
		System.out.println("Enter H for a half dollar coin.");
		System.out.println("Enter Q for a quarter  coin.");
		System.out.println("Enter D for a dime  coin.");
		System.out.println("Enter N for a nickel coin.");
		System.out.println("Enter P for a penny coin.");
		System.out.println();
		System.out.println("Enter X to exit the demo.");
		System.out.println();
    }

    private static void interactiveDemo() {
		System.out.println();
		System.out.println();
		System.out.println("Would you like to make more coins yourself? (Y/n) ");
		String response = keyboard.nextLine();
		response = response.trim();
		if (response.charAt(0) == 'Y' || response.charAt(0) == 'y') runDemo();
    }	

    private static void runDemo() {
		Coin c;
		while (true) {
	    	System.out.println();
	    	System.out.println();

	    	printMenu();
	    	System.out.print("What coin to make? ");
	    	String response = keyboard.nextLine();
	    	response = response.trim();
	    	switch (response.charAt(0)) {
	        	case 'G':
		    		System.out.println("Gonna make a dollar coin...");
		    		c = new Dollar();
		    		break;
	        	case 'H':
		    		System.out.println("Gonna make a half dollar coin...");
		    		c = new HalfDollar();
		    		break;
	        	case 'Q':
		    		System.out.println("Gonna make a quarter coin...");
		    		c = new Quarter();
		    		break;
	        	case 'D':
		    		System.out.println("Gonna make a dime coin...");
		    		c = new Dime();
		    		break;
	        	case 'N':
					System.out.println("Gonna make a nickel coin...");
		    		c = new Nickel();
		    		break;
	        	case 'P':
		    		System.out.println("Gonna make a penny coin...");
		    		c = new Penny();
		    		break;
	        	case 'X':
		    		c = new Coin();
		    		return;
	        	default:
		    		System.out.println("Invalid entry, try again.");
		    		break;
	    	}
		}
    }
}
