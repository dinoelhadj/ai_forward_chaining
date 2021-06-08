package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //declaration
        ArrayList<Action> bF = new ArrayList<>();
        ArrayList<Rule> bR = new ArrayList<>();

        //Actions
        Action a = new Action("a");
        Action b = new Action("b");
        Action c = new Action("c");
        Action d = new Action("d");
        Action e = new Action("e");
        Action f = new Action("f");
        Action z = new Action("z");

        //partie conditions pour les régles
        ArrayList<Action> r1a = new ArrayList<>();
        r1a.add(a);r1a.add(b);r1a.add(c);

        ArrayList<Action> r2a = new ArrayList<>();
        r2a.add(a);r2a.add(d);

        ArrayList<Action> r3a = new ArrayList<>();
        r3a.add(a);r3a.add(e);

        ArrayList<Action> r4a = new ArrayList<>();
        r4a.add(a);r4a.add(e);r4a.add(f);


        //rules
        Rule R1 = new Rule(r1a,d);
        Rule R2 = new Rule(r2a,e);
        Rule R5 = new Rule(r2a,a);
        Rule R6 = new Rule(r2a,a);
        Rule R7 = new Rule(r2a,a);
        Rule R3 = new Rule(r3a,f);
        Rule R4 = new Rule(r4a,z);

        //remplisage des Actions a la base des Actions
        bF.add(a);
        bF.add(b);
        bF.add(c);

        //remplisage des régles a la base des régles
        bR.add(R1);bR.add(R5);bR.add(R6);bR.add(R7);
        bR.add(R2);
        bR.add(R3);
        bR.add(R4);


        //goal
        Action goal = z;

        System.out.println(bF_string(bF));
        System.out.println(bR_string(bR));

        //
        int i = 0;//counts rules
        try {
            while ( !bF.contains(goal) && !bR.isEmpty()){
                System.out.println("\ncurrent rule: " + (i+1) + "/" + bR.size());
                Rule rule = bR.get(i);
                System.out.println(rule.toString());
                boolean available = true;
                for (Action action:rule.conditions) {
                    System.out.println("Action loop!, current action: " + action.character);
                    if (!bF.contains(action)) {
                        available = false;
                        System.out.println(action.character + " isn't available at bF");
                        break;
                    }
                }
                if (available) {
                    if (!bF.contains(rule.result)) {
                        bF.add(rule.result);
                        System.out.println(rule.result.character + " added to bF\nRule " + rule.toString() + " removed!");
                        bR.remove(rule);
                        i--;
                    } else if (bF.contains(rule.result)){
                        System.out.println("bF already has " + rule.result.character +
                                "\n" + bF_string(bF));
                    }
                }
                i++;
                if (i>=bR.size()){
                    i = 0;
                }
            }

        } catch (Exception ee) {
            ee.printStackTrace();
        }

        if (bF.contains(goal)){
            System.out.println("\nSuccess!\nGoal Obtained");
        } else if (i==bR.size()){
            System.out.println("\nFail!\nOut of Rules");
        } else System.out.println("\nFail!\nGoal Not Obtained For Other Reasons!");

        System.out.println(bF_string(bF));

        System.out.println("rules left :" +  (bR.size()-i));
    }
    static String bF_string(ArrayList<Action> bF){
        String Action_string = "";
        for (Action Action : bF) {
            Action_string = Action_string.concat(Action.character + ", ");
        }
        return  "\nAction Base:\n" + Action_string.substring(0,Action_string.length()-2) + ".";
    }
    static String bR_string(ArrayList<Rule> bR){
        String rule_string = "";
        for (Rule rule:bR) {
            rule_string = rule_string.concat(rule.toString() + "\n");
        }
        return  "\nRule Base:\n" + rule_string.substring(0,rule_string.length()-1) + ".";
    }
}
