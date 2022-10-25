import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;

import tools.Sleep;

class Producer implements Runnable {
  private List<String> buffer;
  private String name;
  private int MAX;
  String uniqueID = UUID.randomUUID().toString();
  Semaphore semaforo;

  Random gerador = new Random();

  public Producer(String name, List<String> buffer, int MAX, Semaphore semaforo) {
    this.name = name;
    this.buffer = buffer;
    this.MAX = MAX;
    this.semaforo = semaforo;
  }

  public String getName() {
    return name;
  }

  public void run() {
    while (true) {      
      try {
        semaforo.acquire();

        // Verificar se a lista está cheia
        if(buffer.size() == this.MAX ){
          
            //System.out.println("Lista cheia \t" + getName() + " está dormindo!");
            System.out.println("... \t" + "Lista cheia, " + getName() + " está dormindo! zzz" );
            
            // sleep
            Sleep.sleep(2000);
                  
        } else {
          // Adicionar item a lista
          int randomNumber = gerador.nextInt(20);
  
          System.out.println("ADD \t" + getName() + "\t item produzido: " + randomNumber);          
          buffer.add(String.valueOf(randomNumber));
          
          // Imprimir a lista
          System.out.println("Lista: " + buffer);
        }
      } catch (Exception e) {
        e.printStackTrace();
        return;
      } finally {
        semaforo.release();
      }

      Sleep.sleep(2000);
    }
  }
}