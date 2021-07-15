import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class CartPage {

	JFrame frame;
	static ShoppingCart sC;
	static Customer cS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartPage window = new CartPage(cS, sC);
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
	public CartPage(Customer cs, ShoppingCart sc) {
		sC = sc;
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
		
		JLabel lblNewLabel = new JLabel("Items :");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(134, 84, 67, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTotalPrise = new JLabel("Total Prise  :");
		lblTotalPrise.setForeground(new Color(0, 0, 128));
		lblTotalPrise.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotalPrise.setBounds(134, 381, 140, 24);
		frame.getContentPane().add(lblTotalPrise);
		
		JLabel lblNewLabel_2 = new JLabel(String.valueOf(sC.getTotal_price())+" L.E");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(284, 386, 140, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sC.getLength() != 0)
				{
					try {
						OrderPage window = new OrderPage(cS, sC);
						window.frame.setVisible(true);
						frame.setVisible(false);
					} catch (Exception R) {
						R.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Your cart is Empty!!");
				}
				
			}
		});
		btnCheckOut.setForeground(new Color(0, 128, 0));
		btnCheckOut.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCheckOut.setBounds(585, 400, 138, 36);
		frame.getContentPane().add(btnCheckOut);
		
		JButton btnNewButton_1 = new JButton("BackToMarket");
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
		btnNewButton_1.setBounds(10, 20, 138, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea(sC.printItems());
		textArea.setBackground(SystemColor.menu);
		textArea.setRows(10);
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textArea.setBounds(211, 79, 478, 257);
		frame.getContentPane().add(textArea);
	}
}
