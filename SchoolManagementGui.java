import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Define the Student class to store student information
class Student {
    private String name;
    private int age;
    private String id;
    private List<String> enrolledCourses; // List to store enrolled courses

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getId() { return id; }
    public List<String> getEnrolledCourses() { return enrolledCourses; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setId(String id) { this.id = id; }

    public void enrollCourse(String course) {
        enrolledCourses.add(course);
    }
}

public class SchoolManagementGui implements ActionListener {
    // Components
    private JFrame frame;
    private JLabel label;
    private JLabel label2;
    private JPanel panel;
    private JButton addButton;
    private JButton updateButton;
    private JButton viewButton;
    private JButton enrollButton;
    private JButton assignGradeButton;

    // List to store student information
    private List<Student> students;

    // Constructor
    public SchoolManagementGui() {
        // Initialize the list of students
        students = new ArrayList<>();

        // Create the main frame
        frame = new JFrame("School Management System");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Initialize components
        label = new JLabel("Welcome to our School Management System!", SwingConstants.CENTER);
        label2 = new JLabel("Hello Admin, What would you like to do?", SwingConstants.CENTER);
        panel = new JPanel();
        addButton = new JButton("Add a Student");
        updateButton = new JButton("Update Student Info");
        viewButton = new JButton("View Student Details");
        enrollButton = new JButton("Enroll Student in Course");
        assignGradeButton = new JButton("Assign Grade");

        // Set fonts and borders
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the labels
        label2.setFont(new Font("Arial", Font.BOLD, 26)); // Reduce label2 font size
        label2.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10)); // Add padding around label2
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Add padding around the panel

        // Customize buttons
        customizeButton(addButton);
        customizeButton(updateButton);
        customizeButton(viewButton);
        customizeButton(enrollButton);
        customizeButton(assignGradeButton);

        // Add action listeners to buttons
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        viewButton.addActionListener(this);
        enrollButton.addActionListener(this);
        assignGradeButton.addActionListener(this);

        // Add components to the panel
        panel.add(label);
        panel.add(label2);
        panel.add(Box.createVerticalStrut(20)); // Add vertical space before buttons
        panel.add(addButton);
        panel.add(Box.createVerticalStrut(15)); // Add vertical space between buttons
        panel.add(updateButton);
        panel.add(Box.createVerticalStrut(15)); // Add vertical space between buttons
        panel.add(viewButton);
        panel.add(Box.createVerticalStrut(15)); // Add vertical space between buttons
        panel.add(enrollButton);
        panel.add(Box.createVerticalStrut(15)); // Add vertical space between buttons
        panel.add(assignGradeButton);

