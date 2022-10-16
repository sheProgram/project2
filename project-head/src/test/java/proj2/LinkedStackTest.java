package proj2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

public class LinkedStackTest {
    private Stack testStack;

	@Test 
    public void checkifNull ()
    {
        testStack.push(null);
        assertEquals(null, testStack.pop());
    }
      
}
