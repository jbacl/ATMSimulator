package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

public class SignUpThree extends JFrame implements ActionListener
{
// Initialize variables for all classes
    JRadioButton r1, r2, r3, r4, r5, r6;
    JTextField pinTextField;
    ButtonGroup accountsgroup;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignUpThree(String formno)
    {
        this.formno = formno;
        setLayout(null);
// Account Details Title -> text
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 40, 400, 40);
        add(l1);

// Account Type -> text and buttons
        JLabel accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);

        r1 = new JRadioButton("Checkings");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        add(r1);

        r2 = new JRadioButton("Savings");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Certificate of Deposit");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Individual Retirement");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        r5 = new JRadioButton("Fixed Deposit");
        r5.setFont(new Font("Raleway", Font.BOLD, 16));
        r5.setBackground(Color.WHITE);
        r5.setBounds(600, 180, 250, 20);
        add(r5);

        r6 = new JRadioButton("Money Market");
        r6.setFont(new Font("Raleway", Font.BOLD, 16));
        r6.setBackground(Color.WHITE);
        r6.setBounds(600, 220, 250, 20);
        add(r6);

        accountsgroup = new ButtonGroup();
        accountsgroup.add(r1);
        accountsgroup.add(r2);
        accountsgroup.add(r3);
        accountsgroup.add(r4);
        accountsgroup.add(r5);
        accountsgroup.add(r6);

// Card Number -> text and input
        JLabel cardNum = new JLabel("Card Number:");
        cardNum.setFont(new Font("Raleway", Font.BOLD, 22));
        cardNum.setBounds(100, 300, 200, 30);
        add(cardNum);

        JLabel cnumber = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cnumber.setBounds(330, 300, 300, 30);
        add(cnumber);

        JLabel cnumberDetails = new JLabel("16 Digit Card Number");
        cnumberDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cnumberDetails.setBounds(100, 330, 300, 20);
        add(cnumberDetails);

        JLabel cnumberDetails2 = new JLabel("*** Card Number will be given once you click submit ***");
        cnumberDetails2.setFont(new Font("Raleway", Font.BOLD, 8));
        cnumberDetails2.setBounds(360, 320, 700, 20);
        add(cnumberDetails2);

// Pin Number -> text, input, and subtext
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(330, 370, 300, 30);
        add(pinTextField);

        JLabel pnumberDetails = new JLabel("Personal 4 Digit Code");
        pnumberDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pnumberDetails.setBounds(100, 400, 300, 20);
        add(pnumberDetails);

// Services -> text and checkBox
        JLabel services = new JLabel("Services Requested:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 450, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Cheque Book");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(100, 550, 200, 30);
        add(c2);

        c3 = new JCheckBox("Online Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(350, 500, 200, 30);
        add(c3);

        c4 = new JCheckBox("Mobile Banking");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Email Alerts");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(600, 500, 200, 30);
        add(c5);

        c6 = new JCheckBox("SMS Alerts");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(600, 550, 200, 30);
        add(c6);

// Agreement & Contract -> checkBox and text
        c7 = new JCheckBox("I hereby declare that the information provided is true and correct. I also understand");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 640, 700, 30);
        add(c7);

        JLabel agreement1 = new JLabel("that any willful dishonesty may render for refusal of this application or immediate");
        agreement1.setFont(new Font("Raleway", Font.BOLD, 16));
        agreement1.setBounds(120, 660, 700, 30);
        add(agreement1);

        JLabel agreement2 = new JLabel("termination in signing up with Central Bank.");
        agreement2.setFont(new Font("Raleway", Font.BOLD, 16));
        agreement2.setBounds(120, 680, 700, 30);
        add(agreement2);

// 'Submit' at the bottom -> button
        submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(460, 730, 100, 30);
        submit.addActionListener(this);
        add(submit);

// 'Cancel' at the bottom -> button
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.BLACK);
        cancel.setBackground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(260, 730, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

// App color and layout
        setSize(850, 820);
        setLocation(350, 0);
        getContentPane().setBackground(Color.WHITE);        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == submit)
        {
            String accountType = null;
            if (r1.isSelected())
            {
                accountType = "Checkings";
            }
            else if (r2.isSelected())
            {
                accountType = "Savings";
            }
            else if (r3.isSelected())
            {
                accountType = "Certificate of Deposit";
            }
            else if (r4.isSelected())
            {
                accountType = "Individual Retirement";
            }
            else if (r5.isSelected())
            {
                accountType = "Fixed Deposit";
            }
            else if (r6.isSelected())
            {
                accountType = "Money Market";
            }
            Random random = new Random();
            String cnumber = String.format("%04d-%04d-%04d-%04d", 
                             Math.abs(random.nextInt(10000)), 
                             Math.abs(random.nextInt(10000)), 
                             Math.abs(random.nextInt(10000)), 
                             Math.abs(random.nextInt(10000)));
            String pin = pinTextField.getText();
            List<String> services = new ArrayList<>();;
            if (r1.isSelected()) 
            {
                services.add("ATM Card");
            }

            if (r2.isSelected()) 
            {
                services.add("Cheque Book");
            }

            if (r3.isSelected()) 
            {
                services.add("Online Banking");
            }

            if (r4.isSelected()) 
            {
                services.add("Mobile Banking");
            }

            if (r5.isSelected()) 
            {
                services.add("Email Alerts");
            }

            if (r6.isSelected()) 
            {
                services.add("SMS Alerts");
            }
            String servicesString = String.join(", ", services);
            String agreement = null;
            {
                if (c7.isSelected() == true)
                {
                    agreement = "True";
                }
                else
                {
                    agreement = "False";
                }
            }
            try
                {   
// Error Message -> Account Type is not selected
                    if (accountType == null || accountType.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Error: Please select an Account Type");
                    }
// Error Message -> Agreement box is not checked                
                    if (c7.isSelected() != true)
                    {
                        JOptionPane.showMessageDialog(null, "Error: Please re-read the agreement and check the box");
                    }
// Error Message -> Pin code is not 4 digits
                    if (pin.length() != 4)
                    {               
                        JOptionPane.showMessageDialog(null, "Error: Pin number should be 4 numbers");
                    }
// Connects to local database and updates/inserts values then returns to login page
                    else
                    {
                        Conn conn = new Conn();
                        String query1 = "UPDATE signup SET accountType = '" + accountType + "', cardNumber = '" + cnumber + "', pinNumber = '" + pin + "', services = '" + servicesString + "', agreement = '" + agreement + "' WHERE formno = '" + formno + "'";
                        String query2 = "INSERT INTO login values('"+formno+"', '"+cnumber+"', '"+pin+"')";
                        
                        conn.s.executeUpdate(query1);
                        conn.s.executeUpdate(query2);
                        
                        setVisible(false);
                        new Login().setVisible(true);

                        JOptionPane.showMessageDialog(null, "Card Number: " + cnumber + "\n Pin: " + pin);
                    }
                }
            catch (Exception e) 
            {
                System.out.println(e);
            }

        }
// Cancel Button -> delete data from database and back to login
        else if (ae.getSource() == cancel)
        {
            try 
            {
                Conn conn = new Conn();
                String query3 = "DELETE FROM signup WHERE formno = '" + formno + "'";
                conn.s.executeUpdate(query3);

                setVisible(false);
                new Login().setVisible(true);
            } 
            catch (Exception e) 
            {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[])
    {
        new SignUpThree("");
    }
}
