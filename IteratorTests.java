import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test; // fixes some compile problems with annotations

public class IteratorTests{

  public static void main(String args[]) {
    org.junit.runner.JUnitCore.main("IteratorTests");
  }

	@Test (timeout=1000)
	public void test_1()
	{
		// Let's not use ArraySet.add() to create the set because the .add()
		// might not work properly. Instead, get a reference to the internal
		// ArrayList and use the .add() method on that directly
		ArraySet<String> set = new ArraySet<String>();
		List<String> al = set.asList();
		al.add("Hello");
		al.add("Mason");
		al.add("Nation");
		String merged = "";
		for(String s : set)
			merged += s;
		assertEquals("iterator is incorrect", "HelloMasonNation", merged);
	}

	@Test (timeout=1000)
	public void test_2()
	{
		// Let's not use ArraySet.add() to create the set because the .add()
		// might not work properly. Instead, get a reference to the internal
		// ArrayList and use the .add() method on that directly
		ArraySet<Integer> set = new ArraySet<Integer>();
		List<Integer> al = set.asList();
		al.add(-7);
		al.add(876);
		al.add(1034);
		al.add(891021);
		String merged = "";
		for(Integer i : set)
			merged += i+",";
		assertEquals("iterator is incorrect", "-7,876,1034,891021,", merged);
	}

	@Test (timeout=1000)
	public void test_3()
	{
		// Let's not use ArraySet.add() to create the set because the .add()
		// might not work properly. Instead, get a reference to the internal
		// ArrayList and use the .add() method on that directly
		ArraySet<Boolean> set = new ArraySet<Boolean>();
		List<Boolean> al = set.asList();
		Boolean[] bl = {true,false,false};
		for(int i=0; i<bl.length; i++)
			al.add(bl[i]);
		Iterator<Boolean> it = set.iterator();
		assertEquals("iterator's hasNext() is incorrect", true, it.hasNext());
		assertEquals("iterator's next() is incorrect", true, it.next());
		assertEquals("iterator's hasNext() is incorrect", true, it.hasNext());
		assertEquals("iterator's next() is incorrect", false, it.next());
		assertEquals("iterator's hasNext() is incorrect", true, it.hasNext());
		assertEquals("iterator's next() is incorrect", false, it.next());
		assertEquals("iterator's hasNext() is incorrect", false, it.hasNext());
	}

}
