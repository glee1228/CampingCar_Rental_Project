import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.Component;


interface Primary_Check{
	public void setAllVisibleFalse();
}

interface StructInterFace {
	public void insert();
	public void delete();
	public void update();
}


class JDBCcon {
	private static JDBCcon instance;
	private Connection conn;
	private static final String ID="s13011186";  //로컬 데이터베이스 사용자 아이디
	private static final String PW="ldh1228";     //로컬 데이터베이스 사용자 비밀번호
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";    //Oracle xe버전 로컬 호스트 URL

	
	private JDBCcon()
	{
		conn = null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL,ID,PW);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getcon()
	{
		return conn;
	}
	public static JDBCcon getinstance()
	{
		if(instance == null)
		{
			instance = new JDBCcon();
		}
		return instance;
	}
}

class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static MainFrame instance;
	
	private MainFrame()
	{
		super("캠핑카 프로젝트");
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().add(StartPanel.getinstance());
		pack();
	}
	public static MainFrame getinstance() {
		if(instance == null)
		{
			instance = new MainFrame();
		}
		return instance;
	}
	public void setTableMode(String mode) {
		remove(StartPanel.getinstance());
		if(mode.equals("AdminMode"))
		{
			getContentPane().add(AdminMode.getFirstinstance());
			AdminMode.getFirstinstance().replace_mode("Admin_Mode");
		}
		else if(mode.equals("Customer_Mode"))
		{
			CustomerMode.getFirstinstance().replace_mode("Customer_Mode");
			getContentPane().add(CustomerMode.getFirstinstance());
		}
		else if(mode.equals("CampingShop_Mode"))
		{
			CampingShopMode.getFirstinstance().replace_mode("CampingShop_Mode");
			getContentPane().add(CampingShopMode.getFirstinstance());
		}
		else
		{
			getContentPane().add(WorkShopMode.getFirstinstance());
			WorkShopMode.getFirstinstance().replace_mode("WorkShop_Mode");
		}
		pack();
		repaint();
	}
	public void setFirst(Primary_Check panel) {
		remove((Component) panel);
		setVisible(true);
		getContentPane().add(StartPanel.getinstance());
		pack();
		repaint();
	}
}

class AdminStruct implements StructInterFace {
	private ArrayList<String> column;
	private ArrayList<?> row_value_result;
	//private Vector<String> row_value_instance;
	
	public AdminStruct()
	{
		column = null;
		row_value_result = null;
		//row_value_instance = null;
	}
	public AdminStruct(ArrayList<String> column,@SuppressWarnings("rawtypes") ArrayList<Vector> row_value_result)
	{
		this.column = column;
		this.row_value_result= row_value_result;
	}
	public ArrayList<String> getColumn() {
		return column;
	}
	public void setColumn(ArrayList<String> column) {
		this.column = column;
	}
	public ArrayList<?> getRow_value_result() {
		return row_value_result;
	}
	public void setRow_value_result(ArrayList<?> row_value_result) {
		this.row_value_result = row_value_result;
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}



class CampshopStruct implements StructInterFace{
	private String shop_id;
	private String shop_name;
	private String shop_address;
	private String manager_name;
	private String shopemail;
	private String callnumber;
	public CampshopStruct() {
		shop_id = null;
		shop_name = null;
		shop_address = null;
		manager_name = null;
		shopemail =null;
		callnumber = null;
	}
	public CampshopStruct(String id)
	{
		this.shop_id = id;
		this.shop_name=null;
		shop_address = null;
		manager_name = null;
		shopemail = null;
		callnumber = null;
	}
	public CampshopStruct(String name,String call,String address,String manager_name,String email)
	{
		setLastID();
		this.shop_name = name;
		this.callnumber = call;
		this.shop_address = address;
		this.manager_name = name;
		this.shopemail = email;
	}
	public CampshopStruct(String id,String name,String call,String address,String manager_name,String email)
	{
		this.shop_id = id;
		this.shop_name = name;
		this.callnumber = call;
		this.shop_address = address;
		this.manager_name = name;
		this.shopemail = email;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getShopemail() {
		return shopemail;
	}
	public void setShopemail(String shopemail) {
		this.shopemail = shopemail;
	}
	public String getCallnumber() {
		return callnumber;
	}
	public void setCallnumber(String callnumber) {
		this.callnumber = callnumber;
	}
	public void setLastID()
	{
		ResultSet findid;
		String sql2 = "select Shopid from shoptbl order by shopid";
		PreparedStatement stat2 = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			while(findid.next())
			{
				if(findid.getString(1) != null)
				this.shop_id = findid.getString(1);
			}
			this.shop_id = this.shop_id.substring(1, this.shop_id.length());
			this.shop_id = this.shop_id.trim();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(shop_id == null)
			return;		
		int shopid_int = Integer.parseInt(this.shop_id);
		shopid_int++;
		this.shop_id = "C"+Integer.toString(shopid_int);
	}
	public void getLastID()
	{
		ResultSet findid;
		String sql2 = "select Shopid from shoptbl order by shopid";
		PreparedStatement stat2 = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			while(findid.next())
			{
				if(findid.getString(1) != null)
				this.shop_id = findid.getString(1);
			}
			this.shop_id = this.shop_id.substring(1, this.shop_id.length());
			this.shop_id = this.shop_id.trim();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(shop_id == null)
			return;		
		int shopid_int = Integer.parseInt(this.shop_id);
		this.shop_id = "C"+Integer.toString(shopid_int);
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		String sql = "insert into shoptbl(shopid,shopname,shopaddress,shopmobile,manager,shopemail) values(?,?,?,?,?,?)";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.shop_id);
			stat.setString(2, this.shop_name);
			stat.setString(3, this.shop_address);
			stat.setString(4, this.callnumber);
			stat.setString(5, this.manager_name);
			stat.setString(6, this.shopemail);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		String sql = "delete from shoptbl where shopid = ?";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.shop_id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		String sql = "Update shoptbl set shopname= ?,"
				+ ",shopaddress = ?"
				+ ",shopmobile = ?"
				+ ",manager = ?"
				+ ",shopemail = ?"
				+ "where shopid = ?";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.shop_name);
			stat.setString(2, this.shop_address);
			stat.setString(3, this.callnumber);
			stat.setString(4, this.manager_name);
			stat.setString(5, this.shopemail);
			stat.setString(6, this.shop_id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}



class CarStruct implements StructInterFace {
	private String carid;
	private String carname;
	private String carnumber;
	private String carpassenger;
	private String carrentalcost;
	private String image_path;
	private String cardetail;
	private String shopid;
	private LocalDate date;
	private String posible;
	
	
	public CarStruct(String Carid)
	{
		carid = Carid;
		carname = null;
		carnumber = null;
		carpassenger = null;
		carrentalcost = null;
		image_path = null;
		cardetail = null;
		shopid = null;
		date = null;
		posible = null;
	}
	public CarStruct()
	{
		carid = null;
		carname = null;
		carnumber = null;
		carpassenger = null;
		carrentalcost = null;
		image_path = null;
		cardetail = null;
		shopid = null;
		date = null;
		posible = null;
	}
	public CarStruct(String id,String carname,String carnumber,String carpassenger,String carrentalcost ,String image_path
			,String cardetail,String shopid)
	{
		this.carid = id;
		this.carname = carname;
		this.carnumber = carnumber;
		this.carpassenger = carpassenger;
		this.carrentalcost = carrentalcost;
		this.image_path = image_path;
		this.cardetail = cardetail;
		this.shopid = shopid;
		this.date = LocalDateTime.now().toLocalDate();
		this.posible = "y";
	}
	public CarStruct(String carname,String carnumber,String carpassenger,String carrentalcost ,String image_path
			,String cardetail,String shopid)
	{
		this.carname = carname;
		this.carnumber = carnumber;
		this.carpassenger = carpassenger;
		this.carrentalcost = carrentalcost;
		this.image_path = image_path;
		this.cardetail = cardetail;
		this.shopid = shopid;
		this.date = LocalDateTime.now().toLocalDate();
		this.posible = "y";
	}
	public void setLastID()
	{
		ResultSet findid;
		String sql2 = "select carid from cartbl order by carid";
		PreparedStatement stat2 = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			while(findid.next())
			{
				if(findid.getString(1) != null)
				this.carid = findid.getString(1);
			}
			this.carid = this.carid.substring(1, this.carid.length());
			this.carid = this.carid.trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(carid == null)
			return;		
		int carid_int = Integer.parseInt(this.carid);
		carid_int++;
		this.carid = "B"+Integer.toString(carid_int);
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		String sql = "insert into cartbl(carid,carname,carnumber,carpassenger,carrentalcost,shopid,cardate,cardetail,inuse,carimage) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.carid);
			stat.setString(2, this.carname);
			stat.setString(3, this.carnumber);
			stat.setString(4, this.carpassenger);
			stat.setString(5, this.carrentalcost);
			stat.setString(6, this.shopid);
			stat.setString(7, this.date.toString());
			stat.setString(8, this.cardetail);
			stat.setString(9, this.posible);
			stat.setString(10, this.image_path);
			
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		String sql = "delete from cartbl where carid = ? ";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.carid);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		String sql = "Update cartbl set carname= ?,"
				+ "carnumber = ?,"
				+ "carpassenger = ?,"
				+ "carrentalcost = ?,"
				+ "shopid = ?,"
				+ "cardetail = ?,"
				+ "inuse = ?,"
				+ "carimage = ?"
				+ "where carid = ?";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.carname);
			stat.setString(2, this.carnumber);
			stat.setString(3, this.carpassenger);
			stat.setString(4, this.carrentalcost);
			stat.setString(5, this.shopid);
			stat.setString(6, this.cardetail);
			stat.setString(7, this.posible);
			stat.setString(8, this.image_path);
			stat.setString(9, this.carid);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class CustomerStruct implements StructInterFace{
	private String name;	
	private String address;
	private String email;
	private String drivernumber;
	private String callnumber;
	private AdminStruct cardate;
	
	public CustomerStruct() {
		name =null;
		address=null;
		email=null;
		drivernumber=null;
		callnumber = null;
		cardate = null;
	}
	
	public CustomerStruct(String id)
	{
		this.drivernumber = id;
	}
	public CustomerStruct(String name,String address,String email,String drivernumber,String callnumber)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.drivernumber = drivernumber;
		this.callnumber = callnumber;
	}
	public CustomerStruct(String name,String address,String email,String drivernumber,String callnumber,AdminStruct value)
	{
		this.name = name;
		this.address = address;
		this.email = email;
		this.drivernumber = drivernumber;
		this.callnumber = callnumber;
		this.cardate = value;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getDrivernumber() {
		return drivernumber;
	}
	public String getcallnumber() {
		return callnumber;
	}
	public AdminStruct getCar()
	{
		return this.cardate;
	}
	public void setCar(AdminStruct value)
	{
		this.cardate = value;
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		String sql = "insert into customertbl(cusname,cusaddress,cusmobile,cusemail,drivernum) values(?,?,?,?,?)";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.name);
			stat.setString(2, this.address);
			stat.setString(3, this.callnumber);
			stat.setString(4, this.email);
			stat.setString(5, this.drivernumber);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		String sql = "delete from customertbl where drivernum = ?";
		PreparedStatement stat = null;
		System.out.println(this.drivernumber);
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.drivernumber);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		String sql = "Update customertbl set cusname = ?"
				+ ",cusaddress = ?"
				+ ",cusmobile = ?"
				+ ",cusemail = ?"
				+ ",where drivernum = ?";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.name);
			stat.setString(2, this.address);
			stat.setString(3, this.callnumber);
			stat.setString(4, this.email);
			stat.setString(5, this.drivernumber);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class WorkShopStruct implements StructInterFace{
	private String shopid;
	private String name;
	private String address;
	private String mobile;
	private String manager_name;
	private String email;
	private AdminStruct workshop;
	public WorkShopStruct()
	{
		this.shopid=null;
		this.name = null;
		address = null;
		mobile = null;
		manager_name= null;
		email = null;
		workshop = null;
	}
	public WorkShopStruct(String id)
	{
		this.shopid = id;
	}
	public WorkShopStruct(String name,String address,String mobile,String manager_name,String email)
	{
		getLastID();
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.manager_name = manager_name;
		this.email = email;
	}
	public WorkShopStruct(String shop_id,String name,String address,String mobile,String manager_name,String email)
	{
		this.shopid = shop_id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.manager_name = manager_name;
	}
	
	public String getShopid() {
		return shopid;
	}
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AdminStruct getWorkShop()
	{
		return this.workshop;
	}
	public void setWorkShop(AdminStruct value)
	{
		this.workshop = value;
	}
	public void setLastID()
	{
		ResultSet findid;
		String sql2 = "select Repshopid from repairshoptbl order by repshopid";
		PreparedStatement stat2 = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			while(findid.next())
			{
				if(findid.getString(1) != null)
				this.shopid = findid.getString(1);
			}
			this.shopid = this.shopid.substring(1, this.shopid.length());
			this.shopid = this.shopid.trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(shopid == null)
			return;		
		int shopid_int = Integer.parseInt(this.shopid);
		shopid_int++;
		this.shopid = "A"+Integer.toString(shopid_int);
	}
	public void getLastID()
	{
		ResultSet findid;
		String sql2 = "select Repshopid from repairshoptbl order by repshopid";
		PreparedStatement stat2 = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			while(findid.next())
			{
				if(findid.getString(1) != null)
				this.shopid = findid.getString(1);
			}
			this.shopid = this.shopid.substring(1, this.shopid.length());
			this.shopid = this.shopid.trim();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(shopid == null)
			return;		
		int shopid_int = Integer.parseInt(this.shopid);
		this.shopid = "A"+Integer.toString(shopid_int);
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		setLastID();
		String sql = "insert into Repairshoptbl(repshopid,repshopname,repaddress,repmobile,repmanager,repemail) values(?,?,?,?,?,?)";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.shopid);
			stat.setString(2, this.name);
			stat.setString(3, this.address);
			stat.setString(4, this.mobile);
			stat.setString(5, this.manager_name);
			stat.setString(6, this.email);
			stat.executeUpdate();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		String sql = "delete from customertbl where drivernum = ?";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.shopid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		String sql = "Update repairshoptbl set repshopname = ? "
				+ ",repaddress = ? "
				+ ",repmobile = ? "
				+ ",repmanager = ? "
				+ ",repemail = ? "
				+ "where repshopid = ? ";
		PreparedStatement stat = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, this.name);
			stat.setString(2, this.address);
			stat.setString(3, this.mobile);
			stat.setString(4, this.manager_name);
			stat.setString(5, this.email);
			stat.setString(6, this.shopid);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(null,"수정되었습니다.");
			
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


class Check_ID {
	ResultSet result;
		
