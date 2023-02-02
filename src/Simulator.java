import TASK.Task;
import TASK.TaskCreator;
import observer.AppleM;
import observer.ClockCycle;
import observer.Intel;
import observer.Processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Simulator {
    private PriorityQueue<Task> pq;
    private Processor []processors;
    private ClockCycle []cycles;

    public ClockCycle[] getCycles() {
        return cycles;
    }

    public Simulator(int processorsNum, int CyclesNum, String fileEx){
        processors = new Processor[processorsNum];
        for(int i=0;i<processorsNum/2;i++){
            processors[i] = new Intel();
        }
        for(int i=processorsNum/2;i<processorsNum;i++){
            processors[i] = new AppleM();
        }
        cycles = new ClockCycle[CyclesNum];
        ClockCycle.setAllCycles(CyclesNum);
        pq = new PriorityQueue<>();

        File file = new File(fileEx);

        try {
            Scanner in = new Scanner(file);
            int size = in.nextInt();
            TaskCreator.resize(size);
            for(int i = 0;i<size;i++){
                int creationTime = in.nextInt(), Duration = in.nextInt(), Priority = in.nextInt();
                TaskCreator.preCreate(creationTime,Duration,Priority,i);
            }
            TaskCreator.sort();
            TaskCreator.castArray();
            for(int i=0;i < cycles.length;i++){
                cycles[i] = new ClockCycle(i+1);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void simulate(){
        scheduler s = new scheduler(processors);
        for(int i=0;i<cycles.length;i++){
            int l = TaskCreator.getIdx();
            int r = TaskCreator.getTasks(i+1);
            if(r != -1){
                for(;l<=r;l++){
                    pq.add( TaskCreator.getTaskByIdx(l) );
                }
            }

            s.eachCycle(pq,cycles[i]);
        }
    }

}
