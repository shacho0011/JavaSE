import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main extends JFrame{
	public static void main(String args[]){
		Menu menu = new Menu();
		
		menu.setVisible(true);
		menu.setSize(800,600);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		DonorRegistrationForm donor = new DonorRegistrationForm();
		donor.setVisible(true);
		donor.setSize(800,600);
		donor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
}
