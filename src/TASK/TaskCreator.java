package TASK;

import java.util.Arrays;

public class TaskCreator {
    private static Task[] Tasks = new Task[2];
    private static int idx = 0;
    public static void preCreate(int CreationTime , int Duration , int Priority , int i){
        Tasks[i] = new CreationPriorityTask(Priority,CreationTime,Duration);
    }
    public static void castArray(){

        for(int i=0;i<Tasks.length;i++){
            Tasks[i] = new PriorityDurationTask(Tasks[i]);
        }
    }
    public static void sort(){
        Arrays.sort(Tasks);
    }
    public static void resize(int n){
        Tasks = new Task[n];
    }
    public static int getTasks(int cycleNum){
        int idx2 = -1;
        for(int i = idx ;i<Tasks.length && Tasks[i].getCreationTime() <= cycleNum;i++){
            idx2 = i;
        }
        if(idx2 != -1)  idx = idx2+1;
        return idx2;
    }

    public static Task getTaskByIdx(int cycle) {
        return Tasks[cycle];
    }

    public static int getIdx() {
        return idx;
    }

    public static void printAll(){
        for(int i=0;i<Tasks.length;i++){
            System.out.println(Tasks[i]);
        }
    }
    public static void emptyArray(){

    }
}