        // Center align all components in the panel
        for (Component component : panel.getComponents()) {
            ((JComponent) component).setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        // Add panel to frame
        frame.add(panel, BorderLayout.CENTER);
        // Make the frame visible
        frame.setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            showAddStudentDialog();
        } else if (e.getSource() == updateButton) {
            showUpdateStudentDialog();
        } else if (e.getSource() == viewButton) {
            showViewStudentDialog();
        } else if (e.getSource() == enrollButton) {
            showEnrollStudentDialog();
        } else if (e.getSource() == assignGradeButton) {
            showAssignGradeDialog();
        }
    }

    // Display a dialog to add a new student
    private void showAddStudentDialog() {
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField idField = new JTextField();

        Object[] message = {
            "Name:", nameField,
            "Age:", ageField,
            "ID:", idField
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Add a Student", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String id = idField.getText();
                students.add(new Student(name, age, id));
                JOptionPane.showMessageDialog(frame, "Student added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Display a dialog to update student information
    private void showUpdateStudentDialog() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No students to update.");
            return;
        }

        String[] studentNames = students.stream().map(Student::getName).toArray(String[]::new);
        JComboBox<String> studentList = new JComboBox<>(studentNames);

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField idField = new JTextField();

        studentList.addActionListener(e -> {
            Student selectedStudent = students.get(studentList.getSelectedIndex());
            nameField.setText(selectedStudent.getName());
            ageField.setText(String.valueOf(selectedStudent.getAge()));
            idField.setText(selectedStudent.getId());
        });

        Object[] message = {
            "Select Student:", studentList,
            "Name:", nameField,
            "Age:", ageField,
            "ID:", idField
       
        };

        int option = JOptionPane.showConfirmDialog(frame, message, "Update Student Info", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                Student selectedStudent = students.get(studentList.getSelectedIndex());
                selectedStudent.setName(nameField.getText());
                selectedStudent.setAge(Integer.parseInt(ageField.getText()));
                selectedStudent.setId(idField.getText());
                JOptionPane.showMessageDialog(frame, "Student updated successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid age. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Display a dialog to view student details
    private void showViewStudentDialog() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No students to view.");
            return;
        }

        StringBuilder studentDetails = new StringBuilder();
        for (Student student : students) {
            studentDetails.append("Name: ").append(student.getName()).append("\n")
                    .append("Age: ").append(student.getAge()).append("\n")
                    .append("ID: ").append(student.getId()).append("\n")
                    .append("Enrolled Courses: ").append(student.getEnrolledCourses()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(studentDetails.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(frame, scrollPane, "View Student Details", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showEnrollStudentDialog() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No students to enroll.");
            return;
        }

        // a list of courses
        String[] courses = {"Mathematics", "Physics", "Chemistry", "Biology", "Python", "Java", "JavaScript"};

        // Create drop downs for student selection and course selection
        String[] studentNames = students.stream().map(Student::getName).toArray(String[]::new);
        JComboBox<String> studentList = new JComboBox<>(studentNames);
        JComboBox<String> courseList = new JComboBox<>(courses);

        // Create a panel to hold the drop downs
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Select Student:"));
        panel.add(studentList);
        panel.add(new JLabel("Select Course:"));
        panel.add(courseList);

        // Display the enrollment dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Enroll Student in Course", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String studentName = studentList.getItemAt(studentList.getSelectedIndex());
            String course = courseList.getItemAt(courseList.getSelectedIndex());

            // Find the student object by name
            Student student = students.stream().filter(s -> s.getName().equals(studentName)).findFirst().orElse(null);
            if (student != null) {
                // Check if the student is already enrolled in the selected course
                if (student.getEnrolledCourses().contains(course)) {
                    JOptionPane.showMessageDialog(frame, studentName + " is already enrolled in " + course);
                } else {
                    // Enroll the student in the course
                    student.enrollCourse(course);
                    JOptionPane.showMessageDialog(frame, "Enrolled student " + studentName + " in course " + course + " successfully!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Failed to find student.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Display a dialog to assign a grade to a student
    private void showAssignGradeDialog() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No students to assign grade.");
            return;
        }

        // Create drop downs for student selection and course selection
        String[] studentNames = students.stream().map(Student::getName).toArray(String[]::new);
        JComboBox<String> studentList = new JComboBox<>(studentNames);
        JTextField courseField = new JTextField();
        JTextField gradeField = new JTextField();

        // Create a panel to hold the drop downs and text fields
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Select Student:"));
        panel.add(studentList);
        panel.add(new JLabel("Course:"));
        panel.add(courseField);
        panel.add(new JLabel("Grade:"));
        panel.add(gradeField);

        // Display the assign grade dialog
        int result = JOptionPane.showConfirmDialog(null, panel, "Assign Grade", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String studentName = studentList.getItemAt(studentList.getSelectedIndex());
            String course = courseField.getText();
            String grade = gradeField.getText();
            assignGrade(studentName, course, grade);
        }
    }

    // Method to assign a grade to a student
    public void assignGrade(String studentName, String course, String grade) {
        // simply showing a confirmation message
        String message = "Grade assigned for " + course + " to student " + studentName + ": " + grade;
        JOptionPane.showMessageDialog(frame, message, "Grade Assigned", JOptionPane.INFORMATION_MESSAGE);
    }

    // Customize button appearance
    private void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(100, 149, 237)); // Corn flower blue background color
        button.setForeground(Color.WHITE); // White text color
        button.setFocusPainted(false); // Remove focus border
        button.setMaximumSize(new Dimension(500, 60)); // Set preferred size for consistent button dimensions
    }

    // Main method to launch the application
    public static void main(String[] args) {
        // Create an instance of SchoolManagementGui
        new SchoolManagementGui();
    }
}

