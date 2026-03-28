// Lab 6: Abstract Classes and Interfaces
// Program: Demonstrating interfaces with a smart device system

interface Switchable {
    void turnOn();
    void turnOff();
}

interface Connectable {
    void connectToNetwork(String networkName);
    void disconnect();
}

// Class implementing a single interface
class Light implements Switchable {
    String location;
    boolean isOn;

    Light(String location) {
        this.location = location;
        this.isOn = false;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(location + " light is ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(location + " light is OFF.");
    }
}

// Class implementing multiple interfaces
class SmartTV implements Switchable, Connectable {
    String brand;
    boolean isOn;
    String connectedNetwork;

    SmartTV(String brand) {
        this.brand = brand;
        this.isOn = false;
        this.connectedNetwork = null;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(brand + " Smart TV is ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(brand + " Smart TV is OFF.");
    }

    @Override
    public void connectToNetwork(String networkName) {
        this.connectedNetwork = networkName;
        System.out.println(brand + " TV connected to: " + networkName);
    }

    @Override
    public void disconnect() {
        System.out.println(brand + " TV disconnected from: " + connectedNetwork);
        this.connectedNetwork = null;
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("--- Light (Switchable) ---");
        Light light = new Light("Living Room");
        light.turnOn();
        light.turnOff();

        System.out.println("\n--- Smart TV (Switchable + Connectable) ---");
        SmartTV tv = new SmartTV("Samsung");
        tv.turnOn();
        tv.connectToNetwork("HomeWiFi");
        tv.disconnect();
        tv.turnOff();

        // Interface reference
        System.out.println("\n--- Using Interface Reference ---");
        Switchable device = new Light("Bedroom");
        device.turnOn();
        device.turnOff();
    }
}
