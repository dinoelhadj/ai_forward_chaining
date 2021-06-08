package com.company;

import java.util.ArrayList;

public class RuleBase {
    private ArrayList<Rule> rb;
    public ArrayList<Rule> used_rules_base;

    public RuleBase() {
        rb = new ArrayList<>();
        used_rules_base = new ArrayList<>();
    }

    public void add(Rule rule){
        rb.add(rule);
    }
    /*public void remove(Rule rule){
        rb.remove(rule);
    }*/
    public Rule get(int i){
        return rb.get(i);
    }
    public void deactivate(Rule rule){
        rb.remove(rule);
        used_rules_base.add(rule);
    }
    public int size(){
        return rb.size();
    }
    public boolean contains(Rule rule){
        return rb.contains(rule);
    }
    public boolean isEmpty(){
        return rb.isEmpty();
    }
    @Override
    public String toString() {
        String rule_string = "";
        for (Rule rule:rb) {
            rule_string = rule_string.concat(rule.toString() + "\n");
        }
        return  "\nRule Base:\n" + rule_string.substring(0,rule_string.length()-1) + ".";
    }
}
