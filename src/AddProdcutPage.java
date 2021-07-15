import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddProdcutPage {

	JFrame frame;
	private static AddProdcutPage window;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private Product pr;
	private static Admin admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new AddProdcutPage(admin);
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
	public AddProdcutPage(Admin ad) {
		pr = new Product();
		admin = ad;
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
		
		JLabel lblProductName = new JLabel("Product Name :");
		lblProductName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProductName.setBounds(59, 112, 91, 17);
		frame.getContentPane().add(lblProductName);
		
		JLabel lblNewLabel_1 = new JLabel("CHS");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Viner Hand ITC", Font.BOLD, 32));
		lblNewLabel_1.setBounds(20, 23, 74, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setColumns(10);
		textField.setBounds(171, 112, 184, 20);
		frame.getContentPane().add(textField);
		
		JLabel lblCompany = new JLabel("Company :");
		lblCompany.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCompany.setBounds(59, 194, 91, 17);
		frame.getContentPane().add(lblCompany);
		
		JLabel lblImagePath = new JLabel("Image Path :");
		lblImagePath.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblImagePath.setBounds(59, 270, 91, 17);
		frame.getContentPane().add(lblImagePath);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCategory.setBounds(450, 112, 91, 17);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setBounds(450, 194, 91, 17);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblAdminId = new JLabel("Admin ID :");
		lblAdminId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAdminId.setBounds(450, 270, 91, 17);
		frame.getContentPane().add(lblAdminId);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDescription.setBounds(59, 350, 91, 17);
		frame.getContentPane().add(lblDescription);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setColumns(10);
		textField_1.setBounds(171, 194, 184, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBounds(171, 270, 184, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText((String) null);
		textField_3.setColumns(10);
		textField_3.setBounds(563, 112, 184, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText((String) null);
		textField_4.setColumns(10);
		textField_4.setBounds(563, 194, 184, 20);
		frame.getContentPane().add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setColumns(10);
		textField_6.setBounds(171, 350, 370, 73);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Check_info())
				{
					pr.generateID();
					
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						String sql = "INSERT INTO product (Product_ID, Product_Name, Category, Company, ImagePath, Description, Price, Admin_ID)"
								+ "VALUES ('"+pr.getID()+"', '"+pr.getName()+"', '"+pr.getCat()+"', '"+pr.getCompany()+"', '"+pr.getImagePath()+"', '"+pr.getDes()+"', "+pr.getPrice()+", '"+admin.getID()+"')";
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Product Added!!");
						
						try {
							AdminPage Awindow = new AdminPage(admin);
							Awindow.frame.setVisible(true);
							frame.setVisible(false);
						} 
						catch (Exception R) {
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
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(643, 402, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(admin.getID());
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(563, 273, 184, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
	}
	private boolean Check_info()
	{
		/**
		 * Function to check input information form text fields.
		 */
		if(textField.getText().trim().equals(""))
		{
			textField.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid product name!");
			return false;
		}
		else
		{
			pr.setName(textField.getText());
		}
		
		if(textField_1.getText().trim().equals(""))
		{
			textField_1.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid company name!");
			return false;
		}
		else
		{
			pr.setCompany(textField_1.getText());
		}
		
		if(textField_3.getText().trim().equals(""))
		{
			textField_3.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid category!");
			return false;
		}
		else
		{
			pr.setCat(textField_3.getText());
		}
		
		if(!textField_2.getText().matches("([^\\\\s]+(\\\\.(?i)(jpe?g|png|gif|bmp))$)"))
		{
			pr.setImagePath(textField_2.getText());
		}
		else
		{
			textField_2.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid Image Path!");
			return false;
		}
		
		try
		{
		  pr.setPrice(Double.parseDouble(textField_4.getText()));
		}
		catch(NumberFormatException e)
		{
			textField_4.setText("");
			JOptionPane.showMessageDialog(frame,"The text you entered is not a valid float!");
			return false;
		}
		
		
		if(textField_6.getText().trim().equals(""))
		{
			textField_6.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a valid Description!");
			return false;
		}
		else
		{
			pr.setDes(textField_6.getText());
		}
		
		return true;
	}
	
	public boolean TestHelp(String name,String cat, String com, String imp, String price, String des)
	{
		/* A function to help test the check info function */
		
		textField.setText(name);
		textField_1.setText(com);
		textField_3.setText(cat);
		textField_2.setText(imp);
		textField_6.setText(des);
		textField_4.setText(price);
		
		return Check_info();
	}
}
