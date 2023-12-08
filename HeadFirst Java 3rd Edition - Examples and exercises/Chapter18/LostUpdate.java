import java.util.concurrent.*;

public class LostUpdate
{
	public static void main(String[] args) // "Lost Update" concurrency problem
	{
		ExecutorService pool = Executors.newFixedThreadPool(6);
		Value instance = new Value();
		for (int i = 0; i < 1000; i++)
		{
			pool.execute(()->instance.increment());
		}
		pool.shutdown();
		try {
			if (pool.awaitTermination(1, TimeUnit.MINUTES))
			{
				System.out.println("value = " + instance.value);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}

class Value 
{
	int value = 0;
	
	public void increment()
	{
		value++;
	}
}