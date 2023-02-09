package TASK;

public class PriorityDurationTask extends Task implements Comparable<Task>{
    public PriorityDurationTask(int priority, int creationTime, int durationTime) {
        super(priority, creationTime, durationTime);
    }
    public PriorityDurationTask(Task task){
        int creation = task.getCreationTime();
        int duration = task.getDurationTime();
        int priority = task.getPriority();
        String id = task.getTaskId();
        setPriority(priority);
        setCreationTime(creation);
        setDurationTime(duration);
        setTaskId(id);

    }

    @Override
    public int compareTo(Task o) {
        if(o.getPriority() == getPriority()){
            if(getDurationTime() < o.getDurationTime())
                return 1;
            else if(getDurationTime() > o.getDurationTime())
                return -1;
            return 0;
        }
       if(getPriority() > o.getPriority())
           return -1;
       else if(getPriority() < o.getPriority())
           return 1;
       return 0;
    }
}
