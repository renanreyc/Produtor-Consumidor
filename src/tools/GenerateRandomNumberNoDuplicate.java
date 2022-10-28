package tools;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNumberNoDuplicate {
    private List<String> bufferFull = new ArrayList<>();
    private int randomNumerateGenerate;

    //Get selected size number without duplicate
   public int generateRandomNumberNoDuplicate(int bound) {  
        Random random = new Random(); 
        int size = this.bufferFull.size();

       while (this.bufferFull.size() == size) {
           //Get Random numbers between range
           int randomNumber = random.nextInt(bound);
           
           //Check for duplicate values
           if (!this.bufferFull.contains(String.valueOf(randomNumber))) {
                this.bufferFull.add(String.valueOf(randomNumber));
                randomNumerateGenerate = randomNumber;
           }
       }
       return randomNumerateGenerate;
   }

    
}
