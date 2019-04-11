package osmain.Chatting;

import osmain.Chatting.ClientGUI;
import osmain.Chatting.Server;
import osmain.Chatting.ServerGUI;
import java.util.Scanner;

/**
 *
 * @author Mahmoud Yahia
 */
public class Chat {

    public static void Chat_Driver() {
        
        Scanner input = new Scanner (System.in); 
        System.out.println("Executing in the chatting room ");
        System.out.println("Enter the number of user in the chat room");
        int users = input.nextInt() ; 
        ServerGUI.ServerGUI_Driver();
        for (int i = 0 ; i <users ;i++)
        {
        ClientGUI.ClientGUI_Driver();
        }
        Server.Server_Driver();
    }
}
