package com.testvagrant.playlist;
import java.util.*;
public class Playlist {	
		    private int capacity;
		    private Map<String, User> users; // mapping of user names to User objects

		    public Playlist(int capacity) {
		        this.capacity = capacity;
		        this.users = new HashMap<>();
		    }

		    public void addSong(String user, String song) {
		        User currentUser = users.computeIfAbsent(user, k -> new User(k, capacity)); // get or create User object
		        currentUser.addSong(song); // add song to User's recently played list
		    }

		    public List<String> getRecentSongs(String user) {
		        User currentUser = users.get(user);
		        if (currentUser == null) {
		            return Collections.emptyList();
		        }
		        return currentUser.getRecentSongs(); // return User's recently played list
		    }

		    private class User {
		        private String name;
		        private LinkedList<String> recentSongs;

		        public User(String name, int capacity) {
		            this.name = name;
		            this.recentSongs = new LinkedList<>();
		        }

		        public void addSong(String song) {
		            recentSongs.remove(song); // remove song if already present
		            recentSongs.addFirst(song); // add song to front
		            if (recentSongs.size() > capacity) {
		                recentSongs.removeLast(); // remove least recently played song
		            }
		        }

		        public List<String> getRecentSongs() {
		            return new ArrayList<>(recentSongs); // return copy of list
		        }
		    }
		}



