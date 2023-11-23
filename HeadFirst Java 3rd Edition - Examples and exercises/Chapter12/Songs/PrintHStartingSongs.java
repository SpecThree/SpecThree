import java.util.*;
import java.util.stream.*;

class PrintHStartingSongs
{
	public static void main(String[] args)
	{
		new Songs().getSongs().stream().filter(song -> song.getTitle().substring(0, 1).equals("H"))
														   .collect(Collectors.toList())
							  .forEach(song -> System.out.println(song));
	}
}