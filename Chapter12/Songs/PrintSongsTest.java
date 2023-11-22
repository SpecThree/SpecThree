import java.util.*;

class PrintSongsTest
{
	public static void main(String[] args)
	{
		new Songs().getSongs().forEach(song -> System.out.println(song));
	}
}