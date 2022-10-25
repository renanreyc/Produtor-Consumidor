import java.util.List;
import java.util.concurrent.Semaphore;

import tools.Sleep;

public class Consumer implements Runnable {
    private List<String> buffer;
    private String name;
    Semaphore semaforo;

    public Consumer(String name, List<String> buffer, Semaphore semaforo) {
        this.name = name;
        this.buffer = buffer;
        this.semaforo = semaforo;
      }

    public String getName() {
    return name;
    }

    public void run() {
        while (true) {
    
    //System.out.println("Buffer: " + buffer);

    // Verificar se a lista está vazia
    if(buffer.size() == 0){
        try {
            //System.out.println("Lista vazia \t" + getName() + " está dormindo!");
            System.out.println("... \t" + "Lista vazia, " + getName() + " está dormindo! zzz" );

            // sleep
            Sleep.sleep(5000);
            continue;
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return;
        }
    }

     // Remover item da lista
     try {
      semaforo.acquire();

      // Verificar se a kusta está vazia
        if(buffer.size() == 0) {
          System.out.println("... \t" + "Lista vazia, " + getName() + " está dormindo! zzz");
          Sleep.sleep(5000);
        } else {
          // Remover item da lista
          String removedItem = buffer.remove(0);
          System.out.println("DEL \t" + getName() + "\t item removido: " + removedItem);

          System.out.println("Lista: " + buffer);
        }       
      } catch (Exception e) {
        System.out.println(e);
        e.printStackTrace();
        return;
      } finally {
        semaforo.release();
      }
      // Sleep
      Sleep.sleep(3000);
    }
  }
}
