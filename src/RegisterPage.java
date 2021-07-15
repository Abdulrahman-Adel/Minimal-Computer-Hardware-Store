import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class RegisterPage {

	static JFrame frame;
	private static RegisterPage window;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private String full_name;
	private String Email;
	private String password;
	private String address;
	private String ID;
	private String PhoneNum;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new RegisterPage();
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
	public RegisterPage() {
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
		lblNewLabel_1.setBounds(44, 26, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Full Name :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(110, 135, 67, 17);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(187, 135, 95, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAddress.setBounds(110, 229, 54, 17);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblStreet.setBounds(218, 206, 41, 17);
		frame.getContentPane().add(lblStreet);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(218, 229, 95, 20);
		frame.getContentPane().add(textField_1);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCity.setBounds(616, 206, 31, 17);
		frame.getContentPane().add(lblCity);
		
		JLabel lblGovernment = new JLabel("Government :");
		lblGovernment.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblGovernment.setBounds(350, 206, 79, 17);
		frame.getContentPane().add(lblGovernment);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setToolTipText("Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(110, 332, 63, 17);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(218, 332, 95, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblRetypePassword = new JLabel("Re-type password :");
		lblRetypePassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRetypePassword.setBounds(443, 335, 111, 17);
		frame.getContentPane().add(lblRetypePassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(616, 332, 95, 20);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check_info())
				{
					/* Creating The Object */
					Customer cst = new Customer();
					cst.setName(full_name);
					cst.setAdd(address);
					cst.setMail(Email);
					cst.setPass(password);
					cst.setNo(PhoneNum);
					cst.generate_ID();
					ID = cst.getID();
					
					/* Inserting data to db */
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						String sql = "INSERT INTO customer (customer_ID, Full_Name, Password, Email, Address, PhoneNum)"
								+ "VALUES ('"+ID+"', '"+full_name+"', '"+password+"', '"+Email+"', '"+address+"', '"+PhoneNum+"')";
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Your ID number is: "+ID);
						
						try {
							LoginPage Lwindow = new LoginPage();
							Lwindow.frame.setVisible(true);
							frame.setVisible(false);
						} catch (Exception R) {
							R.printStackTrace();
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
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(350, 400, 100, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginPage Lwindow = new LoginPage();
					Lwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(616, 43, 100, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Already a member?!");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(462, 45, 131, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(538, 135, 45, 17);
		frame.getContentPane().add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(616, 135, 95, 20);
		frame.getContentPane().add(textField_2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--"}));
		comboBox.setBounds(616, 228, 95, 20);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					if(comboBox_1.getSelectedItem().toString().equals("Cairo"))
					{
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Faisal", "Zayed", "Helwan"}));
					}
					else
					{
						comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--"}));
					}
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Cairo"}));
		comboBox_1.setBounds(372, 228, 95, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblPhoneNo = new JLabel("Phone no. :");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPhoneNo.setBounds(322, 138, 67, 17);
		frame.getContentPane().add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(409, 135, 95, 20);
		frame.getContentPane().add(textField_3);
	}
	
	private boolean check_info()
	{
		/**
		 * Function to check input information form text fields.
		 */
		if(textField.getText().trim().equals(""))
		{
			textField.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid name!");
			return false;
		}
		else
		{
			full_name = textField.getText();
		}
		
		if(textField_3.getText().trim().equals("") || !textField_3.getText().matches("[0-9]{11}"))
		{
			textField_3.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid Egyptian Phone Number!");
			return false;
		}
		else
		{
			PhoneNum = textField_3.getText();
		}
		
		if(String.valueOf(passwordField.getPassword()).matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"))
		{
			if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField_1.getPassword())))
			{
				password = String.valueOf(passwordField.getPassword());
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
		
		if(textField_1.getText().trim().equals(""))
		{
			textField_1.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a Street name!");
			return false;
		}
		else
		{
			address = textField_1.getText() + "," + comboBox.getSelectedItem() + "," + comboBox_1.getSelectedItem();
		}
		
		if(textField_2.getText().trim().equals("") || ! (textField_2.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")))
		{
			textField_2.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid email!");
			return false;
		}
		else
		{
			Email = textField_2.getText();
		}
		return true;
	}
	
	public boolean TestHelp(String name,String phnum, String pass,String pass2, String address, String mail)
	{
		/* A function to help test the check info function */
		
		textField.setText(name);
		textField_3.setText(phnum);
		passwordField.setText(pass);
		passwordField_1.setText(pass2);
		textField_1.setText(address);
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		textField_2.setText(mail);
	
		
		return check_info();
	}
}
