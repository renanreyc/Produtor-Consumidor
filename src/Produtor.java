import java.util.List;
import java.util.Random;

class Producer implements Runnable {
  private List<String> buffer;
  private String name;
  private int MAX;

  Random gerador = new Random();

  public Producer(List<String> buffer, int MAX) {
    this.buffer = buffer;
    this.MAX = MAX;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void run() {
    while (true) {

      // Verificar se a lista está cheia
      try {
        if(buffer.size() == this.MAX ){
          try {
            //System.out.println("Lista cheia \t" + getName() + " está dormindo!");
            System.out.println("... \t" + "Lista cheia, " + getName() + " está dormindo! zzz" );
            
            // sleep
            sleep(2000);
            continue;
          }catch (Exception e){
             e.printStackTrace();
            return;
          }
        }
      } catch (Exception ex) {
        System.out.println(ex);
      }

      // Adicionar item a lista
      try {
        int randomNumber = gerador.nextInt(20);
        System.out.println("ADD \t" + getName() + "\t item produzido: " + randomNumber);
        buffer.add(String.valueOf(randomNumber)); 
      } catch (Exception e) {
        System.out.println(e);
        return;
      }
      
      // Imprimir a lista
      System.out.println("Lista: " + buffer);

      // Sleep
      sleep(1000);
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