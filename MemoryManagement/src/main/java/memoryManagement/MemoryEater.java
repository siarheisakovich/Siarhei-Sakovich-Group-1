package memoryManagement;

import org.apache.log4j.Logger;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class MemoryEater {
    static final Logger logger = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
    	//This is heap space OutOfMemoryException. We should not make hard reference to objects
    	//Objects stay in OLD generation.
        List<WeakReference> v = new ArrayList<WeakReference>();
        while (true) {
            byte b[] = new byte[1048576];
            v.add(new WeakReference(b));
            Runtime rt = Runtime.getRuntime();

            System.out.println("free memory: " + rt.freeMemory());
//            try {
//                Thread.sleep(250);
//            } catch (InterruptedException e) {
//            }
        }
    }
}
