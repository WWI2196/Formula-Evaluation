package assignment01;
import java.util.*;

public class InfixToPostFix {
    protected static String infixToPostFix(String infix){
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(char c: infix.toCharArray()){
            if(c==' '){
                continue;
            }
            
            if (Character.isDigit(c)||c=='.'){
                postFix.append(c);
            }
            else {
                if ( postFix.length()>0 && postFix.charAt(postFix.length()-1) != ' '){
                postFix.append(' ');
                }
            }
            
            if (c == '('){
                stack.push(c);
            }
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    postFix.append(stack.pop());
                }
                if (!stack.isEmpty()){
                stack.pop(); // To remove the '(' from the stack
                }

            }
            else if(isOperator(c)){
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    postFix.append(stack.pop());
                }
                
                stack.push(c); 
            }
        }
        
        while(!stack.isEmpty()){
            postFix.append(stack.pop());
        }
       
        return postFix.toString();
        
    }
    
    private static int precedence(Character operator){
        return switch (operator) {
            case '-' -> 1;
            case '+' -> 2;
            case '*' -> 3;
            case '/' -> 4;
            default -> -1;
        };
    }
    
    protected static boolean isOperator(Character c){
        return (c == '-'||c=='+'||c=='*'||c=='/');
    }
}
