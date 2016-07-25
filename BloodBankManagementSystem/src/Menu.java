import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	private JPanel jPanel;
	private JMenuBar menuBar;
	private JMenu file, reg, inventory, req;
	private JMenuItem about, close, donor, stock, sells, request, approval;
	private static String titleText = "BBMS";
	public Menu(){
		super(titleText);
		
		jPanel = new JPanel();
		jPanel.setBackground(Color.WHITE);
		jPanel.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(true);
		
		file = new JMenu("File");
		reg = new JMenu("Registration");
		inventory = new JMenu("Inventory");
		req = new JMenu("Request");
		
		about = new JMenuItem("About");
		about.addActionListener(this);
		close = new JMenuItem("Close");
		close.addActionListener(this);
		donor = new JMenuItem("Donor");
		donor.addActionListener(this);
		stock = new JMenuItem("Stock");
		stock.addActionListener(this);
		sells = new JMenuItem("Sells");
		sells.addActionListener(this);
		request = new JMenuItem("Request");
		request.addActionListener(this);
		approval = new JMenuItem("Approval");
		approval.addActionListener(this);
		
		file.add(about);
		file.add(close);
		reg.add(donor);
		inventory.add(stock);
		inventory.add(sells);
		req.add(request);
		req.add(approval);
		
		
		menuBar.add(file);
		menuBar.add(reg);
		menuBar.add(inventory);
		menuBar.add(req);
		
		add(jPanel);
		setJMenuBar(menuBar);
	}
	@Override
	public void actionPerformed(ActionEvent arg) {
		// TODO Auto-generated method stub
		String comStr = arg.getActionCommand();
		if(comStr.equals("")){
			
		}else if(comStr.equals("About")){
			System.out.println("About");
		}else if(comStr.equals("Close")){
			System.out.println("Close");
		}else if(comStr.equals("Donor")){
			
			DonorRegistrationForm donor = new DonorRegistrationForm();
			donor.setVisible(true);
			donor.setSize(800,600);
			donor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jPanel.setVisible(false);
			System.out.println("Donor");
		}else if(comStr.equals("Stock")){
			System.out.println("Stock");
		}else if(comStr.equals("Sells")){
			System.out.println("Sells");
		}else if(comStr.equals("Request")){
			System.out.println("Request");
		}else if(comStr.equals("Approval")){
			System.out.println("Approval");
		}else{
			System.out.println("Select again!");
		}
	}

}
