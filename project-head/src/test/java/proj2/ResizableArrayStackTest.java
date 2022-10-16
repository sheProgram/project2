package proj2;
import org.junit.jupiter.api.Test;


public class ResizableArrayStackTest {
	private int topIndex = -1; // Index of top entry
    private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

  // end constructor
    @Test
    public void isEmpty() {
        if (topIndex < 0) {
            System.out.println("Stack is empty");
        }
    }
}

