package osmain.FileSystem;

import java.util.Scanner;

/**
 *
 * @author Reham Khalaf & Mohamed Hassan Shanan 
 */
public class CLook {

    /**
     * @param args the command line arguments
     */
    public static void CLook_Driver(){
        System.out.println("Executing in CLook File system");
        Scanner scan = new Scanner(System.in);
        int temp, size, minIndex, index = 0, counter = 0, initialHead;
        
        System.out.println("enter the size of the array");
        size = scan.nextInt();
        int[] array = new int[size];
        
        System.out.println("please, enter the elments of the array");
        for(int index1 = 0; index1 < size; index1++)
            array[index1] = scan.nextInt();
        
        System.out.println("please, enter the initial head");
        initialHead = scan.nextInt();
        
        System.out.println("the array after sorting it");
        
        for(int loc = 0; loc < size - 1; loc++)
        {
            minIndex = loc;
            for(int i = loc + 1; i < size; i++)
            {
                if(array[minIndex] > array[i])
                    minIndex = i;
            }
            
            temp = array[minIndex];
            array[minIndex] = array[loc];
            array[loc] = temp;
        }
        
        
        for(int i = 0; i < size; i++)
        {
            if(array[i] >= initialHead)
            {
                index = i;
                break;
            }
        }
        
        while(true)
        {
            System.out.println("-----------------------");
            
            if(array[counter + index] == -1)
            {
                System.out.println("loop terminated");
                break;
            }
            
            System.out.println(array[counter + index]);
            
            array[counter + index] = -1;
            counter += 1;
            
            if((counter + index) == size)
            {
                System.out.println("returning to the beginning");
                index = 0; 
                counter = 0;
            }
        }
    }
}
