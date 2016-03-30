package com.mycompany._hw5;
import java.util.*;
public class Part1{
    int totalMove=0;

    public int getTotalMove() {
        return totalMove;
    }
    
    /**
     * Get NumberOfDisk and solve tower of hanoi problem 
     * iteratively
     * @param diskSize
     * @param src
     * @param dst
     * @param aux 
     */
    public void run(int diskSize,int src,int dst,int aux){
        int n=diskSize; 
        int step = (int)Math.pow(2,n)-1; //2^n - 1 times  
        
        for(int index=0;index<(step) ;index++){
            totalMove++;
            
			
			
            int index1=0, x= index+1;
            //if x is division to 2 ,stop 
            for(index1=0;x%2==0;index1++){
                x/=2;
            }
            //disk move
            aux = index1;
            
            //source
            src = ( movements(index,aux)*direction(aux,n))%3;
            
            //destination
            dst = (src + direction(aux,n))%3; 
            
            //Print moves
            move(aux,src,dst);
        }      
        
        System.out.println("Total move:" + step);
    }
    
    /**
     * How many times disks d has moved before stage i
     * @param i
     * @param d
     * @return 
     */
    private int movements(int i, int d) { 
        while(d--!=0)
            i/=2;
        return (i+1)/2;
    }
    /**
     *  each moves in same direction
     * @param d
     * @param n
     * @return 
     */
    private int direction(int d,int n) {
        return 2 - (n + d)%2;
    }
    /**
     * Display movements
     * @param disk
     * @param source
     * @param destination 
     */
    private void move(int disk, int source, int destination) {
        System.out.println("Disk " + (disk+1)+ " from Tower " + (source+1) + " to Tower " + (destination+1));
    }
    
}