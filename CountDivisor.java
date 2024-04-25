import java.util.Scanner;
/**
 * This program counts the number of divisors
 * of a number entered by the user
 */
public class CountDivisor {
	public static void main(String[] args) {
	int counter = 0; // a variable for counting the number of divisors
	int i; // and initializing the loop
	int number; // a variable for storing the user input
	Scanner scan = new Scanner(System.in); //declare scanner object
	System.out.println("Please enter any number greater than zero to count it's number of divisors"); // prompting the user
	number = scan.nextInt(); //accepting user input
	// use for loop to count the number of divisors
	for(i = 1; i <= number;i++) {
		if(number % i == 0) {
			counter++;
		}
	}
	System.out.println("The number of divisor for the number you have entered is: " + counter);
	}
}
