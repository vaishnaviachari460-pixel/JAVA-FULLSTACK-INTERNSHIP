/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vaish
 */
//import java.util.*;
//class OddThread extends Thread{
//    public void run() {
//    for(int i=1;i<=10;i++){
//        if(i%2!=0){
//            System.out.println("Odd numbers are:"+i);
//        }
//    }
//    }
//        
//    }
//    class EvenThread extends Thread{
//        public void run(){
//        for(int i=1;i<=10;i++){
//            if(i%2==0){
//                System.out.println("Even numbers are:"+i);
//                
//            }
//        }
//        }
//    }
//    public class MyThread{
//    public static void main(String args[]){
//        OddThread odd = new OddThread();
//        EvenThread even = new EvenThread();
//        odd.start();
//        even.start();
//        
//        
//    }
//}
//




import java.util.ArrayList;
import java.util.Scanner;

public class MyThread {

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== TO-DO LIST MENU =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                    } else {
                        System.out.print("Enter task number to remove: ");
                        int removeIndex = sc.nextInt();

                        if (removeIndex > 0 && removeIndex <= tasks.size()) {
                            tasks.remove(removeIndex - 1);
                            System.out.println("Task removed successfully!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
