package proj2;

import java.lang.Math;
public class Calculator {
    public static void main(String[] args) {
        String infix = "a*b/(c-a)+d*e";
        String postfix = "[postfix] here";

        System.out.println("Infix expression: " + infix + "\nPostfix expression: " + postfix);

        // just for testing purposes to check if evaluatePostfix method works
        System.out.println("Result: " + evaluatePostfix(postfix));
    }

    // public static String convertToPostfix(String infix){

    // }


    /** 
    * Evaluates a postfix expression, provided that all variables in the postfix expression are replaced by their respective values */
    public static int evaluatePostfix(String postfix) {
        // evaluates a postfix expression
        ResizableArrayStack<Integer> valueStack = new ResizableArrayStack<>();

        int index = 0;
        int result = 0;
        while (index < postfix.length()) {
            Character nextCharacter = postfix.charAt(index);
            switch (nextCharacter) {
                case 'a': 
                    valueStack.push(2);
                    break;
                case 'b':
                    valueStack.push(3);
                    break;
                case 'c':
                    valueStack.push(4);
                    break;
                case 'd':
                    valueStack.push(5);
                    break;
                case 'e':
                    valueStack.push(6);
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                int operandTwo = valueStack.pop();
                int operandOne = valueStack.pop();
                result = calculate(nextCharacter, operandOne, operandTwo);
                valueStack.push(result);
                default: break; // ignore unexpected characters
            }
        }
        return valueStack.peek();
    } // end evaluatePostfix

    // performs the mathematical operator on the two operands that were passed in as arguments
    private static int calculate(char mathVariable, int val1, int val2)
    {
        int result = 0;

        switch (mathVariable)
        {
            case '+' :
                // perform addition.
                result = val1 + val2;
                break;
            case '-' :
                // perform subtraction.
                result = val1 - val2;
                break;
            case '*' :
                // perform multiplication.
                result = val1 * val2;
                break;
            case '/' :
                // perform division.
                result = val1 / val2;
                break;
            case '^' :
                result = (int) Math.pow(val1,val2);
                break;
            default : break;
        } // end switch
        return result;
    } // end of calculate
    
}