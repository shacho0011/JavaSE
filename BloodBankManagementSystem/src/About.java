import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JPanel{
	
	private JPanel jPanel;
	private JLabel img;
	private JButton submitB;
	
	public JPanel About(){
	    jPanel = new JPanel();
		img = new JLabel();
		img.setIcon(new ImageIcon("C:\\Users\\Shadhin\\workspace\\BloodBankManagementSystem\\image\\about.jpg"));
	    
		submitB = new JButton("Submit");
		submitB.setBounds(450, 450, 100, 20);
		
		jPanel.add(img);
		jPanel.add(submitB);
		return jPanel;
	}
	

}
