package validation;

public class rangeValidator extends validator{
    @Override
    public boolean check(int creation, int duration, int priority, int cur) {
        if( creation > cur || creation < 1 )
            return false;
        return super.check(creation,duration,priority,cur);
    }
}
