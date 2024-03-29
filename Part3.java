/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author osman
 */
public class Part3<E> {
    private ArrayList<Integer> list1;       //for list 1
    private ArrayList<Integer> list2;       //for list 2
    private ArrayList<Integer> intersect;   //for intersect function
    private ArrayList<Integer> union;       //for union function  
    Scanner scIn;                           //for get input from console 
    private int listSize;                   //for tempListSize

    public Part3(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
        this.listSize = 0;
        intersect = new ArrayList<Integer>();
        union = new ArrayList<Integer>();
        
    }
    
    
    /**
     * @param listSize 
     * set the tempListSize
     */
    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
    
    /**
     * get tempListSize
     * @return tempListSize 
     */
    public int getListSize() {
        return listSize;
    }
    

    public void setTempList(){
        intersect = new ArrayList<Integer>();
        union = new ArrayList<Integer>();
    }
    
    /**
     * if list1 and list2 have any common elements , 
     * the function concatenate elements
     * and return a list
     * @return intersect list
     */
    public List intersectionOfLists(){
       
        //if listSize(is tempSize) is equal list1Size or list2Size
        //Stop
        if(Math.max(list1.size(),list2.size()) == listSize  ){   
            return intersect;
        }
        
        //if listSize small from list size , look at common member
        //and add intersectList
        if((listSize<list1.size())){
            if(list2.contains(list1.get(listSize)) && !intersect.contains(list1.get(listSize)))
            {
                intersect.add(list1.get(listSize));
            }
        }
        //if listSize small from list size , look at common member
        //and add intersectList
        if((listSize<list2.size()))
            if(list1.contains(list2.get(listSize)) && !intersect.contains(list2.get(listSize)))
                intersect.add(list2.get(listSize));
        
        //tempListSize increment
        listSize++;
        
        //Call recursion call
        intersectionOfLists();

        //return a list
        return intersect;
    }
    

    /**
     * if list1 and list2 are not nulls, 
     * the function concatenate elements
     * in list and  return a list
     * @return union list 
     */
    public List unionOfLists(){
        //Base case return union, if listSize(tempSize) is equal add of lists
        if(listSize == (list1.size() + list2.size() -1))
            return union; 
        
        //check lis1 and if union doesnt contains list element,add
        if(listSize < list1.size() && !union.contains(list1.get(listSize)))
            union.add(list1.get(listSize));
        
        //check list2 and if union doesnt contains list element,add
        if(listSize < list2.size() && !union.contains(list2.get(listSize)) )
            union.add(list2.get(listSize));
            
        //total size
        listSize++;
    
        //recursive call
        unionOfLists();
        
        return union;
    }
    
    /**
     * if anyList is subset other list,true
     * is not ,false
     * @return true or false
     */
    public boolean isSubset(){
        
        //if listSize is a equal any List,subset true
        if(list1.size() == listSize ||  list2.size() == listSize)
           return true;
        else if(list1.size() <= list2.size()){
            if(!list2.contains(list1.get(listSize)))
                  return false;
        }else if(list1.size() > list2.size()){
            if(!list1.contains(list2.get(listSize)))
                return false;
        }
            
        listSize++;
        return isSubset();
        
    }    
     
    
    
}
