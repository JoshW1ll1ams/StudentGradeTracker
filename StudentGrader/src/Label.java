import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	
	public Label(String text, int fontSize) 
	{
		this.setText(text);
		this.setFont(new Font("Consolas", Font.BOLD, fontSize));
	}
}
