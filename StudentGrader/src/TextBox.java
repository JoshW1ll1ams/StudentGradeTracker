import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextBox extends JTextField {
    
    public TextBox(String type) {
        // Call the constructor of the superclass
        super();
        
        // Add a document listener to check for changes in the text input field
        this.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                textChanged();
            }

            public void removeUpdate(DocumentEvent e) {
                textChanged();
            }

            public void changedUpdate(DocumentEvent e) {
                textChanged();
            }

            private void textChanged() 
            {
            	if(type == "nameEnter")
            	{
                    if (getText().matches("[a-zA-Z]+") && getText().length() <= 10 && getText().length() >= 3) 
                    {
                        setForeground(Color.black);
                        LoginWindow.loginValid = true;
                    } 
                    else 
                    {
                        setForeground(Color.red);
                        LoginWindow.loginValid = false;
                    }
            	}
            	if(type == "studentName")
            	{
                    if (getText().matches("[a-zA-Z]+") && getText().length() <= 10 && getText().length() >= 3) 
                    {
                        setForeground(Color.black);
                        StudentPanel.nameValid = true;
                    } 
                    else 
                    {
                        setForeground(Color.red);
                        StudentPanel.nameValid = false;
                    }
            	}
            	if(type == "studentScore")
            	{
                    if (getText().matches("[0-9]+") && getText().length() <= 3 && getText().length() >= 1 && Integer.parseInt(getText()) <= 100) 
                    {
                        setForeground(Color.black);
                        StudentPanel.scoreValid = true;
                    } 
                    else 
                    {
                        setForeground(Color.red);
                        StudentPanel.scoreValid = false;
                    }
            	}
            }
        });
    }
	public static int BoxCenter(TextBox box) 
	{
		Dimension boxSize = box.getSize();
		int boxWidth = boxSize.width; 
		return boxWidth;
	}
	
}
