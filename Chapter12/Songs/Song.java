public class Song
{
	private final String title;
	private final String artist;
	private final String genre;
	private final int year;
	private final int timesPlayed;	
	
	Song(String _title, String _artist, String _genre, int _year, int _timesPlayed)
	{
		title = _title;
		artist = _artist;
		genre = _genre;
		year = _year;
		timesPlayed = _timesPlayed;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public String getGenre()
	{
		return genre;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getTimesPlayed()
	{
		return timesPlayed;
	}
	
	public String toString()
	{
		return "{" + " \"" + title + "\", \"" + artist + "\", \"" + genre + "\", " + year + ", " + timesPlayed + " }";
	}
}