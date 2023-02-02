import observer.ClockCycle;
import java.util.concurrent.TimeUnit;

public class reportPrinter {
    public static void report(ClockCycle []cycles){
        for(ClockCycle cycle : cycles){
            System.out.println(cycle);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
