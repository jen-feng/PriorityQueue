package cs2s03;

public interface MyPriorityQueue {

	  public char next() throws EmptyContainerException; // highest priority
	  public void deleteItem(); // highest priority
	  public void insertItem(int p, char c); // int priority, then alphabetical
	  public boolean isEmpty();
	  public String toString(); // you must implement this
	  
}