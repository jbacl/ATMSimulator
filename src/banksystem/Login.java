package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

// Initialize Variables
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    String formno;

    Login() 
    {
    // Titles and headers -> text
        setTitle("ATM by Central Bank");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/imgs/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(100, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to Central Bank ATM!");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 40, 1000, 40);
        add(text);

    // Card No. -> text and input
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(193, 182, 250, 40);
        add(cardno);

        JLabel subtitle = new JLabel("XXXX-XXXX-XXXX-XXXX format");
        subtitle.setFont(new Font("Raleway", Font.ITALIC, 10));
        subtitle.setBounds(430, 220, 800,14);
        add(subtitle);

        cardTextField = new JTextField();
        cardTextField.setBounds(385, 190, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

    // Card Pin -> text and input  
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(310, 247, 140, 40);
        add(pin);
      
        pinTextField = new JPasswordField();
        pinTextField.setBounds(385, 255, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

    //  Login, clear, and signup -> buttons
        login = new JButton("Login");
        login.setBounds(385, 330, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(515, 330, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(385, 380, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

    // Trial Card Number and Pin -> text
        JLabel trial = new JLabel("Trial Card Number: 8266-1051-0257-8139");
        trial.setFont(new Font("Raleway", Font.BOLD, 13));
        trial.setBounds(18, 570, 750, 40);
        add(trial);

        JLabel trial2 = new JLabel("Trial Pin: 1234");
        trial2.setFont(new Font("Raleway", Font.BOLD, 13));
        trial2.setBounds(18, 600, 750, 40);
        add(trial2);
        

    // App size and color background
        getContentPane().setBackground(Color.WHITE);
        setSize(950, 680);
        setVisible(true);
        setLocation(350, 200);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == clear) 
        {
            cardTextField.setText("");
            pinTextField.setText("");
        } 
        else if (ae.getSource() == login) 
        {
            Conn c = new Conn();
            String cnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "SELECT * FROM login WHERE cnumber = '" +cnumber+ "' and pin = '" +pinnumber+ "'";
            try 
            {
                ResultSet result = c.s.executeQuery(query);
                if (result.next()) 
                {
                // Retrieve the formno from the database
                    String formno = result.getString("formno");

                    setVisible(false);
                    new Transactions(formno, pinnumber).setVisible(true);
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Error: Incorrect Card Number or Pin, try again");
                }
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        } 
        else if (ae.getSource() == signup) 
        {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }


    public static void main(String args[])
    {
        new Login();
    }
}