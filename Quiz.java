import java.util.Scanner;  //import scanner object
/**
 * This program asks users five multiple questions and
 * finally displays the result
 **/

public class Quiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name;
		do {
			System.out.println("What is your name? ");
			name = scanner.nextLine();
			//checking the validity of the name
			if(name.matches("[a-zA-Z ]+")) {
				System.out.println(name +" welcome \uD83D\uDC4B"+" for today's quiz");
				int score = QuizConductor(scanner);
				int averageScore = score * 20;
				System.out.println("you scored " + averageScore+"% Thanks for your time!");
				break; //stop the loop if the name is valid
			} else {
				System.out.println("Please enter characters only");
			}
		} while(true);
		scanner.close();
	}

	private static int QuizConductor(Scanner scanner) {
		//questions
		String[] questions = {
			"What is the result of 2 + 2? A, 6 B, 8 C, 10 D, 4",
	            	"What is the result of 4 * 4? A, 18 B, 16 C, 24 D, 4",
	            	"What is the result of 16 / 4? A, 22 B, 8 C, 4 D, 6",
	            	"What is the result of 5 % 4? A, 3 B, 2 C, 1 D, 4",
	            	"What is the result of 2 ** 2? A, 6 B, 4 C, 8 D, 2"
			};
		String[] answers = {"D","B","C","C","B"};  //answers
		int score = 0; // a variable for storing the total answers scored by the user
		for(int i = 0; i < questions.length;i++) {
			System.out.println(questions[i]);
			String answer = scanner.nextLine();
			if(isValidAnswer(answer)) {
				if(answer.equalsIgnoreCase(answers[i])) {
				score += 1;
				}
			} else {
				System.out.println("Please insert the correct letters:");
				i--;
			}

		}
		return score;
	}
	// a class for checking the validty of the answer
	private static boolean isValidAnswer(String answer) {
		String upperCaseAnswer = answer.toUpperCase();
		return upperCaseAnswer.equals("A") || 
		           upperCaseAnswer.equals("B") || 
		           upperCaseAnswer.equals("C") || 
		           upperCaseAnswer.equals("D");
	}
}
