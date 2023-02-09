package validation;

public class priorityValidator extends validator{
    @Override
    public boolean check(int creation, int duration, int priority, int cur) {
         if( priority != 0 && priority != 1)
             return false;
         return super.check(creation,duration,priority,cur);
    }
}
