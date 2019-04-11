package osmain.RoundRobin;

import osmain.RoundRobin.LinkedList;
import osmain.RoundRobin.Link;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class RoundRobin {

    /**
     * @param args the command line arguments
     */
    
    
    //DRIVER CLASS OF ROUND ROBIN ALGORITHM
    public static void RoundRobin_Driver() {
        System.out.println("Executing in RoundRobin");
         LinkedList list = new LinkedList();
         Scanner scan = new Scanner(System.in); 
         
         String processName;
         int processNumber;
         int timeSlot;
         int counter = 0;
         int time = 0; 
         int timeOld = 0;
         int timeTemp = 0;
         int checker;
         
         System.out.println("please, enter the number of process");
         processNumber = scan.nextInt();
         checker = processNumber;
         
         for(int i = 0; i < processNumber; i++){
             processName = "P" + String.valueOf(i);
             System.out.println("please, enter the burst of " + processName);
             
             list.insert(scan.nextInt(), processName);
         }
         
	    list.printList();

            
            System.out.println("please, enter the time Slot");
            timeSlot = scan.nextInt();
            
            System.out.println("time slot value is: " + timeSlot);
            
            System.out.println("\nApplying Round Robin Algorithm");
            
            Link temp; 
            
            while(true){
                if(counter == processNumber){
                counter = 0;
                }
                
                temp = list.iteration(counter);
                
                if(temp.burst == 0){
                    counter += 1;
                    checker -= 1;
                    
                    if(list.conditionBreak() == processNumber)
                        break;
                    
                    continue;
                }
                
                if(temp.burst > timeSlot){
                    list.iterateAndEdit(counter, list.iteration(counter).burst - timeSlot);
                    //list.iteration(counter).burst = list.iteration(counter).burst - timeSlot;
                    timeOld = time;
                    time += timeSlot;
                }
                
                else if(temp.burst < timeSlot){
                    timeTemp = temp.burst;
                    list.iterateAndEdit(counter, 0);
                    timeOld = time;
                    time += timeTemp;
                }
                
                else if(temp.burst == timeSlot){
                    list.iterateAndEdit(counter, 0);
                    timeOld = time;
                    time += timeSlot;
                }
                
                System.out.println("process: " + temp.ProcessName + " executed from " + timeOld + " to " + time);
                counter += 1;
            }
            
       System.out.println("\nDONE!");
    }
}
