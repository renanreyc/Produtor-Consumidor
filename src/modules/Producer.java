package modules;

import java.util.Random;


import tools.Sleep;

public class Producer implements Runnable {
  private String name;
  private Estoque estoque;

  public Producer(String name, Estoque estoque) {
    this.name = name;
    this.estoque = estoque;
  }

  public String getName() {
    return name;
  }

  public void run() {
    while (true) {      
      try {
        estoque.getSemaforo().acquire();

        // Verificar se a lista está cheia
        if(estoque.getBuffer().size() >= estoque.getSize() ){
          
            //System.out.println("Lista cheia \t" + getName() + " está dormindo!");
            System.out.println("... \t" + "Lista cheia, " + getName() + " está dormindo! zzz" );
            
            // sleep
            Sleep.sleep(2000);
                  
        } else {

          int numberAdd = estoque.addBuffer();
          System.out.println("ADD \t" + getName() + "\t item produzido: " + numberAdd);          
          
          // Imprimir a lista
          System.out.println("Lista: " + estoque.getBuffer());
        }
      } catch (Exception e) {
        e.printStackTrace();
        return;
      } finally {
        estoque.getSemaforo().release();
      }

      Sleep.sleep(2000);
    }
  }
}