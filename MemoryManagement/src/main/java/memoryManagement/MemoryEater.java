package memoryManagement;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class MemoryEater {
    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
        // This is heap space OutOfMemoryException. We should not make hard
        // reference to objects
        // Objects stay in OLD generation.
        List v = new ArrayList();
        while (true) {
            if (v.size() < 100) {
                byte b[] = new byte[1048576];
                v.add(b);
            }
            Runtime rt = Runtime.getRuntime();

            System.out.println("free memory: " + rt.freeMemory());
        }
    }
}
