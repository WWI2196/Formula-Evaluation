package assignment01;


public class ConvertToBrackets {
    protected static String convertToNormalBrackets(String infix){
        StringBuilder normalizedInflix = new StringBuilder(); // string top store the generalized formula
        
        for (char c: infix.toCharArray()){
            switch(c){
                case '[','{' -> normalizedInflix.append('(');
                case ']','}' -> normalizedInflix.append(')');
                default -> normalizedInflix.append(c); // non bracket type charcters are added to the string statement without any change
            }
        }
        return normalizedInflix.toString();
    }
}
