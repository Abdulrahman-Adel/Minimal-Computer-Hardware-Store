import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class welcomePage {

	private JFrame frame;
	private static welcomePage window;
	static Admin ADMIN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new welcomePage();
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
	public welcomePage() {
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
		
		JLabel lblNewLabel = new JLabel("Computer Hardware Store");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(162, 42, 403, 78);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(282, 130, 182, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterPage Rwindow = new RegisterPage();
					Rwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(202, 300, 107, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
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
		btnLogin.setForeground(new Color(0, 100, 0));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(432, 300, 107, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnSignUpAs = new JButton("Sign Up As Admin");
		btnSignUpAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					ADMIN.generate_ID();
					ADMIN.setSalary(1550.0);
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
					String sql = "INSERT INTO admin (Admin_ID, Salary) VALUES ('"+ADMIN.getID()+"', 1550.0)";
					PreparedStatement posted = con.prepareStatement(sql);
					
					posted.executeUpdate();
					
					try {
						AdminSignUpPage Awindow = new AdminSignUpPage(ADMIN);
						Awindow.getFrame().setVisible(true);
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
		});
		btnSignUpAs.setForeground(new Color(128, 0, 128));
		btnSignUpAs.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignUpAs.setBounds(575, 20, 165, 25);
		frame.getContentPane().add(btnSignUpAs);
	}
}
