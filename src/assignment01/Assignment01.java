package assignment01;
import java.util.*;
import java.io.*;

public class Assignment01 {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        //String exp = "a+b([c^d]-e)^(f+g*h)-i=";
        
        String exp = "12+(23*34)-23*(31/5)=";
        
        exp = RemoveEqualSign.removeEqualSign(exp);
        
        String exp_1 = ConvertToBrackets.convertToNormalBrackets(exp);
        
        System.out.print(exp_1+'\n');
        
        if(CheckBrackets.areBracketBalanced(exp_1)){
            System.out.print("Formula is balanced.\n");
        }
        else{
            System.out.print("Formula is not balanced.\n");
        }
        
        exp_1 = InfixToPostFix.infixToPostFix(exp_1);
        System.out.print(exp_1+'\n');
        
        String result = EvaluatePostFix.evaluatePostFix(exp_1);
        System.out.print("Result:"+result+'\n');
        
    }
    
}
