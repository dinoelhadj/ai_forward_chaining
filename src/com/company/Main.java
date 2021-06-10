package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        //declaration des bases
        ActionBase actionBase = new ActionBase();
        RuleBase ruleBase = new RuleBase();

        //declataion des faits
        Action a = new Action("a");
        Action b = new Action("b");
        Action c = new Action("c");
        Action d = new Action("d");
        Action e = new Action("e");
        Action f = new Action("f");
        Action z = new Action("z");

        //declaration des tables (partie condition pour les régles)
        ArrayList<Action> r1a = new ArrayList<>();
        r1a.add(a);r1a.add(b);r1a.add(c); // a, b ,c

        ArrayList<Action> r2a = new ArrayList<>();
        r2a.add(a);r2a.add(d); // a, d

        ArrayList<Action> r3a = new ArrayList<>();
        r3a.add(a);r3a.add(e); // a, e

        ArrayList<Action> r4a = new ArrayList<>();
        r4a.add(a);r4a.add(e);r4a.add(f);// a, e, f


        //declaration des régles
        //new Rule(r1a,d), r1a c’est a,b,c, d est la résultat, alors la régle est a,b,c => d
        Rule R1 = new Rule(r1a,d); // a,b,c => d
        Rule R2 = new Rule(r2a,e); // a,d => e
        Rule R5 = new Rule(r2a,c); // a,d => c
        Rule R6 = new Rule(r2a,b); // a,d => b
        Rule R3 = new Rule(r3a,f); // a,e => f
        Rule R4 = new Rule(r4a,z); // a,e,f => z

        // ajout de faits à la base des faits
        actionBase.add(a);
        actionBase.add(b);
        actionBase.add(c);

        //ajout de régles à la base des régles
        ruleBase.add(R1);ruleBase.add(R5);ruleBase.add(R6);
        ruleBase.add(R2);ruleBase.add(R3);ruleBase.add(R4);


        //déclaration de but
        Action goal = z;

        //affichage des bases
        System.out.println(actionBase);
        System.out.println(ruleBase);

        //compteur de régles
        int i = 0;
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
        } else if (ruleBase.isEmpty()){
            System.out.println("\nFail!\nOut of Rules");
        } else System.out.println("\nFail!\nGoal Not Obtained For Other Reasons!");

        System.out.println(actionBase);

        System.out.println("rules left :" +  (ruleBase.size()));
    }
}
