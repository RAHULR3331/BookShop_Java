package Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JRadioButton customerRadioButton;
    private JRadioButton adminRadioButton;

    // Connection parameters for database
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
   // private static final String USERNAME = "your_username";
    //private static final String PASSWORD = "your_password";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUp window = new SignUp();
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
    public SignUp() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 867, 663);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(153, 204, 255));
        panel.setBounds(-11, -36, 885, 113);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("BookStacker");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
        lblNewLabel.setBounds(10, 54, 222, 49);
        panel.add(lblNewLabel);

        ButtonGroup group = new ButtonGroup();
        
                JPanel panel_2 = new JPanel();
                panel_2.setBounds(0, 75, 869, 551);
                frame.getContentPane().add(panel_2);
                panel_2.setBackground(new Color(204, 204, 255));
                panel_2.setLayout(null);
                
                        customerRadioButton = new JRadioButton("Customer");
                        customerRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
                        customerRadioButton.setBounds(132, 162, 165, 31);
                        panel_2.add(customerRadioButton);
                        
                                adminRadioButton = new JRadioButton("Admin");
                                adminRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
                                adminRadioButton.setBounds(132, 162, 165, 31);
                                panel_2.add(adminRadioButton);
                                group.add(customerRadioButton);
                                group.add(adminRadioButton);
                                
                                        JLabel lblNewLabel_2 = new JLabel("Name:");
                                        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                        lblNewLabel_2.setBounds(379, 93, 72, 31);
                                        panel_2.add(lblNewLabel_2);
                                        
                                        JLabel lblNewLabel_3 = new JLabel("Address:");
                                        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                        lblNewLabel_3.setBounds(379, 135, 72, 31);
                                        panel_2.add(lblNewLabel_3);
                                        
                                        JLabel lblNewLabel_4 = new JLabel("Contact No:");
                                        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                        lblNewLabel_4.setBounds(379, 176, 92, 31);
                                        panel_2.add(lblNewLabel_4);
                                        
                                        JLabel lblNewLabel_5 = new JLabel("Email:");
                                        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                        lblNewLabel_5.setBounds(379, 217, 92, 31);
                                        panel_2.add(lblNewLabel_5);
                                        
                                        JLabel lblNewLabel_6 = new JLabel("Password:");
                                        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                        lblNewLabel_6.setBounds(379, 258, 92, 31);
                                        panel_2.add(lblNewLabel_6);
                                        
                                        textField = new JTextField();
                                        textField.setBounds(474, 95, 299, 31);
                                        panel_2.add(textField);
                                        textField.setColumns(10);
                                        
                                        textField_1 = new JTextField();
                                        textField_1.setBounds(474, 137, 299, 31);
                                        panel_2.add(textField_1);
                                        textField_1.setColumns(10);
                                        
                                        textField_2 = new JTextField();
                                        textField_2.setBounds(474, 178, 299, 31);
                                        panel_2.add(textField_2);
                                        textField_2.setColumns(10);
                                        
                                        textField_3 = new JTextField();
                                        textField_3.setBounds(474, 219, 299, 31);
                                        panel_2.add(textField_3);
                                        textField_3.setColumns(10);
                                        
                                        textField_4 = new JTextField();
                                        textField_4.setBounds(474, 260, 299, 31);
                                        panel_2.add(textField_4);
                                        textField_4.setColumns(10);
                                        
                                        
                                                JButton registerbutton = new JButton("REGISTER");
                                                registerbutton.setBackground(new Color(255, 255, 255));
                                                registerbutton.addActionListener(new ActionListener() {
                                                    public void actionPerformed(ActionEvent e) {
                                                        // Call method to save data to the database based on the selected radio button
                                                        if (customerRadioButton.isSelected()) {
                                                            try {
					                                             	saveDataToCustomerTable();
					                                             } catch (ClassNotFoundException e1) {
					                                             	// TODO Auto-generated catch block
					                                             	e1.printStackTrace();
					                                             }
                                                        } else if (adminRadioButton.isSelected()) {
                                                            saveDataToAdminTable();
                                                        } else {
                                                            JOptionPane.showMessageDialog(frame, "Please select user type (Customer/Admin).");
                                                        }
                                                    }
                                                });
                                                registerbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
                                                registerbutton.setBounds(514, 382, 148, 38);
                                                panel_2.add(registerbutton);
                                                
                                                        JButton gobackbutton = new JButton(" Back to home");
                                                        gobackbutton.setForeground(new Color(128, 0, 64));
                                                        gobackbutton.setFont(new Font("Tahoma", Font.PLAIN, 12));
                                                        gobackbutton.setBounds(493, 459, 191, 31);
                                                        panel_2.add(gobackbutton);
                                                        
                                                                JLabel lblNewLabel_1 = new JLabel("SIGN UP");
                                                                lblNewLabel_1.setBounds(130, 108, 124, 32);
                                                                panel_2.add(lblNewLabel_1);
                                                                lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 32));
                                                                
                                                                JLabel lblNewLabel_7 = new JLabel("");
                                                                lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\book22.jpg"));
                                                                lblNewLabel_7.setBounds(110, 37, 957, 565);
                                                                panel_2.add(lblNewLabel_7);
                                                        
                                                        JPanel panel_1 = new JPanel();
                                                        panel_1.setBackground(new Color(255, 255, 255));
                                                        panel_1.setBounds(0, 0, 113, 626);
                                                        frame.getContentPane().add(panel_1);
                                                        
                                                        JPanel panel_3 = new JPanel();
                                                        panel_3.setBackground(new Color(255, 255, 255));
                                                        panel_3.setBounds(113, 125, 746, 54);
                                                        frame.getContentPane().add(panel_3);
        gobackbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard page
                DashBoard dashboard = new DashBoard();
                DashBoard.main(null);
                frame.dispose(); // Close the current sign-up window
            }
        });
    }

    // Method to save data to customer table
    private void saveDataToCustomerTable() throws ClassNotFoundException {
        String name = textField.getText();
        String address = textField_1.getText();
        String contactNo = textField_2.getText();
        String email = textField_3.getText();
        String password = textField_4.getText();

        try 
        
        {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","msc","msc");
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Customer1 (name, address, contactNo, email, password) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, contactNo);
            stmt.setString(4, email);
            stmt.setString(5, password);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(frame, "Customer registered successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Failed to register customer.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
        }
    }

    // Method to save data to admin table
 // Method to save data to admin table
    private void saveDataToAdminTable() {
        String name = textField.getText();
        String address = textField_1.getText();
        String contactNo = textField_2.getText();
        String email = textField_3.getText();
        String password = textField_4.getText();

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection to the database
            try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "msc", "msc")) {
                PreparedStatement stmt = con.prepareStatement("INSERT INTO Admin (name, address, contactNo, email, password) VALUES (?, ?, ?, ?, ?)");

                stmt.setString(1, name);
                stmt.setString(2, address);
                stmt.setString(3, contactNo);
                stmt.setString(4, email);
                stmt.setString(5, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(frame, "Admin registered successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Failed to register admin.");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(); // Print exception stack trace
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
}
}
}