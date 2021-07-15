import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ProductPage {

	JFrame frame;
	static ProductPage window;
	private static Product pr;
	private static ShoppingCart sC;
	private static Customer cS;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JButton btnRemovefromcart;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ProductPage(cS, pr, sC);
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
	public ProductPage(Customer cs, Product p, ShoppingCart sc) {
		sC = sc;
		pr = p;
		cS = cs;
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
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(164, 99, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(pr.getName());
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(269, 87, 98, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setForeground(new Color(0, 0, 128));
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCategory.setBounds(164, 174, 66, 13);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblCompany = new JLabel("Company :");
		lblCompany.setForeground(new Color(0, 0, 128));
		lblCompany.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCompany.setBounds(164, 262, 66, 13);
		frame.getContentPane().add(lblCompany);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(new Color(0, 0, 128));
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDescription.setBounds(164, 342, 78, 13);
		frame.getContentPane().add(lblDescription);
		
		JLabel lblPrise = new JLabel("Prise :");
		lblPrise.setForeground(new Color(0, 0, 128));
		lblPrise.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPrise.setBounds(164, 420, 78, 13);
		frame.getContentPane().add(lblPrise);
		
		JLabel lblNewLabel_1_1 = new JLabel(pr.getCat());
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(269, 164, 98, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(pr.getCompany());
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(269, 251, 98, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(pr.getDes());
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(252, 313, 382, 71);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel(String.valueOf(pr.getPrice())+" L.E");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(252, 410, 98, 36);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2 = new JLabel(pr.getName());
		lblNewLabel_2.setBounds(520, 85, 114, 103);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(pr.getImagePath()));
		
		btnNewButton_1 = new JButton("BackToMarket");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Market Mwindow = new Market(cS, sC);
					Mwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_1.setBounds(28, 30, 138, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(520, 260, 95, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity :");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(520, 237, 114, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		if(sC.SearchProduct(pr))
		{
			display_buttons();
		}
		else
		{
			btnNewButton = new JButton("AddToCart");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(checkQuan())
					{
						sC.AddItem(pr);
						try {
							Market Mwindow = new Market(cS, sC);
							Mwindow.frame.setVisible(true);
							frame.setVisible(false);
						} catch (Exception R) {
							R.printStackTrace();
						}
					}
				}
			});
			btnNewButton.setForeground(new Color(0, 128, 0));
			btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnNewButton.setBounds(442, 408, 168, 36);
			frame.getContentPane().add(btnNewButton);
		}
	}
	
	boolean checkQuan()
	{
		if(textField.getText().trim().equals("") || Integer.valueOf(textField.getText()) == null)
		{
			textField.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a Valid Integer Number!");
			return false;
		}
		else
		{
			pr.setQuan(Integer.valueOf(textField.getText()));
			return true;
		}
	}
	
	boolean checkQuan_update()
	{
		if(textField.getText().trim().equals("") || Integer.valueOf(textField.getText()) == null)
		{
			textField.setText("");
			JOptionPane.showMessageDialog(frame,"Enter a Valid Integer Number!");
			return false;
		}
		else
		{
			sC.UpdateQuantity(pr, Integer.valueOf(textField.getText()));
			return true;
		}
	}
	
	private void display_buttons()
	{
		//btnNewButton_1.setVisible(false);
		
		btnRemovefromcart = new JButton("RemoveFromCart");
		btnRemovefromcart.setForeground(Color.RED);
		btnRemovefromcart.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnRemovefromcart.setBounds(620, 410, 156, 36);
		btnRemovefromcart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sC.removeItem(pr);
				
				try {
					Market Mwindow = new Market(cS, sC);
					Mwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnRemovefromcart);
		
		btnNewButton_2 = new JButton("Update Quantity");
		btnNewButton_2.setForeground(new Color(0, 128, 0));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkQuan_update())
				{
					try {
						Market Mwindow = new Market(cS, sC);
						Mwindow.frame.setVisible(true);
						frame.setVisible(false);
					} catch (Exception R) {
						R.printStackTrace();
					}
				}
			}
		});
		btnNewButton_2.setBounds(429, 408, 174, 36);
		frame.getContentPane().add(btnNewButton_2);
	}
}
