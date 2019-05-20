
package calculator;

/**
 *   Calculator object contains:
 *   first:String - the first number
 *   second:String - the second number 
 *   operat:Char  +, -, etc.
 */
public class Calculator {
    
    private String first;
    private String second;
    private char operat;

    public Calculator(){
        first = "";
        second = "";
        operat = ' ';
    }
    
    public String setResult(String click){
        char c = click.charAt(0);
        
        if (Character.isDigit(c)){
            if (operat==' '){
                first += String.valueOf(c);
                if (first.length() > 1 && first.charAt(0) == '0' && first.charAt(1) != '.')
                    first = first.substring(1);
                return first;
            }
            else {
                second += String.valueOf(c);
                if (second.length() > 1 && second.charAt(0) == '0' && second.charAt(1) != '.')
                    second = second.substring(1);
                return second;
            }
        }
        
        else if (c=='.'){
            if (operat == ' '){
                if (first != "" && !(first.contains(".")))
                    first += String.valueOf(c);
                return first;
            }
            else {
                if (second != "" && !(second.contains(".")))
                    second += String.valueOf(c);
                return second;
            }
        }
        
        else if (c == '='){
            if (operat == ' '){
                if (first == "")
                    return "Enter number";
                else if (first.charAt(first.length()-1) == '.')
                    return "Error: bad choice";
                else if (first.contains("."))
                       return "" + Double.parseDouble(first);
                else return "" + Integer.parseInt(first);
            }
            else {
               if (second == "")
                    return "Enter number";
                else if (second.charAt(second.length()-1) == '.')
                    return "Error: bad choice";
                else {
                    String res = result(first, operat, second);
                    first = "";
                    second = "";
                    operat = ' ';
                    return res;
                } 
            }
        }
        
        else {
            if (operat == ' '){
                if (first == "")
                    return "Enter number";
                else if (first.charAt(first.length()-1) == '.')
                    return "Error: bad choice";
                else {
                    operat = c;
                    return String.valueOf(c);
                }
            }
            else {
               if (second == "")
                    return "Enter number";
                else if (second.charAt(second.length()-1) == '.')
                    return "Error: bad choice";
                else {
                    first = result (first, operat, second);
                    second = "";
                    operat = c;
                    return String.valueOf(c);
                }
            }
        }
    }
    
    public String result(String first, char c, String second){
        int x = 0;
        int y = 0;
        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);
        if (!first.contains(".") && !second.contains(".")){
            x = Integer.parseInt(first);
            y = Integer.parseInt(second);
        }
        
        if (c=='+'){
            a += b;
            x += y;
        }
        if (c=='-'){
            a -= b;
            x -= y;
        }
        if (c=='*'){
            a *= b;
            x *= y;
        }
        if (c=='%'){
            a /= b;
            if (y!=0)
                x /= y;
        }
        
        if (a == x)
            return "" + x;
        return "" + a;           
    }
}
