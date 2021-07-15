import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Market {

	JFrame frame;
	static Market window;
	static ShoppingCart sC;
	static Customer cS;
	private Product pr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Market(cS, sC);
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
	public Market(Customer cs, ShoppingCart sc) {
		sC = sc;
		cS = cs;
		pr = new Product();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 950, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(152, 49, 589, 374);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CPU_1");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/* Create Product Object */
				pr.setID("25e66fc4-cf67-4ec8-9f06-5cc1f096c35e");
				pr.setCat("CPUs");
				pr.setCompany("Intel");
				pr.setDes("Sate-of-the-art Cpu That is capable of speed processing");
				pr.setName("Intel core-i7");
				pr.setPrice(225.5);
				pr.setImagePath("C:\\أشيائي\\هرى\\Java-Workspace\\ProjectBeta\\src\\images\\CPU_INTEL.jpg");
				
				try {
					ProductPage Pwindow = new ProductPage(cS, pr, sC);
					Pwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("C:\\\u0623\u0634\u064A\u0627\u0626\u064A\\\u0647\u0631\u0649\\Java-Workspace\\ProjectBeta\\src\\images\\CPU_INTEL.jpg"));
		lblNewLabel_2.setBounds(31, 10, 110, 90);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPU- Core-i7");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(31, 118, 109, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("CPU_2");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\\u0623\u0634\u064A\u0627\u0626\u064A\\\u0647\u0631\u0649\\Java-Workspace\\ProjectBeta\\src\\images\\CPU-CORE-i9.jpg"));
		lblNewLabel_2_1.setBounds(214, 10, 110, 90);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Keyboard_1");
		lblNewLabel_2_2.setIcon(new ImageIcon("C:\\\u0623\u0634\u064A\u0627\u0626\u064A\\\u0647\u0631\u0649\\Java-Workspace\\ProjectBeta\\src\\images\\keyboard_1.jpg"));
		lblNewLabel_2_2.setBounds(389, 10, 110, 90);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Mouse_1");
		lblNewLabel_2_3.setIcon(new ImageIcon("C:\\\u0623\u0634\u064A\u0627\u0626\u064A\\\u0647\u0631\u0649\\Java-Workspace\\ProjectBeta\\src\\images\\mouse_1.jpg"));
		lblNewLabel_2_3.setBounds(31, 203, 110, 90);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Monitor_2");
		lblNewLabel_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pr.setID("0da3fe43-657f-44b5-91bd-1f49b3e837fd");
				pr.setCat("Monitors");
				pr.setCompany("Apple");
				pr.setDes("14-inch Screen, 4K resolution");
				pr.setName("Monitor_1");
				pr.setPrice(1500);
				pr.setImagePath("C:\\أشيائي\\هرى\\Java-Workspace\\ProjectBeta\\src\\images\\Monitor_2.jpg");
				try {
					ProductPage Pwindow = new ProductPage(cS, pr, sC);
					Pwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		lblNewLabel_2_4.setIcon(new ImageIcon("C:\\\u0623\u0634\u064A\u0627\u0626\u064A\\\u0647\u0631\u0649\\Java-Workspace\\ProjectBeta\\src\\images\\Monitor_2.jpg"));
		lblNewLabel_2_4.setBounds(214, 203, 110, 90);
		panel.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("GPU_1");
		lblNewLabel_2_5.setIcon(new ImageIcon("C:\\\u0623\u0634\u064A\u0627\u0626\u064A\\\u0647\u0631\u0649\\Java-Workspace\\ProjectBeta\\src\\images\\gpu_1.jpg"));
		lblNewLabel_2_5.setBounds(389, 203, 110, 90);
		panel.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("CPU- Core-i9");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(214, 118, 109, 13);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Keyboard_1");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(389, 118, 109, 13);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mouse_1");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(31, 319, 109, 13);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Monitor_2");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_4.setBounds(214, 319, 109, 13);
		panel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("GPU_1");
		lblNewLabel_3_5.setLabelFor(lblNewLabel_2_5);
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_3_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_5.setBounds(389, 319, 109, 13);
		panel.add(lblNewLabel_3_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "CPUs", "Monitors", "Keyboards"}));
		comboBox.setBounds(34, 124, 95, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Dell", "HP", "Apple", "Intel"}));
		comboBox_1.setBounds(34, 330, 95, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Company :");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 297, 63, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Categories :");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 92, 85, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Profile Pwindow = new Profile(cS, sC);
					Pwindow.frame.setVisible(true);
					frame.setVisible(false);
					
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(802, 24, 100, 20);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("ShoppingCart");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					CartPage Cwindow = new CartPage(cS, sC);
					Cwindow.frame.setVisible(true);
					frame.setVisible(false);
				} catch (Exception R) {
					R.printStackTrace();
				}
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("C:\\أشيائي\\هرى\\Java-Workspace\\ProjectBeta\\src\\images\\shoppingcart.png"));
		lblNewLabel_4.setBounds(761, 139, 153, 120);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("+ "+Integer.valueOf(sC.getLength()));
		lblNewLabel_5.setLabelFor(lblNewLabel_4);
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(761, 285, 153, 43);
		frame.getContentPane().add(lblNewLabel_5);
	
	}
}
