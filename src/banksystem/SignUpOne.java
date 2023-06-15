package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.ResultSet;

public class SignUpOne extends JFrame implements ActionListener
{
    JLabel formno, personalDetails, fname, lname, dob, email, sex, marital, address, city, state, pnumber, race;
    JTextField fnameTextField, lnameTextField, emailTextField, addressTextField, cityTextField, pnumberTextField, raceTextField;
    JRadioButton male, female, single, married, divorced, widow;
    ButtonGroup sexgroup, marriedgroup;
    JDateChooser dateChooser;
    JButton next;
    JComboBox dropdownMenu, raceBox;

    SignUpOne()
    {
        setLayout(null);

// Info Details -> title
        formno = new JLabel("Official Application Form");
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(210, 20, 600, 40);
        add(formno);

// Personal Details -> subtitle
        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(330, 80, 600, 40);
        add(personalDetails);

// Name -> text and input
        fname = new JLabel("First Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 140, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 140, 400, 30);
        add(fnameTextField);

// Parental Guardian -> text and input
        lname = new JLabel("Last Name:");
        lname.setFont(new Font("Raleway", Font.BOLD, 20));
        lname.setBounds(100, 190, 300, 30);
        add(lname);

        lnameTextField = new JTextField();
        lnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        lnameTextField.setBounds(300, 190, 400, 30);
        add(lnameTextField);

// Date of Birth -> text and input
        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105, 105));
        add(dateChooser);

// Sex -> text and buttons
        sex = new JLabel("Sex:");
        sex.setFont(new Font("Raleway", Font.BOLD, 20));
        sex.setBounds(100, 290, 200, 30);
        add(sex);

        male = new JRadioButton("Male");
        male.setBounds(390, 290, 120, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(540, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        sexgroup = new ButtonGroup();
        sexgroup.add(male);
        sexgroup.add(female);

// Email -> text and input
        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

// Marital Status -> text and buttons
        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(310, 390, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);

        married = new JRadioButton("Married");
        married.setBounds(410, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        divorced = new JRadioButton("Divorced");
        divorced.setBounds(510, 390, 100, 30);
        divorced.setBackground(Color.WHITE);
        add(divorced);

        widow = new JRadioButton("Widow");
        widow.setBounds(610, 390, 100, 30);
        widow.setBackground(Color.WHITE);
        add(widow);

        marriedgroup = new ButtonGroup();
        marriedgroup.add(single);
        marriedgroup.add(married);
        marriedgroup.add(divorced);
        marriedgroup.add(widow);

// Address -> text and input
        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

// City -> text and input
        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(330, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(385, 490, 90, 30);
        add(cityTextField);

// States -> text and input
        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(500, 490, 200, 30);
        add(state);
        
        String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
        "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
        "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        dropdownMenu = new JComboBox<String>(states);
        dropdownMenu.setBounds(570, 490, 90, 30);
        add(dropdownMenu);
        dropdownMenu.setSelectedItem(null);

        // Phone Number -> text and input
        pnumber = new JLabel("Phone Number:");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(100, 540, 200, 30);
        add(pnumber);

        pnumberTextField = new JTextField();
        pnumberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pnumberTextField.setBounds(300, 540, 400, 30);
        add(pnumberTextField);

// Races -> text and input
        race = new JLabel("Race:");
        race.setFont(new Font("Raleway", Font.BOLD, 20));
        race.setBounds(100, 590, 200, 30);
        add(race);

        String[] races = {"American Indian or Alaskan Native", "Asian", "Black or African American", "Hispanic or Latino", "Native Hawaiian or Other Pacific Islander", "Two or More Races (Not Hispanic or Latino)", "White", "Not Specified"};
        raceBox = new JComboBox<String>(races);
        raceBox.setBounds(300, 590, 400, 30);
        add(raceBox);
        raceBox.setSelectedItem(null);
        
// 'Next' at the bottom -> button
        next = new JButton("Next");
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 640, 80, 50);
        next.addActionListener(this);
        add(next);
        
// App color and layout
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String formno = null;
        String fname = fnameTextField.getText();
        String lname = lnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String sex = null;
        if (male.isSelected())
        {
            sex = "Male";
        }
        else if (female.isSelected())
        {
            sex = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (single.isSelected())
        {
            marital = "Single";
        }
        else if (married.isSelected())
        {
            marital = "Married";
        }
        else if (divorced.isSelected())
        {
            marital = "Divorced";
        }
        else if (widow.isSelected())
        {
            marital = "Widow";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = dropdownMenu.getSelectedItem().toString();
        String pnumber = pnumberTextField.getText();
        String race = raceBox.getSelectedItem().toString();
        String religion = null;
        String occupation = null;
        String income = null;
        String education = null;
        String citizenship = null;
        String ssn = null;
        String dl = null;
        String sCitizen = null;
        String age = null;
        String eaccount = null;
        String accountType = null;
        String cardNumber = null;
        String pinNumber = null;
        String services = null;
        String agreement = null;

        try
        {
            if (fname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else
            {
// Figure out the max form number and increase the next form by one to avoid duplicates
                Conn c = new Conn();
                String getmaxFormnoQuery = "SELECT MAX(formno) FROM signup";
                ResultSet rs = c.s.executeQuery(getmaxFormnoQuery);
                int maxFormNo = 0;
                if (rs.next()) 
                {
                    maxFormNo = rs.getInt(1);
                }
                int tempformno = maxFormNo + 1;

                formno = "" + tempformno;

                String query = "INSERT INTO signup VALUES('"+formno+"', '"+fname+"', '"+lname+"', '"+dob+"', '"+sex+"','"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pnumber+"','"+race+"', '"+religion+"', '"+occupation+"', '"+income+"', '"+education+"', '"+citizenship+"','"+ssn+"', '"+dl+"', '"+sCitizen+"', '"+age+"', '"+eaccount+"','"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+services+"', '"+agreement+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String args[])
    {
        new SignUpOne();
    }
}