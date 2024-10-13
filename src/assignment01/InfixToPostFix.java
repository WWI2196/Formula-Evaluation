package assignment01;
import java.util.*;

public class InfixToPostFix {
    protected static String convertInFlixToPostFix(String inflix){
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (char c:inflix.toCharArray()){
            if (c == ' '){ // if black space was found simply continue to the next character of the inflix formula 
                continue;
            }
            
            if (Character.isDigit(c) || c == '.'){ // if a number/decimal place is found add it to the string
                postFix.append(c);
            }
            else{
                if (postFix.length()>0 && postFix.charAt(postFix.length()-1) != ' '){ // if postfix has black space 
                    postFix.append(' ');
                }
            }
            
            if (c == '('){
                stack.push(c);
            }
            else if(c == ')'){ // handle for the brackets
                while (!stack.isEmpty() && stack.peek() !='('){
                    postFix.append(stack.pop());
                }
                
                if (!stack.isEmpty()){
                    stack.pop();
                } 
            }
            else if(isOperator(c)){ // handle the opetors accorinf to the presendence
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    postFix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()){
            postFix.append(stack.pop());
        }
        return postFix.toString(); 
    }
    
    private static int precedence(Character operator){ // precedence for the operators
        return switch(operator){
            case '-','+' -> 1;
            case '*','/' -> 2;
            default -> -1;
        };
    }
    
    protected static boolean isOperator(Character c){
        return (c == '+'||c == '-'|| c == '*'|| c == '/');
    }
}
