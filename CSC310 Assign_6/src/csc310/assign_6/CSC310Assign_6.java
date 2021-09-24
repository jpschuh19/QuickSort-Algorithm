/*
Jacob Schuh
10-11-20
CSC 310
Assignment 6
 */
package csc310.assign_6;

import java.util.Scanner;

class Quick{
    private long[] theArray;
    private int nElems;
    
    public Quick(int max){
        theArray = new long[max];
        nElems = 0;
    }
    
    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }
    
    public void display(){
        System.out.println("");
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i]+" ");
        }
        System.out.println("");
    }
    
    public void quicksort(int value){//value is = to k
        recQuickSort(0,nElems-1, value);
    }
    
    public void recQuickSort(int left, int right, int value){
        if(right-left <=0)
            return;
        else{
            long pivot = theArray[right];
            
            
            partitionIt(left, right, pivot, value);
        }
    }
    
    public void partitionIt(int left, int right, long pivot, int value){
        int leftPtr = left-1;
        int rightPtr = right;
        while(true){
            while(theArray[++leftPtr]<pivot)
                ;
            while(rightPtr>0&&theArray[--rightPtr]>pivot)
                ;
            if(leftPtr >= rightPtr){
                break;
            }
            else{
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        if(leftPtr<value-1)
            recQuickSort(leftPtr+1, nElems-1, value);//recursion occurs here so only the side that contains k is searched
        else if(leftPtr>value-1)
            recQuickSort(0,leftPtr-1,value);//just uses the range on one side of the partition
        else if(leftPtr==value-1)//if partition position is equal to the value 
            System.out.println("The "+value+"th smallest number in the array is "+ theArray[leftPtr]);
            
    }
    
    public void swap(int dex1, int dex2){
        long temp = theArray[dex1];
        theArray[dex1]=theArray[dex2];
        theArray[dex2]=temp;
    }
}
public class CSC310Assign_6 {

    public static void main(String[] args) {
        int maxSize = 100;
        Quick arr;
        arr = new Quick(maxSize);
        
        
        Scanner input = new Scanner(System.in);
        int x = 0;
        while (x != 4) {
            System.out.println("");
            System.out.println("(1) Insert an Integer to the array (Enter -1 to stop)");
            System.out.println("(2) Find the k-th smallest number in the array");
            System.out.println("(3) Display the array");
            System.out.println("(4) to exit");
            System.out.println("");
            x = input.nextInt();
            String w = input.nextLine();

            if (x == 1) {
                int n=0;
                while(n>-1){
                    System.out.print("Enter in an integer: ");
                    n= input.nextInt();
                    if(n>-1)
                        arr.insert(n);
                }

            }
            if (x == 2) {
                System.out.println("Enter in the k-th smallest number you want to find: ");
                
                int k = input.nextInt();
                w = input.nextLine();
                arr.quicksort(k);

            }
            if (x == 3){
                arr.display();
            }
            if (x == 4) {
                System.out.println("BYE");
            }
            if (x < 1 && x > 4) {
                System.out.println("This is not a valid entry. Please try again.");
            }
        }

                
    }
    
}
