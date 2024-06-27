/**
 * This program analyzes text input from the user, providing various text analysis functionalities.
 * It calculates character and word counts, identifies the most common character, and allows the user
 * to check the frequency of specific characters and words in the text. Additionally, it computes the 
 * number of unique words in the text.
 * 
 */
import java.util.HashMap;
import java.util.Scanner;
public class TextAnalzer {
		static Scanner scan = new Scanner(System.in);
		
		// method to get the user input		
		public static String getUserText() {
			String userText = null;
			try {
				System.out.println("Welcome to our text analyzer.");
				System.out.println("Please enter your Text.");
				userText = scan.nextLine().trim();
				while(userText.isEmpty()) {
					System.out.println("Input can't be empty");
					userText = scan.nextLine().trim();
				}
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
				}
			return userText;
		}
		
		// method to convert the text to words 		
		public static String[] textToWord(String userText) {
			String[] words = null;
			try {
				words = userText.toLowerCase().split("\\s+");	
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return words;
		}
		
		// method to get the most common character
		public static char mostCommonChar(String userText) {
			HashMap<Character, Integer> charCountMap = charMap(userText);  
			//	getting the maximum character in the text
			char maxChar = ' ';
			try {
				int maxCharCount = 0;
				for(char c: charCountMap.keySet()) {
					if(charCountMap.get(c) > maxCharCount) {
						maxCharCount = charCountMap.get(c);
						 maxChar = c;
					}
					
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			return maxChar;
		}
		
		//	method to get each char count
		public static HashMap<Character, Integer> charMap(String userText) {
			HashMap<Character, Integer> charCountMap = new HashMap<>();
			try {
				userText = userText.toLowerCase();
				for(char c:userText.toCharArray()) {
					//	check if the character is already in the map
					if(c == ' ') {
						continue;
					} else if(charCountMap.containsKey(c)) {
						charCountMap.put(c, charCountMap.get(c) + 1);
					} else {
						charCountMap.put(c, 1);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return charCountMap;
		}
		
		// method to get character frequency
		public static String charFrequency(String userText) {
			System.out.println("Enter the character that you want its count: ");
			HashMap<Character, Integer> charCountMap = charMap(userText);
			String userChar =  scan.nextLine().toLowerCase().trim();
			try {
				
				while(userChar.isEmpty()) {
					System.out.println("Input can't be empty");
					userChar =  scan.nextLine().toLowerCase().trim();
					
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			char c = userChar.charAt(0);

			if(charCountMap.containsKey(c)) {
				return userChar + " appears " + charCountMap.get(c) + " times.";
			} else {
				return userChar + " doesn't exist in the text.";
			}
		}
		
		// method to get word count
		public static HashMap<String, Integer> wordCountMap(String userText) {
				// counting the number of words			
				HashMap<String, Integer> wordCountMap = new HashMap<>();
				String[] wordsList = textToWord(userText);
				try {
					for(String word: wordsList) {
						if(wordCountMap.containsKey(word)) {
							wordCountMap.put(word, wordCountMap.get(word) + 1);
							} else {
								wordCountMap.put(word, 1);
							}
						}
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				return wordCountMap;
		}
		// method to get word frequency
		public static String wordFrequency(String userText) {
			HashMap<String, Integer> wordCountMap = wordCountMap(userText);
			// getting user word			
			System.out.println("Enter the word that you want its frequency: ");
			String userWord = scan.nextLine().toLowerCase().trim();
			try {
				
				while(userWord.isEmpty()) {
					System.out.println("Input can't be empty");
					userWord = scan.nextLine().toLowerCase().trim();
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			if(wordCountMap.containsKey(userWord)) {
				return userWord + " appears " + wordCountMap.get(userWord) + " times.";
			} else {
				return userWord + " doesn't exist in the text.";
			}
			
		}
		
		// method to get unique words
		public static int uniqueWords(String userText) {
			HashMap<String, Integer> wordCountMap = wordCountMap(userText);
			int uniqueWordCount = 0;
			try {
				for(String word: wordCountMap.keySet()) {
					if(wordCountMap.get(word) == 1) {
						uniqueWordCount++;
					}
				}
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return uniqueWordCount;
		}
		public static void main(String[] args) {
			
			//getting user input	
			String userText = getUserText();
			
			// getting characters count
			System.out.println("The Number of characters in your text is " + userText.length()+ ".");
			System.out.println();
			// getting word count		
			String[] wordsList = textToWord(userText);
			System.out.println("The number of words in your text is " + wordsList.length + ".");	
			System.out.println();
			// getting the most common character
			char mostCommonChar = mostCommonChar(userText);
			System.out.println("The most common character is " + mostCommonChar + ".");
			System.out.println();
			// get the frequency of char
			String charFrequency = charFrequency(userText);
			System.out.println(charFrequency);
			System.out.println();
			// get the word frequency
			String wordFreq = wordFrequency(userText);
			System.out.println(wordFreq);
			
			// get unique words count
			int uniqueWordsCount = uniqueWords(userText);
			System.out.println("The number of unique words in your text is " + uniqueWordsCount + ".");
			System.out.println("Thanks for using our text analyzer.");
		}
}
