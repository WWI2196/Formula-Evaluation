package assignment01;

import java.util.*;

public class CheckBrackets {
    
   protected static boolean areBracketsBalanced(String formula){
        Stack<Character> bracketStack = new Stack<>();
        
        for (char c:formula.toCharArray()){
            if (c == '('||c == '['||c == '{'){ // for open brackets, push them to the stack
                bracketStack.push(c);
            }
            
            if (c == ')'||c == ']'||c == '}'){ // if close brackets found, check whether the current stack element is the corresponding open bracket
                if(bracketStack.empty()){
                    return false;
                }
                
                char c_1 = bracketStack.pop();

                if (!((c_1 == '(' && c == ')')||
                    (c_1 == '[' && c == ']')||
                    (c_1 == '{' && c == '}'))){
                    return false; // if the stack element is not the corresponding open bracket, return false
                }
            }
        }
        return bracketStack.empty(); // otherwise return true
    }
}
