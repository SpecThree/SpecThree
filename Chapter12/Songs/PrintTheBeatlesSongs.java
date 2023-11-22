import java.util.*;
import java.util.stream.*;

class PrintTheBeatlesSongs
{
	public static void main(String[] args)
	{
		new Songs().getSongs().stream().filter(song -> song.getArtist()
														   .equals("The Beatles"))
														   .collect(Collectors.toList())
							  .forEach(song -> System.out.println(song));
	}
}