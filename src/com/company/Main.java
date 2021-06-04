package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

	    //declaration
        ArrayList<Fait> bF = new ArrayList<>();
        ArrayList<Rule> bR = new ArrayList<>();

        //faits
        Fait a = new Fait("a");
        Fait b = new Fait("b");
        Fait c = new Fait("c");
        Fait d = new Fait("d");
        Fait e = new Fait("e");
        Fait f = new Fait("f");
        Fait z = new Fait("z");

        //partie conditions pour les régles
        ArrayList<Fait> r1a = new ArrayList<>();
        r1a.add(a);r1a.add(b);r1a.add(c);

        ArrayList<Fait> r2a = new ArrayList<>();
        r2a.add(a);r2a.add(d);

        ArrayList<Fait> r3a = new ArrayList<>();
        r3a.add(a);r3a.add(e);
        
        ArrayList<Fait> r4a = new ArrayList<>();
        r4a.add(a);r4a.add(e);r4a.add(f);
        

        //rules
        Rule R1 = new Rule(r1a,d);
        Rule R2 = new Rule(r2a,e);
        Rule R3 = new Rule(r3a,f);
        Rule R4 = new Rule(r4a,z);

	    //remplisage des faits a la base des faits
        bF.add(a);
        bF.add(b);
        bF.add(c);

        //remplisage des régles a la base des régles
        bR.add(R1);
        bR.add(R2);
        bR.add(R3);
        bR.add(R4);

        //but
        Fait goal = z;

        System.out.println(bF_string(bF));
        System.out.println(bR_string(bR));

        //
        int i = 0;//counts rules
        try {
            while ( !bF.contains(goal) && i <= bR.size()){
                System.out.println("\nwhile started!\n");
                System.out.println("rules loop! size:" + bR.size() + ", current rule: " + (i+1));
                Rule rule = bR.get(i);
                System.out.println(rule.toString());
                boolean available = true;
                for (Fait fait:rule.conditions) {
                    System.out.println("fait loop!, current fait: " + fait.character);
                    if (!bF.contains(fait)) {
                        available = false;
                        System.out.println(fait.character + " isn't available at bF");
                        break;
                    }
                }
                if (available) {
                    if (!bF.contains(rule.result)) {
                        bF.add(rule.result);
                        System.out.println(rule.result.character + " added to bF");
                    } else if (bF.contains(rule.result)){
                        System.out.println("bF already has " + rule.result.character +
                                "\n" + bF_string(bF));
                    }
                }
                i++;
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
    static String bF_string(ArrayList<Fait> bF){
        String fait_string = "";
        for (Fait fait : bF) {
            fait_string = fait_string.concat(fait.character + ", ");
        }
        return  "\nFait Base:\n" + fait_string.substring(0,fait_string.length()-2) + ".";
    }
    static String bR_string(ArrayList<Rule> bR){
        String rule_string = "";
        for (Rule rule:bR) {
            rule_string = rule_string.concat(rule.toString() + "\n");
        }
        return  "\nRule Base:\n" + rule_string.substring(0,rule_string.length()-1) + ".";
    }
}
