package osmain.fifo;


import java.util.Scanner;

/**
 *
 * @author Mahmoud
 */
public class FIFO {

    /**
     * @param args the command line arguments
     */
    public static void Fifo_Driver() {
        System.out.println("Executing in FIFO");
        LinkedList list = new LinkedList();
        Scanner scan = new Scanner(System.in);
       
        String processName;
        int processNumber;
        int counter = 0;
        int time = 0; 
        int timeOld = 0;
        int timeTemp = 0;
        
        System.out.println("please, enter the number of the processes");
        processNumber = scan.nextInt();
        
        for(int i = 0; i < processNumber; i++){
             processName = "P" + String.valueOf(i);
             System.out.println("please, enter the burst of " + processName);
             
             list.insert(scan.nextInt(), processName);
         }
        
        list.printList();
            
            System.out.println("\nApplying First-in First-out Algorithm");
            
            Link temp; 
             
            while(true){
                if(counter == processNumber){
                counter = 0;
                }
                
                temp = list.iteration(counter);
                
                if(temp.burst == 0){                    
                    if(list.conditionBreak() == processNumber)
                        break;
                    
                    continue;
                }
                
                timeTemp = temp.burst;
                list.iterateAndEdit(counter, 0);
                timeOld = time;
                time += timeTemp;
                
                System.out.println("process: " + temp.ProcessName + " executed from " + timeOld + " to " + time);
                counter += 1;
            }
            
       System.out.println("\nDONE!");
    }
}
