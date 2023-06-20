package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PinChange  extends JFrame implements ActionListener
{
    String pinnumber, formno;
    JButton back, change;
    JPasswordField newpinTextField, pinTextField, renewpinTextField;

    PinChange(String formno, String pinnumber)
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

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(260, 150, 500, 35);
        image.add(text);

    // Old Password -> text and input
        JLabel pinText = new JLabel("Current Pin:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(170, 210, 180, 25);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("System", Font.PLAIN, 16));
        pinTextField.setBounds(355, 210, 160, 25);
        image.add(pinTextField);

    // New Pin Password -> text and input
        JLabel newpinText = new JLabel("New Pin:");
        newpinText.setForeground(Color.WHITE);
        newpinText.setFont(new Font("System", Font.BOLD, 16));
        newpinText.setBounds(170, 250, 180, 25);
        image.add(newpinText);
    
        newpinTextField = new JPasswordField();
        newpinTextField.setFont(new Font("System", Font.PLAIN, 16));
        newpinTextField.setBounds(355, 250, 160, 25);
        image.add(newpinTextField);
        
    // Re-Enter Password -> text and input
        JLabel renewpinText = new JLabel("Re-Enter New Pin:");
        renewpinText.setForeground(Color.WHITE);
        renewpinText.setFont(new Font("System", Font.BOLD, 16));
        renewpinText.setBounds(170, 290, 180, 25);
        image.add(renewpinText);

        renewpinTextField = new JPasswordField();
        renewpinTextField.setFont(new Font("System", Font.PLAIN, 16));
        renewpinTextField.setBounds(355, 290, 160, 25);
        image.add(renewpinTextField);

    // Change and Back -> buttons
        change = new JButton("Change");
        change.setBounds(353, 373, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(353, 415, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Transactions(formno, pinnumber).setVisible(true);
        }

        if(ae.getSource() == change)
        {
            boolean errorOccurred = false;
            try
            {
                Conn c = new Conn();
                String getCurrentPinQuery = "SELECT pin FROM login WHERE formno = '" + formno + "'";
                ResultSet rs = c.s.executeQuery(getCurrentPinQuery);

                String oldpin = pinTextField.getText();
                String newpin = newpinTextField.getText();
                String renewpin = renewpinTextField.getText();

            // Retrieves current pin from database
                String currentPin = "";
                if (rs.next()) 
                    {
                        currentPin = rs.getString("pin");
                    }
            // Error Message -> old and new pin matches with each other
                if (currentPin.equals(newpin))
                {
                    JOptionPane.showMessageDialog(null, "Error: Already used this pin number");
                    errorOccurred = true;
                }
            // Error Message -> current pin does not match with database
                else if (!currentPin.equals(oldpin))
                {
                    JOptionPane.showMessageDialog(null, "Error: Invalid current pin number");
                    errorOccurred = true;
                }

            // Error Message -> new pin is not 4 digits
                else if (newpin.length() != 4)
                {
                    JOptionPane.showMessageDialog(null, "Error: New Pin has to contain four digits");
                    errorOccurred = true;
                }

            // Error Message -> new pins don't match each other
                else if (!newpin.equals(renewpin))
                {
                    JOptionPane.showMessageDialog(null, "Error: Entered New Pin does not match");
                    errorOccurred = true;
                }
            // Update the pin in the database if no errors occurred
                else if (!errorOccurred) 
                {
                    String updatePinQuery = "UPDATE login SET pin = '" + newpin + "' WHERE formno = '" + formno + "'";
                    c.s.executeUpdate(updatePinQuery);
                    JOptionPane.showMessageDialog(null, "Pin number changed successfully");

                    setVisible(false);
                    new Transactions(formno, pinnumber).setVisible(true);
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
        new PinChange("","");
    }
}
