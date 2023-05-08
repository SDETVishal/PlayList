package com.testvagrant.playlist;
import com.testvagrant.playlist.Playlist;

public class Test {
	
	public static void main(String args[])
	{
	Playlist store = new Playlist(3);
	store.addSong("Alice", "S1");
	store.addSong("Alice", "S2");
	store.addSong("Alice", "S3");
	System.out.println(store.getRecentSongs("Alice")); // prints ["S3", "S2", "S1"]
	store.addSong("Alice", "S4");
	System.out.println(store.getRecentSongs("Alice")); // prints ["S4", "S3", "S2"]
	store.addSong("Alice", "S2");
	System.out.println(store.getRecentSongs("Alice")); // prints ["S2", "S4", "S3"]
	store.addSong("Alice", "S1");
	System.out.println(store.getRecentSongs("Alice")); // prints ["S1", "S2", "S4"]

	}
	}
