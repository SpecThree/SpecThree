import java.util.*;
import java.util.stream.*;

public class CoffeeOrder
{
	public static void main(String[] args)
	{
		List<String> coffees = List.of("Cappuchino", "Americano", "Espresso", "Cortado",
									   "Mocha", "Cappuchino", "Flat White", "Latte");
		List<String> coffeesEndingInO = coffees.stream()
											   .filter(s -> s.endsWith("o"))
											   .sorted()
											   .distinct()
											   .collect(Collectors.toList());
		System.out.println(coffeesEndingInO);
	}
}