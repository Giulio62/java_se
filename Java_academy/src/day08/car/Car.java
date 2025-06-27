package day08.car;

public class Car {

    private double fuel;
    private double maxSpeed;

    // Default constructor
    // Initializes fuel to 0.0 and maxSpeed to a default value (e.g., 120.0)
    public Car() {
        // super(); // Implicitly called if not specified, calls Object's constructor
        this.fuel = 0.0;
        this.maxSpeed = 120.0; // A sensible default max speed
    }

    // Constructor with only fuel
    public Car(double fuel) {
        this.fuel = fuel;
        this.maxSpeed = 120.0; // Still using a default for maxSpeed
    }

    // Constructor with both fuel and maxSpeed
    public Car(double fuel, double maxSpeed) {
        this.fuel = fuel;
        this.maxSpeed = maxSpeed;
    }

    // --- Getter and Setter methods (Good practice for private fields) ---

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        // You might add validation here, e.g., fuel cannot be negative
        if (fuel >= 0) {
            this.fuel = fuel;
        } else {
            System.err.println("Fuel cannot be negative.");
        }
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        // Validation for maxSpeed
        if (maxSpeed > 0) {
            this.maxSpeed = maxSpeed;
        } else {
            System.err.println("Max speed must be positive.");
        }
    }

    // --- Example of a method the Car might have ---
    public void drive(double distance) {
        // Simple logic: consume fuel based on distance
        double fuelConsumed = distance * 0.1; // 0.1 units of fuel per unit of distance
        if (this.fuel >= fuelConsumed) {
            this.fuel -= fuelConsumed;
            System.out.println("Drove " + distance + " units. Remaining fuel: " + this.fuel);
        } else {
            System.out.println("Not enough fuel to drive " + distance + " units. Current fuel: " + this.fuel);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a car using the default constructor
        Car car1 = new Car();
        System.out.println("Car 1 - Fuel: " + car1.getFuel() + ", Max Speed: " + car1.getMaxSpeed());
        car1.drive(10);
        car1.setFuel(5.0);
        car1.drive(20);
        car1.drive(100);

        System.out.println("--------------------");

        // Create a car with initial fuel
        Car car2 = new Car(10.0);
        System.out.println("Car 2 - Fuel: " + car2.getFuel() + ", Max Speed: " + car2.getMaxSpeed());
        car2.drive(50);

        System.out.println("--------------------");

        // Create a car with initial fuel and max speed
        Car car3 = new Car(20.0, 180.0);
        System.out.println("Car 3 - Fuel: " + car3.getFuel() + ", Max Speed: " + car3.getMaxSpeed());
        car3.drive(100);

        // Demonstrate setter validation
        car3.setFuel(-5.0); // Will print an error message
        car3.setMaxSpeed(0); // Will print an error message
    }
}