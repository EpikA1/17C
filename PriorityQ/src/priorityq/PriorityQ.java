/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityq;

import java.util.Scanner;

/**
 *
 * @author Paul
 */
public class PriorityQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList pq = new LinkedList();
        Scanner in = new Scanner(System.in);
        int choice = 0;
        
        do{
            System.out.println("Welcome to the Priority Queue! Please make a selection from the following:");
            System.out.println("1: Insert");
            System.out.println("2: Remove Maximum");
            System.out.println("3: Decrease");
            System.out.println("4: Increase");
            System.out.println("5: Display");
            System.out.println("0: Close");
            System.out.print("Your Choice: ");
            choice = in.nextInt();

            if (choice == 1){
                int data;
                int prior;
                
                System.out.println("Enter the integer you would like to enter: ");
                data = in.nextInt();
                
                System.out.println("Enter the priority of the data(Higher = more important): ");
                prior = in.nextInt();
                
                pq.insert(data, prior);
            }

            else if (choice == 2){
                pq.remove_maximum();
            }

            else if (choice == 3){
                int data;
                int prior;
                
                System.out.println("Enter the integer you would like to decrease the priority of: ");
                data = in.nextInt();
                
                System.out.println("Enter how much you would like the priority lowered by: ");
                prior = in.nextInt();
                
                pq.decrease(data, prior);
            }

            else if (choice == 4){
                int data;
                int prior;
                
                System.out.println("Enter the integer you would like to decrease the priority of: ");
                data = in.nextInt();
                
                System.out.println("Enter how much you would like the priority lowered by: ");
                prior = in.nextInt();
                
                pq.increase(data, prior);
            }

            else if (choice == 5){
                System.out.print("Your queue: ");
                System.out.println( pq.display() );
            }
            
            else System.out.println("Invalid Entry!");
        
        } while (choice != 0);
        
        System.out.print("\n\nGoodbye!\n\n");
    }    
}
