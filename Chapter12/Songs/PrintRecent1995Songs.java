import java.util.*;
import java.util.stream.*;

class PrintRecent1995Songs
{
	public static void main(String[] args)
	{
		new Songs().getSongs().stream().filter(song -> song.getYear() > 1995)
														   .collect(Collectors.toList())
							  .forEach(song -> System.out.println(song));
	}
}