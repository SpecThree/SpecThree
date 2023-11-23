import java.util.*;
import java.util.stream.*;

public class StreamPuzzle
{
	public static void main(String[] args)
	{
		SongSearch songSearch = new SongSearch();
		songSearch.printTopFiveSongs();
		songSearch.search("The Beatles");
		songSearch.search("The Beach Boys");
	}
}

class SongSearch
{
	private final List<Song> songs = new JukeboxData().songs().getSongs();
	
	void printTopFiveSongs()
	{
		List<String> topFive = songs.stream()
									.sorted(Comparator.comparingInt(Song::getTimesPlayed))
									.map(song -> song.getTitle())
									.limit(5)
									.collect(Collectors.toList());
		System.out.println(topFive);
	}
	
	void search(String artist)
	{
		Optional<Song> result = songs.stream()
									 .filter(song -> song.getArtist().equals(artist))
									 .findFirst();
		if (result.isPresent())
		{
			System.out.println(result.get().getTitle());
		}
		else
		{
			System.out.println("No songs found by: " + artist);
		}
	}
}

class JukeboxData
{
	Songs songs()
	{
		return new Songs();
	}
}

class Song
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

class Songs
{
	public List<Song> getSongs()
	{
		return List.of(
			new Song("$10", "HitchHicker", "Electronic", 2016, 183),
			new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
			new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
			new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
			new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
			new Song("Silence", "Delerium", "Electronic", 1999, 134),
			new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 192),
			new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
			new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 0204, 312),
			new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
			new Song("Come Together", "The Beatles", "Blues Rock", 1968, 173),
			new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
			new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
			new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
			new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
			new Song("What's Going On", "Gaye", "R&B", 1971, 420),
			new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
			new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
			new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
			new Song("Pasos de cero", "Pablo Aldoran", "Latin", 2014, 117),
			new Song("Smooth", "Santana", "Latin", 1999, 244),
			new Song("Immigrant Song", "Led Zeppelin", "Rock", 1970, 484));			
	}
}