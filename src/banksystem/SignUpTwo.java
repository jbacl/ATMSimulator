package src.banksystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener
{
    JLabel additionalDetails, religion, category, income, education, age, occupation, ssn, dl, sCitizen, eaccount, citizenship;
    JTextField religionTextField, occupationTextField, incomeTextField, educationTextField, categoryTextField, dlTextField, qualificationTextField, ssnTextField, eaccountTextField, citizenshipTextField;
    JRadioButton yes, no, yes2, no2, yes3, no3;
    ButtonGroup citizengroup, scitizengroup, eaccountgroup;
    JDateChooser dateChooser;
    JButton next;
    JComboBox religionBox, incomeBox, educationsBox, ageBox;
    String formno;

    SignUpTwo(String formno)
    {
        this.formno = formno;
        setLayout(null);

        // Info Details -> title
        setTitle("New Account Application Form - Page 2");

        // Personal Details -> subtitle
        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(330, 80, 600, 40);
        add(additionalDetails);

        // Religion -> text and input
        religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String religions[] = {"Christianity", "Islam", "Catholic", "Hinduism", "Buddhism", "Judaism", "Atheist", "Other"};
        religionBox = new JComboBox(religions);
        religionBox.setFont(new Font("Raleway", Font.BOLD, 14));
        religionBox.setBounds(300, 140, 400, 30);
        add(religionBox);
        religionBox.setSelectedItem(null);

        // Occupation -> text and input
        occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 190, 200, 30);
        add(occupation);

        occupationTextField = new JTextField();
        occupationTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationTextField.setBounds(300, 190, 400, 30);
        add(occupationTextField);

        // Income -> text and input
        income = new JLabel("Yearly Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String incomes[] = {"0", "10,000 - 20,000", "20,000 - 30,000", "30,000 - 40,000", "40,000 - 50,000", "50,000 - 60,000", "60,000 - 70,000", "70,000 - 80,000", "80,000 - 90,000", "90,000 - 100,000", "100,000< ", "Other"};
        incomeBox = new JComboBox(incomes);
        incomeBox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeBox.setBounds(300, 240, 400, 30);
        add(incomeBox);
        incomeBox.setSelectedItem(null);

        // Education -> text and buttons
        education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        String educations[] = {"High School/GED", "Undergraduate", "Associates", "Bachelors", "Masters", "Doctrate", "Other"};
        educationsBox = new JComboBox(educations);
        educationsBox.setFont(new Font("Raleway", Font.BOLD, 14));
        educationsBox.setBounds(300, 290, 400, 30);
        add(educationsBox);
        educationsBox.setSelectedItem(null);

        // Citizenship -> text and input
        citizenship = new JLabel("Are you a citizen?");
        citizenship.setFont(new Font("Raleway", Font.BOLD, 20));
        citizenship.setBounds(100, 340, 200, 30);
        add(citizenship);

        yes2 = new JRadioButton("Yes");
        yes2.setBounds(390, 340, 120, 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);

        no2 = new JRadioButton("No");
        no2.setBounds(540, 340, 120, 30);
        no2.setBackground(Color.WHITE);
        add(no2);

        citizengroup = new ButtonGroup();
        citizengroup.add(yes2);
        citizengroup.add(no2);

        // Address -> text and input
        ssn = new JLabel("Social Security:");
        ssn.setFont(new Font("Raleway", Font.BOLD, 20));
        ssn.setBounds(100, 390, 200, 30);
        add(ssn);

        ssnTextField = new JTextField();
        ssnTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        ssnTextField.setBounds(300, 390, 400, 30);
        add(ssnTextField);

        // Drivers License Number -> text and input
        dl = new JLabel("Drivers License:");
        dl.setFont(new Font("Raleway", Font.BOLD, 20));
        dl.setBounds(100, 440, 200, 30);
        add(dl);

        dlTextField = new JTextField();
        dlTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        dlTextField.setBounds(300, 440, 400, 30);
        add(dlTextField);

        // Senior Citizen -> text and input
        sCitizen = new JLabel("Senior citizen:");
        sCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        sCitizen.setBounds(100, 490, 200, 30);
        add(sCitizen);

        yes = new JRadioButton("Yes");
        yes.setBounds(390, 490, 120, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(540, 490, 120, 30);
        no.setBackground(Color.WHITE);
        add(no);

        scitizengroup = new ButtonGroup();
        scitizengroup.add(yes);
        scitizengroup.add(no);

        // Age -> text and input
        age = new JLabel("Age:");
        age.setFont(new Font("Raleway", Font.BOLD, 20));
        age.setBounds(100, 540, 200, 30);
        add(age);

        String ages[] = {">18", "18-24", "25-31", "32-45", "46-64", "65<", "No answer"};
        ageBox = new JComboBox(ages);
        ageBox.setFont(new Font("Raleway", Font.BOLD, 14));
        ageBox.setBounds(300, 540, 400, 30);
        add(ageBox);
        ageBox.setSelectedItem(null);

        // Exisiting Account -> text and input
        eaccount = new JLabel("Exisiting Account:");
        eaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        eaccount.setBounds(100, 590, 200, 30);
        add(eaccount);

        yes3 = new JRadioButton("Yes");
        yes3.setBounds(390, 590, 120, 30);
        yes3.setBackground(Color.WHITE);
        add(yes3);

        no3 = new JRadioButton("No");
        no3.setBounds(540, 590, 120, 30);
        no3.setBackground(Color.WHITE);
        add(no3);

        eaccountgroup = new ButtonGroup();
        eaccountgroup.add(yes3);
        eaccountgroup.add(no3);
        
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
        String religion = religionBox.getSelectedItem().toString();
        String occupation = occupationTextField.getText();
        String income = incomeBox.getSelectedItem().toString();
        String education = educationsBox.getSelectedItem().toString();
        String citizenship = null;
        if (yes2.isSelected())
        {
            citizenship = "Yes";
        }
        else if (no2.isSelected())
        {
            citizenship = "No";
        }

        String ssn = ssnTextField.getText();
        String dl = dlTextField.getText();
        String sCitizen = null;
        if (yes.isSelected())
        {
            sCitizen = "Yes";
        }
        else if (no.isSelected())
        {
            sCitizen = "No";
        }
        String age = ageBox.getSelectedItem().toString();
        String eaccount = null;
        if (yes3.isSelected())
        {
            eaccount = "Yes";
        }
        else if (no3.isSelected())
        {
            eaccount = "No";
        }

        try
        {
            Conn c = new Conn();
            String query = "UPDATE signup SET religion = '" + religion + "', occupation = '" + occupation + "', income = '" + income + "', education = '" + education + "', citizenship = '" + citizenship + "', ssn = '" + ssn + "', dl = '" + dl + "', sCitizen = '" + sCitizen + "', age = '" + age + "', eaccount = '" + eaccount + "' WHERE formno = '" + formno + "'";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpTwo(formno).setVisible(true);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String args[])
    {
        new SignUpTwo("");
    }
}