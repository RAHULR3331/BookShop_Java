package Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
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
import javax.swing.ImageIcon;

public class AdminPage {

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
                    AdminPage window = new AdminPage();
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
    public AdminPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(192, 192, 192));
        panel_1.setBounds(10, 104, 1026, 519);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Add Book");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc",
                            "msc");
                    PreparedStatement pstmt = con.prepareStatement("INSERT INTO Book VALUES (?, ?, ?, ?, ?, ?)");

                    // Retrieve input values from text fields
                    String id = txtid.getText();
                    String name = txtname.getText();
                    String type = txttype.getText();
                    String category = txtcategory.getText();
                    String description = txtdesc.getText();

                    // Validate and parse price input
                    String priceString = txtprice.getText().trim();

                    // Convert string price to double
                    double price = Double.parseDouble(priceString);

                    pstmt.setString(1, id); // Assuming textField holds Book_Id
                    pstmt.setString(2, name); // Assuming textField_1 holds Book_Name
                    pstmt.setString(3, type); // Assuming textField_2 holds Book_Type
                    pstmt.setString(4, category); // Assuming textField_3 holds Book_Category
                    pstmt.setString(5, description); // Assuming textField_4 holds Book_Description
                    pstmt.setDouble(6, price); // Assuming textField_5 holds Book_Price as a number

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Value inserted");
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(79, 367, 157, 45);
        panel_1.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Delete Book");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc",
                            "msc");
                    Statement stmt = con.createStatement();
                    String id = txtid.getText();
                    String f = "delete from Book where Book_id='" + id + "' ";
                    stmt.executeUpdate(f);
                    JOptionPane.showMessageDialog(null, "Value deleted");

                } catch (Exception q) {
                    System.out.println(q);
                }

            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1.setBounds(454, 367, 157, 45);
        panel_1.add(btnNewButton_1);

        JButton btnNewButton_4 = new JButton("Edit Book Details");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = txtid.getText();
                String name = txtname.getText();
                String type = txttype.getText();
                String category = txtcategory.getText();
                String description = txtdesc.getText();
                String priceString = txtprice.getText().trim();

                DefaultTableModel dfm = (DefaultTableModel) table.getModel();
                dfm.setValueAt(id, table.getSelectedRow(), 0);
                dfm.setValueAt(name, table.getSelectedRow(), 1);
                dfm.setValueAt(type, table.getSelectedRow(), 2);
                dfm.setValueAt(category, table.getSelectedRow(), 3);
                dfm.setValueAt(description, table.getSelectedRow(), 4);
                dfm.setValueAt(priceString, table.getSelectedRow(), 5);

                Connection con = null;
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc", "msc");

                    String query = "UPDATE Book SET Book_ID = ?, Book_NAME = ?, Book_TYPE = ?, Book_CATEGORY = ?, Book_DESCRIPTION = ?, Book_PRICE = ? WHERE Book_NAME = ?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, id); 
                    pstmt.setString(2, name); 
                    pstmt.setString(3, type); 
                    pstmt.setString(4, category); 
                    pstmt.setString(5, description); 
                    pstmt.setString(6, priceString); 
                    pstmt.setString(7, name); 

                   
                    System.out.println("Query: " + pstmt.toString());

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Record updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "No records were updated!");
                    }
                } catch (SQLException ex) {
                    System.out.println("SQL Error: " + ex.getMessage());
                    ex.printStackTrace();
                } catch (Exception ex) {
                    System.out.println("Error updating record: " + ex.getMessage());
                    ex.printStackTrace();
                } finally {
                    if (con != null) {
                        try {
                            con.close();
                        } catch (SQLException ex) {
                            System.out.println("Error closing connection: " + ex.getMessage());
                        }
                    }
                }
            }

        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_4.setBounds(266, 367, 157, 45);
        panel_1.add(btnNewButton_4);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(444, 27, 544, 313);
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

        table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
                { null, null, null, null, null, null } },
                new String[] { "Book_Id", "Book_Name", "Book_Type", "Book_Category", "Book_Description", "Book_Price" }));
        scrollPane.setViewportView(table);

        JButton btnNewButton_5 = new JButton("Show Book Details");
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
        btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_5.setBounds(831, 350, 157, 45);
        panel_1.add(btnNewButton_5);

        JLabel lblNewLabel_1 = new JLabel("Book Id");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(30, 76, 114, 24);
        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Book name");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(30, 117, 114, 25);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Book type");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(30, 160, 114, 24);
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Category");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(30, 200, 114, 24);
        panel_1.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Description");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_5.setBounds(30, 246, 120, 25);
        panel_1.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Price");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(30, 287, 87, 24);
        panel_1.add(lblNewLabel_6);

        txtid = new JTextField();
        txtid.setBounds(175, 67, 157, 37);
        panel_1.add(txtid);
        txtid.setColumns(10);

        txtname = new JTextField();
        txtname.setColumns(10);
        txtname.setBounds(175, 114, 157, 32);
        panel_1.add(txtname);

        txttype = new JTextField();
        txttype.setColumns(10);
        txttype.setBounds(175, 156, 157, 32);
        panel_1.add(txttype);

        txtcategory = new JTextField();
        txtcategory.setColumns(10);
        txtcategory.setBounds(175, 198, 157, 30);
        panel_1.add(txtcategory);

        txtdesc = new JTextField();
        txtdesc.setColumns(10);
        txtdesc.setBounds(175, 238, 157, 37);
        panel_1.add(txtdesc);

        txtprice = new JTextField();
        txtprice.setColumns(10);
        txtprice.setBounds(175, 285, 157, 37);
        panel_1.add(txtprice);
        
                JButton btnNewButton_3 = new JButton("Log Out");
                btnNewButton_3.setBounds(237, 22, 95, 33);
                panel_1.add(btnNewButton_3);
                btnNewButton_3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                    }
                });
                btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
                
                JLabel lblNewLabel_7 = new JLabel("");
                lblNewLabel_7.setBounds(0, -3, 560, 503);
                panel_1.add(lblNewLabel_7);
                lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\bk.jpg"));
                
                JLabel lblNewLabel_8 = new JLabel("New label");
                lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\bkk.jpg"));
                lblNewLabel_8.setBounds(544, -3, 482, 512);
                panel_1.add(lblNewLabel_8);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(102, 204, 255));
        panel.setBounds(0, 0, 1036, 99);
        frame.getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("BookStacker");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
        lblNewLabel.setBounds(10, 54, 228, 49);
        panel.add(lblNewLabel);
        frame.setBounds(100, 100, 1055, 654);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}