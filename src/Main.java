import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> buffer = new ArrayList<>();
        int MAX = 5;
        Semaphore semaforo = new Semaphore(1);
    
        Producer prod1 = new Producer("produto 1", buffer, MAX, semaforo);
        // Producer prod2 = new Producer(buffer, MAX, "produtor 2");
        Consumer cons1 = new Consumer("consumidor 1", buffer, semaforo);
        // Consumer cons2 = new Consumer(buffer, "consumidor 2");
        // Consumer cons3 = new Consumer(buffer);   
        
    
        Thread producerThread1 = new Thread(prod1);
        // Thread producerThread2 = new Thread(prod2);
        Thread consumerThread1 = new Thread(cons1);
        // Thread consumerThread2 = new Thread(cons2);
        // Thread consumerThread3 = new Thread(cons3);
    
        producerThread1.start();
        // producerThread2.start();
        consumerThread1.start();
        // consumerThread2.start();
        // consumerThread3.start();
    }
}
