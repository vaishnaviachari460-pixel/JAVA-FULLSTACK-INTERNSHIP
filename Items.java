/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.items;

/**
 *
 * @author vaish
 */
import java.util.*;
public class Items {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Total Items:");
        int n = sc.nextInt();
       
        
        
        
        for(int i=1;i<=n;i++){
            String items = sc.nextLine();
        System.out.println("Enter Items:"+items);
        
        
        int price = sc.nextInt();
        System.out.println("Enter Price:"+price);
        
            
        }
        
        
    }
}
