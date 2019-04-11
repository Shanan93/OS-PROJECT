package osmain.Segmentation;


import osmain.Segmentation.Segment;
import java.util.LinkedList ;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author mohammed saleh
 */
public class Segmentation {

    /**
     * @param args the command line arguments
     */
    
    public static int GetBaseAddress (LinkedList <Segment> M , int Psize ,int Msize)
    {
        boolean flag ;
        int BaseAddress = -1;
        Random r = new Random ();
        do 
        {
            flag = true;
        BaseAddress = r.nextInt(Msize-Psize);
        
            for (int i = 0; i < M.size(); i++) {
                Segment s = M.get(i);
                if (BaseAddress >= s.BaseAddress && BaseAddress <= s.LimitAddress ) {
                    //if (BaseAddress+Psize < s.BaseAddress || BaseAddress+Psize >s.LimitAddress) {
                    flag = false;    
                   // }
                    
                    
                }
            }
        
        }
        while (flag == false);
    return BaseAddress ;
    }
    public static boolean CheckLimitAddress (LinkedList <Segment> M , int Psize ,int Msize , int BaseAddress)
    {
        boolean flag ;
        int LimitAddress = BaseAddress+Psize;
        
        
       
            flag = true; // Initially we assume that the limit will be valid
        
        
            for (int i = 0; i < M.size(); i++) 
            {
                Segment s = M.get(i);
                if (
                        (LimitAddress==s.BaseAddress)
                        ||(LimitAddress >= s.BaseAddress &&LimitAddress <= s.LimitAddress)
                        ||(LimitAddress==s.LimitAddress) ) 
                {
                    flag = false;// Flag is false if the limit is invalid                        
                }
            }
        
        
                
    return flag ;
    }
    public static void Segmentation_Driver() {
        System.out.println("Executing in segmentation driver");
    
       LinkedList <Segment> Memory = new LinkedList<Segment>();
       
       Scanner sc = new Scanner(System.in) ;
       System.out.println("Plz Enter Number of processes");
       
       int Pnumber = sc.nextInt();
              System.out.println("Plz Enter the memory size");

       int memory_size=sc.nextInt();
       int available_memory=memory_size;
       
        for (int i = 0; i < Pnumber; i++) {
            System.out.println("Plz Enter Process "+i+" Size in Bytes :");
            int Psize = sc.nextInt();
            
            Segment s = new Segment();
            int temp_base_address;
            boolean flag_limit = false;
            
            do {
            
             temp_base_address = GetBaseAddress(Memory , Psize , memory_size);
              flag_limit = CheckLimitAddress(Memory, Psize, memory_size, temp_base_address);             
            if(flag_limit){ available_memory-=Psize;}
             
            
   
            }
            while(flag_limit==false&&available_memory>Psize);
            
                s.BaseAddress = temp_base_address; 
                s.LimitAddress = s.BaseAddress+Psize;
                
                System.out.println("P"+i+" : "+ s.BaseAddress + " , "+ s.LimitAddress);

                    }
       
       
    }
    
}
