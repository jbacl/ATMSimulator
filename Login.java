import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

    JButton login, signup, clear;

    Login() 
    {
        setTitle("ATM by Central Bank");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to Central Bank ATM!");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 1000, 40);
        add(text);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(120, 140, 250, 40);
        add(cardno);

        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 250, 30);
        add(cardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(120, 210, 150, 40);
        add(pin);

        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(300, 210, 250, 30);
        add(pinTextField);

        JButton login = new JButton("Login");
        login.setBounds(300, 300, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        JButton clear = new JButton("Clear");
        clear.setBounds(430, 300, 120, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        JButton signup = new JButton("Sign up");
        signup.setBounds(300, 350, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(1000, 680);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == clear)
        {
        }
            else if (ae.getSource() == login)
            {

            }
            else if (ae.getSource() == signup)
            {

            }
        
    }

    public static void main(String args[])
    {
        new Login();
    }
}