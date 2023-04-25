import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class bottomPanel extends JPanel{
	public bottomPanel(Button exitButton, Button resetButton)
	{
		this.setBackground(Color.decode(Main.lightGray)); 
		this.setLayout(null);
		this.add(exitButton);
		this.add(resetButton);
		
		
		resetButton.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent e) 
	        {
	        	System.out.println("Restarting");
            	Main.loginWindow.setVisible(true);
            	Main.students.setVisible(false);
        		LoginWindow.loginButton.setVisible(true);
        		LoginWindow.enterName.setVisible(true);
        		LoginWindow.nameText.setVisible(true);
        		LoginWindow.confirmButton.setVisible(false);
	        }
	    });
		
		exitButton.addActionListener(new ActionListener() 
		{
	        public void actionPerformed(ActionEvent e) 
	        {
	        	System.out.println("Closing");
	        	System.exit(0);
	        }
	    });
	}
}
