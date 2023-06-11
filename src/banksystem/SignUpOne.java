package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame
{
    long random;
    JLabel formno, personalDetails, name, dob, email, pname1, sex, address, city, state, marital, pincode;
    JTextField nameTextField, pname1TextField, emailTextField, addressTextField, cityTextField, pincodeTextField;
    JRadioButton male, female, single, married, divorced, widow;
    ButtonGroup sexgroup, marriedgroup;
    JDateChooser dateChooser;
    JButton next;
    JComboBox dropdownMenu;

    SignUpOne()
    {
        setLayout(null);

        // Info Details -> title
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        formno = new JLabel("Application form no. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(210, 20, 600, 40);
        add(formno);

        // Personal Details -> subtitle
        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(330, 80, 600, 40);
        add(personalDetails);

        // Name -> text and input
        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        // Parental Guardian -> text and input
        pname1 = new JLabel("Parental Guardian:");
        pname1.setFont(new Font("Raleway", Font.BOLD, 20));
        pname1.setBounds(100, 190, 300, 30);
        add(pname1);

        pname1TextField = new JTextField();
        pname1TextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pname1TextField.setBounds(300, 190, 400, 30);
        add(pname1TextField);

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
        
        String[] states = {"", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
        "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
        "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        dropdownMenu = new JComboBox<String>(states);
        dropdownMenu.setBounds(570, 490, 90, 30);
        add(dropdownMenu);
        dropdownMenu.setSelectedItem(null);

        // Pincode -> text and input
        pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 540, 400, 30);
        add(pincodeTextField);
        
        // 'Next' at the bottom -> button
        next = new JButton("Next");
        next.setForeground(Color.BLACK);
        next.setBackground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 590, 80, 50);
        add(next);
        
        // App color and layout
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String args[])
    {
        new SignUpOne();
    }
}