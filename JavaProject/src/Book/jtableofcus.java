package Book;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

//import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;


public class jtableofcus {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jtableofcus window = new jtableofcus();
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
	public jtableofcus() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 786, 669);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 73, 762, 558);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 752, 300);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(153, 102, 51));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Book_Id", "Book_Name", "Book_Type", "Book_Category", "Book_Description", "Book_Price"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(0).setMinWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(182);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		
		JButton btnNewButton = new JButton("SHOW BooK  DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","msc","msc");
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from Book");
			     	table.setModel(DbUtils.resultSetToTableModel(rs));
					con.close();
					
				}	
				catch(Exception c)
				{
					System.out.println(c);
				}
			}
		});
		btnNewButton.setFont(new Font("Cambria", Font.BOLD, 15));
		btnNewButton.setBounds(258, 399, 230, 42);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back to login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customerpages lo=new Customerpages();
				lo.main(null);
				frame.dispose();
				}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(638, 467, 124, 32);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("BOOK LIST");
		lblNewLabel.setBounds(305, 10, 151, 23);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 28));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\bbbkkk.jpg"));
		lblNewLabel_1.setBounds(10, 10, 762, 558);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(153, 204, 255));
		panel_2.setBounds(0, -33, 1040, 96);
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton_1_1 = new JButton("Go Back To Home");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard page
                DashBoard dashboard = new DashBoard();
                DashBoard.main(null);
                frame.dispose(); // Close the current sign-up window
            }
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(new Color(0, 153, 153));
		btnNewButton_1_1.setBounds(599, 32, 177, 27);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("BookStacker");
		lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
		lblNewLabel_2.setBounds(0, 47, 228, 49);
		panel_2.add(lblNewLabel_2);
	}
}