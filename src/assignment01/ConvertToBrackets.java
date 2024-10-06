package assignment01;


public class ConvertToBrackets {
    protected static String convertToNormalBrackets(String inflix){
        StringBuilder infixAdjusted = new StringBuilder();
        
        for(char c: inflix.toCharArray()){
            switch (c) {
                case '[', '{' -> infixAdjusted.append('(');
                case ']', '}' -> infixAdjusted.append(')');
                default -> infixAdjusted.append(c);
            }
        }

        return infixAdjusted.toString();     
    }
}
