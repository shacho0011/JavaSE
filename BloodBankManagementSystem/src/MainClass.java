import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainClass {
	public static void main(String args[]){
		
		MainFrame menu = new MainFrame();
		
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		
		menu.setVisible(true);
		/*menu.setSize(800,600);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
	}
}
