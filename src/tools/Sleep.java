package tools;

public class Sleep {

    public static void sleep(int time) {
        try {
          Thread.currentThread().sleep(time);
        } catch (Exception ex) {
          System.out.println(ex);
        }
      }
}
