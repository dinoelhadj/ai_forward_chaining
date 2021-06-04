package com.company;

import java.util.ArrayList;

public class Rule {
    public ArrayList<Fait> conditions;
    public Fait result;

    public Rule(ArrayList<Fait> conditions, Fait result) {
        this.conditions = conditions;
        this.result = result;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (Fait fait:conditions) {
            toReturn = toReturn.concat(fait.character + ", ");
        }
        return toReturn.substring(0,toReturn.length()-2) + " ==> " + result.character;
    }
}
