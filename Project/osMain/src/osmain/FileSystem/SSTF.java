package osmain.FileSystem;

import java.util.Scanner;

/**
 *
 * @author Reham Khalaf & Mohamed Hassan Shanan 
 */
public class SSTF {

    /**
     * @param args the command line arguments
     */
    public static void SSTF_Driver(){
        System.out.println("Executing in SSTF Driver");
        Scanner scan = new Scanner(System.in);
        int min, minLocation = 0, temp, size, head, conditionBreaker = 0;
        
        System.out.println("pleas, enter the number of elements");
        size = scan.nextInt();
        
        int[] values = new int[size];
        int[] length = new int[size];
        
        System.out.println("please, enter the elements in the array");
        for(int index = 0; index < size; index++)
            values[index] = scan.nextInt();
        
        System.out.println("please, enter the initial head position");
        head = scan.nextInt();
        
        System.out.println("------------------------------");
        System.out.println(head);
        
        while(true){
		for(int index = 0; index < size; index++)
		{
			if(values[index] == 1000)
				conditionBreaker += 1;
		}

		if(conditionBreaker == size)
			break;
		else
			conditionBreaker = 0;

		for(int index = 0; index < size; index++)
		{
			temp = values[index] - head;
			if(temp < 0)
				temp *= -1;

			length[index] = temp;
		}

		min = 1000;
		for(int index = 0; index < size; index++)
		{
			if(length[index] < min){
				minLocation = index;
				min = length[minLocation];
			}
		}

		System.out.println(values[minLocation]);
		head = values[minLocation];
		values[minLocation] = 1000;
	}
    }
}
