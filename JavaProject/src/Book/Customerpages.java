package Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

//import OnlineBakeryShop.viewBook;
//import Dashboardpackage.viewBook;

public class Customerpages {

    protected static final String OnlineBakeryShop = null;
	private JFrame frame;
    private Connection conn;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customerpages window = new Customerpages();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Customerpages() {
        initialize();
        connectToDatabase(); // Connect to the database when the customerPage object is created
    }

    private void connectToDatabase() {
        try {
            // Connect to your database
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1032, 624);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(102, 51, 51));
        panel_1.setBounds(-15, 70, 1055, 530);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("View All Books");
        btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 20));
        btnNewButton.setBounds(273, 417, 184, 55);
        panel_1.add(btnNewButton);
        
        // ActionListener for the "Show All Items" button
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    
                  jtableofcus jt = new jtableofcus();
                  jt.main(null);

                  frame.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });



        JButton btnNewButton_1 = new JButton("Make A Order");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
              
              Booking cus = new Booking();
              cus.main(null);
          }
        });
        btnNewButton_1.setFont(new Font("Segoe Script", Font.BOLD, 20));
        btnNewButton_1.setBounds(494, 419, 198, 50);
        panel_1.add(btnNewButton_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(37, 367, 152, 153);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\card1.jpeg"));
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\card 5.jpg"));
        lblNewLabel_1.setBounds(37, 27, 227, 316);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\card6.jpg"));
        lblNewLabel_3.setBounds(294, 27, 211, 316);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBackground(new Color(192, 192, 192));
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\card4.jpg"));
        lblNewLabel_4.setBounds(780, 27, 204, 316);
        panel_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImage\\card3.jpg"));
        lblNewLabel_6.setBounds(527, 27, 225, 316);
        panel_1.add(lblNewLabel_6);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, -42, 1040, 113);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(153, 204, 255));
        
        JButton btnNewButton_1_1 = new JButton("Go Back To Home");
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_1_1.setBackground(Color.RED);
        btnNewButton_1_1.setBounds(652, 0, 177, 27);
        panel_2.add(btnNewButton_1_1);
        
                JButton btnNewButton_2 = new JButton("Log Out");
                btnNewButton_2.setBounds(795, 66, 103, 37);
                panel_2.add(btnNewButton_2);
                btnNewButton_2.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		frame.dispose();
                	}
                });
                btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
                
                JLabel lblNewLabel_5 = new JLabel("");
                lblNewLabel_5.setBounds(727, 37, 72, 76);
                panel_2.add(lblNewLabel_5);
                lblNewLabel_5.setBackground(new Color(192, 192, 192));
                
                JLabel lblNewLabel = new JLabel("New label");
                lblNewLabel.setBounds(921, 31, 154, 126);
                panel_2.add(lblNewLabel);
                lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
                lblNewLabel.setEnabled(false);
                lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImages\\user.png"));
                
                JLabel lblNewLabel_7 = new JLabel("BookStacker");
                lblNewLabel_7.setFont(new Font("Monotype Corsiva", Font.BOLD, 45));
                lblNewLabel_7.setBounds(0, 64, 228, 49);
                panel_2.add(lblNewLabel_7);
}
}