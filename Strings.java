/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.strings;

/**
 *
 * @author vaish
 */
import java.util.*;
public  class Strings{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows:");
        int rows = sc.nextInt();
        
        System.out.println("Enter columns:");    
        int cols = sc.nextInt();
        
        int[][] numbers = new int[rows][cols];
        for(int i=0; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                numbers[i][j]=sc.nextInt();
         
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(numbers[i][j]+"");
            }
            System.out.println();
//            
            
        }
        System.out.println("Element at (0,1) position is: " + numbers[0][1]);
    }
}