package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        //declaration
        ActionBase actionBase = new ActionBase();
        RuleBase ruleBase = new RuleBase();

        //Actions
        Action a = new Action("a");
        Action b = new Action("b");
        Action c = new Action("c");
        Action d = new Action("d");
        Action e = new Action("e");
        Action f = new Action("f");
        Action z = new Action("z");

        //Conditions
        ArrayList<Action> r1a = new ArrayList<>();
        r1a.add(a);r1a.add(b);r1a.add(c);

        ArrayList<Action> r2a = new ArrayList<>();
        r2a.add(a);r2a.add(d);

        ArrayList<Action> r3a = new ArrayList<>();
        r3a.add(a);r3a.add(e);

        ArrayList<Action> r4a = new ArrayList<>();
        r4a.add(a);r4a.add(e);r4a.add(f);


        //Rules
        Rule R1 = new Rule(r1a,d);
        Rule R2 = new Rule(r2a,e);
        Rule R5 = new Rule(r2a,a);
        Rule R6 = new Rule(r2a,a);
        Rule R7 = new Rule(r2a,a);
        Rule R3 = new Rule(r3a,f);
        Rule R4 = new Rule(r4a,z);

        //adding actions to action base
        actionBase.add(a);
        actionBase.add(b);
        actionBase.add(c);

        //adding rules to rule base
        ruleBase.add(R1);ruleBase.add(R5);ruleBase.add(R6);ruleBase.add(R7);
        ruleBase.add(R2);ruleBase.add(R3);ruleBase.add(R4);


        //goal
        Action goal = z;

        System.out.println(actionBase);
        System.out.println(ruleBase);


        int i = 0;//counts rules

        try {
            while ( !actionBase.contains(goal) && !ruleBase.isEmpty()){
                System.out.println("\nCurrent rule: " + (i+1) + "/" + ruleBase.size());
                Rule rule = ruleBase.get(i);
                System.out.println(rule.toString());
                boolean available = true;
                for (Action action:rule.conditions) {
                    System.out.println("Current action: " + action.character);
                    if (!actionBase.contains(action)) {
                        available = false;
                        System.out.println(action.character + " isn't available at actionBase");
                        break;
                    }
                }
                if (available) {
                    if (!actionBase.contains(rule.result)) {
                        actionBase.add(rule.result);
                        System.out.println(rule.result.character + " added to actionBase\nRule " + rule + " moved to used rules!");
                        ruleBase.deactivate(rule);
                        i--;
                    } else if (actionBase.contains(rule.result)){
                        System.out.println("actionBase already has " + rule.result.character +
                                "\n" + actionBase);
                    }
                }
                i++;
                if (i>=ruleBase.size()){
                    i = 0;
                }
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        if (actionBase.contains(goal)){
            System.out.println("\nSuccess!\nGoal Obtained");
        } else if (i==ruleBase.size()){
            System.out.println("\nFail!\nOut of Rules");
        } else System.out.println("\nFail!\nGoal Not Obtained For Other Reasons!");

        System.out.println(actionBase);

        System.out.println("rules left :" +  (ruleBase.size()-i));
    }
}
