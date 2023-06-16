package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.*;

public class FastCash extends JFrame implements ActionListener
{
    JButton amount1, amount2, amount3, amount4, amount5, amount6, back;
    String pinnumber, formno;

    FastCash(String formno, String pinnumber)
    {
        this.formno = formno;
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("src/imgs/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1024, 1024, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1024, 1024);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(235, 175, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        amount1 = new JButton("$20");
        amount1.setBounds(150, 283, 150, 30);
        amount1.addActionListener(this);
        image.add(amount1);

        amount2 = new JButton("$50");
        amount2.setBounds(353, 283, 150, 30);
        amount2.addActionListener(this);
        image.add(amount2);

        amount3 = new JButton("$100");
        amount3.setBounds(150, 328, 150, 30);
        amount3.addActionListener(this);
        image.add(amount3);

        amount4 = new JButton("$500");
        amount4.setBounds(353, 328, 150, 30);
        amount4.addActionListener(this);
        image.add(amount4);

        amount5 = new JButton("$1000");
        amount5.setBounds(150, 373, 150, 30);
        amount5.addActionListener(this);
        image.add(amount5);

        amount6 = new JButton("$2000");
        amount6.setBounds(353, 373, 150, 30);
        amount6.addActionListener(this);
        image.add(amount6);

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
        if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(formno, pinnumber).setVisible(true);
        }
        else
        {
            String amount = ((JButton)ae.getSource()).getText().substring(1);
            Conn c = new Conn();
            LocalDateTime now = LocalDateTime.now();
            try
            {
                // Retrieve the current runningBalance from the database
                    String getBalanceQuery = "SELECT runningBalance FROM bank WHERE formno = '" + formno + "'";
                    ResultSet rs = c.s.executeQuery(getBalanceQuery);
                
                    int runningBalance = 0;
                    if (rs.next()) 
                    {
                        runningBalance = rs.getInt("runningBalance");
                    }
                
                // Calculate the new balance by subtracting the fastcash withdraw amount
                    int withdrawalAmount = Integer.parseInt(amount);

                    if (withdrawalAmount > runningBalance)
                    {
                        JOptionPane.showMessageDialog(null, "Error: Insufficient Funds in Account");
                    }
                    else
                    {
                        int newBalance = runningBalance - withdrawalAmount;
                
                // Update the runningBalance in the database
                        String updateBalanceQuery = "UPDATE bank SET runningBalance = '" + newBalance + "' WHERE formno = '" + formno + "'";
                        c.s.executeUpdate(updateBalanceQuery);
                
                // Insert the deposit transaction into the database
                        String insertTransactionQuery = "INSERT INTO bank VALUES ('" + formno + "','" + pinnumber + "', '" + now + "', 'Withdrawal', '" + amount + "', '" + newBalance + "')";
                        c.s.executeUpdate(insertTransactionQuery);
                
                        JOptionPane.showMessageDialog(null, amount + " withdrew successfully");
                        setVisible(false);
                        new Transactions(formno, pinnumber).setVisible(true);
                
                        rs.close();
                    }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[])
    {
        new FastCash("","");
    }
}
