package proj2;
/**
 * convertToPostfix and evaluate postfix, in addition to side methods to check in our main methods which are to check the precedent and to calculate the sorted postfix
 * 
 * @author Mohraiel Matta, Tiffany Truong, Erika Ledesma
 * 
 */
import java.lang.Math;
public class Calculator {
    public static void main(String[] args) {
        String infix = "a*b/(c-a)+d*e";
        String postfix = convertToPostfix(infix);
        System.out.println("Infix expression: " + infix + "\nPostfix expression: " + postfix);

        // after getting the postfix from covertToPostfix, print out result for evaluatePostfix -- result displays 33
        int result = evaluatePostfix(postfix);
        System.out.println("Assuming when a=2, b=3, c=4, d=5, e=6, the result is: " + result);
    }

        private static int checkprec(char operator) {
            switch (operator) {
                //switch statement best way to sort and convert as we tried in class
                //in order for precedence
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '^':
                    return 3;
                case '(':
                case ')':
                    return 0;
            }
            return operator;
        }

        /**a method in order to convert the given infex into postfix
         * @param infix An infix expression.
         * @return postfix expression that has been converted */
        public static String convertToPostfix(String infix) {
            //implements linkedstack
            LinkedStack<Character> opstack = new LinkedStack<Character>();
            String postfix = "";
            char nextChar = infix.charAt(0);
            int end = infix.length() - 1;
            for (int spc = 0; spc <= end; spc++) {
                nextChar = infix.charAt(spc);
                switch (nextChar) {
                    case 'a':
                    case 'b':
                    case 'c':
                    case 'd':
                    case 'e':
                        postfix += nextChar;
                        break;
                    //checks for the signs then looks are their precedence
                    case '^':
                        opstack.push(nextChar);
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    //while the stack is !empty and the precedent is checked, if it is less than or equal to the precedent, it will go to top value of stack and pop opstack to the postifx
                        while (!opstack.isEmpty() && (checkprec(nextChar) <= checkprec(opstack.peek()))) {
                        postfix += opstack.peek();
                        opstack.pop();
                        }
                        opstack.push(nextChar);
                        break;
                    case '(':
                        opstack.push(nextChar);
                        break;
                    case ')':
                    //in order to check the parenthesis 
                        char top = opstack.pop();
                        while (!opstack.isEmpty() && top != '(') {
                            postfix += top;
                            top = opstack.pop();
                        }
                        break;
                }
            }
            while (!opstack.isEmpty() || opstack == null) {
                char topOperator = opstack.pop();
                postfix += topOperator;
            }

            return postfix;//postfix in result
        }

    /** 
    * Evaluates a postfix expression, provided that all variables in the postfix expression are replaced by their respective values 
    @param postfix A postfix expression.
    @return An integer value obtained after evaluating the postfix expression. */
    public static int evaluatePostfix(String postfix) {
        // evaluates a postfix expression
        ResizableArrayStack<Integer> valueStack = new ResizableArrayStack<>(); // call a new empty stack 

        int index = 0;
        int result = 0;
        while (index < postfix.length()) { // while loop to check while posfix has characters left to parse
            Character nextCharacter = postfix.charAt(index);
            // switch statement to take in variable and switch it with the value of the variable 
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
                result = calculate(nextCharacter, operandOne, operandTwo); // call the method calculate to calculate the result
                valueStack.push(result); // push the result 
                default: break; // ignore unexpected characters
            } // end of switch
            ++index;
        } // end of while 
        return valueStack.peek(); // returns the final result 
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
        return result; // returns the end result 
    } // end of calculate
}