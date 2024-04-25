/**
 *  This program is used to print a 12 by 12
 *  multiplication table
 */
public class MultTable {
	public static void main(String[] args) {
		int i, j; // variable for initializing the loops
		for(i = 1;i <= 12;i++) {
		       for(j = 1;j <= 12;j++) {
			System.out.printf("%4d",i * j);
		       }
		       System.out.println();
		}
	}
}
