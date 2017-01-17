package cs2s03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPQ {

	
	AListPQueue pq;
	
	// this will create a new instance of the
	// object every time a class is called
	@Before
	public void setUp() {
		pq = new AListPQueue('a', 4, new AListPQueue('f', 8, 
				new AListPQueue('r', 3)));
	}
	
	@Test
	public void PQtest1(){
		//test insertItem
		pq.insertItem(4, 'b');
		assertEquals("<8f4a4b3r>", pq.toString());
	}
	@Test
	public void PQtest2(){
		//test deleteItem()
		pq.deleteItem();
		assertEquals("<4a3r>", pq.toString());
	}
	@Test
	public void PQtest3() throws EmptyContainerException{
		//test next();
		pq.insertItem(10, pq.next());
		assertEquals("<10f8f4a3r>", pq.toString());
	}
	@Test
	public void PQtest4() throws EmptyContainerException{
		pq.insertItem(15, pq.next());
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(3, pq.next());
		pq.insertItem(26, 'o');
		assertEquals("<26o4a3a3r>", pq.toString());
	}
	
	@Test
	public void PQtest5() throws EmptyContainerException{
		//operation over 15
		pq.insertItem(5, 'i');
		pq.insertItem(11, 'p');
		pq.insertItem(11, 'b');
		pq.insertItem(16, 'k');
		pq.insertItem(9, 'm');
		pq.deleteItem();
		pq.next();
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(4, pq.next());
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(10, 'l');
		pq.deleteItem();
		pq.insertItem(13, 'z');
		pq.deleteItem();		
		assertEquals("<3r>", pq.toString());
	}
	@Test
	public void PQtest6(){
		//operation over 15
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(7, 'y');
		pq.insertItem(15, 'j');
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(8, 'q');
		pq.insertItem(8, 'q');
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(23, 'u');
		pq.insertItem(17, 'v');	
		pq.deleteItem();
		pq.insertItem(17, 'v');	
		pq.deleteItem();	
		assertEquals("<17v>", pq.toString());
	}
	
	@Test
	public void PQtest7() throws EmptyContainerException{
		//operation over 15
		pq.deleteItem();
		pq.insertItem(14, 'a');
		pq.insertItem(11, 'd');
		pq.insertItem(9, pq.next());
		pq.insertItem(27, 'c');
		pq.insertItem(1, 't');
		pq.insertItem(18, 'w');
		pq.deleteItem();
		pq.insertItem(2, pq.next());
		pq.insertItem(18, 'w');
		pq.insertItem(23, 'q');
		pq.insertItem(19, 'g');
		pq.insertItem(14, 'm');
		pq.insertItem(20, 'l');
		pq.insertItem(8, 'w');
		pq.insertItem(13, 'h');
		pq.insertItem(5, 's');
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		assertEquals("<18w14a14m13h11d9a8w5s4a3r2w1t>", pq.toString());
	}
	
	@Test(expected = EmptyContainerException.class)
	public void PQtest8() throws EmptyContainerException{
		//exception
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.next();
		fail("Expected exception does not occur");
	}
	
	@Test(expected = EmptyContainerException.class)
	public void PQtest9() throws EmptyContainerException{
		//exception
		pq.insertItem(12, 'g');
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(14, 'm');
		pq.insertItem(8, 'q');
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(1, pq.next());
		fail("Expected exception does not occur");
	}
	
	@Test(expected = EmptyContainerException.class)
	public void PQtest10() throws EmptyContainerException{
		//exception
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.deleteItem();
		pq.insertItem(14, 'm');
		pq.deleteItem();
		pq.insertItem(14, 'm');
		pq.deleteItem();
		pq.insertItem(14, 'm');
		pq.deleteItem();
		pq.next();
		fail("Expected exception does not occur");
	}
	
	@Test
	public void PQadditionalTest(){
		AListPQueue pq1 = new AListPQueue();
		assertEquals("<>", pq1.toString());
		AListPQueue pq2 = new AListPQueue('a', 5);
		assertEquals("<5a>", pq2.toString());
		pq1.insertItem(5, 'a');
		pq1.deleteItem();
		pq2.deleteItem();
		assertEquals(true, pq2.equals(pq1));
		pq1.insertItem(4, 'a');
		pq1.insertItem(8, 'f');
		pq1.insertItem(3, 'r');
		assertEquals(true, pq.equals(pq1));
		
	}
}
