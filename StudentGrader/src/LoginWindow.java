import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow extends JPanel{ 

	static TextBox nameText;
	static Boolean loginValid = false;
	static Button confirmButton;
	static Button loginButton;
	static Label enterName;
	
	public LoginWindow(int windowWidth, int windowHeight) 
	{ 
		this.setSize(windowWidth,windowHeight);
		this.setBackground(Color.decode(Main.lightGreen)); 
		this.setLayout(null);  
		this.setVisible(true); 
		
		
		// Change tool tip settings and add colours background and foreground
				ToolTip.initialiseToolTip(Main.lightGreen,Main.darkRed);
				

				ArrayList<Component> components = new ArrayList<Component>();
	
				
				nameText = new TextBox("nameEnter")
				{
					public Point getToolTipLocation(MouseEvent e) 
					{
					    return new Point(BoxCenter(nameText)+10, 7);
					}
				};
				nameText.setToolTipText("Accept's characters A-Z (Max 15, Min 3)");
				nameText.setHorizontalAlignment(JTextField.CENTER);
				enterName = new Label("Please enter your name to continue:",17);
				
				
				// Create my button and pass in the type, the display text and the colour
				loginButton = new Button("Login",Main.lightGray);
				confirmButton = new Button("Confirm",Main.lightGray);
				confirmButton.setVisible(false);
				components.add(nameText);
				components.add(enterName);
				components.add(loginButton);
				components.add(confirmButton);


				addComponents(components);
				
				loginButton.addActionListener(new ActionListener() 
				{
		            public void actionPerformed(ActionEvent e) 
		            {
	            	   if(LoginWindow.loginValid == true)
	            	   {
	            		   LoginWindow.ShowConfirm();
	            	   }
		             }
		        });
				confirmButton.addActionListener(new ActionListener() 
				{
		            public void actionPerformed(ActionEvent e) 
		            {
		            	Main.loginWindow.setVisible(false);
		            	Main.students.setVisible(true);
		            	Main.students.positionElements();
		            }
		        });
	}
	private void addComponents(ArrayList<Component> components) {
		for(int i= 0; i < components.size(); i++)
		{		
			this.add(components.get(i));
		}
	} 
	
	public void positionElements()
	{
    	// Reset all of the dimensions before resizing any elements
		Dimension windowSize = Main.mainFrame.getSize();
		int windowWidth = windowSize.width; 
		int windowHeight = windowSize.height; 
		
		enterName.setBounds((windowWidth/2)-140,(windowHeight/3)-50,windowWidth,40);  
		nameText.setBounds((windowWidth/2)-((windowWidth/5)/2),(windowHeight/3),(windowWidth/5),30); 
		loginButton.setBounds((windowWidth/2)-125,(windowHeight/3)+50,250,30);
		confirmButton.setBounds((windowWidth/2)-200,(windowHeight/3)+50,400,30);

	}
	public static void ShowConfirm() {
		confirmButton.setVisible(true);
		confirmButton.setText("Welcome "+ LoginWindow.nameText.getText()+",  please click to login.");
		loginButton.setVisible(false);
		enterName.setVisible(false);
		nameText.setVisible(false);
	}
} 