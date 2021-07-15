import java.awt.EventQueue; 

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class LoginPage {
	static JFrame frame;
	private static LoginPage window;
	private JTextField textField;
	private JPasswordField passwordField;
	private String Email;
	private String Password;
	private ShoppingCart sC;
	private Customer cS;
	private Admin ADMIN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginPage();
					window.frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		sC = new ShoppingCart();
		cS = new Customer();
		ADMIN = new Admin();
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
		lblNewLabel_1.setBounds(37, 31, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 0, 128));
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPassword.setBounds(168, 207, 84, 17);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblEmailorId = new JLabel("Email (or ID)  :");
		lblEmailorId.setForeground(new Color(0, 0, 128));
		lblEmailorId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmailorId.setBounds(168, 127, 124, 17);
		frame.getContentPane().add(lblEmailorId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(345, 127, 150, 20);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(345, 207, 150, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(check_info())
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						Statement stmt = con.createStatement();
						String sql = "Select * from customer where Email ='"+Email+"' and Password = '"+Password+"'";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "Login Successfully!");
							
							cS.setID(rs.getString("Customer_ID"));
							cS.setName(rs.getString("Full_Name"));
							cS.setMail(rs.getString("Email"));
							cS.setAdd(rs.getString("Address"));
							cS.setNo(rs.getString("PhoneNum"));
							cS.setPass(rs.getString("Password"));
							
							try {
								Market Mwindow = new Market(cS, sC);
								Mwindow.frame.setVisible(true);
								frame.setVisible(false);
							} catch (Exception R) {
								R.printStackTrace();
							}
						}
						else
						{
							String sql1 = "Select * from admin where Email ='"+Email+"' and Password = '"+Password+"'";
							ResultSet rs1 = stmt.executeQuery(sql1);
							
							if(rs1.next())
							{
								JOptionPane.showMessageDialog(null, "Login Successfully!\nWelcom Admin!");
								
								ADMIN.setID(rs1.getString("Admin_ID"));
								ADMIN.setName(rs1.getString("Full_Name"));
								ADMIN.setMail(rs1.getString("Email"));
								ADMIN.setPass(rs1.getString("Password"));
								ADMIN.setSalary(rs1.getDouble("Salary"));
								
								try {
									AdminPage window = new AdminPage(ADMIN);
									window.frame.setVisible(true);
									frame.setVisible(false);
								} catch (Exception R) {
									R.printStackTrace();
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Wrong Email or password!!");
								textField.setText("");
								passwordField.setText("");
							}
						}
						con.close();
					}
					catch(Exception E)
					{
						E.printStackTrace();
					}
				}
			}
		});
		btnSignIn.setForeground(new Color(0, 100, 0));
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignIn.setBounds(345, 344, 100, 25);
		frame.getContentPane().add(btnSignIn);
		
		JLabel lblNewLabel_2 = new JLabel("New Customer?!");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(521, 33, 131, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterPage Rwindow = new RegisterPage();
					Rwindow.frame.setVisible(true);
					window.frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(662, 31, 96, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	private boolean check_info()
	{
		if(textField.getText().trim().equals("") || textField.getText().matches("^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$"))
		{
			textField.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid email!");
			return false;
		}
		else
		{
			Email = textField.getText();
		}
		Password = String.valueOf(passwordField.getPassword());
		
		return true;
	}

}
