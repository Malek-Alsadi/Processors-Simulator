package observer;
import TASK.Task;

public class ClockCycle implements Observer {
    private static int allCycles = 0;
    private int CycleNum;
    private String report = "";

    public int getCycleNum() {
        return CycleNum;
    }
    public ClockCycle(int cycleNum) {
        CycleNum = cycleNum;
    }

    public static int getAllCycles() {
        return allCycles;
    }

    public static void setAllCycles(int allCycles) {
        ClockCycle.allCycles = allCycles;
    }

    @Override
    public boolean CycleProcess(Task task) {
        if(task == null)
            return false;
        if(task.getDurationTime() == -1)
            report += "The task " + task.getTaskId() + " is done and " + task.getProcessorId() + " is now available\n";
        else
            report += "The task " + task + " is assigned to " + task.getProcessorId() + '\n';
        return true;
    }

    @Override
    public String toString() {
        return "ClockCycle " + getCycleNum() + ":\n" +
                report;
    }
}
