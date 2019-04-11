package osmain.SJF;

import osmain.SJF.LinkedList;
import osmain.SJF.Link;
import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class SJF {

    /**
     * @param args the command line arguments
     */
    public static void SJF_Driver() {
        System.out.println("Executing in SJF");
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
       
        String processName;
        int processNumber;
        int time = 0; 
        int timeOld = 0;
        int timeTemp = 0;
        int minIndex = 0;
        
        System.out.println("please, enter the number of the processes");
        processNumber = scan.nextInt();
        
        for(int i = 0; i < processNumber; i++){
             processName = "P" + String.valueOf(i);
             System.out.println("please, enter the burst of " + processName);
             
             list.insert(scan.nextInt(), processName);
         }
        
        list.printList();
       
            System.out.println("\nApplying Shortest-Job First Algorithm");
            
            Link temp; 
            
             while(true){
                minIndex = list.iteration(processNumber);
                temp = list.getNode(minIndex);
                
                if(temp.burst == 0){                    
                        break;               
                }
                
                timeTemp = temp.burst;
                list.iterateAndEdit(minIndex, 0);
                timeOld = time;
                time += timeTemp;
                
                System.out.println("process: " + temp.ProcessName + " executed from " + timeOld + " to " + time);
            }
            
       System.out.println("\nDONE!");
    }
}
