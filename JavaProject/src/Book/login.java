package Book;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 846, 539);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(102, 51, 51));
        panel_2.setBounds(-29, 60, 875, 455);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Customer");
        rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton.setBounds(52, 125, 125, 33);
        panel_2.add(rdbtnNewRadioButton);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Admin");
        rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rdbtnNewRadioButton_1.setBounds(52, 52, 125, 33);
        panel_2.add(rdbtnNewRadioButton_1);
        
        JLabel lblNewLabel_2 = new JLabel("Email:");
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_2.setBounds(238, 78, 96, 19);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setForeground(new Color(255, 0, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_3.setBounds(238, 132, 96, 19);
        panel_2.add(lblNewLabel_3);
        
        textField = new JTextField();
        textField.setBackground(new Color(255, 255, 204));
        textField.setBounds(344, 73, 235, 33);
        panel_2.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBackground(new Color(255, 255, 204));
        textField_1.setBounds(344, 127, 235, 33);
        panel_2.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btnNewButton = new JButton("Login");
        btnNewButton.setBackground(new Color(204, 204, 204));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(330, 230, 134, 39);
        panel_2.add(btnNewButton);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(285, 270, 2, 2);
        panel_2.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Downloads\\240_F_460710131_YkD6NsivdyYsHupNvO3Y8MPEwxTAhORh.jpg"));
        lblNewLabel.setBounds(238, -55, 386, 426);
        panel_2.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(153, 204, 255));
        panel.setBounds(0, -55, 859, 113);
        frame.getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("BookStacker");
        lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
        lblNewLabel_1.setBounds(0, 64, 226, 49);
        panel.add(lblNewLabel_1);
        
        JButton btnNewButton_1 = new JButton("Dashbord");
        btnNewButton_1.setBounds(674, 51, 160, 29);
        panel.add(btnNewButton_1);
        btnNewButton_1.setForeground(new Color(0, 51, 102));
        btnNewButton_1.setBackground(new Color(255, 0, 0));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Navigate back to the dashboard page
                DashBoard dashboard = new DashBoard();
                dashboard.main(null);
                frame.dispose(); // Close the login window
            }
        });
        btnNewButton_1.setFont(new Font("Sylfaen", Font.PLAIN, 15));

        // Action listener for the "Login" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = textField.getText();
                String password = textField_1.getText();
                if (rdbtnNewRadioButton.isSelected()) {
                    // If the "Customer" radio button is selected, validate against the Customer1 table
                    if (validateCustomer(email, password)) {
                        // Customer login successful
                        // Show success message
                        JOptionPane.showMessageDialog(frame, "Customer login successful!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                        btnNewButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // Navigate back to the dashboard page
                                Customerpages cus = new Customerpages();
                                cus.main(null);
                                frame.dispose(); // Close the login window
                            }
                        });
                       // frame.dispose(); // Close the login window
                    } else {
                        // Customer login failed
                        // Show error message
                        JOptionPane.showMessageDialog(frame, "Customer login failed!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (rdbtnNewRadioButton_1.isSelected()) {
                    // If the "Admin" radio button is selected, validate against the Admin table
                    if (validateAdmin(email, password)) {
                        // Admin login successful
                        // Show success message
                        JOptionPane.showMessageDialog(frame, "Admin login successful!", "Login Success", JOptionPane.INFORMATION_MESSAGE);
                        // Redirect to admin page
                        AdminPage adminPage = new AdminPage();
                        adminPage.main(null); // Show the admin page
                        frame.dispose(); // Close the login window
                    } else {
                        // Admin login failed
                        // Show error message
                        JOptionPane.showMessageDialog(frame, "Admin login failed!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // No radio button selected, handle this case
                    // Show error message
                    JOptionPane.showMessageDialog(frame, "Please select user type!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

 // Method to validate customer credentials
    private boolean validateCustomer(String email, String password) {
        // Implement your database connection and validation logic here
        // Modify the JDBC URL, username, and password as per your database setup
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "msc";
        String password1 = "msc";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password1)) {
            String sql = "SELECT * FROM Customer1 WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        return password.equals(storedPassword);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        
        return false;
    }

    // Method to validate admin credentials
    private boolean validateAdmin(String email, String password) {
        // Implement your database connection and validation logic here
        // Modify the JDBC URL, username, and password as per your database setup
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "msc";
        String password1 = "msc";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password1)) {
            String sql = "SELECT * FROM Admin WHERE email = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String storedPassword = resultSet.getString("password");
                        return password.equals(storedPassword);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        
        return false;
    }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}