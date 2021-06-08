package com.company;

import java.util.ArrayList;

public class Rule {
    public ArrayList<Action> conditions;
    public Action result;
    public boolean used;

    public Rule(ArrayList<Action> conditions, Action result) {
        this.conditions = conditions;
        this.result = result;
        used = false;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (Action action:conditions) {
            toReturn = toReturn.concat(action.character + ", ");
        }
        return toReturn.substring(0,toReturn.length()-2) + " ==> " + result.character;
    }
}
