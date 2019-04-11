package osmain;

import java.util.Scanner;
import osmain.Chatting.Chat;
import osmain.DeadLockAvoidance.DeadlockAvoidance;
import osmain.DeadlockDetection.DeadlockDetection;
import osmain.DeadlockPrevention.DeadlockPrevention;
import osmain.FileSystem.CLook;
import osmain.FileSystem.SSTF;
import osmain.FirstComeFirstServed.FirstInFirstOut;
import osmain.IOArduinoWithJava.IO;
import osmain.LRU.lru;
import osmain.ProducerConsumer.ProducerConsumerSolution;
import osmain.ReaderWriter.ReaderWriterSolution;
import osmain.RoundRobin.RoundRobin;
import osmain.SJF.SJF;
import osmain.Segmentation.Segmentation;
import osmain.SleepingBarber.SleepingBarber;
import osmain.diningPhilosophers.DiningPhilosophers;
import osmain.fifo.FIFO;

/**
 *
 * @author Mahmoud Yahia
 */
public class OsMain {

    public static void Synchronization() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int inner;
        
         System.out.println("Enter 1 for Bounded Buffer");
         System.out.println("Enter 2 for Readers Writer");
         System.out.println("Enter 3 for Dining Philosophers");
         System.out.println("Enter 4 for Barber's Shop");
        
         inner = scan.nextInt();
         
         switch(inner){
             case 1: ProducerConsumerSolution.ProducerConsumer_Driver();
                    break;
             case 2: ReaderWriterSolution.ReaderWriter_Driver();
                    break;
             case 3: DiningPhilosophers.DiningPhilosophers_Driver();
                    break;
             case 4: SleepingBarber.SleepingBarber_Driver();
                    break;
             default:
                System.out.println("you have entered wrong number");
         }
    }
    public static void Scheduling()
    {
        Scanner scan = new Scanner(System.in);
        int inner;
        
        System.out.println("Enter 1 for FIFO");
        System.out.println("Enter 2 for SJF");
        System.out.println("Enter 3 for Round Robin");
        
        inner = scan.nextInt();
        switch(inner)
        {
            case 1: FIFO.Fifo_Driver();
                    break;
            case 2: SJF.SJF_Driver();
                    break;
            case 3: RoundRobin.RoundRobin_Driver();
                    break;
            default:
                System.out.println("you have entered wrong number");
        }
    }
    public static void Chatting()
    {
        Chat.Chat_Driver();
    }
    public static void DeadLock()
    {
        Scanner scan = new Scanner(System.in);
        int inner; 
        
        System.out.println("Enter 1 for Dead Lock Prevention");
        System.out.println("Enter 2 for Dead Lock Avoidance");
        System.out.println("Enter 3 for Dead Lock Detection");
        
        inner = scan.nextInt();
        switch(inner)
        {
            case 1: DeadlockPrevention.DeadlockPrevention_Driver();
                    break;
            case 2: DeadlockAvoidance.DeadLockAvoidance_Driver();
                    break;
            case 3: DeadlockDetection.DeadlockDetection_Driver();
                    break;
            default:
                System.out.println("you have entered wrong number");
        }
    }
    public static void FileSystem()
    {
        Scanner scan = new Scanner(System.in);
        int inner;
        
        System.out.println("Enter 1 for SSTF");
        System.out.println("Enter 2 for CLook");
        
        inner = scan.nextInt();
        
        switch(inner)
        {
            case 1: SSTF.SSTF_Driver();
                    break;
            case 2: CLook.CLook_Driver();
                    break;
            default:
                System.out.println("you have entered wrong number");
        }
    }
    public static void MemoryManagement() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int inner;
        
        System.out.println("Enter 1 for Least Recently Used");
        System.out.println("Enter 2 for Segmentation");
        System.out.println("Enter 3 for First Come First Served");
        
        inner = scan.nextInt();
        
        switch(inner)
        {
            case 1: lru.LRU_Driver();
                    break;
            case 2: Segmentation.Segmentation_Driver();
                    break;
            case 3: FirstInFirstOut.FirstComeFirstServed_Driver();
                    break;
            default:
                System.out.println("you have entered wrong number");
        }
    }
    
    public static void InputOutput(){
        IO.IO_Driver();
    }
    
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int choice; 
        
        System.out.println("Enter 1 for Synchronization");
        System.out.println("Enter 2 for Scheduling");
        System.out.println("Enter 3 for Chatting server");
        System.out.println("Enter 4 for Dead Lock");
        System.out.println("Enter 5 for File System");
        System.out.println("Enter 6 for Memory management");
        System.out.println("Enter 7 for the Input/Output");
               
        choice = scan.nextInt();
        
        switch(choice)
        {
            case 1: 
                Synchronization();
                break;
            case 2:
                Scheduling();
                break;
            case 3: 
                Chatting();
                break; 
            case 4: 
                DeadLock();
                break;
            case 5: 
                FileSystem();
                break; 
            case 6: 
                MemoryManagement();
                break; 
            case 7: 
                InputOutput();
                break;
            default:
                System.out.println("you have entered wrong number");
        }

    }
    
}
