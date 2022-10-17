package proj2;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * unit test cases for calculator, testing sortings and conversions in addition to evaluations
 * 
 * @author Mohraiel Matta
 * 
 */
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    void anotherexcalc(){
            String infix = "a+b*(c/a)+d*e";
            System.out.println("Infix expression: " + infix + "\nPostfix expression: " + Calculator.convertToPostfix(infix));
    
            int result = Calculator.evaluatePostfix(Calculator.convertToPostfix(infix));
            System.out.println("Assuming when a=2, b=3, c=4, d=5, e=6, the result is: " + result);
        }
    
     @Test
        void moreparenthesis(){
                String infix = "a+b*(c/a)/(d-e)";
                System.out.println("Infix expression: " + infix + "\nPostfix expression: " + Calculator.convertToPostfix(infix));
        
                int result = Calculator.evaluatePostfix(Calculator.convertToPostfix(infix));
                System.out.println("Assuming when a=2, b=3, c=4, d=5, e=6, the result is: " + result);
            }
    @Test
        void lessletters(){
                String infix = "(a*c)+(e+b)";
                System.out.println("Infix expression: " + infix + "\nPostfix expression: " + Calculator.convertToPostfix(infix));
            
                int result = Calculator.evaluatePostfix(Calculator.convertToPostfix(infix));
                System.out.println("Assuming when a=2, b=3, c=4, d=5, e=6, the result is: " + result);
                }   
    @Test
    void subtraction(){
        String sub = "";
        sub = Calculator.convertToPostfix("a-e");
        assertEquals(sub, "ae-");
    }

    @Test
    void addition(){
        String add="";
        add=Calculator.convertToPostfix("c+d");
        assertEquals(add,"cd+");
    }

    @Test
    void division(){
        String div="";
        div=Calculator.convertToPostfix("e/e");
        assertEquals(div,"ee/"); 
    }

    @Test 
    void multiplication() {
        String mul = "";
        mul=Calculator.convertToPostfix("d*b");
        assertEquals(mul, "db*");
    }

    @Test 
    void exponential() {
        String exp = "";
        exp = Calculator.convertToPostfix("a^b");
        assertEquals(exp, "ab^");
    }

    @Test
    void emptycalc(){
        String emp="";
        emp=Calculator.convertToPostfix(" ");
        assertEquals(emp, "");
    }

        
    }
