// Lab 4: Inheritance
// Program: Animal hierarchy demonstrating single and multilevel inheritance

// Base class
class Animal {
    String name;
    String sound;

    Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    void makeSound() {
        System.out.println(name + " says: " + sound);
    }

    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

// Single inheritance: Dog extends Animal
class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name, "Woof");
        this.breed = breed;
    }

    void fetch() {
        System.out.println(name + " (" + breed + ") is fetching the ball!");
    }
}

// Single inheritance: Cat extends Animal
class Cat extends Animal {
    boolean isIndoor;

    Cat(String name, boolean isIndoor) {
        super(name, "Meow");
        this.isIndoor = isIndoor;
    }

    void purr() {
        System.out.println(name + " is purring...");
    }
}

// Multilevel inheritance: GoldenRetriever extends Dog extends Animal
class GoldenRetriever extends Dog {
    GoldenRetriever(String name) {
        super(name, "Golden Retriever");
    }

    void guide() {
        System.out.println(name + " is acting as a guide dog.");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        System.out.println("--- Dog ---");
        Dog dog = new Dog("Buddy", "Labrador");
        dog.makeSound();
        dog.eat();
        dog.fetch();

        System.out.println("\n--- Cat ---");
        Cat cat = new Cat("Whiskers", true);
        cat.makeSound();
        cat.sleep();
        cat.purr();

        System.out.println("\n--- Golden Retriever (multilevel) ---");
        GoldenRetriever gr = new GoldenRetriever("Max");
        gr.makeSound();
        gr.eat();
        gr.fetch();
        gr.guide();
    }
}
