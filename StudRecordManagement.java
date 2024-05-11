import java.util.Scanner;
/**
 * This program is used to manage student info 
 * which is used to add new student, update
 * the info of student or view detail info
 * about a student
 */
// A class that represents a student
class Student {
    private String name;
    private String id;
    private int age;
    private int grade;

    // Constructor function
    public Student(String name, String id, int age, int grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Method to display student info
    public void displayInfo() {
    	System.out.println("The student you're looking for is: ");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

public class StudRecordManagement {
    static Scanner scan = new Scanner(System.in);
    static Student[] studentList = new Student[200];
    static int studentCount = 0;

    // Method to add a new student
    public static void addStudent() {
        try {
        	System.out.println("Enter name:");
        	String name = scan.nextLine();
        	System.out.println("Enter ID:");
        	String id = scan.nextLine();
        	System.out.println("Enter age:");
        	int age = scan.nextInt();
        	scan.nextLine(); // Consumes the newline after age
        	System.out.println("Enter grade:");
        	int grade = scan.nextInt();
        	
            Student newStudent = new Student(name, id, age, grade);
            studentList[studentCount] = newStudent;
            studentCount++;
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to display student info
    public static void displayStudent() {
        try {
            System.out.println("Enter student ID:");
            String searchId = scan.next();
            boolean found = false;
            for (int i = 0; i < studentCount; i++) {
                if (studentList[i].getId().equals(searchId)) {
                    studentList[i].displayInfo();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to update student info
    public static void updateStudent() {
        try {
            System.out.println("Enter student ID:");
            String searchId = scan.next();
            scan.nextLine();
            boolean found = false;
            for (int i = 0;i < studentCount; i++) {
                if (studentList[i].getId().equals(searchId)) {
                    System.out.println("Enter new name:");
                    String newName = scan.nextLine();
                    studentList[i].setName(newName);
                    System.out.println("Enter new age:");
                    int newAge = scan.nextInt();
                    scan.nextLine();
                    studentList[i].setAge(newAge);
                    System.out.println("Enter new grade:");
                    int newGrade = scan.nextInt();
                    studentList[i].setGrade(newGrade);
                    System.out.println("Student info updated successfully!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        int choice;
        do {
            try {
                System.out.println("Menu:");
                System.out.println("1. Add new student");
                System.out.println("2. Display student info");
                System.out.println("3. Update student info");
                System.out.println("4. Exit");
                System.out.println("Enter your choice:");
                choice = scan.nextInt();
                scan.nextLine(); //consume the next line
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayStudent();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scan.next(); // Clear the buffer
                choice = 0; // Reset choice to force the loop to repeat
            }
        } while (choice != 4);
    }
}
