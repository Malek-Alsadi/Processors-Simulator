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
    public static void report(ClockCycle []cycles,String[] processors){
        System.out.println("Table :");
        for(int i=0;i<processors.length;i++){
            System.out.print(processors[i] + ":\t");
            for(int j=0;j< cycles.length;j++){
                System.out.print(cycles[j].getTaskAtProcessor(processors[i]) + "\t" );
            }
            System.out.println();
        }
    }
}
