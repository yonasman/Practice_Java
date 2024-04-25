import java.util.Scanner; //importing a scanner object to accept user input
/**
 * This program is a library system which
 * is used to borrow or return or add books
 * to the library
 */
// a class that represents a book
class Book {
	private String author;
    	private String title;
    	private int quantity;
    	//constructor function
    	public Book(String author, String title, int quantity) {
        this.author = author;
        this.title = title;
        this.quantity = quantity;
    }
    // Getters and setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // Method to update quantity
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
    public void decreaseQuantity(int quantity) {
    	this.quantity -= quantity;
    }

}
public class LibrarySystem {
	public static void main(String[] args) {
			int cont;
			int bookCount =	0; // a variable for storing the total number of books
			Book[] library = new Book[100];	// an array for storing books
			Scanner scan = new Scanner(System.in); //initializing scanner object
			do {
			try {
			int action; //variable to accept user input
			System.out.println("Welcome to our library system!"); //welcoming user
			//prompting user to choose the action
			System.out.println("What do you want to do? Enter 1 for Add, 2 for Return, 3 for Borrow: "); 
			do {
				//check whether the number is integer
				while(!scan.hasNextInt()) {
					System.out.println("Please enter a valid number: ");
					scan.next(); //execute the next line
				}
				action = scan.nextInt(); //accepting user input
				scan.nextLine(); //consume the newline left	over
				if(!(action == 1 || action == 2 || action == 3)) {
					//prompting the user to enter the correct number
					System.out.println("Please enter the correct number (1,2, or 3): ");
				}
				//adding a book
				if(action == 1) {
					System.out.println("You are going to add a book. Please give me the book's Author, Title, and Quantity");
					System.out.println("Author's Fullname");
					String	bookAuthor = scan.nextLine(); //accepting Authors name
					System.out.println("Book's Title");
					String	bookTitle = scan.nextLine(); //accepting book's title
					System.out.println("Quantity of the book");
					int	quantity = scan.nextInt(); //accepting quantity
					boolean bookExists = false; //flag for checking if the book exist
						// loop to get the book and update
						for(int i = 0; i < bookCount; i++) {
							if(library[i].getTitle().equals(bookTitle)){
								// updating the quantity of the book
								library[i].increaseQuantity(quantity);
								bookCount += quantity;
								System.out.println("Successfully added!");
								bookExists = true;
								break;
							}
						}
						//add to library if the book doesn't exist
						if(!bookExists) {
							// Create a new Book instance and add it to the library array
		                    library[bookCount] = new Book(bookAuthor, bookTitle, quantity);
		                    bookCount += quantity; // Increment the book count
		                    System.out.println("Successfully added!");
						}
				} else if(action == 2) { //returning a book
					System.out.println("You are going to return	a book. Please give me the book's Author, Title, and Quantity");
					System.out.println("Author's Fullname");
					String	bookAuthor = scan.nextLine(); //accepting Authors name
					System.out.println("Book's Title");
					String	bookTitle = scan.nextLine(); //accepting book's title
					System.out.println("Quantity of the book");
					int	quantity = scan.nextInt(); //accepting quantity
					boolean bookExists = false; //
					for(int i = 0;i < bookCount;i++) {
						if(library[i].getTitle().equals(bookTitle) && library[i].getAuthor().equals(bookAuthor)) {
							library[i].increaseQuantity(quantity);
							System.out.println("Succesfully returned!");
							bookCount += quantity;
							bookExists = true;
							break;
						}
					}
					if(!bookExists) {  //if book is not in the list of books(library system)
		                 System.out.println("Sorry The book deosn't belong to the Library"); 
					}
				} else if(action == 3) { // borrowing a book
					System.out.println("You are going to borrow	a book. Please give me the book's Author, Title, and Quantity");
					System.out.println("Author's Fullname");
					String	bookAuthor = scan.nextLine(); //accepting Authors name
					System.out.println("Book's Title");
					String	bookTitle = scan.nextLine(); //accepting book's title
					System.out.println("Quantity of the book");
					int	quantity = scan.nextInt(); //accepting quantity
					
					boolean bookExists  = false;
					for(int i = 0;i < bookCount; i++) {
					if(library[i].getTitle().equals(bookTitle))	{
							library[i].decreaseQuantity(quantity);
							System.out.println("Successfully borrowed!");
							bookCount -= quantity;
							bookExists = true;
							break;
						}
					}
					if(!bookExists) {
						System.out.println("Sorry The book doesn't exist in the library"); 
					}
					
				}
			} while(!(action == 1 || action == 2 || action == 3));
		} catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("Do you want to continue	enter 1 for yes 2 for no: ");
		cont = scan.nextInt();
		if(cont == 2) {
			System.out.println("Thanks for working with us!");
		}
		} while(cont == 1);
	}
}

