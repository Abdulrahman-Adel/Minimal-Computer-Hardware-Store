import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminSignUpPage {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_2;
	static Admin ADMIN;
	private String Email;
	private String password;
	private String full_name;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblPassword;
	private JLabel lblRetypePassword;
	private JLabel lblEmail;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignUpPage window = new AdminSignUpPage(ADMIN);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminSignUpPage(Admin ad) {
		ADMIN = ad;
		System.out.print(ADMIN.getID());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 800, 500);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Admin Code :");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(107, 73, 126, 24);
		getFrame().getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(278, 77, 220, 19);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);
		
		Display_Info();
	}
	
	public void Display_Info()
	{
		panel = new JPanel();
		panel.setBounds(10, 114, 766, 339);
		getFrame().getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Full Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(59, 39, 67, 17);
		panel.add(lblNewLabel_1);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setToolTipText("Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPassword.setBounds(59, 155, 63, 17);
		panel.add(lblPassword);
		
		lblRetypePassword = new JLabel("Re-type password :");
		lblRetypePassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRetypePassword.setBounds(400, 155, 111, 17);
		panel.add(lblRetypePassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 39, 95, 20);
		panel.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 155, 95, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(545, 155, 95, 20);
		panel.add(passwordField_1);
		
		lblEmail = new JLabel("E-mail :");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(400, 42, 45, 17);
		panel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(545, 39, 95, 20);
		panel.add(textField_2);
		
		btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(check_info())
				{
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						String sql = "UPDATE admin SET Email = '"+Email+"', Password = '"+password+"', Full_Name = '"+full_name
								+"' WHERE Admin_ID = '"+ADMIN.getID()+"'";
						
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();
						
						try {
							LoginPage Lwindow = new LoginPage();
							Lwindow.frame.setVisible(true);
							frame.setVisible(false);
						} catch (Exception R) {
							R.printStackTrace();
						}
						con.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
			
		});
		btnNewButton_1.setForeground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(322, 270, 100, 25);
		panel.add(btnNewButton_1);
	}
	
	private boolean check_info()
	{
		if(!ADMIN.getID().equals(textField.getText()))
		{
			JOptionPane.showMessageDialog(getFrame(),"Code is Invalid!");
			return false;
		}
		if(textField_1.getText().trim().equals(""))
		{
			textField_1.setText("");
			JOptionPane.showMessageDialog(getFrame(),"Enter a valid name!");
			return false;
		}
		else
		{
			full_name = textField_1.getText();
			ADMIN.setName(full_name);
		}
		if(String.valueOf(passwordField.getPassword()).matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"))
		{
			if(String.valueOf(passwordField.getPassword()).equals(String.valueOf(passwordField.getPassword())))
			{
				password = String.valueOf(passwordField.getPassword());
				ADMIN.setPass(password);
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
		
		if(textField_2.getText().trim().equals("") || textField_2.getText().matches("^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$"))
		{
			textField_2.setText("");
			JOptionPane.showMessageDialog(getFrame(),"Enter a valid email!");
			return false;
		}
		else
		{
			Email = textField_2.getText();
			ADMIN.setMail(Email);
		}
		return true;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
