import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AdminPage {

	JFrame frame;
	private static Admin ADMIN;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage(ADMIN);
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
	public AdminPage(Admin ad) {
		ADMIN = ad;
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
		
		JLabel lblNewLabel = new JLabel("Welcome, "+ADMIN.getName());
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(171, 81, 333, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CHS");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
		lblNewLabel_1.setBounds(21, 10, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add A product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddProdcutPage APwindow = new AddProdcutPage(ADMIN);
					APwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(41, 312, 183, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemoveAProduct = new JButton("Remove A product");
		btnRemoveAProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = JOptionPane.showInputDialog(null, "Enter Product ID :");
				try
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
					String sql = "DELETE FROM product WHERE Product_ID = '"+ID+"'";
					PreparedStatement posted = con.prepareStatement(sql);
					
					posted.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Deleted Successfully!!");
					
					con.close();
				}
				catch(Exception R)
				{
					R.printStackTrace();
				}
			}
		});
		btnRemoveAProduct.setForeground(new Color(255, 0, 0));
		btnRemoveAProduct.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRemoveAProduct.setBounds(529, 312, 183, 38);
		frame.getContentPane().add(btnRemoveAProduct);
		
		JButton btnModifyAProduct = new JButton("Modify A product");
		btnModifyAProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModifyProductPage MPwindow = new ModifyProductPage(ADMIN);
					MPwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnModifyAProduct.setForeground(new Color(0, 0, 128));
		btnModifyAProduct.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnModifyAProduct.setBounds(293, 312, 183, 38);
		frame.getContentPane().add(btnModifyAProduct);
	}

}
