import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUp {

        JFrame frame;
        JLabel l1,l2,l3,l4,l5,l6,l7,l8;
        JTextField tf1,tf2,tf3,tf4,tf5;
        JPasswordField pf1,pf2;
        JButton bt1,bt2;
        SignUp(){
            frame =new JFrame("Registration Form In java");
            frame.setLayout(null);
            frame.setSize(700,500);

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    frame.dispose();
                }
            });
            l1 = new JLabel("Registration Form in Windows Forms:");
            l1.setFont(new Font("serif",Font.BOLD,20));
            l2 = new JLabel("Name:");
            l3 = new JLabel("Email-ID:");
            l4 = new JLabel("Create Password:");
            l5 = new JLabel("Confirm Password:");
            l6 = new JLabel("Country:");
            l7 = new JLabel("State:");
            l8=new JLabel("Phone No:");
            tf1 = new JTextField();
            tf2   = new JTextField();
            tf3 = new JTextField();
            tf4 = new JTextField();
            tf5 = new JTextField();
            pf1 = new JPasswordField();
            pf2  = new JPasswordField();
            bt1 =  new JButton("Submit");
            bt2=new JButton("Clear");
            l1.setBounds(100,50,400,30);
            l2.setBounds(80,100,200,30);
            l3.setBounds(80,140,200,30);
            l4.setBounds(80,180,200,30);
            l5.setBounds(80,220,200,30);
            l6.setBounds(80,260,200,30);
            l7.setBounds(80,300,200,30);
            l8.setBounds(80,340,200,30);
            tf1.setBounds(300,100,200,30);
            tf2.setBounds(300,140,200,30);
            pf1.setBounds(300,180,200,30);
            pf2.setBounds(300,220,200,30);
            tf3.setBounds(300,260,200,30);
            tf4.setBounds(300,300,200,30);
            tf5.setBounds(300,340,200,30);
            bt1.setBounds(50,400,100,30);
            bt2.setBounds(170,400,100,30);
            frame.add(l1);
            frame.add(l2);
            frame.add(l3);
            frame.add(l4);
            frame.add(l5);
            frame.add(l6);
            frame.add(l7);
            frame.add(l8);

            frame.add(tf1);
            frame.add(tf2);
            frame.add(tf3);
            frame.add(tf4);
            frame.add(tf5);
            frame.add(pf1);
            frame.add(pf2);
            frame.add(bt1);
            frame.add(bt2);

            bt2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tf1.setText("");
                    tf2.setText("");
                    pf1.setText("");
                    pf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    tf5.setText("");
                }
            });

            bt1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String s1 = tf1.getText();
                    String s2=tf2.getText();
                    char []pwd1=pf1.getPassword();
                    String s3 = new String(pwd1);
                    char []pwd2=pf2.getPassword();
                    String s4 = new String(pwd2);
                    String s5 = tf3.getText();
                    String s6 = tf4.getText();
                    String s7 = tf5.getText();
                    if(s3.equals(s4))
                    {
                        if(s3.length()>0)
                        {
                            try
                            {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","Root@123");
                                PreparedStatement ps = con.prepareStatement("insert into userinfo values(?,?,?,?,?,?)");
                                ps.setString(1,s1);
                                ps.setString(2,s2);
                                ps.setString(3,s3);
                                ps.setString(4,s5);
                                ps.setString(5,s6);
                                ps.setString(6,s7);
                                ps.execute();
                                ps.close();
                                con.close();
                                JOptionPane.showMessageDialog(frame,"Data Saved Successfully!");
                                tf1.setText("");
                                tf2.setText("");
                                pf1.setText("");
                                pf2.setText("");
                                tf3.setText("");
                                tf4.setText("");
                                tf5.setText("");
                            }
                            catch(Exception obj)
                            {
                                System.out.println(obj);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(frame,"Please enter pwd");
                        }
                    }
                    else {
                        pf1.setText("");
                        pf2.setText("");
                        JOptionPane.showMessageDialog(frame,"Create pwd and " +
                                "confirm pwd are not same");
                    }
                }
            });
            frame.setVisible(true);
        }
    public static void main(String[] args) {
        new SignUp();
    }
}