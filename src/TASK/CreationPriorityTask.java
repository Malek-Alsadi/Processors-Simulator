package TASK;

public class CreationPriorityTask extends Task implements Comparable<Task>{
    public CreationPriorityTask(int priority, int creationTime, int durationTime) {
        super(priority, creationTime, durationTime);
    }
    @Override
    public int compareTo(Task o) {
        if(getCreationTime() == o.getCreationTime()){
            if(getPriority() < o.getPriority())
                return 1;
            else if(getPriority() > o.getPriority())
                return -1;
            return 0;
        }
        if(getCreationTime() < o.getCreationTime())
            return -1;
        else if(getCreationTime() > o.getCreationTime())
            return 1;
        return 0;
    }
}
