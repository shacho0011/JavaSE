import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DonorRegistrationForm extends JPanel{
	
	private JLabel monileNL, nameL, bloodGL, sexL, addressL, emailL, alternativeMNL;
	private JTextField mobileNTF, nameTF, bloodGTF, sexTF, addressTF, emailTF, alternativeMNTF;
	private JButton submitB;
	private static String titleText = "BBMS";
	
	public DonorRegistrationForm(){
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		monileNL = new JLabel("Donor Mobile Number:");
		monileNL.setFont(new Font("Cambri", Font.PLAIN, 16));
		monileNL.setBounds(20, 50, 250, 20);
		nameL = new JLabel("Donor Full Name:");
		nameL.setFont(new Font("Cambri", Font.PLAIN, 16));
		nameL.setBounds(20, 80, 250, 20);
		bloodGL = new JLabel("Donor Blood Group:");
		bloodGL.setFont(new Font("Cambri", Font.PLAIN, 16));
		bloodGL.setBounds(20, 110, 250, 20);
		sexL = new JLabel("Donor Sex:");
		sexL.setFont(new Font("Cambri", Font.PLAIN, 16));
		sexL.setBounds(20, 140, 250, 20);
		addressL = new JLabel("Donor Address:");
		addressL.setFont(new Font("Cambri", Font.PLAIN, 16));
		addressL.setBounds(20, 170, 250, 20);
		emailL = new JLabel("Donor Email:");
		emailL.setFont(new Font("Cambri", Font.PLAIN, 16));
		emailL.setBounds(20, 200, 250, 20);
		alternativeMNL = new JLabel("Donor Alternative Mobile Number:");
		alternativeMNL.setFont(new Font("Cambri", Font.PLAIN, 16));
		alternativeMNL.setBounds(20, 230, 250, 20);
		
		mobileNTF = new JTextField(30);
		mobileNTF.setBounds(300, 50, 250, 20);
		nameTF = new JTextField(30);
		nameTF.setBounds(300, 80, 250, 20);
		bloodGTF = new JTextField(30);
		bloodGTF.setBounds(300, 110, 250, 20);
		sexTF = new JTextField(30);
		sexTF.setBounds(300, 140, 250, 20);
		addressTF = new JTextField(30);
		addressTF.setBounds(300, 170, 250, 20);
		emailTF = new JTextField(30);
		emailTF.setBounds(300, 200, 250, 20);
		alternativeMNTF = new JTextField(30);
		alternativeMNTF.setBounds(300, 230, 250, 20);
		
		submitB = new JButton("Submit");
		submitB.setBounds(450, 270, 100, 20);
		
		class donorSubmitB implements ActionListener{
			public void actionPerformed(ActionEvent e){
				DatabaseConnection dc = new DatabaseConnection();
				dc.insertDonorInfo(mobileNTF.getText(), nameTF.getText(), bloodGTF.getText(), sexTF.getText(), addressTF.getText(), emailTF.getText(), alternativeMNTF.getText());
			}
		}
		
		
		submitB.addActionListener(new donorSubmitB());
		
		this.add(monileNL);
		this.add(nameL);
		this.add(bloodGL);
		this.add(sexL);
		this.add(addressL);
		this.add(emailL);
		this.add(alternativeMNL);
		
		this.add(mobileNTF);
		this.add(nameTF);
		this.add(bloodGTF);
		this.add(sexTF);
		this.add(addressTF);
		this.add(emailTF);
		this.add(alternativeMNTF);
		
		this.add(submitB);
		
	}

}
