package proj2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedStackTest {
    /** Test case values: push 5,4,3,2,1 and pop twice
 *   Expected output: value at the top is 3 */
    @Test
    <T> void checkStack() {
        LinkedStack<Integer> st = new LinkedStack<>();
        st.push(5); 
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        st.pop();
        st.pop();
        assertEquals(3, st.pop());
    }

    /** Test case values: push 5,4,3,2,1,0
 *   Expected output: stack is not empty */
    @Test
    <T> void stackNotEmpty() {
        LinkedStack<Integer> st = new LinkedStack<>();
        st.push(5); 
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(1);
        st.push(0);
        st.pop();
        st.pop();
        assertEquals(false, st.isEmpty());
    }
    @Test
    <T> void stackhasempty(){
        LinkedStack<Integer> st = new LinkedStack<>();
        st.push(0); 
        st.push(5);
        st.push(0);
        st.push(1);
        st.push(0);
        st.pop();
        st.pop();
        assertEquals(0, st.pop());
    }
}
