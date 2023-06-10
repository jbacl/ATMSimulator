package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SignUpOne extends JFrame
{
    SignUpOne()
    {
        setLayout(null);

        // Info Details -> Text
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application form no. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(210, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(330, 80, 600, 40);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel Pname1 = new JLabel("Parental Guardian:");
        Pname1.setFont(new Font("Raleway", Font.BOLD, 20));
        Pname1.setBounds(100, 190, 300, 30);
        add(Pname1);

        JTextField Pname1TextField = new JTextField();
        Pname1TextField.setFont(new Font("Raleway", Font.BOLD, 14));
        Pname1TextField.setBounds(300, 190, 400, 30);
        add(Pname1TextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        // JTextField dobTextField = new JTextField();
        // dobTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        // dobTextField.setBounds(300, 240, 400, 30);
        // add(dobTextField);

        JLabel sex = new JLabel("Sex:");
        sex.setFont(new Font("Raleway", Font.BOLD, 20));
        sex.setBounds(100, 290, 200, 30);
        add(sex);

        // JTextField sexTextField = new JTextField();
        // sexTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        // sexTextField.setBounds(300, 290, 400, 30);
        // add(sexTextField);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        // JTextField maritalTextField = new JTextField();
        // maritalTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        // maritalTextField.setBounds(300, 390, 400, 30);
        // add(maritalTextField);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(330, 490, 200, 30);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(385, 490, 90, 30);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(500, 490, 200, 30);
        add(state);

        String[] states = {"", "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana",
        "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas",
        "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
        JComboBox dropdownMenu = new JComboBox<String>(states);
        dropdownMenu.setBounds(570, 490, 90, 30);
        add(dropdownMenu);
        dropdownMenu.setSelectedItem(null);
        // JTextField stateTextField = new JTextField();
        // stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        // stateTextField.setBounds(570, 490, 90, 30);
        // add(stateTextField);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);

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