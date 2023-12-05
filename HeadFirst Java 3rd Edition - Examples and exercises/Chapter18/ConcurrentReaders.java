import java.util.*;
import java.util.concurrent.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;

public class ConcurrentReaders
{
	public static void main(String[] args)
	{
		List<Chat> chatHistory = new CopyOnWriteArrayList<>();
		// List<Chat> chatHistory = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++)
		{
			executor.execute(() -> chatHistory.add(new Chat("Hi there!")));
			executor.execute(() -> System.out.println(chatHistory));
			executor.execute(() -> System.out.println(chatHistory));
		}
		executor.shutdown();
	}
}

final class Chat
{
	private final String message;
	private final LocalDateTime timestamp;
	
	public Chat(String message)
	{
		this.message = message;
		timestamp = LocalDateTime.now();
	}
	
	public String toString()
	{
		String time = timestamp.format(DateTimeFormatter.ofLocalizedTime(MEDIUM));
		return time + " " + message;
	}
}