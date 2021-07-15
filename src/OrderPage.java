import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;

public class OrderPage {

	JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3 ;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private static ShoppingCart sC;
	private static Customer cS;
	private Order or;
	private String address;
	private String payment;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPage window = new OrderPage(cS, sC);
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
	public OrderPage(Customer cs, ShoppingCart sc) {
		or = new Order();
		cS = cs;
		sC = sc;
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
		
		JLabel lblNewLabel = new JLabel("Shipping Info. :");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(111, 136, 125, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPaymentDetails = new JLabel("Payment Details :");
		lblPaymentDetails.setForeground(new Color(0, 0, 128));
		lblPaymentDetails.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPaymentDetails.setBounds(111, 290, 125, 20);
		frame.getContentPane().add(lblPaymentDetails);
		
		
		
		
		btnNewButton = new JButton("New Shipping info.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
				btnNewButton_1.setVisible(false);
				Display_New_Address();
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(246, 131, 160, 25);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Use Saved Address");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
				btnNewButton_1.setVisible(false);
				Display_current_Address();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBounds(461, 134, 160, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
				{
					if(comboBox.getSelectedItem().toString().equals("Credit Card"))
					{
						payment = null;
						Display_Card_info();
					}
					else if(comboBox.getSelectedItem().toString().equals("Cash"))
					{
						payment = "Cash,\t"+String.valueOf(sC.getTotal_price())+" L.E";
						if(panel_2 != null)
						{
							if(panel_2.isVisible())
								panel_2.setVisible(false);
						}	
						Display_Amount();
						
					}
					else
					{
						payment = "--Select--";
						if(panel_2 != null)
						{
							if(panel_2.isVisible())
								panel_2.setVisible(false);
						}
						if(panel_3 != null)
						{
							if(panel_3.isVisible())
								panel_3.setVisible(false);
						}
					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Cash", "Credit Card"}));
		comboBox.setBounds(270, 291, 125, 20);
		frame.getContentPane().add(comboBox);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("CHS");
		lblNewLabel_1_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_1_2.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
		lblNewLabel_1_2.setBounds(34, 23, 74, 52);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JButton btnNewButton_2 = new JButton("Confirm Order");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(check_info())
				{
					or.setCart_ID(sC.getID());
					or.generateID();
					or.setPayment(payment);
					or.setShipping(address);
					
					try
					{
						ArrayList<Product> pl = sC.getProduct_list();
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						
						for(int i = 0; i < sC.getLength(); i++)
						{
							Product pr = pl.get(i);
							String sql1 = "INSERT INTO product_list (Product_List_ID, Product_ID, Quantity)"
									+ "VALUES ('"+sC.getID()+"', '"+pr.getID()+"', "+pr.getQuan()+")";
							
							PreparedStatement posted1 = con.prepareStatement(sql1);
							
							posted1.executeUpdate();
						}
						
						try
						{
							String sql = "INSERT INTO orders (Order_ID, Customer_ID, Full_Price, Shipping_Address, Product_List_ID, Payment_Method)"
									+ "VALUES ('"+or.getOrder_ID()+"', '"+cS.getID()+"', "+sC.getTotal_price()+", '"+address+"', '"+sC.getID()+"', '"+payment+"')";
							PreparedStatement posted = con.prepareStatement(sql);
							
							posted.executeUpdate();
							
							try {
								ConfirmPage window = new ConfirmPage(cS, or, sC);
								window.frame.setVisible(true);
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
					catch(Exception E)
					{
						E.printStackTrace();
					}
				}
			}
		});
		btnNewButton_2.setForeground(new Color(255, 0, 0));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(309, 380, 207, 52);
		frame.getContentPane().add(btnNewButton_2);
		
	}
	private void Display_New_Address()
	{
		
		
		panel_1.setBounds(220, 98, 473, 90);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Region :");
		lblNewLabel_2.setBounds(10, 10, 85, 20);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 40, 125, 21);
		panel_1.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Cairo", "Giza", "Alex"}));
		
		JLabel lblNewLabel_3 = new JLabel("Shipping Cost :");
		lblNewLabel_3.setBounds(215, 10, 125, 20);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel_4 = new JLabel("50 L.E");
		lblNewLabel_4.setBounds(215, 39, 100, 20);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		address = comboBox_1.getSelectedItem().toString();
	}
	
	private void Display_current_Address()
	{
		
		panel = new JPanel();
		panel.setBounds(235, 100, 462, 94);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel_5 = new JLabel("Address :");
		lblNewLabel_5.setBounds(10, 10, 95, 20);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		address = cS.getAdd();
		
		JLabel lblNewLabel_6 = new JLabel(address);
		lblNewLabel_6.setBounds(20, 40, 410, 25);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
	}
	private void Display_Card_info()
	{
		panel_2 = new JPanel();
		panel_2.setBounds(417, 238, 359, 103);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Credit Card no. :");
		lblNewLabel_1.setBounds(10, 25, 125, 20);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField = new JTextField();
		textField.setBounds(10, 55, 140, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Holder Name. :");
		lblNewLabel_1_1.setBounds(186, 25, 125, 20);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 55, 140, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
	}
	
	private void Display_Amount()
	{
		panel_3 = new JPanel();
		panel_3.setBounds(423, 252, 337, 90);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Amount :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 10, 95, 13);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(String.valueOf(sC.getTotal_price())+" L.E");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(10, 39, 95, 28);
		panel_3.add(lblNewLabel_8);
	}
	
	private boolean check_info()
	{
		if(payment == null)
		{
			if(textField_1.getText().matches("^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$"))
			{
				payment = "Credit Card,\t"+textField_1.getText();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Enter A Valid Credit Card Number!!");
				return false;
			}
		}
		else if(payment == "--Select--")
		{
			JOptionPane.showMessageDialog(null, "Choose a valid payment method");
			return false;
		}
		if(address == null || address.equals("--Select--"))
		{
			JOptionPane.showMessageDialog(null, "Please Enter your address!!");
			return false;
		}
		return true;
		
	}
}
