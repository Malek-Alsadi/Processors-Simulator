package observer;
import TASK.Task;

public abstract class Processor implements Observer {
    static int processorNum = 0;
    private String processorId;
    private boolean status;
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getProcessorId() {
        return processorId;
    }

    public static int getProcessorNum() {
        return processorNum;
    }

    public static void setProcessorNum(int processorNum) {
        Processor.processorNum = processorNum;
    }

    public void setProcessorId(String processorId) {
        this.processorId = processorId;
    }

    public abstract void setProcessorId(int num);
    @Override
    public boolean CycleProcess(Task task) {

        if(status){
            this.task.setDurationTime(this.task.getDurationTime()-1);
            if(this.task.getDurationTime() <= 0 ) {
                this.task.setDurationTime(-1);
                status = false;
            }
        }else if(task != null ){
            this.task = task;
            task.setDurationTime(task.getDurationTime()-1);
            task.setProcessorId(getProcessorId());
            status = true;
            return true;
        }
        return false;
    }
}
