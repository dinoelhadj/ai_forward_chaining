# ai_forward_chaining
Forward chaining algorithm for artificial intelligence and system expert

Algorithme de chaînage avant pour l'intelligence artificielle et système expert


              University of Oran1 Ahmed Ben Bella
                Department of Computer Science





                  Artificial Intelligence
                Forward Chaining Using JAVA




1.	The Data Structure:
In this project structure we have 4 types of elements:

a.	 Action: a class that represents a fact, and which has a public string named "character" for displaying that fact.

b.	Rule: a class which represents a rule, it has 2 attributes, an array of facts named "conditions" which represents the necessary facts of the rule (condition part), the second attribute "result" represents the result fact.
and a toString method to properly display the rule.

c.	ActionBase: this class represents the fact base, and it contains a single attribute which is a fact table named "ab", and methods to access or display the table.

d.	RuleBase: this class represents the rule base, it actually contains 2 rule tables, a private initial rules table named "", and a public used rules table named "". when a rule is used, it is deleted from the first table so that we do not process it again, and it will be added to the second and we will end up with the second table filled with the ordered used rules.


e.	this class also has some methods to access the first "rb" table

1.	"add ()": add a rule to "rb".
2.	"get (int i)": returns the rule at index i of the first table rb.
3.	"size ()": returns the size of the first "rb" array.
4.	"contains (Rule rule)": returns true or false if the first table contains "rule".
5.	"isEmpty ()": returns true or false if the first table is empty.
6.	"toString ()": returns a text format of the rule to better display it.
7.	"deactivate (Rule rule)": removes "rule" from the first "rb" table and adds it to the second "used_rules_base" table.
8.	"used_rule_base_toString ()": returns a text format of the rules used.
2.	Pseudo Code:
a.	 Declaration of bases:
      ActionBase actionBase = new ActionBase();
      RuleBase ruleBase = new RuleBase();
b.	Declaration of actions:
      Action a = new Action("a");
      Action b = new Action("b");
      Action c = new Action("c");
      Action d = new Action("d");
      Action e = new Action("e");
      Action f = new Action("f");
      Action z = new Action("z");

c.	Declaration of tables (Condition part of rules) :
      ArrayList<Action> r1a = new ArrayList<>();
      r1a.add(a);r1a.add(b);r1a.add(c); 

      ArrayList<Action> r2a = new ArrayList<>();
      r2a.add(a);r2a.add(d);

      ArrayList<Action> r3a = new ArrayList<>();
      r3a.add(a);r3a.add(e);

      ArrayList<Action> r4a = new ArrayList<>();
      r4a.add(a);r4a.add(e);r4a.add(f);
  
d.	Declaration of rules
new Rule(r1a,d), r1a is a,b,c, d is the result, so the rule is a,b,c => d
  
      Rule R1 = new Rule(r1a,d); 
      Rule R2 = new Rule(r2a,e);
      Rule R5 = new Rule(r2a,c);
      Rule R6 = new Rule(r2a,b);
      Rule R3 = new Rule(r3a,f);
      Rule R4 = new Rule(r4a,z);
  
a,b,c => d
a,d => e
a,d => c
a,d => b
a,e => f
a,e,f => z

e.	Adding actions to action base
      actionBase.add(a);
      actionBase.add(b);
      actionBase.add(c);
  
f.	Adding rules to rule base
      ruleBase.add(R1);ruleBase.add(R5);ruleBase.add(R6);
      ruleBase.add(R2);ruleBase.add(R3);ruleBase.add(R4);
  
g.	Declaring goal
      Action goal = z;
  
h.	Printing bases
      System.out.println(actionBase);
      System.out.println(ruleBase);
  
i.	Forward Chaining algorithm
      int i = 0;
      try {
        code1
      } catch (Exception ex){
        code2
      }
i is rule counter initialized to 0
the "try" will try to execute code1, if an error is detected in the code, the catch will execute code2
in code1 we have:
        while ( !actionBase.contains(goal) && !ruleBase.isEmpty()){
          code3
        }
the “while” will loop code3 until “actionBase.contains (goal)” (if the action base contains the goal) returns true or “ruleBase.isEmpty ()” (if the rule base is empty) returns true !
in code3 we have:
      System.out.println("\nCurrent rule: " + (i+1) + "/" + ruleBase.size());
      Rule rule = ruleBase.get(i);
      System.out.println(rule.toString());
      boolean available = true;
  
Display the current rule / unused rules 
Assign variable rule to the current rule and display it
"Available" is true if we cannot find an unavailable action in our action base
  
      for (Action action:rule.conditions) {
          System.out.println("Current action: " + action.character);
          if (!actionBase.contains(action)) {
              available = false;
              System.out.println(action.character + " isn't available at actionBase");
              break;
          }
      }
  
for all the actions in the condition part of the rule {
  display (courante ’current action:‘ ’+ done);
  if the action base contains this current action {
    available = false;
    display (action + ‘’ unavailable! ’);
    break the loop for;
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
  
if available is true {
  if actionbase does not contain the result of the rule then {
    add rule result based on facts;
    display (result + ’has been added to actionbase, rule‘ ’+ rule +‘ ’has been moved to used rules!’ ’);
    Disable(rule); 
    i--;  decrement the rule counter because in deleting a rule then the following rule number is the same as that which was deleted (after the general increment at        the end of the loop
    } else display (’actionbase already have this fact‘ ’);
}
 
      i++;
      if (i>=ruleBase.size()){
          i = 0;
      }
  
i++; general incrementation, incrementation of i each time we finish the course with a rule
if (i equals or greater than the size of rulebase) then {
  i = 0;  initialize i because we are not in the last rule so the next rule is the 1st, then i = 0;
} 
      if (actionBase.contains(goal)){
        System.out.println("Success!\nGoal Obtained");
      } else if (ruleBase.isEmpty()){
          System.out.println("Fail! Out of Rules");
      } else System.out.println("Fail!  Goal Not Obtained For Other Reasons!");
          System.out.println(actionBase);
      System.out.println("rules left :" +  (ruleBase.size()));
  
if (actionbase contains (goal)) {
  Display ("success");
} otherwise if (the rule base is empty) {
  Display ("failure!");
} else {
  Display ("unexpected case");
}
Display actionbase;
Display ("unused rules:" + rulebase size);
Display ("used rules:" +  display used rules);
  
3.	Report:
so the algorithm does the chaining before, after the declaration and all, a "while" loop (which stops only if the rule base is empty or if the goal is found in the rule base) loops all the rules and sees which one is applicable by checking the existence of their fact condition in the fact base, if they exist then the rule is applicable and the result will be added to the action base and the rule will be moved to the used rules base, at the end of the loop, the goal will be checked if it exists in action base, if yes a success message will be displayed, otherwise a failure message will be displayed, with the final action base and both of used and unused rules