	public boolean Check_Customer(String license) {
		String sql;
		sql = "select * from customertbl where DRIVERNUM =?";
		PreparedStatement sqlconnect;
		
		sqlconnect = null;
		try {
			sqlconnect = JDBCcon.getinstance().getcon().prepareStatement(sql);
			sqlconnect.setString(1,license);
			result = sqlconnect.executeQuery();
			if(result.next())
			{
				sqlconnect.close();
				return true;
			}
			else
			{
				sqlconnect.close();
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;	
	}
	
	public boolean Check_Shop(String license) {
		String sql;
		sql = "select * from shoptbl where shopid =?";
		PreparedStatement sqlconnect;
		sqlconnect = null;
		try {
			sqlconnect = JDBCcon.getinstance().getcon().prepareStatement(sql);
			
			sqlconnect.setString(1,license);
			result = sqlconnect.executeQuery();			
			if(result.next())
			{
				sqlconnect.close();
				return true;
			}
			else
			{
				sqlconnect.close();
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;	
	}
	
	public boolean Check_WorkShop(String license) {
		String sql;
		sql = "select * from repairshoptbl where repshopid =?";
		PreparedStatement sqlconnect;
		
		sqlconnect = null;
		try {
			sqlconnect = JDBCcon.getinstance().getcon().prepareStatement(sql);
			sqlconnect.setString(1,license);
			result = sqlconnect.executeQuery();
			if(result.next())
			{
				sqlconnect.close();
				return true;
			}
			else
			{
				sqlconnect.close();
				return false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;	
	}
}


class Admin_Class {
	@SuppressWarnings("rawtypes")
	public AdminStruct selectTable(String tablename)
	{
		String sql = "select * from "+tablename;
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	public void insertValue(StructInterFace struct)
	{
		struct.insert();
	}
	public void updateValue(StructInterFace struct)
	{
		struct.update();
	}
	public void deleteValue(StructInterFace struct)
	{
		struct.delete();
	}
	
	public String getcolumn_value(ResultSet result,int index,int types)
	{
		if(java.sql.Types.VARCHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.TIMESTAMP == types)
		{
			SimpleDateFormat changeString = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(result.getTimestamp(index) == null)
					return "";
				return changeString.format(result.getTimestamp(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(java.sql.Types.CHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.INTEGER == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		else if(java.sql.Types.NUMERIC == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
	
	@SuppressWarnings("rawtypes")
	public AdminStruct selectCarGroup() {
		String sql = "select shopid,count(*) from cartbl group by shopid";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectTwoYearNoRent() {
		String sql = "select * from customertbl where drivernum in (select drivernum from rentaltbl natural join (select drivernum, max(rentdate) as rentdate from rentaltbl group by drivernum) where to_char((select add_months(sysdate,-24) from dual),'yyyy-mm-dd') > rentdate)";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectRepairofShopCount() {
		String sql = "select repshopid,count(*) from repairtbl group by repshopid";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectCarOfRepair() {
		String sql = "select carid, carname,carpassenger,carnumber from cartbl where carid in (select carid from repairtbl group by carid having count(*)>=1)";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
				
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	
	public void updateRent(String id,String cost,String detail)
	{
		String sql="Update rentaltbl set etccost = ?, etcdetail = ? where rentnum = ?";
		PreparedStatement stat=null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setInt(1, Integer.parseInt(cost));
			stat.setString(2, detail);
			stat.setString(3, id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void updateRepair(String id,String cost,String detail)
	{
		String sql="Update repairtbl set repcost = ?, repdetail = ? where repnum = ?";
		PreparedStatement stat=null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setInt(1, Integer.parseInt(cost));
			stat.setString(2, detail);
			stat.setString(3, id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void deleteRental(String id)
	{
		String sql="delete from rentaltbl where rentnum = ?";
		PreparedStatement stat=null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void deleteRepair(String id)
	{
		String sql="delete from repairtbl where repnum = ?";
		PreparedStatement stat=null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			stat.executeUpdate();
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"Sql Complete");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setDeleteAll()
	{
		
		String sql[];
		PreparedStatement stat = null;
		sql = new String[144];
		
		try {
			int length=0;
			Scanner s = new Scanner(new File("c:\\\\dbinput.sql"),"UTF-8"); //경로 지정할때 역슬래쉬 4개를 써야 하나로 인식됨
			for(length=0;length<=143;length++){
				sql[length] = s.nextLine();
				stat = JDBCcon.getinstance().getcon().prepareStatement(sql[length]);
				stat.executeUpdate();
			}
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"테이블 초기화 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
				JDBCcon.getinstance().getcon().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class CampShopClass {
	public CampshopStruct getCampshopInformation(String id)
	{
		String sql = "select shopid,shopname,shopmobile,shopaddress,manager,shopemail from shoptbl where shopid = ?";
		PreparedStatement stat = null;
		CampshopStruct return_value = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			ArrayList<Integer> column_types;
			column_types = new ArrayList<Integer>();
			Vector<String> instance_value = null;	
			for(int i = 1;i<=column_result.getColumnCount();i++)
			{
				column_types.add(column_result.getColumnType(i));
			}
			if(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
			}
			return_value = new CampshopStruct(instance_value.get(0),instance_value.get(1),instance_value.get(2)
					,instance_value.get(3),instance_value.get(4),instance_value.get(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return return_value;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct setCarCount(String id)
	{
		String sql = "select count(*) from cartbl where shopid = ?";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct setCarAll(String id)
	{
		String sql = "select Carid,Carname,carnumber,carpassenger,carimage,carrentalcost,cardate,cardetail from cartbl where shopid = ?";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	
	@SuppressWarnings("rawtypes")
	public AdminStruct setRentCar(String id)
	{
		String sql = "select Carid,Carname,carnumber,carpassenger,carimage,carrentalcost,cardate,cardetail from cartbl where shopid = ? and inuse = ?";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			stat.setString(2, "N");
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}

	public void insertValue(StructInterFace struct)
	{
		struct.insert();
	}
	public void updateValue(StructInterFace struct)
	{
		struct.update();
	}
	public void deleteValue(StructInterFace struct)
	{
		struct.delete();
	}
	public String getcolumn_value(ResultSet result,int index,int types)
	{
		if(java.sql.Types.VARCHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.TIMESTAMP == types)
		{
			SimpleDateFormat changeString = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(result.getTimestamp(index) == null)
					return "";
				return changeString.format(result.getTimestamp(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.CHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.INTEGER == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		else if(java.sql.Types.NUMERIC == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
}


class Customer_Class {
	public CustomerStruct getinformation(String name)
	{
		CustomerStruct customer = null;
		String sql;
		sql = "select CUSNAME,CUSADDRESS,CUSEMAIL,DRIVERNUM,CUSMOBILE from CUSTOMERTBL where drivernum=?";
		
		PreparedStatement stat = null;
		ArrayList<String> column;
		Vector<String> instance_value = null;
		ArrayList<Integer> column_types;
		column = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, name);
			
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			if(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				customer = new CustomerStruct(instance_value.get(0),instance_value.get(1),instance_value.get(2),instance_value.get(3),instance_value.get(4));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return customer;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectRecentCar(String name)
	{
		String sql2;
		sql2 = "select * from rentaltbl where drivernum = ? ";
		PreparedStatement stat2 = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		AdminStruct return_value = null;
		column = null;
		row_data_set = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			stat2.setString(1, name);
			
			ResultSet result2 = stat2.executeQuery();
			ResultSetMetaData column_result2 = result2.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result2.getColumnCount();i++)
			{
				column.add(column_result2.getColumnName(i));
				column_types.add(column_result2.getColumnType(i));
			}
			while(result2.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result2.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result2,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value=new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return return_value;
	
	}
	public boolean CanRent(String name) {
		String sql = "select * from Rentaltbl where drivernum = ? AND PayDate is NULL";
		PreparedStatement checkvalue = null;
		try {
			checkvalue = JDBCcon.getinstance().getcon().prepareStatement(sql);
			checkvalue.setString(1, name);	
			if(checkvalue.executeQuery().next())
			{
				checkvalue.close();
				return false;
			}
			else
			{
				checkvalue.close();
				return true;
			}
		}
		catch(SQLException e) {}
		finally {
			try {
				checkvalue.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	public void setRent(String name, String car_ID)//name = license
	{
		ResultSet car;
		LocalDate date;
		String sql = "insert into RENTALTBL values(?,?,?,?,?,?,?,?,?,?)";
		String default_value = "NO DATA";
		String sql2 = "select carid,shopid,carrentalcost from CARTBL where carid = ? ";
		String sql3 = "Update CARTBL set INUSE = 'n' where CARID = ?";
		int setValue = 0;
		PreparedStatement insertvalue,selectvalue,updatevalue;
		if(!CanRent(name))
		{
			JOptionPane.showMessageDialog(CustomerMode.getFirstinstance(),"이미 대여 완료했습니다.");
			return;
		}

		date =LocalDateTime.now().toLocalDate();
		try {
			insertvalue = JDBCcon.getinstance().getcon().prepareStatement(sql);
			selectvalue = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			selectvalue.setString(1, car_ID);
			car = selectvalue.executeQuery();//���������� 1��������
			
			updatevalue = JDBCcon.getinstance().getcon().prepareStatement(sql3);
			updatevalue.setString(1, car_ID);
			String lastrent = getLastRenttable();
			
			if(car.next())
			{
				System.out.println(car.getString(1));
				System.out.println(car.getString(2));
				System.out.println(car.getInt(3));
				System.out.println(name);
				System.out.println(lastrent);
				insertvalue.setString(1,lastrent);
				insertvalue.setString(2,car.getString(1));
				insertvalue.setString(3,name);
				insertvalue.setString(4,car.getString(2));
				insertvalue.setString(5,date.toString());
				insertvalue.setInt(6,7);
				insertvalue.setInt(7, car.getInt(3));
				insertvalue.setNull(8,java.sql.Types.DATE);
				insertvalue.setString(9,default_value);
				insertvalue.setString(10,default_value);
				setValue = insertvalue.executeUpdate();
				updatevalue.executeUpdate();
			}
			selectvalue.close();
			insertvalue.close();
			updatevalue.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(setValue >0)
		{
			JOptionPane.showMessageDialog(MainFrame.getinstance(),"complete SQL" , "SQL-Message", 1);
		}
	}
	public String getLastRenttable()
	{
		ResultSet findid;
		String renttable_id = null;
		String sql2 = "select rentnum from rentaltbl order by rentnum";
		PreparedStatement stat2 = null;
		try {
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			while(findid.next())
			{
				if(findid.getString(1) != null)
					renttable_id = findid.getString(1);
			}
			renttable_id = renttable_id.trim();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(renttable_id);
		if(renttable_id == null)
			return "";		
		int shopid_int = Integer.parseInt(renttable_id);
		shopid_int++;
		return  Integer.toString(shopid_int);
	}
	public void setReturn(String rental_id,String car_id)
	{
		LocalDate date;
		String sql = "update RENTALTBL set paydate = ? where rentnum = ? ";
		String sql2 = "update Cartbl set INUSE = 'y' where carid =?";
		
		date = LocalDateTime.now().toLocalDate();
		PreparedStatement stat= null,stat2 = null;
		try
		{
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			stat.setString(1, date.toString());
			stat.setString(2, rental_id);
			stat2.setString(1, car_id);
			stat.executeQuery();
			stat2.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				stat.close();
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	@SuppressWarnings("rawtypes")
	public AdminStruct selectReturnTable(String name)
	{
		String sql = "select rentnum,Carid,shopid,rentdate,cost,paydate,etcdetail,etccost from rentaltbl where drivernum = ? "
				+ "and paydate is null";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, name);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectCanRentCar()
	{
		String sql = "select * from cartbl where INUSE = 'y'";
		AdminStruct return_value = null;
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			return_value = new AdminStruct();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				row_data_set.add(instance_value);
			}
			return_value = new AdminStruct(column,row_data_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return return_value;
	}
	public String getcolumn_value(ResultSet result,int index,int types)
	{
		if(java.sql.Types.VARCHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.TIMESTAMP == types)
		{
			SimpleDateFormat changeString = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(result.getTimestamp(index) == null)
					return "";
				return changeString.format(result.getTimestamp(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(java.sql.Types.CHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.INTEGER == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		else if(java.sql.Types.NUMERIC == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
	public void insertRepair(String drivernum,String workshopnum,String repairValue)
	{
		String sql1,sql2;
		LocalDate date,date2;
		date = LocalDateTime.now().toLocalDate();
		date2 = date.plusDays(3);
		int insertValue=0;
		String default_value = "NO DATA";
		sql1 = "select carid,shopid from cartbl where carid = (select carid from rentaltbl where drivernum = ? and paydate is NULL)";
		sql2 = "insert into repairtbl "
				+ "values(?,?,?,?,?,?,?,30000,?,?)";
		PreparedStatement stat1=null,stat2=null;
		try {
			stat1 = JDBCcon.getinstance().getcon().prepareStatement(sql1);
			stat1.setString(1,drivernum);
			ResultSet car = stat1.executeQuery();
			if(car.next())
			{
				stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
				stat2.setString(1,getLastRepair());
				stat2.setString(2,car.getString(1));
				stat2.setString(5,car.getString(2));
				stat2.setString(4,drivernum);
				stat2.setString(3,workshopnum);
				stat2.setString(6,repairValue);
				stat2.setString(7,date.toString());
				stat2.setString(8,date2.toString());
				stat2.setString(9,default_value);
			}//한개밖에없으므로
			insertValue = stat2.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				stat1.close();
				stat2.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(insertValue >0 )
		{
			JOptionPane.showMessageDialog(CustomerMode.getFirstinstance(), "SQL Complete");
		}
}
	
	public String getLastRepair()
	{
		ResultSet findid;
		String repair_id = null;
		String sql2 = "select repnum from repairtbl order by repnum";
		PreparedStatement stat2 = null;
		try { 
			stat2 = JDBCcon.getinstance().getcon().prepareStatement(sql2);
			findid = stat2.executeQuery();
			
			while(findid.next())
			{
				if(findid.getString(1) != null)
				{
					repair_id=findid.getString(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(repair_id);
		if(repair_id == null)
			return "";		
		int shopid_int = Integer.parseInt(repair_id);
		shopid_int++;
		return  Integer.toString(shopid_int);
	}
	public void updateValue(StructInterFace instance) {
		// TODO Auto-generated method stub
		instance.update();		
	}
}


class WorkShopClass {
	
	public void replaceRepairShop(String repshopname,String repaddress,String repmobile ,String repmanager, String repemail,String repshopid)
	{
		try {
			String sql = "Update REPAIRSHOPTBL set repshopname = ?, repaddress = ?, repmobile = ? ,repmanager = ?, repemail = ? where repshopid=?";
			
			PreparedStatement updatevalue;
			
			if(repshopid==null)
			{
				JOptionPane.showMessageDialog(null,"없는 정비소 정보입니다.");
				return;
			}
			
			updatevalue = JDBCcon.getinstance().getcon().prepareStatement(sql);
			updatevalue.setString(1, repshopname);
			updatevalue.setString(2, repaddress);
			updatevalue.setString(3, repmobile);
			updatevalue.setString(4, repmanager);
			updatevalue.setString(5, repemail);
			updatevalue.setString(6, repshopid);
			
			updatevalue.executeUpdate();
			JOptionPane.showMessageDialog(null,"수정되었습니다.");
			
			updatevalue.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void replaceRepair(String repdetail,String repdate,String repcost ,String paydate, String etcdetail,String repnum)
	{
		try {
			String sql = "Update REPAIRTBL set repdetail = ?, repdate = ?, repcost = ? ,paydate = ?, etcdetail =? where repnum=?";
			Timestamp timestamp1 = null, timestamp2 = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate1 = dateFormat.parse(repdate);
			timestamp1 = new java.sql.Timestamp(parsedDate1.getTime());
			    
			    Date parsedDate2 = dateFormat.parse(paydate);
			    timestamp2 = new java.sql.Timestamp(parsedDate2.getTime());
			PreparedStatement updatevalue;
			
			if(repnum==null)
			{
				JOptionPane.showMessageDialog(null,"없는 정비정보입니다.");
				return;
			}
			
			updatevalue = JDBCcon.getinstance().getcon().prepareStatement(sql);
			updatevalue.setString(1, repdetail);
			updatevalue.setTimestamp(2, timestamp1);
			updatevalue.setString(3, repcost);
			updatevalue.setTimestamp(4, timestamp2);
			updatevalue.setString(5, etcdetail);
			updatevalue.setString(6, repnum);
			
			updatevalue.executeUpdate();
			JOptionPane.showMessageDialog(null,"수정되었습니다.");
			
			updatevalue.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectMyWorkShop(String id)
	{
		ArrayList<String> column;
		ArrayList<Vector> result_set;
		Vector<String> instance_result;
		
		AdminStruct table_struct = null;
		column = new ArrayList<String>();
		result_set = new ArrayList<Vector>();
		String sql = "select * from repairshoptbl where repshopid = ? ";
		PreparedStatement stat = null;
		ArrayList<Integer> column_types;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1,id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_result = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_result.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				result_set.add(instance_result);
			}
			table_struct = new AdminStruct(column,result_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table_struct;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectRepairAll(String id)
	{
		ArrayList<String> column;
		ArrayList<Vector> result_set;
		Vector<String> instance_result;
		
		AdminStruct table_struct = null;
		column = new ArrayList<String>();
		result_set = new ArrayList<Vector>();
		String sql = "select * from repairtbl where repshopid=?";
		PreparedStatement stat = null;
		ArrayList<Integer> column_types;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1,id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_result = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_result.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				result_set.add(instance_result);
			}
			table_struct = new AdminStruct(column,result_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table_struct;
	}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectCountCar(String id)
	{
		ArrayList<String> column;
		ArrayList<Vector> result_set;
		Vector<String> instance_result;
		AdminStruct table_struct = null;
		column = new ArrayList<String>();
		result_set = new ArrayList<Vector>();
		
		String sql = "select count(*) as count from repairtbl where repshopid = ?";
		PreparedStatement stat = null;
		ArrayList<Integer> column_types;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1,id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_result = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_result.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				result_set.add(instance_result);
			}
			table_struct = new AdminStruct(column,result_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table_struct;
		}
	@SuppressWarnings("rawtypes")
	public AdminStruct selectCountOfShop(String id) 
	{
		ArrayList<String> column;
		ArrayList<Vector> result_set;
		Vector<String> instance_result;
		System.out.println(id);
		AdminStruct table_struct = null;
		column = new ArrayList<String>();
		result_set = new ArrayList<Vector>();
		
		String sql = "select shopid,count(*) as count from repairtbl where repshopid = ? group by shopid";
		PreparedStatement stat = null;
		ArrayList<Integer> column_types;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, id);
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			while(result.next())
			{
				instance_result = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_result.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				result_set.add(instance_result);
			}
			table_struct = new AdminStruct(column,result_set);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return table_struct;
	}
	public String getcolumn_value(ResultSet result,int index,int types)
	{
		if(java.sql.Types.VARCHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.TIMESTAMP == types)
		{
			SimpleDateFormat changeString = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(result.getTimestamp(index)!=null) {
					return changeString.format(result.getTimestamp(index));
					}
					else if(result.getTimestamp(index)==null)
						return "";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.CHAR == types)
		{
			try {
				return result.getString(index);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(java.sql.Types.INTEGER == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		else if(java.sql.Types.NUMERIC == types)
		{
			try {
				return Integer.toString(result.getInt(index));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public WorkShopStruct getinformation(String name)
	{
		// TODO Auto-generated method stub
		WorkShopStruct workshop = null;
		String sql;
		sql = "select REPSHOPID,REPSHOPNAME,REPADDRESS,REPMOBILE,REPMANAGER,REPEMAIL from REPAIRSHOPTBL where REPSHOPID = ?";
		
		PreparedStatement stat = null;
		ArrayList<String> column;
		ArrayList<Vector> row_data_set;			
		Vector<String> instance_value = null;
		ArrayList<Integer> column_types;
		column = null;
		row_data_set = null;
		try {
			stat = JDBCcon.getinstance().getcon().prepareStatement(sql);
			stat.setString(1, name);
			
			ResultSet result = stat.executeQuery();
			ResultSetMetaData column_result = result.getMetaData();
			
			column = new ArrayList<String>();
			row_data_set = new ArrayList<Vector>();
			column_types = new ArrayList<Integer>();
			for(int i=1;i<=column_result.getColumnCount();i++)
			{
				column.add(column_result.getColumnName(i));
				column_types.add(column_result.getColumnType(i));
			}
			if(result.next())
			{
				instance_value = new Vector<String>();
				for(int i=1 ; i<=column_result.getColumnCount();i++)
				{
					instance_value.add(getcolumn_value(result,i,column_types.get(i-1)));
				}
				workshop = new WorkShopStruct(instance_value.get(0),instance_value.get(1),instance_value.get(2),instance_value.get(3),instance_value.get(4),instance_value.get(5));			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("sql error");
		}
		finally {
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return workshop;
	}
	public void updateValue(StructInterFace instance) {
		// TODO Auto-generated method stub
		instance.update();		
	}
}


class AdminMode extends JPanel implements Primary_Check{
	
	private static final long serialVersionUID = 1L;
	private static AdminMode instance;
	private DefaultTableModel changeValue;
	private String mode;
	private JComboBox<String> setDefault;
	private ArrayList<String> defaultset;
	private ComboListener listener;
	private JPanel dynamic_Panel;
	
	private JLabel name_lb,email_lb,call_lb,address_lb;
	private JLabel customer_lb,campshop_lb,workshop_lb;
	private JLabel etccost_lb,etcdetail_lb;
	private JTextField customer_tx,campshop_tx,workshop_tx;
	private JTextField name_tx,email_tx,call_tx,address_tx;
	private JTextField etccost_tx,etcdetail_tx;
	private JButton commit,delet_bt;
	private JLabel select_lb;
	private JTable resaultTable;
	private Button_Add commit_listener;
	
	private Delete_Button delete_listener;
	private AdminMode() {
		super();
		delete_listener = new Delete_Button();
		commit_listener = new Button_Add();
		setPreferredSize(new Dimension(894, 608));
		setBackground(Color.WHITE);
		defaultset = new ArrayList<String>();
		listener = new ComboListener();
		setLayout(null);
		changeValue = new DefaultTableModel();
		this.setMode(mode);
		
		etccost_lb = new JLabel();
		etcdetail_lb = new JLabel();
		
		etccost_tx = new JTextField();
		etcdetail_tx = new JTextField();
		
		etccost_lb.setBounds(12, 8, 250, 48);
		etcdetail_lb.setBounds(12, 73, 250, 38);
		etccost_tx.setBounds(270,10,400,48);
		etcdetail_tx.setBounds(270,60,400,50);
		resaultTable = new JTable(changeValue);
		//resaultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(resaultTable);
		setDefault = new JComboBox<String>();
		setDefault.setBackground(Color.LIGHT_GRAY);
		setDefault.setBounds(12, 26, 601, 33);
		scrollPane.setBounds(12, 201, 870, 397);
		add(scrollPane);
		add(setDefault);
		delet_bt = new JButton("Delete");
		delet_bt.addActionListener(delete_listener);
		delet_bt.setBounds(675, 73, 139, 38);
		commit = new JButton("Commit");
		commit.setBounds(696, 36, 118, 38);
		dynamic_Panel = new JPanel();
		dynamic_Panel.setBackground(Color.LIGHT_GRAY);
		dynamic_Panel.setBounds(12, 69, 870, 122);
		add(dynamic_Panel);
		select_lb = new JLabel();
		commit.addActionListener(commit_listener);
		select_lb.setFont(new Font("HY견고딕", Font.BOLD | Font.ITALIC, 27));
		select_lb.setBackground(Color.LIGHT_GRAY);
		select_lb.setBounds(107, 8, 412, 87);
		dynamic_Panel.add(select_lb);
		dynamic_Panel.add(commit);
		dynamic_Panel.add(delet_bt);
		
		
		name_lb = new JLabel("Name");
		name_lb.setBounds(296, 48, 34, 15);
		email_lb = new JLabel("E-Mail");
		email_lb.setBounds(292, 73, 38, 15);
		call_lb = new JLabel("Call-Number");
		call_lb.setBounds(12, 73, 73, 15);
		address_lb = new JLabel("Address");
		address_lb.setBounds(12, 48, 60, 15);
		
		customer_lb = new JLabel("License");
		customer_lb.setBounds(14, 8, 45, 15);
		campshop_lb = new JLabel("CampShop_Name");
		campshop_lb.setBounds(14, 8, 103, 15);
		workshop_lb = new JLabel("WorkShop_Name");
		workshop_lb.setBounds(12, 8, 96, 15);
		
		customer_tx = new JTextField();
		customer_tx.setBounds(129, 5, 165, 21);
		campshop_tx = new JTextField();
		campshop_tx.setBounds(129, 5, 165, 21);
		workshop_tx = new JTextField();
		workshop_tx.setBounds(129, 5, 165, 21);
		name_tx = new JTextField();
		name_tx.setBounds(342, 45, 101, 21);
		call_tx = new JTextField();
		call_tx.setBounds(97, 70, 172, 21);
		address_tx = new JTextField();
		address_tx.setBounds(71, 45, 198, 21);
		email_tx = new JTextField();
		email_tx.setBounds(342, 70, 188, 21);
		dynamic_Panel.setLayout(null);
		
		dynamic_Panel.add(name_lb);
		dynamic_Panel.add(address_lb);
		dynamic_Panel.add(call_lb);
		dynamic_Panel.add(customer_lb);
		dynamic_Panel.add(campshop_lb);
		dynamic_Panel.add(email_lb);
		dynamic_Panel.add(workshop_lb);
		dynamic_Panel.add(etccost_lb);
		dynamic_Panel.add(etcdetail_lb);
		dynamic_Panel.add(etccost_tx);
		dynamic_Panel.add(etcdetail_tx);
		
		
		dynamic_Panel.add(name_tx);
		dynamic_Panel.add(address_tx);
		dynamic_Panel.add(call_tx);
		dynamic_Panel.add(email_tx);
		dynamic_Panel.add(workshop_tx);
		dynamic_Panel.add(customer_tx);
		dynamic_Panel.add(campshop_tx);
		setAllVisibleFalse();
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public void setDefault_setting() {
		if(!this.defaultset.isEmpty()) {
			defaultset.clear();
			setDefault.removeActionListener(listener);
			setDefault.removeAllItems();
		}
		defaultset.add("고객 등록");//0
		defaultset.add("캠핑카 회사 등록");//1
		defaultset.add("정비소 등록");//2
		defaultset.add("고객 전체 조회");//3
		defaultset.add("회사 전체 조회");//4
		defaultset.add("차량 전체 조회");//5
		defaultset.add("정비소 전체 조회");//6
		defaultset.add("정비정보 전체 조회");//7
		defaultset.add("대여정보 전체 조회");//8
		defaultset.add("고객 삭제");//9
		defaultset.add("캠핑카 회사 삭제");//10
		defaultset.add("정비소 삭제");//11
		defaultset.add("캠핑카 차량 삭제");//12
		defaultset.add("대여정보(ETC_Cost,ETC_Detail) 변경");//13
		defaultset.add("정비정보(Repair_Cost,Repair_Detail) 변경");//14
		defaultset.add("대여정보 삭제");//15
		defaultset.add("정비정보 삭제");//16
		defaultset.add("회사별 캠핑카 수량 조회(gruop by)");//17
		defaultset.add("정비소별 정비했던 차량 대수 조회(gruop by)");//18
		defaultset.add("2년동안 대여하지 않은 고객보기(삭제)(내포질의)");//19
		defaultset.add("한번이상 정비한 차량 보기(삭제 가능)(내포질의)");//20
		defaultset.add("뒤로가기");
		defaultset.add("테이블 초기화");
		

		for(int i =0;i<defaultset.size();i++)
		{
			setDefault.addItem(defaultset.get(i));
		}
		setDefault.addActionListener(listener);
	}
	
	public void setAddCustomerSetting()
	{
		setAllVisibleFalse();
		name_lb.setVisible(true);
		email_lb.setVisible(true);
		call_lb.setVisible(true);
		address_lb.setVisible(true);
		customer_lb.setVisible(true);
		customer_tx.setVisible(true);
		name_tx.setVisible(true);
		email_tx.setVisible(true);
		call_tx.setVisible(true);
		address_tx.setVisible(true);
		commit.setVisible(true);
	}
	public void setAddCampShopSetting()
	{
		setAllVisibleFalse();
		name_lb.setVisible(true);
		email_lb.setVisible(true);
		call_lb.setVisible(true);
		address_lb.setVisible(true);
		campshop_lb.setVisible(true);
		campshop_tx.setVisible(true);	
		name_tx.setVisible(true);
		email_tx.setVisible(true);
		call_tx.setVisible(true);
		address_tx.setVisible(true);
		commit.setVisible(true);
	}
	public void setAddWorkShopSetting()
	{
		setAllVisibleFalse();
		name_lb.setVisible(true);
		email_lb.setVisible(true);
		call_lb.setVisible(true);
		address_lb.setVisible(true);
		workshop_lb.setVisible(true);
		workshop_tx.setVisible(true);
		name_tx.setVisible(true);
		email_tx.setVisible(true);
		call_tx.setVisible(true);
		address_tx.setVisible(true);
		commit.setVisible(true);
	}
	@Override
	public void setAllVisibleFalse() {
		name_lb.setVisible(false);
		email_lb.setVisible(false);
		call_lb.setVisible(false);
		address_lb.setVisible(false);
		customer_lb.setVisible(false);
		campshop_lb.setVisible(false);
		workshop_lb.setVisible(false);
		name_tx.setVisible(false);
		email_tx.setVisible(false);
		call_tx.setVisible(false);
		address_tx.setVisible(false);
		customer_tx.setVisible(false);
		campshop_tx.setVisible(false);
		workshop_tx.setVisible(false);
		commit.setVisible(false);
		select_lb.setVisible(false);
		delet_bt.setVisible(false);
		etccost_lb.setVisible(false);
		etcdetail_lb.setVisible(false);
		etccost_tx.setVisible(false);
		etcdetail_tx.setVisible(false);
		etcdetail_tx.setText("");
		etccost_tx.setText("");
		name_tx.setText("");
		email_tx.setText("");
		call_tx.setText("");
		address_tx.setText("");
		customer_tx.setText("");
		campshop_tx.setText("");
		workshop_tx.setText("");
	}
	
	public void setSelectCustomerTBL() {
	
		setAllVisibleFalse();
		select_lb.setText("CustomerTBL");
		select_lb.setVisible(true);
		
	
	}
	public void setSelectCampShopTBL() {
		setAllVisibleFalse();
		select_lb.setText("CampShopTBL");
		select_lb.setVisible(true);
	}
	public void setSelectWorkShopTBL() {
		setAllVisibleFalse();
		select_lb.setText("WorkShopTBL");
		select_lb.setVisible(true);
	}
	public void setSelectCarTBL() {
		setAllVisibleFalse();
		select_lb.setText("CarTBL");
		select_lb.setVisible(true);
	}
	public void setSelectRepairTBL()
	{
		setAllVisibleFalse();
		select_lb.setText("RepairTBL");
		select_lb.setVisible(true);
	}
	public void setSelectRenTalTBL()
	{
		setAllVisibleFalse();
		select_lb.setText("RentalTBL");
		select_lb.setVisible(true);
	}
	public void setGroupByCarOfShop() 
	{
		setAllVisibleFalse();
		select_lb.setText("차량회사별 차량 수 조회");
		select_lb.setVisible(true);
	}
	public void setGroupByCarOfWork() 
	{
		setAllVisibleFalse();
		select_lb.setText("정비 회사별 정비한 조회");
		select_lb.setVisible(true);
	}
	public void setCountByCarOfWork() 
	{
		setAllVisibleFalse();
		select_lb.setText("정비수량에 따른 차 조회");
		select_lb.setVisible(true);
		delet_bt.setVisible(true);
	}
	public void setSelectTwoYear() {
		setAllVisibleFalse();
		select_lb.setText("2년동안 대여 안한 사람 조회");
		select_lb.setVisible(true);
		delet_bt.setVisible(true);
	}
	public void setDeleteMode()
	{
		setAllVisibleFalse();
		select_lb.setText("Delete Mode");
		select_lb.setVisible(true);
		delet_bt.setVisible(true);
	}
	public void replace_mode(String mode)
	{
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), mode, TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.RED));
		setMode(mode);
		setDefault_setting();
		setAddCustomerSetting();
	}
	public static AdminMode getFirstinstance() {
		if(instance == null)
		{
			instance = new AdminMode();
		}
		return instance;
	}//���� ���������� ȣ��
	public void setDeleteRental_repair()
	{
		setAllVisibleFalse();
		delet_bt.setVisible(true);
	}
	public void setUpdateRental()
	{
		setAllVisibleFalse();
		etccost_lb.setText("ETC_Cost");
		etcdetail_lb.setText("ETC_Detail");
		etccost_lb.setVisible(true);
		etcdetail_lb.setVisible(true);
		etccost_tx.setVisible(true);
		etcdetail_tx.setVisible(true);
		commit.setVisible(true);
	}
	public void setUpdateRepair()
	{
		setAllVisibleFalse();
		etccost_lb.setText("Repair_Cost");
		etcdetail_lb.setText("Repair_Detail");
		etccost_lb.setVisible(true);
		etcdetail_lb.setVisible(true);
		etccost_tx.setVisible(true);
		etcdetail_tx.setVisible(true);
		commit.setVisible(true);
	}
	
	@SuppressWarnings("rawtypes")
	public void setTable(AdminStruct value)
	{
		//changeValue = new DefaultTableModel();
		//resaultTable = new JTable(changeValue);
		changeValue = new DefaultTableModel();
		resaultTable.setModel(changeValue);
		for(int i =0;i<value.getColumn().size();i++)
			changeValue.addColumn(value.getColumn().get(i));
		for(int i = 0;i<value.getRow_value_result().size();i++)
		{
			changeValue.addRow((Vector)value.getRow_value_result().get(i));
		}
	}
	public ArrayList<String> getComboBoxItems(){return defaultset;}
	
	private class ComboListener implements ActionListener{
		private JComboBox<?> parsing;
		Admin_Class method_struct;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			parsing =(JComboBox<?>) e.getSource();
			if(parsing.getSelectedItem().equals("뒤로가기"))
			{
				MainFrame.getinstance().setFirst(AdminMode.getFirstinstance());
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(0)))
			{
				setAddCustomerSetting();
			}//Customer Add
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(1)))
			{
				setAddCampShopSetting();	
			}//CampShop Add
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(2)))
			{
				setAddWorkShopSetting();
			}//WorkShop Add
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(3)))
			{
				setSelectCustomerTBL();
				AdminStruct value ;
				method_struct = new Admin_Class();
				value = method_struct.selectTable("customertbl");
				setTable(value);
			}//Select Customer All
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(4)))
			{
				setSelectCampShopTBL();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectTable("shoptbl");
				setTable(value);
			}//Select CampingShop All
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(5)))
			{
				setSelectCarTBL();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectTable("cartbl");
				setTable(value);
			}//Select Car All
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(6)))
			{
				setSelectWorkShopTBL();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectTable("repairshoptbl");
				setTable(value);
			} 

			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(7)))
			{
				setSelectRepairTBL();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("repairtbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(8)))
			{
				setSelectRenTalTBL();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("rentaltbl"));				
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(9)))
			{
				setDeleteMode();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("customertbl"));
				//마우스 클릭시 삭제 (커스터머 불러오기)
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(10)))
			{
				setDeleteMode();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("shoptbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(11)))
			{
				setDeleteMode();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("repairshoptbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(12)))
			{
				setDeleteMode();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("cartbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(13)))
			{
				setUpdateRental();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("rentaltbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(14)))
			{
				setUpdateRepair();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("repairtbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(15)))
			{
				setDeleteRental_repair();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("rentaltbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(16)))
			{
				setDeleteRental_repair();
				method_struct = new Admin_Class();
				setTable(method_struct.selectTable("repairtbl"));
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(17)))
			{
				setGroupByCarOfShop();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectCarGroup();
				setTable(value);			
			}
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(18)))
			{
				setGroupByCarOfWork();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectRepairofShopCount();
				setTable(value);
			}//Select 
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(19)))
			{
				setSelectTwoYear();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectTwoYearNoRent();
				setTable(value);
			}//Select didn`t rent until two year of user
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(20)))
			{
				setCountByCarOfWork();
				method_struct = new Admin_Class();
				AdminStruct value = method_struct.selectCarOfRepair();
				setTable(value);
			}//Select Count By Car of repair
			else if(parsing.getSelectedItem().equals(getComboBoxItems().get(22)))
			{
				method_struct = new Admin_Class();
				method_struct.setDeleteAll();
				System.exit(0);
			}
		}
	}

	private class Button_Add implements ActionListener{
		Admin_Class method_struct;
		@Override
		public void actionPerformed(ActionEvent e) {
			method_struct = new Admin_Class();
			if(setDefault.getSelectedItem().equals(defaultset.get(0)))
			{
				method_struct.insertValue(new CustomerStruct(
						name_tx.getText(),
						address_tx.getText(),
						email_tx.getText(),
						customer_tx.getText(),
						call_tx.getText()
						));
				System.out.println("finish insert customer");
			}
			else if(setDefault.getSelectedItem().equals(defaultset.get(1)))
			{

				method_struct.insertValue(new CampshopStruct(
						campshop_tx.getText(),
						call_tx.getText(),
						address_tx.getText(),
						name_tx.getText(),
						email_tx.getText()
						));
				System.out.println("finish insert carshop");
			}
			else if(setDefault.getSelectedItem().equals(defaultset.get(2)))
			{
				method_struct.insertValue(new WorkShopStruct(
						workshop_tx.getText(),
						address_tx.getText(),
						call_tx.getText(),
						name_tx.getText(),
						email_tx.getText()
						));
				System.out.println("finish insert workshop");
			}
			else if(setDefault.getSelectedItem().equals(defaultset.get(13)))
			{
				if(resaultTable.getSelectedRow() < 0)
					return;
				method_struct.updateRent((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0),etccost_tx.getText(),etcdetail_tx.getText());	
			}
			else if(setDefault.getSelectedItem().equals(defaultset.get(14)))
			{
				if(resaultTable.getSelectedRow() < 0)
					return;
				method_struct.updateRepair((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0),etccost_tx.getText(),etcdetail_tx.getText());
			}
		}
	}
	private class Delete_Button implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(resaultTable.getSelectedRow() < 0)
				return;
			if(setDefault.getSelectedItem().equals(defaultset.get(9)) || setDefault.getSelectedItem().equals(defaultset.get(19)))
			{
				Admin_Class method_struct;
				method_struct = new Admin_Class();
				method_struct.deleteValue(new CustomerStruct((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),4)));
			}//사람 삭제
			else if(setDefault.getSelectedItem().equals(defaultset.get(12)) ||setDefault.getSelectedItem().equals(defaultset.get(20)))
			{

				Admin_Class method_struct;
				method_struct = new Admin_Class();
				method_struct.deleteValue(new CarStruct((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0)));
			}//차량 삭제
			else if(setDefault.getSelectedItem().equals(defaultset.get(10)))
			{
				Admin_Class method_struct;
				method_struct = new Admin_Class();
				method_struct.deleteValue(new CampshopStruct((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0)));	
			}//campshop delete
			else if(setDefault.getSelectedItem().equals(defaultset.get(11)))
			{
				Admin_Class method_struct;
				method_struct = new Admin_Class();
				method_struct.deleteValue(new WorkShopStruct((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0)));
			}//workshop delete
			else if(setDefault.getSelectedItem().equals(defaultset.get(15)))
			{
				Admin_Class method_struct;
				method_struct = new Admin_Class();
				method_struct.deleteRental(((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0)));
			}//rental delete
			else if(setDefault.getSelectedItem().equals(defaultset.get(16)))
			{
				Admin_Class method_struct;
				method_struct = new Admin_Class();
				method_struct.deleteRepair(((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0)));
			}//repair delete delete
			
		}
	}
}



class CampingShopMode extends JPanel implements Primary_Check{
	private static final long serialVersionUID = 1L;
	private static CampingShopMode instance;
	private DefaultTableModel changeValue;
	private String mode;
	private JComboBox<String> setDefault;
	private ArrayList<String> defaultset;
	private ComboListener listener;
	private JPanel dynamic_Panel;
	private JLabel change_lb;
	
	private JLabel name_lb,car_number_lb,possible_carry_lb,img_path_lb,detail_lb;
	private JLabel cost_lb;
	private JTextField name_tx,car_number_tx,possible_carry_tx,img_path_tx,detail_tx;
	private JTextField cost_tx;
	private JButton commit_bt,delete_bt;
	private JLabel select_lb;
	private JTable resaultTable;
	private CommitAction commit_listener;
	private DeleteAction delete_listener;
	
	private JLabel campshop_name_lb;
	private JLabel campshop_address_lb;
	private JTextField campshop_name_tx;
	private JTextField campshop_address_tx;
	private JTextField campshop_call_tx;
	private JTextField campshop_manager_tx;
	private JTextField campshop_email_tx;
	private JLabel campshop_email_lb;
	private JLabel campshop_manager_lb;
	private JLabel campshop_call_lb;
	
	private Click_Table table_click;
	private CampingShopMode() {
		super();
		setPreferredSize(new Dimension(894, 608));
		setBackground(Color.WHITE);
		defaultset = new ArrayList<String>();
		table_click = new Click_Table();
		listener = new ComboListener();
		setLayout(null);
		changeValue = new DefaultTableModel();
		this.setMode(mode);
		commit_listener = new CommitAction();
		delete_listener = new DeleteAction();
		resaultTable = new JTable(changeValue);
		JScrollPane scrollPane = new JScrollPane(resaultTable);
		setDefault = new JComboBox<String>();
		setDefault.setBounds(12, 26, 599, 33);
		scrollPane.setBounds(12, 201, 870, 397);
		add(scrollPane);
		add(setDefault);
		change_lb = new JLabel("");
		change_lb.setBounds(675, 26, 207, 33);
		add(change_lb);
		dynamic_Panel = new JPanel();
		dynamic_Panel.setBounds(12, 69, 870, 122);
		add(dynamic_Panel);
		
		name_lb = new JLabel("Car name");
		name_lb.setBounds(12, 9, 56, 15);
		car_number_lb = new JLabel("Car Number");
		car_number_lb.setBounds(12, 47, 69, 15);
		possible_carry_lb = new JLabel("Carry");
		possible_carry_lb.setBounds(12, 77, 31, 15);
		img_path_lb = new JLabel("Image Path");
		img_path_lb.setBounds(398, 9, 64, 15);
		detail_lb= new JLabel("Detail ");
		detail_lb.setBounds(427, 77, 35, 15);
		cost_tx = new JTextField("");
		cost_tx.setBounds(492, 47, 214, 15);
		cost_lb = new JLabel("Cost");
		cost_lb.setBounds(427, 38, 50, 32);
		dynamic_Panel.add(cost_lb);
		dynamic_Panel.add(cost_tx);
		dynamic_Panel.add(detail_lb);
		name_tx = new JTextField("");
		name_tx.setBounds(80, 6, 249, 21);
		car_number_tx = new JTextField("");
		car_number_tx.setBounds(90, 44, 290, 21);
		possible_carry_tx = new JTextField("");
		possible_carry_tx.setBounds(55, 74, 274, 21);
		img_path_tx = new JTextField("");
		img_path_tx.setBounds(491, 6, 214, 21);
		detail_tx= new JTextField("");
		detail_tx.setBounds(491, 69, 215, 21);
		commit_bt = new JButton("Commit");
		commit_bt.setBounds(781, 89, 77, 23);
		delete_bt = new JButton("Delete");
		delete_bt.setBounds(781, 89, 77, 23);
		select_lb = new JLabel("");
		select_lb.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 26));
		select_lb.setBounds(191, 9, 339, 69);
		dynamic_Panel.setLayout(null);
		commit_bt.addActionListener(commit_listener);
		delete_bt.addActionListener(delete_listener);
		dynamic_Panel.add(commit_bt);
		dynamic_Panel.add(delete_bt);
		dynamic_Panel.add(select_lb);
		dynamic_Panel.add(name_lb);
		dynamic_Panel.add(name_tx);
		dynamic_Panel.add(car_number_lb);
		dynamic_Panel.add(car_number_tx);
		dynamic_Panel.add(possible_carry_lb);
		dynamic_Panel.add(possible_carry_tx);
		dynamic_Panel.add(img_path_lb);
		dynamic_Panel.add(img_path_tx);
		dynamic_Panel.add(detail_lb);
		dynamic_Panel.add(detail_tx);
		
		
		campshop_name_lb = new JLabel("Name");
		campshop_name_lb.setBounds(12, 10, 98, 15);
		dynamic_Panel.add(name_lb);
		
		campshop_address_lb = new JLabel("Address");
		campshop_address_lb.setBounds(12, 45, 57, 15);
		dynamic_Panel.add(campshop_address_lb);
		
		campshop_call_lb = new JLabel("Mobile");
		campshop_call_lb.setBounds(12, 85, 57, 15);
		dynamic_Panel.add(campshop_call_lb);
		
		campshop_manager_lb = new JLabel("Manager");
		campshop_manager_lb.setBounds(476, 10, 57, 15);
		dynamic_Panel.add(campshop_manager_lb);
		
		campshop_email_lb = new JLabel("Email");
		campshop_email_lb.setBounds(475, 45, 85, 15);
		dynamic_Panel.add(campshop_email_lb);
		
		campshop_name_tx = new JTextField();
		campshop_name_tx.setBounds(55, 10, 176, 21);
		dynamic_Panel.add(campshop_name_tx);
		campshop_name_tx.setColumns(10);
		
		campshop_address_tx = new JTextField();
		campshop_address_tx.setColumns(10);
		campshop_address_tx.setBounds(75, 42, 250, 21);
		dynamic_Panel.add(campshop_address_tx);
		
		campshop_call_tx = new JTextField();
		campshop_call_tx.setColumns(10);
		campshop_call_tx.setBounds(55, 82, 216, 21);
		dynamic_Panel.add(campshop_call_tx);
		
		campshop_manager_tx = new JTextField();
		campshop_manager_tx.setColumns(10);
		campshop_manager_tx.setBounds(545, 7, 216, 21);
		dynamic_Panel.add(campshop_manager_tx);
		
		campshop_email_tx = new JTextField();
		campshop_email_tx.setColumns(10);
		campshop_email_tx.setBounds(476, 67, 285, 21);
		dynamic_Panel.add(campshop_email_tx);
		setAllVisibleFalse();		
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public void setDefault_setting() {
		if(!this.defaultset.isEmpty()) {
			defaultset.clear();
			setDefault.removeActionListener(listener);
			setDefault.removeAllItems();
		}
		defaultset.add("캠핑샵 정보 보기/수정");
		defaultset.add("캠핑카 등록하기");
		defaultset.add("캠핑카 수량 보기");
		defaultset.add("캠핑카 전체 보기");
		defaultset.add("나의 캠핑카 삭제하기");
		defaultset.add("나의 캠핑카 수정하기");
		defaultset.add("현재 대여중인 캠핑카 보기");
		
		defaultset.add("뒤로가기");
		for(int i =0;i<defaultset.size();i++)
		{
			setDefault.addItem(defaultset.get(i));
		}
		setDefault.addActionListener(listener);
	}
	
	public void replace_mode(String mode)
	{
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), mode, TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.RED));
		setDefault_setting();
		setCarAdd();
	}
	public static CampingShopMode getFirstinstance() {
		if(instance == null)
		{
			instance = new CampingShopMode();
		}
		return instance;
	}
	
	
	public void setDefault(String name)
	{
		this.change_lb.setText(name);
	}

	@Override
	public void setAllVisibleFalse() {
		// TODO Auto-generated method stub
		name_lb.setVisible(false);
		car_number_lb.setVisible(false);
		possible_carry_lb.setVisible(false);
		img_path_lb.setVisible(false);
		detail_lb.setVisible(false);
		cost_lb.setVisible(false);
		cost_tx.setVisible(false);
		name_tx.setVisible(false);
		car_number_tx.setVisible(false);
		possible_carry_tx.setVisible(false);
		img_path_tx.setVisible(false);
		detail_tx.setVisible(false);
		commit_bt.setVisible(false);
		delete_bt.setVisible(false);
		select_lb.setVisible(false);
		name_tx.setText("");
		car_number_tx.setText("");
		possible_carry_tx.setText("");
		img_path_tx.setText("");
		name_tx.setText("");
		detail_tx.setText("");
		cost_tx.setText("");
		
		campshop_name_lb.setVisible(false);
		campshop_address_lb.setVisible(false);
		campshop_name_tx.setVisible(false);
		campshop_address_tx.setVisible(false);
		campshop_call_tx.setVisible(false);
		campshop_manager_tx.setVisible(false);
		campshop_email_tx.setVisible(false);
		campshop_email_lb.setVisible(false);
		campshop_manager_lb.setVisible(false);
		campshop_call_lb.setVisible(false);
		if(resaultTable.getMouseListeners() != null)
			resaultTable.removeMouseListener(table_click);
	}	
	public void setCarAdd() 
	{
		setAllVisibleFalse();
		name_lb.setVisible(true);
		car_number_lb.setVisible(true);
		possible_carry_lb.setVisible(true);
		img_path_lb.setVisible(true);
		detail_lb.setVisible(true);
		name_tx.setVisible(true);
		car_number_tx.setVisible(true);
		possible_carry_tx.setVisible(true);
		img_path_tx.setVisible(true);
		detail_tx.setVisible(true);
		commit_bt.setVisible(true);
		cost_lb.setVisible(true);
		cost_tx.setVisible(true);
	}
	public void setCarUpdate()
	{
		setAllVisibleFalse();
		name_lb.setVisible(true);
		car_number_lb.setVisible(true);
		possible_carry_lb.setVisible(true);
		img_path_lb.setVisible(true);
		detail_lb.setVisible(true);
		name_tx.setVisible(true);
		car_number_tx.setVisible(true);
		possible_carry_tx.setVisible(true);
		img_path_tx.setVisible(true);
		detail_tx.setVisible(true);
		commit_bt.setVisible(true);
		cost_lb.setVisible(true);
		cost_tx.setVisible(true);
		resaultTable.addMouseListener(table_click);
		commit_bt.setVisible(true);
	}
	public void setCarCount() 
	{
		setAllVisibleFalse();
		select_lb.setVisible(true);
		select_lb.setText("전체 차량 수량 보기");
	}
	public void setCarSelectAll() 
	{
		setAllVisibleFalse();
		select_lb.setVisible(true);
		select_lb.setText("전체 차량 보기");
	}
	public void setCarDelete() 
	{
		setAllVisibleFalse();
		select_lb.setVisible(true);
		select_lb.setText("캠핑카 삭제 하기");
		delete_bt.setVisible(true);
		
	}
	public void setSelectRent() 
	{
		setAllVisibleFalse();
		select_lb.setVisible(true);
		select_lb.setText("현재 대여 중인 캠핑카 보기");
	}
	public void clearTable()
	{
		changeValue = new DefaultTableModel();
		resaultTable.setModel(changeValue);
	}
	@SuppressWarnings("rawtypes")
	public void setTable(AdminStruct value)
	{
		changeValue = new DefaultTableModel();
		resaultTable.setModel(changeValue);
		for(int i =0;i<value.getColumn().size();i++)
			changeValue.addColumn(value.getColumn().get(i));
		for(int i = 0;i<value.getRow_value_result().size();i++)
		{
			changeValue.addRow((Vector)value.getRow_value_result().get(i));
		}
	}
	public void setdefaultInformation()
	{
		setAllVisibleFalse();
		campshop_name_lb.setVisible(true);
		campshop_address_lb.setVisible(true);
		campshop_name_tx.setVisible(true);
		campshop_address_tx.setVisible(true);
		campshop_call_tx.setVisible(true);
		campshop_manager_tx.setVisible(true);
		campshop_email_tx.setVisible(true);
		campshop_email_lb.setVisible(true);
		campshop_manager_lb.setVisible(true);
		campshop_call_lb.setVisible(true);	
	}//캠핑샵의 정보 보이기
	public void setInformation()
	{
		CampShopClass method_struct;
		CampshopStruct struct;
		struct = new CampshopStruct();
		method_struct = new CampShopClass();
		struct = method_struct.getCampshopInformation(change_lb.getText());
		campshop_name_tx.setText(struct.getShop_name());
		campshop_address_tx.setText(struct.getShop_address());
		campshop_call_tx.setText(struct.getCallnumber());
		campshop_manager_tx.setText(struct.getManager_name());
		campshop_email_tx.setText(struct.getShopemail());
		clearTable();
	}//캠핑샵 정보 채우기
	private class ComboListener implements ActionListener{
		private JComboBox<?> parsing;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			parsing =(JComboBox<?>) e.getSource();
			if(parsing.getSelectedItem().equals("뒤로가기"))
			{
				MainFrame.getinstance().setFirst(CampingShopMode.getFirstinstance());
			}
			else if(parsing.getSelectedItem().equals(defaultset.get(0)))
			{
				setdefaultInformation();
				setInformation();
			}//캠핑카 수정하기
			else if(parsing.getSelectedItem().equals(defaultset.get(1)))
			{
				setCarAdd();
			}//차량 추가하기
			else if(parsing.getSelectedItem().equals(defaultset.get(2)))
			{
				setCarCount();
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				setTable(method_struct.setCarCount(change_lb.getText()));
			}//차량 수량보기
			else if(parsing.getSelectedItem().equals(defaultset.get(3)))
			{
				setCarSelectAll();
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				setTable(method_struct.setCarAll(change_lb.getText()));
			}//차량 전체보기
			else if(parsing.getSelectedItem().equals(defaultset.get(4)))
			{
				setCarDelete();
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				setTable(method_struct.setCarAll(change_lb.getText()));
			}//차량 삭제하기
			else if(parsing.getSelectedItem().equals(defaultset.get(5)))
			{
				setCarUpdate();
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				setTable(method_struct.setCarAll(change_lb.getText()));
			}//차량 수정하기
			else if(parsing.getSelectedItem().equals(defaultset.get(6)))
			{
				setSelectRent();
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				setTable(method_struct.setRentCar(change_lb.getText()));
			}
		}
	}
	private class CommitAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(setDefault.getSelectedItem().equals(defaultset.get(0)))
			{
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				method_struct.updateValue(new CampshopStruct(change_lb.getText(),campshop_name_tx.getText(),campshop_call_tx.getText()
						,campshop_address_tx.getText(),campshop_manager_tx.getText(),campshop_email_tx.getText()));
			}
			else if(setDefault.getSelectedItem().equals(defaultset.get(1)))
			{
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				method_struct.insertValue(new CarStruct(name_tx.getText(),car_number_tx.getText(),possible_carry_tx.getText()
					,cost_tx.getText(),img_path_tx.getText(),detail_tx.getText(),change_lb.getText()));
			}
			else if(setDefault.getSelectedItem().equals(defaultset.get(5)))
			{
				CampShopClass method_struct;
				method_struct = new CampShopClass();
				method_struct.updateValue(
						new CarStruct((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0),
						name_tx.getText(),car_number_tx.getText(),possible_carry_tx.getText()
					,cost_tx.getText(),img_path_tx.getText(),detail_tx.getText(),change_lb.getText()));
			}
		}
	}
	public String SelectValue(JTable resaultTable,int row,int column)
	{
		return (String) resaultTable.getValueAt(row,column);
	}
	private class DeleteAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CampShopClass method_struct;
			method_struct = new CampShopClass();
			method_struct.deleteValue(new CarStruct(SelectValue(resaultTable,resaultTable.getSelectedRow(),0)));
		}
	}
	private class Click_Table implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			name_tx.setText((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),1));
			car_number_tx.setText((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),2));
			possible_carry_tx.setText((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),3));
			cost_tx.setText((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),5));
			img_path_tx.setText((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),4));
			detail_tx.setText((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),7));
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub	
			}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
}


class Check_ID_Dialog extends Check_ID {
	private JDialog input_value;
	private JTextField textField;
	private JButton btnNewButton;
	private int dialog_value;
	private Commit listener;
	
	public Check_ID_Dialog(int value) {
		input_value = new JDialog();
		input_value.getContentPane().setLayout(null);
		input_value.setSize(564,155);
		this.dialog_value = value;
		textField = new JTextField();
		textField.setBounds(98, 46, 233, 40);
		input_value.getContentPane().add(textField);
		textField.setColumns(0);
		
		btnNewButton = new JButton("ID_Check");
		btnNewButton.setBounds(370, 45, 97, 40);
		input_value.getContentPane().add(btnNewButton);
		listener = new Commit();
		JLabel lblNewLabel = new JLabel("ID_\uC785\uB825");
		lblNewLabel.setBounds(38, 46, 75, 40);
		input_value.getContentPane().add(lblNewLabel);
		btnNewButton.addActionListener(listener);
		input_value.setVisible(true);
	}
	
	public int getvalue() {return dialog_value;}
	public void check() {
		if(dialog_value == 1)
		{
			if(Check_Customer(textField.getText())) 
			{
				input_value.setVisible(false);
				CustomerMode.getFirstinstance().setDefault(textField.getText());
				MainFrame.getinstance().setTableMode("Customer_Mode");
				return;
			}	
		}
		else if(dialog_value == 2)
		{

			if(Check_Shop(textField.getText()))
			{
				input_value.setVisible(false);
				CampingShopMode.getFirstinstance().setDefault(textField.getText());
				MainFrame.getinstance().setTableMode("CampingShop_Mode");
				return;
			}
		}
		else
		{

			if(Check_WorkShop(textField.getText())) 
			{
				input_value.setVisible(false);
				WorkShopMode.getFirstinstance().setDefault(textField.getText());
				MainFrame.getinstance().setTableMode("workShop_Mode");
				return;
			}
		}
		JOptionPane.showMessageDialog(input_value, "ID_create_please","warning", 0);
	}
	private class Commit implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			check();
		}
	}
}


 class CustomerMode extends JPanel implements Primary_Check {
	
	private static final long serialVersionUID = 1L;
	private static CustomerMode instance;
	private DefaultTableModel changeValue;
	private String mode;
	private JComboBox<String> setDefault;
	private ArrayList<String> defaultset;
	private ComboListener listener;
	private JPanel dynamic_Panel;
	private JLabel change_lb;
	private JButton rent_bt,return_bt;
	private JButton Fix_bt;
	private JLabel name_lb,address_lb,phone_lb,email_lb;
	private JTextField name_tx,addr_tx,phone_tx,email_tx;
	private JButton replace_bt;
	private CustomerStruct customerinformation;
	private JTable resaultTable;
	private Rent_Button rent_listener;
	private Update_Button update_listener;
	private Fix_Button fix_listener;
	
private CustomerMode() {
		super();
		setPreferredSize(new Dimension(894, 608));
		setBackground(Color.WHITE);
		customerinformation =null;
		defaultset = new ArrayList<String>();
		listener = new ComboListener();
		setLayout(null);
		update_listener = new Update_Button();
		changeValue = new DefaultTableModel();
		this.setMode(mode);
		resaultTable = new JTable(changeValue);
		JScrollPane scrollPane = new JScrollPane(resaultTable);
		setDefault = new JComboBox<String>();
		setDefault.setBounds(10, 26, 600, 30);
		scrollPane.setBounds(10, 210, 872, 388);
		add(scrollPane);
		add(setDefault);
		
		dynamic_Panel = new JPanel();
		dynamic_Panel.setBounds(10, 70, 872, 130);
		add(dynamic_Panel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(633, 34, 57, 15);
		add(lblId);
		
		change_lb = new JLabel("");
		change_lb.setBounds(656, 26, 226, 30);
		add(change_lb);
		
		rent_bt = new JButton("Rent");
		rent_bt.setBounds(589, 66, 96, 23);
		return_bt = new JButton("Return");
		return_bt.setBounds(605, 97, 80, 23);
		Fix_bt = new JButton("Fix");
		Fix_bt.setBounds(697, 97, 80, 23);
		replace_bt = new JButton("Replace");
		replace_bt.setBounds(781, 97, 79, 23);
		
		name_lb = new JLabel("Name");
		name_lb.setBounds(66, 9, 34, 15);
		address_lb = new JLabel("Address");
		address_lb.setBounds(293, 9, 96, 15);
		phone_lb = new JLabel("Call_Number");
		phone_lb.setBounds(46, 70, 73, 15);
		email_lb = new JLabel("E-mail");
		email_lb.setBounds(293, 70, 38, 15);
		
		name_tx = new JTextField();
		name_tx.setBounds(46, 34, 80, 21);
		addr_tx= new JTextField();
		addr_tx.setBounds(293, 34, 392, 21);
		phone_tx= new JTextField();
		email_tx = new JTextField();
		email_tx.setBounds(303, 98, 234, 21);
		phone_tx.setBounds(46, 98, 215, 21);
		dynamic_Panel.setLayout(null);
				
		dynamic_Panel.add(rent_bt);
		dynamic_Panel.add(return_bt);
		dynamic_Panel.add(Fix_bt);
		dynamic_Panel.add(name_lb);
		dynamic_Panel.add(address_lb);
		dynamic_Panel.add(phone_lb);
		dynamic_Panel.add(email_lb);
		dynamic_Panel.add(name_tx);
		dynamic_Panel.add(addr_tx);
		dynamic_Panel.add(email_tx);
		dynamic_Panel.add(phone_tx);
		dynamic_Panel.add(replace_bt);
		rent_listener = new Rent_Button();
		fix_listener = new Fix_Button();
		rent_bt.addActionListener(rent_listener);
		return_bt.addActionListener(rent_listener);
		replace_bt.addActionListener(update_listener);
		Fix_bt.addActionListener(fix_listener);
		setAllVisibleFalse();
	}
	
	
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setRentSetting() {
		setAllVisibleFalse();
		rent_bt.setVisible(true);
		return_bt.setVisible(true);
	}
	
	public void setFixSetting() {
		setAllVisibleFalse();
		Fix_bt.setVisible(true);
	}
	public void setDefaultInformationSetting() {
		setAllVisibleFalse();
		name_lb.setVisible(true);
		address_lb.setVisible(true);
		phone_lb.setVisible(true);
		email_lb.setVisible(true);
		name_tx.setVisible(true);
		addr_tx.setVisible(true);
		email_tx.setVisible(true);
		phone_tx.setVisible(true);
	}
	public void setReplaceSetting() {
		setAllVisibleFalse();
		name_lb.setVisible(true);
		address_lb.setVisible(true);
		phone_lb.setVisible(true);
		email_lb.setVisible(true);
		name_tx.setVisible(true);
		addr_tx.setVisible(true);
		email_tx.setVisible(true);
		phone_tx.setVisible(true);
		replace_bt.setVisible(true);
	}
	public void setDefault_setting() {
		if(!this.defaultset.isEmpty()) {
			defaultset.clear();
			setDefault.removeActionListener(listener);
			setDefault.removeAllItems();
		}
		defaultset.add("내 정보 보기");
		defaultset.add("대여/반납하기");
		defaultset.add("정비 의뢰하기/정비소 보기");
		defaultset.add("내정보 수정하기");
		defaultset.add("뒤로가기");
		for(int i =0;i<defaultset.size();i++)
		{
			setDefault.addItem(defaultset.get(i));
		}
		setDefault.addActionListener(listener);
	}
	
	public void replace_mode(String mode)
	{
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), mode, TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.RED));
		setDefault_setting();
		setDefaultInformationSetting();		
		setCustomerStruct(change_lb.getText());
		setCustomerinput();
	}
	public static CustomerMode getFirstinstance() {
		if(instance == null)
		{
			instance = new CustomerMode();
		}
		return instance;
	}
	
	public void setDefault(String name)
	{
		this.change_lb.setText(name);
	}
	public void setCustomerStruct(String name)
	{
		Customer_Class method_struct  =new Customer_Class();
		this.customerinformation = method_struct.getinformation(name);
		this.customerinformation.setCar(method_struct.selectRecentCar(name));
	}
	public void setCustomerinput()
	{
		name_tx.setText(customerinformation.getName());
		addr_tx.setText(customerinformation.getAddress());
		phone_tx.setText(customerinformation.getcallnumber());
		email_tx.setText(customerinformation.getEmail());
		setTable(customerinformation.getCar());
	}
	@SuppressWarnings("rawtypes")
	public void setTable(AdminStruct value)
	  {
		changeValue = new DefaultTableModel();
		resaultTable.setModel(changeValue);
		for(int i =0;i<value.getColumn().size();i++)
			changeValue.addColumn(value.getColumn().get(i));
		for(int i = 0;i<value.getRow_value_result().size();i++)
		{
			changeValue.addRow((Vector)value.getRow_value_result().get(i));
		}
	  }
	@Override
	public void setAllVisibleFalse() {
		// TODO Auto-generated method stub
		rent_bt.setVisible(false);
		return_bt.setVisible(false);
		Fix_bt.setVisible(false);
		name_lb.setVisible(false);
		address_lb.setVisible(false);
		phone_lb.setVisible(false);
		email_lb.setVisible(false);
		name_tx.setVisible(false);
		addr_tx.setVisible(false);
		email_tx.setVisible(false);
		phone_tx.setVisible(false);
		replace_bt.setVisible(false);
	}
	
	private class ComboListener implements ActionListener{
		private JComboBox<?> parsing;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			parsing =(JComboBox<?>) e.getSource();
			if(parsing.getSelectedItem().equals("뒤로가기"))
			{
				MainFrame.getinstance().setFirst(CustomerMode.getFirstinstance());
			}
			else if(parsing.getSelectedItem().equals("내 정보 보기"))
			{
				setDefaultInformationSetting();	
				setCustomerStruct(change_lb.getText());
				setCustomerinput();
				repaint();
			}
			else if(parsing.getSelectedItem().equals("대여/반납하기"))
			{
				setRentSetting();
				Customer_Class method_struct;
				method_struct = new Customer_Class();
				if(method_struct.CanRent(change_lb.getText()))
				{
					rent_bt.setEnabled(true);
					return_bt.setEnabled(false);
					setTable(method_struct.selectCanRentCar());
				}
				else
				{
					return_bt.setEnabled(true);					
					rent_bt.setEnabled(false);
					setTable(method_struct.selectReturnTable(change_lb.getText()));
				}
				repaint();
			}
			else if(parsing.getSelectedItem().equals("정비 의뢰하기/정비소 보기")) 
			{
				setFixSetting();
				Customer_Class method_struct;
				Admin_Class method_struct2;
				method_struct = new Customer_Class();
				if(!method_struct.CanRent(change_lb.getText()))
				{
					method_struct2 = new Admin_Class();
					setTable(method_struct2.selectTable("repairshoptbl"));					
				}
				else
				{
					JOptionPane.showMessageDialog(CustomerMode.getFirstinstance(),"정비 가능한 차량이 없습니다." ,"Error", 0);
					setDefault.setSelectedIndex(0);
					setDefaultInformationSetting();
				}
				repaint();
			}
			else
			{
				setReplaceSetting();
				repaint();
			}
		}
	}
	//정비를 의뢰하기 위해서 하는 작업
	//if customer rental car
	private class Fix_Button implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Customer_Class method_struct;
			method_struct = new Customer_Class();
			method_struct.insertRepair(change_lb.getText(),(String)resaultTable.getValueAt(resaultTable.getSelectedRow(), 0),
					JOptionPane.showInputDialog(dynamic_Panel, "수리해야 하는 부분을 입력해주세요", "FixField", 1).toString());
		}		
	}
	
	private class Update_Button implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Customer_Class method_struct;
			method_struct = new Customer_Class();
			method_struct.updateValue(new CustomerStruct(name_tx.getText(),addr_tx.getText(),email_tx.getText(),change_lb.getText(),phone_tx.getText()));
		}
		
	}
	
	private class Rent_Button implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton parser = (JButton)e.getSource();
			Customer_Class method_struct;
			if(parser == rent_bt)
			{
				method_struct = new Customer_Class();
				method_struct.setRent(change_lb.getText(),(String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0));
			}
			else
			{
				method_struct = new Customer_Class();
				method_struct.setReturn((String)resaultTable.getValueAt(resaultTable.getSelectedRow(),0),(String)resaultTable.getValueAt(resaultTable.getSelectedRow(),1));
			}
		}
	} 
}


class StartPanel extends JPanel {

 	private static final long serialVersionUID = 1L;
 	private static StartPanel instance;
 	private Start button_click;
 	private StartPanel() {
 		
 		super();
 		button_click = new Start();
 		setPreferredSize(new Dimension(400,200));
 		JButton tableMode = new JButton("Admin");
 		JButton customerMode = new JButton("Customer");
 		JButton carShopMode = new JButton("Camping Shop");
 		JButton workShopMode = new JButton("workShopMode");
 		
 		
 		tableMode.addActionListener(button_click);
 		customerMode.addActionListener(button_click);
 		workShopMode.addActionListener(button_click);
 		carShopMode.addActionListener(button_click);
 		
 		setLayout(new GridLayout(0, 2, 0, 0));
 		add(tableMode);
 		add(customerMode);
 		add(carShopMode);
 		add(workShopMode);
 	}
 	public static StartPanel getinstance() {
 		if(instance == null)
 		{
 			instance = new StartPanel();
 		}
 		return instance;
 		
 	}
 	private class Start implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			JButton event=(JButton)e.getSource();
 			if(event.getText().equals("Admin"))
 			{
 				MainFrame.getinstance().setTableMode("AdminMode");
 			}
 			else if(event.getText().equals("Customer"))
 			{
 				new Check_ID_Dialog(1);
 			}
 			else if(event.getText().equals("workShopMode"))
 			{
 				new Check_ID_Dialog(3);
 			}
 			else
 			{
 				new Check_ID_Dialog(2);
 			}
 		}
 		
 	}
 }


class WorkShopMode extends JPanel implements Primary_Check,MouseListener {
	
	private static final long serialVersionUID = 1L;
	private static WorkShopMode instance;
	private DefaultTableModel changeValue;
	private String mode;
	private JComboBox<String> setDefault;
	private ArrayList<String> defaultset;
	private ComboListener listener;
	private JPanel dynamic_Panel;
	private JLabel change_lb;
	private JLabel select_lb;
	private JLabel repdetail_lb,repdate_lb,repcost_lb,paydate_lb,etcdetail_lb;
	private JTextField repdetail_tx,repdate_tx,repcost_tx,paydate_tx,etcdetail_tx;
	private JButton replace_bt;
	private JButton shopreplace_bt;
	private JLabel repshopname_lb,repaddress_lb,repmobile_lb,repmanager_lb,repemail_lb;
	private JTextField repshopname_tx,repaddress_tx,repmobile_tx,repmanager_tx,repemail_tx;
	private JTable resaultTable;
	private WorkShopStruct repshopinformation;
	private Update_Button update_listener;
	private Rep_Update_Button rep_update_listener;
	private WorkShopMode() {
		super();
		setPreferredSize(new Dimension(894, 608));
		setBackground(Color.WHITE);
		defaultset = new ArrayList<String>();
		listener = new ComboListener();
		setLayout(null);
		repshopinformation=null;
		changeValue = new DefaultTableModel();
		this.setMode(mode);
		resaultTable = new JTable(changeValue);
		JScrollPane scrollPane = new JScrollPane(resaultTable);
		setDefault = new JComboBox<String>();
		setDefault.setBounds(12, 26, 530, 33);
		scrollPane.setBounds(12, 201, 870, 397);
		add(scrollPane);
		add(setDefault);
		change_lb = new JLabel("");
		change_lb.setBounds(564, 26, 134, 33);
		add(change_lb);
		dynamic_Panel = new JPanel();
		dynamic_Panel.setBounds(12, 69, 870, 122);
		add(dynamic_Panel);
		dynamic_Panel.setLayout(null);
		select_lb = new JLabel();
		select_lb.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 28));
		select_lb.setBounds(152, 4, 358, 106);
		dynamic_Panel.add(select_lb);
		replace_bt = new JButton("Replace");
		replace_bt.setBounds(659, 86, 128, 27);
		shopreplace_bt = new JButton("Replace");
		shopreplace_bt.setBounds(659, 86, 128, 27);
		
		rep_update_listener = new Rep_Update_Button();
		update_listener = new Update_Button();
		repdetail_lb = new JLabel("REPDETAIL");
		repdetail_lb.setBounds(46, 4, 171, 15);
		repdate_lb = new JLabel("REPDATE (year,month,day)");
		repdate_lb.setBounds(293, 4, 249, 15);
		repcost_lb = new JLabel("REPCOST");
		repcost_lb.setBounds(46, 62, 171, 15);
		paydate_lb = new JLabel("PAYDATE (year,month,day)");
		paydate_lb.setBounds(293, 62, 191, 15);
		etcdetail_lb = new JLabel("ETCDETAIL");
		etcdetail_lb.setBounds(556,4,107,15);
		repdetail_tx = new JTextField();
		repdetail_tx.setBounds(46, 26, 191, 30);
		repdate_tx= new JTextField();
		repdate_tx.setBounds(293, 26, 145, 30);
		repcost_tx= new JTextField();
		repcost_tx.setBounds(46, 83, 191, 33);
		paydate_tx = new JTextField();
		paydate_tx.setBounds(293, 83, 145, 33);
		
		repshopname_lb = new JLabel("REPSHOPNAME");
		repshopname_lb.setBounds(46, 4, 171, 15);
		repaddress_lb = new JLabel("REPADDRESS");
		repaddress_lb.setBounds(293, 4, 249, 15);
		repmobile_lb = new JLabel("REPMOBILE");
		repmobile_lb.setBounds(46, 62, 171, 15);
		repmanager_lb = new JLabel("REPMANAGER NAME");
		repmanager_lb.setBounds(293, 62, 191, 15);
		repemail_lb = new JLabel("REPEMAIL");
		repemail_lb.setBounds(556,4,107,15);
		repshopname_tx = new JTextField();
		repshopname_tx.setBounds(46, 26, 191, 30);
		repaddress_tx= new JTextField();
		repaddress_tx.setBounds(293, 26, 191, 30);
		repmobile_tx= new JTextField();
		repmobile_tx.setBounds(46, 83, 191, 33);
		repmanager_tx = new JTextField();
		repmanager_tx.setBounds(293, 83, 191, 33);
		repemail_tx = new JTextField();
		repemail_tx.setBounds(556,25,232,31);
		
		dynamic_Panel.add(repdetail_lb);
		dynamic_Panel.add(repdate_lb);
		dynamic_Panel.add(repcost_lb);
		dynamic_Panel.add(paydate_lb);
		dynamic_Panel.add(etcdetail_lb);
		dynamic_Panel.add(repdetail_tx);
		dynamic_Panel.add(repdate_tx);
		dynamic_Panel.add(repcost_tx);
		dynamic_Panel.add(paydate_tx);
		etcdetail_tx = new JTextField();
		etcdetail_tx.setBounds(556,25,232,31);
		dynamic_Panel.add(etcdetail_tx);
		dynamic_Panel.add(replace_bt);
		
		
		dynamic_Panel.add(repshopname_lb);
		dynamic_Panel.add(repaddress_lb);
		dynamic_Panel.add(repmobile_lb);
		dynamic_Panel.add(repmanager_lb);
		dynamic_Panel.add(repemail_lb);
		dynamic_Panel.add(repshopname_tx);
		dynamic_Panel.add(repaddress_tx);
		dynamic_Panel.add(repmobile_tx);
		dynamic_Panel.add(repmanager_tx);
		dynamic_Panel.add(repemail_tx);
		dynamic_Panel.add(shopreplace_bt);
		
		resaultTable.addMouseListener(this);
		replace_bt.addActionListener(update_listener);
		shopreplace_bt.addActionListener(rep_update_listener);
		setAllVisibleFalse();
		setReplaceSetting();
	}
	
	public void setRepshopStruct(String name)
	{
		WorkShopClass method_struct  =new WorkShopClass();
		this.repshopinformation = method_struct.getinformation(name);
		this.repshopinformation.setWorkShop(method_struct.selectMyWorkShop(name));
	}
	public void setWorkShopinput()
	{
		repshopname_tx.setText(repshopinformation.getName());
		repaddress_tx.setText(repshopinformation.getAddress());
		repmobile_tx.setText(repshopinformation.getMobile());
		repmanager_tx.setText(repshopinformation.getManager_name());
		repemail_tx.setText(repshopinformation.getEmail());
		setTable(repshopinformation.getWorkShop());
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public void setDefault(String name)
	{
		this.change_lb.setText(name);
	}
	public void setSelectWorkReplace()
	{
		
		
	}
	public void setSelectWorkAll()
	{
		
		select_lb.setVisible(true);
	}
	public void setSelectWorkCount()
	{
		select_lb.setVisible(true);
		select_lb.setText("정비한 모든 차량 대수");
	}
	public void setSelectWorkCountOfShop()
	{
		select_lb.setVisible(true);
		select_lb.setText("회사별 정비한 차량의 수");
	}
	public void setSelectMyWorkShop()
	{
		select_lb.setVisible(true);
		select_lb.setText("내 정비소 정보 보기");
	}
	public void setReplaceSetting() {
		setAllVisibleFalse();
		select_lb.setVisible(false);
		repdetail_lb.setVisible(true);
		repdate_lb.setVisible(true);
		repcost_lb.setVisible(true);
		paydate_lb.setVisible(true);
		etcdetail_lb.setVisible(true);
		repdetail_tx.setVisible(true);
		repdate_tx.setVisible(true);
		paydate_tx.setVisible(true);
		repcost_tx.setVisible(true);
		repdetail_tx.setVisible(true);
		etcdetail_tx.setVisible(true);
		replace_bt.setVisible(true);
	}
	public void setWorkShopReplaceSetting()
	{
		setAllVisibleFalse();
		repshopname_lb.setVisible(true);
		repaddress_lb.setVisible(true);
		repmobile_lb.setVisible(true);
		repmanager_lb.setVisible(true);
		repemail_lb.setVisible(true);
		repshopname_tx.setVisible(true);
		repaddress_tx.setVisible(true);
		repmobile_tx.setVisible(true);
		repmanager_tx.setVisible(true);
		repemail_tx.setVisible(true);
	}
	public void setWorkShopReplaceSetting2()
	{
		setAllVisibleFalse();
		repshopname_lb.setVisible(true);
		repaddress_lb.setVisible(true);
		repmobile_lb.setVisible(true);
		repmanager_lb.setVisible(true);
		repemail_lb.setVisible(true);
		repshopname_tx.setVisible(true);
		repaddress_tx.setVisible(true);
		repmobile_tx.setVisible(true);
		repmanager_tx.setVisible(true);
		repemail_tx.setVisible(true);
		shopreplace_bt.setVisible(true);
	}
	public void setReplaceText() {
		repdetail_tx.setText(SelectValue(resaultTable,resaultTable.getSelectedRow(),5));
		repcost_tx.setText(SelectValue(resaultTable,resaultTable.getSelectedRow(),7));
		repdate_tx.setText(SelectValue(resaultTable,resaultTable.getSelectedRow(),6));
		paydate_tx.setText(SelectValue(resaultTable,resaultTable.getSelectedRow(),8));
		etcdetail_tx.setText(SelectValue(resaultTable,resaultTable.getSelectedRow(),9));
	}
	public String getRepdetail()
	{
		return repdetail_tx.getText();
	}
	public String getRepcost()
	{
		return repcost_tx.getText();
	}
	public String getRepdate()
	{
		return repdate_tx.getText();
	}
	public String getPaydate()
	{
		return paydate_tx.getText();
	}
	public String getEtcdetail()
	{
		return etcdetail_tx.getText();
	}
	
	public String SelectValue(JTable resaultTable,int row,int column)
	{
		return (String) resaultTable.getValueAt(row,column);
	}
	public void setDefault_setting() {
		if(!this.defaultset.isEmpty()) {
			defaultset.clear();
			setDefault.removeActionListener(listener);
			setDefault.removeAllItems();
			}
		defaultset.add("내 정비소 정비정보 수정하기");
		defaultset.add("내 정비소 정비정보 전부 보기");
		defaultset.add("정비했던 차량의 수");
		defaultset.add("캠핑카 회사별 정비한 차량의 수");
		defaultset.add("내 정비소 정보 보기");
		defaultset.add("내 정비소 정보 수정하기");
		defaultset.add("뒤로가기");
		for(int i =0;i<defaultset.size();i++)
		{
			setDefault.addItem(defaultset.get(i));
		}
		setDefault.addActionListener(listener);
	}
	@Override
	public void setAllVisibleFalse() {
		// TODO Auto-generated method stub
		replace_bt.setVisible(false);
		select_lb.setVisible(false);
		shopreplace_bt.setVisible(false);
		repdetail_lb.setVisible(false);
		repdate_lb.setVisible(false);
		repcost_lb.setVisible(false);
		paydate_lb.setVisible(false);
		etcdetail_lb.setVisible(false);
		repdetail_tx.setVisible(false);
		repdate_tx.setVisible(false);
		repcost_tx.setVisible(false);
		paydate_tx.setVisible(false);
		etcdetail_tx.setVisible(false);
		repshopname_tx.setVisible(false);
		repshopname_lb.setVisible(false);
		repaddress_tx.setVisible(false);
		repaddress_lb.setVisible(false);
		repmobile_tx.setVisible(false);
		repmobile_lb.setVisible(false);
		repmanager_tx.setVisible(false);
		repmanager_lb.setVisible(false);
		repemail_tx.setVisible(false);
		repemail_lb.setVisible(false);
		
		
	}
	
	
	public void replace_mode(String mode)
	{
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), mode, TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, Color.RED));
		setDefault_setting();
		setSelectWorkAll();
	}
	
	
	public static WorkShopMode getFirstinstance() {
		if(instance == null)
		{
			instance = new WorkShopMode();

		}
		return instance;
	}//���� ���������� ȣ��
	@SuppressWarnings("rawtypes")
	public void setTable(AdminStruct value)
	{
		changeValue = new DefaultTableModel();
		resaultTable.setModel(changeValue);
		for(int i =0;i<value.getColumn().size();i++)
			changeValue.addColumn(value.getColumn().get(i));
		for(int i = 0;i<value.getRow_value_result().size();i++)
		{
			changeValue.addRow(((Vector)value.getRow_value_result().get(i)));
		}
	}
	
	private class ComboListener implements ActionListener{
		private JComboBox<?> parsing;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			parsing =(JComboBox<?>) e.getSource();
			if(parsing.getSelectedItem().equals(defaultset.get(0)))
			{
				setAllVisibleFalse();
				setReplaceSetting();
				WorkShopClass method_struct;
				method_struct = new WorkShopClass();
				System.out.println(change_lb.getText());
				setTable(method_struct.selectRepairAll(change_lb.getText()));
			}
			else if(parsing.getSelectedItem().equals(defaultset.get(1)))
			{
				setAllVisibleFalse();
				setSelectWorkAll();
				WorkShopClass method_struct;
				method_struct = new WorkShopClass();
				System.out.println(change_lb.getText());
				setTable(method_struct.selectRepairAll(change_lb.getText()));
			}
			else if(parsing.getSelectedItem().equals(defaultset.get(2)))
			{
				setAllVisibleFalse();
				setSelectWorkCount();
				WorkShopClass method_struct;
				method_struct = new WorkShopClass();
				setTable(method_struct.selectCountCar(change_lb.getText()));
			}
			else if(parsing.getSelectedItem().equals(defaultset.get(3)))
			{
				setAllVisibleFalse();
				setSelectWorkCountOfShop();
				WorkShopClass method_struct;
				method_struct = new WorkShopClass();
				setTable(method_struct.selectCountOfShop(change_lb.getText()));
			
			}
			else if(parsing.getSelectedItem().equals(defaultset.get(4)))
			{
				setAllVisibleFalse();
				setWorkShopReplaceSetting();
				setRepshopStruct(change_lb.getText());
				setWorkShopinput();
				
			
			}else if(parsing.getSelectedItem().equals(defaultset.get(5)))
			{
				setAllVisibleFalse();
				setWorkShopReplaceSetting2();
				setRepshopStruct(change_lb.getText());
				setWorkShopinput();
			
			
			}
			else if(parsing.getSelectedItem().equals("뒤로가기"))
			{
				MainFrame.getinstance().setFirst(WorkShopMode.getFirstinstance());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(replace_bt.isVisible()) {
			setReplaceText();
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private class Update_Button implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			WorkShopClass method_struct;
			method_struct = new WorkShopClass();
			method_struct.replaceRepair(repdetail_tx.getText(),repdate_tx.getText(),repcost_tx.getText(),paydate_tx.getText(),etcdetail_tx.getText(),SelectValue(resaultTable,resaultTable.getSelectedRow(),0));
			System.out.println(SelectValue(resaultTable,resaultTable.getSelectedRow(),0));
		}
		
	}
	
	private class Rep_Update_Button implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			WorkShopClass method_struct;
			method_struct = new WorkShopClass();
			method_struct.updateValue(new WorkShopStruct(change_lb.getText(),repshopname_tx.getText(),repaddress_tx.getText(),repmobile_tx.getText(),repmanager_tx.getText(),repemail_tx.getText()));
			System.out.println(change_lb.getText());
		}
		
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame.getinstance();
	}

}
