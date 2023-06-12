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
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bankmanagementsystem", "root", "123qwe");
            s = c.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
