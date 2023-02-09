package validation;

public abstract class validator {
    private validator nextCheck = null;
    public void setNext(validator next){
        nextCheck = next;
    }
    public boolean check(int creation , int duration, int priority, int cur){
        return nextCheck.check(creation,duration,priority,cur);
    }
}
