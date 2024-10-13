package assignment01;

import java.text.DecimalFormat;
import java.util.*;

public class EvaluatePostFix {
   protected static String evaluatePostFix(String postFix){
       Stack<Double> stack = new Stack<>(); // stack to store the numbers yo calculate the result
       StringBuilder number = new StringBuilder(); // string to store the final result
       
       for (char c: postFix.toCharArray()){
           if (c == ' ' && !number.isEmpty()){
               stack.push(Double.valueOf(number.toString())); // if blank space found, push the number in the string to the stack
               number.setLength(0); // to clear out the number buffer/string
               continue;
           }
           
           if(Character.isDigit(c)|| c == '.'){ // if a number is found add it to the string
               number.append(c);
           }
           if(InfixToPostFix.isOperator(c) && !stack.isEmpty()){ // if a operator is found evaluate
               if (!number.isEmpty()){
                   stack.push(Double.valueOf(number.toString()));
                   number.setLength(0);
               }
               Double b = stack.pop();
               Double a = stack.pop();
               
               stack.push(evaluate(a,b,c));
           }
       }
       
       DecimalFormat df = new DecimalFormat("#.00"); // to get the decimals upto two ploaces
       return df.format(stack.pop());
   }
   
   private static Double evaluate(Double a,Double b,Character operator){ // to calculate the evaluation
       return switch(operator){
           case '+' -> a+b;
           case '-' -> a-b;
           case '*' -> a*b;
           case '/' ->{
               if (b == 0){
                   throw new IllegalArgumentException();
               }
               yield a/b;
           }
           default-> throw new IllegalArgumentException();
       };
   }
}

    

