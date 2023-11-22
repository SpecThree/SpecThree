import java.util.*;

public class SortMountains
{
	public static void main(String[] args)
	{
		new SortMountains().go();
	}
	
	public void go()
	{
		List<Mountain> mountains = new ArrayList<>();
		mountains.add(new Mountain("Longs", 14255));
		mountains.add(new Mountain("Elbert", 14433));
		mountains.add(new Mountain("Maroon", 14156));
		mountains.add(new Mountain("Castle", 14265));
		System.out.println("as entered:\n" + mountains);
		
		mountains.sort((one, two)->one.myName.compareTo(two.myName));
		System.out.println("by name:\n" + mountains);
		
		mountains.sort((one, two)->Integer.valueOf(two.myHeight).compareTo(one.myHeight));
		System.out.println("by height:\n" + mountains);
	}
}

class Mountain
{
	String myName;
	int myHeight;
	
	public Mountain(String iName, int iHeight)
	{
		myName = iName;
		myHeight = iHeight;
	}
	
	public String toString()
	{
		return myName + ' ' + myHeight;
	}
	
}