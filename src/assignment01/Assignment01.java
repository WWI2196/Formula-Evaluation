package assignment01;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Assignment01 {
    public static void main(String[] args) throws IOException {

        List<String> formulas = Files.readAllLines(Paths.get("C:/Users/Wansajee/Documents/NetBeansProjects/Assignment01/src/assignment01/formulas.txt"));
        List<String> results = new ArrayList<>();
        
        for (String formula: formulas){
            if (formula.trim().isEmpty()) {
                continue;  // Skip empty lines
            }
            
            String formulaCopy = formula;
            if(!formulaCopy.trim().endsWith("=") && !CheckBrackets.areBracketBalanced(formula)){
                results.add(formula +" E ");
                continue;
            }
            
            try{
                formulaCopy = RemoveEqualSign.removeEqualSign(formulaCopy);
                formulaCopy = ConvertToBrackets.convertToNormalBrackets(formulaCopy);

                String result = EvaluatePostFix.evaluatePostFix(InfixToPostFix.infixToPostFix(formulaCopy));

                results.add(formula+result);
            }
            catch(Exception e){
                results.add(formula+" E ");
            }
        }
        
        Files.write(Paths.get("C:/Users/Wansajee/Documents/NetBeansProjects/Assignment01/src/assignment01/result.txt"), results);
        
        
        
        //String exp = "a+b([c^d]-e)^(f+g*h)-i=";

        
    }
    
}
