package proj2;

import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor
  
//  < Implementations of the stack operations go here. >
//  . . .

	private class Node
	{
      private T data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(T dataPortion)
      {
         this(dataPortion, null);
      } // end constructor
      
      private Node(T dataPortion, Node linkPortion)
      {
         data = dataPortion;
         next = linkPortion;
      } // end constructor
      
      private T getData()
      {
         return data;
      } // end getData
      
      private Node getNextNode()
      {
         return next;
      } // end getNextNode
      
	} // end Node

   public void push(T newEntry) {
      topNode = new Node(newEntry, topNode);
   } // end push

   public T pop() {
      T top = peek();
      topNode = topNode.getNextNode();
      return top;
   } // end pop

   public T peek() {
      if (isEmpty()){
         throw new EmptyStackException();
      } else {
         return topNode.getData();
      } // end peek
   }

   public boolean isEmpty() {
      return topNode == null;
   } // end isEmpty


   public void clear() {
      topNode = null;
   } // end clear
} // end LinkedStack
