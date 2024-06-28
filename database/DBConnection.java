package database;
import java.sql.*;
import java.util.ArrayList;
public class DBConnection
{
    Connection conn;

    public DBConnection()
    {
   
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping","root","");
            System.out.println("Connected to the database successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to the database.");
        }
    }

    public void insertData(Product p)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("insert into products (name,price) values(?,?)");
            ps.setString(1,p.name());
            ps.setInt(2,p.price());
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }    

    public ArrayList<Product> fetchData()
    {
        ArrayList<Product> products = new ArrayList<Product>();
        try
        {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");
            while(resultSet.next())
            {
                Product product = new Product(
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );
                products.add(product);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return products;
    }
}