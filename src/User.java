import java.util.ArrayList;

public class User {
    int id;
    String username;
    String password;
    boolean isRegistered;

    public static ArrayList<User> users = new ArrayList<>();
    public static int nextId = 1; 

    public User(String username, String password) {
        this.id = nextId++;
        this.username = username;
        this.password = password;
        this.isRegistered = true;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public boolean isRegistered() { return isRegistered; }

    public static boolean register(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("Username already exists.");
                return false;
            }
        }
        users.add(new User(username, password));
        System.out.println("Registration successful.");
        return true;
    }

    public static User login(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful.");
                return user;
            }
        }
        System.out.println("Invalid credentials.");
        return null;
    }
}
