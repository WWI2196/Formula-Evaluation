package assignment01;

public class RemoveEqualSign {
    protected static String removeEqualSign(String infix){
        if (infix.endsWith("=")){
          infix = infix.substring(0, infix.length()-1);
        }
        return infix;  
    }
    
}
