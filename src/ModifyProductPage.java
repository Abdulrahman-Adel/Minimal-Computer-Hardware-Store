import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class ModifyProductPage {

	JFrame frame;
	private static ModifyProductPage window;
	static Admin ADMIN;
	private JTextField textField_1;
	private String ID;
	private String product_name;
	private String category;
	private String company;
	private String ImagePath;
	private String Description;
	private Double price;
	private String admin_ID;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ModifyProductPage(ADMIN);
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
	public ModifyProductPage(Admin ad) {
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
		
		JLabel lblNewLabel = new JLabel("Enter Product ID :");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(122, 89, 126, 24);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(289, 93, 220, 19);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					ID = textField_1.getText();
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
					Statement stmt = con.createStatement();
					String sql = "Select * from product where Product_ID = '"+ID+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next())
					{
						product_name = rs.getString("Product_Name");
						company = rs.getString("Company");
						category = rs.getString("Category");
						ImagePath = rs.getString("ImagePath");
						Description = rs.getString("Description");
						admin_ID = rs.getString("Admin_ID");
						price = rs.getDouble("Price");
						
						Display_Info();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Non Existing Prodcut!!");
					}
					con.close();
				}
				catch(Exception E)
				{
					E.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(584, 92, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		//Display_Info();
			
	}
	
	void Display_Info()
	{
		JPanel panel = new JPanel();
		panel.setBounds(10, 123, 766, 330);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name :");
		lblProductName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblProductName.setBounds(55, 48, 91, 17);
		panel.add(lblProductName);
		
		JLabel lblCompany = new JLabel("Company :");
		lblCompany.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCompany.setBounds(55, 130, 67, 17);
		panel.add(lblCompany);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCategory.setBounds(441, 51, 67, 17);
		panel.add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrice.setBounds(441, 133, 67, 17);
		panel.add(lblPrice);
		
		JLabel lblImagePath = new JLabel("Image Path :");
		lblImagePath.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblImagePath.setBounds(55, 198, 91, 17);
		panel.add(lblImagePath);
		
		JLabel lblAdminId = new JLabel("Admin ID :");
		lblAdminId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblAdminId.setBounds(441, 198, 67, 17);
		panel.add(lblAdminId);
		
		JLabel lblNewLabel_7 = new JLabel("Description  :");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(55, 276, 91, 17);
		panel.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(156, 48, 184, 20);
		panel.add(textField);
		textField.setText(product_name.toString());
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(540, 48, 159, 20);
		panel.add(textField_2);
		textField_2.setText(category.toString());
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(156, 130, 184, 20);
		panel.add(textField_3);
		textField_3.setText(company.toString());
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(540, 130, 159, 20);
		panel.add(textField_4);
		textField_4.setText(price.toString());
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(156, 198, 184, 20);
		panel.add(textField_5);
		textField_5.setText(ImagePath.toString());
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(156, 276, 389, 20);
		panel.add(textField_7);
		textField_7.setText(Description.toString());
		
		JLabel lblNewLabel_1 = new JLabel(admin_ID.toString());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(540, 201, 159, 13);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(614, 275, 85, 21);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Check_info())
				{
					try
					{
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/chs","root","");
						Statement stmt = con.createStatement();
						String sql = "UPDATE product SET Product_Name = '"+product_name+"', Price = "+price+", Category = '"+category+"', "
								+"Company = '"+company+"', Description = '"+Description+"', Admin_ID = '"+ADMIN.getID()+"', ImagePath = '"
								+ImagePath+"' WHERE Product_ID = '"+ID+"'";
								
						PreparedStatement posted = con.prepareStatement(sql);
						
						posted.executeUpdate();	
						
						JOptionPane.showMessageDialog(null, "Updated Successfully!!");
						
						try {
							AdminPage Awindow = new AdminPage(ADMIN);
							Awindow.frame.setVisible(true);
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
	}
	
	private boolean Check_info()
	{
		/**
		 * Function to check input information form text fields.
		 */
		if(textField.getText().trim().equals(""))
		{
			textField.setText(product_name.toString());
			JOptionPane.showMessageDialog(frame,"Enter a valid product name!");
			return false;
		}
		else
		{
			product_name = textField.getText();
		}
		
		if(textField_1.getText().trim().equals(""))
		{
			textField_1.setText(company.toString());
			JOptionPane.showMessageDialog(frame,"Enter a valid company name!");
			return false;
		}
		else
		{
			company = textField_1.getText();
		}
		
		if(textField_2.getText().trim().equals(""))
		{
			textField_2.setText(category.toString());
			JOptionPane.showMessageDialog(frame,"Enter a valid category!");
			return false;
		}
		else
		{
			category = textField_2.getText();
		}
		
		if(textField_5.getText().matches("^[A-Za-z]:\\\\\\\\\\\\\\\\(?:[^\\\\\\\\\\\\\\\\/:*?\\\\\\\"<>|\\\\\\\\r\\\\\\\\n]+\\\\\\\\\\\\\\\\)*[^\\\\\\\\\\\\\\\\/:*?\\\\\\\"<>|\\\\\\\\r\\\\\\\\n]*$"))
		{
			ImagePath = textField_5.getText();
		}
		else
		{
			textField_5.setText(ImagePath.toString());
			JOptionPane.showMessageDialog(frame,"Enter a valid Image Path!");
			return false;
		}
		
		try
		{
		   price = Double.parseDouble(textField_4.getText());
		}
		catch(NumberFormatException e)
		{
			textField_4.setText(price.toString());
			JOptionPane.showMessageDialog(frame,"The text you entered is not a valid float!");
			return false;
		}
		
		if(textField_7.getText().trim().equals(""))
		{
			textField_7.setText(Description.toString());
			JOptionPane.showMessageDialog(frame,"Enter a valid Description!");
			return false;
		}
		else
		{
			Description = textField_7.getText();
		}
		
		return true;
	}
}

