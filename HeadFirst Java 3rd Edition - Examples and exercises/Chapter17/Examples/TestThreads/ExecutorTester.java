import java.util.concurrent.*;

class ExecutorTester
{
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(()->new TestThread().go());
		System.out.println(Thread.currentThread().getName() + ": back in main");
		Thread.dumpStack();
		executor.shutdown();
	}
}