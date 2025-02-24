package com.indus.training.core.svc;

public interface IPlaylist {
	public void addSongs(String[] newSongs);

	public void sortSongs();

	public String getSongs();

	public int getPlaylistArraySize();
}
