package assignment01;

import java.util.*;

public class CheckBrackets {
    
    protected static boolean areBracketBalanced(String formula){
        Stack<Character> bracketStack = new Stack<>();
        
        for(char c: formula.toCharArray() ){
            if (c == '(' || c == '[' || c == '{'){
                bracketStack.push(c);
            }
            else if ( c == ')' || c == ']' || c == '}'){
                if (bracketStack.empty()){
                    return false;
                }
                
                char c_1 = bracketStack.pop();
                if(!((c_1 == '(' && c == ')')||
                   (c_1 == '[' && c == ']')||
                   (c_1 == '{' && c == '}'))){
                    return false;
                }
            }
        }
        return bracketStack.empty();
    }
}
