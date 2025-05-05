
public class Package {
    int id;
    String name;
    String description;
    double price;

    public Package(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void displayPackage() {
        System.out.println("Package ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
    }
}
