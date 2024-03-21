package Book;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DashBoard {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DashBoard window = new DashBoard();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DashBoard() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 993, 638);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(0, 541, 979, 60);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBounds(0, 0, 979, 541);
        frame.getContentPane().add(panel_3);
        panel_3.setLayout(null);
        
        JButton signupbutton = new JButton("SIGN UP");
        signupbutton.setForeground(new Color(204, 153, 255));
        signupbutton.setBounds(369, 390, 183, 45);
        panel_3.add(signupbutton);
        signupbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SignUp signUpWindow = new SignUp();
                signUpWindow.main(null); // Show the sign-up window
                frame.dispose(); // Close the dashboard window
            }
        });
        signupbutton.setBackground(new Color(255, 204, 204));
        signupbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        
        JButton loginbutton = new JButton("LOGIN");
        loginbutton.setForeground(new Color(255, 204, 153));
        loginbutton.setBounds(379, 216, 159, 45);
        panel_3.add(loginbutton);
        loginbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	login loginWindow = new login();
                loginWindow.main(null); // Show the sign-up window
                frame.dispose(); // Close the dashboard window
            }
        });
        loginbutton.setBackground(new Color(255, 128, 128));
        loginbutton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Downloads\\books-1204029_1920.jpg"));
        lblNewLabel.setBounds(-1, 79, 1000, 452);
        panel_3.add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(51, 102, 102));
        panel.setBounds(-11, -24, 990, 106);
        panel_3.add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("BookStacker");
        lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 50));
        lblNewLabel_1.setBounds(375, 47, 261, 49);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(734, 201, 980, 111);
        panel_3.add(lblNewLabel_2);
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\RAHUL\\Desktop\\ProjectImages\\bookstore1.jpeg"));
}
}