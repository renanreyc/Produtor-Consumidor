import java.util.List;

public class Consumer implements Runnable {
    private List<String> buffer;
    private String name;

    public Consumer(List<String> buffer) {
        this.buffer = buffer;
      }

    public String getName() {
    return name;
    }

    public void setName(String name) {
        this.name = name;
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
            sleep(5000);
            continue;
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
            return;
        }
    }

     // Remover item da lista
     try {
        String removedItem = buffer.remove(0);
        System.out.println("DEL \t" + getName() + "\t item removido: " + removedItem);
      } catch (Exception e) {
        System.out.println(e);
        return;
      }

      // Sleep
      sleep(3000);
    }
  }

  public void sleep(int time) {
    try {
      Thread.currentThread().sleep(time);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
