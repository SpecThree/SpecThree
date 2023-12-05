import java.util.concurrent.*;

public class LostUpdateSimple // "Lost Update" concurrency problem
{
	static int value = 0;
	
	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(6);
		for (int i = 0; i < 1000; i++)
		{
			pool.execute(()->{ value++; });
		}
		pool.shutdown();
		try {
			if (pool.awaitTermination(1, TimeUnit.MINUTES))
			{
				System.out.println("value = " + value);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}