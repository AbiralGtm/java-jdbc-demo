import database.DBConnection;
import database.Product;

class Main
{
    public static void main(String[] args) {
        Product product = new Product("Laptop", 50000);

        DBConnection db = new DBConnection();
        db.insertData(product);

        Product p1 = db.fetchData().get(0);
        System.out.println("Name: "+ p1.name());
    }
}