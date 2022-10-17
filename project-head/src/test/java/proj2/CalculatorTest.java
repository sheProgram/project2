package proj2;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
