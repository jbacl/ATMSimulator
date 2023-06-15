package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;



public class Deposit extends JFrame implements ActionListener
{
    String pinnumber;
    JButton deposit, back;
    JTextField amount;

    Deposit(String pinnumber)
    {
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/imgs/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 1024, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1024, 1024);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setBounds(170, 175, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 225, 320, 20);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(353, 373, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(353, 415, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == deposit)
        {
            String number = amount.getText();
            LocalDateTime now = LocalDateTime.now();
            if (number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Error: Enter a 'Deposit' amount");
            }
            else
            {
                try
                {
                    Conn c = new Conn();
                    String query = "INSERT INTO bank values('"+pinnumber+"', '"+now+"', 'Deposit', '"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, number+" deposited succesfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Deposit("");
    }
}
