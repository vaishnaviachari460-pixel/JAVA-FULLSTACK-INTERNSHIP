/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.magicalfoodfestival;

/**
 *
 * @author vaish
 */
//import java.util.*;
//
//public class MagicalFoodFestival {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        // 1️⃣ ArrayList → Food Stalls
//        ArrayList<String> foodStalls = new ArrayList<>();
//
//        System.out.print("Enter number of food stalls: ");
//        int stallCount = sc.nextInt();
//        sc.nextLine();   // clear buffer
//
//        for (int i = 0; i < stallCount; i++) {
//            System.out.print("Enter stall name: ");
//            String stall = sc.nextLine();
//            foodStalls.add(stall);
//        }
//
//        System.out.println("Food Stalls: " + foodStalls);
//
//
//        // 2️⃣ Vector → Dishes
//        Vector<String> dishes = new Vector<>();
//
//        System.out.print("\nEnter number of dishes: ");
//        int dishCount = sc.nextInt();
//        sc.nextLine();
//
//        for (int i = 0; i < dishCount; i++) {
//            System.out.print("Enter dish name: ");
//            String dish = sc.nextLine();
//            dishes.add(dish);
//        }
//
//        System.out.println("Available Dishes: " + dishes);
//
//
//        // 3️⃣ Queue → Customers
//        Queue<String> customerQueue = new LinkedList<>();
//
//        System.out.print("\nEnter number of customers: ");
//        int customerCount = sc.nextInt();
//        sc.nextLine();
//
//        for (int i = 0; i < customerCount; i++) {
//            System.out.print("Enter customer name: ");
//            String customer = sc.nextLine();
//            customerQueue.add(customer);
//        }
//
//        System.out.println("Customers in Queue: " + customerQueue);
//
//
//        // 4️⃣ LinkedList → History
//        LinkedList<String> customerHistory = new LinkedList<>();
//
//        System.out.println("\nServing Customers:");
//        while (!customerQueue.isEmpty()) {
//            String served = customerQueue.poll();
//            System.out.println(served + " is served.");
//            customerHistory.add(served);
//        }
//
//
//        // 5️⃣ Stack → Returning customers
//        Stack<String> returnStack = new Stack<>();
//
//        System.out.print("\nEnter number of returning customers: ");
//        int returnCount = sc.nextInt();
//        sc.nextLine();
//
//        for (int i = 0; i < returnCount; i++) {
//            System.out.print("Enter returning customer name: ");
//            String name = sc.nextLine();
//            returnStack.push(name);
//        }
//
//        System.out.println("\nReturning Customers:");
//        while (!returnStack.isEmpty()) {
//            System.out.println(returnStack.pop() + " returned to stall.");
//        }
//
//
//        // Final History
//        System.out.println("\nDaily Festival History:");
//        for (String customer : customerHistory) {
//            System.out.println(customer);
//        }
//
//        sc.close();
//    }
//}



import java.util.*;

public class MagicalFoodFestival {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> foodStalls = new ArrayList<>();
        Vector<String> dishes = new Vector<>();
        Queue<String> customerQueue = new LinkedList<>();
        Stack<String> returnStack = new Stack<>();
        LinkedList<String> history = new LinkedList<>();

        int choice;

        do {
            System.out.println("\n--- Magical Food Festival ---");
            System.out.println("1. Add Food Stall");
            System.out.println("2. Add Dish");
            System.out.println("3. Add Customer");
            System.out.println("4. Serve Customer");
            System.out.println("5. Add Returning Customer");
            System.out.println("6. Show History");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter stall name: ");
                    String stall = sc.nextLine();
                    foodStalls.add(stall);
                    break;

                case 2:
                    System.out.print("Enter dish name: ");
                    String dish = sc.nextLine();
                    dishes.add(dish);
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    String customer = sc.nextLine();
                    customerQueue.add(customer);
                    break;

                case 4:
                    if (!customerQueue.isEmpty()) {
                        String served = customerQueue.poll();
                        System.out.println(served + " is served.");
                        history.add(served);
                    } else {
                        System.out.println("No customers in queue.");
                    }
                    break;

                case 5:
                    System.out.print("Enter returning customer name: ");
                    String name = sc.nextLine();
                    returnStack.push(name);
                    break;

                case 6:
                    System.out.println("Daily History: " + history);
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}

