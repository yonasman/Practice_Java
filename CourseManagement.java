import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program is about course management system
 * which is used to add course, assign grade to
 * students, and calculating the overall score.
 */
class Student {
    private String name;
    private int id;
    private Course[] enrolledCoursesList = new Course[20];
    private double[] grades = new double[20];
    private int numOfCourses = 0;
    private int gradesAssigned = 0;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public double[] getGrades() {
        return grades;
    }

    public void addCourseToStudent(Course course) {
        if (numOfCourses < 20) {
            enrolledCoursesList[numOfCourses++] = course;
            Course.totalEnrolledStudents++;
            System.out.println("Successfully enrolled " + this.getName() + " to " + course.getCourseName() + " course.");
        } else {
            System.out.println("Course limit reached for the student.");
        }
    }

    public void assignGrade(Course course, double grade) {
        for (int i = 0; i < numOfCourses; i++) {
            if (enrolledCoursesList[i].getCourseCode().equals(course.getCourseCode())) {
                grades[gradesAssigned++] = grade;
                System.out.println("Successfully assigned a grade of " + grade + " for " + course.getCourseName() + " course.");
                return;
            }
        }
        System.out.println("Student not enrolled in the course.");
    }
}

class Course {
    private String courseName;
    private String courseCode;
    private int maxCapacity;
    static int totalEnrolledStudents = 0;

    public Course(String courseName, String courseCode, int maxCapacity) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.maxCapacity = maxCapacity;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseCode() {
        return this.courseCode;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}

public class CourseManagement {
    private static Course[] courses = new Course[100];
    private static ArrayList<Student> students = new ArrayList<>();
    private static int coursesAdded = 0;

    public static void addCourse(String courseName, String courseCode, int maxCapacity) {
        Course newCourse = new Course(courseName, courseCode, maxCapacity);
        courses[coursesAdded++] = newCourse;
        System.out.println("Course added successfully!");
    }

    public static void enrollStudent(Student student, Course course) {
        student.addCourseToStudent(course);
    }

    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    public static double calculateOverallScore(Student student) {
        double[] grades = student.getGrades();
        double totalGrade = 0;
        int numGrades = 0;

        for (double grade : grades) {
            if (grade != 0) {
                totalGrade += grade;
                numGrades++;
            }
        }

        return numGrades > 0 ? totalGrade / numGrades : 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        try {
            do {
                System.out.println("Welcome to the Course Enrollment and Grade Management System!");
                System.out.println("Enter 1 to Add course, 2 to Enroll student, 3 to Assign grade, 4 to Calculate overall score, 5 to Exit: ");
                choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Course Name: ");
                        String courseName = scan.nextLine();
                        System.out.println("Course Code: ");
                        String courseCode = scan.nextLine();
                        System.out.println("Maximum Capacity: ");
                        int maxCapacity = scan.nextInt();
                        scan.nextLine();
                        addCourse(courseName, courseCode, maxCapacity);
                        break;
                    case 2:
                        System.out.println("Student Name: ");
                        String stdName = scan.nextLine();
                        System.out.println("Student ID: ");
                        int stdId = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Course Code: ");
                        String enrollCourseCode = scan.nextLine();
                        Course enrollCourse = null;
                        for (Course c : courses) {
                            if (c != null && c.getCourseCode().equals(enrollCourseCode)) {
                                enrollCourse = c;
                                break;
                            }
                        }
                        if (enrollCourse != null) {
                            Student student = null;
                            for (Student s : students) {
                                if (s != null && s.getId() == stdId) {
                                    student = s;
                                    break;
                                }
                            }
                            if (student == null) {
                                student = new Student(stdName, stdId);
                                students.add(student);
                            }
                            enrollStudent(student, enrollCourse);
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Student Name: ");
                        stdName = scan.nextLine();
                        System.out.println("Student ID: ");
                        stdId = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Course Code: ");
                        String gradeCourseCode = scan.nextLine();
                        System.out.println("Grade: ");
                        double grade = scan.nextDouble();
                        scan.nextLine();
                        Course gradeCourse = null;
                        for (Course c : courses) {
                            if (c != null && c.getCourseCode().equals(gradeCourseCode)) {
                                gradeCourse = c;
                                break;
                            }
                        }
                        if (gradeCourse != null) {
                            Student student = null;
                            for (Student s : students) {
                                if (s != null && s.getId() == stdId) {
                                    student = s;
                                    break;
                                }
                            }
                            if (student != null) {
                                assignGrade(student, gradeCourse, grade);
                            } else {
                                System.out.println("Student not found.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Student Name: ");
                        stdName = scan.nextLine();
                        System.out.println("Student ID: ");
                        stdId = scan.nextInt();
                        scan.nextLine();
                        Student student = null;
                        for (Student s : students) {
                            if (s != null && s.getId() == stdId) {
                                student = s;
                                break;
                            }
                        }
                        if (student != null) {
                            double overallScore = calculateOverallScore(student);
                            System.out.println("Overall Score: " + overallScore);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }

            } while (choice != 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        scan.close();
    }
}
