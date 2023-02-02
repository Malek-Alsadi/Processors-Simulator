package TASK;

public abstract class Task {
    private int Priority;
    private int CreationTime;
    private int DurationTime;
    private String TaskId;
    private static int cnt;
    private String processorId;

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getProcessorId() {
        return processorId;
    }

    public void setProcessorId(String processorId) {
        this.processorId = processorId;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public int getCreationTime() {
        return CreationTime;
    }

    public void setCreationTime(int creationTime) {
        CreationTime = creationTime;
    }

    public int getDurationTime() {
        return DurationTime;
    }

    public void setDurationTime(int durationTime) {
        DurationTime = durationTime;
    }

    public Task(int priority, int creationTime, int durationTime) {
        Priority = priority;
        CreationTime = creationTime;
        DurationTime = durationTime;
        setId();
    }
    public void setId(){
        TaskId = "T" + ++cnt;
    }
    public Task() {
        Priority = 0;
        CreationTime = 0;
        DurationTime = 0;
    }

    @Override
    public String toString() {
        return TaskId +
                "{Priority=" + Priority +
                ", CreationTime=" + CreationTime +
                ", DurationTime=" + (DurationTime+1) +
                '}';
    }
}
