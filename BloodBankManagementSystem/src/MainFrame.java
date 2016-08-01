import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu file, reg, inventory, req;
	private JMenuItem about, close, donor, stock, sells, request, approval;
	private static String titleText = "BBMS";
	private int pFlag = 0;
	
	
	public MainFrame(){
		//jFrame = new JFrame(titleText);
		//jFrame.setVisible(true);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
		menuBar = new JMenuBar();

		setJMenuBar(menuBar);
		
		file = new JMenu("File");
		menuBar.add(file);
		file.addSeparator();
		
		about = new JMenuItem("About");
		file.add(about);
		
		close = new JMenuItem("Close");
		file.add(close);
		
		reg = new JMenu("Registration");
		menuBar.add(reg);
		
		donor = new JMenuItem("Donor");
		reg.add(donor);
		
		inventory = new JMenu("Inventory");
		menuBar.add(inventory);
		
		stock = new JMenuItem("Stock");
		inventory.add(stock);
		
		sells = new JMenuItem("Sells");
		inventory.add(sells);
		
		req = new JMenu("Request");
		menuBar.add(req);
		
		request = new JMenuItem("Request");
		req.add(request);
		
		
		approval = new JMenuItem("Approval");
		req.add(approval);
		
		
		class donorA implements ActionListener{
			public void actionPerformed(ActionEvent e){
				DonorRegistrationForm drf = new DonorRegistrationForm();
				add(drf);
			}
		}
		
		donor.addActionListener(new donorA());
		
		class requestA implements ActionListener{
			public void actionPerformed(ActionEvent e){
				Request req = new Request();
				add(req.Request());
			}
		}
		
		request.addActionListener(new requestA());
		
		class closeA implements ActionListener{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		}
		
		close.addActionListener(new closeA());
		
		
		
	}


}
