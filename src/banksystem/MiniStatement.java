package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener
{
    String formno, pinnumber;
    JButton back;

    MiniStatement(String formno, String pinnumber) 
    {
        setTitle("Mini Statement");
        setLayout(null);

        this.formno = formno;
        this.pinnumber = pinnumber;

        JLabel bank = new JLabel("Central Bank");
        bank.setBounds(180, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(20, 120, 300, 20);
        add(dateLabel);

        JLabel typeLabel = new JLabel("Type");
        typeLabel.setBounds(150, 120, 300, 20);
        add(typeLabel);
        
        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(245, 120, 300, 20);
        add(amountLabel);

        JLabel balanceLabel = new JLabel("Balance");
        balanceLabel.setBounds(321, 120, 300, 20);
        add(balanceLabel);

        JTextArea mini = new JTextArea();
        mini.setTabSize(7);
        mini.setEditable(false);

    // Wrap the JTextArea in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(mini);
        scrollPane.setBounds(20, 140, 395, 400); 
        add(scrollPane);

        back = new JButton("Back");
        back.setBounds(264, 550, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(450, 650);
        setLocation(300, 0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE formno = '" + formno + "'");
            if (rs.next()) 
            {
                card.setText("Card Number: XXXX-XXXX-XXXX-" + rs.getString("cnumber").substring(15));
            } 
            else 
            {
                card.setText("No records available");
            }
        } 
        catch (Exception e) 
        {
            System.out.print(e);
        }

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE formno = '" + formno + "'");
            while (rs.next()) 
            {
                String date = rs.getString("date").substring(0, 19);
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                Integer runningBalance = rs.getInt("runningBalance");

            // How the individual strings are formatted to align with the table
                String formattedText = date + "      " + type + "\t" + amount + "\t" + runningBalance + "\n";

                mini.append(formattedText);
            }
        } 
        catch (Exception e) 
        {
            System.out.print(e);
        }

    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(formno, pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) 
    {
        new MiniStatement("", "");
    }
}

