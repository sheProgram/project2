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
    void subtraction(){
        String sub = "";
        sub = Calculator.convertToPostfix("a-b");
        assertEquals(sub, "ab-");
    }

    @Test
    void addition(){
        String add="";
        add=Calculator.convertToPostfix("a+b");
        assertEquals(add,"ab+");
    }

    @Test
    void division(){
        String div="";
        div=Calculator.convertToPostfix("a/b");
        assertEquals(div,"ab/"); 
    }

    @Test 
    void multiplication() {
        String mul = "";
        mul=Calculator.convertToPostfix("a*b");
        assertEquals(mul, "ab*");
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
        
    }
