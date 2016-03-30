/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._hw5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author osman
 */
public class Main<E>{
    ArrayList list1;       //for list 1
    ArrayList list2;       //for list 2

    public Main() {
        list1 = new ArrayList<E>();
        list1 = new ArrayList<E>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scIn = new Scanner(System.in);
        System.out.println("1-)Part1");
        System.out.println("2-)Part2");
        System.out.println("3-)Part3");
        System.out.print("Please select anyone test>>");
        int select = scIn.nextInt();
        
        
        //Menu for testing
        switch(select){
            case 1:
                main.driverPart1();
                break;
            case 2:
                main.driverPart2();
                break;
            case 3:
                main.driverPart3();
                break;
            default:
                System.err.println("Exit System \n Worng Selection");
        }
       
     
    }
    void driverPart1(){
       int src=0,dst=0,aux=0;
       int numberOfDisks=3;  //change disk numbers for test 
       Part1 towerOfHanoi=new Part1();
    
       System.out.println("Number Of Disks : " + numberOfDisks + "(you can change numberOfElemets)");
       towerOfHanoi.run(numberOfDisks,src,dst,aux);
        
    }
    
    /**
     * Remove duplicate elements 
     *
     */
    void driverPart2(){
        //For Integer
       Part2 prt = new Part2();
       prt.add(1);
       prt.add(1);
       prt.add(2);
       prt.add(1);
       prt.add(1);
       prt.add(1);
       prt.add(2);
       prt.add(3);
      
       System.out.println("Remove Element : 1");
       System.out.println("list before remove : " + prt.toString());
       prt.remove(1);
       System.out.println("list after remove elements : " +prt.toString());
       
       
       //For string
       prt = new Part2();
       
       prt.add("Osman");
       prt.add("Baba");
       prt.add("Cemal");
       prt.add("Osman");
       prt.add("Ahmet");
       prt.add("Osman");
       prt.add("Said");
      
       System.out.println("\n\nRemove Element : Osman");
       System.out.println("list before remove : " + prt.toString());
       prt.remove("Osman");
       System.out.println("list after remove elements : " +prt.toString());
    }
    
    /**
     * Fill Lists
     * You can change type to string,double,integer and the other
     */
    public void fillList(){
        list1 = new ArrayList<E>();
        list2 = new ArrayList<E>();
        
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        
        
        //list2
        list2.add(3);
        list2.add(4);
        list2.add(5);
        
    }
    
    void driverPart3(){
        System.out.println("\nTest One");
        fillList();
        Part3 list  = new Part3(list1,list2);
        
        System.out.print("List1>>");
        displayLists(list1);

        System.out.print("List2>>");
        displayLists(list2);
        
        testPart3(list);
        
        
        System.out.println("\nTest Two");
        list2 = new ArrayList();
        list2.add(7);
        list2.add(9);
        list2.add(11);
        
        list  = new Part3(list1,list2);
       
        System.out.print("List1>>");
        displayLists(list1);

        System.out.print("List2>>");
        displayLists(list2);
        
        testPart3(list);
    }
    
    private void testPart3(Part3 list){
        ArrayList ls ;
        System.out.print("IntersectionOfLists>>");
        ls = (ArrayList)list.intersectionOfLists();
        displayLists(ls);
       
        list.setListSize(0);
        System.out.print("UnionOfLists>>");
        ls = (ArrayList) list.unionOfLists();
        displayLists(ls);
        
        list.setListSize(0);
        
        System.out.println("isSubset>>" + list.isSubset());
    
    }
    
    /**
    * Display list1,list2 elements
    */
    private static void displayLists(ArrayList list1){
    
        //Display list 1
        for (int i = 0; i <list1.size(); i++) {
            System.out.print(list1.get(i) + "  ");
        }
        System.out.println();
    
    }
}
