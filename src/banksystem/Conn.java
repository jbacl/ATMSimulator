package src.banksystem;

import java.sql.*;

public class Conn 
{
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
            c = DriverManager.getConnection("jdbc:mysql://database-bankmanagement.c2fuumy8c57t.us-east-2.rds.amazonaws.com:3306/bankmanagementsystem", "admin", "1234qwer");
            s = c.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
