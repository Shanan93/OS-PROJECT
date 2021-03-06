package osmain.LRU;

/**
 *
 * @author mohammed saleh
 */

 import java.io.*;
 public class lru 
 {
     public static void LRU_Driver() throws Exception
     {
         System.out.println("Executing in least recently used");
         int f, p, num=0, pageHit=0, count=0, ptPage=0, pg=0;
         int pages[];
         int frame[];
         int recent[];
         boolean flag = true;
         boolean flag2 = true;
         
         BufferedReader br= new BufferedReader(new InputStreamReader(System.in));      //STEP 1
         System.out.println("Enter number of frames : ");
         f = Integer.parseInt(br.readLine());
         System.out.println("Enter number of pages : ");
         p = Integer.parseInt(br.readLine());
         
         frame = new int[f];
         pages = new int[p];
         recent = new int[f];
         
         for(int i=0; i<f; i++)                                      //STEP 2
         {
             frame[i] = -1;
             recent[i] = -1;
         }
         
         System.out.println("Enter page number : ");
         for(int i=0;i<p;i++)
             pages[i] = Integer.parseInt(br.readLine());
         
         for(int i=0; i<p; i++)
         {    
             flag = true;
             int page = pages[i];
             
             for(int j=0; j<f; j++)
                 recent[j] = -1;
                 
             for(int j=0; j<f; j++)        //check for page hit      STEP 3
             {
                 if(frame[j] == page)
                 {
                     flag = false;
                     pageHit++;
                     break;
                 }
             }
             if(flag)
             {
                 count = 0;
                 if(i>=3)
                 {    
                     ptPage = i-1;
                     
                     while(count < f)                                      //STEP 4
                     {    
                         Thread.sleep(1000);
                         pg = pages[ptPage];
                         flag2 = true;
                         //for(int j=0; j<f; j++)
                         //        System.out.print(recent[j]+" ");
                         //System.out.println();
                         for(int j=0; j<f; j++)
                         {
                             if(pg == recent[j])
                             {    
                                 flag2 = false;
                                 //System.out.println(pg+" "+recent[j]+" "+flag2+" "+i+" "+j+" "+f+" "+ptPage);
                                 break;
                             }
                             //break;
                         }
                         if(flag2)
                         {
                             //System.out.println(pg+" "+recent[j]+" "+flag2+" "+i+" "+j+" "+f+" "+ptPage);
                             recent[count] = pg;
                             count++;
                             ptPage--;
                         }
                         else
                             ptPage--;
                     }
                 
                 /*    System.out.print("page : "+page+" recent : ");
                     for(int j=0; j<f; j++)
                         System.out.print(recent[j]+" ");
                     System.out.println();
                 */    
                 
                     int replace = recent.length - 1;                     //STEP 5
                     int pg_to_replace = recent[replace];
                     int k=0;
                     while(frame[k] != pg_to_replace)                 //STEP 6
                         k++;
                     
                     frame[k] = page;
                 }
                 else
                     frame[i] = page;
             }
             System.out.print("frame : ");                          //STEP 7
             for(int k=0; k<f; k++)
                 System.out.print(frame[k]+" ");
             System.out.println();
         }
         System.out.println("No. of page hit : "+pageHit);
     }
 }
