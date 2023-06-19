package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame
{
    String formno, pinnumber;

    MiniStatement(String formno, String pinnumber)
    {
        setTitle("Mini Statement");
        setLayout(null);

        this.formno = formno;
        this.pinnumber = pinnumber;

        JLabel bank = new JLabel("Central Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, -130, 400, 1000);
        add(mini);

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login WHERE formno = '"+formno+"'");
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
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE formno = '"+formno+"'");
            while (rs.next())
            {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br>");
            }
        }
        catch (Exception e)
        {
            System.out.print(e);
        }
    }

    public static void main(String args[])
    {
        new MiniStatement("","");
    }
}
