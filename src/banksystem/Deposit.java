package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;



public class Deposit extends JFrame implements ActionListener
{
    String pinnumber, formno;
    JButton deposit, back;
    JTextField amount;

    Deposit(String formno, String pinnumber)
    {
        this.formno = formno;
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
                // Retrieve the current runningBalance from the database
                    Conn c = new Conn();
                    String getBalanceQuery = "SELECT runningBalance FROM bank WHERE formno = '" + formno + "'";
                    ResultSet rs = c.s.executeQuery(getBalanceQuery);
                
                    int runningBalance = 0;
                    if (rs.next()) 
                    {
                        runningBalance = rs.getInt("runningBalance");
                    }
                
                // Calculate the new balance by adding the deposit amount
                    int depositAmount = Integer.parseInt(number);
                    int newBalance = runningBalance + depositAmount;
                
                // Update the runningBalance in the database
                    String updateBalanceQuery = "UPDATE bank SET runningBalance = '" + newBalance + "' WHERE formno = '" + formno + "'";
                    c.s.executeUpdate(updateBalanceQuery);
                
                // Insert the deposit transaction into the database
                    String insertTransactionQuery = "INSERT INTO bank VALUES ('" + formno + "','" + pinnumber + "', '" + now + "', 'Deposit', '" + number + "', '" + newBalance + "')";
                    c.s.executeUpdate(insertTransactionQuery);
                
                    JOptionPane.showMessageDialog(null, number + " deposited successfully");
                    setVisible(false);
                    new Transactions(formno, pinnumber).setVisible(true);
                
                    rs.close();
                } 
                catch (Exception e) 
                {
                    System.out.println(e);
                }
            }
        } 
    else if (ae.getSource() == back) 
    {
        setVisible(false);
        new Transactions(formno, pinnumber).setVisible(true);
    }
    }
}
