package TASK;

public class CreationPriorityTask extends Task implements Comparable<Task>{
    public CreationPriorityTask(int priority, int creationTime, int durationTime) {
        setPriority(priority);
        setCreationTime(creationTime);
        setDurationTime(durationTime);
        setId();
    }
    public CreationPriorityTask(Task task){
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
