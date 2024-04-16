/**
 * This function is used to solve the 3N + 1 problem
 * if the given number is even, we divide by two
 * if the number is odd, then we multiply it by three
 * and add one util the number is 1.
 **/
public class ThreeN1 {
	public static void main(String[] args) {
		int n = 5;
		//looping till n = 1
		while (n != 1) {
			if(n % 2 == 0) {
				n = n / 2;
				System.out.println(n);
			} else {
				n = n * 3 + 1;
				System.out.println(n);
			}
		}

	}
}
