import java.util.ArrayList;

public class Booking {
    User user;
    Package travelPackage;

    public static ArrayList<Booking> bookings = new ArrayList<>();

    public Booking(User user, Package travelPackage) {
        this.user = user;
        this.travelPackage = travelPackage;
    }

    public static void bookPackage(User user, Package travelPackage) {
        bookings.add(new Booking(user, travelPackage));
        System.out.println("Booking successful for package: " + travelPackage.getName());
    }

    public static ArrayList<Booking> getBookings() { 
    	return bookings; 
    	}
}
