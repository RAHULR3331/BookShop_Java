package Book;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ParameterMetaData;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
public class Booking {

    private JFrame frame;
    private JTable table;
    private JTextField txtid;
    private JTextField txtname;
    private JTextField txttype;
    private JTextField txtcategory;
    private JTextField txtdesc;
    private JTextField txtprice;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Booking window = new Booking();
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
    public Booking() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 70, 1036, 669);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        
        
       
        JButton btnNewButton_2 = new JButton("Order Now");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Order Placed Successfully ");
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_2.setBounds(415, 501, 192, 45);
        panel_1.add(btnNewButton_2);

        
        

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(110, 30, 795, 222);
        panel_1.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                if (selectedRowIndex != -1) { // Check if a row is selected
                    // Get data from the selected row
                    String id = dtm.getValueAt(selectedRowIndex, 0).toString();
                    String name = dtm.getValueAt(selectedRowIndex, 1).toString();
                    String type = dtm.getValueAt(selectedRowIndex, 2).toString();
                    String category = dtm.getValueAt(selectedRowIndex, 3).toString();
                    String desc = dtm.getValueAt(selectedRowIndex, 4).toString();
                    String price = dtm.getValueAt(selectedRowIndex, 5).toString();

                    // Set the data to the text fields
                    txtid.setText(id);
                    txtname.setText(name);
                    txttype.setText(type);
                    txtcategory.setText(category);
                    txtdesc.setText(desc);
                    txtprice.setText(price);
                }
            }
        });

        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"Book_Id", "Book_Name", "Book_Type", "Book_Category", "Book_Description", "Book_Price"
        	}
        ));
        scrollPane.setViewportView(table);

        JButton btnNewButton_5 = new JButton("SHOW BOOK DETAILS");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc", "msc");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from Book");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    con.close();

                } catch (Exception c) {
                    System.out.println(c);
                }
            }
        });
        btnNewButton_5.setFont(new Font("SimSun", Font.BOLD, 15));
        btnNewButton_5.setBounds(697, 262, 208, 33);
        panel_1.add(btnNewButton_5);

        JLabel lblNewLabel_1 = new JLabel("Book Id");
        lblNewLabel_1.setForeground(new Color(204, 153, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(48, 375, 87, 24);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Book Name");
        lblNewLabel_2.setForeground(new Color(204, 204, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(384, 375, 102, 25);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Book Type");
        lblNewLabel_3.setForeground(new Color(204, 204, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_3.setBounds(683, 379, 94, 24);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Book Category");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(48, 434, 129, 24);
        panel_1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Description");
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(384, 434, 114, 25);
        panel_1.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Price");
        lblNewLabel_6.setForeground(new Color(204, 204, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setBounds(683, 434, 87, 24);
        panel_1.add(lblNewLabel_6);

        txtid = new JTextField();
        txtid.setBounds(187, 381, 157, 22);
        panel_1.add(txtid);
        txtid.setColumns(10);

        txtname = new JTextField();
        txtname.setColumns(10);
        txtname.setBounds(496, 379, 157, 22);
        panel_1.add(txtname);

        txttype = new JTextField();
        txttype.setColumns(10);
        txttype.setBounds(787, 379, 157, 24);
        panel_1.add(txttype);

        txtcategory = new JTextField();
        txtcategory.setColumns(10);
        txtcategory.setBounds(187, 440, 157, 22);
        panel_1.add(txtcategory);

        txtdesc = new JTextField();
        txtdesc.setColumns(10);
        txtdesc.setBounds(496, 440, 157, 22);
        panel_1.add(txtdesc);

        txtprice = new JTextField();
        txtprice.setColumns(10);
        txtprice.setBounds(787, 434, 157, 24);
        panel_1.add(txtprice);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\bookstore.jpg"));
        lblNewLabel.setBounds(0, 0, 1036, 659);
        panel_1.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(153, 204, 255));
        panel.setBounds(0, -32, 1036, 101);
        frame.getContentPane().add(panel);
        
        JButton btnNewButton_1 = new JButton("Dashbord");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard page
                DashBoard dashboard = new DashBoard();
                dashboard.main(null);
                frame.dispose(); // Close the login window
            }
        });
        btnNewButton_1.setForeground(new Color(0, 51, 102));
        btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
        btnNewButton_1.setBackground(new Color(255, 204, 153));
        btnNewButton_1.setBounds(876, 32, 160, 29);
        panel.add(btnNewButton_1);
        
        JLabel lblNewLabel_7 = new JLabel("BookStacker");
        lblNewLabel_7.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
        lblNewLabel_7.setBounds(0, 52, 228, 49);
        panel.add(lblNewLabel_7);
        frame.setBounds(100, 100, 1054, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}