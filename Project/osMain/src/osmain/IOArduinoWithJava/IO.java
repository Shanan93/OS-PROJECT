package osmain.IOArduinoWithJava;

import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JSlider;
import com.fazecast.jSerialComm.*;

/**
 *
 * @author Ahmed Shaaban
 */

public class IO {

	public static void IO_Driver() {

		JFrame window = new JFrame();
		JSlider slider = new JSlider();
		
                slider.setMaximum(1023); //Arduino got 10-bit ADC 
		slider.setPaintTicks(true);
                slider.setPaintTrack(true);
                slider.setPaintLabels(true);
                window.add(slider);
                window.pack();
		window.setVisible(true);

		SerialPort[] ports = SerialPort.getCommPorts(); //array of ports that shows all ports on system
		System.out.println("Select a port:");
		int i = 1;
		for(SerialPort port : ports) //special kind of for loop 
			System.out.println(i++ +  ": " + port.getSystemPortName());
		Scanner s = new Scanner(System.in);
		int chosenPort = s.nextInt();

		SerialPort serialPort = ports[chosenPort - 1];
		if(serialPort.openPort())
			System.out.println("Port opened successfully.");
		else {
			System.out.println("Unable to open the port.");
			return;
		}
		//serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);

		Scanner data = new Scanner(serialPort.getInputStream());
		int value = 0;
		          System.out.println("Now you can change the POT value and it will be shown on the screen and slider");
                          System.out.println("NOTE : there may be some sort of delay for 5 seconds at most, be patient please!");
                while(data.hasNextLine()){
                        System.out.println(data.nextLine());
                        try{value = Integer.parseInt(data.nextLine());}catch(Exception e){}
			double analog_reading = (10000/1024)*value; 
                        slider.setValue(value);
		}
		System.out.println("Done.");
                
	

        }
}
