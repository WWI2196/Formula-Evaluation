package assignment01;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Assignment01 {
private static final String READPATH = "src/formula_evaluator/formulas.txt"; // to set the file paths
private static final String WRITEPATH = "src/formula_evaluator/result.txt";

    public static void main(String[] args) throws IOException {

        List<String> formulas = Files.readAllLines(Paths.get(READPATH)); // read the lines from the text file and add them to the array
        List<String> results = new ArrayList<>(); // array to store the results with the formula
        
        for (String formula:formulas){
            if(formula.trim().isEmpty()){ // for any empty lines, ignore those and continue
                continue;
            }

            if (!formula.trim().endsWith("=") || !CheckBrackets.areBracketsBalanced(formula)){ // check whether the formula is ending with a '=' and it is balanced 
                results.add(formula+"E"); // if not add a E to the statement
                continue;
            }
            try{
                String formulaCopy = RemoveEqualSign.removeEqualSign(formula); // take a copy of the formula and remove '='
                formulaCopy = ConvertToBrackets.convertToNormalBrackets(formulaCopy); // generalize the formual
                String result = EvaluatePostFix.evaluatePostFix(InfixToPostFix.convertInFlixToPostFix(formulaCopy)); // evaluate the statement

                results.add(formula+result); // add the result to the end of the formula 
            }
            catch(Exception e){ // handle any exceptions by add E to the end of the formula
                results.add(formula+"E");
            }
        }
        
        Files.write(Paths.get(WRITEPATH), results); // write the results to the text file

    }
    
}
