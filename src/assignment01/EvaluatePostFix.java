package assignment01;

import java.text.DecimalFormat;
import java.util.*;

public class EvaluatePostFix {
    protected static String evaluatePostFix(String postFix){
        Stack<Double> stack = new Stack<>();
        StringBuilder number = new StringBuilder();
        
        for (Character c: postFix.toCharArray()){
            if(c==' ' && !number.isEmpty()){
                stack.push(Double.valueOf(number.toString()));
                number.setLength(0); // to clear out the number
                continue;
            }
            
            if (Character.isDigit(c) || c=='.'){
                number.append(c);
            }
            
            if (InfixToPostFix.isOperator(c) && !stack.isEmpty()){
                if (!number.isEmpty()){
                    stack.push(Double.valueOf(number.toString()));
                    number.setLength(0);
                }
                Double b = stack.pop();
                Double a = stack.pop();
                
                stack.push(evaluate(a,b,c));
            }
        }
        DecimalFormat df = new DecimalFormat("#.00");
        
        return df.format(stack.pop());
    }
    
    private static Double evaluate(Double a,Double b,Character operator){
        return switch(operator){
            case '+'-> a+b;
            case '-'-> a-b;
            case '*'-> a*b;
            case '/'-> {
                if (b == 0){
                    throw new IllegalArgumentException();
                }
                yield a/b;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}

    

