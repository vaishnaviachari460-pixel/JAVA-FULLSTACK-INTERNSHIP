/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentdemo;

/**
 *
 * @author vaish
 */
//import java.util.*;
//class student{
//    int rollno,sem;
//    String name,address;
//    static String collegename="CIT";
//    void getdata(int r,int s,String n,String a){
//        rollno=r;
//        sem=s;
//        name=n;
//        address=a;
//    }
//    void putdata(){
//        System.out.println(rollno+"\t"+name+"\t"+sem+"\t"+address+"\t"+collegename);
//    }
//}
//public class StudentDemo{
//    public static void main(String args[]){
//        Scanner sc=new Scanner(System.in);
//        student s[]=new student[5];
//        for(int i=0;i<5;i++){
//            s[i]=new student();
//            System.out.println("Enter details of Student"+(i+1));
//            System.out.println("Roll No:");
//            int r=sc.nextInt();
//            sc.nextLine();
//            
//            System.out.println("Semester:");
//            int se=sc.nextInt();
//            sc.nextLine();
//            
//            System.out.println("Name:");
//            String n=sc.nextLine();
//            
//            System.out.println("Address:");
//            String a=sc.nextLine();
//            
//            s[i].getdata(r,se,n,a);
//        }
//        System.out.println("\nStudent Details:");
//        for(int i=0;i<5;i++){
//            s[i].putdata();
//        }
//        sc.close();
//    }
//}



import java.util.*;
public class StudentDemo{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows:");
        int rows = sc.nextInt();
        
        System.out.println("Enter columns:");    
        int cols = sc.nextInt();
//        int[][] matrix=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
            if((i+j)%2==0){
                System.out.print(" B ");
            }else{
                System.out.print(" W ");
            }
            System.out.println();
            
        }
        
        
    }
}