import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

class TestAtomicCAS
{
	
	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Atomic instance = new Atomic();
		for (int i = 0; i < 1000; i++)
		{
			pool.execute(()->instance.increment());
		}
		pool.shutdown();
		try {
			if (pool.awaitTermination(1, TimeUnit.MINUTES))
			{
				System.out.println("value = " + instance.getBalance());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}

class Atomic
{
	private final AtomicInteger balance = new AtomicInteger(0);
	
	public void increment()
	{
		int value = balance.get();
		if (!balance.compareAndSet(value, value + 1))
		{
			System.out.println("Balance is locked");
		}
	}
	
	public int getBalance()
	{
		return balance.get();
	}
	
}