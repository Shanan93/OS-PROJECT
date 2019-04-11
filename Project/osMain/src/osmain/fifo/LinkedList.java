package osmain.fifo;

import osmain.fifo.Link;

/**
 *
 * @author Mahmoud
 */
public class LinkedList {
    private Link first;
    
    //LinkList constructor
    public LinkedList() {
	    first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
	    return first == null;
    }

    //Inserts a new Link at the first of the list
    public void insert(int d1, String d2) {
        if(first == null)
        {
            Link link = new Link(d1, d2);
	    link.nextLink = first;
	    first = link;
            return;
        }
        Link currentLink = first;
        
        while(currentLink.nextLink != null)
            currentLink = currentLink.nextLink;
        
        Link link = new Link(d1, d2);
        currentLink.nextLink = link;
        link.nextLink = null;
    }

    //Deletes the link at the first of the list
    public Link delete() {
	    Link temp = first;
	    first = first.nextLink;
	    return temp;
    }

    //Prints list data
    public void printList() {
	    Link currentLink = first;
	    System.out.print("List: ");
	    while(currentLink != null) {
		    currentLink.printLink();
		    currentLink = currentLink.nextLink;
	    }
	    System.out.println("");
    }
    
    public Link iteration(int index){
            Link currentLink = first;
            for(int i = 0; i < index; i++)
                currentLink = currentLink.nextLink;
            
            return currentLink;
    }
    
    public void iterateAndEdit(int index, int burst){
            Link currentLink = first;
            for(int i = 0; i < index; i++)
                currentLink = currentLink.nextLink;
            
            currentLink.burst = burst;
    }
    
    public int conditionBreak(){
            int breaker = 0;
            Link currentLink = first;
            
            while(currentLink != null){
                if(currentLink.burst == 0)
                    breaker += 1;
                
                currentLink = currentLink.nextLink;
            }
            
            return breaker;
    }
}
