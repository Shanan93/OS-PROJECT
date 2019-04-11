package osmain.diningPhilosophers;
import java.awt.*;
import java.util.concurrent.*;
import java.util.*;

/**
 *
 * @author Mahmoud
 */
class Chopstick {

    private boolean taken = false;

    public synchronized
            void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}