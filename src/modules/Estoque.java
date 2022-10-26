package modules;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import tools.GenerateRandomNumberNoDuplicate;


public class Estoque {
    private int size;
    private List<String> buffer = new ArrayList<>();
    Semaphore semaforo = new Semaphore(1);
    private int bound = 20;
    GenerateRandomNumberNoDuplicate generateRandomNumberNoDuplicate = new GenerateRandomNumberNoDuplicate();
    

    public Estoque(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public List<String> getBuffer() {
        return buffer;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

    public int addBuffer() {
        
        int randomNumber = generateRandomNumberNoDuplicate.generateRandomNumberNoDuplicate(this.bound);
        this.buffer.add(String.valueOf(randomNumber));

        return randomNumber;
    }

    public String removeBuffer() {
        
        String removedItem = this.buffer.remove(0);

        return removedItem;
    }

    public void setBuffer(List<String> buffer) {
        this.buffer = buffer;
    }
}
