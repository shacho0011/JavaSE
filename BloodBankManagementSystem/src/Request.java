import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Request {
	private static JFrame jFrame;
	private static JPanel jPanel;
	private JLabel monileNL, nameL, bloodGL, sexL, addressL, emailL, alternativeMNL;
	private JTextField mobileNTF, nameTF, bloodGTF, sexTF, addressTF, emailTF, alternativeMNTF;
	private JButton submitB;
	private static String titleText = "BBMS";
	
	public JPanel Request(){
		
		jPanel = new JPanel();
		jPanel.setBackground(Color.WHITE);
		jPanel.setLayout(null);
		
		monileNL = new JLabel("Request Mobile Number:");
		monileNL.setFont(new Font("Cambri", Font.PLAIN, 16));
		monileNL.setBounds(20, 50, 250, 20);
		nameL = new JLabel("Request Full Name:");
		nameL.setFont(new Font("Cambri", Font.PLAIN, 16));
		nameL.setBounds(20, 80, 250, 20);
		bloodGL = new JLabel("Request Blood Group:");
		bloodGL.setFont(new Font("Cambri", Font.PLAIN, 16));
		bloodGL.setBounds(20, 110, 250, 20);
		sexL = new JLabel("Request Sex:");
		sexL.setFont(new Font("Cambri", Font.PLAIN, 16));
		sexL.setBounds(20, 140, 250, 20);
		addressL = new JLabel("Request Address:");
		addressL.setFont(new Font("Cambri", Font.PLAIN, 16));
		addressL.setBounds(20, 170, 250, 20);
		emailL = new JLabel("Request Email:");
		emailL.setFont(new Font("Cambri", Font.PLAIN, 16));
		emailL.setBounds(20, 200, 250, 20);
		alternativeMNL = new JLabel("Request Alternative Mobile Number:");
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
		
		class requestSubmitB implements ActionListener{
			public void actionPerformed(ActionEvent e){
				DatabaseConnection dc = new DatabaseConnection();
				dc.insertRequest(mobileNTF.getText(), nameTF.getText(), bloodGTF.getText(), sexTF.getText(), addressTF.getText(), emailTF.getText(), alternativeMNTF.getText());
			}
		}
		
		
		submitB.addActionListener(new requestSubmitB());
		
		jPanel.add(monileNL);
		jPanel.add(nameL);
		jPanel.add(bloodGL);
		jPanel.add(sexL);
		jPanel.add(addressL);
		jPanel.add(emailL);
		jPanel.add(alternativeMNL);
		
		jPanel.add(mobileNTF);
		jPanel.add(nameTF);
		jPanel.add(bloodGTF);
		jPanel.add(sexTF);
		jPanel.add(addressTF);
		jPanel.add(emailTF);
		jPanel.add(alternativeMNTF);
		
		jPanel.add(submitB);
		
		return jPanel;
	}

}
