import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("./testFiles/test11.txt");
        int num = 0 , cycles = 0;
        String ex = "";
        try {
            Scanner in = new Scanner(file);
            num = in.nextInt();
            cycles = in.nextInt();
            ex = in.next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Simulator simulator = new Simulator(num,cycles,ex);
        simulator.simulate();
        reportPrinter.report(simulator.getCycles());
    }
}