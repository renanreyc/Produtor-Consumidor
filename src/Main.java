import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> buffer = new ArrayList<>();
        int MAX = 5;
    
        Producer prod1 = new Producer(buffer, MAX);
        //Producer prod2 = new Producer(buffer, MAX);
        Consumer cons1 = new Consumer(buffer);
        Consumer cons2 = new Consumer(buffer);
    
        prod1.setName("produtor 1");
        //prod2.setName("produtor 2");
        cons1.setName("consumidor 1");
        cons2.setName("consumidor 2");
    
        Thread producerThread1 = new Thread(prod1);
        //Thread producerThread2 = new Thread(prod2);
        Thread consumerThread1 = new Thread(cons1);
        Thread consumerThread2 = new Thread(cons2);
    
        producerThread1.start();
        //producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
