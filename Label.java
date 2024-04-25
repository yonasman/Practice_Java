/**
 *  This program is designed to pratice
 *  labeled break in java
 */
public class Label {
	public static void main(String[] args) {
		int i,j; //variables for initializing the loop
		i = 0;
		outer: while(i < 5) {
	       		j = 0;
	 		while(j < 5) {
				if(i == 2 && j == 2) {
					break outer;
				}
				System.out.println(i);
				j++;
			}
			i++;
		}
	}
}	
