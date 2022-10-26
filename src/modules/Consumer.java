package modules;

import tools.Sleep;

public class Consumer implements Runnable {
    private String name;
    private Estoque estoque;

    public Consumer(String name, Estoque estoque) {
        this.name = name;
        this.estoque = estoque;
      }

    public String getName() {
    return name;
    }

    public void run() {
      while (true) {

     // Remover item da lista
      try {
        estoque.getSemaforo().acquire();

        // Verificar se a kusta está vazia
          if(estoque.getBuffer().size() == 0) {
            System.out.println("... \t" + "Lista vazia, " + getName() + " está dormindo! zzz");
            Sleep.sleep(2000);
          } else {
            // Remover item da lista
            String removedItem = estoque.removeBuffer();
            System.out.println("DEL \t" + getName() + "\t item removido: " + removedItem);

            System.out.println("Lista: " + estoque.getBuffer());
          }       
        } catch (Exception e) {
          System.out.println(e);
          e.printStackTrace();
          return;
        } finally {
          estoque.getSemaforo().release();
        }
        // Sleep
        Sleep.sleep(3000);
      }
  }
}
