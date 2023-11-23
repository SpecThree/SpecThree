import java.util.*;
import java.util.stream.*;

class PrintRockSongs
{
	public static void main(String[] args)
	{
		new Songs().getSongs().stream().filter(song -> song.getGenre()
														   .toLowerCase()
														   .contains("rock"))
														   .collect(Collectors.toList())
							  .forEach(song -> System.out.println(song));
	}
}