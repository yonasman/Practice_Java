/**
 * This function calculates the value of the
 * investment for the given number of years
 * The function takes the initial value, the
 * number of years to calculate the investment
 *  and the interest rate are inputted by the user
 * */
//
import textio.TextIO;

public class Interests {
	public static void main(String[] args) {
		double principal; //a variable for storing the initial value from user
		double rate; //a variable for storing the rate from user
		int years; //to store the number of years
		
		//taking the initial investment from user
		System.out.println("Please enter the initial investment: ");
		principal = TextIO.getinDouble();
		//taking the interest rate from user
		System.out.println("Please enter the interest rate: ");
		rate = TextIO.getinDouble();
		//taking the years from the user
		System.out.println("Please enter the number of years to calculate the investment: ");
		years = TextIO.getinInt();
		
		double sum = 0; //a variable to store the total investment all over the given years
		int i = 0; //a variable to iterate through the loop till the number of years
		while(i < years) {
			double interest;
			interest = principal * rate;
			principal += interest;
			System.out.println(principal);
			sum += principal;
			i += 1;
		}
		System.out.println(sum);
	}
}
