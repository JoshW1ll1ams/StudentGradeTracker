import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton {
	static String type;
	public Button(String text, String color)
	{
		this.type = type;
		this.setVisible(true);
		this.setText(text);
		// Remove button border
		this.setBorderPainted(false);
		// Remove button text border
		this.setFocusPainted(false); 
		this.setBackground(Color.decode(color)); 
	}
}
