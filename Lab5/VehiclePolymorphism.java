// Lab 5: Polymorphism
// Program: Demonstrating compile-time polymorphism (method overloading) and
//          runtime polymorphism (method overriding) with a Vehicle hierarchy

class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    // Method to be overridden
    void start() {
        System.out.println(brand + " vehicle is starting.");
    }

    void stop() {
        System.out.println(brand + " vehicle has stopped.");
    }

    // Overloaded describe methods (compile-time polymorphism)
    void describe() {
        System.out.println("Vehicle brand: " + brand);
    }

    void describe(String type) {
        System.out.println("Vehicle brand: " + brand + " | Type: " + type);
    }

    void describe(String type, int year) {
        System.out.println("Vehicle brand: " + brand + " | Type: " + type + " | Year: " + year);
    }
}

class Car extends Vehicle {
    int doors;

    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }

    @Override
    void start() {
        System.out.println(brand + " car with " + doors + " doors is starting with ignition key.");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int doors, int batteryCapacity) {
        super(brand, doors);
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    void start() {
        System.out.println(brand + " electric car is silently starting (battery: " + batteryCapacity + " kWh).");
    }
}

class Motorcycle extends Vehicle {
    Motorcycle(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(brand + " motorcycle is roaring to life!");
    }
}

public class VehiclePolymorphism {
    public static void main(String[] args) {
        System.out.println("--- Runtime Polymorphism ---");
        Vehicle[] vehicles = {
            new Car("Toyota", 4),
            new ElectricCar("Tesla", 4, 100),
            new Motorcycle("Harley-Davidson")
        };

        for (Vehicle v : vehicles) {
            v.start();
        }

        System.out.println("\n--- Compile-time Polymorphism (Overloading) ---");
        Vehicle v = new Vehicle("Honda");
        v.describe();
        v.describe("SUV");
        v.describe("SUV", 2023);
    }
}
