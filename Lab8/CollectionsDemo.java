// Lab 8: Collections Framework
// Program: Demonstrating ArrayList, LinkedList, HashMap, and HashSet

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class CollectionsDemo {

    // ArrayList demo
    static void arrayListDemo() {
        System.out.println("--- ArrayList ---");
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Apple"); // duplicates allowed
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        list.remove("Banana");
        System.out.println("After removing Banana: " + list);
        Collections.sort(list);
        System.out.println("Sorted: " + list);
        System.out.println("Contains Cherry: " + list.contains("Cherry"));
    }

    // LinkedList demo
    static void linkedListDemo() {
        System.out.println("\n--- LinkedList (as Queue) ---");
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Queue: " + queue);
        System.out.println("Peek (front): " + queue.peek());
        System.out.println("Poll (remove front): " + queue.poll());
        System.out.println("Queue after poll: " + queue);
    }

    // HashMap demo
    static void hashMapDemo() {
        System.out.println("\n--- HashMap ---");
        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 82);
        scores.put("Charlie", 78);
        scores.put("Alice", 98); // updates existing key
        System.out.println("Scores: " + scores);
        System.out.println("Alice's score: " + scores.get("Alice"));
        System.out.println("Contains Bob: " + scores.containsKey("Bob"));
        scores.remove("Charlie");
        System.out.println("After removing Charlie: " + scores);

        System.out.println("\nIterating HashMap:");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // HashSet demo
    static void hashSetDemo() {
        System.out.println("\n--- HashSet ---");
        HashSet<String> set = new HashSet<>();
        set.add("Red");
        set.add("Green");
        set.add("Blue");
        set.add("Red"); // duplicate — ignored
        System.out.println("Set (no duplicates): " + set);
        System.out.println("Size: " + set.size());
        System.out.println("Contains Green: " + set.contains("Green"));
        set.remove("Green");
        System.out.println("After removing Green: " + set);
    }

    public static void main(String[] args) {
        arrayListDemo();
        linkedListDemo();
        hashMapDemo();
        hashSetDemo();
    }
}
