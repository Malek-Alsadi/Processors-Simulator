package observer;

public class Intel extends Processor {

    public Intel() {
        int num = getProcessorNum();
        setProcessorNum(num+1);
        setProcessorId(num);
    }
    @Override
    public void setProcessorId(int num) {
        String id = "Intel i7." + num;
        setProcessorId(id);
    }

    @Override
    public String toString() {
        return getProcessorId();
    }
}
