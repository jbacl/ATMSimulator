package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{
    JButton deposit, withdrawal, fastcash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber, formno;

    Transactions(String formno, String pinnumber)
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

    // Title -> text
        JLabel text = new JLabel("Please select a transaction");
        text.setBounds(235, 175, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

    // All Transaction Options -> buttons
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 283, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(353, 283, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(150, 328, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(353, 328, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(150, 373, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(353, 373, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(353, 415, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == exit)
        {
            System.exit(0);
        }
        else if (ae.getSource() == deposit)
        {
            setVisible(false);
            new Deposit(formno, pinnumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawal)
        {
            setVisible(false);
            new Withdrawal(formno, pinnumber).setVisible(true);
        }
        else if (ae.getSource() == fastcash)
        {
            setVisible(false);
            new FastCash(formno, pinnumber).setVisible(true);
        }
        else if (ae.getSource() == pinChange)
        {
            setVisible(false);
            new PinChange(formno, pinnumber).setVisible(true);
        }
        else if (ae.getSource() == balanceEnquiry)
        {
            setVisible(false);
            new BalanceEnquiry(formno, pinnumber).setVisible(true);
        }
    }

    public static void main(String args[])
    {
        new Transactions("","");
    }
}
