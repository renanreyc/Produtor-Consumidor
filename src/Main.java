import modules.Consumer;
import modules.Estoque;
import modules.Producer;

public class Main {
    public static void main(String[] args) throws Exception {

        Estoque estoque1 = new Estoque(5);
    
        Producer prod1 = new Producer("produtor 1", estoque1);
        Consumer cons1 = new Consumer("consumidor 1", estoque1);
        Consumer cons2 = new Consumer("consumidor 2", estoque1);        
    
        Thread producerThread1 = new Thread(prod1);
        // Thread producerThread2 = new Thread(prod2);
        Thread consumerThread1 = new Thread(cons1);
        Thread consumerThread2 = new Thread(cons2);

    
        producerThread1.start();
        // producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();

    }
}
