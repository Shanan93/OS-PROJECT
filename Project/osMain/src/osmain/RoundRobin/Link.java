package osmain.RoundRobin;

/**
 *
 * @author Mahmoud
 */
public class Link {
    public int burst;
    public String ProcessName;
    public Link nextLink;

    //Link constructor
    public Link(int d1, String d2) {
	    burst = d1;
	    ProcessName = d2;
    }

    //Print Link data
    public void printLink() {
	    System.out.print("{" + ProcessName + ", " + burst + "} ");
    }
}



