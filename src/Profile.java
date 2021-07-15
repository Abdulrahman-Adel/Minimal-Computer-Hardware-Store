import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile {

	JFrame frame;
	private static Profile window;
	private static Customer cs;
	private static ShoppingCart Sc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Profile(cs, Sc);
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
	public Profile(Customer CS, ShoppingCart SC) {
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
		lblNewLabel_1.setBounds(30, 26, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome, "+cs.getName());
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(171, 81, 333, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Customer_ID :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(74, 168, 119, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Address :");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(74, 265, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("E-mail :");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(410, 168, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Phone no. :");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(410, 265, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel(cs.getID());
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(224, 168, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel(cs.getAdd());
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(224, 265, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel(cs.getMail());
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_6.setBounds(559, 173, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel(cs.getNo());
		lblNewLabel_2_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_7.setBounds(559, 265, 119, 20);
		frame.getContentPane().add(lblNewLabel_2_7);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setForeground(new Color(0, 128, 0));
		btnChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnChangePassword.setBounds(93, 388, 160, 25);
		frame.getContentPane().add(btnChangePassword);
		
		JButton btnUpdateProfile = new JButton("Update Profile.");
		btnUpdateProfile.setForeground(Color.BLUE);
		btnUpdateProfile.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdateProfile.setBounds(443, 388, 160, 25);
		frame.getContentPane().add(btnUpdateProfile);
		
		JButton btnNewButton_1_1 = new JButton("BackToMarket");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Market Mwindow = new Market(cs, Sc);
					Mwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(605, 26, 138, 36);
		frame.getContentPane().add(btnNewButton_1_1);
	}

}
