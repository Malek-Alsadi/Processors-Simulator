import TASK.Task;
import observer.ClockCycle;
import observer.Observer;
import observer.Processor;

import java.util.PriorityQueue;

public class scheduler {
    Observer []processors;
    public scheduler(Processor[] processors){
        this.processors = processors;
    }
    public void eachCycle(PriorityQueue<Task> pq, Observer cycle){

        boolean assigned = false;
        for(int i=0;i<processors.length;i++){
            ClockCycle c = (ClockCycle) cycle;
            assigned = processors[i].CycleProcess(pq.peek());

            Task tmp = ((Processor)processors[i]).getTask();
            cycle.CycleProcess( ((Processor) processors[i]).getTask() );
            if(assigned) {
                pq.poll();
            }
            if( tmp != null && tmp.getDurationTime() == 0){
                ((Processor)processors[i]).EmptyProcessor();
            }

            assigned = false;
        }
    }
}
