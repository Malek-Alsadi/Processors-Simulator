package observer;
import TASK.Task;
import java.util.HashMap;

public class ClockCycle implements Observer {
    private static int allCycles = 0;
    private int CycleNum;
    private String report = "";
    private HashMap<String,String> map;

    public int getCycleNum() {
        return CycleNum;
    }
    public ClockCycle(int cycleNum) {
        CycleNum = cycleNum;
        map = new HashMap<>();
    }

    public static int getAllCycles() {
        return allCycles;
    }

    public static void setAllCycles(int allCycles) {
        ClockCycle.allCycles = allCycles;
    }
    public String getTaskAtProcessor(String processor){
        if(map.containsKey(processor)){
            return map.get(processor);
        }else{
            return "NA";
        }

    }

    @Override
    public boolean CycleProcess(Task task) {
        if(task == null) {
            return false;
        }
        if(task.getDurationTime() > 0) {
            report += "Processor " + task.getProcessorId() + " is working on task " + task + "\n";
            task.setDurationTime( task.getDurationTime()-1 );
        }
        if(task.getDurationTime() <= 0) {
            report += "The task " + task.getTaskId() + " is done and " + task.getProcessorId() + " will be available next clock cycle\n";
        }
        if(!map.containsKey(task.getProcessorId()))
            map.put(task.getProcessorId(), task.getTaskId());

        return true;
    }

    @Override
    public String toString() {
        return "ClockCycle " + getCycleNum() + ":\n" +
                report;
    }
}
