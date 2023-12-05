public class TestThread
{
	public static int count = 0;
	
	public static void main(String[] args)
	{
		Thread testThread = new Thread(()->new TestThread().startThread());
		testThread.start();
		System.out.println(Thread.currentThread().getName() + ": top of the main stack");
		Thread.dumpStack();	
	}
	
	public void startThread()
	{
		if (++count < 10)
		{
			new Thread(this::startThread).start();
		}
		go();
	}
	
	public void go()
	{
		doMore();
	}
	
	private void doMore()
	{
		System.out.println(Thread.currentThread().getName() + ": top of the Thread stack");
		Thread.dumpStack();	
	}
}