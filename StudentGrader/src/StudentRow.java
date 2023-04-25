import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StudentRow extends JPanel{
	
	static Label informationLabel;
	static Button removeButton;

	 
	public StudentRow(int windowWidth, String studentName, String studentScore, String user)
	{
	
		this.setBackground(Color.decode(Main.lightGray)); 
		this.setLayout(null);
		final int studentScoreInt = Integer.parseInt(studentScore);
		EmptyBorder paddingLabel = new EmptyBorder(0, 40, 0, 10);
		LocalTime currentTime = LocalTime.now();
		String time = currentTime.toString().substring(0, 5);
		
		String studentScoreFinal = "";
		if(Integer.parseInt(studentScore) < 72)
		{
			studentScoreFinal = "\\/ "+studentScore + "%";
		}
		if(Integer.parseInt(studentScore) == 72)
		{
			studentScoreFinal = "= "+studentScore + "%";
		}
		if(Integer.parseInt(studentScore) > 72)
		{
			studentScoreFinal = "/\\ "+studentScore + "%";
		}
		
		String information = "Student Name:  "+studentName+"    Score:  "+studentScoreFinal+"    Added by: "+user + " at "+time;
		informationLabel = new Label(information,16);
		informationLabel.setBorder(paddingLabel);
		
		removeButton = new Button("Remove",Main.lightPurple);
		this.add(informationLabel);
		this.add(removeButton);
		
  		Dimension windowDimention = Main.mainFrame.getSize();
		int frameWidth = windowDimention.width; 
		
		Dimension labelSize = informationLabel.getPreferredSize();
		
		informationLabel.setBounds(((frameWidth/2)+270)-labelSize.width,5,labelSize.width,30);
		removeButton.setBounds((frameWidth/2)+270,5,100,30);
		
		StudentPanel.totalStudents +=1;
		
		final StudentRow currentRow = this;
		removeButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	StudentPanel.removeRows(StudentPanel.students,currentRow);
            	StudentPanel.drawRows(StudentPanel.students);
            	StudentPanel.totalStudents -=1;
            	StudentPanel.totalScore -= studentScoreInt;
            	StudentPanel.updateStudentNum();
            }
        });
		
	
		
		StudentPanel.rowContainer.add(this);
		
	}
	public StudentRow returnParent(Component comp)
	{
		Component temp = comp.getParent();
		
		return (StudentRow) comp.getParent();
	}

}
