package observer;

public class AppleM extends Processor {
    public AppleM() {
        int num = getProcessorNum();
        setProcessorNum(num+1);
        setProcessorId(num);
    }
    @Override
    public void setProcessorId(int num) {
        String id = "Apple M2." + num;
        setProcessorId(id);
    }

    @Override
    public String toString() {
        return getProcessorId();
    }
}
