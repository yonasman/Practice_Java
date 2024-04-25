import java.util.*;
/**
 *The first class to calculate the avarage of numbers
 *
 *
 **/
public class Avg {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5}; //declaring an array
		int sum = 0; //variable for storing the sum
		for(int i = 0;i < nums.length;i++) {
			sum += nums[i];
		}
		int avg = sum / nums.length; //average of the numbers
		System.out.println(avg); //printing the result
		//taking user input and calculate the average
		double a,b,sum2 = 0,avg2 = 0; //variables
        	Scanner scan = new Scanner(System.in); //initialize the scanner object
        	System.out.println("Enter the first number: ");
        	a = scan.nextDouble(); //accepting the first number
        	System.out.println("Enter the second number: ");
        	b = scan.nextDouble(); //accepting second number
        	sum2 = a + b;
        	avg2 = sum2 / 2;
        	System.out.println("Your average is " + avg2);
		}
}
