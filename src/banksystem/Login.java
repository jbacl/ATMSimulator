package src.banksystem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

    // Initialize Variables
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

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

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(183, 162, 250, 40);
        add(cardno);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(300, 212, 150, 40);
        add(pin);

        login = new JButton("Login");
        login.setBounds(375, 310, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(505, 310, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign up");
        signup.setBounds(375, 360, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Input Boxes -> input(str)
        cardTextField = new JTextField();
        cardTextField.setBounds(375, 170, 250, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(375, 220, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // App size and color background
        getContentPane().setBackground(Color.WHITE);
        setSize(950, 680);
        setVisible(true);
        setLocation(350, 200);
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