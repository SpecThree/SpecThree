import java.util.*;
import java.util.stream.*;

class PrintGenres
{
	public static void main(String[] args)
	{
		new Songs().getSongs().stream().map(Song::getGenre)
									   .sorted()
									   .distinct()
							  .forEach(genre -> System.out.println(genre));
	}
}