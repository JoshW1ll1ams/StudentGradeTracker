import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame(int windowWidth, int windowHeight)
	{
		this.setSize(windowWidth-200,windowHeight-100);
		this.setMinimumSize(new Dimension(900, 1000));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setBackground(Color.decode(Main.lightGreen)); 
		this.setResizable(true); 
		this.setVisible(true);
	}
}
