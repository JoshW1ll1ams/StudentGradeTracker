import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import javax.swing.JTextField;

public class Main { 
	
	static String lightGreen = "#E5FFDE"; 
	static String lightGray = "#BBCBCB"; 
	static String lightPurple = "#9590A8"; 
	static String darkRed = "#18020C";
	static String lightRed = "#f2686a";
	static LoginWindow loginWindow;
	static StudentPanel students;
	static MainFrame mainFrame;
	public static void main(String[] args)  

	{ 
		
		
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		int windowWidth = windowSize.width; 
		int windowHeight = windowSize.height; 
		
		mainFrame = new MainFrame(windowWidth, windowHeight);
		loginWindow = new LoginWindow(windowWidth, windowHeight);
		students = new StudentPanel(windowWidth, windowHeight);

		
		mainFrame.add(loginWindow);
		mainFrame.add(students);
		
		loginWindow.positionElements();

		mainFrame.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		    	try 
		    	{
		    		students.positionElements();
		    	}
		    	catch (Exception e1) {
		    	    System.out.println("Items not within frame");
		    	}
		    	try 
		    	{
		    		loginWindow.positionElements();
		    	}
		    	catch (Exception e1) {
		    	    System.out.println("Items not within frame");
		    	}
		    }
		});
	} 
} 