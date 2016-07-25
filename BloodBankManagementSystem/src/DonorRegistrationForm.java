import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DonorRegistrationForm extends JFrame{
	
	private static JFrame jFrame;
	private static JPanel jPanel;
	private JLabel mobileNumberLabel, nameLabel, bloodGroupLabel, sexLabel, addressLabel, emailLabel, alternativeMobileNumberLabel;
	private JTextField mobileNumberTextField, nameTextField, bloodGroupTextField, sexTextField, addressTextField, emailTextField, alternativeMobileNumberTextField;
	private JButton submitB;
	private static String titleText = "BBMS";
	
	public DonorRegistrationForm(){
		super(titleText);
		/*
		jFrame = new JFrame("Test");
		jFrame.setVisible(true);
		jFrame.setSize(500, 200);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		
		jPanel = new JPanel();
		jPanel.setBackground(Color.WHITE);
		jPanel.setLayout(null);
		
		mobileNumberLabel = new JLabel("Donor Mobile Number:");
		mobileNumberLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		mobileNumberLabel.setBounds(20, 50, 250, 20);
		nameLabel = new JLabel("Donor Full Name:");
		nameLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		nameLabel.setBounds(20, 80, 250, 20);
		bloodGroupLabel = new JLabel("Donor Blood Group:");
		bloodGroupLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		bloodGroupLabel.setBounds(20, 110, 250, 20);
		sexLabel = new JLabel("Donor Sex:");
		sexLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		sexLabel.setBounds(20, 140, 250, 20);
		addressLabel = new JLabel("Donor Address:");
		addressLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		addressLabel.setBounds(20, 170, 250, 20);
		emailLabel = new JLabel("Donor Email:");
		emailLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		emailLabel.setBounds(20, 200, 250, 20);
		alternativeMobileNumberLabel = new JLabel("Donor Alternative Mobile Number:");
		alternativeMobileNumberLabel.setFont(new Font("Cambri", Font.PLAIN, 16));
		alternativeMobileNumberLabel.setBounds(20, 230, 250, 20);
		
		mobileNumberTextField = new JTextField(30);
		mobileNumberTextField.setBounds(300, 50, 250, 20);
		nameTextField = new JTextField(30);
		nameTextField.setBounds(300, 80, 250, 20);
		bloodGroupTextField = new JTextField(30);
		bloodGroupTextField.setBounds(300, 110, 250, 20);
		sexTextField = new JTextField(30);
		sexTextField.setBounds(300, 140, 250, 20);
		addressTextField = new JTextField(30);
		addressTextField.setBounds(300, 170, 250, 20);
		emailTextField = new JTextField(30);
		emailTextField.setBounds(300, 200, 250, 20);
		alternativeMobileNumberTextField = new JTextField(30);
		alternativeMobileNumberTextField.setBounds(300, 230, 250, 20);
		
		submitB = new JButton("Submit");
		submitB.setBounds(450, 270, 100, 20);
		
		jPanel.add(mobileNumberLabel);
		jPanel.add(nameLabel);
		jPanel.add(bloodGroupLabel);
		jPanel.add(sexLabel);
		jPanel.add(addressLabel);
		jPanel.add(emailLabel);
		jPanel.add(alternativeMobileNumberLabel);
		
		jPanel.add(mobileNumberTextField);
		jPanel.add(nameTextField);
		jPanel.add(bloodGroupTextField);
		jPanel.add(sexTextField);
		jPanel.add(addressTextField);
		jPanel.add(emailTextField);
		jPanel.add(alternativeMobileNumberTextField);
		
		jPanel.add(submitB);
		
		add(jPanel);
	}

}
