package com.company;

import java.util.ArrayList;

public class ActionBase {
    private ArrayList<Action> ab;

    public ActionBase() {
        ab = new ArrayList<>();
    }

    public void add(Action action){
        ab.add(action);
    }
    public void remove(Action action){
        ab.remove(action);
    }
    public int size(){
        return ab.size();
    }
    public boolean contains(Action action){
        return ab.contains(action);
    }

    public boolean isEmpty(){
        return ab.isEmpty();
    }

    @Override
    public String toString() {
        String action_string = "";
        for (Action action : ab) {
            action_string = action_string.concat(action.character + ", ");
        }
        return  "\nAction Base:\n" + action_string.substring(0,action_string.length()-2) + ".";
    }
}
