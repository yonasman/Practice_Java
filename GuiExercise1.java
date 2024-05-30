import javax.swing.*;
import java.awt.*;

public class GuiExercise1 {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(400, 500);
		myFrame.setTitle("Chat Frame");
		
		//menu
		JMenuBar menuBar = new JMenuBar();
		JMenu m1 = new JMenu("FIle");
		JMenu m2 = new JMenu("Help");
		menuBar.add(m1);
		menuBar.add(m2);
		JMenuItem mi1 = new JMenuItem("Open");
		JMenuItem mi2 = new JMenuItem("Save as");
		
		// adding items to the menu
		m1.add(mi1);
		m1.add(mi2);
		
		// panel for the bottom content
		JPanel myPanel = new JPanel();
		JLabel textLabel = new JLabel("Enter Text");
		JTextField textArea = new JTextField(10);
		JButton b1 = new JButton("Send");
		JButton b2 = new JButton("Reset");
		myPanel.add(textLabel);
		myPanel.add(textArea);
		myPanel.add(b1);
		myPanel.add(b2);
		
		// text Area at the center
		JTextArea ta = new JTextArea();
		
		// setting the layout
		myFrame.getContentPane().add(BorderLayout.SOUTH, myPanel);
		myFrame.getContentPane().add(BorderLayout.CENTER, ta);
		myFrame.getContentPane().add(BorderLayout.NORTH, menuBar);
		myFrame.setVisible(true);
	}
}
