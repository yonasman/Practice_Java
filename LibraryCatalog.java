import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
* This program implements a generic class to create 
* a library system, where users can add, remove, and 
* view library items.
*/

// Generic catalog class
class GenericCatalog<T> {
ArrayList<T> LibraryItems = new ArrayList<T>();

// Method to add library items	
public void addItem(T item) {
LibraryItems.add(item);
}

// Method to remove library items	
public T removeItem(T item) {
LibraryItems.remove(item);
return item;
}

// Method to display items
public void DisplayItems() {
for(T item: LibraryItems) {
System.out.println(item);
}
}
}

// Library item class
class LibraryItem {
// variables to store item info
private String title;
private String author;
private String itemID;

public LibraryItem(String title, String author, String itemID) {
this.title = title;
this.author = author;
this.itemID = itemID;
}

// Method to display item details
@Override
public String toString() {
return "Item Details -> Title: " + title + ", Author: " + author + ", Item ID: " + itemID;
}

// Override equals and hashCode for proper comparison
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
LibraryItem that = (LibraryItem) o;
return Objects.equals(title, that.title) && 
Objects.equals(author, that.author) && 
Objects.equals(itemID, that.itemID);
}

@Override
public int hashCode() {
return Objects.hash(title, author, itemID);
}
}

public class LibraryCatalog {
// generic catalog for creating catalogs
static GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();
public static void main(String[] args) {
// scanner object to take user input
Scanner scan = new Scanner(System.in);
// variables to store user input
String itemTitle;
String itemAuthor;
String itemId;

// choice variable for the loop
int choice = 0;
// welcome user
System.out.println("Hello, Welcome to our library system!");
do {
try {
System.out.println("Enter 1: to add an item, 2: to remove an item 3: to View the current catalog 4: to exit");

// Control user input
 while (!scan.hasNextInt()) {
 System.out.println("Invalid input. Please enter a number between 1 and 4.");
 scan.next(); // Consume the invalid input
 }
 choice = scan.nextInt();

 while (choice > 4 || choice < 1) {
 System.out.println("Please enter a correct number between 1 and 4.");
 while (!scan.hasNextInt()) {
 System.out.println("Invalid input. Please enter a number between 1 and 4.");
 scan.next(); // Consume the invalid input
 }
 choice = scan.nextInt();
 }
// consume new line character
scan.nextLine();

// Perform the specific operation
switch(choice) {
case 1:
try {
System.out.println("Please Enter the following information to add the item: ");
System.out.println("Item Title: ");
itemTitle = scan.nextLine();
System.out.println("Item Author: ");
itemAuthor = scan.nextLine();
System.out.println("Item ID: ");
itemId = scan.nextLine();
// initialize the item and catalog
LibraryItem item = new LibraryItem(itemTitle, itemAuthor, itemId);
// adding the item to the catalog
catalog.addItem(item);
} catch(Exception e) {
System.out.println(e.getMessage());
}
break;
case 2:
try {
System.out.println("Please Enter the following information to remove an item");
System.out.println("Item Title: ");
itemTitle = scan.nextLine();
System.out.println("Item Author: ");
itemAuthor = scan.nextLine();
System.out.println("Item ID: ");
itemId = scan.nextLine();
// initialize the item and catalog
LibraryItem itemToRemove = new LibraryItem(itemTitle, itemAuthor, itemId);
// remove the item from the catalog
if(!catalog.LibraryItems.contains(itemToRemove)) {
System.out.println("Item Not found in the catalog");
} else {
catalog.removeItem(itemToRemove);
System.out.println("Item removed successfully");
}
} catch(Exception e) {
System.out.println(e.getMessage());
}
break;
case 3:
try {
System.out.println("The items are: ");
catalog.DisplayItems();
} catch(Exception e) {
System.out.println(e.getMessage());
}
break;
case 4:
return;
}
} catch(Exception e) {
System.out.println(e.getMessage());
}
} while(choice != 4);
scan.close();
}
}
