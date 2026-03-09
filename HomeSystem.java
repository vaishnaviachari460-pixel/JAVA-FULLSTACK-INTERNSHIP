/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.homesystem;

/**
 *
 * @author vaish
 */
import java.util.*;
abstract class Appliance{
    private String name;
    private boolean status;//Encapsulation
    public Appliance(String name){
        this.name=name;
        this.status=false;//Initially OFF
    }
    public String getName(){
        return name;
    }
    public boolean getStatus(){
        return status;
    }
    public void turnOn(){
        if(status){
            System.out.println(name+"is already ON");
        }else{
            status=true;
            System.out.println(name+"is now ON");
        }
    }
    public void turnOff(){
        if(!status){
            System.out.println(name+"is already OFF");
        }else{
            System.out.println(name+"is now OFF");
        }
    }
    public abstract void showApplianceType();
    
}
//Inheritance
class Fan extends Appliance{
    public Fan(){
        super("Fan");
        
    }
    public void showApplianceType(){
        System.out.println("Cooling Appliance");
    }
}
class Light extends Appliance{
    public Light(){
        super("Light");
    }
    public void showApplianceType(){
        System.out.println("Lighting Appliance");
    }
}
class AC extends Appliance{
    public AC(){
    super("AC");
}
    public void showApplianceType(){
        System.out.println("Air Cnditioning Appliance");
    }
}
//Main class
public class HomeSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Objects created once->state remembered
        Appliance fan = new Fan();
        Appliance light = new Light();
        Appliance ac = new AC();
        while(true){
            System.out.println("\n Choose Appliance:");
            System.out.println("1.Fan");
            System.out.println("2.Light");
            System.out.println("3.AC");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            if(choice==4){
                System.out.println("Existing System..");
                break;
            }
        }
    }
}
