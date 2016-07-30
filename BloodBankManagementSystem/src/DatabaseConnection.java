import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseConnection {
	
	Connection con;
	PreparedStatement ps;
	String query;
	public DatabaseConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shadhin","123456");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}  
		
	}
	
	public void insertDonorInfo(String mobileN, String name, String bloodG, String sex, String address, String email, String alternativeMN){
		
		query = "insert into Donor (MobileN, Name, BloodG, Sex,  Address, Email, AlternativeMN) values('"+mobileN+"','"+name+"','"+bloodG+"','"+sex+"','"+address+"','"+email+"','"+alternativeMN+"')";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shadhin","123456");
			ps = con.prepareStatement(query);
			ps.executeQuery();
			con.close();
			System.out.println("Execution Successfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
public void insertRequest(String mobileN, String name, String bloodG, String sex, String address, String email, String alternativeMN){
	
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	String approval = "No";
		query = "insert into Request (MobileN, Name, BloodG, Sex,  Address, Email, RequestDate, Approval) values('"+mobileN+"','"+name+"','"+bloodG+"','"+sex+"','"+address+"','"+email+"','"+timeStamp+"','"+approval+"')";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shadhin","123456");
			ps = con.prepareStatement(query);
			ps.executeQuery();
			con.close();
			System.out.println("Execution Successfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	 

}
