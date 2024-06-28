package database;
public class Product {
    
    protected String name;
    protected int price;
    
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String name() {
        return this.name;
    }
    
    public int price() {
        return this.price;
    }
    
    public void name(String name) {
        this.name = name;
    }
    
    public void price(int price) {
        this.price = price;
    }
    
    public String toString() {
        return this.name + " " + this.price;
    }
}
