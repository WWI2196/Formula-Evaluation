package assignment01;

public class RemoveEqualSign {
   protected static String removeEqualSign(String inflix){
        
        if(inflix.endsWith("=")){ // check the last character of the formula for '='
            inflix = inflix.substring(0, inflix.length()-1); // if the last element is '=', take the rest of the formula removing the last element
        }
        return inflix;
    }
    
}
