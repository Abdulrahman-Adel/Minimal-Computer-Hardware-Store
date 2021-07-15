import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ChangePassPage {

	private JFrame frame;
	private static ChangePassPage window;
	private static ShoppingCart Sc;
	private static Customer cs;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private String password;
	private String ID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ChangePassPage(cs, Sc);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangePassPage(Customer CS, ShoppingCart SC) {
		cs = CS;
		Sc = SC;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CHS");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
		lblNewLabel_1.setBounds(37, 32, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Current Password :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(134, 146, 119, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New Password :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(134, 212, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Confirm New Password :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(85, 287, 168, 20);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 146, 197, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(263, 214, 197, 20);
		frame.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(263, 287, 197, 20);
		frame.getContentPane().add(passwordField_2);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check_pass())
				{
					Connection con;
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						
						Statement stmt = con.createStatement();
						String sql = "UPDATE customer SET Password = '"+password+"' WHERE Customer_ID = '"+ID+"'";
								
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
					try {
						Profile Pwindow = new Profile(cs, Sc);
						Pwindow.frame.setVisible(true);
						frame.setVisible(false);
					} catch (Exception R) {
						R.printStackTrace();
					}
				}
			}
		});
		btnChangePassword.setForeground(new Color(0, 128, 0));
		btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChangePassword.setBounds(284, 387, 160, 25);
		frame.getContentPane().add(btnChangePassword);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Profile Pwindow = new Profile(cs, Sc);
					Pwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(Color.BLUE);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(602, 34, 138, 36);
		frame.getContentPane().add(btnNewButton_1_1);
	}
	
	private boolean check_equality()
	{
		password = String.valueOf(passwordField.getPassword());
		
		ID = cs.getID();
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
			
			Statement stmt = con.createStatement();
			String sql = "Select * from cutomer where Customer_ID = '"+ID+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				
				if(password != rs.getString("Password"))
				{
					return true;
				}
				else {
					return false;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "SomeThing went wrong!!");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	private boolean check_pass()
	{
		if(check_equality())
		{
			if(String.valueOf(passwordField_1.getPassword()).matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"))
			{
				if(String.valueOf(passwordField_1.getPassword()).equals(String.valueOf(passwordField_2.getPassword())))
				{
					password = String.valueOf(passwordField_1.getPassword());
					cs.setPass(password);
					return true;
				}
				else
				{
					passwordField.setText("");
					passwordField_1.setText("");
					JOptionPane.showMessageDialog(null, "The two passwords don't equal each other!");
					return false;
				}
			}
			else
			{
				passwordField.setText("");
				passwordField_1.setText("");
				JOptionPane.showMessageDialog(null,"Password must contain Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:!!");
				return false;
			}
		}
		return false;
	}
}
