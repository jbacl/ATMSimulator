package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener 
{
    String pinnumber, formno, currentBalance;
    JButton change, back;

    BalanceEnquiry(String formno, String pinnumber) 
    {
    // Background ATM Image
        this.formno = formno;
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/imgs/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 1024, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1024, 1024);
        add(image);

    // Back -> button
        back = new JButton("Back");
        back.setBounds(353, 415, 150, 30);
        back.addActionListener(this);
        image.add(back);

    // Account Balance -> text
        Conn c = new Conn();
        try 
        {
            String getBalanceQuery = "SELECT currentBalance FROM bank WHERE formno = '" + formno + "'";
            ResultSet rs = c.s.executeQuery(getBalanceQuery);

            if (rs.next()) 
            {
                int temp = rs.getInt("currentBalance");
                currentBalance = String.valueOf(temp);

                JLabel text = new JLabel("Current Account Balance:");
                text.setForeground(Color.WHITE);
                text.setFont(new Font("System", Font.BOLD, 16));
                text.setBounds(240, 180, 500, 35);
                image.add(text);

                JLabel subtext = new JLabel("$" + currentBalance);
                subtext.setForeground(Color.WHITE);
                subtext.setFont(new Font("System", Font.BOLD, 16));
                subtext.setBounds(315, 210, 500, 35);
                image.add(subtext);
            } 
            else 
            {
            // Handle the case when no balance is found for the given formno
                JLabel errorText = new JLabel("Error: Unable to retrieve account balance, try again");
                errorText.setForeground(Color.WHITE);
                errorText.setFont(new Font("System", Font.BOLD, 16));
                errorText.setBounds(135, 180, 500, 35);
                image.add(errorText);
            }

            rs.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }

        setSize(900, 900);
        setLocation(300, 0);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) 
    {   
        if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(formno, pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new BalanceEnquiry("", "");
    }
}

