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
		System.out.println("Making a Penny() with a different metallurgy");
		Coin penny = new Penny();
		System.out.println("Result:" + new Coin(penny.getValue(), penny.getYear(), penny.getCommonName(), penny.getFrontImage(), penny.getBackImage(), penny.getValueDescription(), penny.hasRidgedEdge(), new CuproNickel()) {});
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
		TotalCoins totalCoins = new TotalCoins(Coin.getCoinCounts());
		Thread tcThread = new Thread(totalCoins);
	    tcThread.start();
		QuarterCounter quarterCounter = new QuarterCounter(Coin.getCoinCounts());
		Thread qThread = new Thread(quarterCounter);
		qThread.start();

		Coin c;
		while (true) {
	    	System.out.println();
	    	System.out.println();

	    	printMenu();
	    	System.out.print("What coin to make? ");
	    	String response = keyboard.nextLine();
	    	response = response.trim();
			if (response.length() == 0) {
				response = " ";
			}
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
					totalCoins.setVisible(false);
					totalCoins.dispose();
					quarterCounter.setVisible(false);
					quarterCounter.dispose();
		    		return;
	        	default:
		    		System.out.println("Invalid entry, try again.");
		    		break;
	    	}
		}
    }
}
