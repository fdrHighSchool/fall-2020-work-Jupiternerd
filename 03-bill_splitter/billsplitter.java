import java.util.*;

class Main {
  public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Bill-Splitter");
		System.out.print("Enter the total, pre-tax: ");

		double total = input.nextInt();
    	System.out.print("Enter the percent for tax (without % sign): ");

    	double tax = input.nextInt();
      double taxForTotal = total * (tax / 100);

		System.out.print("How many people? ");

		int numPeople = input.nextInt();
		double perPerson = (total + taxForTotal)/ numPeople;
System.out.printf("Each person must pay $ %.2f, (Tip Included)", perPerson);
}//end of method
}//end of class
