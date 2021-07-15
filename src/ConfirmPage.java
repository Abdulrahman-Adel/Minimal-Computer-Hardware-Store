import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ConfirmPage {

	JFrame frame;
	private static Customer cS;
	private static ShoppingCart sC;
	private static Order or;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmPage window = new ConfirmPage(cS, or, sC);
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
	public ConfirmPage(Customer cS, Order or, ShoppingCart sC) {
		ConfirmPage.cS = cS;
		ConfirmPage.or = or;
		ConfirmPage.sC = sC;
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
		lblNewLabel_1.setBounds(32, 25, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Customer ID: ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(75, 129, 111, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerName.setBounds(75, 199, 111, 13);
		frame.getContentPane().add(lblCustomerName);
		
		JLabel lblShippingInfo = new JLabel("Shipping info.:");
		lblShippingInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblShippingInfo.setBounds(440, 130, 111, 13);
		frame.getContentPane().add(lblShippingInfo);
		
		JLabel lblPayemnt = new JLabel("Payemnt: ");
		lblPayemnt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPayemnt.setBounds(440, 199, 111, 13);
		frame.getContentPane().add(lblPayemnt);
		
		JLabel lblTotalPrise = new JLabel("Total Prise: ");
		lblTotalPrise.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalPrise.setBounds(75, 277, 111, 13);
		frame.getContentPane().add(lblTotalPrise);
		
		JLabel lblOrderid = new JLabel("Order_ID: ");
		lblOrderid.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOrderid.setBounds(440, 278, 111, 13);
		frame.getContentPane().add(lblOrderid);
		
		JLabel lblNewLabel_2 = new JLabel(cS.USER_ID);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(182, 129, 215, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(cS.getName());
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(230, 200, 111, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(String.valueOf(sC.getTotal_price()));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(230, 278, 111, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(or.getShipping());
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(575, 130, 111, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(or.getPayment());
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(575, 200, 111, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(or.getOrder_ID());
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(531, 277, 215, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblHowWasYour = new JLabel("How was your experience?");
		lblHowWasYour.setForeground(Color.BLUE);
		lblHowWasYour.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblHowWasYour.setBounds(75, 338, 192, 13);
		frame.getContentPane().add(lblHowWasYour);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(75, 361, 462, 92);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton_1 = new JButton("BackToMarket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPane.getText() != "")
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						Statement stmt = con.createStatement();
						String sql = "UPDATE orders SET Customer_Feedback = '"+ textPane.getText()+"' WHERE Order_ID = '"+or.getOrder_ID()+"'";
								
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();	
						
						con.close();
						
						sC = new ShoppingCart();
						try {
							Market window = new Market(cS, sC);
							window.frame.setVisible(true);
							frame.setVisible(false);
						} catch (Exception R) {
							R.printStackTrace();
						}
					}
					catch(Exception E)
					{
						E.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(609, 384, 138, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Log out");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textPane.getText() != "")
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						Statement stmt = con.createStatement();
						String sql = "UPDATE orders SET Customer_Feedback = '"+ textPane.getText()+"' WHERE Order_ID = '"+or.getOrder_ID()+"'";
								
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();	
						
						con.close();
				
						frame.dispose();
					}
					catch(Exception E)
					{
						E.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(625, 22, 121, 25);
		frame.getContentPane().add(btnNewButton_1_1);
	}
}
